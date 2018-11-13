package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainController implements Initializable
{
	
	@FXML private ChoiceBox<String> ch;
	
	
	@FXML
	private Button btn;
	
	
	
	@FXML
	public void buttonAction(ActionEvent e) throws IOException
	{
		
		
		
		try
		{
			if(!ch.getValue().isEmpty() && ch.getValue().equals("Arc"))
			{
				Parent root2 = FXMLLoader.load(getClass().getResource("/application/Scene2.fxml"));
				Scene scene2 = new Scene(root2);
				scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
				window.setScene(scene2);
				window.show();

			}
			
			else if(!ch.getValue().isEmpty() && ch.getValue().equals("Circle"))
			{
				Parent root2c = FXMLLoader.load(getClass().getResource("/application/Scene2c.fxml"));
				Scene scene2c = new Scene(root2c);
				scene2c.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
				window.setScene(scene2c);
				window.show();

			}
			
		}	catch(RuntimeException f)
		{
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ch.getItems().addAll("Circle","Arc");
		
	}

}
