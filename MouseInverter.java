import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class MouseInverterMean extends JFrame{

	//Doesn't work on multi monitors (yet)
	
	private static final long serialVersionUID = 1L;

	public MouseInverterMean() {
		
		Point lastLocation = MouseInfo.getPointerInfo().getLocation();
		
		int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		while (true)
		{
			Point p = MouseInfo.getPointerInfo().getLocation();
			if (!p.equals(lastLocation)){
				
				try {
					
					int newX = Math.min(screenWidth-4 , Math.max(p.x-2*(p.x - lastLocation.x), 4));
					int newY = Math.min(screenHeight-4, Math.max(p.y-2*(p.y - lastLocation.y), 4));
					
					new Robot().mouseMove(newX, newY);
					lastLocation = new Point(newX, newY);
					
				} catch (AWTException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		
		while (true)
			System.out.println(MouseInfo.getPointerInfo().getLocation());
		
//		new MouseInverterMean();
	}

}
