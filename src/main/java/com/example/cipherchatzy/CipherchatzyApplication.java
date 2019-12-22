package com.example.cipherchatzy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.HashSet;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.cipherchatzy.Model.ChatModel;
import com.example.cipherchatzy.Model.ChatReplyModel;
import com.example.cipherchatzy.Model.FRequestModel;
import com.example.cipherchatzy.Model.PhoneNumberModel;
import com.example.cipherchatzy.Model.PhotosModel;
import com.example.cipherchatzy.Model.TimeLineModel;
import com.example.cipherchatzy.Model.UserModel;
import com.example.cipherchatzy.Repository.ChatReplyRepository;
import com.example.cipherchatzy.Repository.ChatRepository;
import com.example.cipherchatzy.Repository.FRequestReposiotry;
import com.example.cipherchatzy.Repository.PhoneNumberRepository;
import com.example.cipherchatzy.Repository.TimelineRepository;
import com.example.cipherchatzy.Repository.UserRepository;
import com.example.cipherchatzy.Services.ChatReplyServices;
import com.example.cipherchatzy.Services.ChatServices;
import com.example.cipherchatzy.Services.PhotoServices;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@PropertySource("classpath:application.properties")
@EnableJpaAuditing
@SpringBootApplication
public class CipherchatzyApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PhoneNumberRepository numberRepository;

	@Autowired
	TimelineRepository timelineRepository;

	@Autowired
	FRequestReposiotry fRequestReposiotry;

	@Autowired
	ChatRepository chatRepository;

	@Autowired
	ChatServices chatServices;

	@Autowired
	ChatReplyServices chatReplyServices;

	@Autowired
	PhotoServices photoService;

	@Autowired
	ChatReplyRepository chatReplyRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	public static void main(String[] args) {
		SpringApplication.run(CipherchatzyApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		clearData();
		saveData();
	}

	private void clearData() {
		

		userRepository.deleteAll();
		numberRepository.deleteAll();
		timelineRepository.deleteAll();
	
		chatRepository.deleteAllInBatch();
		chatReplyRepo.deleteAllInBatch();
	}

	private void saveData() {
	UserModel rajat = new UserModel("rajat", "rajat@gmail.com", bcryptEncoder.encode ("123456"));
	
	UserModel paritosh = new UserModel( "paritosh", "pari@gmail.com", bcryptEncoder.encode ("123456"));
	
	UserModel sompa = new UserModel("Som Mangalam", "som@gmail.com", bcryptEncoder.encode ("123456"));
	
	PhoneNumberModel iphone7 = new PhoneNumberModel(799, rajat);
	PhoneNumberModel iPadPro = new PhoneNumberModel(899, rajat);
	
	PhoneNumberModel galaxyJ7 = new PhoneNumberModel(111, paritosh);
	PhoneNumberModel galaxyTabA = new PhoneNumberModel (222, paritosh);
	
	PhoneNumberModel galaxy71 = new PhoneNumberModel(111, sompa);	
	PhoneNumberModel galaxyTabAI = new PhoneNumberModel(222, sompa);
	
	
	HashSet<PhoneNumberModel> rajatPhone = new HashSet<PhoneNumberModel>();
	rajatPhone.add(iphone7);
	rajatPhone.add(iPadPro);
	
	HashSet<PhoneNumberModel> paritoshPhone = new HashSet<PhoneNumberModel>();
	paritoshPhone.add(galaxyJ7);
	paritoshPhone.add(galaxyTabA);
	

	rajat.setAllPhoneNumbers(rajatPhone);
	
	paritosh.setAllPhoneNumbers(paritoshPhone);
	
	userRepository.save(rajat);
	userRepository.save(paritosh);
	userRepository.save(sompa);
	
	UserModel rajatTable = userRepository.findByEmail("rajat@gmail.com");	
	UserModel pariTable = userRepository.findByEmail("pari@gmail.com");
	UserModel somTable = userRepository.findByEmail("som@gmail.com");
	
	TimeLineModel timelineModel = new TimeLineModel("Txt", "rajat@gmail.com",rajatTable);
	TimeLineModel timelineModell = new TimeLineModel("Txt", "pariegmail@com" ,pariTable);
	
	timelineRepository.save(timelineModel);
	timelineRepository.save(timelineModell);
	
	
	
	FRequestModel fRequestModel = new FRequestModel ("rajat@gmail.com", "Pari@gmail.com", "ACCEPT",rajatTable, pariTable);
	fRequestReposiotry.save(fRequestModel);
	
	FRequestModel fRequestModel1 = new FRequestModel( "som@gmail.com" ,"rajat@gmail.com", "No", somTable, rajatTable);
	fRequestReposiotry.save(fRequestModel1);
	
	
	ChatReplyModel chatReply1 = new ChatReplyModel("Firest Testing", "rajat@gmail.com", rajatTable);
	ChatReplyModel chatReply2 = new ChatReplyModel("Second Testing", "pari@gmail.com", pariTable);
	ChatModel chatMsg1 = new ChatModel("rajat@gmail.com", "pari@gmail.com", rajatTable, pariTable);
	
	 HashSet<ChatReplyModel> rajatChatReply = new HashSet<ChatReplyModel>();
	 rajatChatReply.add(chatReply1);
	 rajatChatReply.add(chatReply2);	 
	 chatMsg1.setTags(rajatChatReply);
	
	ChatModel chatMsg2 = new ChatModel("som@gmail.com", "rajat@gmail.com" , rajatTable, somTable );
	
	ChatReplyModel chatReply3 = new ChatReplyModel("Hi", "rajat@gmail.com" , rajatTable);
	ChatReplyModel chatReply4 = new ChatReplyModel("Hello", "som@gmail.com" , somTable);
	ChatReplyModel chatReply5 = new ChatReplyModel("Yes", "som@gmail.com" , somTable);
	
	
	HashSet<ChatReplyModel> chatMsg2Reply = new HashSet<ChatReplyModel>();
	chatMsg2Reply.add(chatReply3);
	chatMsg2Reply.add(chatReply4);
	chatMsg2Reply.add(chatReply5);
	
	chatMsg2.setTags(chatMsg2Reply);


	
	chatRepository.save(chatMsg2);
	
	ChatModel FstMsg1 = chatRepository.save(chatMsg1);
	ChatReplyModel chatReply6 = new ChatReplyModel ("Third Testing", "pari@gnail.com", pariTable );
	
	FstMsg1.getTags().add(chatReply6);
	chatReply6.getChatModel().add(FstMsg1);

	chatRepository.save(FstMsg1);
	PhotosModel photol =	new PhotosModel("fist photo", "jtttp:sndjbd", false, rajatTable);
	
	chatReplyServices.InsertChatReply(chatReply5);
	chatServices.InsertChat (chatMsg1);
	
	
	chatServices.InsertChat (chatMsg2);
	
	chatReplyServices.InsertChatReply(chatReply1);
	chatReplyServices.InsertChatReply(chatReply2);
	chatReplyServices.InsertChatReply (chatReply3);
	
	
	}
		

}
