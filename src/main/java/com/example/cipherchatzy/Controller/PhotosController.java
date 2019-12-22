package com.example.cipherchatzy.Controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cipherchatzy.Dto.PhotoRequestDto;
import com.example.cipherchatzy.Services.PhotoServices;

@RestController
@RequestMapping("api/user/{userId}/photo/")
public class PhotosController {

	@Autowired
	PhotoServices photoServices;

	@PostMapping()
	public PhotoRequestDto AddPhotos(@PathVariable("userId") Long userId,
			@Valid @RequestBody PhotoRequestDto photoRequestDto) {
		return photoServices.addPhotos(photoRequestDto);
	}

	@GetMapping()
	public PhotoRequestDto GetAl1Photos(@PathVariable("userId") int userId) {
		return null;
	}

	@DeleteMapping("{photoId}")
	public boolean DeletePhotoById(@PathVariable("userId") Long userId, @PathVariable("photoId") Long photoId) {
		return photoServices.DeletePhotosById(userId, photoId);
	}

}
