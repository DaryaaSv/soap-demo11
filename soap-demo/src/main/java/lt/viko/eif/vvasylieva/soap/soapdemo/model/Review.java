package lt.viko.eif.vvasylieva.soap.soapdemo.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "review"
)
public class Review {
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
    private String reviewText;
    private double rating;

    public Review() {
    }

    public Review(Game game, String reviewText, double rating) {
        this.game = game;
        this.reviewText = reviewText;
        this.rating = rating;
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

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
