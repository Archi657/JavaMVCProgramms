#include <iostream>
#include <iomanip>
#include <vector>
#include <complex>
using namespace std;

using poly = vector<double>;
using cmplx = complex<double>;

//======================================================================

// Solve quadratic equation a.x^2 + b.x + c = 0
void solveQuad( double a, double b, double c, cmplx &root1, cmplx &root2 )
{
   cmplx det = b * b - 4 * a * c;
   root1 = ( -b + sqrt( det ) ) / ( 2.0 * a );
   root2 = -( b / a  + root1 );
}

//======================================================================

// Evaluate polynomial P(z)
cmplx evaluate( const poly &P, cmplx z )
{
   cmplx result = 0;
   for ( int i = P.size() - 1; i >= 0; i-- ) result = P[i] + z * result;
   return result;
}

//======================================================================

// Bairstow's method (see Wikipedia)
// Seek to write polynomial A as (x^2 + ux + v)B
// where B is a polynomial of (2-)lower degree
void quadFactor( const poly &A, double &u, double &v, poly &B )
{
   const double TOLSQ = 1.0e-40;             // convergence tolerance
   const int ITERMAX = 100;                  // maximum number of iterations

   int n = A.size() - 1;                     // degree of polynomial
   double c = 1, d = 1;
   int iter = 0;

   while ( c * c + d * d >= TOLSQ && iter < ITERMAX )
   {
      poly F( 1 + n, 0.0 );
      B = poly( 1 + n, 0.0 );
      for ( int i = n - 2; i >= 0; i-- )
      {
         B[i] = A[i+2] - u * B[i+1] - v * B[i+2];
         F[i] = B[i+2] - u * F[i+1] - v * F[i+2];
      }
      c = A[1] - u * B[0] - v * B[1];
      d = A[0] - v * B[0];
      double g = B[1] - u * F[0] - v * F[1];
      double h = B[0] - v * F[0];
      double det = v * g * g + h * ( h - u * g );
      u -= ( -h     * c +   g           * d ) / det;
      v -= ( -g * v * c + ( g * u - h ) * d ) / det;
      iter++;
   }
   if ( iter >= ITERMAX ) cout << "Not converged\n";
   B.pop_back();   B.pop_back();            // quotient polynomial has degree two less
}

//======================================================================

// Apply Bairstow's approach to successively remove quadratic factors
vector<cmplx> Bairstow( poly A )
{
   vector<cmplx> roots;                     // roots of polynomial 

   while ( A.size() > 2 )                   // at least quadratic 
   {
      poly B;                               // quotient polynomial
      int n = A.size();
      double u = A[n-2] / A[n-1];           // guessed start values
      double v = A[n-3] / A[n-1];
      quadFactor( A, u, v, B );             // seek quadratic factor x^2 + ux + v
      
      cmplx root1, root2;
      solveQuad( 1.0, u, v, root1, root2 ); // solve quadratic
      roots.push_back( root1 );
      roots.push_back( root2 );
      A = B;                                // continue with quotient
   }
                                            // any remaining linear factor
   if ( A.size() == 2 ) roots.push_back( -A[0] / A[1] );

   return roots;
}

//======================================================================

int main()
{
   poly P = { 6, 11, -33, -33, 11, 6 };     // polynomial is P0 + P1.x + P2.x^2 + ... 

   vector<cmplx> roots = Bairstow( P );     // get roots 

   cout << setw( 30 ) << "Root z" << setw( 30 ) << "abs( P(z) )\n";
   for ( cmplx z : roots )
   {
      cout << setw( 30 ) << z << setw( 30 ) << abs( evaluate( P, z ) ) << '\n';
   }
}