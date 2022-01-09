/**
 * The Person class is a simple illustration of a basic class
 * 
 * @author J. Evan Noynaert
 * @since December 2021
 * 
 *        If the person's age is greater than 115 or less than 0 the age is set
 *        to -1.
 *        -1 is the flag for age unknown
 * 
 */

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    public Person(String firstName, String lastName) {
        this(firstName, lastName, -99);
    }

    public Person() {
        this("Anonymous", "Coward", 117);
    }

    // Getters and setters
    public void setFirstName(String inFirstName) { // Bad way to do a setter
        firstName = inFirstName;
    }

    public void setLastName(String lastName) { // Correct way to do a setter
        this.lastName = lastName;
    }

    /**
     * * If the person's age is greater than 115 or less than 0 the age is set to
     * -1.
     * -1 is the flag for age unknown
     * 
     * @param age Age must be 0 through 115. Ages outside that range are flag as age
     *            unknown.
     */
    public void setAge(int age) {
        // if(age < 0 || age > 115)
        // this.age = -1;
        // else
        // this.age = age;

        this.age = (age < 0 || age > 115) ? -1 : age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return this.lastName; // the this. is not necessary
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        String s = String.format("%s, %s", lastName, firstName);
        if (age > -1)
            s += String.format("  Age: %d", age);
        return s;
    }

    @Override
    public int compareTo(Person other) {
        int result = this.lastName.compareTo(other.lastName);
        if (result == 0) {
            result = this.firstName.compareTo(other.firstName);
        }
        if (result == 0) {
            result = this.age - other.age;
        }
        return result;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age != other.age)
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        return true;
    }

    /**
     * Checks to see if the user's age is unknown
     * 
     * @return true if the age is in the range of 0 through 115 or false if the age
     *         was out of range or not specified
     */
    public boolean ageIsKnown() {
        return age >= 0;
    }
}