#include<stdio.h>
#include<conio.h>
#include<math.h>
#include<iostream>
#define ESP 0.001
#define F(x) (x)*(x)*(x) + (x) + 10
#define a3 1
#define a2 0
#define a1 1
#define a0 10
using namespace std;
//#define c3  0void main()
int main(){
  double u,v,u1,v1,u2,v2,b3,b2,p,b1,b0,c2,c1,c0,U,V;
  int i=1;
  float c3=0;
  printf("\nEnter the value of u: ");
  scanf("%lf",&u);
  printf("\nEnter the value of v: ");
  scanf("%lf",&v);
  b3=a3;
  b2=a2+u*b3;
  b1=a1+u*b2+v*b3;
  b0=a0+u*b1+v*b2;
  c2=b3;
  c1=b2+u*c2+v*c3;
  c0=b1+u*c1+v*c2;
  p=c1*c1-c0*c2;
  U=((-(b1*c1-b0*c2))/(p));
  V=((-(b0*c1-c0*b1))/(p));
  u1=u+U;
  v1=v+V;
  printf("\n\n b0 = %lf",b0);
  printf("\n\n b1 = %lf",b1);
  printf("\n\n b2 = %lf",b2);
  printf("\n\n b3 = %lf",b3);
  printf("\n\n c0 = %lf",c0);
  printf("\n\n c1 = %lf",c1);
  printf("\n\n c2 = %lf",c2);
  printf("\n\n c3 = %lf",c3);
  printf("\n\n * * * u = %lf * * *",u1);
  printf("\n\n * * * v = %lf * * *",v1);

  do
  {
   u=u1;
   v=v1;
   b3=a3;
   b2=a2+u*b3;
   b1=a1+u*b2+v*b3;
   b0=a0+u*b1+v*b2;
   c2=b3;
   c1=b2+u*c2+v*c3;
   c0=b1+u*c1+v*c2;
   p=c1*c1-c0*c2;
   U=((-(b1*c1-b0*c2))/(p));
   V=((-(b0*c1-c0*b1))/(p));
   u2=u+U;
   v2=v+V;
   printf("\n\n b0 = %lf",b0);
   printf("\n\n b1 = %lf",b1);
   printf("\n\n b2 = %lf",b2);
   printf("\n\n b3 = %lf",b3);
   printf("\n\n c0 = %lf",c0);
   printf("\n\n c1 = %lf",c1);
   printf("\n\n c2 = %lf",c2);
   cout << c3 ;
   printf("\n\n  u = %lf ",u2);
   printf("\n\n  v = %lf ",v2);

   if(fabs(u1 - u2) < ESP && fabs(v1-v2) < ESP)
   {
    printf("\n\nREAL ROOT = %.3lf",u2);
    printf("\n\nREAL ROOT = %.3lf",v2);
    i=0;
   }
   else
   {
     u1 = u2;
     v1 = v2;
   }
  }while(i!=0);
getch();
}