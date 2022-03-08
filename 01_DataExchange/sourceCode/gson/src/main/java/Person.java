public class Person {
    private Name name;
    private int age;
    public Person(Name name, int age){
        setName(name);
        setAge(age);
    }
    public Person(String first, String last, int age){
        setName(new Name(first, last));
        setAge(age);
    }
    public Person(){
        this("","",-1);
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString(){
        String s = String.format("%-20s Age: %3d", name, age);
        return s;
    }
}

