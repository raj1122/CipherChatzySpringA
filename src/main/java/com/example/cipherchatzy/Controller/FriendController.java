package com.example.cipherchatzy.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation. RequestBody;
import org.springframework.web.bind.annotation. RequestMapping;
import org.springframework.web.bind.annotation. RestController;

import com.example.cipherchatzy.Dto.FriendsRequestDto;
import com.example.cipherchatzy.Services.FRequestService;


@RestController
@RequestMapping("api/friends")
public class FriendController {

	@Autowired
	private FRequestService fRequestService;

	@PostMapping("/{semail}")
	public List<FriendsRequestDto> GetAl1Friend(@PathVariable(value = "semail") String semail) {
		return fRequestService.GetAl1Friends(semail);
	}

}
