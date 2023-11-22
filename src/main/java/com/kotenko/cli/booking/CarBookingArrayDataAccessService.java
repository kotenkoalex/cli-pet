package main.java.com.kotenko.cli.booking;

import java.util.ArrayList;
import java.util.List;

public class CarBookingArrayDataAccessService implements CarBookingDao {
    private static final List<CarBooking> carBookings;

    static {
        carBookings = new ArrayList<>();
    }

    @Override
    public List<CarBooking> getCarBookings() {
        return carBookings;
    }

    public void book(CarBooking carBooking) {
        carBookings.add(carBooking);
    }
}