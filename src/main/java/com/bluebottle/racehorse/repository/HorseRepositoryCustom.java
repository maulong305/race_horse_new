package com.bluebottle.racehorse.repository;

import com.bluebottle.racehorse.model.Horse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HorseRepositoryCustom {
    List<Horse> findAllByTrainerId(Long id);

    List<Horse> findAllByTrainerIdAndName(Long id, String name, Pageable pageable);

    List<Horse> findAllByFoaled(Long id, String year, Pageable pageable);
}
