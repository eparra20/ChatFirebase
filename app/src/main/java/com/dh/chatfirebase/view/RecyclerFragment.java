package com.dh.chatfirebase.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dh.chatfirebase.R;
import com.dh.chatfirebase.controller.ChatController;
import com.dh.chatfirebase.model.Chat;
import com.dh.chatfirebase.util.ResultListener;

import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerFragment extends Fragment {


    public RecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        final RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        ChatController chatController = new ChatController();
        chatController.getChats(new ResultListener<List<Chat>>() {
            @Override
            public void onFinish(List<Chat> chats) {
                configurarRecycler(recyclerView, chats);
            }
        });


        return view;
    }

    private void configurarRecycler(RecyclerView recyclerView, List<Chat> chats) {
        ChatAdapter chatAdapter = new ChatAdapter(chats);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(chatAdapter);
    }

}
