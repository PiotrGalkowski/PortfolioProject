package pl.javaprogrammer.portfolio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class About {

    @Id
    @GeneratedValue
    private int id;
    private String description;

    public About() {
    }

    public About(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "About{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
