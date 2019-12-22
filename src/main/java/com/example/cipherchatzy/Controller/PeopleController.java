package com.example.cipherchatzy.Controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cipherchatzy.Dto.CMRNameDto;
import com.example.cipherchatzy.Dto.PeopleRequestDto;
import com.example.cipherchatzy.Services.PeopleService;

@RestController
@RequestMapping("api/people")
public class PeopleController {

	@Autowired
	private PeopleService PeopleServices;

	@PostMapping("getPeople")
	public List<CMRNameDto> GetAllPeoples (@Valid @RequestBody PeopleRequestDto peopleDto) {
	return PeopleServices.GetAllPeople(peopleDto.getEmail());
	}


}
