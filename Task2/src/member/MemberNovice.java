package member;

import booking.Booking;
import instructor.Instructor;
import java.util.List;

/**
 *
 * @author dima82.91
 */
public class MemberNovice extends Member {

    public MemberNovice(String fullname, String memberType) {
        super(fullname, memberType);
    }

    @Override
    public void addLesson(List<Instructor> mockInstructorsList, Member member) {
        //add lesson with instructr
        Instructor.displayInstructorTimeSlots(member.getMemberInstructor());
        Booking.bookingHandler(member.getMemberInstructor(), member);
    }
}
