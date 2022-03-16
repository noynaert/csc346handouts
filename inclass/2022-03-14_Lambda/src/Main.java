import java.util.ArrayList;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        ArrayList<Double> numbers = new ArrayList<>();
        numbers.add(-1.);
        numbers.add(2.14);
        numbers.add(0.0);
        numbers.add(Math.PI);
        numbers.add(Math.random());

//        for(Double number: numbers){
//            System.out.println(number);
//        }
       // Consumer<Double> printer = (x) -> {System.out.println(x);};

        // You don't need () if there is exactly 1 argument
        //Consumer<Double> printer = x -> {System.out.println(x);};

        // You don't need {} if there is only one expression that returns a value
        Consumer<Double> printer = x -> System.out.println(x);
        // Consumer<Double> square = x -> x*x;

        numbers.forEach(printer);

        System.out.println("Now for squares");
        ArrayList<Double> squares = new ArrayList<>();

        numbers.forEach(y -> squares.add(y*y));
        squares.forEach(printer);

        //System.out.println( () -> "I got nothin." );
    }
    public static void xprinter(Double x){
        System.out.println(x);
    }
}

