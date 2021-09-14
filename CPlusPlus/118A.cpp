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
	string s,k;
	cin>>s;
	for (int i = 0; i < s.length(); ++i)
	{
		if (s[i]!='a' && s[i]!='e' && s[i]!='i' && s[i]!='o' && s[i]!='u' && s[i]!='A' && s[i]!='E' && s[i]!='I' && s[i]!='O' && s[i]!='U' && s[i]!='Y' && s[i]!='y' )
		{
			k= k+".";
			k=k+(char) tolower(s[i]);  
		}
	}
	cout << k ;
	return 0;
}