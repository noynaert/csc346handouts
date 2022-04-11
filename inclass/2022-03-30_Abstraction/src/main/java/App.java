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

        Student stu = new Student("Joe Cool", "G00000007", 2.000, 55);
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
        m.put("Barney", new Student("Barney", "G99999997", 4.000, 99));

        //demonstrate Exceptions

        Person[] people = new Person[10];
        try {
            people[9] = pn;
            char ch = pn.getName().charAt(0);
        }catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Array index out of bounds." +e.getMessage());
        }catch(StringIndexOutOfBoundsException e){
            System.err.println("STRING index is out of bounds." + e.getMessage());
        }
        int i;
        try {
            i = 99 / 0;
            System.out.println("I is " +i);
            people[999] = pn;
            char ch = pn.getName().charAt(99);
        }catch(ArithmeticException e){
            i = Integer.MAX_VALUE;
        }catch(Exception e) {
            System.err.println("Either the array or string subscript is out of bounds, "
                               +"but I do not know which. "+ e.getMessage()
            );
        }finally{
            //a sample of something that would appear in a finally{} clause would be closing a stream
            //another example would be logging.
            System.out.println("I survived the exceptions");
        }
        System.out.println("\nDone!");
    }
    public static void print(){
        System.out.println("I am in App");
    }
}
