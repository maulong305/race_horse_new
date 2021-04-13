package com.bluebottle.racehorse.repository;

import com.bluebottle.racehorse.model.Horse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface HorseRepository extends PagingAndSortingRepository<Horse, Long> {
    Page<Horse> findAllByOrderByName(Pageable pageable);

}
