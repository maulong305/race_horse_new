package com.bluebottle.racehorse.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Horse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date foaled;
    private String color;
    @ManyToMany
    @JoinTable(name = "horse_account",
            joinColumns = {@JoinColumn(name = "horse_id")},
            inverseJoinColumns ={@JoinColumn(name = "trainer_id")})
    private Set<Trainer> trainers;

}
