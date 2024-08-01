package io.deeplay.camp.handlers.commands;

import entity.GameSession;
import entity.SessionMessage;
import io.deeplay.camp.handlers.MainHandler;
import io.deeplay.camp.managers.SessionManager;
import io.deeplay.camp.repository.CommandHandler;

import java.io.IOException;
import java.sql.SQLException;

public class SessionChatCommandHandler implements CommandHandler  {

    @Override
    public void handle(String message, MainHandler mainHandler) throws IOException, SQLException, InterruptedException {
        String[] parts = message.split(MainHandler.splitRegex, 2);
        
        SessionManager.getInstance().sendSessionMessage(mainHandler, parts[1]);
        var sessionChat = mainHandler.getSession().getSessionChat();

        StringBuilder sb = new StringBuilder();
        for (SessionMessage messageChat : sessionChat) {
            sb.append(messageChat.getUsername()).append("::").append(messageChat.getMsg());
        }
        
        mainHandler.sendMessageToClient("session-chat::" + sb.toString());
        SessionManager.getInstance().sendMessageToOpponent(mainHandler, mainHandler.getSession(), "session-chat::" + sb.toString());
    }
}