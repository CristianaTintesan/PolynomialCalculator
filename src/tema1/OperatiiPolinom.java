package tema1;

//import java.util.ArrayList;
//import java.util.List;


public class OperatiiPolinom {
	int i = 0;
	int j = 0;
	//private List<Monom> m = new ArrayList<Monom>();
	
	
	public Polinom suma(Polinom P,Polinom Q)
	{
	    Polinom suma= new Polinom();
	    for (Monom m1: P.getM())//parcurge polinomul P
	    {
	    	int putereP=m1.getPutere();
	    	int coefP=m1.getCoef();
	    	int i_putere=Q.indexPutere(putereP, Q);//gaseste indexul monomului din Q care are puterea= putereP
	    	if(i_putere==-1)//Daca nu s-a gasit un astefel de monom, adugam monomul curent in suma
	    	{
	    		Monom m= new Monom(coefP,putereP);
	    		suma.adaugaMonom(m);
	    	}else {
	    		int putereQ= Q.getMonom(i_putere).getPutere();
	    		int coefQ=Q.getMonom(i_putere).getCoef();
	    		Monom m = new Monom(coefP+coefQ,putereQ);//sunt monoame in acelasi grad, calculma suma coef
	    		suma.adaugaMonom(m);//le adaugam in suma
	    		Q.stergeMon(i_putere);
	    	}
	    }
	    for (Monom m2: Q.getM())//Se adauga ce monomae au ramas in Q
	    {
	    	int putere2Q=m2.getPutere();
	    	int coef2Q=m2.getCoef();
	    	Monom m= new Monom(coef2Q,putere2Q);
	    	suma.adaugaMonom(m);
	    }
	    return suma;
	}
	
	public Polinom diferenta(Polinom P,Polinom Q)
	{
	    Polinom dif= new Polinom();
	    for (Monom m1: P.getM())
	    {
	    	int putereP=m1.getPutere();
	    	int coefP=m1.getCoef();
	    	int i_putere=Q.indexPutere(putereP, Q);
	    	if(i_putere==-1)
	    	{
	    		Monom m= new Monom(coefP,putereP);
	    		dif.adaugaMonom(m);
	    	}else {
	    		int putereQ= Q.getMonom(i_putere).getPutere();
	    		int coefQ=Q.getMonom(i_putere).getCoef();
	    		coefQ=coefQ * -1;
	    		Monom m = new Monom(coefP+coefQ,putereQ);
	    		dif.adaugaMonom(m);
	    		Q.stergeMon(i_putere);
	    	}
	    }
	    for (Monom m2: Q.getM())
	    {
	    	int putere2Q=m2.getPutere();
	    	int coef2Q=m2.getCoef();
	    	coef2Q=coef2Q * -1;
	    	Monom m= new Monom(coef2Q,putere2Q);
	    	dif.adaugaMonom(m);
	    }
	    return dif;
	}
	
	public Polinom inmultire(Polinom P, Polinom Q) {//se inmulteste fiecare monom din P cu fiecare monom din Q
		
		Polinom mul= new Polinom();
		for(Monom m1: P.getM()) {//parcurgere polinom P
			int coef=m1.getCoef();
			int putere=m1.getPutere();
			for(Monom m2: Q.getM()) {//se parcurge Q
				int coef2=m2.getCoef();
				int putere2=m2.getPutere();
			Monom	m= new Monom(coef*coef2,putere+putere2);
				mul.adaugaMonom(m);
			}
		}
		return mul;
	}
	
	public Polinom derivare (Polinom P) {
		Polinom der= new Polinom();
		for(Monom m1: P.getM()) {
			int coef=m1.getCoef();
			int putere=m1.getPutere();
			if(putere != 0) {//cond necesare deoarece derivata unui monom cu gradul 0 este 0
				Monom m = new Monom(coef*putere,putere-1);
				der.adaugaMonom(m);
			}
			
		}
		return der;
	}
	
	public Polinom integrare(Polinom P) {
		Polinom integrat= new Polinom();
		for (Monom m1: P.getM()) {
			int coef=m1.getCoef();
			int putere=m1.getPutere();
			int x=(int) (coef/(putere+1));
			Monom m= new Monom(x,putere+1);
			integrat.adaugaMonom(m);
		}
		return integrat;
	}
	
	

}