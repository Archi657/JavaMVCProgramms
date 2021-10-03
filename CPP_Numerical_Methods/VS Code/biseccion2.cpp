#include <iostream>
#include <iomanip> // setprecision
#include <cmath>
#define PI 3.14159265
#define PRECISION 6

using namespace std;

double f(double x, int opc);
void imprimePuntos(double a, double b);
int opc;
int main()
{
   cout << setprecision(PRECISION); // Establecemos la precisión
   
   double a, b, tolerancia;

   cout << "********** INGRESE QUE FUNCION DESEA CALCULAR ***********" << endl;
   cout << "1- e^-1 * x - cos(3x) - 0.5" << endl;
   cout << "2- sen(x)" << endl;
   cout << "3- cos(x)" << endl;
   cout << "4- tan(x)" << endl;
   cout << "5- acos(x)" << endl;
   cout << "6- asin(x)" << endl;
   cout << "7- atan(x)" << endl;
   cout << "8- atan2(x)" << endl;
   cout << "9- cosh(x)" << endl;
   cout << "10- sinh(x)" << endl;
   cout << "11- tanh(x)" << endl;
   cout << "12 acosh(x)" << endl;
   cout << "13 asinh(x)" << endl;
   cout << "14 atanh(x)" << endl;
   cout << "x^4 + 3x^3 -2" << endl;
   cin >> opc ;
   cout << "\nCalculo de las raices de una funcion aplicando el metodo de la biseccion" << endl;
   cout << "\nIngrese el intervalo inicial [a, b]" << endl;
   cout << "\na = ";
   cin >> a;
   
   cout << "b = ";
   cin >> b;
   
   imprimePuntos(a, b);
   
   cout << "\nEscoja el intervalo adecuado" << endl;
   cout << "\na = ";
   cin >> a;
   
   cout << "b = ";
   cin >> b;
   
   // [a, b]
   float xr; // raiz de la función
   
   /*
   cout << "\nf(" << a << ") = " << f(a) << endl;
   cout << "f(" << b << ") = " << f(b) << endl;
   */
   
   if ( f(a,opc) * f(b,opc) > 0) {
      
      cout << "\nNo se puede aplicar el metodo de la biseccion\n";
      cout << "porque f(" << a << ") y f(" << b << ") tienes el mismo signo" << endl;
      
   } else {
      cout << "Tolerancia = ";
      cin >> tolerancia;
      cout << "\na\tb\tx\tf(a)\t\tf(b)\t\tf(x)\n" << endl;
      do {
         xr = (a + b) / 2.0;
         cout << a << "\t" << b << "\t" << xr << "\t";
         cout << f(a,opc) << "\t" << f(b,opc) << "\t" << f(xr,opc) << endl;

         // Vemos si cumple o no cumple
         if (abs(f(xr,opc)) <= tolerancia) { // xr sería la raiz de f
         
            cout << "\n\nPara una tolerancia " << tolerancia << " la raiz de f es " << xr << endl;
         
            break;
            
         } else {
            if (f(xr,opc) * f(a,opc) > 0) {
               a = xr;
            } else if (f(xr,opc) * f(b,opc) > 0) {
               b = xr;
            }
         }
         
      } while (1);
   }
   
   cin.get();
   cin.get();
   return 0;
}


double f(double x, int opc) 
{
   return exp(-1 * x) - cos(3 * x) - 0.5;
   switch (opc)
   {
   case 1:
      return exp(-1 * x) - cos(3 * x) - 0.5;
      break;
   case 2:
      return sin (x*PI/180);
      break;
   case 3:
      return cos ( x * PI / 180.0 );
      break;
   case 4:
      return tan ( x * PI / 180.0 );
      break;
   case 5:
      return acos (x) * 180.0 / PI;
      break;
   case 6:
      return asin (x) * 180.0 / PI;
      break;
   case 7:
      return atan (x) * 180 / PI;
      break;
   case 9:
      return cosh (x);
      break;
   case 10:
      return sinh (x);
      break;
   case 11:
      return tanh(x) ;
      break;
   case 12:
      return acosh(x);
      break;
   case 13:
      return asinh(x);
      break;
   case 14:
      return atanh(x);
      break;
   default:
      break;
   }
   
}

#define INTERVALOS 10
void imprimePuntos(double a, double b)
{
   int puntos = INTERVALOS + 1;
   
   double ancho = (b - a) / INTERVALOS;
   
   cout << "\n";
   cout << "\tx\tf(x)\n" << endl;
   for (int i = 0; i < puntos; i++) {
      cout << "\t" << a << "\t" << f(a,opc) << endl;
      a = a + ancho;
   }
}