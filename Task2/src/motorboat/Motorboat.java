package motorboat;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import member.Member;
import utils.Utils;

/**
 *
 * @author dima82.91
 */
public class Motorboat {

    private final String name;
    private final HashSet<MotorboatBooking> bookings = new HashSet<>();

    public Motorboat(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addBooking(MotorboatBooking booking) {
        this.bookings.add(booking);
    }

    public HashSet<MotorboatBooking> getBookings() {
        return bookings;
    }

    public static void displayAllMotorboats(List<Motorboat> mockMotorboatList) {
        int index = 0;
        for (Motorboat motorboat : mockMotorboatList) {
            System.out.println(index + "." + motorboat.getName());
            index++;
        }
    }

    public static void displayMotorboat(Motorboat motorboat) {
        System.out.println("==Motorboat info==");
        System.out.println("==Schedule for selected motorboat==");
        Iterator<MotorboatBooking> it = motorboat.getBookings().iterator();
        while (it.hasNext()) {
            MotorboatBooking element = it.next();
            System.out.println("Scheduled date and time:" + Utils.localDateTimeFormatter(element.getDateTime()));
            System.out.println("Booking type:" + element.getmotorboatBookingType());
            System.out.println("-------------------------");
        }
    }

    public static void motorboatBooking(Motorboat motorboat, LocalDateTime bookingTime, Member member) {
        MotorboatBooking booking = new MotorboatBooking(bookingTime, motorboat, member.getMemberType());
        motorboat.addBooking(booking);
        member.addMotorboatHiring(booking);
    }

    public static void displayAvailableMotorboats(LocalDateTime dateAndTimeIsertedByUser, Member member, List<Motorboat> mockMotorboatList) {
        //using iterator to itreate for better performance
        Iterator<Motorboat> it = mockMotorboatList.iterator();
        int index = 0;
        //iterate through all motorboat and motorboat bookings to check if it is not already booked
        while (it.hasNext()) {
            index++;
            boolean isSlotAvailable = true;
            Motorboat element = it.next();
            Iterator<MotorboatBooking> motorboatBookingIterator = element.getBookings().iterator();

            while (motorboatBookingIterator.hasNext()) {
                MotorboatBooking motorboatBooking = motorboatBookingIterator.next();
                //if booked slot time matches the datetime inserted by user then booking is not available
                if (motorboatBooking.getDateTime().equals(dateAndTimeIsertedByUser)) {
                    System.out.println("Booking for motorboat MB-" + index + " is not available");
                    isSlotAvailable = false;
                    break;
                } else {
                    isSlotAvailable = true;
                }
            }
            if (isSlotAvailable) {
                System.out.println(index + ".Motorboat " + element.getName() + " is available!");
            }
        }
    }

    public static boolean checkIfMotorboatAlreadyBooked(Member member, LocalDateTime dateAndTimeIsertedByUser) {
        if (member.getMotorboatHires().size() >= 2) {
            System.out.println("No more than 2 hirings is allowed");
            return true;
        }
        Iterator<MotorboatBooking> it = member.getMotorboatHires().iterator();
        while (it.hasNext()) {
            MotorboatBooking element = it.next();
            if (element.getDateTime().equals(dateAndTimeIsertedByUser)) {
                System.out.println("Slot already booked by mblh member");
                return true;
            }
        }
        return false;
    }
}
