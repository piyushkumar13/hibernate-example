package com.example.inheritance.singletablestrategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@DiscriminatorValue("TWO_WHEELER")
public class TwoWheeler extends Vehicle {

    private String engineName;
    private String handleType;
}
