package com.example.inheritance.joinedstrategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Piyush Kumar.
 * @since 10/07/21.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("FOUR_WHEELER")
public class FourWheeler extends Vehicle {

    private String engineName;
    private String steeringType;
}
