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
    int n,a=0,d=0;
    cin >> n;
    string s;
    cin >> s ;
    for (int i = 0; i < s.length(); ++i)
    {
        if(s[i]=='A'){
            a+=1;
        }else{
            d+=1;
        }
    }
    if (a>d)
    {
        cout << "Anton" ;
    }else if(a<d){
        cout << "Danik" ;
    }else if(a==d){
        cout << "Friendship" ;
    }
    
    return 0;
}