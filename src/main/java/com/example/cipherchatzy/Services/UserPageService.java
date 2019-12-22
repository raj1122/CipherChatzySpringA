package com.example.cipherchatzy.Services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.cipherchatzy.Dto.UserReturnDto;
import com.example.cipherchatzy.Model.UserModel;
import com.example.cipherchatzy.Repository.UserPagingRepo;

@Service
public class UserPageService {

	@Autowired
	UserPagingRepo userPageRepo;

	public List<UserReturnDto> getAllPeople(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<UserModel> pagedResult = userPageRepo.findAll(paging);
		if (pagedResult.hasContent()) {
			final Page<UserReturnDto> userDtoPage = pagedResult.map(this::convertToUsertDto);
			return userDtoPage.getContent();
		} else {
			return new ArrayList<UserReturnDto>();
		}
	}

	private UserReturnDto convertToUsertDto(final UserModel user) {
		final UserReturnDto userDto = new ModelMapper(). map(user, UserReturnDto.class);
	return userDto;

		
	}

}
