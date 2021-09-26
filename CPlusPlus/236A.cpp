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
	int cont=0;
	string s;
	cin >> s;
	sort(s.begin(),s.end());
	for (int i = 0; i < s.size(); ++i)
	{
		if (s[i]!=s[i+1])
		{
			cont+=1;
		}
	}
	if (cont%2==0 )
	{
		cout <<  "CHAT WITH HER!" ;
	}else{
		cout << "IGNORE HIM!" ;
	}

	return 0;
}
