package com.lawencon.ticketms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.ticketms.constant.ResponseConst;
import com.lawencon.ticketms.dao.CompanyDao;
import com.lawencon.ticketms.dao.FileDao;
import com.lawencon.ticketms.dto.company.CompanyDataDto;
import com.lawencon.ticketms.dto.company.CompanyDeleteResDto;
import com.lawencon.ticketms.dto.company.CompanyInsertDataResDto;
import com.lawencon.ticketms.dto.company.CompanyInsertReqDto;
import com.lawencon.ticketms.dto.company.CompanyInsertResDto;
import com.lawencon.ticketms.dto.company.CompanyListResDto;
import com.lawencon.ticketms.dto.company.CompanyResDto;
import com.lawencon.ticketms.dto.company.CompanyUpdateDataResDto;
import com.lawencon.ticketms.dto.company.CompanyUpdateReqDto;
import com.lawencon.ticketms.dto.company.CompanyUpdateResDto;
import com.lawencon.ticketms.model.Company;
import com.lawencon.ticketms.model.File;
import com.lawencon.ticketms.service.CompanyService;
import com.lawencon.ticketms.service.PrincipalService;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private FileDao fileDao;
	@Autowired
	private PrincipalService principalService;
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public CompanyInsertResDto insert(final CompanyInsertReqDto data)  {
		final Company company = new Company();
		company.setCompanyCode(data.getCompanyCode());
		company.setCompanyName(data.getCompanyName());
		company.setCompanyAddress(data.getCompanyAddress());
		
		final File file = new File();
		if(data.getFileCode() != null) {
			file.setFileCode(data.getFileCode());
			file.setFileExt(data.getFileExt());
			file.setCreatedBy(principalService.getPrincipal().getId());
			final File insertFile = fileDao.insert(file);			
			company.setFile(insertFile);
		}
		company.setCreatedBy(principalService.getPrincipal().getId());
		
		final Company insertOne = companyDao.insert(company);
		
		final CompanyInsertDataResDto dto = new CompanyInsertDataResDto();
		dto.setId(insertOne.getId());
		
		final CompanyInsertResDto resDto = new CompanyInsertResDto();
		resDto.setData(dto);
		resDto.setMessage(ResponseConst.CREATED.getResponse());
		return resDto;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public CompanyUpdateResDto update(final CompanyUpdateReqDto data)  {
		final Optional<Company> optional = companyDao.getById(data.getId());
		Company updateOne = null;
		final CompanyUpdateResDto resDto = new CompanyUpdateResDto();
		if(optional.isPresent()) {
			updateOne = optional.get();
			updateOne.setCompanyName(data.getCompanyName());
			updateOne.setCompanyAddress(data.getCompanyAddress());
			
			updateOne.setUpdatedBy(principalService.getPrincipal().getId());
			updateOne.setVer(data.getVer());
			updateOne.setIsActive(data.getIsActive());
			
			if(data.getFileCode()!=null) {
				final File file = new File();
				file.setFileCode(data.getFileCode());
				file.setFileExt(data.getFileExt());
				file.setCreatedBy(principalService.getPrincipal().getId());
				final File insertFile = fileDao.insert(file);
				updateOne.setFile(insertFile);
			} 
			
			updateOne = companyDao.update(updateOne);				
			
			final CompanyUpdateDataResDto dto = new CompanyUpdateDataResDto();
			dto.setVer(updateOne.getVer());
			resDto.setData(dto);
			resDto.setMessage(ResponseConst.UPDATED.getResponse());
		}
		return resDto;
	}
	
	@Override
	public CompanyResDto getById(final Long id)  {
		final Optional<Company> optional = companyDao.getById(id);
		final Company company = optional.get();
		
		final CompanyDataDto companyDataDto = new CompanyDataDto();
		companyDataDto.setId(company.getId());
		companyDataDto.setCompanyCode(company.getCompanyCode());
		companyDataDto.setCompanyName(company.getCompanyName());
		companyDataDto.setCompanyAddress(company.getCompanyAddress());
		if(company.getFile() != null) {
			companyDataDto.setFileId(company.getFile().getId());
			companyDataDto.setFileCode(company.getFile().getFileCode());
			companyDataDto.setFileExt(company.getFile().getFileExt());			
		}
		companyDataDto.setVer(company.getVer());
		companyDataDto.setIsActive(company.getIsActive());
		
		final CompanyResDto companyResDto = new CompanyResDto();
		companyResDto.setData(companyDataDto);
		
		return companyResDto;
	}

	@Override
	public CompanyListResDto getAll()  {
		final List<Company> companies = companyDao.getAll();
		final List<CompanyDataDto> dataDto = new ArrayList<>();
		for (int i = 0; i<companies.size(); i++) {
			final Company company = companies.get(i);
			final CompanyDataDto dto = new CompanyDataDto();
			dto.setId(company.getId());
			dto.setCompanyCode(company.getCompanyCode());
			dto.setCompanyName(company.getCompanyName());
			dto.setCompanyAddress(company.getCompanyAddress());
			if(company.getFile() != null) {
				dto.setFileId(company.getFile().getId());
				dto.setFileCode(company.getFile().getFileCode());
				dto.setFileExt(company.getFile().getFileExt());				
			}
			dto.setVer(company.getVer());
			dto.setIsActive(company.getIsActive());
			dataDto.add(dto);
		}
		final CompanyListResDto companyListResDto = new CompanyListResDto();
		companyListResDto.setData(dataDto);
		return companyListResDto;
	}
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public CompanyDeleteResDto deleteById(final Long id)  {
		final Optional<Company> optional = companyDao.getById(id);
//		final Optional <File> file = fileDao.getById(optional.get().getFile().getId());
		final CompanyDeleteResDto resDto = new CompanyDeleteResDto();
		if(optional.isPresent()) {
			companyDao.deleteById(id);
//			fileDao.deleteById(file.get().getId());
			resDto.setMessage(ResponseConst.DELETED.getResponse());
		}
		return resDto;
	}

}
