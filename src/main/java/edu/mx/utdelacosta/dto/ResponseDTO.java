package edu.mx.utdelacosta.dto;

import java.util.Date;

public class ResponseDTO {

    private Date datetime;

    private String respuesta;

    private Integer codigo;

    private Object contenido;

    public ResponseDTO(){
        this.datetime = new Date();
    }

    public ResponseDTO(String respuesta, Integer codigo, Object contenido) {
        this.respuesta = respuesta;
        this.codigo = codigo;
        this.contenido = contenido;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Object getContenido() {
        return contenido;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }
}
