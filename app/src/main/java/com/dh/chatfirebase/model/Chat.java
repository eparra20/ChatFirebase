package com.dh.chatfirebase.model;

public class Chat {

    private String mensaje;
    private String receptor;
    private String emisor;
    private Integer tipo;

    public  final static  int TIPO_EMISOR = 1;
    public final static int TIPO_RECEPTOR = 2;

    public Chat() {
    }

    public Chat(String mensaje, String receptor, String emisor,Integer tipo) {
        this.mensaje = mensaje;
        this.receptor = receptor;
        this.emisor = emisor;
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}
