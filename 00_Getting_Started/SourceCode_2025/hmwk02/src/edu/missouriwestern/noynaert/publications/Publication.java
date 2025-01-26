package edu.missouriwestern.noynaert.publications;

public class Publication extends Book {
    int year;

    public Publication(){
        super();
    }

    public Publication(String title, int year, int pages){
        super(title,pages);
        setYear(year);
    }
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString(){
        String result = super.toString();
        result += String.format(", Year: %d", year);
        return result;
    }
}
