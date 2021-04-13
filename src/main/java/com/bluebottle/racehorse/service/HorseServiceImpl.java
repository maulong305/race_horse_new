package com.bluebottle.racehorse.service;

import com.bluebottle.racehorse.model.Horse;
import com.bluebottle.racehorse.repository.HorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HorseServiceImpl implements HorseService{

    @Autowired
    HorseRepository horseRepository;

    @Override
    public Iterable<Horse> findAll(Pageable pageable) {
        return horseRepository.findAllByOrderByName(pageable);
    }

    @Override
    public Horse findById(Long id) {
        return horseRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean remove(Long id) {
        horseRepository.deleteById(id);
        return true;
    }

    @Override
    public Horse save(Horse horse) {
        return horseRepository.save(horse);
    }
}
