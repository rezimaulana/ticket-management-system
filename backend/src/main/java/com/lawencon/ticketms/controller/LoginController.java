package com.lawencon.ticketms.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.ticketms.dto.login.LoginReqDto;
import com.lawencon.ticketms.dto.login.LoginResDto;
import com.lawencon.ticketms.model.User;
import com.lawencon.ticketms.service.JwtService;
import com.lawencon.ticketms.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<LoginResDto> login(@RequestBody LoginReqDto data) {
		Authentication auth = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword());
		authManager.authenticate(auth);
		final Optional<User> user = userService.getByEmail(data.getEmail());
		Map<String, Object> claims = new HashMap<>();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.HOUR_OF_DAY, 1);
		
		claims.put("exp", calendar.getTime());
		claims.put("id", user.get().getId());
		claims.put("roleCode", user.get().getRole().getRoleCode());
		
		LoginResDto dto = new LoginResDto();
		dto.setId(user.get().getId());
		dto.setFullname(user.get().getFullname());
		dto.setRoleCode(user.get().getRole().getRoleCode());
		dto.setToken(jwtService.generateJwt(claims));
		return new ResponseEntity<LoginResDto>(dto, HttpStatus.OK);
	}
	
}
