/**
 * 
 */
package com.example.cipherchatzy.ServicesInterface;

import java.util.List;

import com.example.cipherchatzy.Dto.PhotoRequestDto;

/**
 * @author Raj Kumar
 *
 */
public interface PhotosInterface {

	public PhotoRequestDto addPhotos(PhotoRequestDto photoRequestDto);

	public List<PhotoRequestDto> GetAllPhotosById(Long id);

	public boolean DeletePhotosById(Long userId, Long photoId);

}
