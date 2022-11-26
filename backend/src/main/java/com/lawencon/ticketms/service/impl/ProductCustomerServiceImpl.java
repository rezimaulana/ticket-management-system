package com.lawencon.ticketms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.ticketms.constant.ResponseConst;
import com.lawencon.ticketms.dao.ProductCustomerDao;
import com.lawencon.ticketms.dao.ProductDao;
import com.lawencon.ticketms.dao.UserDao;
import com.lawencon.ticketms.dto.productcustomer.ProductCustomerDataDto;
import com.lawencon.ticketms.dto.productcustomer.ProductCustomerDeleteResDto;
import com.lawencon.ticketms.dto.productcustomer.ProductCustomerInsertListReqDto;
import com.lawencon.ticketms.dto.productcustomer.ProductCustomerInsertResDto;
import com.lawencon.ticketms.dto.productcustomer.ProductCustomerListResDto;
import com.lawencon.ticketms.dto.productcustomer.ProductCustomerResDto;
import com.lawencon.ticketms.model.Product;
import com.lawencon.ticketms.model.ProductCustomer;
import com.lawencon.ticketms.model.User;
import com.lawencon.ticketms.service.PrincipalService;
import com.lawencon.ticketms.service.ProductCustomerService;

@Service
public class ProductCustomerServiceImpl implements ProductCustomerService{
	
	@Autowired
	private ProductCustomerDao productCustomerDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private PrincipalService principalService;
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public ProductCustomerInsertResDto insert(final ProductCustomerInsertListReqDto data)  {
		for (int i = 0; i < data.getData().size(); i++) {

			Optional<Product> product = productDao.getById(data.getData().get(i).getProductId());
			Optional<User> customer = userDao.getById(data.getData().get(i).getCustomerId());
			final ProductCustomer insertPC = new ProductCustomer();
			
			System.out.println(product.get().getId());
			System.out.println(customer.get().getId());
			
			final User insertCust = customer.get();
			final Product insertProduct = product.get();
			
			insertPC.setUser(insertCust);
			insertPC.setProduct(insertProduct);
			insertPC.setCreatedBy(principalService.getPrincipal().getId());
			productCustomerDao.insert(insertPC);
		}
		ProductCustomerInsertResDto productCustomerInsertResDto = new ProductCustomerInsertResDto();
		productCustomerInsertResDto.setMessage(ResponseConst.CREATED.toString());
		return productCustomerInsertResDto;
	}
		
	@Override
	public ProductCustomerResDto getById(final Long id) {
		final Optional<ProductCustomer> optional = productCustomerDao.getById(id);
		final ProductCustomer productCustomer = optional.get();
		
		final ProductCustomerDataDto productCustomerDataDto = new ProductCustomerDataDto();
		productCustomerDataDto.setId(productCustomer.getId());
		productCustomerDataDto.setCustomerId(productCustomer.getId());
		productCustomerDataDto.setCustomerEmail(productCustomer.getUser().getEmail());
		productCustomerDataDto.setCustomerName(productCustomer.getUser().getFullname());
		productCustomerDataDto.setProductId(productCustomer.getId());
		productCustomerDataDto.setProductCode(productCustomer.getProduct().getProductCode());
		productCustomerDataDto.setProductName(productCustomer.getProduct().getProductName());
		productCustomerDataDto.setVer(productCustomer.getVer());
		productCustomerDataDto.setIsActive(productCustomer.getIsActive());
		
		final ProductCustomerResDto productCustomerResDto = new ProductCustomerResDto();
		productCustomerResDto.setData(productCustomerDataDto);
		
		return productCustomerResDto;
	}
	
	@Override
	public ProductCustomerListResDto getAll()  {
		final List<ProductCustomer> products = productCustomerDao.getAll();
		final List<ProductCustomerDataDto> dataDto = new ArrayList<>();
		for (int i = 0; i<products.size(); i++) {
			final ProductCustomer product = products.get(i);
			final ProductCustomerDataDto dto = new ProductCustomerDataDto();
			dto.setId(product.getId());
			dto.setCustomerId(product.getUser().getId());
			dto.setCustomerEmail(product.getUser().getEmail());
			dto.setCustomerName(product.getUser().getFullname());
			dto.setProductId(product.getProduct().getId());
			dto.setProductCode(product.getProduct().getProductCode());
			dto.setProductName(product.getProduct().getProductName());
			dto.setVer(product.getVer());
			dto.setIsActive(product.getIsActive());
			dataDto.add(dto);
		}
		final ProductCustomerListResDto resDto = new ProductCustomerListResDto();
		resDto.setData(dataDto);
		return resDto;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public ProductCustomerDeleteResDto deleteById(final Long id) {
		final Optional<ProductCustomer> optional = productCustomerDao.getById(id);
		final ProductCustomerDeleteResDto resDto = new ProductCustomerDeleteResDto();
		if(optional.isPresent()) {
			productCustomerDao.deleteById(id);
			resDto.setMessage(ResponseConst.DELETED.getResponse());
		}
		return resDto;
	}

	@Override
	public ProductCustomerListResDto getAllIdCust(final Long id){
		final List<ProductCustomer> products = productCustomerDao.getAllIdCust(id);
		final List<ProductCustomerDataDto> dataDto = new ArrayList<>();
		for (int i = 0; i<products.size(); i++) {
			final ProductCustomer product = products.get(i);
			final ProductCustomerDataDto dto = new ProductCustomerDataDto();
			dto.setId(product.getId());
			dto.setCustomerId(product.getUser().getId());
			dto.setCustomerEmail(product.getUser().getEmail());
			dto.setCustomerName(product.getUser().getFullname());
			dto.setProductId(product.getProduct().getId());
			dto.setProductCode(product.getProduct().getProductCode());
			dto.setProductName(product.getProduct().getProductName());
			dto.setVer(product.getVer());
			dto.setIsActive(product.getIsActive());
			dataDto.add(dto);
		}
		final ProductCustomerListResDto resDto = new ProductCustomerListResDto();
		resDto.setData(dataDto);
		return resDto;
	}

}