package com.example.masteradar.bankingchatbot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Master Adar on 02-Dec-17.
 */

class Documents {
    public List<Document> documents;

    public Documents() {
        this.documents = new ArrayList<Document>();
    }
    public void add(String id, String language, String text) {
        this.documents.add (new Document (id, language, text));
    }
}