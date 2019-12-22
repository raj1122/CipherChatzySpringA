package com.example.cipherchatzy.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.cipherchatzy.Dto.FRequestDto;
import com.example.cipherchatzy.Dto.FriendsRequestDto;
import com.example.cipherchatzy.Exception.ResourceNotFoundException;
import com.example.cipherchatzy.Model.FRequestModel;
import com.example.cipherchatzy.Model.UserModel;
import com.example.cipherchatzy.Repository.FRequestReposiotry;
import com.example.cipherchatzy.Repository.UserRepository;
import com.example.cipherchatzy.ServicesInterface.FriendRequestInterface;

import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FRequestService implements FriendRequestInterface {

	@Autowired
	private FRequestReposiotry freqReposiotry;

	@Autowired
	private UserRepository userRepository;

	public List<FriendsRequestDto> GetAl1Friends(String semail) {

		return freqReposiotry.findByStatusUserAndSemailOrStatusUserAndRemail("ACCEPT", semail, "ACCEPT", semail)
				.map(frequest -> {
					return frequest.stream().map(m -> ChangeFRequestToDto(m)).collect(Collectors.toList());
				}).orElseThrow(() -> new ResourceNotFoundException("No Friend found for " + semail + " not found"));
	}

	@Override
	public List<FRequestDto> getFRequestByEmail(String email) {

		List<FRequestModel> FriendReqList = freqReposiotry.findBySemail(email);

		return FriendReqList.stream().map(m -> convertToDto(m)).collect(Collectors.toList());

	}

	public FRequestModel createFriendRequest(String semail, FRequestModel fRequestModel) {

		UserModel usr = userRepository.findByEmail(semail);

		return userRepository.findById(usr.getId()).map(user -> {
			fRequestModel.setSenderUserModel(user);
			return freqReposiotry.save(fRequestModel);
		}).orElseThrow(() -> new ResourceNotFoundException("PostId " + semail + "not found"));
	}

	@Override
	public Optional<FRequestModel> DeleteFriendRequestByEmail(String semail, String remail) {
		return freqReposiotry.deleteBySemailAndRemail(semail, remail);
	}

	@Override
	public FRequestModel AcceptFriendRequestByEmail(String semail, String remail) {

		return freqReposiotry.findBySemailAndRemail(semail, remail).map(frequest -> {
			frequest.setStatusUser("ACCEPT");
			return freqReposiotry.save(frequest);
		}).orElseThrow(() -> new ResourceNotFoundException("PostId " + semail + "not found"));

	}

	private FriendsRequestDto ChangeFRequestToDto(FRequestModel frequest) {
		ModelMapper modelMapper = new ModelMapper();
		FriendsRequestDto postDto = modelMapper.map(frequest, FriendsRequestDto.class);
		return postDto;
	}

	private FRequestDto convertToDto(FRequestModel post) {
		FRequestDto postDto = new ModelMapper().map(post, FRequestDto.class);
		return postDto;
	}

}
