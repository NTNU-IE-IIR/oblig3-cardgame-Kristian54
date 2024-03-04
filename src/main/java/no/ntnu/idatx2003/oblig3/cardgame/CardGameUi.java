package no.ntnu.idatx2003.oblig3.cardgame;

    import javafx.scene.control.Button;
    import javafx.application.Application;
    import javafx.scene.Scene;
    import javafx.scene.layout.BorderPane;
    import javafx.scene.layout.FlowPane;
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

    BorderPane rootNode = new BorderPane();

    VBox leftPane = new VBox();

    leftPane.setPadding(new javafx.geometry.Insets(10));
    leftPane.setSpacing(10);

    rootNode.setLeft(leftPane);


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

