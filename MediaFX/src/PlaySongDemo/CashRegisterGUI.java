package PlaySongDemo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CashRegisterGUI extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }

  private TextField quantityField = new TextField();
  private TextField priceField;
  private Button addItemButton;
  private ListView<String> listView;
  ObservableList<String> observableList = FXCollections.observableArrayList();

  @Override
  public void start(Stage primaryStage) {
    
    
    // Instantiate the components of the top pane
    Label quantityLabel = new Label("  Quantity");
    quantityField = new TextField();
    Label priceLabel = new Label("  Price ");
    priceField = new TextField();
    GridPane panel = new GridPane();
    panel.setHgap(4);
    panel.setVgap(4);
    quantityField.setMaxWidth(60);
    priceField.setMaxWidth(60);
    addItemButton = new Button("Add LineItem");

 
    panel.add(quantityLabel, 0, 0); 
    panel.add(quantityField, 1, 0);
    panel.add(priceLabel, 0, 2);
    panel.add(priceField, 1, 2);
    panel.add(addItemButton, 1, 3);   
    
    BorderPane all = new BorderPane();
    all.setTop(panel); 
    listView = new ListView<String>();
    listView.setItems(observableList);
    all.setCenter(listView);   
    Scene scene = new Scene(all, 170, 200);
    primaryStage.setScene(scene);
    primaryStage.show();
    
    // TODO: Register the listener   
    addItemButton.setOnAction(new PriceFieldListener());   
  }

  // TODO: Implement an EventHandler so when the user presses the button 
  // a new LineItem is created and added to the list. The EventHandler 
  // must also update the TextArea so all LineItems are shown.
private class PriceFieldListener implements EventHandler<ActionEvent>{

    public void handle(ActionEvent e) {
      int howMany = Integer.parseInt(quantityField.getText());
      double price = Double.parseDouble(priceField.getText());
      LineItem lineItem = new LineItem(howMany, price);
      observableList.add(lineItem.toString());
    }
  }

}