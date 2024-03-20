package no.ntnu.idatx2003.oblig3.cardgame;

    import javafx.scene.control.Label;
    import javafx.scene.image.Image;
    import java.io.InputStream;
    import javafx.geometry.Pos;
    import javafx.scene.control.Button;
    import javafx.application.Application;
    import javafx.scene.Scene;
    import javafx.scene.image.ImageView;
    import javafx.scene.layout.BorderPane;
    import javafx.scene.layout.FlowPane;
    import javafx.scene.layout.GridPane;
    import javafx.scene.layout.Pane;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

public class CardGameUi extends Application {

  private DeckOfCards deck;
  private HandOfCards hand;


  private BorderPane borderPane;
  private FlowPane handDisplay;
  private GridPane statsGrid;
  private VBox buttonPane;

  private Button dealHand;
  private Button checkHand;


  public void initialize() {
    this.deck = new DeckOfCards();

    this.borderPane = new BorderPane();

    this.buttonPane = new VBox();
    buttonPane.setStyle("-fx-background-color: #424242");
    buttonPane.setAlignment(Pos.TOP_CENTER);
    buttonPane.setPadding(new javafx.geometry.Insets(40));
    buttonPane.setSpacing(10);
    borderPane.setRight(buttonPane);

    this.statsGrid = new GridPane(2, 4);
    statsGrid.setAlignment(Pos.CENTER);
    statsGrid.setStyle("-fx-background-color: #606060");
    borderPane.setBottom(statsGrid);
    statsGrid.setPrefHeight(100);

    this.handDisplay = new FlowPane();
    handDisplay.setVgap(100);
    handDisplay.setHgap(10);
    handDisplay.setAlignment(Pos.TOP_CENTER);
    handDisplay.setPadding(new javafx.geometry.Insets(40));
    handDisplay.setStyle("-fx-background-color: #182a65");
    borderPane.setCenter(handDisplay);
  }

  public void viewHand(BorderPane borderPane) {
    handDisplay.getChildren().clear();

    for (PlayingCard card : hand.getHandOfCards()) {
      try {
        InputStream is = this.getClass().getResourceAsStream("/" + card.getAsString() + ".png");
        Image cardImage = new Image(is);
        ImageView cardView = new ImageView(cardImage);

        double aspectRatio = cardImage.getWidth() / cardImage.getHeight();
        cardView.setFitWidth(100);
        cardView.setFitHeight(200 * aspectRatio);
        handDisplay.getChildren().addAll(cardView);
      } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
      }
      hand.printHand();
    }
  }

  public void dealHand(BorderPane borderPane) {
    this.hand = new HandOfCards(this.deck, 5);
    viewHand(borderPane);
  }

  public void viewCardInfo() {
    if (hand != null) {
      String isFlush = "Hand isn't a flush";
      String hasS12String = "Hand doesn't contain S12";
      if (hand.isFlush()) {
        isFlush = "Hand is a flush";
      }
      if (hand.hasS12()) {
        hasS12String = "Hand contains S12";
      }
      statsGrid.getChildren().clear();

      Label sumOfCards = new javafx.scene.control.Label("Sum of cards: " + hand.getSumOfCards());
      sumOfCards.setStyle("-fx-font-size: 20px");
      sumOfCards.setTextFill(javafx.scene.paint.Color.web("#ffffff"));

      Label flush = new javafx.scene.control.Label(isFlush);
      flush.setStyle("-fx-font-size: 20px");
      flush.setTextFill(javafx.scene.paint.Color.web("#ffffff"));

      Label hasS12 = new javafx.scene.control.Label(hasS12String);
      hasS12.setStyle("-fx-font-size: 20px");
      hasS12.setTextFill(javafx.scene.paint.Color.web("#ffffff"));

      Label getHearts = new javafx.scene.control.Label("Hearts: " + hand.getHearts());
      getHearts.setStyle("-fx-font-size: 20px");
      getHearts.setTextFill(javafx.scene.paint.Color.web("#ffffff"));



      statsGrid.add(sumOfCards, 0, 0);
      statsGrid.add(flush, 0, 1);
      statsGrid.add(hasS12, 1, 0);
      statsGrid.add(getHearts, 1, 1);

      statsGrid.setHgap(40);
    }
  }

  /**
   * Construct the main window.
   *
   * @param stage
   * @throws Exception
   */
  @Override
  public void start(Stage stage) throws Exception {
    initialize();
    addButtons();
    setButtonActions();

    Scene scene = new Scene(borderPane, 800, 330);
    stage.setScene(scene);
    stage.setTitle("Card Game");
    stage.show();

    dealHand(borderPane);
  }

  public void addButtons() {
    this.dealHand = new Button("Deal Hand");
    this.checkHand = new Button("Check Hand");
    dealHand.setPrefSize(100, 60);
    checkHand.setPrefSize(100, 60);

    buttonPane.getChildren().addAll(dealHand, checkHand);

  }

  private void setButtonActions() {
    dealHand.setOnAction((event) -> {dealHand(borderPane);});
    checkHand.setOnAction((event) -> {viewCardInfo();});
  }

  public static void cardGameMain(String[] args) {
    launch();
  }
}

