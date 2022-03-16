/**
 * The name file is a sub-class of Person. It reverses the first name and last
 * name.
 */

public class Name {
    String first;
    String last;

    public Name(String first, String last) {
        setFirst(first);
        setLast(last);
    }

    public Name() {
        this("?First?", "?Last?");
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        String s = last + ", " + first;
        return s;
    }
}
