// opencv_hello.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

#include <cv.h>
#include <cxcore.h>
#include <highgui.h>

int _tmain(int argc, _TCHAR* argv[])
{
	int type = 1;

	if(type == 1){ // Show some fuji.jpg pic
		IplImage *img = cvLoadImage("fuji.jpg");
		cvNamedWindow("Image:",1);
		cvShowImage("Image:",img);

		cvWaitKey();
		cvDestroyWindow("Image:");
		cvReleaseImage(&img);
	}else{ // show Hello World
		cvNamedWindow( "My Window", 1 );
		IplImage *img = cvCreateImage( cvSize( 640, 480 ), IPL_DEPTH_8U, 1 );
		CvFont font;
		double hScale = 2.0;
		double vScale = 2.0;
		int lineWidth = 5;
		cvInitFont(&font, CV_FONT_HERSHEY_SIMPLEX | CV_FONT_ITALIC, hScale, vScale, 0, lineWidth);
		cvPutText(img, "Hello World!", cvPoint( 100, 200 ), &font, cvScalar( 255, 255, 0 ) );
		cvShowImage( "My Window", img );
		cvWaitKey();
	}
	return 0;
}

