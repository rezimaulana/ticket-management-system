package com.lawencon.ticketms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.ticketms.dto.user.UserDeleteResDto;
import com.lawencon.ticketms.dto.user.UserInsertReqDto;
import com.lawencon.ticketms.dto.user.UserInsertResDto;
import com.lawencon.ticketms.dto.user.UserListResDto;
import com.lawencon.ticketms.dto.user.UserResDto;
import com.lawencon.ticketms.dto.user.UserUpdateReqDto;
import com.lawencon.ticketms.dto.user.UserUpdateResDto;
import com.lawencon.ticketms.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserInsertResDto> insert(@RequestBody UserInsertReqDto data){
		final UserInsertResDto result = userService.insert(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<UserUpdateResDto> update(@RequestBody UserUpdateReqDto data){
		final UserUpdateResDto result = userService.update(data);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<UserResDto> getById(@PathVariable("id") Long id){
		final UserResDto result = userService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<UserDeleteResDto> delete(@PathVariable("id") Long id) {
		final UserDeleteResDto result = userService.deleteById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<UserListResDto> getAll(){
		final UserListResDto result = userService.getAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("customer")
	public ResponseEntity<UserListResDto> getAllIdCust() {
		final UserListResDto result = userService.getAllIdCust();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("pic")
	public ResponseEntity<UserListResDto> getAllIdPic() {
		final UserListResDto result = userService.getAllIdPic();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("pic/{id}/customer")
	public ResponseEntity<UserListResDto> getAllIdPicIdCust(@PathVariable("id") Long id) {
		final UserListResDto result = userService.getAllIdPicIdCust(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
