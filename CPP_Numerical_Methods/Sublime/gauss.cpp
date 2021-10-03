#include <bits/stdc++.h>
using namespace std;

void init_code(){
	#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif // ONLINE_JUDGE	
}

int main()
{
	init_code();
   cout.precision(4);
    cout.setf(ios::fixed);
   float a[10][10], b[10], m[10], n[10];
   int p = 0, q = 0, i = 0, j = 0;
   // leer tamaño del array
   cin >> p;
   for (i = 0; i < p; i++) {
      for (j = 0; j < p; j++) {
         //cout << "a[" << i << ", " << j << " ]=";
         cin >> a[i][j];
      }
   }
   //valores de la ecuacion
   for (i = 0; i < p; i++) {
     // cout << "b[" << i << ", " << j << " ]=";
      cin >> b[i];
   }
   //valores iniciales
   for (i = 0; i < p; i++) {
     // cout << "x:[" << i<<"]=";
      cin >> m[i];
   }
   // numero de iteraciones deseadas
   cin >> q;
   while (q> 0) {
      for (i = 0; i < p; i++) {
         n[i] = (b[i] / a[i][i]);
         for (j = 0; j < p; j++) {
            if (j == i)
               continue;
            n[i] = n[i] - ((a[i][j] / a[i][i]) * m[j]);
            m[i] = n[i];
         }
         cout<<"x"<<i + 1 << "="<<n[i]<<" ";
      }
      cout << "\n";
      q--;
   }

    return 0;
}