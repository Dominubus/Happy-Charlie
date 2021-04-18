package com.example.happycharlie.funcionalidadMensajeAnimo;

public class MensajesDeAnimo {
    private Integer id;
    private String typeMessage;
    private String message;

    public MensajesDeAnimo(Integer id, String tipoMensaje, String mensaje) {
        this.id = id;
        typeMessage = tipoMensaje;
        message = mensaje;
    }

    public Integer getId() {
        return id;
    }
    public String getTipoMensaje() {
        return typeMessage;
    }
    public String getMensaje() {
        return message;
    }


    public void setId(Integer id) {
        this.id = id;
    }
    public void setTipoMensaje(String tipoMensaje) {
        typeMessage = tipoMensaje;
    }
    public void setMensaje(String mensaje) {
        message = mensaje;
    }
}
