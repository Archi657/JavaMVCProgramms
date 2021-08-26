#include <iostream>
#include <fstream>
#include <stdlib.h>
#include <time.h>
#include <windows.h>
#include <ctime> 
#include "solucion.h"
#include <iomanip>

using namespace std;

// Variables acumuladora, al ser los metodos recursivos, se debio hacerlos globales
int operacionesQuickSort = 0;
int operacionesMergeSort = 0;

// Funcion principal

int main(){
	 long num; int x; 
	 long *arreglo, *arregloBur, *arregloSele, *arregloInser, *arregloMergesort, *arregloQuicksort;
	 cout << "Cual es el tamaño de la muestra: "<<endl;
	 cin >> num;
	 arreglo = new long[num];
     arregloBur = new long[num];
     arregloSele = new long[num];
     arregloInser = new long[num];
     arregloMergesort = new long[num];
     arregloQuicksort = new long[num];
     
   	generarMuestra(arreglo, num);

	for(long i=0; i<=num; i++){
			arregloBur[i] = arreglo[i];}
			algoBurbuja(arregloBur, num);
	

	for(long i=0; i<=num; i++){
		  arregloSele[i] = arreglo[i];}
		algoSeleccion(arregloSele, num);	
	
	for(long i=0; i<=num; i++){
		arregloInser[i] = arreglo[i];}
		algoInsercion(arregloInser, num);	
	
	for(long i=0; i<=num; i++){
	arregloMergesort[i] = arreglo[i];}
	algoMergeSort(arregloMergesort, num);	
	
	for(long i=0; i<=num; i++){
	 arregloQuicksort[i] = arreglo[i];}
	algoQuickSort(arregloQuicksort, num);	
	
	
	return EXIT_SUCCESS;
}

// Metodo que lee el TXT
void generarMuestra(long arreglo[], long num){
	ifstream archivo;

	if(num > 0 && num < 801){
	archivo.open("Entrada-800.txt",ios::in);
	}
    
    else if(num > 802 && num < 8001){
	archivo.open("Entrada-8000.txt",ios::in);
	}
	
	else if(num > 8002 && num < 80001){
	archivo.open("Entrada-80000.txt",ios::in);
	}
	int i = 0;
    while(!archivo.eof()){
            archivo>>arreglo[i];   
            i++;
    }
    cout<<"Se leyo el TXT"<<num<<" el arreglo tiene la siguiente cantidad de datos "<<i<<endl;  
}

// Organiza utilizando el ordenamiento Burbuja
void algoBurbuja(long arreglo[], long num){
	unsigned t0, t1;
	int aux=0, operaciones=0; t0=clock();
	for(int i=0 ; i<num; i++) {
		for(int j=i+1 ; j<num; j++) {
			if(arreglo[j] < arreglo[i]){
				aux = arreglo[i];
				arreglo[i]=arreglo[j];
				arreglo[j]=aux;
				operaciones++; 
			}	
		}
	} 
	t1 = clock();
	double time = (double(t1-t0)/CLOCKS_PER_SEC);
	cout << "Tiempo ejecutado Met. Burbuja  TXT"<<num<<" es " << setprecision(10) <<  time << " Con " << operaciones<<" operaciones" << endl;
}

// Organiza utilizando el ordenamiento Seleccion
void algoSeleccion(long arreglo[], long num){
	unsigned t0, t1;
	int aux=0, operaciones=0, men=0; t0=clock();
	for (int i=0;i<num;i++) {
        men=i;
        for(int j=i+1;j<num;j++){
            if(arreglo[j]<arreglo[men]){
                men=j;
                operaciones++; 
            }
        }
        aux=arreglo[i];
        arreglo[i]=arreglo[men];
        arreglo[men]=aux;
        operaciones++; 
    }
   	t1 = clock();
	double time = (double(t1-t0)/CLOCKS_PER_SEC);
	cout << "Tiempo ejecutado Met. Seleccion  TXT"<<num<<" es " << setprecision(8) <<  time << " Con " << operaciones<<" operaciones" << endl;
	
}

// Organiza utilizando el ordenamiento Inserccion
void algoInsercion(long arreglo[], long num){
	unsigned t0, t1;
	int aux=0, pos=0, operaciones=0, men=0; t0=clock();
	for (int i=0;i<num;i++ ){
        pos=i;
        aux=arreglo[i];
        while((pos>0) && (arreglo[pos-1]>aux)){
            arreglo[pos] = arreglo[pos-1];
            pos--;
            operaciones++; 
        }
        arreglo[pos]=aux;
        operaciones++; 
    }
   	t1 = clock();
	double time = (double(t1-t0)/CLOCKS_PER_SEC);
	cout << "Tiempo ejecutado Met. Insersion  TXT"<<num<<" es " << setprecision(10) <<  time << " Con " << operaciones<<" operaciones" << endl;
}

// Organiza utilizando el ordenamiento QuickSort
void algoQuickSort(long arreglo[], long num){
	unsigned t0, t1;
	t0=clock();
	QuickSort(arreglo,0,num);
	t1 = clock();
	double time = (double(t1-t0)/CLOCKS_PER_SEC);
    cout << "Tiempo ejecutado Met. QuickSort  TXT"<<num<<" es " << setprecision(15) <<  time << " Con " << operacionesQuickSort<<" operaciones" << endl;
}

// Metodo secundario para organizar en QuickSort
void QuickSort(long* arreglo, int izq, int num) { 

     int i = izq, j = num, tmp; 
     int p = arreglo[(izq + num) / 2]; 
     while (i <= j) { 
          while (arreglo[i] < p) i++; 
          while (arreglo[j] > p) j--; 
          if (i <= j) 
           { 
               tmp = arreglo[i]; 
               arreglo[i] = arreglo[j]; 
               arreglo[j] = tmp; 
               i++; j--; 
               operacionesQuickSort++; 
          } 
     } 
     if (izq < j) {
     	 QuickSort(arreglo, izq, j);
     	 operacionesQuickSort++; 
	 }  
     if (i < num) {
     	 QuickSort(arreglo, i, num);
     	 operacionesQuickSort++; 
	 }

}
// Organiza utilizando el ordenamiento MegaSort
void algoMergeSort(long arreglo[], long num){
	unsigned t0, t1;
	t0=clock();
	mergeSort(arreglo,0,num);
	t1 = clock();
	double time = (double(t1-t0)/CLOCKS_PER_SEC);
    cout << "Tiempo ejecutado Met. MegaSort  TXT"<<num<<" es " << setprecision(15) << time << " Con " << operacionesMergeSort<<" operaciones" << endl;
}

// Metodo secundario para organizar en QuickSort
void merge(long arreglo[], int l, int m, int r)
{
    int n1 = m - l + 1;
    int n2 = r - m;
    long L[n1], R[n2];

    for (int i = 0; i < n1; i++)
        L[i] = arreglo[l + i];
       	operacionesMergeSort++;
    for (int j = 0; j < n2; j++)
        R[j] = arreglo[m + 1 + j];
     	operacionesMergeSort++;

    int i = 0;
    int j = 0;
    int k = l;
 
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arreglo[k] = L[i];
            i++;
          	operacionesMergeSort++;
        }
        else {
            arreglo[k] = R[j];
            j++;
          	operacionesMergeSort++;
        }
        k++;
      	operacionesMergeSort++;
    }
    while (i < n1) {
        arreglo[k] = L[i];
        i++;
        k++;
       	operacionesMergeSort++;
    }
    while (j < n2) {
        arreglo[k] = R[j];
        j++;
        k++;
       	operacionesMergeSort++;
    }
}

// Metodo secundario para organizar en QuickSort
void mergeSort(long arreglo[],int l,int r){
    if(l>=r){
    	operacionesMergeSort++;
        return;
    }
   	operacionesMergeSort++;
    int m =l+ (r-l)/2;     	
    mergeSort(arreglo,l,m);     	
    mergeSort(arreglo,m+1,r);     	
    merge(arreglo,l,m,r);     	
}
