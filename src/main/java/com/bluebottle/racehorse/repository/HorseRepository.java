package com.bluebottle.racehorse.repository;

import com.bluebottle.racehorse.model.Horse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface HorseRepository extends PagingAndSortingRepository<Horse, Long>, HorseRepositoryCustom{
    Page<Horse> findAllByOrderByName(Pageable pageable);
}
