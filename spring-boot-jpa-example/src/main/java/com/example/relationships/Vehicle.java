package com.example.relationships;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Piyush Kumar.
 * @since 04/07/21.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "VEHICLE")
//@Table(name = "VEHICLE")
public class Vehicle {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "VARIANT")
    private String variant;
}
