package com.example.crudopwithcallbacksandlisteners.listeners;

import com.example.crudopwithcallbacksandlisteners.Student;
import java.util.Objects;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

/**
 * @author Piyush Kumar.
 * @since 12/07/21.
 */
public class EntityValidation {

    @PrePersist
    public void validationForPrePersist(Student student){
        System.out.println("==== Listener : PrePersist Callback Starts ====");
        System.out.println("Validating name");
        Objects.requireNonNull(student.getName());
        System.out.println("Validating dob");
        Objects.requireNonNull(student.getDob());
        System.out.println("==== Listener : PrePersist Callback Ends ====");
    }

    @PreUpdate
    public void validationForPreUpdate(Student student){
        System.out.println("==== Listener : PreUpdate Callback Starts ====");
        System.out.println("Validating name");
        Objects.requireNonNull(student.getName());
        System.out.println("Validating dob");
        Objects.requireNonNull(student.getDob());
        System.out.println("==== Listener : PreUpdate Callback Ends ====");
    }

    @PreRemove
    public void validationForPreRemove(Student student){
        System.out.println("==== Listener : PreRemove Callback Starts ====");
        System.out.println("Validating name");
        Objects.requireNonNull(student.getName());
        System.out.println("Validating dob");
        Objects.requireNonNull(student.getDob());
        System.out.println("==== Listener : PreRemove Callback Ends ====");
    }

    @PostPersist
    public void logMsgPostPersist(Student student){
        System.out.println("==== Listener : PostPersist Callback Starts ====");
        System.out.println("The object is successfully persisted" + student);
        System.out.println("==== Listener : PostPersist Callback Ends ====");
    }

    @PostUpdate
    public void logMsgPostUpdate(Student student){
        System.out.println("==== Listener : PostUdpate Callback Starts ====");
        System.out.println("The object is successfully updated" + student);
        System.out.println("==== Listener : PostUpdate Callback Ends ====");
    }

    @PostLoad
    public void logMsgPostLoad(Student student){
        System.out.println("==== Listener : PostLoad Callback Starts ====");
        System.out.println("The object is successfully removed" + student);
        System.out.println("==== Listener : PostLoad Callback Ends ====");
    }

    @PostRemove
    public void logMsgPostRemove(Student student){
        System.out.println("==== Listener : PostRemove Callback Starts ====");
        System.out.println("The object is successfully fetched" + student);
        System.out.println("==== Listener : PostRemove Callback Ends ====");
    }


}
