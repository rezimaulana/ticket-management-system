package com.lawencon.ticketms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lawencon.ticketms.constant.ResponseConst;
import com.lawencon.ticketms.dao.CompanyDao;
import com.lawencon.ticketms.dao.FileDao;
import com.lawencon.ticketms.dao.RoleDao;
import com.lawencon.ticketms.dao.UserDao;
import com.lawencon.ticketms.dto.user.UserDataDto;
import com.lawencon.ticketms.dto.user.UserDeleteResDto;
import com.lawencon.ticketms.dto.user.UserInsertDataResDto;
import com.lawencon.ticketms.dto.user.UserInsertReqDto;
import com.lawencon.ticketms.dto.user.UserInsertResDto;
import com.lawencon.ticketms.dto.user.UserListResDto;
import com.lawencon.ticketms.dto.user.UserResDto;
import com.lawencon.ticketms.dto.user.UserUpdateDataResDto;
import com.lawencon.ticketms.dto.user.UserUpdateReqDto;
import com.lawencon.ticketms.dto.user.UserUpdateResDto;
import com.lawencon.ticketms.model.Company;
import com.lawencon.ticketms.model.File;
import com.lawencon.ticketms.model.Role;
import com.lawencon.ticketms.model.User;
import com.lawencon.ticketms.pojo.SendEmailPojo;
import com.lawencon.ticketms.service.GenerateCodeService;
import com.lawencon.ticketms.service.JavaMailService;
import com.lawencon.ticketms.service.PrincipalService;
import com.lawencon.ticketms.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordEncoder passwordEncode;
	@Autowired
	private GenerateCodeService generateCodeService;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private FileDao fileDao;
	@Autowired
	private JavaMailService mailService;
	@Autowired
	private PrincipalService principalService;
//	private long systemId = 1l;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optional = userDao.getByEmail(username);
		if(optional.isPresent()) {
			return new org.springframework.security.core.userdetails.User(username, optional.get().getPassword(), new ArrayList<>());
		}
		throw new UsernameNotFoundException("Wrong Email or Password");
	}
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public UserInsertResDto insert(UserInsertReqDto data)  {
		final User user= new User();
		user.setEmail(data.getEmail());
		user.setFullname(data.getFullname());
		
		final String plainText = generateCodeService.generateDigit();
		final String hash = passwordEncode.encode(plainText);
		user.setPassword(hash);
		
		final Optional<Role> role = roleDao.getById(data.getRoleId());
		user.setRole(role.get());
		
		if(data.getPicId() != null) {
			final Optional<User> pic = userDao.getById(data.getPicId());
			user.setPicId(pic.get());			
		}
		
		if(data.getCompanyId() != null) {
			final Optional<Company> comp = companyDao.getById(data.getCompanyId());
			user.setCompany(comp.get());
		}
		
		if(data.getFileCode() != null) {
			final File file = new File();
			file.setFileCode(data.getFileCode());
			file.setFileExt(data.getFileExt());
//			file.setCreatedBy(systemId);
			file.setCreatedBy(principalService.getPrincipal().getId());
			final File insertFile = fileDao.insert(file);
			user.setFile(insertFile);
		}
		
//		user.setCreatedBy(systemId);
		user.setCreatedBy(principalService.getPrincipal().getId());
		final User insertOne = userDao.insert(user);
		final UserInsertDataResDto dto = new UserInsertDataResDto();
		dto.setId(insertOne.getId());
		
		final SendEmailPojo emailPojo = new SendEmailPojo();
        emailPojo.setEmail(data.getEmail());
        emailPojo.setSubject("Registrasi Anda Berhasil");
        emailPojo.setBody("Email : "+data.getEmail()+"\nPassword anda : " + plainText);

        Runnable r = () -> mailService.sendEmail(emailPojo);
		Thread t = new Thread(r);
		t.start();
        
		final UserInsertResDto resDto = new UserInsertResDto();
		resDto.setData(dto);
		resDto.setMessage(ResponseConst.CREATED.getResponse());
		return resDto;
		
	}

	@Override
	public Optional<User> getByEmail(final String email)  {
		return userDao.getByEmail(email);
	}

	@Override
	public UserListResDto getAll(){
		final List<User> users = userDao.getAll();
		final List<UserDataDto> dataDto = new ArrayList<>();
		for (int i = 0; i<users.size(); i++) {
			final User user = users.get(i);
			final UserDataDto dto = new UserDataDto();
			dto.setId(user.getId());
			dto.setEmail(user.getEmail());
			dto.setFullname(user.getFullname());
			if(user.getPicId() != null) {
				dto.setPicId(user.getPicId().getId());
				dto.setPicEmail(user.getPicId().getEmail());
				dto.setPicName(user.getPicId().getFullname());				
			}
			if(user.getCompany() != null) {
				dto.setCompanyId(user.getCompany().getId());
				dto.setCompanyCode(user.getCompany().getCompanyCode());
				dto.setCompanyName(user.getCompany().getCompanyName());				
			}
			dto.setRoleId(user.getRole().getId());
			dto.setRoleCode(user.getRole().getRoleCode());
			dto.setRoleName(user.getRole().getRoleName());
			if(user.getFile() != null) {
				dto.setFileId(user.getFile().getId());
				dto.setFileCode(user.getFile().getFileCode());
				dto.setFileExt(user.getFile().getFileExt());
			}
			dto.setIsActive(user.getIsActive());
			dto.setVer(user.getVer());
			dataDto.add(dto);
		}
		final UserListResDto userListResDto = new UserListResDto();
		userListResDto.setData(dataDto);
		return userListResDto;
	}
	
	@Override
	public UserListResDto getAllIdCust(){
		final List<User> users = userDao.getAllIdCust();
		final List<UserDataDto> dataDto = new ArrayList<>();
		for (int i = 0; i<users.size(); i++) {
			final User user = users.get(i);
			final UserDataDto dto = new UserDataDto();
			dto.setId(user.getId());
			dto.setEmail(user.getEmail());
			dto.setFullname(user.getFullname());
			dto.setPicEmail(user.getPicId().getEmail());
			dto.setPicName(user.getPicId().getFullname());
			dto.setCompanyCode(user.getCompany().getCompanyCode());
			dto.setCompanyName(user.getCompany().getCompanyName());
			dto.setRoleCode(user.getRole().getRoleCode());
			dto.setRoleName(user.getRole().getRoleName());
			if(user.getFile() != null) {
				dto.setFileCode(user.getFile().getFileCode());
				dto.setFileExt(user.getFile().getFileExt());
			}
			dto.setVer(user.getVer());
			dataDto.add(dto);
		}
		final UserListResDto userListResDto = new UserListResDto();
		userListResDto.setData(dataDto);
		return userListResDto;
	}

	@Override
	public UserListResDto getAllIdPic() {
		final List<User> users = userDao.getAllIdPic();
		final List<UserDataDto> dataDto = new ArrayList<>();
		for (int i = 0; i<users.size(); i++) {
			final User user = users.get(i);
			final UserDataDto dto = new UserDataDto();
			dto.setId(user.getId());
			dto.setEmail(user.getEmail());
			dto.setFullname(user.getFullname());
			dto.setRoleCode(user.getRole().getRoleCode());
			dto.setRoleName(user.getRole().getRoleName());
			if(user.getFile() != null) {
				dto.setFileCode(user.getFile().getFileCode());
				dto.setFileExt(user.getFile().getFileExt());
			}
			dto.setVer(user.getVer());
			dataDto.add(dto);
		}
		final UserListResDto userListResDto = new UserListResDto();
		userListResDto.setData(dataDto);
		return userListResDto;
	}
	
	@Override
	public UserListResDto getAllIdPicIdCust(long id)  {
		final List<User> users = userDao.getAllIdPicIdCust(id);
		final List<UserDataDto> dataDto = new ArrayList<>();
		for (int i = 0; i<users.size(); i++) {
			final User user = users.get(i);
			final UserDataDto dto = new UserDataDto();
			dto.setId(user.getId());
			dto.setEmail(user.getEmail());
			dto.setFullname(user.getFullname());
			dto.setPicEmail(user.getPicId().getEmail());
			dto.setPicName(user.getPicId().getFullname());
			dto.setCompanyCode(user.getCompany().getCompanyCode());
			dto.setCompanyName(user.getCompany().getCompanyName());
			dto.setRoleCode(user.getRole().getRoleCode());
			dto.setRoleName(user.getRole().getRoleName());
			if(user.getFile() != null) {
				dto.setFileCode(user.getFile().getFileCode());
				dto.setFileExt(user.getFile().getFileExt());
			}
			dto.setVer(user.getVer());
			dto.setIsActive(user.getIsActive());
			dataDto.add(dto);
		}
		final UserListResDto userListResDto = new UserListResDto();
		userListResDto.setData(dataDto);
		return userListResDto;
	}

	@Override
	public UserResDto getById(Long id) {
		final Optional<User> optional = userDao.getById(id);
		final User user = optional.get();
		final UserDataDto dto = new UserDataDto();
		dto.setId(user.getId());
		dto.setEmail(user.getEmail());
		dto.setFullname(user.getFullname());
		if(user.getPicId() != null) {
			dto.setPicId(user.getPicId().getId());
			dto.setPicEmail(user.getPicId().getEmail());
			dto.setPicName(user.getPicId().getFullname());
		}
		if(user.getCompany() != null) {
			dto.setCompanyId(user.getCompany().getId());
			dto.setCompanyCode(user.getCompany().getCompanyCode());
			dto.setCompanyName(user.getCompany().getCompanyName());			
		}
		if(user.getFile() != null) {
			dto.setFileId(user.getFile().getId());
			dto.setFileCode(user.getFile().getFileCode());
			dto.setFileExt(user.getFile().getFileExt());
		}
		dto.setRoleId(user.getRole().getId());
		dto.setRoleCode(user.getRole().getRoleCode());
		dto.setRoleName(user.getRole().getRoleName());
		dto.setVer(user.getVer());
		dto.setIsActive(user.getIsActive());
		
		final UserResDto userResDto = new UserResDto();
		userResDto.setData(dto);
		
		return userResDto;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public UserUpdateResDto update(UserUpdateReqDto data) {
		final Optional<User> optional = userDao.getById(data.getId());
		User updateOne = null;
		final UserUpdateResDto resDto = new UserUpdateResDto();
		if(optional.isPresent()) {
			updateOne = optional.get();
			
			if(data.getPassword()!= null) {
				if(passwordEncode.matches(data.getOldPassword(), updateOne.getPassword())) {
					final String plainText = data.getPassword();
					final String hash = passwordEncode.encode(plainText);
					updateOne.setPassword(hash);									
				} else {
					throw new RuntimeException("Password lama anda tidak sama");
				}
			}
			
			updateOne.setId(data.getId());
			updateOne.setEmail(data.getEmail());
			updateOne.setFullname(data.getFullname());
			updateOne.setIsActive(data.getIsActive());
			
			final Optional<Role> role = roleDao.getById(data.getRoleId());
			updateOne.setRole(role.get());
			updateOne.setUpdatedBy(principalService.getPrincipal().getId());
			updateOne.setVer(data.getVer());
			
			if(data.getFileCode() != null) {
				final File file = new File();
				file.setFileCode(data.getFileCode());
				file.setFileExt(data.getFileExt());
				file.setCreatedBy(principalService.getPrincipal().getId());
				final File insertFile = fileDao.insert(file);
				updateOne.setFile(insertFile);
			}
			
			updateOne = userDao.update(updateOne);
			
			final UserUpdateDataResDto dto = new UserUpdateDataResDto();
			dto.setVer(updateOne.getVer());
			resDto.setData(dto);
			resDto.setMessage(ResponseConst.UPDATED.getResponse());
		}
		return resDto;
	}
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public UserDeleteResDto deleteById(Long id) {
		final Optional<User> optional = userDao.getById(id);
		final UserDeleteResDto resDto = new UserDeleteResDto();
		if(optional.isPresent()) {
			userDao.deleteById(id);
			resDto.setMessage(ResponseConst.DELETED.getResponse());
		}
		return resDto;
	}

}