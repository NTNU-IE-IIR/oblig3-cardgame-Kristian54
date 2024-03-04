package no.ntnu.idatx2003.oblig3.cardgame;

    import javafx.scene.control.Button;
    import javafx.application.Application;
    import javafx.scene.Scene;
    import javafx.scene.layout.BorderPane;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

public class CardGameUi extends Application {

  /**
   * Construct the main window.
   *
   * @param stage
   * @throws Exception
   */
  @Override
  public void start(Stage stage) throws Exception {
    Button dealHand = new Button("Deal Hand");
    Button checkHand = new Button("Check Hand");
    dealHand.setPrefSize(100, 50);
    checkHand.setPrefSize(100, 50);

    BorderPane rootNode = new BorderPane();

    VBox rightPane = new VBox();

    rightPane.setPadding(new javafx.geometry.Insets(10));
    rightPane.setSpacing(10);
    rightPane.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
    rootNode.setRight(rightPane);

    rightPane.getChildren().addAll(dealHand, checkHand);
    rootNode.setPadding(new javafx.geometry.Insets(5));


    Scene scene = new Scene(rootNode, 1000, 800);
    stage.setScene(scene);
    stage.setTitle("Card Game");
    stage.show();
  }

  public static void cardGameMain(String[] args) {
    launch();
  }
}

