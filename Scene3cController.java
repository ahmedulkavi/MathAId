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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Scene3cController 
{
	int m;
	
	@FXML Label lc1;
	
	@FXML TextField tc1;
	
	@FXML Button btn2;
	
	@FXML Button btn3;
	
	public void initializeLabels(String st1,int m)
	{
		lc1.setText(st1);
		this.m = m;
	}
	
	@FXML
	public void buttonActionForward2(ActionEvent e)throws Exception
	{
		Pane root4c = new Pane();
		
		double val1 = Double.parseDouble(tc1.getText());
		
		Label areaLabel = new Label();
		Label circumLabel = new Label();
		Label radiusLabel = new Label();
		
		try
		{
			CircleMath circle = new CircleMath(val1,m);
			
			Button btReturn = new Button("Return to Main Menu");
			btReturn.setLayoutX(200);
			btReturn.setLayoutY(450);
			
			btReturn.setOnAction(event->
			{
				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
					window.setScene(scene);
					window.show();
				} catch (Exception e1) {
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
				
				
			});
			
			circumLabel.setLayoutX(50);
			circumLabel.setText(String.format("Circumference="+"%.3f",circle.getCircumference()));
			circumLabel.setLayoutY(10);
			areaLabel.setLayoutX(50);
			areaLabel.setLayoutY(30);
			areaLabel.setText(String.format("Area="+"%.3f",circle.getArea()));
			radiusLabel.setText("Radius="+String.format("%.3f",circle.getRadius()));
			radiusLabel.setLayoutX(50);
			radiusLabel.setLayoutY(50);
			root4c.getChildren().addAll(circle,circumLabel,areaLabel,radiusLabel);
			
			root4c.getChildren().add(btReturn);
			
			
			Scene scene4c = new Scene(root4c,500,500);
			scene4c.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
			window.setScene(scene4c);
			window.show();
		}
		
		catch(Exception f)
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
	public void buttonActionBackward2(ActionEvent e)throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("/application/Scene2.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	
	
}
