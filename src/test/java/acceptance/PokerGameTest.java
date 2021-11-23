package acceptance;

import fr.zbar.kata.pokerkata.PokerGame;
import fr.zbar.kata.pokerkata.ext.PokerParser;
import fr.zbar.kata.pokerkata.model.card.Card;
import fr.zbar.kata.pokerkata.model.card.Rank;
import fr.zbar.kata.pokerkata.model.card.Suit;
import fr.zbar.kata.pokerkata.model.hand.StartingHand;
import fr.zbar.kata.pokerkata.model.player.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.mock;
import static org.mockito.BDDMockito.when;

@ExtendWith(MockitoExtension.class)
public class PokerGameTest {

    private final PokerParser parser = mock(PokerParser.class);
    private final PokerGame game = new PokerGame(parser);

    @Test
    void should_have_winner_white_with_high_card() {
        String input = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH";
        Player black = new Player(
                "Black",
                new StartingHand(
                        new Card(Rank.TWO, Suit.HEARTS),
                        new Card(Rank.THREE, Suit.DIAMONDS),
                        new Card(Rank.FIVE, Suit.SPADES),
                        new Card(Rank.NINE, Suit.CLUBS),
                        new Card(Rank.KING, Suit.DIAMONDS)
                )
        );
        Player white = new Player(
                "White",
                new StartingHand(
                        new Card(Rank.TWO, Suit.CLUBS),
                        new Card(Rank.THREE, Suit.HEARTS),
                        new Card(Rank.FOUR, Suit.SPADES),
                        new Card(Rank.EIGHT, Suit.CLUBS),
                        new Card(Rank.ACE, Suit.HEARTS)
                )
        );
        String expected = "White wins. - with high card: Ace";
        when(parser.parse(input))
                .thenReturn(List.of(black, white));

        String result = game.result(input);

        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void should_have_winner_black_with_pair_of_king() {
        String input = "Black: 2H 2D KS 9C KD  White: 5C 5H 4S 8C AH";
        Player black = new Player(
                "Black",
                new StartingHand(
                        new Card(Rank.TWO, Suit.HEARTS),
                        new Card(Rank.TWO, Suit.DIAMONDS),
                        new Card(Rank.KING, Suit.SPADES),
                        new Card(Rank.NINE, Suit.CLUBS),
                        new Card(Rank.KING, Suit.DIAMONDS)
                )
        );
        Player white = new Player(
                "White",
                new StartingHand(
                        new Card(Rank.FIVE, Suit.CLUBS),
                        new Card(Rank.FIVE, Suit.HEARTS),
                        new Card(Rank.FOUR, Suit.SPADES),
                        new Card(Rank.EIGHT, Suit.CLUBS),
                        new Card(Rank.ACE, Suit.HEARTS)
                )
        );
        String expected = "Black wins. - with pair of: King";
        when(parser.parse(input))
                .thenReturn(List.of(black, white));

        String result = game.result(input);

        assertThat(result)
                .isEqualTo(expected);
    }
}
