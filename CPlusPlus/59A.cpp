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
	string n;
	int may=0,min=0;
	cin >> n ;
	for (int i = 0; i < n.length(); ++i)
	{
		if (n[i]==toupper(n[i]))
		{
			may+=1; 
		}else{
			min+=1;
		}
	}

	if (may>min)
	{
		for (int y = 0; y < n.length(); y++)
		{
			n[y] = toupper(n[y]);
		}
	}else{
		for (int z = 0; z < n.length(); z++)
		{
			n[z] = tolower(n[z]);
		}
	}
	cout << n;

	return 0;
}
