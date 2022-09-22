import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import java.io.Serializable;

public class Country implements Comparable<Country>, Serializable {
   //@CsvBindByName(column="entity")
    @CsvBindByPosition(position=0)
    private String name;
   @CsvBindByPosition(position=1)
    private String url;
    @CsvBindByPosition(position=2)
private String gec;
@CsvBindByPosition(position=3)
    private String iso;
@CsvBindByPosition(position=4)
    private String strang;
@CsvBindByPosition(position=5)
    private String internet;
@CsvBindByPosition(position = 6)
    private String comment;

    public Country(String name, String url, String gec, String iso, String strang, String internet, String comment) {
        this.name = name;
        this.url = url;
        this.gec = gec;
        this.iso = iso;
        this.strang = strang;
        this.internet = internet;
        this.comment = comment;
    }
    public Country(){
        String s = "???";
        setName(s);
        setUrl(s);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGec() {
        return gec;
    }

    public void setGec(String gec) {
        this.gec = gec;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getStrang() {
        return strang;
    }

    public void setStrang(String strang) {
        this.strang = strang;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString(){
        String sep = "|";
        String s = name+sep+url+sep+gec+sep+iso+sep+strang+sep+internet+sep+comment;
        return s;
    }
    @Override
    public int compareTo(Country other) {
        //return name.compareTo(other.name);
        return this.toString().compareTo(other.toString());
    }
}
