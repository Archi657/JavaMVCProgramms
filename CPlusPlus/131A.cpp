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
    string n,may,min;
    cin >> n;
    /*for (int i = 1; i < n.length(); ++i)
    {
        if (n[0]==toupper(n[0]) && n[i]==tolower(n[i]))
        {
            cout << n ;
            return 0 ;
        }
        if (n[0]!=toupper(n[0]) && n[i]==tolower(n[i]))
        {
            cout << n ;
            return 0 ;
        }
        
    }*/
    
    for (int i = 0; i < n.length(); ++i)
    {
        may[i] = toupper(n[i]);
        min[i] = tolower(n[i]);
    }
    cout << may << " " << min ; 
   /* if (n==may)
    {
        cout << min ;
    }else if (n==min){
        cout << may ;
    }

    for (int i = 1; i < n.length(); ++i)
    {
        n[0]=toupper(n[0]);
        n[i]=tolower(n[i]);
    }
    cout << n ;*/
    return 0;
}