package com.bluebottle.racehorse.repository;

import com.bluebottle.racehorse.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
}
