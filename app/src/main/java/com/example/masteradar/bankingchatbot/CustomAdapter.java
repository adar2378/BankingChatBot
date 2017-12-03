package com.example.masteradar.bankingchatbot;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.github.library.bubbleview.BubbleTextView;

import java.util.List;

/**
 * Created by Master Adar on 02-Dec-17.
 */

public class CustomAdapter extends BaseAdapter {

    private List<ChatBot> list_chat_bots;
    private Context context;
    private LayoutInflater layoutInflater;

    public CustomAdapter(List<ChatBot> list_chat_bots, Context context) {
        this.list_chat_bots = list_chat_bots;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list_chat_bots.size();
    }

    @Override
    public Object getItem(int i) {
        return list_chat_bots.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            if(list_chat_bots.get(i).isSend){
                view = layoutInflater.inflate(R.layout.list_item_send,null);

            }
            else{
                view = layoutInflater.inflate(R.layout.list_item_recieve,null);
            }
            BubbleTextView text_meesage = view.findViewById(R.id.textMessage);
            Log.d("id",""+i+text_meesage);
            text_meesage.setText(list_chat_bots.get(i).getMessage());
        }
        return view;
    }

}
