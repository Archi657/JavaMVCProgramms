#include <stdlib.h>
#include <iostream>
using namespace std;

struct nodo{
	int n;
	nodo *izq, *der,*sig,*ant;
};
// entrada.txt input
// results.txt output
FILE *entrada;

void leermostrar(); //leer txt - mostrar lista doble                                   // Read data entrada.txt 
void leerarbol();//Pedir en que orden desea ingresar datos al arbol                    //List to tree, order by user + show links in x level + search x number
void enlazar(nodo *aux, nodo *n);//Enlazar al arbol                                    //Link (list and tree)
void mostrarinorden(nodo *aux);//Mostrar inorden                                       //in order tree
void mostrarpreorden(nodo *aux);//Mostrar preorden                                     //pre order tree
void mostrarpostorden(nodo *aux);//Mostrar postorden                                   //post order tree
void hojas(nodo *aux);//Mostrar elementos hojas "no tienen hijos"                      //tree leaves
void hijo(nodo *aux);//Mostrar elementos con un solo hijo                              //son
void buscar(nodo *aux, int); //Buscar dato, devolver true si lo encuentra              //search x number and show level
void buscardato(); //Llama la funcion buscar y le lleva el dato que tiene que encontrar//search x number and show level
void nivel(nodo *aux); //Encontrar nivel del dato "izquierda"                          //show level by left side
void nivel2(nodo *aux); //Encontrar nivel del dato "derecha"                           //show level by right side   
void out();// imprimir en pantalla y txt                                               //c out in screen and create results.txt

int a,b,cont3,cont4,cont2;

nodo *raiz,*p,*cab,*ult,*aux,*aux2;

bool x=false;

int main(){ //Main
	a=b=cont3=cont2=cont4=0;
	leermostrar(); //read+show list
	leerarbol(); //List to tree, order by user + show links in x level + search x number
	out();
	return 0;
}

void leermostrar(){ //read+show list

entrada = fopen ("entrada.txt", "r");

while( !feof(entrada) ) {
	p=(nodo *) malloc (sizeof(struct nodo));
    fscanf(entrada,"%i",&p->n);
    if(cab==NULL){
			p->ant=p->sig=NULL;
			cab=ult=p;	
		 }
		else{
	    	p->sig=cab;
			p->ant=NULL;
	    	cab->ant=p;
			cab=p;
		}
	}
	aux=cab;
		cout << "Lista desde el inicio :" << endl;
		aux=cab;
		
		while(aux!=NULL){
		    cout << " " << aux->n;
		    aux = aux->sig;
		}
		cout << "\nLista desde el final :" << endl;
		aux=ult;
		while(aux!=NULL){
		    cout <<" " << aux->n;
		    aux = aux->ant;
		}
		fclose(entrada);		
}

void leerarbol(){ //List to tree, order by user + show links in x level + search x number
	int x;
	cout << "\n\nEn que orden desea ingresar los nodos al arlbol?\n\n1.Desde el inicio\n2.Desde el final\n\nDigite una opcion"<<endl; cin>>x;
	switch(x) {
		case 1:
			aux=cab;
		while(aux!=NULL){
			p=(nodo *) malloc (sizeof(struct nodo));
			p->n=aux->n;
        	p->izq=p->der=NULL;
            enlazar(raiz,p);
            aux=aux->sig;           
		}
		break;
		case 2:
			aux=ult;
		while(aux!=NULL){
			p=(nodo *) malloc (sizeof(struct nodo));
			p->n=aux->n;
			p->izq=p->der=NULL;
			enlazar(raiz,p);
			aux=aux->ant;	
		}
		break;
		default:
			cout<<"No ingreso una opcion valida (1-Desde el inicio , 2-Desde el final)"<<endl;
		    break;;
   }	
   cout << "Que dato desea buscar en el arbol: " << endl; cin >> a;	
   cout << "Mostrar nivel del dato: " << endl; cin >> b;
}

void enlazar(nodo *aux,nodo *n){	//Link (list and tree)
	if(aux==NULL){
		raiz=n;
	}else{
		if(n->n<aux->n){
			
			if(aux->izq==NULL){
				aux->izq=n;
			}else{
				enlazar(aux->izq,n);
			}
		}else if(n->n>aux->n){
			
			if(aux->der==NULL){
				aux->der=n;
			}else{
				enlazar(aux->der,n);
			}
		}
	}
}


void out(){ 	//Show in screen + create txt


	system("cls");
	entrada=fopen("results.txt","w");
	fprintf(entrada,"%s","Elementos al recorrer el arbol inorden: "); cout<<  "Inorden: "; mostrarinorden(raiz); cout << endl; fprintf(entrada,"%s","\n");
	fprintf(entrada,"%s","Elementos al recorrer el arbol preorden: "); cout << "Preorder: "; mostrarpreorden(raiz); cout << endl; fprintf(entrada,"%s","\n");
	fprintf(entrada,"%s","Elementos al recorrer el arbol posorden: "); cout << "Posorden: "; mostrarpostorden(raiz); cout << endl; fprintf(entrada,"%s","\n");
	fprintf(entrada,"%s","Elementos hojas: "); cout << "Hojas: "; hojas(raiz);  cout << endl; fprintf(entrada,"%s","\n");                                                     
	fprintf(entrada, "%s", "Elementos hijos: "); cout << "Hijos: "; hijo(raiz); cout << endl; fprintf(entrada, "%s","\n");
	fprintf(entrada, "%s", "Buscar dato: "); cout <<"Buscar dato: " ; buscardato(); fprintf(entrada, "%s", "\n");
	fprintf(entrada,"%s","Datos del nivel "); cout << "Dato del nivel: "; fprintf(entrada,"%d",b); cout<< b <<" : "; fprintf(entrada,"%s",": ");nivel(raiz);nivel2(raiz);
	fclose(entrada);	                                                                                                      
}                                                                                                                       

void mostrarinorden(nodo *aux){	//in order tree
	if(aux==NULL){
		return;
	}else{
		mostrarinorden(aux->izq);
		cout << aux->n;
		cout << " ";
		fprintf(entrada,"%d",aux->n);
		fprintf(entrada,"%s"," ");
		mostrarinorden(aux->der);	
	}
}
	
		
		
void mostrarpreorden(nodo *aux){ //pre order tree
	if(aux==NULL){
		return;
	}else{
		cout << aux->n;
		cout << " ";
		fprintf(entrada,"%d",aux->n);
		fprintf(entrada,"%s"," ");
		mostrarpreorden(aux->izq);
		mostrarpreorden(aux->der);
	}
}

void mostrarpostorden(nodo *aux){ //post order tree
	if(aux==NULL){
		return;
	}else{
		mostrarpostorden(aux->izq);
		mostrarpostorden(aux->der);	
		fprintf(entrada,"%d",aux->n);
		fprintf(entrada,"%s"," ");
		cout << aux->n;
		cout << " ";
	}
}

void hojas(nodo *aux){	//tree leaves
	if(aux==NULL){
		return;
	}else{	  
		hojas(aux->izq);
		if (aux->der==NULL && aux->izq==NULL){
		    fprintf(entrada,"%d",aux->n);
	        fprintf(entrada,"%s"," ");
	        cout << aux->n;
	        cout << " ";
		}      
		hojas(aux->der);
   }
}

void hijo(nodo *aux){ //son 
	if(aux==NULL){
		return;
	}else{	  
		hijo(aux->izq);
		if (aux->der==NULL && aux->izq!=NULL || aux->der!=NULL && aux->izq==NULL ){
			fprintf(entrada,"%d",aux->n);
	     	fprintf(entrada,"%s"," ");
	     	cout << aux->n;
			cout << " ";   
			
		}
	}
}
		
void buscardato(){ //search number
	aux=raiz;                           
	buscar(aux,a);         
	if (x==false){
		fprintf(entrada,"%s","Buscar ");fprintf(entrada,"%d",a);fprintf(entrada,"%s",": no esta en algun nivel ");
	}	
}

void buscar(nodo *aux, int a){ //search number
	
	if(aux->n==a){
		fprintf(entrada,"%s","Buscar ");fprintf(entrada,"%d",a);fprintf(entrada,"%s",": si esta en el nivel ");fprintf(entrada,"%d",cont3);
		cout << a << " : si esta en el nivel " << cont3 << endl;
		x=true;
	}
	else if(a<aux->n){
		cont3++;
		buscar(aux->izq,a);
	}
	else if(a>aux->n){
		cont3++;
	    buscar(aux->der,a);
	}
}

void nivel(nodo *aux){ // c out level left
	cont2++;
	if(aux==NULL){
		return;
	}else{
		if (cont2==b){
			if(aux->der!=NULL){
				cout << aux->der->n;
				cout << " " ;
				fprintf(entrada,"%d",aux->der->n);
	        	fprintf(entrada,"%s"," ");

			}
			if(aux->izq!=NULL){
				cout << aux->izq->n;
				cout << " " ;
				fprintf(entrada,"%d",aux->izq->n);
	        	fprintf(entrada,"%s"," ");

			}
			cont2=0;
			return;
		}
		nivel(aux->izq);	
	}	
}

void nivel2(nodo *aux){ // c out level right
	cont2++;
	if(aux==NULL){
		return;
	}else{
		if (cont2==b){
			if(aux->izq!=NULL){
				cout << aux->izq->n;
				cout << " " ;
				fprintf(entrada,"%d",aux->izq->n);
	        	fprintf(entrada,"%s"," ");
	
			}
			if(aux->der!=NULL){
				cout << aux->der->n;
				cout << " " ;
				fprintf(entrada,"%d",aux->der->n);
	        	fprintf(entrada,"%s"," ");
			}	
			return;
		}
		nivel(aux->der);	
	}	
}
