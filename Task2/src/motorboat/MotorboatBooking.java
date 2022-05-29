package motorboat;

import java.time.LocalDateTime;

/**
 *
 * @author dima82.91
 */
public class MotorboatBooking {

    private final LocalDateTime dateTime;
    private final Motorboat motorboat;
    private final String motorboatBookingType;

    public MotorboatBooking(LocalDateTime dateTime, Motorboat motorboat, String motorboatBookingType) {
        this.dateTime = dateTime;
        this.motorboat = motorboat;
        this.motorboatBookingType = motorboatBookingType;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Motorboat getMotorboat() {
        return motorboat;
    }

    public String getmotorboatBookingType() {
        return motorboatBookingType;
    }
}
