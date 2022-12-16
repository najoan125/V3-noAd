package Main;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

public class MouseCorrectRobot extends Robot
{
	public MouseCorrectRobot() throws AWTException {
		super();
	}
	
	public void betterMouseMove(int x, int y, float scaleFactor) {
		float modFactor = 1 - (1 / scaleFactor);
		Point origin = MouseInfo.getPointerInfo().getLocation();
		
		float deltaX = x - origin.x;
		float deltaY = y - origin.y;
		
		int finalX = (int) Math.floor(x - deltaX * modFactor);
		int finalY = (int) Math.floor(y - deltaY * modFactor);
		
		this.mouseMove(finalX, finalY);
	}
}