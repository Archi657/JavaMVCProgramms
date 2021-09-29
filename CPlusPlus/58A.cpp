#include <bits/stdc++.h>
using namespace std;
void init_code(){
	#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif // ONLINE_JUDGE	
}
// hleou // hhhellooo
int main(){
	init_code();
	string n,k="hello";
	int j=0,y=0;
	cin >> n ;
	bool x = false;

for (int i = 0; i < n.length(); ++i)
{
	if (n[i]==k[j])
	{
		j++ ;
		y++ ;
	}
}
if(y==5){
	cout << "YES" ;
}else {
	cout << "NO" ;
}
	

	return 0;
}
