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

import static com.dh.chatfirebase.model.Chat.TIPO_EMISOR;
import static com.dh.chatfirebase.model.Chat.TIPO_RECEPTOR;

public class ChatAdapter extends RecyclerView.Adapter {

    private List<Chat> chatList;

    public ChatAdapter(List<Chat> chatList) {
        this.chatList = chatList;
    }


    public void setChatList(List<Chat> chatList) {
        this.chatList = chatList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return this.chatList.get(position).getTipo();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = null;

        switch (viewType) {
            case TIPO_EMISOR:
                view = layoutInflater.inflate(R.layout.celda_chat_emisor, parent, false);
                return new ChatEmisorViewHolder(view);
            case TIPO_RECEPTOR:
                view = layoutInflater.inflate(R.layout.celda_chat_receptor, parent, false);
                return new ChatReceptorViewHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Chat chat = this.chatList.get(position);

        switch (chat.getTipo()){
            case TIPO_EMISOR:
                ChatEmisorViewHolder chatEmisorViewHolder = (ChatEmisorViewHolder) holder;
                chatEmisorViewHolder.onBind(chat);
                break;
            case TIPO_RECEPTOR:
                ChatReceptorViewHolder chatReceptorViewHolder = (ChatReceptorViewHolder) holder;
                chatReceptorViewHolder.bind(chat);
                break;
        }



    }

    @Override
    public int getItemCount() {
        return this.chatList.size();
    }

    class ChatReceptorViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewMensajeReceptor;

        public ChatReceptorViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewMensajeReceptor = itemView.findViewById(R.id.textViewMensajeReceptor);
        }

        public void bind(Chat chat) {
            this.textViewMensajeReceptor.setText(chat.getMensaje());
        }
    }

    class ChatEmisorViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewMensajeEmisor;

        public ChatEmisorViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewMensajeEmisor = itemView.findViewById(R.id.textViewMensajeEmisor);
        }

        public void onBind(Chat chat) {
            this.textViewMensajeEmisor.setText(chat.getMensaje());
        }
    }


}
