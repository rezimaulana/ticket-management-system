package com.lawencon.ticketms.dao.impl.hibernate.springdatanativequery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.constant.RoleConst;
import com.lawencon.ticketms.dao.UserDao;
import com.lawencon.ticketms.model.Company;
import com.lawencon.ticketms.model.File;
import com.lawencon.ticketms.model.Role;
import com.lawencon.ticketms.model.User;
import com.lawencon.ticketms.repository.nativequery.UserRepositoryNative;

@Repository
@Profile("datanative")
public class UserDaoImpl extends BaseDaoImpl implements UserDao{
	
	@Autowired
	private UserRepositoryNative repository;
	
	@Override
	public User insert(final User data)  {
		return repository.save(data);
	}

	@Override
	public User update(final User data)  {
		return repository.saveAndFlush(data);
	}

	@Override
	public Optional<User> getById(final Long id)  {
		final User user = this.em.find(User.class, id);
		em.detach(user);
		final Optional<User> userOptional = Optional.ofNullable(user);
		return userOptional;
	}

	@Override
	public List<User> getAll()  {
		return repository.findAll();
	}

	@Override
	public boolean deleteById(final Long id)  {
		final int result = repository.removeById(id);
		return result > 0;
	}

	@Override
	public Optional<User> getByEmail(final String email)  {		
		final User user = repository.getByEmail(email);
		final Optional<User> userOptional = Optional.ofNullable(user);
		return userOptional;
	}

	@Override
	public List<User> getAllIdCust()  {
		final List<?> result = repository.getAllIdCust(RoleConst.CUST.getRoleCodeEnum());
		final List<User> users =  new ArrayList<>();
		if(result != null && result.size() > 0) {
			result.forEach(userObj -> {
				Object[] objArr = (Object[]) userObj;
				final User user = new User();
				user.setId(Long.valueOf(objArr[0].toString()));
				user.setEmail(objArr[1].toString());
				user.setFullname(objArr[2].toString());
				user.setVer(Integer.valueOf(objArr[15].toString()));
				final User pic = new User();
				pic.setId(Long.valueOf(objArr[3].toString()));
				pic.setEmail(objArr[4].toString());
				pic.setFullname(objArr[5].toString());
				user.setPicId(pic);
				final Company company = new Company();
				company.setId(Long.valueOf(objArr[6].toString()));
				company.setCompanyCode(objArr[7].toString());
				company.setCompanyName(objArr[8].toString());
				user.setCompany(company);
				final Role role = new Role();
				role.setId(Long.valueOf(objArr[9].toString()));
				role.setRoleCode(objArr[10].toString());
				role.setRoleName(objArr[11].toString());
				user.setRole(role);
				if(objArr[12] != null) {
					final File file = new File();
					file.setId(Long.valueOf(objArr[12].toString()));
					file.setFileCode(objArr[13].toString());
					file.setFileExt(objArr[14].toString());
					user.setFile(file);
				}
				users.add(user);
			});
		}
		return users;
	}

	@Override
	public List<User> getAllIdPic() {
		final List<?> result = repository.getAllIdPic( RoleConst.PIC.getRoleCodeEnum());
		final List<User> users =  new ArrayList<>();
		if(result != null && result.size() > 0) {
			result.forEach(userObj -> {
				Object[] objArr = (Object[]) userObj;
				final User user = new User();
				user.setId(Long.valueOf(objArr[0].toString()));
				user.setEmail(objArr[1].toString());
				user.setFullname(objArr[2].toString());
				final Role role = new Role();
				role.setId(Long.valueOf(objArr[3].toString()));
				role.setRoleCode(objArr[4].toString());
				role.setRoleName(objArr[5].toString());
				user.setRole(role);
				users.add(user);
			});
		}
		return users;
	}
	
	@Override
	public 	List<User> getAllIdPicIdCust(long id) {
		final List<?> result = repository.getAllIdPicIdCust(id);
		final List<User> users =  new ArrayList<>();
		if(result != null && result.size() > 0) {
			result.forEach(userObj -> {
				Object[] objArr = (Object[]) userObj;
				final User user = new User();
				user.setId(Long.valueOf(objArr[0].toString()));
				user.setEmail(objArr[1].toString());
				user.setFullname(objArr[2].toString());
				user.setVer(Integer.valueOf(objArr[15].toString()));
				final User pic = new User();
				pic.setId(Long.valueOf(objArr[3].toString()));
				pic.setEmail(objArr[4].toString());
				pic.setFullname(objArr[5].toString());
				user.setPicId(pic);
				final Company company = new Company();
				company.setId(Long.valueOf(objArr[6].toString()));
				company.setCompanyCode(objArr[7].toString());
				company.setCompanyName(objArr[8].toString());
				user.setCompany(company);
				final Role role = new Role();
				role.setId(Long.valueOf(objArr[9].toString()));
				role.setRoleCode(objArr[10].toString());
				role.setRoleName(objArr[11].toString());
				user.setRole(role);
				if(objArr[12] != null) {
					final File file = new File();
					file.setId(Long.valueOf(objArr[12].toString()));
					file.setFileCode(objArr[13].toString());
					file.setFileExt(objArr[14].toString());
					user.setFile(file);
				}
				users.add(user);
			});
		}
		return users;
	}

}
