package com.bluebottle.racehorse.dto.account;

import com.bluebottle.racehorse.model.Account;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class AccountResponse {
    private Long id;
    private String username;
    private Long status;

    public AccountResponse(Account account) {
        BeanUtils.copyProperties(account, this);
    }
}
