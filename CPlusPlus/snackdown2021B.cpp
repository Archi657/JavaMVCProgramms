#include<iostream>
#include<vector>
using namespace std;
int main(){
    int n;
    cin>>n;
    while(n--){
        int india = 0;
        int england = 0;
        int draw = 0;
        vector<int>vec1;
        for(int i=0;i<5;i++){
            int a;
            cin>>a;
            vec1.push_back(a);
        }
        for (int i = 0; i < vec1.size(); i++)
        {
            if(vec1[i] == 1){
                india = india +1;
            }
            else if (vec1[i] == 2){
                england = england+1;
            }
            else {
                draw = draw +1;
            }
        }
        if(india > england){
            cout<<"INDIA"<<endl;
        }
        else if(england>india){
            cout<<"ENGLAND"<<endl;
        }
        else {
            cout<<"DRAW"<<endl;
        }
        
    }
}

/*#include <iostream>
using namespace std;
int main(){
   int n,t[5];
   int ind=0,eng=0,draw=0;
   cin >> n;
   while(n--){
   for (int i = 0; i < 4; i++)
   {
      cin>>t[i];
      if (t[i]==1)
      {
         ind++;
      }
      if(t[i]==2){
         eng++;
      }else{
         draw++;
      }
   }
   if(ind<eng){
      cout << "ENGLAND" << endl;
   }
   else if (ind>eng)
   {
      cout << "INDIA" << endl;
   }else{
      cout << "DRAW" << endl;
   }
   ind=eng=draw=0;
   }
  return 0;
}


/*
Ri=0  denotes that the test match ends in a draw. 
Ri=1 denotes that the test match is won by India.
 Ri=2 denotes that the test match is won by England.
*/