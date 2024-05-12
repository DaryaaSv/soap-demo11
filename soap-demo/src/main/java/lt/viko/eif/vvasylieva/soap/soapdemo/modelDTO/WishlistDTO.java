package lt.viko.eif.vvasylieva.soap.soapdemo.modelDTO;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lt.viko.eif.vvasylieva.soap.soapdemo.WebService.Game;
import lt.viko.eif.vvasylieva.soap.soapdemo.WebService.Wishlist;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wishlist", propOrder = {
        "id",
        "wishlistName",
        "game"
})
public class WishlistDTO {
    @XmlElement(required = true)
    private int Id;

    @XmlElement(required = true)
    private String wishlistName;

    @XmlElement(required = true)
    private List<Game> games = new ArrayList<>();

    public WishlistDTO() {
    }

    public WishlistDTO(int id, String wishlistName, List<Game> games) {
        Id = id;
        this.wishlistName = wishlistName;
        this.games = games;
    }

    public WishlistDTO(Wishlist wishlist) {
        this.Id = wishlist.getId();
        this.wishlistName = wishlist.getWishlistName();
        this.games = wishlist.getGames();
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