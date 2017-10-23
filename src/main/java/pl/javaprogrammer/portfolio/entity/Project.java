package pl.javaprogrammer.portfolio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;


@Entity
public class Project {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String image;
    private String technologies;
    private String description;
    private String author;
    private String date;

    public Project() {

    }

    public Project(String name, String image, String technologies, String description, String author, String date) {
        this.name = name;
        this.image = image;
        this.technologies = technologies;
        this.description = description;
        this.author = author;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", technologies='" + technologies + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                '}';
    }
}
