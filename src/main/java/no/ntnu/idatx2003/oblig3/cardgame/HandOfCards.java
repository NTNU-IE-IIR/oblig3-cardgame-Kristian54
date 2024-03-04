package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;

public class HandOfCards {
  private ArrayList<PlayingCard> handOfCards;

  /**
   * Creates an instance of a HandOfCards with a given deck of cards and a number of cards to deal.
   *
   * @param deckOfCards The deck of cards to deal from
   * @param n The number of cards to deal
   */
  public HandOfCards(DeckOfCards deckOfCards, int n) {
    this.handOfCards = new ArrayList<PlayingCard>();
  }

  public ArrayList<PlayingCard> dealHand(int n) {
    ArrayList<PlayingCard> hand = new ArrayList<PlayingCard>();
    for (int i = 0; i < n; i++) {
      hand.add(handOfCards.get(i));
    }
    return hand;
  }

  public void printHand() {
    for (PlayingCard card : handOfCards) {
      System.out.println(card.getAsString());
    }
  }
}
