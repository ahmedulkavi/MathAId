package application;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class ArcMath extends Arc
{
	private double area;
	public double arcLength;
	private int mode;
	
	public ArcMath(double val1,double val2,int m)
	{
		mode = m;
		
		setCenterX(250);
		setCenterY(250);
		//setFill(Color.RED);
		//setStroke(Color.BLACK);
		setType(ArcType.ROUND);
		//setStyle("-fx-background-color: green");
		Stop[] stops = new Stop[] { new Stop(0, Color.GREEN), new Stop(1, Color.BLUE)};  
        LinearGradient linear = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        setFill(linear);
		setStartAngle(0);
		
		switch(mode)
		{
			case 1:
				setLength(val2);
				setRadius(val1);
				area = Math.PI*val1*val1*(val2/360);
				arcLength = val1*val2*Math.PI/180;
				break;
			case 2:
				setLength(val2*180/(val1*Math.PI));
				setRadius(val1);
				area = val1*val1*getLength()*Math.PI/360;
				arcLength = val2;
				break;
			case 3:
				setLength(2*val2/val1*val1*180/Math.PI);
				setRadius(val1);
				area = val2;
				arcLength = 2*val2/val1;
				break;
			case 4:
				setLength(val2);
				setRadius(Math.sqrt(360*val1/(Math.PI*val2)));
				area = val1;
				arcLength = getRadiusX()*getLength()*Math.PI/180;
				break;
			case 5:
				setRadius(360*val1/(Math.PI*val2));
				setLength(val2/getRadiusX()*180/Math.PI);
				area = val1;
				arcLength = val2;
				break;
			case 6:
				setLength(val2);
				setRadius(val1*180/(val2*Math.PI));
				area = 0.5*getRadiusX()*val1;
				arcLength = val1;
				break;
			case 7:
				setLength(val1);
				setRadius(val2);
				area = Math.PI*val2*val2*(val1/360);
				arcLength = val1*val2*Math.PI/180;
				break;
			case 8:
				setLength(val1*180/(val2*Math.PI));
				setRadius(val2);
				area = val2*val2*getLength()*Math.PI/360;
				arcLength = val1;
				break;
			case 9:
				setLength(2*val1/val2*val2*180/Math.PI);
				setRadius(val2);
				area = val1;
				arcLength = 2*val1/val2;
				break;
			case 10:
				setLength(val1);
				setRadius(Math.sqrt(360*val2/(Math.PI*val1)));
				area = val2;
				arcLength = getRadiusX()*getLength()*Math.PI/180;
				break;
			case 11:
				setRadius(360*val2/(Math.PI*val1));
				setLength(val1/getRadiusX()*180/Math.PI);
				area = val2;
				arcLength = val1;
				break;
			case 12:
				setLength(val1);
				setRadius(val2*180/(val1*Math.PI));
				area = 0.5*getRadiusX()*val2;
				arcLength = val2;
				break;
		}
		
		
		
	}

	public double getArea() {
		return area;
	}

	public double getArcLength() {
		return arcLength;
	}
	
	public void setRadius(double val)
	{
		setRadiusX(val);
		setRadiusY(val);
	}
	

}
