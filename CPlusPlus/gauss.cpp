#include <iostream>
#include <math.h>
#include <stdlib.h>
using namespace std;
int main(){
	
	double a[3][4];
	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 4; j++)
		{
			cout << "Ingrese un valor para i = " << i << " j = " << j << endl;;
			cin >> a[i][j];
		}
	}
	
	//imprimir
	cout << "Original" << endl ;
	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 4; j++)
		{
			cout << a[i][j] << " " ;
		}
		cout << endl;
	}
	cout << endl << "Modificado" << endl;
	//convertir [0,0] en 1 pivote
	
	if (a[0][0]!=1)
	{
		int aux= a[0][0];
		for (int i = 0; i < 4; i++)
		{
			a[0][i]=a[0][i]/aux;
		}
		
	}
	//convertir en 0 [1,0]
	if(a[1][0]!=0){
	    int aux=a[1][0];
	    for (int i = 0; i < 4; i++)
		{
			a[1][i]=(a[0][i])*aux-(a[1][0]);
		}
	}
	//convertir en 0 [2,0]
	if(a[2][0]!=0){
	    int aux=a[2][0];
	    for (int i = 0; i < 4; i++)
		{
			a[2][i]=(a[0][i])*aux-(a[2][0]);
		}
	}
		//convertir 1,1 en 1 pivote
	if (a[1][1]!=1)
	{

		for (int i = 0; i < 4; i++)
		{
			a[1][i]=a[1][i]*0.8;
		}
		
	}
	
	
	//convertir en 0 [2,1]
	if(a[2][1]!=0){
	    int aux=a[2][1];
	    for (int i = 0; i < 4; i++)
		{
			a[2][i]=(a[0][i])*aux-(a[2][i]);
		}
	}
	
	if (a[2][2]!=1)
	{
		int aux= a[2][2];
		for (int i = 0; i < 4; i++)
		{
			a[2][i]=a[2][i]/aux;
		}
		
	}
	
	//imprimir
	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 4; j++)
		{
			cout << floor(a[i][j]) << " " ;
		}
		cout << endl;
	}
	
	return 0;
	
}
