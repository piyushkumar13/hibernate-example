package com.example.relationships;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity(name = "ADDRESS")
//@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "BUILDING_NAME")
    private String buildingName;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee refemployee;

}
