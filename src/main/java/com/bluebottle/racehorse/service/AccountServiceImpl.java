package com.bluebottle.racehorse.service;

import com.bluebottle.racehorse.model.Account;
import com.bluebottle.racehorse.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public Iterable<Account> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean remove(Long id) {
        accountRepository.deleteById(id);
        return true;
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
