#include<iostream>
#include <string>

using namespace std;

string& multiply(string& a, string& b, int lenA, int lenB);

int main() {
    char a[20010], b[20010];
    cin >> a >> b;
    string strA = a;
    string strB = b;
    
    int lenA = strA.size();
    int lenB = strB.size();
    
    if (lenA > lenB) cout << multiply(strB, strA, lenB, lenA);
    else cout << multiply(strA, strB, lenA, lenB);
}

string& multiply(string& a, string& b, int lenA, int lenB) {
    //matrix is used to save multiply result
    int** matrix = new int*[lenA];

    for(int i = 0; i < lenA; i++) {
        matrix[i] = new int[lenB];

}
