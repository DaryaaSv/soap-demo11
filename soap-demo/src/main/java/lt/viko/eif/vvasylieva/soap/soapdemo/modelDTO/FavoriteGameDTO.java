package lt.viko.eif.vvasylieva.soap.soapdemo.modelDTO;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lt.viko.eif.vvasylieva.soap.soapdemo.WebService.FavoriteGame;
import lt.viko.eif.vvasylieva.soap.soapdemo.WebService.Game;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "favoriteGame", propOrder = {
        "id",
        "game"
})
public class FavoriteGameDTO {
    @XmlElement(required = true)
    private int Id;
    @XmlElement(required = true)
    private GameDTO game;

    public FavoriteGameDTO() {
    }

    public FavoriteGameDTO(int id, GameDTO game) {
        Id = id;
        this.game = game;
    }

    public FavoriteGameDTO(FavoriteGame favoriteGame) {
        this.Id = favoriteGame.getId();
        this.game = new GameDTO(favoriteGame.getGame());
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public GameDTO getGame() {
        return game;
    }

    public void setGame(GameDTO game) {
        this.game = game;
    }
}
