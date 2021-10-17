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
   int n,x;
   string s;
   cin >> n >> x >> s;
  while(x--){
      for(int i=0; i<n; i++){
         if (s[i]=='B'&& s[i+1]=='G')
         {
         s[i]='G';
         s[i+1]='B';
         i++;
         }
      }  
   }
   cout << s ;
   //cout << "n "<< n<< " s "<< s  <<" x " << x<<endl;
    
   
   return 0;
}

//BGGBG //GB
//GBGGB //GB

//GBGGB
//GGBGG