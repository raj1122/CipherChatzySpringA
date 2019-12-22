package com.example.cipherchatzy.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.cloudfoundry.AccessLevel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cipherchatzy.Dto.FRequestDto;
import com.example.cipherchatzy.Model.FRequestModel;
import com.example.cipherchatzy.Services.FRequestService;

import org.hibernate.annotations.UpdateTimestamp;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import java.lang.reflect.Type;

@RestController
@RequestMapping("api/friendRequest")
public class FRequestController {

	@Autowired
	private FRequestService fRequestService;

	@GetMapping("/{email}")
	public List<FRequestDto> getFRequestByEmail(@PathVariable("email") String email) {
		return fRequestService.getFRequestByEmail(email);
	}

	@PostMapping("/{semail}")
	public FRequestModel createFRequest(@PathVariable(value = "semail") String email,
			@Valid @RequestBody FRequestModel fRequestModel) {
		return fRequestService.createFriendRequest(email, fRequestModel);
	}

	@DeleteMapping("delete/{remail}/{semail}")
	public Optional<FRequestModel> deleteFrequest(@PathVariable(value = "semail") String semail,
			@PathVariable(value = "remail") String remail) {
		return fRequestService.DeleteFriendRequestByEmail(semail, remail);
	}

	@PutMapping("accept/{remail}/{semail}")
	public FRequestModel AceeptFrequest(@PathVariable(value = "semail") String semail,
			@PathVariable(value = "remail") String remail) {
		return fRequestService.AcceptFriendRequestByEmail(semail, remail);
	}








}
