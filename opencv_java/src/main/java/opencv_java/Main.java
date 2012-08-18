package opencv_java;

import javax.swing.JFrame;

import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvMemStorage;
import com.googlecode.javacv.cpp.opencv_core.CvRect;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.CvSeq;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_highgui;
import com.googlecode.javacv.cpp.opencv_legacy.CvFace;
import com.googlecode.javacv.cpp.opencv_objdetect;
import com.googlecode.javacv.cpp.opencv_objdetect.CvHaarClassifierCascade;


public class Main {
	public static void main(String[] args){
		final IplImage image = opencv_highgui.cvLoadImage("C:\\Users\\jaoki\\coding\\git_playground\\opencv_hello\\opencv_hello\\lena.jpg");
		
//		CvHaarClassifierCascade cascade = (CvHaarClassifierCascade) opencv_core.cvLoad("C:\\tools\\OpenCV2.2\\data\\haarcascades\\haarcascade_frontalface_alt.xml");
//		CvHaarClassifierCascade cascade = (CvHaarClassifierCascade) opencv_core.cvLoad("C:/tools/OpenCV2.2/data/haarcascades/haarcascade_frontalface_alt.xml");
		CvHaarClassifierCascade cascade = new CvHaarClassifierCascade(opencv_core.cvLoad("C:/tools/OpenCV2.2/data/haarcascades/haarcascade_frontalface_alt.xml")) ;
		CvMemStorage storage = opencv_core.cvCreateMemStorage(0);
		CvSeq faces = opencv_objdetect.cvHaarDetectObjects(image, cascade, storage, 1.1, 3, 0);
		for(int i = 0; i < faces.total(); i++){
			CvRect r = new CvRect(opencv_core.cvGetSeqElem(faces, i));
			opencv_core.cvRectangle(image, opencv_core.cvPoint(r.x(), r.y()), opencv_core.cvPoint(r.x() + r.width(), r.y() + r.height()), CvScalar.YELLOW, 1, 8, 0);
			
		}

		final CanvasFrame canvas = new CanvasFrame("opencv java");
		canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas.showImage(image);
		opencv_core.cvReleaseMemStorage(storage);

	}
}
