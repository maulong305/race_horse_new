package com.bluebottle.racehorse.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateAccountRequest extends AccountRequest{
    private int id;
}
