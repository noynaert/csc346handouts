import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<String, LocalDate> people = new TreeMap<>();
        people.put("Dave", LocalDate.of(2000, 04, 03));
        people.put("Zeek", LocalDate.of(2000, 8, 9));
        people.put("Pam", LocalDate.of(1986, 9, 26));
        people.put("Mary", LocalDate.of(1988, 5, 14));
        people.put("Steve", LocalDate.of(2002, 07, 8));
        people.put("Abe", LocalDate.of(1970, 01, 01));
        people.put("Aaron", LocalDate.of(1970, 01, 01));
        people.put("Dick", LocalDate.of(2001, 12, 12));
        people.put("Tom", LocalDate.of(1992, 6, 7));
        people.put("Harry", LocalDate.of(2000, 8, 9));
        people.put("Alice", LocalDate.of(2000, 8, 9));
        people.put("Marty", LocalDate.of(1999, 4, 04));
        people.put("Chris", LocalDate.of(2000, 7, 8));
        people.put("Jan", LocalDate.of(2002, 8, 3));
        people.put("June", LocalDate.of(1990, 9, 12));
        people.put("Janet", LocalDate.of(1984, 03, 02));

        print(people);
        printByBirthdate(people);
        System.out.println("Hello world!");

        String jackpot =
    }

    public static <K, V> void print(Map<K, V> map) {
//        System.out.println("-----Printed with for()");
//        //var keys = map.keySet() ;
//        for(K key: map.keySet()){
//            printOne(key, map.get(key));
//        }

        System.out.println("Printing with a foreach() iterator");
        map.forEach((name, birthdate) -> {
            System.out.printf("%20d\t%s has a birthday on %s\n", name.hashCode(), name, birthdate);
        });
//lamba expression
    }

    public static void printOne(Object name, Object birthDay) {
        System.out.printf("%s has a birthday on %s\n", name, birthDay);
    }

    public static void printByBirthdate(Map<String, LocalDate> map) {
        ArrayList<LocalDate> birthDays = new ArrayList<>();

        //Make an arraylist of the birthdays, eliminating duplicates
        map.forEach((name, birthdate) -> {
            if (!birthDays.contains(birthdate)) {
                birthDays.add(birthdate);
            }
            //System.out.println(birthDays.size());
        });
        Collections.sort(birthDays);

//
        //birthDays.forEach(birthdate ->  System.out.println(birthdate));
        birthDays.forEach((birthdate) ->{
           System.out.println(birthdate);

           //now print everyone who was born on that date.
           map.forEach( (name, date ) -> {
               if(birthdate.equals(date)){
                   System.out.printf("\t%s\n",name);
               }
            });
        });


    }
    //
}
