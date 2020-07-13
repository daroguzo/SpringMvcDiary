package spring.diary.dto;

public class Diary {

    private Long id;

    private String owner;

    private String name;

    private String content;

    private String date;

    private String imageFile;


    public Diary() {
    }

    public Diary(String owner, String name, String content, String date, String imageFile) {
        this.owner = owner;
        this.name = name;
        this.content = content;
        this.date = date;
        this.imageFile = imageFile;
    }

    public Diary(Diary element){
        this.id = element.id;
        this.owner = element.owner;
        this.name = element.name;
        this.content = element.content;
        this.date = element.date;
        this.imageFile = element.imageFile;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }
}
