public class Employee  extends Person{
    public static double MINIMUM_WAGE = 15.00;
    private double salary = MINIMUM_WAGE;

    public Employee(){
        super("???","???", "", "1900-01-01");
    }

    public void setSalary(double amount){
        salary = amount;
    }

    public double getSalary(){
        return salary;
    }

    @Override
    public String toString(){
        String result = super.toString();
        result += String.format(" $%1.2f", salary);
        return result;
    }

}
