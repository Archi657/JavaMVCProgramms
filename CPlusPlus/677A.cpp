#include <bits/stdc++.h>
using namespace std;
void init_code(){
	#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif // ONLINE_JUDGE	
}
int n,h,x,ans;
 
int main()
{
	init_code();
    cin>>n>>h;
    int ans=0;
    while(n--){
    	cin>>x;
        if(x>h){
            ans++;
        }
        ans++;
    }
        
    
    cout<<ans<<"\n";
    return 0;
}