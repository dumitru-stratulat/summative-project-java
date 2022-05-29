package menu;

import java.util.List;
import java.util.Scanner;
import member.Member;
import instructor.Instructor;
import member.MembersMock;
import instructor.InstructorsMock;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import motorboat.Motorboat;
import motorboat.MotorboatMock;
import utils.Utils;

/**
 *
 * @author dima82.91
 */
public class Menu {

    static Scanner scanner = new Scanner(System.in);
    //declaring lists static to ensure no lists are created when creating a new menu object.
    static List<Member> mockMembersList;
    static List<Instructor> mockInstructorsList;
    static List<Motorboat> mockMotorboatList;
    static LocalDateTime localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.HOURS);
    static Member member;

    public Menu() {
        mockAllSchedule();
    }

    //mocking time slots, combining the classes with each other because
    private static void mockAllSchedule() {
        MembersMock mockMembersImplementationObject = new MembersMock();
        mockMembersList = mockMembersImplementationObject.getMembers();

        InstructorsMock mockInstructorsObject = new InstructorsMock();
        mockInstructorsList = mockInstructorsObject.getInstructors();

        MotorboatMock motorboatMockObject = new MotorboatMock();
        mockMotorboatList = motorboatMockObject.getMotorboats();

        LocalDateTime nextMonday = localDateTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        LocalDateTime nextTuesday = localDateTime.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        LocalDateTime nextWednesday = localDateTime.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        //add mock bookings
        mockInstructorsObject.addMockBooking(mockMembersList.get(0), nextMonday.withHour(10), mockInstructorsList.get(0), mockMotorboatList.get(8));
        mockInstructorsObject.addMockBooking(mockMembersList.get(0), nextTuesday.withHour(10), mockInstructorsList.get(0), mockMotorboatList.get(8));
        mockInstructorsObject.addMockBooking(mockMembersList.get(0), nextWednesday.withHour(10), mockInstructorsList.get(0), mockMotorboatList.get(8));
        mockInstructorsObject.addMockBooking(mockMembersList.get(1), nextTuesday.withHour(14), mockInstructorsList.get(1), mockMotorboatList.get(9));
        mockInstructorsObject.addMockBooking(mockMembersList.get(2), nextTuesday.withHour(14), mockInstructorsList.get(2), mockMotorboatList.get(4));
        //add mock instructrs
        mockMembersList.get(0).addMockInstructor(mockInstructorsList.get(0));
        mockMembersList.get(1).addMockInstructor(mockInstructorsList.get(1));
        mockMembersList.get(2).addMockInstructor(mockInstructorsList.get(2));
        //add mock motorboat hire
        Motorboat.motorboatBooking(mockMotorboatList.get(4), nextTuesday.withHour(14), mockMembersList.get(3));
        Motorboat.motorboatBooking(mockMotorboatList.get(3), nextTuesday.withHour(14), mockMembersList.get(4));
    }

    public static List<Member> getMockMembersList() {
        return mockMembersList;
    }

    public static List<Motorboat> getMockMotorboatList() {
        return mockMotorboatList;
    }

    public void displayMenu() {
        System.out.println("========Menu========");
        System.out.println("1.Add lesson");
        System.out.println("2.List motorboats");
        System.out.println("3.List mblh members to hire motorboat");
        System.out.println("4.List instructors");
        System.out.println("5.List members");
        System.out.println("0.Exit");

        int menuChoice = Utils.menuInputValidator();
        switch (menuChoice) {
            case 1:
                Member.displayAllMembers(mockMembersList);
                System.out.println();
                System.out.println("Select member:");
                int memberNr = Utils.menuInputValidator();
                member = Member.displayMember(mockMembersList.get(memberNr));
                //check if reached the limit
                if (member.getbookingsWithInstructors().size() >= 2) {
                    System.out.println("Member reached the limit");
                    displayMenu();
                }
                member.addLesson(mockInstructorsList, member);
                displayMenu();
                break;
            case 2:
                Motorboat.displayAllMotorboats(mockMotorboatList);
                System.out.println("Select motorboat to display info:");
                int nrInsertedByUser = Utils.menuInputValidator();
                Motorboat.displayMotorboat(mockMotorboatList.get(nrInsertedByUser));
                displayMenu();
                break;
            case 3:
                Member.displayMembersByType(mockMembersList, "mblh");
                System.out.println("Select mblh member");
                nrInsertedByUser = Utils.menuInputValidator();
                member = Member.getMemberByType(mockMembersList, "mblh", nrInsertedByUser);
                System.out.println("==Motorboat hire==");
                //prompt user to enter date time
                LocalDateTime dateAndTimeIsertedByUser = Utils.dateTimeHandler();
                boolean isOverBooked = Motorboat.checkIfMotorboatAlreadyBooked(member, dateAndTimeIsertedByUser);
                if (isOverBooked) {
                    displayMenu();
                }
                Motorboat.displayAvailableMotorboats(dateAndTimeIsertedByUser, member, mockMotorboatList);
                //select motorboat from list
                System.out.println("Insert nr of available motorboat for booking!");
                nrInsertedByUser = Utils.menuInputValidator() - 1;//list starts from 0 but motorboat nr starts from 1
                Motorboat.motorboatBooking(mockMotorboatList.get(nrInsertedByUser), dateAndTimeIsertedByUser, member);
                System.out.println("=Motorboat succesfully booked for hire!=");
                displayMenu();
                break;
            case 4:
                Instructor.displayInstructors(mockInstructorsList);
                System.out.println("Select instructor from list");
                nrInsertedByUser = Utils.menuInputValidator();
                Instructor.displayInstructorBookings(mockInstructorsList.get(nrInsertedByUser));
                displayMenu();
                break;
            case 5:
                //5.List members
                Member.displayAllMembers(mockMembersList);
                System.out.println("-----------------");
                System.out.println("Select member to display details:");
                nrInsertedByUser = Utils.menuInputValidator();
                member = Member.displayMember(mockMembersList.get(nrInsertedByUser));
                member.displayBookingsWithInstructors();
                displayMenu();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("Please enter valid number");
                displayMenu();
        }
    }

}
