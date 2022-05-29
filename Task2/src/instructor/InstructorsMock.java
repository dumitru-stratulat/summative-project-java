package instructor;

import java.util.LinkedList;
import java.util.List;
import member.Member;
import booking.Booking;
import java.time.LocalDateTime;
import motorboat.Motorboat;
import motorboat.MotorboatMock;

public class InstructorsMock {

    List<Instructor> instructors = new LinkedList<>();

    public List<Instructor> getInstructors() {
        instructors.add(new Instructor("Laura Meadhbh"));
        instructors.add(new Instructor("Darshana Bion"));
        instructors.add(new Instructor("Kimmo Jayanta"));
        instructors.add(new Instructor("Iiro Anelie"));
        instructors.add(new Instructor("Haman Marcius"));

        return instructors;
    }

    ;
    //method is used only for moock booking 
    public void addMockBooking(Member member, LocalDateTime localDateTime, Instructor instructor, Motorboat motorboat) {
        //methods below adds booking for every element instructor,member,motorboat
        Booking booking = new Booking(localDateTime, member, motorboat, instructor);
        instructor.addBooking(booking);
        member.addBookingsWithInstructors(booking);
        MotorboatMock.addMockBooking(motorboat, localDateTime, member.getMemberType());
    }
}
