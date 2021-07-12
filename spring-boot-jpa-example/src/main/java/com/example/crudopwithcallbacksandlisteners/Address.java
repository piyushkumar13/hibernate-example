package com.example.crudopwithcallbacksandlisteners;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Piyush Kumar.
 * @since 04/07/21.
 */

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    @Column(name = "BUILDING_NAME")
    private String buildingName;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
}
