package com.dh.chatfirebase.model;

public class Chat {

    private String mensaje;
    private String receptor;
    private String emisor;
    private String tipo;

    public Chat() {
    }

    public Chat(String mensaje, String receptor, String emisor) {
        this.mensaje = mensaje;
        this.receptor = receptor;
        this.emisor = emisor;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
