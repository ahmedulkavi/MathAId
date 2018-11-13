package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.javafx.geom.transform.GeneralTransform3D;

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

public class Scene3Controller implements Initializable
{
	int m;
	
	@FXML Label l1;
	@FXML Label l2;
	
	@FXML TextField t1;
	@FXML TextField t2;
	
	@FXML Button btn2;
	@FXML Button btn3;
	
	public void initializeLabels(String st1,String st2,int m)
	{
		l1.setText(st1);
		l2.setText(st2);
		this.m = m;
	}
	
	@FXML
	public void buttonActionForward2(ActionEvent e)
	{
		Pane root4 = new Pane();
		
		double val1 = Double.parseDouble(t1.getText());
		double val2 = Double.parseDouble(t2.getText());
		
		Label areaLabel = new Label();
		Label lengthLabel = new Label();
		Label radiusLabel = new Label();
		Label angleLabel = new Label();
		
		try
		{
			ArcMath arc = new ArcMath(val1,val2, m);
			
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
			
			root4.getChildren().add(btReturn);
			lengthLabel.setText("Arc Length="+String.format("%.3f",arc.getArcLength()));
			lengthLabel.setLayoutX(50);
			lengthLabel.setLayoutY(10);
			areaLabel.setLayoutX(50);
			areaLabel.setLayoutY(30);
			areaLabel.setText("Area="+String.format("%.3f",arc.getArea()));
			radiusLabel.setText("Radius="+String.format("%.3f",arc.getRadiusX()));
			radiusLabel.setLayoutX(50);
			radiusLabel.setLayoutY(50);
			angleLabel.setText("Angle="+String.format("%.3f",arc.getLength()));
			angleLabel.setLayoutX(50);
			angleLabel.setLayoutY(70);
			root4.getChildren().addAll(arc,lengthLabel,areaLabel,radiusLabel,angleLabel);
				
				
			
			Scene scene4 = new Scene(root4,500,500);
			scene4.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
			window.setScene(scene4);
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}
