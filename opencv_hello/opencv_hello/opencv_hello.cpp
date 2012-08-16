﻿// opencv_hello.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

#include <cv.h>
#include <cxcore.h>
#include <highgui.h>

int _tmain(int argc, _TCHAR* argv[])
{
	int type = 2;

	IplImage *jpgimg = cvLoadImage("lena.jpg"); 
	const char *haarFile = "C:\\OpenCV2.2\\data\\haarcascades\\haarcascade_frontalface_alt.xml";

	if(type == 1){ // Show some jpg pic
		cvNamedWindow("Image:",1);
		cvShowImage("Image:",jpgimg);

		cvWaitKey();
		cvDestroyWindow("Image:");

	}else if(type == 2){ // face detection example (failed???)

		CvCapture *capture;
		int       key;

		CvHaarClassifierCascade *cascade = ( CvHaarClassifierCascade* )cvLoad( haarFile, 0, 0, 0 );
		CvMemStorage *storage = cvCreateMemStorage( 0 );
		// jpgimg     = cvLoadImage( "fuji.jpg", 1 ); 
		

		assert( cascade && storage && jpgimg );

		cvNamedWindow( "video", 1 );
//		detectFaces( jpgimg );

	 
		/* detect faces */
		CvSeq *faces = cvHaarDetectObjects(
				jpgimg,
				cascade,
				storage,
				1.1,
				3,
				0 /*CV_HAAR_DO_CANNY_PRUNNING*/,
				cvSize( 40, 40 ) );
	 
		/* for each face found, draw a red box */
		int i;
		for( i = 0 ; i < ( faces ? faces->total : 0 ) ; i++ ) {
			CvRect *r = ( CvRect* )cvGetSeqElem( faces, i );
			cvRectangle( jpgimg,
						 cvPoint( r->x, r->y ),
						 cvPoint( r->x + r->width, r->y + r->height ),
						 CV_RGB( 255, 0, 0 ), 1, 8, 0 );
		}
	 
		/* display video */
		cvShowImage( "video", jpgimg );



		cvWaitKey( 0 );
		cvDestroyWindow( "video" );
		cvReleaseHaarClassifierCascade( &cascade );
		cvReleaseMemStorage( &storage );

	}else if(type == 3){ // face detection example

		int i;
	   	IplImage *src_gray = 0;
		CvHaarClassifierCascade *cascade = 0;
		CvMemStorage *storage = 0;
		CvSeq *faces;
		static CvScalar colors[] = {
			{{0, 0, 255}}, {{0, 128, 255}},
			{{0, 255, 255}}, {{0, 255, 0}},
			{{255, 128, 0}}, {{255, 255, 0}},
			{{255, 0, 0}}, {{255, 0, 255}}
		};

		// (1)画像を読み込む
		src_gray = cvCreateImage (cvGetSize (jpgimg), IPL_DEPTH_8U, 1);

		// (2)ブーストされた分類器のカスケードを読み込む
		cascade = (CvHaarClassifierCascade *) cvLoad (haarFile, 0, 0, 0);

		// (3)メモリを確保し，読み込んだ画像のグレースケール化，ヒストグラムの均一化を行う
		storage = cvCreateMemStorage (0);
		cvClearMemStorage (storage);
		cvCvtColor (jpgimg, src_gray, CV_BGR2GRAY);
		cvEqualizeHist (src_gray, src_gray);

		// (4)物体（顔）検出
		faces = cvHaarDetectObjects (src_gray, cascade, storage, 1.11, 4, 0, cvSize (40, 40));

		// (5)検出された全ての顔位置に，円を描画する
		for (i = 0; i < (faces ? faces->total : 0); i++) {
			CvRect *r = (CvRect *) cvGetSeqElem (faces, i);
			CvPoint center;
			int radius;
			center.x = cvRound (r->x + r->width * 0.5);
			center.y = cvRound (r->y + r->height * 0.5);
			radius = cvRound ((r->width + r->height) * 0.25);
			cvCircle (jpgimg, center, radius, colors[i % 8], 3, 8, 0);
		}

		// (6)画像を表示，キーが押されたときに終了
		cvNamedWindow ("Face Detection", CV_WINDOW_AUTOSIZE);
		cvShowImage ("Face Detection", jpgimg);
		cvWaitKey (0);

		cvDestroyWindow ("Face Detection");
//		cvReleaseImage (&jpgimg);
		cvReleaseImage (&src_gray);
		cvReleaseMemStorage (&storage);

	}else{ // show Hello World
		cvNamedWindow( "My Window", 1 );
		IplImage *newimg = cvCreateImage( cvSize( 640, 480 ), IPL_DEPTH_8U, 1 );
		CvFont font;
		double hScale = 2.0;
		double vScale = 2.0;
		int lineWidth = 5;
		cvInitFont(&font, CV_FONT_HERSHEY_SIMPLEX | CV_FONT_ITALIC, hScale, vScale, 0, lineWidth);
		cvPutText(newimg, "Hello World!", cvPoint( 100, 200 ), &font, cvScalar( 255, 255, 0 ) );
		cvShowImage( "My Window", newimg );
		cvWaitKey();
	}

	cvReleaseImage(&jpgimg);
	
	return 0;

}




