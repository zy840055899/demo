package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service("webSocketMessageService")
public class WSMessageService {
    private Logger logger = LoggerFactory.getLogger(WSMessageService.class);
    //声明websocket连接类
    private WebSocketChat webSocketChat = new WebSocketChat();

    /**
     * @param @param  userId 用户id
     * @param @param  message 消息
     * @param @return 发送成功返回true，否则返回false
     * @Title: sendToAllTerminal
     * @Description: 调用websocket类给用户下的所有终端发送消息
     */
    public Boolean sendToAllTerminal(String userId, String message) {
        logger.info("向用户{}的消息：{}", userId, message);
        if (webSocketChat.sendMessageToUser(userId, message)) {
            return true;
        } else {
            return false;
        }
    }
}