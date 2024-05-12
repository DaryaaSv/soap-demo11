package lt.viko.eif.vvasylieva.soap.soapdemo.modelDTO;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lt.viko.eif.vvasylieva.soap.soapdemo.WebService.*;

import java.util.List;
import java.util.stream.Collectors;

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
    private List<GameDTO> games;

    @XmlElement(required = true)
    private List<ReviewDTO> reviews;

    @XmlElement(required = true)
    private WishlistDTO wishlist;

    @XmlElement(required = true)
    private List<FavoriteGameDTO> favoriteGames;

    public AccountDTO() {
    }

    public AccountDTO(Account account) {
        this.Id = account.getId();
        this.userName = account.getUserName();
        this.password = account.getPassword();
        this.games = account.getGames().stream()
                .map(GameDTO::new)
                .collect(Collectors.toList());
        this.reviews = account.getReviews().stream()
                .map(ReviewDTO::new)
                .collect(Collectors.toList());
        this.wishlist = new WishlistDTO(account.getWishlist());
        this.favoriteGames = account.getFavoriteGames().stream()
                .map(FavoriteGameDTO ::new)
                .collect(Collectors.toList());
    }

    public AccountDTO(int id, String userName, String password, List<GameDTO> games, List<ReviewDTO> reviews, WishlistDTO wishlist, List<FavoriteGameDTO> favoriteGames) {
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

    public List<GameDTO> getGames() {
        return games;
    }

    public void setGames(List<GameDTO> games) {
        this.games = games;
    }

    public List<ReviewDTO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewDTO> reviews) {
        this.reviews = reviews;
    }

    public WishlistDTO getWishlist() {
        return wishlist;
    }

    public void setWishlist(WishlistDTO wishlist) {
        this.wishlist = wishlist;
    }

    public List<FavoriteGameDTO> getFavoriteGames() {
        return favoriteGames;
    }

    public void setFavoriteGames(List<FavoriteGameDTO> favoriteGames) {
        this.favoriteGames = favoriteGames;
    }
}

