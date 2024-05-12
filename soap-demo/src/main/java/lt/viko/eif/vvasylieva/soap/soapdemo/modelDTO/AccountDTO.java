package lt.viko.eif.vvasylieva.soap.soapdemo.modelDTO;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lt.viko.eif.vvasylieva.soap.soapdemo.WebService.*;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "account", propOrder = {
        "id",
        "userName",
        "password",
        "game",
        "review",
        "wishlist",
        "favoriteGame"
})
public class AccountDTO {
    @XmlElement(required = true)
    private int Id;

    @XmlElement(required = true)
    private String userName;

    @XmlElement(required = true)
    private String password;

    @XmlElement(required = true)
    private List<Game> games;

    @XmlElement(required = true)
    private List<Review> reviews;

    @XmlElement(required = true)
    private Wishlist wishlist;

    @XmlElement(required = true)
    private List<FavoriteGame> favoriteGames;

    public AccountDTO() {
    }

    public AccountDTO(Account account) {
        this.Id = account.getId();
        this.userName = account.getUserName();
        this.password = account.getPassword();
        this.games = account.getGames();
        this.reviews = account.getReviews();
        this.wishlist = account.getWishlist();
        this.favoriteGames = account.getFavoriteGames();
    }

    public AccountDTO(int id, String userName, String password, List<Game> games, List<Review> reviews, Wishlist wishlist, List<FavoriteGame> favoriteGames) {
        Id = id;
        this.userName = userName;
        this.password = password;
        this.games = games;
        this.reviews = reviews;
        this.wishlist = wishlist;
        this.favoriteGames = favoriteGames;
    }

    public String toString() {
        return String.format("\t\tUserName: %s\n\t\tPassword: %s\n", this.userName, this.password);
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public List<FavoriteGame> getFavoriteGames() {
        return favoriteGames;
    }

    public void setFavoriteGames(List<FavoriteGame> favoriteGames) {
        this.favoriteGames = favoriteGames;
    }
}

