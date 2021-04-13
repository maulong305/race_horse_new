package com.bluebottle.racehorse.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private Account account;
}
