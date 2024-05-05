package lt.viko.eif.vvasylieva.soap.soapdemo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "wishlist"
)
public class Wishlist {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "id"
    )
    private int Id;
    private String wishlistName;
    @OneToMany(
            targetEntity = Game.class,
            cascade = {CascadeType.ALL}
    )
    private List<Game> games = new ArrayList<>();

    public Wishlist() {
    }

    public Wishlist(String wishlistName, List<Game> games) {
        this.wishlistName = wishlistName;
        this.games = games;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getWishlistName() {
        return wishlistName;
    }

    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
