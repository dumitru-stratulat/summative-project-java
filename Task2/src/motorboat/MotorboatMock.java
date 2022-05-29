package motorboat;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author dima82.91
 */
public class MotorboatMock {

    List<Motorboat> motorboats;

    public List<Motorboat> getMotorboats() {
        motorboats = new LinkedList<>();
        motorboats.add(new Motorboat("MB-01"));
        motorboats.add(new Motorboat("MB-02"));
        motorboats.add(new Motorboat("MB-03"));
        motorboats.add(new Motorboat("MB-04"));
        motorboats.add(new Motorboat("MB-05"));
        motorboats.add(new Motorboat("MB-06"));
        motorboats.add(new Motorboat("MB-07"));
        motorboats.add(new Motorboat("MB-08"));
        motorboats.add(new Motorboat("MB-09"));
        motorboats.add(new Motorboat("MB-10"));

        return motorboats;
    }

    public static void addMockBooking(Motorboat motorboat, LocalDateTime localDateTime, String motorboatBookingType) {
        MotorboatBooking booking = new MotorboatBooking(localDateTime, motorboat, motorboatBookingType);
        motorboat.addBooking(booking);

    }
;
}
