package survivethewest;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import java.util.Random;
import javafx.scene.text.TextFlow;
import javafx.scene.text.FontWeight;

public class SurviveTheWest extends Application {
    
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final String[] LIST_OF_STATES = {"Alabama", "Arkansas", "California", "Connecticut", "Delaware", "Florida", "Georgia", "Illinois", "Indiana",
            "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Mississippi", "Missouri", "New Hampshire", "New Jersey",
            "New York", "North Carolina", "Ohio", "Pennsylvania", "Rhode Island", "South Carolina", "Tennessee", "Texas", "Vermont", "Virginia", "Wisconsin"};
    
    private int introMessage = 0;
    
    private Text textNode;
    private Label playerNameLabel;
    private Label playerLocationLabel;
    private String playerFirstName;
    private String playerLastName;
    private String startingLocation;
    
    private Person player;
    
    private Button arrowButton;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        // Create the player object
        player = new Person();
        
        // Initialize labels
        playerNameLabel = new Label();
        playerLocationLabel = new Label();
        
        // Create a Text node for displaying text
        textNode = new Text("You are a " + player.getGender() + " of 22 years named " + player.getFirstName() + 
                " " + player.getLastName() + ".");
        textNode.setFill(Color.WHITE);
        textNode.setFont(Font.font("Arial",18));
        textNode.setWrappingWidth(WINDOW_WIDTH - 20);
        
        // Set the Text node alignment to the center of the screen
        textNode.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        
        // Create a button with an arrow icon
         arrowButton = createArrowButton();
        arrowButton.setAlignment(Pos.BOTTOM_RIGHT);
        
        // Create the main content box
        BorderPane mainContentBox = createMainContentBox();
        
        // Create the inventory box
        ScrollPane inventoryBox = createInventoryBox();
        
        // Create an HBox to hold both boxes
        HBox root = new HBox(mainContentBox, inventoryBox);
        
        VBox labelsVBox = new VBox();
        labelsVBox.setAlignment(Pos.TOP_LEFT);
        
        playerNameLabel.setTextFill(Color.WHITE);
        playerNameLabel.setFont(Font.font("Arial",14));
        
        playerLocationLabel.setTextFill(Color.WHITE);
        playerLocationLabel.setFont(Font.font("Arial",14));
        
        labelsVBox.getChildren().addAll(playerNameLabel, playerLocationLabel);
        
        BorderPane.setMargin(labelsVBox, new Insets(5, 0, 0, 10));
        BorderPane.setAlignment(labelsVBox, Pos.TOP_LEFT);
        
        mainContentBox.setTop(labelsVBox);
        
        // Create the scene and set it in the stage
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setScene(scene);
        
        // Set stage properties
        primaryStage.setTitle("Survive The West");
        primaryStage.show();
    }
    
    private Button createArrowButton() {
        arrowButton = new Button();
        
        // Set the arrow icon
        Image arrowImage = new Image(getClass().getResourceAsStream("/survivethewest/resources/arrow.png"));
        ImageView imageView = new ImageView(arrowImage);
        imageView.setFitWidth(30);
        imageView.setFitHeight(30);
        arrowButton.setGraphic(imageView);
        
        // Set the button's size
        arrowButton.setStyle("-fx-min-width: 40px; -fx-min-height: 40px; -fx-max-width: 40px; -fx-max-height: 40px;");
        
        // Set the event handler
        arrowButton.setOnAction(e -> {
            if (introMessage == 0) {
                displayText("You are a dirt poor American born in the early 1800s now trying to survive and thrive by your own decisions, skills, and relationships.");
                if(playerFirstName == null && playerLastName == null) {
                    playerFirstName = player.getFirstName();
                    playerLastName = player.getLastName();
                    playerNameLabel.setText("Name: " + playerFirstName + " " + playerLastName);
                    
                }
            }
           else if (introMessage == 1) {
                    Random random = new Random();
                    int locationIndex = random.nextInt(LIST_OF_STATES.length);
                    startingLocation = LIST_OF_STATES[locationIndex];
                    playerLocationLabel.setText("Location: " + startingLocation);
                    displayText("You were born in " + startingLocation + ". Your family had no choice but to send you on your way and now you stand on your own two feet." +
                            " Your choices shall determine your fate.");
            }
              introMessage++;
        });
        return arrowButton;
    }
    
    public void displayText(String newText) {
        textNode.setText(newText);
        textNode.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
    }
    
    private BorderPane createMainContentBox() {
        // Create a BorderPane for the main content box
        BorderPane mainContentBox = new BorderPane();
        mainContentBox.setStyle("-fx-background-color: black;");
        mainContentBox.setMinWidth(600);
        
       // Create a TextFlow to hold the textNode
       TextFlow textFlow = new TextFlow(textNode);
       textFlow.setMaxWidth(560);
       
       // Add the TextFlow to the center of the main content box with padding
       VBox textVBox = new VBox(textFlow);
       textVBox.setAlignment(Pos.CENTER);
       textVBox.setPadding(new Insets(10));
       
       // Center the text vertically in the main content box
       mainContentBox.setCenter(textVBox);
       
       // Add the arrowButton to the bottom right of the main content box
       mainContentBox.setBottom(arrowButton);
       BorderPane.setAlignment(arrowButton, Pos.BOTTOM_RIGHT);
        
        return mainContentBox;
    }
    
    private ScrollPane createInventoryBox() {
        // Create a ScrollPane for the inventory box
        ScrollPane inventoryBox = new ScrollPane();
        inventoryBox.setStyle("-fx-background-color: darkgray;");
        inventoryBox.setMinWidth(200);
        
        // Create a label for the inventory text
        Label inventoryLabel = new Label("Inventory");
        inventoryLabel.setTextFill(Color.BLACK);
        
        // Set the label to be centered and bold
        inventoryLabel.setAlignment(Pos.CENTER);
        inventoryLabel.setFont(Font.font("Arial",FontWeight.BOLD, 14));
        
        // Add a line break
        Label lineBreakLabel = new Label("---------------------------------------");
        
        // Create a VBox to hold the labels
        VBox labelsVBox = new VBox(inventoryLabel, lineBreakLabel);
        labelsVBox.setAlignment(Pos.CENTER);
        
        // Set the content of the ScrollPane to the inventory label
        inventoryBox.setContent(labelsVBox);
        
        // Ensure the inventory box expands to fill available height
        HBox.setHgrow(inventoryBox, Priority.ALWAYS);
        
        return inventoryBox;
    }
    
}