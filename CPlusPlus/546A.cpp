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
	int p=0,k,w,n;
    cin >> k >> w >> n ;
    for (int i = 1; i < n+1; ++i)
    {
        p+=k*i;
    }
    if (p>w)
    {
        cout << p-w ;
    }else {
        cout << "0" ;
    }
	return 0;
}

