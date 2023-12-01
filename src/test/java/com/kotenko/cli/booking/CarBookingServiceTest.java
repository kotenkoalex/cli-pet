package com.kotenko.cli.booking;

import com.kotenko.cli.car.*;
import com.kotenko.cli.user.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CarBookingServiceTest {

    @Test
    void bookRandomCar() {
        CarBookingDao carBookingDao = new CarBookingArrayDataAccessService();
        CarDao carDao = new CarArrayDataAccessService();
        CarService carService = new CarService(carDao);

        CarBookingService service = new CarBookingService(carBookingDao, carService);

        CarBooking carBooking = new CarBooking(
                UUID.randomUUID(),
                new User(UUID.randomUUID(), "User"),
                new Car(UUID.randomUUID(), Engine.PETROL, Brand.MAZDA),
                LocalDateTime.now());

        service.bookCar(new User(UUID.randomUUID(), "User"),
                new Car(UUID.randomUUID(), Engine.PETROL, Brand.MAZDA));

        assertEquals(service.getCarBookings(), carBooking);
    }

    @Test
    void getInitialSizeCarBookings() {
        CarBookingArrayDataAccessService service = new CarBookingArrayDataAccessService();
        assertEquals(0, service.getCarBookings().size());
    }

    @Test
    void getAvailableCars() {
        //TODO
    }

    @Test
    void getAllUserBookedCars() {
        //TODO
    }
}
