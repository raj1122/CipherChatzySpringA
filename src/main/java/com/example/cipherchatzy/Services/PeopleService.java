package com.example.cipherchatzy.Services;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cipherchatzy.Dto.CMRNameDto;
import com.example.cipherchatzy.Exception.ResourceNotFoundException;
import com.example.cipherchatzy.Model.UserModel;
import com.example.cipherchatzy.Repository.UserRepository;
import com.example.cipherchatzy.ServicesInterface.PeopleInterface;


@Service
public class PeopleService implements PeopleInterface {

	
	
	@Autowired
	private UserRepository userRepo;

	public List<CMRNameDto> GetAllPeople(String email) {
		
		return userRepo.findByEmailNot(email).map(user -> {
			return user.stream().map(m -> UserToUserDto(m)).collect(Collectors.toList());
		}).orElseThrow(() -> new ResourceNotFoundException("No Friend found in Repository"));
		
		
	}

	private CMRNameDto UserToUserDto(UserModel post) {
		CMRNameDto postDto = new ModelMapper().map(post, CMRNameDto.class);
		return postDto;
	}

}
