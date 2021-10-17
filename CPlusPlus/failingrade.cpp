#include <iostream>
using namespace std;
 void init_code(){
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif // ONLINE_JUDGE  
}
int main(){
     init_code();   
    int n,nota,estu,acum=0;
    cin >> n >> nota;
    while(n--){
        cin>>estu;
        if(estu<nota){
            acum++;
        }
    }
    cout << acum ;
    return 0;
}