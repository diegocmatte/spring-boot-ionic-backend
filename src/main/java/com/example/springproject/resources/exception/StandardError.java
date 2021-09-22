package com.example.springproject.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer statusErro;
    private String msgErro;
    private Long timeStamp;

    public StandardError(Integer statusErro, String msgErro, Long timeStamp) {
        this.statusErro = statusErro;
        this.msgErro = msgErro;
        this.timeStamp = timeStamp;
    }

    public Integer getStatusErro() {
        return statusErro;
    }

    public void setStatusErro(Integer statusErro) {
        this.statusErro = statusErro;
    }

    public String getMsgErro() {
        return msgErro;
    }

    public void setMsgErro(String msgErro) {
        this.msgErro = msgErro;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
