public class Name extends Object {
    private String first;
    private String last;
    private String middle;

    public Name(String first, String last, String middle) {
//        this.first = first;
//        this.last = last;
//        this.middle = middle;
        setFirst(first);
        setLast(last);
        setMiddle(middle);
    }
    public Name(String first, String last){
        this(first, last, "");
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    @Override
    public String toString(){
        String result = String.format("%s, %s %s" ,last, first, middle).trim();
        return result;
    }
}
