#include "stdafx.cpp"

#ifdef CPRAPRA

#include <opencv2/opencv.hpp>
#include <vector>

using namespace cv;
using namespace std;

int main () {
  Mat img = imread("lena.jpg");
  namedWindow("mywindow");
  imshow("mywindow", img);
  waitKey();
  return 0;
}

#endif