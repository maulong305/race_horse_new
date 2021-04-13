package com.bluebottle.racehorse.service;

import com.bluebottle.racehorse.model.Trainer;
import com.bluebottle.racehorse.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TrainerServiceImpl implements TrainerService{
    @Autowired
    TrainerRepository trainerRepository;

    @Override
    public Iterable<Trainer> findAll(Pageable pageable) {
        return trainerRepository.findAll(pageable);
    }

    @Override
    public Trainer findById(Long id) {
        return trainerRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean remove(Long id) {
        trainerRepository.deleteById(id);
        return true;
    }

    @Override
    public Trainer save(Trainer trainer) {
        return trainerRepository.save(trainer);
    }
}
