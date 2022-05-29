package member;

import java.util.LinkedList;
import java.util.List;
import instructor.InstructorsMock;
import instructor.Instructor;

/**
 *
 * @author dima82.91
 */
public class MembersMock {

    List<Member> members;
    List<Instructor> instructorsList;

    public List<Member> getMembers() {
        instructorsList = new InstructorsMock().getInstructors();

        members = new LinkedList<>();
        members.add(new MemberNovice("Dumitru Stratulat", "novice"));
        members.add(new MemberNovice("Dumitru Pascanean", "novice"));
        members.add(new MemberNovice("Andrew Tirnavschi", "novice"));
        members.add(new MemberMBLH("Pavel Gorodetschi", "mblh"));
        members.add(new MemberMBLH("Nicolae Sarbu", "mblh"));
        members.add(new MemberMBLH("James Bond", "mblh"));
        return members;
    }
;
}
