package com.example.masteradar.bankingchatbot;

/**
 * Created by Master Adar on 30-Nov-17.
 */

public class ChatBot {
    public String message;
    public boolean isSend;

    public ChatBot(String message, boolean isSend) {
        this.message = message;
        this.isSend = isSend;
    }
    public ChatBot(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }
}
