package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


public class Main extends Application {
	
	@FXML Button wbButton;
	final Stage warningStage = new Stage();
	
	@Override
	public void start(final Stage primaryStage) throws IOException {
		try 
		{
			Pane root0 = new Pane();
			Image img = new Image("file:C:/Users/User/eclipse-workspace/MathAid/src/application/pic2.gif");
			ImageView imv = new ImageView(img);
			Button btn = new Button("Continue");
			btn.setLayoutX(220);
			btn.setLayoutY(460);
			btn.setStyle("-fx-background-color:  linear-gradient(#00bfff, #add8e6	)");
			root0.getChildren().addAll(imv,btn);
			
			Scene scene0 = new Scene(root0);
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
			final Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			btn.setOnAction(e->
			{
				primaryStage.setScene(scene);
			});
			
			primaryStage.setTitle("MathAid");
			primaryStage.setMaxHeight(600);
			primaryStage.setMaxWidth(500);
			primaryStage.setScene(scene0);
			primaryStage.show();
		} catch(Exception e) {
			
			Stage warningStage = new Stage();
			GridPane wPane = new GridPane();
			wPane.setAlignment(Pos.CENTER);
			wPane.setPadding(new Insets(14.5));
			wPane.setHgap(5);
			wPane.setVgap(5);
			
			
			Image warningImage = new Image("file:C:/Users/User/eclipse-workspace/MathAid/src/application/warningFinal.png");
			wPane.add(new ImageView(warningImage), 0, 0);
			
			wPane.add(new Text("Invalid Input"), 1, 0);
			Button wButton = new Button("OK");
			wButton.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent event) 
				{
					warningStage.close();
				}
			});
			wPane.add(wButton, 1, 1);
			
			Scene wScene = new Scene(wPane);
			warningStage.setScene(wScene);
			warningStage.show();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
