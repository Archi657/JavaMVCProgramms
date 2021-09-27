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
	int a,v[100][100],x=0,y=0,z=0;
	cin>>a;
    for (int i = 0; i < a; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            cin >> v[i][j];
        }
        x+=v[i][0];
        y+=v[i][1];
        z+=v[i][2];
    }
    for (int i = 0; i < a; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            cout << "v["<<i<<"]="<< v[i][j] << endl;
        }
    }
    /*

    if (z==0 && x ==0 && y==0)
    {
        cout << "YES" ;
    }else{
        cout << "NO" ;
    }
	*/
	return 0;
}

