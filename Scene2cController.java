package application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class Scene2cController implements Initializable
{
	
	@FXML private ChoiceBox<String> chc1;
	@FXML private ChoiceBox<String> chc2;
	
	@FXML private Button btn1;
	@FXML private Button btn2;
	
	
	private String sc1,sc2;
	
	private ObservableList<String> ol1 = FXCollections.observableArrayList("Radius","Circumference","Area");
	
	
	@FXML
	public void choice()
	{
		try 
		{
			if(!chc1.getValue().isEmpty())
			{
				sc1 = chc1.getValue();
				chc1.setDisable(true);
				chc2.getItems().remove(chc1.getValue());
			}
			
			if(!chc2.getValue().isEmpty())
			{
				sc2 = chc2.getValue();
				chc2.setDisable(true);
				chc1.getItems().remove(chc2.getValue());
			}
			
			
		} catch(Exception e)
		{
			
		}
	}
	
	@FXML
	public void buttonActionForward1(ActionEvent e) throws IOException
	{
		try 
		{
			int m;
			
			if(!chc1.getValue().isEmpty())sc1 = chc1.getValue();
			if(!chc2.getValue().isEmpty())sc2 = chc2.getValue();
			
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/Scene3c.fxml"));
			
			Parent root3c = loader.load();
			
			Scene scene3 = new Scene(root3c);
			
			Scene3cController controller = loader.getController();
			
			if( sc2.equals("Radius")) m = 1;
			
			else if(sc2.equals("Circumference") ) m = 2;
			
			else m = 3;
			
			controller.initializeLabels(sc2+":",m);
			
			scene3.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
			window.setScene(scene3);
			window.show();

			
		} catch(Exception f)
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
	
	@FXML
	public void buttonActionBackward1(ActionEvent e)throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		chc1.setItems(ol1);
		chc2.setItems(ol1);

		
	}
}
