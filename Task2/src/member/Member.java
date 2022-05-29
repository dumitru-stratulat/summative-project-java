package member;

import java.util.HashSet;
import instructor.Instructor;
import booking.Booking;
import java.util.Iterator;
import java.util.List;
import motorboat.MotorboatBooking;

/**
 *
 * @author dima82.91
 */
public abstract class Member {

    private final String fullname;
    private final String memberType;
    private Instructor instructor;
    HashSet<Booking> bookingsWithInstructors = new HashSet<>();
    HashSet<MotorboatBooking> motorboatHires = new HashSet<>();

    public Member(String fullname, String memberType) {
        this.fullname = fullname;
        this.memberType = memberType;
    }

    public void addMotorboatHiring(MotorboatBooking booking) {
        motorboatHires.add(booking);
    }

    public void addMockInstructor(Instructor mockInstructor) {
        this.instructor = mockInstructor;
    }

    public String getFullname() {
        return fullname;
    }

    public String getMemberType() {
        return memberType;
    }

    public Instructor getMemberInstructor() {
        return instructor;
    }

    ;
    public HashSet<MotorboatBooking> getMotorboatHires() {
        return this.motorboatHires;
    }

    public HashSet<Booking> getbookingsWithInstructors() {
        return bookingsWithInstructors;
    }

    public void displayBookingsWithInstructors() {
        if (bookingsWithInstructors.size() >= 1) {
            Iterator<Booking> it = bookingsWithInstructors.iterator();
            System.out.println("==Lesson booking details==");
            System.out.println("-----------------");
            while (it.hasNext()) {
                Booking element = it.next();
                System.out.println("Instructor name:" + element.getInstructor().getFullname());
                System.out.println("Time booked:" + element.getDateTime());
                System.out.println("Motorboat booked:" + element.getMotorboat().getName());
                System.out.println("-----------------");
            }
        } else {
            System.out.println("No lesson bookings");
        }
    }

    ;
    public void addBookingsWithInstructors(Booking booking) {
        this.bookingsWithInstructors.add(booking);
    }

    public static void displayAllMembers(List<Member> mockMembersList) {
        int index = 0;
        //display mocked members
        for (Member member : mockMembersList) {
            System.out.println(index + "." + member.getFullname());
            index++;
        }
    }

    public abstract void addLesson(List<Instructor> mockInstructorsList, Member member);

    public static void displayMembersByType(List<Member> mockMembersList, String memberType) {
        int index = 0;
        for (Member member : mockMembersList) {
            if (member.getMemberType().equals(memberType)) {
                if (member.getbookingsWithInstructors().size() < 3) {
                    System.out.println(index + "." + member.getFullname());
                    index++;
                } else {
                    System.out.println("Member reached the limit");
                }
            }
        }
    }

    public static Member getMemberByType(List<Member> mockMembersList, String memberType, int memberNr) {
        int index = 0;
        for (Member member : mockMembersList) {
            if (member.getMemberType().equals(memberType)) {
                if (member.getbookingsWithInstructors().size() < 3) {
                    System.out.println(index + "." + member.getFullname());
                    if (index == memberNr) {
                        return member;
                    }
                    index++;
                }
                return member;
            }
        }
        throw new RuntimeException("Error:Wrong nr");
    }

    public static Member displayMember(Member member) {
        System.out.println("-----------------");
        System.out.println("Selected member is:" + member.getFullname());
        System.out.println("Selected member is:" + member.getMemberType());
        System.out.println("-----------------");
        return member;
    }
}
