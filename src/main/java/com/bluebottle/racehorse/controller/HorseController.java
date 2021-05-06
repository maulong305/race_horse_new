package com.bluebottle.racehorse.controller;

import com.bluebottle.racehorse.dto.horse.HorseRequest;
import com.bluebottle.racehorse.dto.horse.HorseResponse;
import com.bluebottle.racehorse.dto.horse.UpdateHorseRequest;
import com.bluebottle.racehorse.model.Horse;
import com.bluebottle.racehorse.model.Trainer;
import com.bluebottle.racehorse.service.HorseService;
import com.bluebottle.racehorse.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/horses")
public class HorseController {
    @Autowired
    private HorseService horseService;

    @Autowired
    private TrainerService trainerService;

    private final Date currentTime = Calendar.getInstance().getTime();

    @GetMapping("/list")
    public ResponseEntity<List<HorseResponse>> getAll(@RequestParam(name = "pageIndex", required = false)
                                                          Integer pageIndex,
                                                  @RequestParam(name = "pageSize", required = false)
                                                          Integer pageSize) {
        pageSize = pageSize != null ? pageSize : 5;
        pageIndex = pageIndex != null ? pageIndex : 0;
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Iterable<Horse> horses =  horseService.findAll(pageable);
        List<HorseResponse> horseResponseList = new ArrayList<>();
        if (horses == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            for (Horse horse : horses){
                HorseResponse horseResponse = new HorseResponse(horse);
                horseResponseList.add(horseResponse);
            }
            return new ResponseEntity<>(horseResponseList, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Horse> create(@RequestBody HorseRequest request) {
        Horse horse = new Horse();
        BeanUtils.copyProperties(request, horse);
        horse.setFoaled(currentTime);
        horseService.save(horse);
        return new ResponseEntity<>(horse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<HorseResponse> edit(@RequestBody UpdateHorseRequest updateHorseRequest) {
        return new ResponseEntity<>(horseService.update(updateHorseRequest), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        Horse horse = horseService.findById(id);
        if (horse == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            horseService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/getAllByTrainerId")
    public ResponseEntity<List<HorseResponse>> getAllByTrainerId(@RequestParam("trainerId") Long id) {
        Trainer trainer = trainerService.findById(id);
        List<Horse> horses = (List<Horse>) horseService.findAllByTrainer(id);
        List<HorseResponse> horseResponseList = new ArrayList<>();
        if (trainer == null || horses == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            for (Horse horse: horses){
               HorseResponse horseResponse = new HorseResponse(horse);
               horseResponseList.add(horseResponse);
            }
            return new ResponseEntity<>(horseResponseList, HttpStatus.OK);
        }
    }

    @GetMapping("/getAllByTrainerIdAndName")
    public ResponseEntity<List<HorseResponse>> getAllByTrainerIdAndName(@RequestParam("trainerId") Long id,
                                                                        @RequestParam(name = "horseName", required = false) String name,
                                                                        @RequestParam Integer pageIndex,
                                                                        @RequestParam Integer pageSize){
        Trainer trainer = trainerService.findById(id);
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        List<Horse> horses = horseService.findAllByTrainerAndName(id, name, pageable);
        List<HorseResponse> horseResponseList = new ArrayList<>();
        if (trainer == null || horses == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            for (Horse horse : horses){
                HorseResponse horseResponse = new HorseResponse(horse);
                horseResponseList.add(horseResponse);
            }
            return new ResponseEntity<>(horseResponseList, HttpStatus.OK);
        }
    }

    @GetMapping("/getAllByFoaled")
    public ResponseEntity<List<HorseResponse>> getAllByFoaled(@RequestParam("trainerId") Long id,
                                                              @RequestParam("horseFoaled") String year,
                                                              @RequestParam Integer pageIndex,
                                                              @RequestParam Integer pageSize){
        Trainer trainer = trainerService.findById(id);
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        List<Horse> horses = horseService.findAllByFoaled(id, year, pageable);
        List<HorseResponse> horseResponseList = new ArrayList<>();
        if (trainer == null || horses == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            for (Horse horse : horses){
                HorseResponse horseResponse = new HorseResponse(horse);
                horseResponseList.add(horseResponse);
            }
            return new ResponseEntity<>(horseResponseList, HttpStatus.OK);
        }
    }

}
