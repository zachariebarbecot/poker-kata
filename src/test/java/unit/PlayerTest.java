package unit;

import fr.zbar.kata.pokerkata.model.card.Card;
import fr.zbar.kata.pokerkata.model.card.Rank;
import fr.zbar.kata.pokerkata.model.card.Suit;
import fr.zbar.kata.pokerkata.model.hand.FinalHand;
import fr.zbar.kata.pokerkata.model.hand.HighCardFinalHand;
import fr.zbar.kata.pokerkata.model.hand.NullFinalHand;
import fr.zbar.kata.pokerkata.model.hand.PairFinalHand;
import fr.zbar.kata.pokerkata.model.hand.StartingHand;
import fr.zbar.kata.pokerkata.model.player.Name;
import fr.zbar.kata.pokerkata.model.player.Player;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Nested
    class HighCardFinalHandTest {
        @Test
        void should_get_high_card() {
            StartingHand startingHand = new StartingHand(
                    new Card(Rank.TWO, Suit.HEARTS),
                    new Card(Rank.THREE, Suit.DIAMONDS),
                    new Card(Rank.FIVE, Suit.SPADES),
                    new Card(Rank.NINE, Suit.CLUBS),
                    new Card(Rank.KING, Suit.DIAMONDS)
            );
            Player player = new PlayerTestBuilder()
                    .withStartingHand(startingHand)
                    .build();


            Player result = player.determineStrongestHand();

            Player expectedPlayer = new PlayerTestBuilder()
                    .withStartingHand(player.startingHand())
                    .withFinalHand(
                            new HighCardFinalHand(
                                    new Card(Rank.KING, Suit.DIAMONDS)
                            )
                    )
                    .build();
            assertThatPlayerHaveFinalHand(result, expectedPlayer);
        }
    }

    @Nested
    class PairFinalHandTest {
        @Test
        void should_get_pair() {
            StartingHand startingHand = new StartingHand(
                    new Card(Rank.FIVE, Suit.CLUBS),
                    new Card(Rank.FIVE, Suit.HEARTS),
                    new Card(Rank.FOUR, Suit.SPADES),
                    new Card(Rank.EIGHT, Suit.CLUBS),
                    new Card(Rank.ACE, Suit.HEARTS)
            );
            Player player = new PlayerTestBuilder()
                    .withStartingHand(startingHand)
                    .build();

            Player result = player.determineStrongestHand();

            Player expectedPlayer = new PlayerTestBuilder()
                    .withStartingHand(player.startingHand())
                    .withFinalHand(
                            new PairFinalHand(
                                    new Card(Rank.FIVE, Suit.CLUBS),
                                    new Card(Rank.FIVE, Suit.HEARTS)
                            )
                    )
                    .build();
            assertThatPlayerHaveFinalHand(result, expectedPlayer);
        }

        @Test
        void should_get_highest_pair() {
            StartingHand startingHand = new StartingHand(
                    new Card(Rank.TWO, Suit.HEARTS),
                    new Card(Rank.TWO, Suit.DIAMONDS),
                    new Card(Rank.KING, Suit.SPADES),
                    new Card(Rank.NINE, Suit.CLUBS),
                    new Card(Rank.KING, Suit.DIAMONDS)
            );
            Player player = new PlayerTestBuilder()
                    .withStartingHand(startingHand)
                    .build();


            Player result = player.determineStrongestHand();

            Player expectedPlayer = new PlayerTestBuilder()
                    .withStartingHand(player.startingHand())
                    .withFinalHand(
                            new PairFinalHand(
                                    new Card(Rank.KING, Suit.SPADES),
                                    new Card(Rank.KING, Suit.DIAMONDS)
                            )
                    )
                    .build();
            assertThatPlayerHaveFinalHand(result, expectedPlayer);
        }
    }

    private void assertThatPlayerHaveFinalHand(Player result, Player expectedPlayer) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result.name()).isEqualTo(expectedPlayer.name());
        softly.assertThat(result.startingHand()).isEqualTo(expectedPlayer.startingHand());
        softly.assertThat(result.finalHand()).isEqualTo(expectedPlayer.finalHand());
        softly.assertAll();
    }

    private static final class PlayerTestBuilder {

        private final Name name = new Name("PLAYER_NAME");
        private StartingHand startingHand;
        private FinalHand finalHand = new NullFinalHand();

        public PlayerTestBuilder withStartingHand(StartingHand startingHand) {
            this.startingHand = startingHand;
            return this;
        }

        public PlayerTestBuilder withFinalHand(FinalHand finalHand) {
            this.finalHand = finalHand;
            return this;
        }

        public Player build() {
            return Player.of(name, startingHand, finalHand);
        }
    }
}
