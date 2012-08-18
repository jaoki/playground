package opencv_java;

import javax.swing.JFrame;

import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_highgui;

public class Main {
	public static void main(String[] args){
		final IplImage image = opencv_highgui.cvLoadImage("C:\\Users\\jaoki\\coding\\git_playground\\opencv_hello\\opencv_hello\\lena.jpg");
		final CanvasFrame canvas = new CanvasFrame("opencv java");
		canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas.showImage(image);

	}
}
