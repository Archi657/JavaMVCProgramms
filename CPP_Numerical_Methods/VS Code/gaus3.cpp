#include<iostream>
#include<iomanip>
#include<cmath>
using namespace std;
int main()
{
    /////////////////Declaraciones Iniciales//////////////////
    cout.precision(4);
    cout.setf(ios::fixed);
    double a[100][100];         
    double x[100];                
    double precision,y,aux;
    int n,i,j,k,flag=0,count=0;
    ////////////////////////Tamaño////////////////////////////////////
    cout<<"\nCantidad de ecuaciones *Filas*\n";           
    cin>>n;                       
    //////////////////////Valor de las ecuaciones///////////////////////////////
    cout<<"\nIngresar valores de las ecuaciones :\n";
    for (i=0;i<n;i++)
        for (j=0;j<=n;j++)
            cin>>a[i][j];
    /////////////////////Inicializar variables////////////////////////////////
    cout<<"\nValor inicial de las variables :\n";
    for (i=0;i<n;i++){
        //cin>>x[i];
        x[i]=0;
     }
    ////////////////////////Ingresar precision///////////////////////////////
    cout<<"\nPrecision:\n";
    cin>>precision;
    /////////////////////////Metodo gauss////////////////////////////////
    /////////DIAGONAL PRINCIPAL////////////////////////
    for (i=0;i<n;i++){
        for (k=i+1;k<n;k++){
            if (abs(a[i][i])<abs(a[k][i])){
                for (j=0;j<=n;j++)
                {
                    aux=a[i][j];
                    a[i][j]=a[k][j];
                    a[k][j]=aux;
                }
            } 
        }   
    }                    
    cout<<"Iter"<<setw(10);
    for(i=0;i<n;i++)
        cout<<"x"<<i<<setw(18);
    cout<<"\n----------------------------------------------------------------------";
    do                            //Iteraciones para calcular xn
    {
        cout<<"\n"<<count+1<<"."<<setw(16);
        for (i=0;i<n;i++)               
        {
            y=x[i];
            x[i]=a[i][n];
            for (j=0;j<n;j++)
            {
                if (j!=i)
                x[i]=x[i]-a[i][j]*x[j]; 
            }
            x[i]=x[i]/a[i][i];
            if (abs(x[i]-y)<=precision)            //Comprar ultimo valor
                flag++;
            cout<<x[i]<<setw(18);
        }
        cout<<"\n";
        count++;   
    }while(flag<n);                        //If the values of all the variables don't differ from their previious values with error more than eps then flag must be n and hence stop the loop
    
    cout<<"\n The solution is as follows:\n";
    for (i=0;i<n;i++)
        cout<<"x"<<i<<" = "<<x[i]<<endl;        //x[]
    return 0;
}