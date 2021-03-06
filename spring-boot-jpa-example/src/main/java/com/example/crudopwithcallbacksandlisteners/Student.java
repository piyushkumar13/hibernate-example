package com.example.crudopwithcallbacksandlisteners;

import com.example.crudopwithcallbacksandlisteners.listeners.EntityValidation;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
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
@EntityListeners(value = {EntityValidation.class})
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


    @PrePersist
    public void validationForPrePersist(){
        System.out.println("==== PrePersist Callback Starts ====");
        System.out.println("Validating name");
        Objects.requireNonNull(this.name);
        System.out.println("Validating dob");
        Objects.requireNonNull(this.dob);
        System.out.println("==== PrePersist Callback Ends ====");
    }

    @PreUpdate
    public void validationForPreUpdate(){
        System.out.println("==== PreUpdate Callback Starts ====");
        System.out.println("Validating name");
        Objects.requireNonNull(this.name);
        System.out.println("Validating dob");
        Objects.requireNonNull(this.dob);
        System.out.println("==== PreUpdate Callback Ends ====");
    }

    @PreRemove
    public void validationForPreRemove(){
        System.out.println("==== PreRemove Callback Starts ====");
        System.out.println("Validating name");
        Objects.requireNonNull(this.name);
        System.out.println("Validating dob");
        Objects.requireNonNull(this.dob);
        System.out.println("==== PreRemove Callback Ends ====");
    }

    @PostPersist
    public void logMsgPostPersist(){
        System.out.println("==== PostPersist Callback Starts ====");
        System.out.println("The object is successfully persisted" + this);
        System.out.println("==== PostPersist Callback Ends ====");
    }

    @PostUpdate
    public void logMsgPostUpdate(){
        System.out.println("==== PostUdpate Callback Starts ====");
        System.out.println("The object is successfully updated" + this);
        System.out.println("==== PostUpdate Callback Ends ====");
    }

    @PostLoad
    public void logMsgPostLoad(){
        System.out.println("==== PostLoad Callback Starts ====");
        System.out.println("The object is successfully removed" + this);
        System.out.println("==== PostLoad Callback Ends ====");
    }

    @PostRemove
    public void logMsgPostRemove(){
        System.out.println("==== PostRemove Callback Starts ====");
        System.out.println("The object is successfully fetched" + this);
        System.out.println("==== PostRemove Callback Ends ====");
    }
}
