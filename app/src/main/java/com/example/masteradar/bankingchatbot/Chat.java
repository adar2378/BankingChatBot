package com.example.masteradar.bankingchatbot;

import android.nfc.Tag;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
/*import android.util.Log;

import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.http.ServiceCallback;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;*/


import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.masteradar.bankingchatbot.DetectLanguage.GetLanguage;
import static com.example.masteradar.bankingchatbot.DetectLanguage.prettify;

public class Chat extends AppCompatActivity {

    ListView listView;
    EditText editText;
    List<ChatBot> list_chat = new ArrayList<>();
    FloatingActionButton btn_send_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        listView = findViewById(R.id.list_of_message);
        editText = findViewById(R.id.user_message);
        btn_send_message = findViewById(R.id.flaotingButton);

        btn_send_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                ChatBot chatBot= new ChatBot(text,true);
                list_chat.add(chatBot);
                BotReply botReply = new BotReply(text);

                ChatBot chatBot1= new ChatBot(botReply.getReply(),false);
                list_chat.add(chatBot1);
                CustomAdapter adapter = new CustomAdapter(list_chat,getApplicationContext());
                listView.setAdapter(adapter);
                editText.setText("");
            }
        });
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        Log.d("tag","below layout");


      /*  try {
            Documents documents = new Documents ();
            documents.add ("1","en", "This is a document written in English.");

            Log.d("tag","below document add");
            String response = GetLanguage (documents);
            Log.d("tag","below get language");
            Log.d("tag",prettify (response));


        }
        catch (Exception e) {
            System.out.println (e);
        }*/

        /*final NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
                NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27,
                "{5b494404-2c87-4e5a-a95d-ed15e19086ef}",
                "{MfSCiUHhyyKt}"
        );



        String text = "IBM is an American multinational technology " +
                "company headquartered in Armonk, New York, " +
                "United States, with operations in over 170 countries.";

        EntitiesOptions entitiesOptions = new EntitiesOptions.Builder()
                .emotion(true)
                .sentiment(true)
                .limit(2)
                .build();

        KeywordsOptions keywordsOptions = new KeywordsOptions.Builder()
                .emotion(true)
                .sentiment(true)
                .limit(2)
                .build();

        Features features = new Features.Builder()
                .entities(entitiesOptions)
                .keywords(keywordsOptions)
                .build();

        final AnalyzeOptions parameters = new AnalyzeOptions.Builder()
                .text(text)
                .features(features)
                .build();
        ServiceCall call = service.analyze(parameters);
        call.enqueue(new ServiceCallback<AnalysisResults>() {
            @Override public void onResponse(AnalysisResults response) {
                response = service
                        .analyze(parameters)
                        .execute();
                Log.d("tag", ""+response);

            }
            @Override public void onFailure(Exception e) {

            }
        });
*/

    }
    private class BotReply{

        String textPhrases,textSenti,text;
        String reply;



        public BotReply(String text) {
            this.text = text;
            setReply();
        }

        public String getReply() {
            return reply;
        }

        public void setReply() {
            try {
                Documents documents = new Documents ();
                documents.add ("1","en", text);


                String responsePhrase = GetKeyPhrases.prettify(GetKeyPhrases.GetKeyPhrases(documents));
                String responseSentiment = GetSentiment.prettify(GetSentiment.GetSentiment(documents));

                reply = responsePhrase+" "+responseSentiment;


            }
            catch (Exception e) {
                System.out.println (e);
            }
        }

    }
}
