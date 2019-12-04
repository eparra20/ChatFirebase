package com.dh.chatfirebase.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dh.chatfirebase.R;
import com.dh.chatfirebase.model.Chat;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter {

    private List<Chat> chatList;

    public ChatAdapter(List<Chat> chatList) {
        this.chatList = chatList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.celda_chat_emisor, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Chat chat = this.chatList.get(position);
        ChatViewHolder chatViewHolder = (ChatViewHolder) holder;
        chatViewHolder.bind(chat);
    }

    @Override
    public int getItemCount() {
        return this.chatList.size();
    }

    class ChatViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewMensaje;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewMensaje = itemView.findViewById(R.id.textViewMensaje);
        }

        public void bind(Chat chat){
            this.textViewMensaje.setText(chat.getMensaje());
        }
    }


}
