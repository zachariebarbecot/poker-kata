package unit;

import fr.zbar.kata.pokerkata.model.card.Card;
import fr.zbar.kata.pokerkata.model.card.Rank;
import fr.zbar.kata.pokerkata.model.card.Suit;
import fr.zbar.kata.pokerkata.model.hand.HighCardHand;
import fr.zbar.kata.pokerkata.model.hand.PairHand;
import fr.zbar.kata.pokerkata.model.hand.StartingHand;
import fr.zbar.kata.pokerkata.model.player.Name;
import fr.zbar.kata.pokerkata.model.player.Player;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Nested
    class HighCardTest {
        @Test
        void should_get_high_card() {
            Player player = new Player(
                    new Name("Black"),
                    new StartingHand(
                            new Card(Rank.TWO, Suit.HEARTS),
                            new Card(Rank.THREE, Suit.DIAMONDS),
                            new Card(Rank.FIVE, Suit.SPADES),
                            new Card(Rank.NINE, Suit.CLUBS),
                            new Card(Rank.KING, Suit.DIAMONDS)
                    )
            );
            Player expected = new Player(
                    player.name(),
                    new HighCardHand(
                            new Card(Rank.KING, Suit.DIAMONDS)
                    )
            );

            Player result = player.determineStrongestHand();

            assertThat(result)
                    .isEqualTo(expected);
        }
    }

    @Nested
    class PairHandTest {
        @Test
        void should_get_pair() {
            Player player = new Player(
                    new Name("White"),
                    new StartingHand(
                            new Card(Rank.FIVE, Suit.CLUBS),
                            new Card(Rank.FIVE, Suit.HEARTS),
                            new Card(Rank.FOUR, Suit.SPADES),
                            new Card(Rank.EIGHT, Suit.CLUBS),
                            new Card(Rank.ACE, Suit.HEARTS)
                    )
            );
            Player expected = new Player(
                    player.name(),
                    new PairHand(
                            new Card(Rank.FIVE, Suit.CLUBS),
                            new Card(Rank.FIVE, Suit.HEARTS)
                    )
            );

            Player result = player.determineStrongestHand();

            assertThat(result)
                    .isEqualTo(expected);
        }

        @Test
        void should_get_highest_pair() {
            Player player = new Player(
                    new Name("Black"),
                    new StartingHand(
                            new Card(Rank.TWO, Suit.HEARTS),
                            new Card(Rank.TWO, Suit.DIAMONDS),
                            new Card(Rank.KING, Suit.SPADES),
                            new Card(Rank.NINE, Suit.CLUBS),
                            new Card(Rank.KING, Suit.DIAMONDS)
                    )
            );
            Player expected = new Player(
                    player.name(),
                    new PairHand(
                            new Card(Rank.KING, Suit.SPADES),
                            new Card(Rank.KING, Suit.DIAMONDS)
                    )
            );

            Player result = player.determineStrongestHand();

            assertThat(result)
                    .isEqualTo(expected);
        }
    }
}
