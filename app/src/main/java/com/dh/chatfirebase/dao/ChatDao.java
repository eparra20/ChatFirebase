package com.dh.chatfirebase.dao;

import com.dh.chatfirebase.model.Chat;

import java.util.Arrays;
import java.util.List;

public class ChatDao {

    public List<Chat> getChats(){
       return  Arrays.asList(
                new Chat("Hola como estas?","Adrian","Eduardo"),
                new Chat("Bien bien y tu? Como van las clases?","Eduardo","Adrian"),
                new Chat("Vienen bien, bla bla bla bla....","Adrian","Eduardo"),
                new Chat("terminamos el 18 de diciembre las clases","Adrian","Eduardo"),
                new Chat("Oh que bien, y luego que haras? ","Eduardo","Adrian"),
                new Chat("tienes algun plan ?", "Eduardo","Adrian"),
                new Chat("Si si, tenemos la fiesta de fin de año en DH y luego vere","Adrian","Eduardo"),
                new Chat("Creo que me voy a matricidiar","Adrian","Eduardo"),
                new Chat("WAO que mal! mi sentido pesame","Eduardo","Adrian")
       );

    }
}
