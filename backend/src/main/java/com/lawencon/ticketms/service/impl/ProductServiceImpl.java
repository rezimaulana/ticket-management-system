package com.lawencon.ticketms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.ticketms.constant.ResponseConst;
import com.lawencon.ticketms.dao.ProductDao;
import com.lawencon.ticketms.dto.product.ProductDataDto;
import com.lawencon.ticketms.dto.product.ProductDeleteResDto;
import com.lawencon.ticketms.dto.product.ProductInsertDataResDto;
import com.lawencon.ticketms.dto.product.ProductInsertReqDto;
import com.lawencon.ticketms.dto.product.ProductInsertResDto;
import com.lawencon.ticketms.dto.product.ProductListResDto;
import com.lawencon.ticketms.dto.product.ProductResDto;
import com.lawencon.ticketms.dto.product.ProductUpdateDataResDto;
import com.lawencon.ticketms.dto.product.ProductUpdateReqDto;
import com.lawencon.ticketms.dto.product.ProductUpdateResDto;
import com.lawencon.ticketms.model.Product;
import com.lawencon.ticketms.service.PrincipalService;
import com.lawencon.ticketms.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	@Autowired
	private PrincipalService principalService;
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public ProductInsertResDto insert(final ProductInsertReqDto data)  {
		final Product product = new Product();
		product.setProductCode(data.getProductCode());
		product.setProductName(data.getProductName());
		product.setCreatedBy(principalService.getPrincipal().getId());
		
		final Product insertOne = productDao.insert(product);
		
		final ProductInsertDataResDto dto = new ProductInsertDataResDto();
		dto.setId(insertOne.getId());
		
		final ProductInsertResDto resDto = new ProductInsertResDto();
		resDto.setData(dto);
		resDto.setMessage(ResponseConst.CREATED.getResponse());
		return resDto;
	}
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public ProductUpdateResDto update(final ProductUpdateReqDto data)  {
		final Optional<Product> optional = productDao.getById(data.getId());
		Product updateOne = null;
		final ProductUpdateResDto resDto = new ProductUpdateResDto();
		if(optional.isPresent()) {
			updateOne = optional.get();
			updateOne.setProductName(data.getProductName());
			updateOne.setUpdatedBy(principalService.getPrincipal().getId());
			updateOne.setVer(data.getVer());
			updateOne.setIsActive(data.getIsActive());
			updateOne = productDao.update(updateOne);
			
			final ProductUpdateDataResDto dto = new ProductUpdateDataResDto();
			dto.setVer(updateOne.getVer());
			resDto.setData(dto);
			resDto.setMessage(ResponseConst.UPDATED.getResponse());
		}
		return resDto;
	}

	@Override
	public ProductResDto getById(final Long id)  {
		final Optional<Product> optional = productDao.getById(id);
		final Product product = optional.get();
		
		final ProductDataDto productDataDto = new ProductDataDto();
		productDataDto.setId(product.getId());
		productDataDto.setProductCode(product.getProductCode());
		productDataDto.setProductName(product.getProductName());
		productDataDto.setVer(product.getVer());
		productDataDto.setIsActive(product.getIsActive());
		
		final ProductResDto productResDto = new ProductResDto();
		productResDto.setData(productDataDto);
		
		return productResDto;
	}

	@Override
	public ProductListResDto getAll()  {
		final List<Product> products = productDao.getAll();
		final List<ProductDataDto> dataDto = new ArrayList<>();
		for (int i = 0; i<products.size(); i++) {
			final Product product = products.get(i);
			final ProductDataDto dto = new ProductDataDto();
			dto.setId(product.getId());
			dto.setProductCode(product.getProductCode());
			dto.setProductName(product.getProductName());
			dto.setVer(product.getVer());
			dto.setIsActive(product.getIsActive());
			dataDto.add(dto);
		}
		final ProductListResDto productListResDto = new ProductListResDto();
		productListResDto.setData(dataDto);
		return productListResDto;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public ProductDeleteResDto deleteById(final Long id)  {
		final Optional<Product> optional = productDao.getById(id);
		final ProductDeleteResDto resDto = new ProductDeleteResDto();
		if(optional.isPresent()) {
			productDao.deleteById(id);
			resDto.setMessage(ResponseConst.DELETED.getResponse());
		}
		return resDto;
	}

}
