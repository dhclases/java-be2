package com.dh.clinica.demo.controllers.exceptions;

import lombok.Data;

@Data
public class Error {
    private String errorClass;
    private String errorDetail;

    public Error(String errorClass, String errorDetail) {
        this.errorClass = errorClass;
        this.errorDetail = errorDetail;
    }
}
