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
	int n,x,y,z,cont=0;
	cin >> n;
	for (int i = 0; i < n; ++i)
	{
		cin >> x >> y >> z;
		if ((x+y+z)>=2)
		{
			cont+=1 ;
		}

	}
	cout << cont ;
	return 0;
}