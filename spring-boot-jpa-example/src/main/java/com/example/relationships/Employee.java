package com.example.relationships;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Entity(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "DESIGNATION")
    private String designation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "EMPLOYEE_VEHICLE_MAPPING",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
            inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "refemployee", cascade = CascadeType.ALL)
    private List<Address> address;


    /* refer page : https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/one-to-many-foreign-key-mapping.html
    * Good page explains on how to use JoinColumn without bidirectional relationship.
    * */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "REF_EMPLOYEE_ID")
    private List<Subordinate> subordinates;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "EMP_CAB_MAPPING", joinColumns = {@JoinColumn(name = "EMP_ID", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "CAB_ID", referencedColumnName = "id")})
    private List<Cab> cabs;

}
