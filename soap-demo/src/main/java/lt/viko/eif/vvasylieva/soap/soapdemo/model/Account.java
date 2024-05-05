package lt.viko.eif.vvasylieva.soap.soapdemo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(
        name = "account"
)
public class Account {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "id"
    )
    private int Id;
    private String userName;
    private String password;
    @OneToMany(
            targetEntity = Game.class,
            cascade = {CascadeType.ALL}
    )
    private List<Game> games;
    @OneToMany(
            targetEntity = Review.class,
            cascade = {CascadeType.ALL}
    )
    private List<Review> reviews;
    @OneToOne(
            targetEntity = Wishlist.class,
            cascade = {CascadeType.ALL}
    )
    private Wishlist wishlist;
    @OneToMany(
            targetEntity = FavoriteGame.class,
            cascade = {CascadeType.ALL}
    )
    private List<FavoriteGame> favoriteGames;

    public Account() {
    }

    public Account(String userName, String password, List<Game> games, List<Review> reviews, Wishlist wishlist, List<FavoriteGame> favoriteGames) {
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

