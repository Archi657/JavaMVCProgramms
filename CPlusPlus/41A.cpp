#include <bits/stdc++.h>
using namespace std;
void init_code(){
	#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif // ONLINE_JUDGE	
}
int main()
{
	init_code();
    string n,s,news;
    cin >> n >> s ;
    for (int i = s.size()-1; i>=0;--i)
    {
        news+=s[i];
    }
    if (n==news)
    {
        cout << "YES" ;
    }else{
        cout << "NO" ;
    }

    
    return 0;
}