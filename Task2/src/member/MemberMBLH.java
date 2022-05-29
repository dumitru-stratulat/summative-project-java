package member;

import booking.Booking;
import instructor.Instructor;
import java.util.List;
import java.util.Scanner;
import utils.Utils;

/**
 *
 * @author dima82.91
 */
public class MemberMBLH extends Member {

    Scanner scanner = new Scanner(System.in);

    public MemberMBLH(String fullname, String memberType) {
        super(fullname, memberType);
    }

    @Override
    public void addLesson(List<Instructor> mockInstructorsList, Member member) {
        //add lesson with instructor
        Instructor.displayInstructors(mockInstructorsList);
        System.out.println("Select instructor from list");
        int nrInsertedByUser = Utils.menuInputValidator();
        Instructor.displayInstructorTimeSlots(mockInstructorsList.get(nrInsertedByUser));
        Booking.bookingHandler(mockInstructorsList.get(nrInsertedByUser), member);
    }

}
