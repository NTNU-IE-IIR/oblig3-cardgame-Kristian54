package no.ntnu.idatx2003.oblig3.cardgame;

public class Main {
    public static void main(String[] args) {
        //CardGameUi.cardGameMain(args);
        DeckOfCards deckOfCards = new DeckOfCards();
        //deckOfCards.printCards();
        HandOfCards handOfCards = new HandOfCards(deckOfCards, 5);
        handOfCards.printHand();
    }
}
