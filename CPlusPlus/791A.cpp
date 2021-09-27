#include <bits/stdc++.h>
using namespace std;
void init_code(){
	#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif // ONLINE_JUDGE	
}

int main(){
	init_code();
	int a,b,cont=0;
    cin >> a >> b ;
    //a  * 3 // b * 2 
    do{
        a*=3;
        b*=2;
        cont++;
    }while(a<=b);
    //cout << "a " << a << endl << "b " << b << endl;  
    cout << cont ; 
	return 0;
}

