/**
 * 
 */
package com.example.cipherchatzy.Repository;

import org.springframework.stereotype.Repository;

import com.example.cipherchatzy.Constant.ChatMessageQuery;
import com.example.cipherchatzy.Model.ChatModel;
import com.example.cipherchatzy.Model.ChatReplyModel;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/**
 * @author Raj Kumar
 *
 */

@Repository
public interface ChatReplyRepository extends JpaRepository<ChatReplyModel, Long> {
	
	ChatReplyModel findFirstByChatModelOrderByCreatedAtDesc(ChatModel chat);
	
	@Query (value = ChatMessageQuery.CHAT_MESSAGE_REPLY_ID, nativeQuery = true)	
	Object findCidReplyList(@Param("ChatId") Long ChatId, @Param("UserId") Long UserId);
	
	List<ChatReplyModel> findByChatModelIdOrderByIdAsc( Long Id);
	
	ChatReplyModel findTop1ByChatModelIdOrderByIdAsc( Long Id);
	
	ChatReplyModel findTop1ByChatModelIdOrderByIdDesc( Long Id);

}
