/**
 * 
 */
package com.example.cipherchatzy.Services;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cipherchatzy.Dto.PhotoRequestDto;
import com.example.cipherchatzy.Exception.ResourceNotFoundException;
import com.example.cipherchatzy.Model.PhotosModel;
import com.example.cipherchatzy.Model.UserModel;
import com.example.cipherchatzy.Repository.PhotosRepository;
import com.example.cipherchatzy.Repository.UserRepository;
import com.example.cipherchatzy.ServicesInterface.PhotosInterface;


/**
 * @author Raj Kumar
 *
 */

@Service
public class PhotoServices implements PhotosInterface {
	

	@Autowired
	private PhotosRepository photoRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public PhotoRequestDto addPhotos(PhotoRequestDto photoRequestDto) {
		Optional<UserModel> userFromRepo0pt = userRepo.findById(photoRequestDto.getUserId());
		if ( !userFromRepo0pt.isPresent())
		{
			System.out.println("Value not found - ");
			return null;
		}
		else
		{
			PhotosModel convertPhotoEntity = ConvertDtoToPhoto(photoRequestDto);

			PhotosModel photoFromRepo = photoRepo.save(convertPhotoEntity);
			return ConvertPhotoToDto(photoFromRepo);
		}
		
	
	
	}
	
	@Override
	public List<PhotoRequestDto> GetAllPhotosById(Long id) {
		Optional<UserModel> userFromRepoOpt  = userRepo.findById(id);
		if (userFromRepoOpt.isPresent()) {
			// value is present inside Optional
			System.out.println("Value found - " + userFromRepoOpt.get());
		} 
		else {
		// value is absent
			System.out.println("Optional is empty");
			return null;	
		}
		UserModel userFromRepo = userFromRepoOpt.get();
		return photoRepo.findByUserModel(userFromRepo).map(allPhotosList -> {
			return allPhotosList.stream().map(m -> ConvertPhotoToDto(m)).collect(Collectors.toList());
		}).orElseThrow(() -> new ResourceNotFoundException("No Photos found for " + id + " not found"));
	
		
	}
	
	
	private PhotoRequestDto ConvertPhotoToDto(PhotosModel photoModel) {
		ModelMapper modelMapper = new ModelMapper ();
		return modelMapper.map (photoModel, PhotoRequestDto.class);
	}
	
	@Override
	public boolean DeletePhotosById(Long userId, Long photoId) {
		
		Optional<UserModel> userFromRepo0pt = this.userRepo.findById(userId);
		if (!userFromRepo0pt.isPresent ()) {
			// value is absent
			System.out.println("No userId found for given User");
			return false;
		}
		Optional<PhotosModel> photoFromRepoOpt = this.photoRepo.findById(photoId);
		if (!photoFromRepoOpt.isPresent()) {
		// value is absent
			System.out.println("No Photos Found for id");
			return false;
		}
		this.photoRepo.deleteById(photoId);
		return true;
	}
	
	private PhotosModel ConvertDtoToPhoto(PhotoRequestDto photoRequestDto) {
		Optional<UserModel> userFromRepoOpt = userRepo.findById(photoRequestDto.getUserId());
		if ( userFromRepoOpt.isPresent()) {
			// value is present inside Optional
			System.out.println("Value not found - ");
			return null;
		}
			UserModel userFromRepo =  userFromRepoOpt.get();
			PhotosModel photoFromRepo = modelMapper.map(photoRequestDto, PhotosModel.class);
			photoFromRepo.setUserModel(userFromRepo);
			return photoFromRepo;
		}

}
