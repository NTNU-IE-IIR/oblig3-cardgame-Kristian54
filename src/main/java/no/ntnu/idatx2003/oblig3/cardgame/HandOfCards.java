package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Random;

public class HandOfCards {
  private DeckOfCards deckOfCards;
  private ArrayList<PlayingCard> handOfCards;

  /**
   * Creates an instance of a HandOfCards with a given deck of cards and a number of cards to deal.
   *
   * @param deckOfCards The deck of cards to deal from
   * @param n The number of cards to deal
   */
  public HandOfCards(DeckOfCards deckOfCards, int n) {
    this.handOfCards = new ArrayList<PlayingCard>();
    setDeckOfCards(deckOfCards);
    initializeHand(n);
  }

  private void setDeckOfCards(DeckOfCards deckOfCards) {
    if (deckOfCards == null) {
      throw new IllegalArgumentException("Parameter deckOfCards cannot be null");
    }

    this.deckOfCards = deckOfCards;
  }

  /**
   * Initializes the hand of cards by dealing n cards from the deck of cards.
   *
   * @param n The number of cards to deal
   */
  public void initializeHand(int n) {
    if (n < 1 || n > deckOfCards.getNumberOfCards()) {
      throw new IllegalArgumentException("Parameter n must be a positive number and less than " +
          "the number of cards in the deck of cards");
    }

    Random random = new Random();

    for (int i = 0; i < n; i++) {
      handOfCards.add(this.deckOfCards.dealCard(random.nextInt(deckOfCards.getNumberOfCards())));
    }
  }

  /**
   * Checks if the hand of cards is a flush.
   * A flush is a hand of cards where all the cards have the same suit.
   *
   * @return true if the hand of cards is a flush, false otherwise
   */
  public boolean isFlush() {
    char suit = handOfCards.get(0).getSuit();
    for (PlayingCard card : handOfCards) {
      if (card.getSuit() != suit) {
        return false;
      }
    }
    return true;
  }

  public void printHand() {
    for (PlayingCard card : handOfCards) {
      System.out.println(card.getAsString());
    }
  }

    public ArrayList<PlayingCard> getHandOfCards() {
        return handOfCards;
    }
}
