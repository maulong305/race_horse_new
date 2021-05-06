package com.bluebottle.racehorse.dto.horse;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateHorseRequest extends HorseRequest {
    private Long id;
}
