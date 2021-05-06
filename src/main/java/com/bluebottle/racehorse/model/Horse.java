package com.bluebottle.racehorse.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
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
            inverseJoinColumns ={@JoinColumn(name = "account_id")})
    private Set<Account> accounts;

}
