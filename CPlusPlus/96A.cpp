#include <bits/stdc++.h>
using namespace std;
void init_code(){
	#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif // ONLINE_JUDGE	
}
bool encontrar();
string s;
int cont;
int main(){
	init_code();
	
	cin >> s;
	
	
	for (int i = 0; i < s.length(); ++i)
	{	
		if(s[i]==s[i+1]){
			cont+=1;
			if (cont >=6)
			{
				cout << "YES " ;
				return 0;
			}
		}else {
			cont=0;
		}
	}
	cout << "NO" ;
	return 0;
}

