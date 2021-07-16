package com.example.repository;

import java.util.Date;
import java.util.Objects;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
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
@NamedQuery(name = "Student.findTheRecordWithYourState", query = "select s from STUDENT s where s.homeAddress.state = ?1")
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

    /* Changed below lists to set due to MultipleBagFetchException check https://thorben-janssen.com/fix-multiplebagfetchexception-hibernate/ */

    @ElementCollection
    private Set<Subject> subjects;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> alias;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "EXTRA", joinColumns = @JoinColumn(name = "STUDENT_ID"))
    private Set<Extra> extras;

    @PrePersist
    public void validationForPrePersist(){
        System.out.println("==== PrePersist Callback Starts ====");
        System.out.println("Validating name");
        Objects.requireNonNull(this.name);
        System.out.println("Validating dob");
        Objects.requireNonNull(this.dob);
        System.out.println("==== PrePersist Callback Ends ====");
    }
}
