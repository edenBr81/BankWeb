package com.bankweb.account.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    public static enum Status{ SUCCESS, FAILED}
    private Status status;
    private String message;

}
