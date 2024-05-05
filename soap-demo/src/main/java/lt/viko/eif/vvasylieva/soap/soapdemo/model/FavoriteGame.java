package lt.viko.eif.vvasylieva.soap.soapdemo.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "favorite_game"
)
public class FavoriteGame {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "id"
    )
    private int Id;
    @OneToOne(
            targetEntity = Game.class,
            cascade = {CascadeType.ALL}
    )
    private Game game;

    public FavoriteGame() {
    }

    public FavoriteGame(Game game) {
        this.game = game;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
