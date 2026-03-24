package com.capgi.bank.service;

import com.capgi.bank.entity.dto.AccountDto;
import com.capgi.bank.entity.dto.AccountResponseDto;

public abstract class AccountService {
    public abstract void createAccount(AccountDto accountDto);

    public AccountResponseDto getAccountById(Integer id) {
    }
}
