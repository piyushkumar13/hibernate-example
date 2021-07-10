package com.example.inheritance.singletablestrategy;

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
public class JpaWithExplicitEMForInheritance implements ApplicationRunner {

    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {

        SpringApplication.run(JpaWithExplicitEMForInheritance.class, args);
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("MyVehicle");
        vehicle.setVehicleModelYear("2021");
        vehicle.setPassengerCapacity("1");

        TwoWheeler twoWheeler = new TwoWheeler();
        twoWheeler.setEngineName("bajaj");
        twoWheeler.setHandleType("straight-handle");
        twoWheeler.setVehicleName("Avenger");
        twoWheeler.setVehicleModelYear("2021");
        twoWheeler.setPassengerCapacity("2");

        FourWheeler fourWheeler = new FourWheeler();
        fourWheeler.setEngineName("ford");
        fourWheeler.setSteeringType("round");
        fourWheeler.setVehicleName("Audi");
        fourWheeler.setVehicleModelYear("2021");
        fourWheeler.setPassengerCapacity("6");

        entityManager.persist(vehicle);
        entityManager.persist(twoWheeler);
        entityManager.persist(fourWheeler);
    }
}
