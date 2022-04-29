package dev.fitzgerald.Cars;

import dev.fitzgerald.entities.Car;
import dev.fitzgerald.repos.CarRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class CarRepoTest {

    @Autowired
    private CarRepo carRepo;

    @Test
    public void createCar() {
        Car car = new Car(0,"Subaru", "Outback", 5000);
        carRepo.save(car);
        System.out.println(car);
        Assertions.assertNotEquals(0,car.getId());
    }

    @Test
    public void getCar(){
        Car car = this.carRepo.getById(4);
        System.out.println(car.toString());
        Assertions.assertEquals(car.getMake(), "Honda");
    }

    @Test
    public void updateCar(){
        Car car = this.carRepo.getById(4);
        car.setMileage(300000);
        this.carRepo.save(car);
        Assertions.assertEquals(car.getMileage(), this.carRepo.getById(4).getMileage());
    }

    @Test
    public void testDelete() {
        this.carRepo.delete(this.carRepo.getById(4));
        //BS little test for now. Does not delete by ID but I wanted to outline 
        //the CRUD tools for the repo

    }

}
