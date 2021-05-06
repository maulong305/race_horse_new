package com.bluebottle.racehorse.service;

import com.bluebottle.racehorse.dto.horse.HorseResponse;
import com.bluebottle.racehorse.dto.horse.UpdateHorseRequest;
import com.bluebottle.racehorse.model.Horse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HorseService extends IService<Horse> {
    HorseResponse update(UpdateHorseRequest updateHorseRequest);
    Iterable<Horse> findAllByTrainer(Long id);
    List<Horse> findAllByTrainerAndName(Long id, String name, Pageable pageable);
    List<Horse> findAllByFoaled(Long id, String year, Pageable pageable);
}
