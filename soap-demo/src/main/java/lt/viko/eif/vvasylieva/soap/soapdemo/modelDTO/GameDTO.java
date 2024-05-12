package lt.viko.eif.vvasylieva.soap.soapdemo.modelDTO;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lt.viko.eif.vvasylieva.soap.soapdemo.WebService.Game;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "game", propOrder = {
        "id",
        "title",
        "description",
        "genre"
})
public class GameDTO {
    @XmlElement(required = true)
    private int Id;

    @XmlElement(required = true)
    private String title;

    @XmlElement(required = true)
    private String description;

    @XmlElement(required = true)
    private String genre;

    public GameDTO() {
    }

    public GameDTO(int id, String title, String description, String genre) {
        this.Id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
    }

    public GameDTO(Game game) {
        this.Id = game.getId();
        this.title = game.getTitle();
        this.description = game.getDescription();
        this.genre = game.getGenre();
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


