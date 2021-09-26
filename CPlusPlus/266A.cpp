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
	int n,cont=0;
	string s;
	cin >> n;
	for (int i = 0; i < n; ++i)
	{
		cin >> s;
		if (s[i]==s[i+1])
		{
			cont+=1;
		}
	}
	cout << cont ;
	return 0;
}