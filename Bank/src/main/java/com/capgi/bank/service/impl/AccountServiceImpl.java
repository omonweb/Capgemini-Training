package com.capgi.bank.service.impl;

import com.capgi.bank.entity.Account;
import com.capgi.bank.entity.dto.AccountDto;
import com.capgi.bank.repository.AccountRepository;
import com.capgi.bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final ModelMapper modelMapper;

    @Override
    public void createAccount(AccountDto accountDto) {
        Account account = new Account();
        Account account1 = modelMapper.map(accountDto, Account.class);
        accountRepository.save(account1);
    }
}