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
    int a,b;
    cin >> a >> b;
    if (a==b)
    {
        cout << a*2;
    }else if (a>b /*&& a-1>b*/){
        cout << a+a-1;
    }else if(b>a /*&& b-1>a*/){
        cout << b+b-1;
    /*}else if(b>a && b-1==a){
        cout<< b+*/
    }
    return 0;
}