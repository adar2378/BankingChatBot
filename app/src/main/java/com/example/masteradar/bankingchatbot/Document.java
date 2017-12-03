package com.example.masteradar.bankingchatbot;

/**
 * Created by Master Adar on 02-Dec-17.
 */

class Document {
    public String id, language, text;

    public Document(String id, String language, String text){
        this.id = id;
        this.language = language;
        this.text = text;
    }
}