import java.util.Objects;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private String city;
    private String state;

    public Person(String firstName, String lastName, String city, String state) {
        setCity(city);
        setFirstName(firstName);
        setLastName(lastName);
        setState(state);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String toString(){
        String result = String.format("%-20s %s", lastName+ ", "+ firstName,city+", "+state);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person people = (Person) o;
        return getFirstName().equals(people.getFirstName()) && getLastName().equals(people.getLastName()) && getCity().equals(people.getCity()) && getState().equals(people.getState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getCity(), getState());
    }

    @Override
    public int compareTo(Person o) {
        int result = 0;
        result = this.lastName.compareTo(o.lastName);
        if( result == 0)
            result = this.firstName.compareTo(o.lastName);
        return result;
    }
}
