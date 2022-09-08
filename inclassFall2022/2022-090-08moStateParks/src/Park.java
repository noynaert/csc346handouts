public class Park {
    private String name;
    private String county;
    private double acres;
    private int yearEstablished;

    public Park(String name, String county, double acres, int yearEstablished) {
       setName(name);
       setCounty(county);
       setAcres(acres);
       setYearEstablished(yearEstablished);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county.trim();
    }

    public double getAcres() {
        return acres;
    }

    public void setAcres(double acres) {
        this.acres = acres;
    }

    public int getYearEstablished() {
        return yearEstablished;
    }

    public void setYearEstablished(int yearEstablished) {
        this.yearEstablished = yearEstablished;
    }
    @Override
    public String toString() {
        String s = String.format("%-35s %-30s %10.1f acres Established in %4d",name, county,acres,yearEstablished);
        return s;
    }
}
