package Main;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JOptionPane;
import java.awt.event.InputEvent;

public class Main {
	public static int x1=0,y1=0,x2=0,y2=0,x3=0,y3=0,x4=0,y4=0,x5=0,y5=0; //마우스가 이동할 좌표
	public static int delay = 300; //마우스 클릭 후 지연시간
	public static float currentscale = 1.0f; //현재 화면 배율(100%: 1.0f, 125%: 1.25f)
	
	public static void main(String[] args) {
		//기본 스크린 정보
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		//화면 가로 길이
		int width = gd.getDisplayMode().getWidth();
		//화면 세로 길이
		int height = gd.getDisplayMode().getHeight();
		//화면 배율(100%: 96)
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
			y3 = 543;
			
			x4 = 1488;
			y4 = 894;
			
			x5 = 1216;
			y5 = 900;
			
			currentscale = 1.25f;
		}
		//not supported
		else {
			JOptionPane.showMessageDialog(null, "이 디스플레이는 지원되지 않습니다.\n"
					+ "지원되는 해상도: \n"
					+ "1920x1080(FHD) 100%,125% 배율\n"
					+ "2560x1440(QHD) 100% 배율");
			return;
		}
		run();
	}
	
	public static void run() {
		Runtime rt = Runtime.getRuntime();
		String execPro = "C:\\V3-noAd.bat";
		Process p;
		try {
			p = rt.exec(execPro); //V3 환경설정 실행
			p.waitFor(); //V3 환경설정 실행될 때 까지 기다림
			MouseCorrectRobot r = new MouseCorrectRobot();
			
			r.betterMouseMove(0, 0,currentscale); //betterMouseMove를 이용해 x, y 좌표에 마우스 커서 이동
			r.delay(delay); //지연 주기
			
			r.betterMouseMove(x1,y1,currentscale);
			r.mousePress(InputEvent.BUTTON1_DOWN_MASK); //마우스 좌클릭 누르기
			r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); //마우스 좌클릭 떼기
			r.delay(delay);
			
			r.betterMouseMove(x2, y2,currentscale);
			r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			r.delay(delay);
			
			r.betterMouseMove(x3, y3,currentscale);
			Color color = r.getPixelColor(x3, y3); //x3, y3 좌표의 색깔 얻기
			int red = color.getRed(); //얻은 색깔 중에 빨간색 값 얻기
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
