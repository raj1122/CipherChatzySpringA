/**
 * 
 */
package com.example.cipherchatzy.ServicesInterface;

import java.util.List;
import java.util.Optional;

import com.example.cipherchatzy.Dto.FRequestDto;
import com.example.cipherchatzy.Model.FRequestModel;

/**
 * @author Raj Kumar
 *
 */
public interface FriendRequestInterface {

	List<FRequestDto> getFRequestByEmail(String emai1);

	Optional<FRequestModel> DeleteFriendRequestByEmail(String semail1, String remail);

	FRequestModel AcceptFriendRequestByEmail(String semail, String remail);
}
