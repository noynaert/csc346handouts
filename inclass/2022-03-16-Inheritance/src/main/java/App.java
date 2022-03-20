import edu.missouriwestern.csc346.noynaert.courses.*;

import java.util.ArrayList;

/**
 * todo: PROGRAM DESCRIPTION
 *
 * @author: YOUR NAME
 * @since: MONTH YEAR program is started
 */

public class App {
    public static void main(String[] args){
        Course  course= new Undergraduate();
        ArrayList<Course> department = new ArrayList<>();
        department.add(new Undergraduate());
        department.add(new Graduate());
        //department.add(new Section());  //hasa relationship, not an isa relationship.
        System.out.println("\nDone!");
    }
}
