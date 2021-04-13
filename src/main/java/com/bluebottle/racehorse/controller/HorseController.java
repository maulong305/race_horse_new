package com.bluebottle.racehorse.controller;

import com.bluebottle.racehorse.model.Horse;
import com.bluebottle.racehorse.service.HorseService;
import com.bluebottle.racehorse.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/horses/")
//@RequiredArgsConstructor
public class HorseController {
    @Autowired
    private  HorseService horseService;
//    show All horse and sort by name
    @GetMapping("")
    public ResponseEntity<Iterable<Horse>> getHorses(@RequestParam Integer pageIndex, @RequestParam Integer pageSize){
        pageSize = pageSize != null ? pageSize : 5;
        pageIndex = pageIndex != null ? pageIndex : 0;
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Iterable<Horse> horses = horseService.findAll(pageable);
        if (horses.equals(null)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(horses, HttpStatus.OK);
        }
    }
}
