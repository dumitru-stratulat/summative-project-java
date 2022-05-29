package instructor;

import java.util.HashSet;
import java.util.Iterator;
import java.time.LocalDateTime;
import booking.Booking;
import java.time.DayOfWeek;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import member.Member;
import utils.Utils;
import static utils.Utils.dateTimeHandler;

/**
 *
 * @author dima82.91
 */

public class Instructor {

    private final String fullname;
    private final HashSet<Booking> bookingsWithMembers = new HashSet<>();

    public Instructor(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void addBooking(Booking booking) {
        this.bookingsWithMembers.add(booking);
    }

    public HashSet<Booking> getBookingsWithMembers() {
        return this.bookingsWithMembers;
    }

    public static void displayInstructorTimeSlots(Instructor instructor) {
        System.out.println("Instructor:" + instructor.getFullname());
        System.out.println("Instructor schedule:");
        System.out.println("------------------");
        //getting next monday date
        LocalDateTime nextMonday = LocalDateTime.now().truncatedTo(ChronoUnit.HOURS)
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY)).withHour(9);
        //getting one week ahead
        LocalDateTime end = nextMonday.plusDays(6).plusHours(9);
        LocalDateTime currentTimeIterator = nextMonday;
        LocalDateTime bookedTime = null;
        //iterate up to one week
        while (!currentTimeIterator.isEqual(end)) {
            Iterator<Booking> it = instructor.getBookingsWithMembers().iterator();
            while (it.hasNext()) {
                Booking booking = it.next();
                //display booked timeslot during iteration
                if (currentTimeIterator.isEqual(booking.getDateTime())) {
                    bookedTime = currentTimeIterator;
                    System.out.println("booked time: " + Utils.localDateTimeFormatter(currentTimeIterator));
                }
            }
            //check if time iterator is between 9 and 18 and is and is not already booked
            if (currentTimeIterator.getHour() >= 9 && currentTimeIterator.getHour() < 18 && bookedTime == null) {
                System.out.println("Available time slot:" + Utils.localDateTimeFormatter(currentTimeIterator));
            }
            //add one hour to time iterator
            currentTimeIterator = currentTimeIterator.plusHours(1);
            bookedTime = null;
        }
        System.out.println();
    }

    public static void displayInstructors(List<Instructor> mockInstructorsList) {
        int index = 0;
        System.out.println("-----------------");
        for (Instructor instructor : mockInstructorsList) {
            System.out.println(index + "." + instructor.getFullname());
            index++;
        }
        System.out.println("-----------------");
    }

    public static void displayInstructorBookings(Instructor instructor) {
        HashSet<Booking> instructorBookings = instructor.getBookingsWithMembers();
        if (instructorBookings.size() >= 1) {
            Iterator<Booking> it = instructorBookings.iterator();
            System.out.println("==Instructor bookings details==");
            System.out.println("-----------------");
            while (it.hasNext()) {
                Booking booking = it.next();
                System.out.println("Instructor name:" + instructor.getFullname());
                System.out.println("Member name:" + booking.getMember().getFullname());
                System.out.println("Time booked:" + booking.getDateTime());
                System.out.println("Motorboat booked:" + booking.getMotorboat().getName());
                System.out.println("-----------------");
            }
        } else {
            System.out.println("No bookings for this instructor!");
        }
    }

    //check if instructors lesson is not already booked
    public static LocalDateTime checkIfLessonAlreadyBooked(LocalDateTime dateAndTimeIsertedByUser, Member member, Instructor instructor) {
        Iterator<Booking> it = instructor.getBookingsWithMembers().iterator();
        while (it.hasNext()) {
            Booking booking = it.next();
            //if user try to overbook the  lesson he is promted to enter the desired datetime again
            while (booking.getDateTime().isEqual(dateAndTimeIsertedByUser)) {
                dateAndTimeIsertedByUser = dateTimeHandler();
            }
        }
        return dateAndTimeIsertedByUser;
    }
;
    
  }
