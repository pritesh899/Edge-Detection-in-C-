# Edge-Detection-in-C++

C++ program to read in raw format image, and perform filtering by convolving it with small operators of 3*3 and 5*5 coefficients. The resulting images should be saved as raw or png format. The output images are:

(1) Computing differentiation by difference - using an edge operator such as Sobel Operator in x and y directions. Display zero difference value in gray, i.e., I(x,y)=128, and other positive and negative values scaled and shifted accordingly in the range of [0, 255]. Compute these horizontal and vertical differential images separately. For 5*5 size filter, the differential operator (filter) can be designed as the weighted rows or columns of -1, -2, 0, 2, 1. These differential vectors can be further stacked with weights 1, 2, 4, 2, 1 for 5*5 filter. Pay attention to positive edges and negative edges and possible overflow and underflow in the filtered results. In the filtering, you will select certain constants to divide the results of convolutions in order to prevent overflow of the filtered values.
(2) Computing a gradient image from the horizontal and vertical differential images. Display both results for 3*3 and 5*5 filters.

(3) Detecting edges at peaks of gradient values over a threshold. The threshold can be selected manually so that the edge results show good shape of scenes. Edge must be one pixel wide and marked in a bright intensity.
