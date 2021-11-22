package unit;

import fr.zbar.kata.pokerkata.model.card.Card;
import fr.zbar.kata.pokerkata.model.card.Rank;
import fr.zbar.kata.pokerkata.model.card.Suit;
import fr.zbar.kata.pokerkata.model.hand.HighCardHand;
import fr.zbar.kata.pokerkata.model.hand.StartingHand;
import fr.zbar.kata.pokerkata.model.player.Player;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    void should_get_high_card_with_king() {
        Player player = new Player(
                "Black",
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

        Player result = player.determineBestHand();

        assertThat(result)
                .isEqualTo(expected);
    }
}
