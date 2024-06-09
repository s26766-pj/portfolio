package pl.pjatk.demo.model;

public class Movie {
    private Integer id;
    private String title;
    private Category category;
    private boolean isAvailable;

    public Movie() {}

    public Movie(Integer id, String title, Category category, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.isAvailable = isAvailable;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }
}