package com.example.masteradar.bankingchatbot;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Master Adar on 16-Dec-17.
 */

public class ReplyGenerator {
    List<String> list;

    Double score;
    String text;
    public ReplyGenerator(String text,List<String> list, Double score) {
        this.text = text;
        this.list = list;
        this.score = score;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String generate(){
        Log.d("gem", "generate: here");
        String reply = "";
        String[] words=text.split(" ");
        Log.d("word",""+words[0]);
        reply= reply+greetingDetector1(words)+greetingDetector2(words)+contextDetector(words)+farewellDetector(words);
        if (reply.length() == 0) {
            reply = "How may i help you?";
        }
        return reply;
    }


    private String greetingDetector1(String[] words){
        List<String> greetings = new ArrayList<>();
        greetings.add("Hi");
        greetings.add("Hello");

        greetings.add("hi");
        greetings.add("hello");

        for (int i = 0 ;i<words.length;i++){

               for (int ii = 0; ii< greetings.size();ii++){
                   Log.d("tag8", "greetingDetector1: "+"\b"+words[i].contains(greetings.get(ii))+"\b" );
                   if (words[i].contains(greetings.get(ii))){
                        return "Hello. ";
                   }


               }
        }
        return "";

    }
    private String greetingDetector2(String[] words){
        List<String> greetings = new ArrayList<>();
        greetings.add("How are you");
        greetings.add("how are you");
        greetings.add("what's up");

        for (int i = 0 ;i<words.length;i++){

            for (int ii = 0; ii< greetings.size();ii++){
                Log.d("tag8", "greetingDetector2: "+words[i].contains(greetings.get(ii)) );
                if (text.contains(greetings.get(ii))){
                    return "I'm doing great. How about you? ";
                }


            }
        }
        return "";

    }

    private String farewellDetector(String[] words){
        List<String> greetings = new ArrayList<>();
        greetings.add("bye");
        for (int i = 0 ;i<words.length;i++){

            for (int ii = 0; ii< greetings.size();ii++){
                Log.d("tag8", "greetingDetector2: "+words[i].contains(greetings.get(ii)) );
                if (text.contains(greetings.get(ii))){
                    return "Goodbye. Have a nice day. ";
                }


            }
        }
        return "";

    }
    private String contextDetector(String[] words){
        String s = "";
        for (int i = 0; i< list.size();i++){
            if (list.get(i).toLowerCase().contains("card")||list.get(i).toLowerCase().contains("lost card")||list.get(i).toLowerCase().contains("lost credit card")){
                if(score<.1){
                    s+= "You need to verify information on our website and Your Replacement ATM or " +
                            "Debit Card will be sent to your mailing address on file in 5 to 7 business days. If your address has changed," +
                            " please contact an Advisor at 01710222555 prior to requesting a replacement ATM/Debit Card.";
                }
            }
            if(list.get(i).toLowerCase().contains("card")||list.get(i).toLowerCase().contains("new card")||list.get(i).toLowerCase().contains("new credit card")){
                    if(score>.5){
                        s+=  "For new credit card you will need to apply for it first." +
                                " You can apply online(if you have online account)or goto bank and verify information.";
                    }
            }
            if(list.get(i).toLowerCase().contains("account")||list.get(i).toLowerCase().contains("new account")||list.get(i).toLowerCase().contains("bank account")){
                    if(score>.15){
                        s+=  "you can open a new account from your nearest branches.\n" +
                                "You will have to bring 2 copies of passport size photographs" +
                                " with a photocopy of your NID or Driving license or Birth Certificate";
                    }
            }
            if (list.get(i).toLowerCase().contains("bill")){
                    s+= "You can pay electricity bills and gas bills.";
            }


        }
        if(text.contains("Who are you")||text.contains("who are you")){
            s+= "I'm a banking chatbot of XYZ Bank. How may a help you?";
        }

        return s;
    }
}
