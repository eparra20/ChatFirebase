package com.dh.chatfirebase.view;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.dh.chatfirebase.R;
import com.dh.chatfirebase.controller.ChatController;
import com.dh.chatfirebase.model.Chat;
import com.dh.chatfirebase.util.ResultListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {


    private  ChatAdapter chatAdapter;


    public ChatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        final RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        FloatingActionButton button = view.findViewById(R.id.buttonEnviar);
        final EditText editText = view.findViewById(R.id.editTextChat);
        configurarRecycler(recyclerView);
       /* ChatController chatController = new ChatController();
        chatController.getChats(new ResultListener<List<Chat>>() {
            @Override
            public void onFinish(List<Chat> chats) {
                configurarRecycler(recyclerView, chats);
            }
        });*/


        leerFirebase();
        monitorearFirebase();

        button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String mensaje = editText.getText().toString();
               Chat chat = new Chat(mensaje, "", "", Chat.TIPO_EMISOR);
               escribirChat(chat);
               editText.setText("");

           }
       });






        return view;
    }

    private void monitorearFirebase(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("chat").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {

                List<Chat> chatList = new ArrayList<>();
                for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                    Chat chat = document.toObject(Chat.class);
                    chatList.add(chat);
                }
                chatAdapter.setChatList(chatList);
            }
        });


    }

    private void leerFirebase() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("chat").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                List<Chat> chatList = new ArrayList<>();
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Chat chat = document.toObject(Chat.class);
                        chatList.add(chat);
                    }
                    chatAdapter.setChatList(chatList);
                } else {
                    Toast.makeText(getContext(), "ha ocurrido un error al leer de firebase", Toast.LENGTH_SHORT).show();;
                }
            }
        });
    }

    private void configurarRecycler(RecyclerView recyclerView) {
         chatAdapter = new ChatAdapter(new ArrayList<Chat>());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(chatAdapter);
    }

    public void escribirChat(Chat chat){

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("chat")
                .add(chat)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getContext(), "Mensaje Enviado...", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
