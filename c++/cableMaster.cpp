#include<iostream>
#include<math.h>
#include <iomanip>
#include<stdio.h>

const double PRECISION = 1e-8;
using namespace std;

double* input(int n, double* sum);

int isSatisfied(double* a, int n, int k, double len);

double cutCable(double* a, int n, int k, double sum);

int main() {

    int n , k;

    cin >> n >> k;

    double sum;

    double* a = input(n, &sum);

    double d = cutCable(a, n, k, sum);

    cout << fixed << setprecision(2)<< floor(d*100)/100.0<< endl; 
}

double* input(int n, double* sum) {

    if (n <=0 ) return new double[0];

    double* a = new double[n];

    for (int i = 0; i < n; i++) {
        double temp = 0;
        cin >> temp;
        *sum += temp;
        a[i] = temp;
    }

    return a;
}

double cutCable(double* a, int n, int k, double sum) {

    double l = 0 , h = sum/k;

    while (fabs(h-l) > PRECISION) {

        double mid = (l + h) / 2;

        if (isSatisfied(a, n, k, mid)) l = mid;

        else  h = mid;

    }

    return l;
}

int isSatisfied(double* a, int n, int k, double len) {

    int count = 0; 
    for (int i = 0; i < n; i++) {
        count += (int)(a[i]/len);
    }

    if (count >= k)  return 1;
    
    return 0;
}
