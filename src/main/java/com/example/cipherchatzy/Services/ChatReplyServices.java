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

import com.example.cipherchatzy.Dto.CMRMainDto;
import com.example.cipherchatzy.Dto.ChatReplyReqDto;
import com.example.cipherchatzy.Model.ChatModel;
import com.example.cipherchatzy.Model.ChatReplyModel;
import com.example.cipherchatzy.Model.UserModel;
import com.example.cipherchatzy.Repository.ChatReplyRepository;
import com.example.cipherchatzy.Repository.ChatRepository;
import com.example.cipherchatzy.Repository.UserRepository;
import com.example.cipherchatzy.ServicesInterface.ChatReplyInterface;

/**
 * @author Raj Kumar
 *
 */

@Service
public class ChatReplyServices  implements ChatReplyInterface {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ChatRepository chatRepo;
	
	@Autowired
	private ChatReplyRepository chatReplyRepo;
	
	@Override
	public CMRMainDto InsertReplyConversation(ChatReplyReqDto chatsReplyDetails) {
		UserModel Senduser = userRepo.findByEmail(chatsReplyDetails.getSemail());
		Optional<ChatModel> convoOpt =		chatRepo.findById(chatsReplyDetails.getId());
		if (convoOpt.isPresent()) {
			// value is present inside Optional
			System.out.println("Value found -" + convoOpt.get() );
			}
		else
		{
			// value is absent
			System.out.println("Optional is empty");
			return null;
		}
		ChatModel conversation = convoOpt.get();
		ChatReplyModel converstaionReply = new ChatReplyModel(chatsReplyDetails.getReply() ,chatsReplyDetails.getSemail(), Senduser);
		
		converstaionReply.getChatModel().add(conversation);
		conversation.getTags().add(converstaionReply);
		ChatReplyModel returnConverstaion = InsertReply (conversation, converstaionReply);
		
		return ChatMainToCMRDto(returnConverstaion);
		
	}
	@Override
	public ChatReplyModel InsertReply (ChatModel conversation, ChatReplyModel convReply)
	{
		conversation.setUpdatedAt(convReply.getCreatedAt());
		ChatModel result = chatRepo.save(conversation);
		ChatReplyModel convReplyFromRepo = chatReplyRepo.findTop1ByChatModelIdOrderByIdDesc(result.getId());
		return convReplyFromRepo;
	}
	
	@Override
	public ChatReplyModel InsertChatReply(ChatReplyModel chats) {
		return chatReplyRepo.save(chats);
	}
	
	@Override
	public List<CMRMainDto> searchChatDetailsById(Long id) {
		List<ChatReplyModel> allChatsDetails = chatReplyRepo.findByChatModelIdOrderByIdAsc(id);
		return allChatsDetails.stream().map(m -> ChatMainToCMRDto(m)).collect(Collectors.toList());
	}
	
	@Override
	public List<ChatReplyModel> searchChatDetailsById1 (Long id) {
		
		List<ChatReplyModel> allChatsDetails = chatReplyRepo.findByChatModelIdOrderByIdAsc (id);
		return allChatsDetails;
	}
	
	private CMRMainDto ChatMainToCMRDto(ChatReplyModel ChatRModel) {
		ModelMapper modelMapper = new ModelMapper ();
		CMRMainDto postDto = modelMapper.map(ChatRModel, CMRMainDto.class);
		return postDto;
	}


	


 
}
