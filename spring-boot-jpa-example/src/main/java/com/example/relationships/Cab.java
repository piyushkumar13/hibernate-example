package com.example.relationships;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Entity(name = "CAB")
public class Cab {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "CAB_TYPE")
    private String cabType;

    @ManyToMany(mappedBy = "cabs", cascade = CascadeType.ALL)
    private List<Employee> employees;
}
