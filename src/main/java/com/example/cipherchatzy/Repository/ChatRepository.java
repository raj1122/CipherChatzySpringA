/**
 * 
 */
package com.example.cipherchatzy.Repository;

import org.springframework.stereotype.Repository;

import com.example.cipherchatzy.Constant.ChatMessageQuery;
import com.example.cipherchatzy.Model.ChatModel;
import com.example.cipherchatzy.Model.UserModel;

import java.util.List;
import org.springframework.data.jpa.repository. JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/**
 * @author Raj Kumar
 *
 */

@Repository
public interface ChatRepository extends JpaRepository<ChatModel, Long> {
	
	List<ChatModel> findByReceiverUserModelOrSenderUserModel(UserModel suser1, UserModel suser2);
	
	ChatModel findBySenderUserModelAndReceiverUserModelOrReceiverUserModelAndSenderUserModel(UserModel suser1, UserModel
	ruser1, UserModel renduser2, UserModel secvUser2);
	
	@Query (value = ChatMessageQuery.CHAT_MESSAGE_ID, nativeQuery = true)
	List<Object[]> findCidName (@Param("chatMsgId") Long id);

}
