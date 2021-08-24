#include <bits/stdc++.h>
using std::cout;
using std::cin;

int main(){
	int m;
	for (int i=0; i<5; i++){
		for(int j=0; i<5; i++){
			cin>>m;
			if(m==1){
				cout << (j-3)+(i-3);
				return 0;
			}
		}
	}
	

	return 0;
}
