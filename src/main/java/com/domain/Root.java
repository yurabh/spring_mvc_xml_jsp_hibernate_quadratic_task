package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roots")
public class Root {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private Double x1;

    @Column(nullable = false)
    private Double x2;

    public Root(Double x1, Double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}
