/**
 * 
 */
package com.example.cipherchatzy.Services;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cipherchatzy.Dto.CMRMainDto;
import com.example.cipherchatzy.Dto.FstChatReciveDto;
import com.example.cipherchatzy.Dto.FstChatReqDto;
import com.example.cipherchatzy.Model.ChatModel;
import com.example.cipherchatzy.Model.ChatReplyModel;
import com.example.cipherchatzy.Model.UserModel;
import com.example.cipherchatzy.Repository.ChatReplyRepository;
import com.example.cipherchatzy.Repository.ChatRepository;
import com.example.cipherchatzy.Repository.UserRepository;
import com.example.cipherchatzy.ServicesInterface.ChatInterface;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Raj Kumar
 *
 */

@Service
public class ChatServices implements ChatInterface {

	@Autowired
	ChatRepository chatRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	private ChatReplyRepository chatReplyRepo;

	@Override
	public ChatModel InsertChat(ChatModel chats) {
		return chatRepository.save(chats);
	}

	@Override
	public ChatReplyModel FstInsertChatReply(ChatReplyModel chats) {
		return chatReplyRepo.save(chats);
	}

	@Override
	public List<ChatReplyModel> SearchChatMainByUser(String email) {
		
		UserModel user = userRepository.findByEmail(email);
		
		List<ChatModel> allChats = chatRepository.findByReceiverUserModelOrSenderUserModel(user, user);
		
		List<ChatReplyModel> mainchatReply = allChats.stream().map(chatModel -> {
			return chatReplyRepo.findTop1ByChatModelIdOrderByIdAsc(chatModel.getId());
		}).collect(Collectors.toList());
		return mainchatReply;
	}

	public List<CMRMainDto> SearchChatDetailByUser(String remail) {
		UserModel user = userRepository.findByEmail(remail);
		return null;
	}

	// TODO Auto-generated method stub
	private CMRMainDto ChatMainToCMRDto(ChatModel chatModel) {
		ModelMapper modelMapper = new ModelMapper();
		CMRMainDto postDto = modelMapper.map(chatModel, CMRMainDto.class);
		return postDto;
	}

	@Override
	public List<ChatModel> SearchChatByUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override	
	public FstChatReciveDto InsertFirstchat(FstChatReqDto chatsDetails) {
		UserModel SendUser = userRepository.findByEmail(chatsDetails.getSemail());

		if (SendUser == null) {
			return null;
		}

		UserModel RecvUser = userRepository.findByEmail(chatsDetails.getRemail());
		if (RecvUser == null)
			return null;

		ChatModel checkMsgExist = chatRepository
				.findBySenderUserModelAndReceiverUserModelOrReceiverUserModelAndSenderUserModel
				(SendUser, RecvUser, SendUser,  RecvUser);
		
		if (checkMsgExist != null) {
			return null;
		}

		ChatReplyModel insertChatReply = new ChatReplyModel(chatsDetails.getReply(), chatsDetails.getSemail(),
				SendUser);
		
		ChatModel chatMsg = new ChatModel(chatsDetails.getSemail(), chatsDetails.getRemail(), SendUser, RecvUser,
				new HashSet<ChatReplyModel>(Arrays.asList(insertChatReply)));
		ChatModel convertTofstDto = InsertChat(chatMsg);

		return FirstChatReqDto(convertTofstDto);
	}

	private FstChatReciveDto FirstChatReqDto(ChatModel ChatModel) {
		ModelMapper modelMapper = new ModelMapper();
		FstChatReciveDto postDto = modelMapper.map(ChatModel, FstChatReciveDto.class);
		return postDto;
	}



	@Override
	public List<ChatModel> SearchChatByUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
