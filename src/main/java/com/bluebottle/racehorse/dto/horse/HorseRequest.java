package com.bluebottle.racehorse.dto.horse;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class HorseRequest {
    private String name;
    private Date foaled;
    private String color;
}
