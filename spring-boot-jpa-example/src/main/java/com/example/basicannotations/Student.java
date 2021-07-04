package com.example.basicannotations;

import java.util.Date;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Piyush Kumar.
 * @since 14/06/21.
 */

@Entity(name = "STUDENT")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
//@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // By default strategy is auto only
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "COLLEGE")
    private String college;

    @Embedded
    private Address officeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "buildingName", column = @Column(name = "HOME_BUILDING_NAME")),
            @AttributeOverride(name = "city", column = @Column(name = "HOME_CITY")),
            @AttributeOverride(name = "state", column = @Column(name = "HOME_STATE"))
    })
    private Address homeAddress;

    @Temporal(TemporalType.DATE)
    @Column(name = "DOB")
    private Date dob;

    @Transient
    private String age;

    @Lob
    private String descriptionBio;

    @ElementCollection
    private List<Subject> subjects;

    @ElementCollection
    private List<String> alias;

    @ElementCollection
    @CollectionTable(name = "EXTRA", joinColumns = @JoinColumn(name = "STUDENT_ID"))
    private List<Extra> extras;

}
