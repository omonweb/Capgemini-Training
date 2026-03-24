package com.capgi.bank.entity.dto;

public class ResponseDto {
    private String statusCode;
    private String statusMessage;
    private Object object;

    public ResponseDto(String status201, String message201, Object o) {
    }
}
