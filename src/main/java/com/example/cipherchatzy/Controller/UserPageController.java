package com.example.cipherchatzy.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cipherchatzy.Dto.UserReturnDto;
import com.example.cipherchatzy.Services.UserPageService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/userPage")
public class UserPageController {
	@Autowired
	UserPageService userPageService;

	@GetMapping
	public ResponseEntity<List<UserReturnDto>> getAllEmployees(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) 
	{
		List<UserReturnDto> list = userPageService.getAllPeople(pageNo, pageSize, sortBy);
		return new ResponseEntity<List<UserReturnDto>>(list, new HttpHeaders(), HttpStatus.OK);

	}

}
