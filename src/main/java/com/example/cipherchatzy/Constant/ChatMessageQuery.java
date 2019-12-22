package com.example.cipherchatzy.Constant;



public interface ChatMessageQuery {
	
	public static final String CHAT_MESSAGE_ID = "SELECT C.CMS_ID,U.RUS_ID FROM \r\n"+
			"CHAT_MESSAGE C ,REGISTER_USER U \r\n" +
			" WHERE ( ( C.CMS_SENDER_ID =:chatMsgId AND C.CMS RECEIVER ID = U.RUS_ID) \r\n" +
			" OR (C.CMS_RECEIVER_ID =:chatMsgId AND C.CMS_SENDER_ID = U. RUS_ID)  \r\n" + " )\r\n"+
			"AND (C.CMS_SENDER_ID = : chatMsgId OR C.CMS_RECEIVER_ID = :chatMsgId)";
	
	
	public static final String CHAT_MESSAGE_REPLY_ID = "SELECT CR1.CMR_CHATMSG_ID, CR1.CREATED_AT \r\n"+
			",CR1.CMR_REPLY,CR1.RUS_NAME, CR1. RUS_EMAIL FROM (\r\n" +
			"SELECT CR.CMR_CHATMSG_ID ,CR.CMR_ID, CR.CREATED_AT ,CR.CMR_REPLY,U.RUS_NAME,U. RUS_EMAIL FROM"+
			"CHAT_MESSAGE_REPLY CR"+
			"CHAT MESSAGE C ,REGISTER_USER U \r\n"+
			"WHERE CR.CMR_CHATMSG_ID = :ChatId \r\n"+
			"AND C.CMS_ID =  CR.CMR_CHATMSG_ID \r\n"+
			"AND U. RUS_ID = :UserId \r\n" +
			"AND (  C.CMS_SENDER_ID =:UserId AND C.CMS_SENDER_ID = U.RUS_ID) \r\n"+
			"OR (C.CMS_RECEIVER_ID =:UserId AND C.CMS_RECEIVER ID = U. RUS_ID) \r\n"+
			"ORDER BY CR.CMR_ID DESC) CR1 \r\n"+
			"WHERE ROWNUM <2 ";			

}
