package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;

/**
 * Represents a deck of playing cards. A deck of cards contains 52 cards.
 */
public class DeckOfCards {

  private final int NUMBER_OF_CARDS_IN_A_SUIT = 13;
  private final char[] suits = {'S', 'H', 'D', 'C'};
  private int NUMER_OF_CARDS_IN_DECK = 52;
  private ArrayList<PlayingCard> deckOfCards;


  public DeckOfCards() {
    this.deckOfCards = new ArrayList<PlayingCard>();
    for (char suit : suits) {
      for (int face = 1; face <= NUMBER_OF_CARDS_IN_A_SUIT; face++) {
        deckOfCards.add(new PlayingCard(suit, face));
      }
    }
  }

  public void removeCard(PlayingCard card) {
    deckOfCards.remove(card);
  }

  public void printCards() {
    for (PlayingCard card : deckOfCards) {
      System.out.println(card.getAsString());
    }
  }
}
