package com.capgi.bank.controller;

import com.capgi.bank.constants.AccountConstant;
import com.capgi.bank.entity.dto.AccountDto;
import com.capgi.bank.entity.dto.AccountResponseDto;
import com.capgi.bank.entity.dto.ResponseDto;
import com.capgi.bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody AccountDto accountDto) {
        accountService.createAccount(accountDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(
                        AccountConstant.STATUS_201,
                        AccountConstant.MESSAGE_201,
                        null
                ));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AccountResponseDto> getAccountById(@PathVariable Integer id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AccountResponseDto>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateAccount(
            @PathVariable Integer id,
            @RequestBody AccountDto accountDto
    ) {
        accountService.updateAccount(id, accountDto);

        return ResponseEntity.ok(
                new ResponseDto(
                        AccountConstant.STATUS_200,
                        AccountConstant.MESSAGE_200,
                        null
                )
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteAccount(@PathVariable Integer id) {
        accountService.deleteAccount(id);

        return ResponseEntity.ok(
                new ResponseDto(
                        AccountConstant.STATUS_204,
                        AccountConstant.MESSAGE_204,
                        null
                )
        );
    }
}