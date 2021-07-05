package com.example.relationships;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Piyush Kumar.
 * @since 05/07/21.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "SUBORDINATE")
public class Subordinate {

    @Id
    @GeneratedValue
    private int id;

    private String name;
}
