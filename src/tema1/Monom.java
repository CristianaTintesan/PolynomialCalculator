package tema1;

public class Monom {
	private int coef; // coeficientul fiecarui monom
	private int putere;// puterea fiecarui monom

	public Monom(int coef, int putere) { // Constructor
		this.coef = coef;
		this.putere = putere;
	}

	public int getCoef() {
		return coef;
	}

	public void setCoef(int coef) {
		this.coef = coef;
	}

	public int getPutere() {
		return putere;
	}

	public void setPutere(int putere) {
		this.putere = putere;
	}

	public String toString() { // Metoda pentru afisarea fiecarui monom dintr-un polinom
		String rez = "";
		int c = getCoef();
		int p = getPutere();
		if ((c == 1) && p == 1) // Conditiile sunt puse in asa fel incat polinom va fi afisat intr-un format
								// "frumos",
			rez += "+" + "X"; // fara sa apara expresii de genul "1x sau x^0..."
		else if ((c == 1) && p > 1)
			rez += "+X^" + p;// 10
		else if (c == -1 && p == 1)
			rez += "-" + "X";
		else if (c == -1 && p > 1)
			rez += "-X^" + p;
		else if (c != 0 && p == 0) {
			if (c >= 1)
				rez += "+" + c;
			else
				rez += c;
		} else {
			if (c != 1 && c != 0 && p == 1) {
				if (c > 1)
					rez += "+" + c + "X";
				else
					rez += c + "X";
			} else {
				if (c != 1 && c != 0 && p > 1) {
					if (c > 1)
						rez += "+" + c + "X^" + p;
					else
						rez += c + "X^" + p;
				}
			}
		}
		return rez;
	}

}
