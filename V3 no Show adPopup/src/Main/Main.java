package Main;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JOptionPane;
import java.awt.event.InputEvent;

public class Main {
	public static int x1=0,y1=0,x2=0,y2=0,x3=0,y3=0,x4=0,y4=0,x5=0,y5=0; //���콺�� �̵��� ��ǥ
	public static int delay = 300; //���콺 Ŭ�� �� �����ð�
	public static float currentscale = 1.0f; //���� ȭ�� ����(100%: 1.0f, 125%: 1.25f)
	
	public static void main(String[] args) {
		//�⺻ ��ũ�� ����
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		//ȭ�� ���� ����
		int width = gd.getDisplayMode().getWidth();
		//ȭ�� ���� ����
		int height = gd.getDisplayMode().getHeight();
		//ȭ�� ����(100%: 96)
		int scale = java.awt.Toolkit.getDefaultToolkit().getScreenResolution();
		
		//FHD 100%
		if (width == 1920 && height == 1080 && scale == 96) {
			x1 = 541;
			y1 = 635;
			
			x2 = 881;
			y2 = 257;
			
			x3 = 752;
			y3 = 539;
			
			x4 = 1373;
			y4 = 823;
			
			x5 = 1159;
			y5 = 819;
		}
		//QHD 100%
		else if (width == 2560 && height == 1440 && scale == 96) {
			x1 = 864;
			y1 = 818;
			
			x2 = 1199;
			y2 = 439;
			
			x3 = 1072;
			y3 = 721;
			
			x4 = 1689;
			y4 = 998;
			
			x5 = 1487;
			y5 = 1005;
		}
		//FHD 125%
		else if (width == 1920 && height == 1080 && scale == 120) {
			x1 = 454;
			y1 = 666;
			
			x2 = 856;
			y2 = 189;
			
			x3 = 703;
			y3 = 538;
			
			x4 = 1488;
			y4 = 894;
			
			x5 = 1216;
			y5 = 900;
			
			currentscale = 1.25f;
		}
		//not supported
		else {
			JOptionPane.showMessageDialog(null, "�� ���÷��̴� �������� �ʽ��ϴ�.\n"
					+ "�����Ǵ� �ػ�: \n"
					+ "1920x1080(FHD) 100%,125% ����\n"
					+ "2560x1440(QHD) 100% ����");
			return;
		}
		run();
	}
	
	public static void run() {
		Runtime rt = Runtime.getRuntime();
		String execPro = "C:\\V3-noAd.bat";
		Process p;
		try {
			p = rt.exec(execPro); //V3 ȯ�漳�� ����
			p.waitFor(); //V3 ȯ�漳�� ����� �� ���� ��ٸ�
			MouseCorrectRobot r = new MouseCorrectRobot();
			
			r.betterMouseMove(0, 0,currentscale); //betterMouseMove�� �̿��� x, y ��ǥ�� ���콺 Ŀ�� �̵�
			r.delay(delay); //���� �ֱ�
			
			r.betterMouseMove(x1,y1,currentscale);
			r.mousePress(InputEvent.BUTTON1_DOWN_MASK); //���콺 ��Ŭ�� ������
			r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); //���콺 ��Ŭ�� ����
			r.delay(delay);
			
			r.betterMouseMove(x2, y2,currentscale);
			r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			r.delay(delay);
			
			r.betterMouseMove(x3, y3,currentscale);
			Color color = r.getPixelColor(x3, y3); //x3, y3 ��ǥ�� ���� ���
			int red = color.getRed(); //���� ���� �߿� ������ �� ���
			r.delay(delay);
			
			if (red == 255) {
				r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				r.delay(delay);
			}
			
			r.betterMouseMove(x4, y4,currentscale);
			r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			r.delay(delay);
			
			r.betterMouseMove(x5, y5,currentscale);
			r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			r.delay(delay);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
