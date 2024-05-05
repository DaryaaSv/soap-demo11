package lt.viko.eif.vvasylieva.soap.soapdemo.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "game"
)
public class Game {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "id"
    )
    private int Id;
    private String title;
    private String description;
    private String genre;

    public Game() {
    }

    public Game(String title, String description, String genre) {
        this.title = title;
        this.description = description;
        this.genre = genre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
