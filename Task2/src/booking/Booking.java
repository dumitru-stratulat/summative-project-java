package booking;

import instructor.Instructor;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import member.Member;
import menu.Menu;
import motorboat.Motorboat;
import static utils.Utils.dateTimeHandler;

/**
 *
 * @author dima82.91
 */
public class Booking {

    private final LocalDateTime dateTime;
    private final Member member;
    private final Motorboat motorboat;
    private final Instructor instructor;

    public Booking(LocalDateTime dateTime, Member member, Motorboat motorboat, Instructor instructor) {
        this.dateTime = dateTime;
        this.member = member;
        this.motorboat = motorboat;
        this.instructor = instructor;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Motorboat getMotorboat() {
        return this.motorboat;
    }

    public Member getMember() {
        return member;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public static void bookingHandler(Instructor instructor, Member member) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime dateAndTimeIsertedByUser = dateTimeHandler();
        List<Motorboat> mockMotorboatList = Menu.getMockMotorboatList();
        System.out.println();
        System.out.println("Inserted date= " + dateAndTimeIsertedByUser);
        System.out.println();
        //check if this booking occupied

        dateAndTimeIsertedByUser = Instructor.checkIfLessonAlreadyBooked(dateAndTimeIsertedByUser, member, instructor);
        Motorboat.displayAvailableMotorboats(dateAndTimeIsertedByUser, member, mockMotorboatList);
        System.out.println();
        System.out.println("Insert nr of available motorboat for booking!");
        int motorboatNr = scanner.nextInt() - 1;//list starts from 0 but motorboat nr starts from 1
        Motorboat.motorboatBooking(mockMotorboatList.get(motorboatNr), dateAndTimeIsertedByUser, member);
        Booking booking = new Booking(dateAndTimeIsertedByUser, member, mockMotorboatList.get(motorboatNr), instructor);
        instructor.addBooking(booking);
        member.addBookingsWithInstructors(booking);
        System.out.println("The timeslot is successfully booked!");
        System.out.println();
    }
}
