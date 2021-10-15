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
   int t,a,b,c ; //cases
   cin >> t;
   while(t--){
      cin >> a >> b >> c;
     if (a==b && a==c)
     {
        cout << "1 1 1" <<endl;
        continue;

     }
     if (a<b)
     {
        cout << (b-a)+1 << " ";
     }
     else if (a<c)
     {
        cout << (c-a)+1 << " ";
     }else {
        cout << "0 ";
     }

     ///////////////////////////
     if (b<c)
     {
        cout << (c-b)+1 <<" "; 
     }
    else if (b<a)
     {
        cout << (a-b)+1 <<" "; 
     }else {
        cout << "0 ";
     }
     //////////////////////////
     if(c<b){
      cout << (b-c)+1<< " " ;
     }
      else if(c<a){
      cout << (a-c)+1<< " " ;
     }else {
      cout << "0 " ;
       }  
     
     cout << endl;
   }
    
   
   return 0;
}