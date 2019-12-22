/**
 * 
 */
package com.example.cipherchatzy.ServicesInterface;


import java.util.List;
import com.example.cipherchatzy.Dto.FstChatReciveDto;
import com.example.cipherchatzy.Dto.FstChatReqDto;
import com.example.cipherchatzy.Model.ChatModel;
import com.example.cipherchatzy.Model.ChatReplyModel;

/**
 * @author Raj Kumar
 *
 */
public interface ChatInterface {
	
	ChatModel InsertChat (ChatModel chats);
	
	List<ChatModel> SearchChatByUser (String email);
	
	List<ChatReplyModel> SearchChatMainByUser (String email);
	
	List<ChatModel> SearchChatByUser (Long id);
	
	FstChatReciveDto InsertFirstchat(FstChatReqDto chatsDetails);
	
	ChatReplyModel FstInsertChatReply(ChatReplyModel chats);

}
