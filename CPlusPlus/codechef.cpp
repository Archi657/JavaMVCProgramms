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
   int n,a,b,c;
   cin >> n;
   for(int i=0; i<n; i++){
      cin>>a>>b>>c;
      if (a==7 || b==7|| c==7)
      {
         cout << "YES"<<endl;
         continue;
      }
      cout << "NO" << endl;
   }
   return 0;
}