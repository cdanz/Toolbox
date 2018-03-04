// AUTHOR: Craig Danz
// FILENAME: CPSC5041-HW1
// DATE: 1/18/2018
// VERSION: 1.0


#include <iostream>

using namespace std;

class Rectangle {
private:
	int length;
	int width;


public:
	Rectangle(int l, int w) {
		length = l;
		width = w;
	}
	Rectangle() {
		length = 0;
		width = 0;
	}
	void setLength(int l) {
		length = l;
	}
	void setWidth(int w) {
		width = w;
	}
	int perimeter(){
		return (2 * width) + (2 * length);
	}
	int area() {
		return (width * length);
	}
	void show() {
		cout << "len = " << length << ", width = " << width;
	}
	bool sameArea(Rectangle r) {
		return this->area() == r.area();
	}
};

/*int main(void) {
	/*1. Create an array to store five rectangle objects.
	const int SIZE = 5;
	Rectangle rects[SIZE];
	
	int tempLength = 0;
	int tempWidth = 0;
	unsigned i = 0;
	unsigned j = 0;
	unsigned index = 0;
	bool none = false;
	
	/*2. Ask user to enter the length and width of the five rectangles one by
	 * one.
	 *3. Initialize the length and width of the five rectangles in the array
	 * with values entered in step 2. (10 points)
	for(i = 0; i < sizeof(rects)/sizeof(*rects); i++) {
		cout << "\nRectangle " << (i + 1) << ":\nLength: ";
		cin >> tempLength;
		rects[i].setLength(tempLength);
		cout << "Width: ";
		cin >> tempWidth;
		rects[i].setWidth(tempWidth);
	}
	/*4. For each of the five rectangles, print their length, width, area, and
	 * perimeter one by one over five lines. For example: Rectangle 0: len = 10,
	 * width = 20, area = 200, perimeter = 60. Make sure the o/p is easy to
	 * read. (10 points)
	for(i = 0; i < sizeof(rects)/sizeof(*rects); i++) {
		cout << "Rectangle " << (i + 1) << ": ";
		rects[i].show();
		cout <<	", area = " << rects[i].area() << ", perimeter = " <<
			 rects[i].perimeter() << "." << endl;
	}
	
	/*5. Print the same information as in step 4, but only for the rectangle
	 * with smallest area. The information should be preceded by label
	 * saying “Rectangle with smallest area: ” (10 points)
	for(i = 0; i < sizeof(rects)/sizeof(*rects); i++) {
		if (i == 0)
			index = i;
		else if (rects[index].area() > rects[i].area())
			index = i;
		else ;
	}
	
	cout << "\nRectangle with smallest area:\n";
	cout << "Rectangle " << (index + 1) << ": ";
	rects[index].show();
	cout <<	", area = " << rects[index].area() << ", perimeter = " <<
		 rects[index].perimeter() << "." << endl;
	
	/*6. Print the same information as in step 4, but only for the rectangle
	 * with largest area. The information should be preceded by label  saying
	 * “Rectangle with largest area: ” (10 points)
	
	for(i = 0; i < sizeof(rects)/sizeof(*rects); i++) {
		if (i == 0)
			index = i;
		else if (rects[index].area() < rects[i].area())
			index = i;
		else ;
	}
	
	cout << "\nRectangle with largest area:\n";
	cout << "Rectangle " << (index + 1) << ": ";
	rects[index].show();
	cout <<	", area = " << rects[index].area() << ", perimeter = " <<
		 rects[index].perimeter() << "." << endl;
	
	/*7. Print the same information as in step 4, but only for the rectangle
	 * with smallest perimeter. The information should be preceded by label
	 * saying “Rectangle with smallest perimeter: ” (10 points)
	for(i = 0; i < sizeof(rects)/sizeof(*rects); i++) {
		if (i == 0)
			index = i;
		else if (rects[index].perimeter() > rects[i].perimeter())
			index = i;
		else ;
	}
	
	cout << "\nRectangle with smallest perimeter:\n";
	cout << "Rectangle " << (index + 1) << ": ";
	rects[index].show();
	cout <<	", area = " << rects[index].area() << ", perimeter = " <<
		 rects[index].perimeter() << "." << endl;
	
	/*8. Print the same information as in step 4, but only for the rectangle
	 * with largest perimeter. The information should be preceded by label
	 * saying “Rectangle with largest perimeter: ” (10 points)
	for(i = 0; i < sizeof(rects)/sizeof(*rects); i++) {
		if (i == 0)
			index = i;
		else if (rects[index].perimeter() < rects[i].perimeter())
			index = i;
		else ;
	}
	
	cout << "\nRectangle with largest perimeter:\n";
	cout << "Rectangle " << (index + 1) << ": ";
	rects[index].show();
	cout <<	", area = " << rects[index].area() << ", perimeter = " <<
		 rects[index].perimeter() << ".\n" << endl;
	
	/*9. If there are two or more rectangles with same area, print them here.
	 * For example, if area of rectangles were: r0=20, r1=30, r2=10, r3=20,
	 * r4=50, print “Rectangles r0, r3 have equal areas of 20 units each.” If
	 * none of the rectangles have equal areas, simply say “No rectangles
	 * with equal area found. (15 points)
	for(i = 0; i < sizeof(rects)/sizeof(*rects); i++) {
		for (j = i + 1; j < sizeof(rects)/sizeof(*rects); j++) {
			if (rects[i].area() == rects[j].area()) {
				cout << "Rectangles " << (i +1) << " and " << (j + 1) <<
					 " have equal areas of " << rects[i].area() <<
					 " units each.\n";
				none = true;
			}
		}
	}
	if (none == false)
		cout << "No rectangles with equal area found.\n";
	
	10. If there are two or more rectangles with same perimeter, print them
	 * here. For example, if perimeter of rectangles were: r0=20, r1=30, r2=10,
	 * r3=20, r4=50, print “Rectangles r0, r3 have equal perimeters of 20 units
	 * each.” If none of the rectangles have equal perimeters, simply say “No
	 * rectangles with equal perimeter found. (15 points)
	none = false;

	for(i = 0; i < sizeof(rects)/sizeof(*rects); i++) {
		for (j = i + 1; j < sizeof(rects)/sizeof(rects); j++) {
			if (rects[i].perimeter() == rects[j].perimeter()) {
				cout << "Rectangles " << (i + 1) << " and " << (j + 1) <<
					 " have equal perimeters of " << rects[i].perimeter() <<
					 " units each.\n";
				none = true;
			}
		}
	}
	if (none == false)
		cout << "No rectangles with equal perimeter found.\n";
	
	return 0;

}*/
