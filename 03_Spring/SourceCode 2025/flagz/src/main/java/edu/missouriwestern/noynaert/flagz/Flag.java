package edu.missouriwestern.noynaert.flagz;

public class Flag implements Comparable<Flag> {
    @Override
    public int compareTo(Flag other) {
        return this.id.compareTo(other.id);
    }

    private static int lastId = 100;
    private Integer id;
    private String fileName;
    private String description;
    public Flag() {
        this("noFile.jpg","not a file");
    }
    public Flag(String fileName, String description){
        this.id = ++lastId;
        this.fileName = fileName;
        this.description = description;
    }
    public Integer getId() {
        return id;
    }
    public String getFileName() {
        return fileName;
    }
    public String getDescription() {
        return description;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Flag{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
