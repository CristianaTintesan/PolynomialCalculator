package tema1;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.lang.String;


public class Polinom {

	private int nrM = 0;
	private List<Monom> m = new ArrayList<Monom>();

	public List<Monom> getM() {
		return m;
	}

	public void setM(List<Monom> m) {
		this.m = m;
	}

	public void adaugaMonom(Monom mon) {
		nrM++;
		m.add(mon);
	}

	public void stergeMon(int i) {
		m.remove(i);
		nrM--;
	}

	public int indexPutere(int x, Polinom P) {
		int poz = 0;//se determina indexul monomului care are puterea x din P
		for (Monom m1 : P.getM()) {
			if (m1.getPutere() == x) {
				return poz;
			} else
				poz++;
		}
		return -1;
	}

	public String toString() {
		String afisarePolinom = "";
		for (Monom monom : m) {
			afisarePolinom += monom.toString();//se apeleaza toString din clasa Monom

		}
		return afisarePolinom;

	}

	public int nrMonoane() {
		return nrM;
	}

	public Monom getMonom(int x) {
		return m.get(x);
	}

	public int detPutere(String cuv2) {
		int putere = 0;
		String cuv3 = "";
		if (cuv2.contains("X") && cuv2.contains("^")) {//in acest caz puterea este >1
			StringTokenizer st3 = new StringTokenizer(cuv2, "X^");
			while (st3.hasMoreTokens()) {
				cuv3 = "";
				putere = 0;
				cuv3 = st3.nextToken();
				if (cuv3 == "")
					putere = 0;
				else {

					if (Character.isDigit(cuv3.charAt(0)) == true)
						putere = Integer.parseInt(cuv3);
				}
			}
		} else if (cuv2.contains("X") == true && cuv2.contains("^") == false)
			putere = 1;
		else if (cuv2.contains("X") == false && cuv2.contains("^") == false)
			putere = 0;

		return putere;
	}

	public int detCoeficient(String cuv2) {//det coef monomului din cuv2 si il transorma in int
		int coef = 0;
		if (cuv2.startsWith("-") == true)
			coef = -1;
		else
			coef = 1;
		if (cuv2.length() == 2 && cuv2.contains("X") == false && cuv2.contains("^") == false) {
			char value = cuv2.charAt(1);
			String a = "";
			a += value;
			coef = coef * Integer.parseInt(a);
		} else if (cuv2 == "+X")
			coef = 1;
		else if (cuv2 == "-X")
			coef = -1;
		else if (cuv2.length() > 2) {
			String zero = "";
			zero += cuv2.charAt(0);
			String unu = "";
			unu += cuv2.charAt(1);
			if (Character.isDigit(unu.charAt(0)) == true)
				coef = coef * Integer.parseInt(unu);
			else if (zero == "+")
				coef = 1;
			else if (zero == "-")
				coef = -1;

		}

		return coef;
	}

	

	public void formarePolinom1(String pol, Polinom pQ) {

		int coef = 0, putere = 0;//Se sparge Stringul pol in fuctie de caracterele +- care apar
		StringTokenizer st = new StringTokenizer(pol, "+");
		String cuv3 = "";
		while (st.hasMoreTokens()) {
			String cuv = st.nextToken();
			cuv = "+" + cuv;
			StringTokenizer st2 = new StringTokenizer(cuv, "-");
			while (st2.hasMoreTokens()) {
				String cuv2 = st2.nextToken();
				if (cuv2.startsWith("+"))
					cuv2 = cuv2;
				else
					cuv2 = "-" + cuv2;//cuv2 va contine primul monom din pol,apoi al doilea....
				if (cuv2.length() > 1) {
					putere = detPutere(cuv2);
					coef = detCoeficient(cuv2);
				}
				Monom monom = new Monom(coef, putere);
				pQ.adaugaMonom(monom);

			}

		}
         if(pol.startsWith("-")) //Daca Stringul pol incepe cu - este adaugat un monom vid in polinom si il stergem
        	 pQ.stergeMon(0);
         
	}
	
	public void resetarePolinom(Polinom P) {
		m.clear();
		nrM = 0;
	}
}
