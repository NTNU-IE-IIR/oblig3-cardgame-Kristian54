package no.ntnu.idatx2003.oblig3.cardgame;

    import javafx.scene.image.Image;
    import java.io.InputStream;
    import javafx.geometry.Pos;
    import javafx.scene.control.Button;
    import javafx.application.Application;
    import javafx.scene.Scene;
    import javafx.scene.image.ImageView;
    import javafx.scene.layout.BorderPane;
    import javafx.scene.layout.FlowPane;
    import javafx.scene.layout.Pane;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

public class CardGameUi extends Application {

  private DeckOfCards deck;
  private HandOfCards hand;

  public void initialize() {
    this.deck = new DeckOfCards();
  }

  public void viewHand(BorderPane borderPane) {
    FlowPane handDisplay = new FlowPane();
    handDisplay.setVgap(100);
    handDisplay.setHgap(10);
    handDisplay.setAlignment(Pos.TOP_CENTER);

    borderPane.setCenter(handDisplay);

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
    }
  }

  public void dealHand(BorderPane borderPane) {
    this.hand = new HandOfCards(this.deck, 5);
    viewHand(borderPane);
  }

  public void checkHand() {

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
    BorderPane borderPane = new BorderPane();

    addButtons(borderPane);

    Pane spacer = new Pane();
    spacer.setPrefHeight(100);
    borderPane.setTop(spacer);


    Scene scene = new Scene(borderPane, 1000, 800);
    stage.setScene(scene);
    stage.setTitle("Card Game");
    stage.show();
  }

  public void addButtons(BorderPane borderPane) {
    Button dealHand = new Button("Deal Hand");
    Button checkHand = new Button("Check Hand");
    dealHand.setPrefSize(100, 60);
    checkHand.setPrefSize(100, 60);

    dealHand.setOnAction((event) -> {
      dealHand(borderPane);
    });

    VBox buttonPane = new VBox();
    buttonPane.getChildren().addAll(dealHand, checkHand);
    buttonPane.setAlignment(Pos.TOP_CENTER);
    buttonPane.setPadding(new javafx.geometry.Insets(40));
    buttonPane.setSpacing(10);

    borderPane.setRight(buttonPane);
  }

  public static void cardGameMain(String[] args) {
    launch();
  }
}

