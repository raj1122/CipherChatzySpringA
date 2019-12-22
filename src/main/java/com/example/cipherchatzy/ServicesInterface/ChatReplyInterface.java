/**
 * 
 */
package com.example.cipherchatzy.ServicesInterface;

import java.util.List;
import java.util.Optional;

import com.example.cipherchatzy.Dto.CMRMainDto;
import com.example.cipherchatzy.Dto.ChatReplyReqDto;
import com.example.cipherchatzy.Model.ChatModel;
import com.example.cipherchatzy.Model.ChatReplyModel;

/**
 * @author Raj Kumar
 *
 */
public interface ChatReplyInterface {

	ChatReplyModel InsertChatReply(ChatReplyModel chats);

	List<CMRMainDto> searchChatDetailsById(Long id);

	List<ChatReplyModel> searchChatDetailsById1(Long id);

	CMRMainDto InsertReplyConversation(ChatReplyReqDto chatsReplyDetails);

	ChatReplyModel InsertReply(ChatModel conversation, ChatReplyModel chats);

}
