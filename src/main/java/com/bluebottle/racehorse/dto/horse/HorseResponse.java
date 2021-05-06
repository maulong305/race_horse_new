package com.bluebottle.racehorse.dto.horse;

import com.bluebottle.racehorse.model.Account;
import com.bluebottle.racehorse.model.Horse;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.Set;

@Data
public class HorseResponse {
    private Long id;
    private String Name;
    private Date foaled;
    private String color;
    private Set<Account> accounts ;

    public HorseResponse(Horse horse) {
        BeanUtils.copyProperties(horse, this);
    }
}
