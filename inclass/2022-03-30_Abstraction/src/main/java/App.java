import com.noynaert.csc346.inheritance.people.*;

import java.util.HashMap;
import java.util.Map;

/**
 * todo: PROGRAM DESCRIPTION
 *
 * @author: YOUR NAME
 * @since: MONTH YEAR program is started
 */

public class App {
    public static void main(String[] args){
        Person pn = new Person("x","y");
        pn.setName("Max Griffon");
        pn.setNumber("G00000000");

        System.out.println(pn);

        Student stu = new Student();
        stu.setName("Maxine Griffon");
        stu.setNumber("G00000001");

        System.out.println(stu);

        System.out.println( "CompareTo:" +pn.compareTo(stu));

        Person p2 = new Student();  //works because Student isa Person
        //Student s2 = new Person(); //does not work because a person is not a student

        Map<String,Person> m = new HashMap<>();
        m.put(pn.getNumber(), pn);
        m.put(stu.getNumber(), stu);
        m.put("Fred", new Person("Fred","G99999999"));
        m.put("Barney", new Student("Barney", "G99999997", 4.000));
        System.out.println("\nDone!");
    }
    public static void print(){
        System.out.println("I am in App");
    }
}
