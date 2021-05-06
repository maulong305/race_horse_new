package com.bluebottle.racehorse.service;

import com.bluebottle.racehorse.dto.horse.HorseResponse;
import com.bluebottle.racehorse.dto.horse.UpdateHorseRequest;
import com.bluebottle.racehorse.model.Horse;
import com.bluebottle.racehorse.repository.HorseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public HorseResponse update(UpdateHorseRequest updateHorseRequest) {
        Horse horse = horseRepository.findById(updateHorseRequest.getId()).orElse(null);
        if (horse == null) {
            return null;
        } else {
            BeanUtils.copyProperties(updateHorseRequest, horse);
            horseRepository.save(horse);

            return new HorseResponse(horse);
        }
    }

    @Override
    public Iterable<Horse> findAllByTrainer(Long id) {
        return horseRepository.findAllByTrainerId(id);
    }

    @Override
    public List<Horse> findAllByTrainerAndName(Long id, String name, Pageable pageable) {
        return horseRepository.findAllByTrainerIdAndName(id, name, pageable);
    }


    @Override
    public List<Horse> findAllByFoaled(Long id, String year, Pageable pageable) {
        return horseRepository.findAllByFoaled(id, year, pageable);
    }
}
