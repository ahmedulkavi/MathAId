package application;

import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;

public class CircleMath extends Circle
{
	private double area;
	private double circumference;
	private int mode;
	
	public CircleMath(double val1,int m)
	{
		mode = m;
		
		setCenterX(250);
		setCenterY(250);
		//setFill(Color.RED);
		//setStroke(Color.BLACK);
		
		  RadialGradient gradient1 = new RadialGradient(0,  
		            .1,  
		            100,  
		            100,  
		            200,  
		            false,  
		            CycleMethod.NO_CYCLE,  
		            new Stop(0, Color.YELLOW),  
		            new Stop(1, Color.RED));  
		       setFill(gradient1);  
		
		
		switch(mode)
		{
			case 1:
				setRadius(val1*3);
				area =  Math.PI*val1*val1;
				circumference = 2*Math.PI*val1;
				break;
			case 2:
				setRadius(val1/(2*Math.PI)*3);
				area = val1*val1/(4*Math.PI);
				circumference = val1;
				break;
			case 3:
				setRadius(Math.sqrt(val1/Math.PI)*3);
				area = val1;
				circumference = 2*Math.PI*Math.sqrt(val1)/Math.PI;
				break;
				
		}
		
	}

	public double getArea() {
		return area;
	}

	public double getCircumference() {
		return circumference;
	}
}
