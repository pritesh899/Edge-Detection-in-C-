#include "opencv2/imgproc.hpp"
#include "opencv2/highgui.hpp"
#include <string>
#include <iostream>

using namespace cv;
using namespace std;

int main()
{
    Point anchor = Point(-1, -1);
    int delta = 0;
    int ddepth = -1;
    char x_window_name[] = "X-Sobel";
    namedWindow(x_window_name, WINDOW_AUTOSIZE);
    char y_window_name[] = "Y-Sobel";
    namedWindow(y_window_name, WINDOW_AUTOSIZE);
    char window_name[] = "Sobel";
    namedWindow(window_name, WINDOW_AUTOSIZE);
    char gray_window_name[] = "Gray";
    namedWindow(gray_window_name, WINDOW_AUTOSIZE);
    char max_window_name[] = "Max Sobel";
    namedWindow(max_window_name, WINDOW_AUTOSIZE);

    Mat src, x_dst, y_dst, dst;
    string imgPath = "C:\\Users\\priteshratnappagol\\Desktop\\dog.jpg";

    Size size(500,500);
    src = imread(imgPath);
    resize(src,dst,size);
    cvtColor(dst, dst, CV_RGB2GRAY);

    double x_matrix[3][3] = {
        {-1.0,-2.0,-1.0},
        {0.0,0.0,0.0},
        {1.0,2.0,1.0}};

    Mat x_kernel = Mat(3,3,CV_64FC1,&x_matrix);

    double y_matrix[3][3] = {
        {-1.0,0.0,1.0},
        {-2.0,0.0,2.0},
        {-1.0,0.0,1.0}};

    Mat y_kernel = Mat(3,3,CV_64FC1,&y_matrix);

    filter2D(dst, x_dst, ddepth, x_kernel, anchor, delta, BORDER_DEFAULT);

    filter2D(dst, y_dst, ddepth, y_kernel, anchor, delta, BORDER_DEFAULT);

    Mat x_square, y_square, sobel, sobel_max;

    convertScaleAbs(x_dst, x_square);
	convertScaleAbs(y_dst, y_square);

	sobel_max = max(x_square, y_square);

    addWeighted(x_square, 0.5, y_square, 0.5, 0, sobel);

    imshow(x_window_name, x_dst);

    imshow(y_window_name, y_dst);

    imshow(gray_window_name, dst);

    imshow(window_name, sobel);

    imshow(max_window_name, sobel_max);

    imwrite("C:\\Users\\priteshratnappagol\\Desktop\\dog_gray_3.jpg", dst);
    imwrite("C:\\Users\\priteshratnappagol\\Desktop\\dog_x_3.jpg", x_dst);
    imwrite("C:\\Users\\priteshratnappagol\\Desktop\\dog_y_3.jpg", y_dst);
    imwrite("C:\\Users\\priteshratnappagol\\Desktop\\dog_sobel_3.jpg", sobel);
    imwrite("C:\\Users\\priteshratnappagol\\Desktop\\dog_sobel_max_3.jpg", sobel_max);

    waitKey(0);

    return 0;
}

