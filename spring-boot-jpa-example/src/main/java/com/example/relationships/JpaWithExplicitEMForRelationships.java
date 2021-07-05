package com.example.relationships;

import static java.util.Arrays.asList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Piyush Kumar.
 * @since 04/07/21.
 */

@SpringBootApplication
public class JpaWithExplicitEMForRelationships implements ApplicationRunner {

    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {

        SpringApplication.run(JpaWithExplicitEMForRelationships.class, args);
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        Project project1 = Project.builder().name("Asset Management").projectType("Jira").build();

        Vehicle vehicle1 = Vehicle.builder().name("AUDI").model("2021").variant("Q3").build();
        Vehicle vehicle2 = Vehicle.builder().name("Range Rover").model("2021").variant("Evoque").build();
        Vehicle vehicle3 = Vehicle.builder().name("BMW").model("2021").variant("X3").build();


        Address homeAddress = Address.builder().buildingName("Sopara Building").city("Bengaluru").state("Karnataka").build();
        Address officeAddress = Address.builder().buildingName("Raj Bhavan Road").city("Bengaluru").state("Karnataka").build();

        Subordinate subordinate1 = Subordinate.builder().name("ABC").build();
        Subordinate subordinate2 = Subordinate.builder().name("XYZ").build();
        Subordinate subordinate3 = Subordinate.builder().name("PQR").build();

        Cab cab1 = Cab.builder().cabType("Innova").build();
        Cab cab2 = Cab.builder().cabType("Desire").build();
        Cab cab3 = Cab.builder().cabType("Etios").build();

//        Employee employee = Employee.builder()
//                .name("Piyush")
//                .companyName("ABC Company")
//                .designation("Engineer")
//                .address(asList(homeAddress, officeAddress))
//                .project(project1)
//                .vehicles(asList(vehicle1, vehicle2, vehicle3))
//                .build();

        Employee employee = new Employee();
        employee.setName("Piyush");
        employee.setCompanyName("ABC Company");
        employee.setDesignation("Engineer");
        employee.setAddress(asList(homeAddress, officeAddress));
        employee.setProject(project1);
        employee.setVehicles(asList(vehicle1, vehicle2, vehicle3));
        employee.setSubordinates(asList(subordinate1, subordinate2, subordinate3));
        employee.setCabs(asList(cab1, cab2, cab3));

        homeAddress.setRefemployee(employee);
        officeAddress.setRefemployee(employee);

        cab1.setEmployees(asList(employee));
        cab2.setEmployees(asList(employee));
        cab3.setEmployees(asList(employee));

        entityManager.persist(employee);
    }
}
