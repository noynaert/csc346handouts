import java.time.LocalDate;

public class Person {
    private Name name;    // hasa
    private LocalDate birthdate;

    public Person(){
        this("", "Anonymous", "", null);
    }
    public Person(Name name, LocalDate birthdate){
        setName(name);
        setBirthdate(birthdate);
    }
    public Person(String first, String last, String middle, String date){
        this(new Name(first, last, middle), null);
        String[] parts = date.split("-");
        try{
            int year   = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);
            LocalDate d = LocalDate.of(year, month, day);
            setBirthdate(d);
        }catch(Exception e){}


    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String toString(){
        String result = String.format( "%s", name.toString().trim());
        if(birthdate != null){
            result += String.format(" born on %s", birthdate);
        }

        return result;
    }
}
