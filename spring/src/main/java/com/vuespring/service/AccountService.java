package com.vuespring.service;

import com.vuespring.exception.ResourceNotFoundException;
import com.vuespring.model.Account;
import com.vuespring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + id));
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(Long id, Account accountDetails) {
        Account account = getAccountById(id);
        account.setAccountName(accountDetails.getAccountName());
        account.setBrandingColorCode(accountDetails.getBrandingColorCode());
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        Account account = getAccountById(id);
        accountRepository.delete(account);
    }

    public Account updateBrandingColor(Long id, String brandingColorCode) {
        Account account = getAccountById(id);
        account.setBrandingColorCode(brandingColorCode);
        return accountRepository.save(account);
    }
}
