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

public class Scene2Controller implements Initializable
{
	
	@FXML private ChoiceBox<String> ch1;
	@FXML private ChoiceBox<String> ch2;
	@FXML private ChoiceBox<String> ch3;
	
	@FXML private Button btn1;
	
	@FXML private Button btn2;
	
	
	private String s1,s2,s3;
	
	private ObservableList<String> ol = FXCollections.observableArrayList("Radius","Angle","Length","Area");
	
	
	@FXML
	public void choice()
	{
		try 
		{
			if(!ch1.getValue().isEmpty())
			{
				s1 = ch1.getValue();
				ch1.setDisable(true);
				ch2.getItems().remove(ch1.getValue());
				ch3.getItems().remove(ch1.getValue());
			}
			
			if(!ch2.getValue().isEmpty())
			{
				s2 = ch2.getValue();
				ch2.setDisable(true);
				ch1.getItems().remove(ch2.getValue());
				ch3.getItems().remove(ch2.getValue());
			}
			
			if(!ch3.getValue().isEmpty())
			{
				s3 = ch3.getValue();
				ch3.setDisable(true);
				ch1.getItems().remove(ch3.getValue());
				ch2.getItems().remove(ch3.getValue());
			}
			
		} catch(RuntimeException e)
		{
			
			
		}
	}
	
	@FXML
	public void buttonActionForward1(ActionEvent e) throws IOException
	{
		try 
		{
			int m;
			
			if(!ch1.getValue().isEmpty())s1 = ch1.getValue();
			if(!ch2.getValue().isEmpty())s2 = ch2.getValue();
			if(!ch3.getValue().isEmpty())s3 = ch3.getValue();
			
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/Scene3.fxml"));
			
			Parent root3 = loader.load();
			
			Scene scene3 = new Scene(root3);
			
			Scene3Controller controller = loader.getController();
			
			if(s2.equals("Radius") && s3.equals("Angle")) m = 1;
			
			else if(s2.equals("Radius") && s3.equals("Length")) m = 2;
			
			else if(s2.equals("Radius") && s3.equals("Area")) m = 3;
			
			else if(s2.equals("Area") && s3.equals("Angle")) m = 4;
		
			else if(s2.equals("Area") && s3.equals("Length")) m = 5;
			
			else if(s2.equals("Length") && s3.equals("Angle")) m = 6;
			
			else if(s2.equals("Angle") && s3.equals("Radius")) m = 7;
			
			else if(s2.equals("Length") && s3.equals("Radius")) m = 8;
			
			else if(s2.equals("Area") && s3.equals("Radius")) m = 9;
			
			else if(s2.equals("Angle") && s3.equals("Area")) m = 10;
			
			else if(s2.equals("Length") && s3.equals("Area")) m = 11;
		
			
			else m = 12;
			
			controller.initializeLabels(s2+":", s3+":",m);
			
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
		ch1.setItems(ol);
		ch2.setItems(ol);
		ch3.setItems(ol);
		
	}
}
