package com.stackroute.chattingservice.service;


import java.util.HashSet;
import java.util.List;

import com.stackroute.chattingservice.exceptions.ChatAlreadyExistException;
import com.stackroute.chattingservice.exceptions.ChatNotFoundException;
import com.stackroute.chattingservice.exceptions.NoChatExistsInTheRepository;
import com.stackroute.chattingservice.model.Chat;
import com.stackroute.chattingservice.model.Message;

public interface ChatService {

    public Chat addChat(Chat chat) throws ChatAlreadyExistException;

    List<Chat> findallchats() throws NoChatExistsInTheRepository;

    Chat getById(int id)  throws ChatNotFoundException;

    HashSet<Chat> getChatByFirstUserName(String username)  throws ChatNotFoundException;

    HashSet<Chat> getChatBySecondUserName(String username)  throws ChatNotFoundException;

    HashSet<Chat> getChatByFirstUserNameOrSecondUserName(String username)  throws ChatNotFoundException;

    HashSet<Chat> getChatByFirstUserNameAndSecondUserName(String firstUserName, String secondUserName)  throws ChatNotFoundException;

    Chat addMessage(Message add, int chatId)  throws ChatNotFoundException;
}

