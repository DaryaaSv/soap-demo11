package lt.viko.eif.vvasylieva.soap.soapdemo.db;

import lt.viko.eif.vvasylieva.soap.soapdemo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader {
    private AccountJpaRepository accountJpaRepository;

    @Autowired
    public DataLoader(AccountJpaRepository accountJpaRepository){
        this.accountJpaRepository = accountJpaRepository;
        loadAccounts();
    }

    private void loadAccounts(){
        Game game1 = new Game("The Witcher 3: Wild Hunt", "An action RPG with a vast open world and rich storytelling.",
                "Action, RPG");
        Game game2 = new Game("Red Dead Redemption 2", "An epic Western-themed action-adventure game set in an open world.",
                "Action, Adventure");
        Game game3 = new Game("The Legend of Zelda: Breath of the Wild", "A critically acclaimed action-adventure game with open-world exploration.",
                "Action, Adventure");
        Game game4 = new Game("Horizon Zero Dawn", "A post-apocalyptic action RPG with a unique blend of primitive and futuristic elements.",
                "Action, Adventure, RPG");
        Game game5 = new Game("Grand Theft Auto V", "An open-world action-adventure game set in the fictional state of San Andreas.",
                "Action, Adventure");
        Game game6 = new Game("Dark Souls III", "A challenging action RPG known for its punishing difficulty and intricate level design.",
                "Action, RPG");
        Game game7 = new Game("Minecraft", "A sandbox video game that allows players to build and explore virtual worlds.",
                "Adventure");
        Game game8 = new Game("Super Mario Odyssey", "A platform game featuring Mario's quest to save Princess Peach from Bowser.",
                "Platformer, Adventure");
        Game game9 = new Game("Overwatch", "A team-based multiplayer first-person shooter game with diverse characters and abilities.",
                "FPS");
        Game game10 = new Game("Fortnite", "A battle royale game where players compete to be the last one standing in a shrinking map.",
                "Battle Royale, Shooter");

        Review review1 = new Review(game1, "Great game!", 4.5);
        Review review2 = new Review(game2, "Nice storyline.", 4.0);
        Review review3 = new Review(game3, "Challenging puzzles.", 4.2);
        Review review4 = new Review(game4, "Amazing RPG experience.", 4.8);
        Review review5 = new Review(game5, "Realistic simulation.", 4.3);

        Wishlist wishlist1 = new Wishlist("My Wishlist", List.of(game6, game7));

        FavoriteGame favoriteGame1 = new FavoriteGame(game1);
        FavoriteGame favoriteGame2 = new FavoriteGame(game3);
        FavoriteGame favoriteGame3 = new FavoriteGame(game4);

        Account account1 = new Account("john23", "password123", List.of(game1, game2, game3, game4, game5,game8, game9, game10), List.of(review1, review2, review3, review4, review5), wishlist1, List.of(favoriteGame1, favoriteGame2, favoriteGame3));

        accountJpaRepository.save(account1);
    }

}
