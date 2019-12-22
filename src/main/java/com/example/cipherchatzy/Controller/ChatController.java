package com.example.cipherchatzy.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cipherchatzy.Dto.CMRMainDto;
import com.example.cipherchatzy.Dto.ChatReplyReqDto;
import com.example.cipherchatzy.Dto.FstChatReciveDto;
import com.example.cipherchatzy.Dto.FstChatReqDto;
import com.example.cipherchatzy.Model.ChatReplyModel;
import com.example.cipherchatzy.Services.ChatReplyServices;
import com.example.cipherchatzy.Services.ChatServices;

@RestController
@RequestMapping("api/chat")
public class ChatController {

	@Autowired
	ChatServices chatServices;

	@Autowired
	ChatReplyServices chatRepServices;

	@PostMapping("insertFstChat")
	public FstChatReciveDto InsertFirstchat(@Valid @RequestBody FstChatReqDto chatsDetails) {

		return chatServices.InsertFirstchat(chatsDetails);
	}

	@PostMapping("insertChatReply")
	public CMRMainDto InsertChatReply(@Valid @RequestBody ChatReplyReqDto chatsReplyDetails) {
		return chatRepServices.InsertReplyConversation(chatsReplyDetails);
	}

	@PostMapping("searchChat/{email}")
	public List<ChatReplyModel> searchChatMainByEmail(@PathVariable("email") String email) {
		// List<ChatModel> allChatsList = chatServices.SearchChatByUser(email);
		return chatServices.SearchChatMainByUser(email);
	}

	@PostMapping("searchChatDetails/{id}")
	public List<CMRMainDto> searchChatDetailsById(@PathVariable("id") Long id) {
		return chatRepServices.searchChatDetailsById(id);
	}

	
}
