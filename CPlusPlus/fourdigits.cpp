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
    string s;
    cin >> s;
    while(s.length()<4){
        s.insert(0,"0");
    }
    cout << s ;
    return 0;
}