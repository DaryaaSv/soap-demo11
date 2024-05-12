package lt.viko.eif.vvasylieva.soap.soapdemo.modelDTO;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lt.viko.eif.vvasylieva.soap.soapdemo.WebService.Game;
import lt.viko.eif.vvasylieva.soap.soapdemo.WebService.Review;
import org.apache.fop.afp.goca.GraphicsAreaEnd;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "review", propOrder = {
        "id",
        "game",
        "reviewText",
        "rating"
})
public class ReviewDTO {
    @XmlElement(required = true)
    private int Id;

    @XmlElement(required = true)
    private GameDTO game;

    @XmlElement(required = true)
    private String reviewText;

    @XmlElement(required = true)
    private double rating;

    public ReviewDTO() {
    }

    public ReviewDTO(GameDTO game, String reviewText, double rating) {
        this.game = game;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public ReviewDTO(int id, GameDTO game, String reviewText, double rating) {
        this.Id = id;
        this.game = game;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public ReviewDTO(Review review) {
        this.Id = review.getId();
        this.game = new GameDTO(review.getGame());
        this.reviewText = review.getReviewText();
        this.rating = review.getRating();
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

