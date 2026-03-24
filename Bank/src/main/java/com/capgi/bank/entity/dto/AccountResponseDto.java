package com.capgi.bank.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountResponseDto {

    private Long balance;
    private String  accountHolderName;
    private Integer accountId;
    private AccountType accountType;

}
