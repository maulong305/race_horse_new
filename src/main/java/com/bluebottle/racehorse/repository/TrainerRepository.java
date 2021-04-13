package com.bluebottle.racehorse.repository;

import com.bluebottle.racehorse.model.Trainer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TrainerRepository extends PagingAndSortingRepository<Trainer, Long> {
}
