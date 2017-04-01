#include<iostream>
#include<stdio.h>
#include <iomanip>
#include<math.h>

using namespace std;

int main() {
    double num = 4.2;
    cout << setprecision(2)<< fixed <<num <<endl;
    cout << setprecision(2)<< fixed <<floor(num*100)/100.0 <<endl;
    char* s = new char[100];
    sprintf(s, "%.4lf", num);
    string str = s;
    cout << str;
}
