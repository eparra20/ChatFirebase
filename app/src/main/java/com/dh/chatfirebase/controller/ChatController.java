package com.dh.chatfirebase.controller;

import com.dh.chatfirebase.dao.ChatDao;
import com.dh.chatfirebase.model.Chat;
import com.dh.chatfirebase.util.ResultListener;

import java.util.List;

public class ChatController {

    private ChatDao chatDao;

    public ChatController() {

        this.chatDao = new ChatDao();
    }

    public void getChats(ResultListener<List<Chat>> listenerDelaView){
        List<Chat> chats = chatDao.getChats();
        listenerDelaView.onFinish(chats);
    }
}
