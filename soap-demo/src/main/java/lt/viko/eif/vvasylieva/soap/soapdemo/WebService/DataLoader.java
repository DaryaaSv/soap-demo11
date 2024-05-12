package lt.viko.eif.vvasylieva.soap.soapdemo.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * DataLoader class is responsible for loading initial data into the application database upon startup.
 * It initializes and saves sample data including games, reviews, wishlists, favorite games, and accounts.
 */
@Component
public class DataLoader {

    @Autowired
    private AccountJpaRepository accountJpaRepository;

    /**
     * Constructor for DataLoader class.
     * @param accountJpaRepository An instance of AccountJpaRepository for saving account data.
     */
    @Autowired
    public DataLoader(AccountJpaRepository accountJpaRepository){
        this.accountJpaRepository = accountJpaRepository;
        loadAccounts();
    }

    /**
     * Helper method to load sample accounts and associated data into the database.
     * It creates instances of games, reviews, wishlists, favorite games, and accounts, and then saves them using the provided repository.
     */
    private void loadAccounts(){
        // Creating sample games
        Game game1 = new Game("The Witcher 3: Wild Hunt", "An action RPG with a vast open world and rich storytelling.", "Action, RPG");
        Game game2 = new Game("Red Dead Redemption 2", "An epic Western-themed action-adventure game set in an open world.", "Action, Adventure");
        Game game3 = new Game("The Legend of Zelda: Breath of the Wild", "A critically acclaimed action-adventure game with open-world exploration.", "Action, Adventure");
        Game game4 = new Game("Horizon Zero Dawn", "A post-apocalyptic action RPG with a unique blend of primitive and futuristic elements.", "Action, Adventure, RPG");
        Game game5 = new Game("Grand Theft Auto V", "An open-world action-adventure game set in the fictional state of San Andreas.", "Action, Adventure");
        Game game6 = new Game("Dark Souls III", "A challenging action RPG known for its punishing difficulty and intricate level design.", "Action, RPG");
        Game game7 = new Game("Minecraft", "A sandbox video game that allows players to build and explore virtual worlds.", "Adventure");
        Game game8 = new Game("Super Mario Odyssey", "A platform game featuring Mario's quest to save Princess Peach from Bowser.", "Platformer, Adventure");
        Game game9 = new Game("Overwatch", "A team-based multiplayer first-person shooter game with diverse characters and abilities.", "FPS");
        Game game10 = new Game("Fortnite", "A battle royale game where players compete to be the last one standing in a shrinking map.", "Battle Royale, Shooter");

        // Creating sample reviews
        Review review1 = new Review(game1, "Great game!", 4.5);
        Review review2 = new Review(game2, "Nice storyline.", 4.0);
        Review review3 = new Review(game3, "Challenging puzzles.", 4.2);
        Review review4 = new Review(game4, "Amazing RPG experience.", 4.8);
        Review review5 = new Review(game5, "Realistic simulation.", 4.3);

        // Creating a sample wishlist
        Wishlist wishlist1 = new Wishlist("My Wishlist", List.of(game6, game7));

        // Creating sample favorite games
        FavoriteGame favoriteGame1 = new FavoriteGame(game1);
        FavoriteGame favoriteGame2 = new FavoriteGame(game3);
        FavoriteGame favoriteGame3 = new FavoriteGame(game4);

        // Creating a sample account with associated data
        Account account1 = new Account("john23", "password123",
                List.of(game1, game2, game3, game4, game5,game8, game9, game10),
                List.of(review1, review2, review3, review4, review5),
                wishlist1,
                List.of(favoriteGame1, favoriteGame2, favoriteGame3));

        // Saving the sample account to the database
        accountJpaRepository.save(account1);
    }
}

