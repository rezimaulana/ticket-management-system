package com.lawencon.ticketms.service;

import com.lawencon.ticketms.dto.company.CompanyDeleteResDto;
import com.lawencon.ticketms.dto.company.CompanyInsertReqDto;
import com.lawencon.ticketms.dto.company.CompanyInsertResDto;
import com.lawencon.ticketms.dto.company.CompanyListResDto;
import com.lawencon.ticketms.dto.company.CompanyResDto;
import com.lawencon.ticketms.dto.company.CompanyUpdateReqDto;
import com.lawencon.ticketms.dto.company.CompanyUpdateResDto;

public interface CompanyService{
	
	CompanyInsertResDto insert(CompanyInsertReqDto data);
	CompanyUpdateResDto update(CompanyUpdateReqDto data);
	CompanyResDto getById(Long id);
	CompanyListResDto getAll();
	CompanyDeleteResDto deleteById(Long id);
	
}
