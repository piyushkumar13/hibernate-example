package com.example.relationships;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Piyush Kumar.
 * @since 04/07/21.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue
    @Column(name = "PROJECT_ID")
    private int projectId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PROJECT_TYPE")
    private String projectType;

}
