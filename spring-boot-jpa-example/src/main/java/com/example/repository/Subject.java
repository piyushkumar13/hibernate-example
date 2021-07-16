package com.example.repository;

import javax.persistence.Embeddable;
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
@Embeddable
public class Subject {

    private String name;
    private String subNumber;
    private String subStream;
}
