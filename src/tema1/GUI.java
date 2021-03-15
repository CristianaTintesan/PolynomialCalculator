package tema1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class GUI {
	private JFrame frame = new JFrame("Calculator polinoame");
	private JTextArea text = new JTextArea(); // unde se introduce primul polinom
	private JTextArea text2 = new JTextArea();// unde se introduce al doilea polinom(introducerea lui este necesara doar
												// pt operatiile +,-,*)
	private JTextArea rezultat = new JTextArea();// aici va fi afisat rezultatul operatiei selectate
	private JButton b1 = new JButton("Adunare");// butoane prin care selectam ce operatie dorim sa facem
	private JButton b2 = new JButton("Scadere");
	private JButton b3 = new JButton("Inmultire");
	private JButton b4 = new JButton("Impartire");
	private JButton b5 = new JButton("Derivare");
	private JButton b6 = new JButton("Integrare");
	private JButton clear = new JButton("Clear");
	private JButton reset = new JButton("Reset");
	JLabel l1 = new JLabel("Introduceti polinoamele sub forma X^p1+X^p2.."); // mesajele afisate
	JLabel l2 = new JLabel("Rezultatul operatie:");
	private Polinom P = new Polinom(); // polinomul rezultat pt fiecare operatie
	private Polinom Q = new Polinom();
	private Polinom S = new Polinom();
	private Polinom D = new Polinom();
	private Polinom mul = new Polinom();
	private Polinom derivat = new Polinom();
	private Polinom integrat = new Polinom();
	private OperatiiPolinom r = new OperatiiPolinom();

	public GUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(600, 400); // setarile frame-ului
		frame.setResizable(false);
		frame.setLayout(null);

		b1.setSize(100, 25);// dimensiunile butoanelor
		b2.setSize(100, 25);
		b3.setSize(100, 25);
		b4.setSize(100, 25);
		b5.setSize(100, 25);
		b6.setSize(100, 25);
		clear.setSize(100, 25);
		reset.setSize(100, 25);

		b1.setLocation(30, 300); // locatia butoanelor
		b2.setLocation(150, 300);
		b3.setLocation(270, 300);
		b4.setLocation(390, 300);
		b5.setLocation(30, 330);
		b6.setLocation(150, 330);
		clear.setLocation(270, 330);
		reset.setLocation(390, 330);
		text.setSize(350, 20);
		text.setLocation(45, 45);
		text2.setSize(350, 20);
		text2.setLocation(45, 75);
		rezultat.setSize(450, 20);
		rezultat.setLocation(45, 185);
		rezultat.setEditable(false);
		l1.setSize(350, 20);
		l1.setLocation(18, 18);
		l2.setSize(200, 25);
		l2.setLocation(45, 125);
		frame.add(text);// pentru a le face vizibile trebuie sa folosim frame.add.....
		frame.add(text2);
		frame.add(rezultat);
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.add(b5);
		frame.add(b6);
		frame.add(clear);
		frame.add(reset);

		frame.add(l1);
		frame.add(l2);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String polinom1 = "";
				String polinom2 = "";// citim doua siruri de caractere de la tastatura ,le transformam in polinoame
				polinom1 = text.getText();
				polinom2 = text2.getText();
				P.formarePolinom1(polinom1, P);
				Q.formarePolinom1(polinom2, Q);
				S = r.suma(P, Q);// se realizeaza operatia de adunare
				rezultat.setText("0");
				rezultat.setText(S.toString());// se afiseaza rezultatul ca string
				S.resetarePolinom(S);// se reseteaza polinomul S
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String polinom1 = "";
				String polinom2 = "";
				polinom1 = text.getText();
				polinom2 = text2.getText();
				P.formarePolinom1(polinom1, P);
				Q.formarePolinom1(polinom2, Q);
				D = r.diferenta(P, Q);
				rezultat.setText(D.toString());
				D.resetarePolinom(D);
			}
		});
		clear.addActionListener(new ActionListener() {// goleste cele 2 JTextArea si reseteaza cele 2 polinoame
			public void actionPerformed(ActionEvent e) {
				text.setText("");
				text2.setText("");
				rezultat.setText("");
				P.resetarePolinom(P);
				Q.resetarePolinom(Q);

			}
		});
		reset.addActionListener(new ActionListener() {// reseteaza cele 2 polinoame
			public void actionPerformed(ActionEvent e) {

				P.resetarePolinom(P);
				Q.resetarePolinom(Q);
			}
		});

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String polinom1 = "";
				String polinom2 = "";
				polinom1 = text.getText();
				polinom2 = text2.getText();
				P.formarePolinom1(polinom1, P);
				Q.formarePolinom1(polinom2, Q);
				mul = r.inmultire(P, Q);
				rezultat.setText(mul.toString());
				mul.resetarePolinom(mul);
			}
		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String polinom1 = "";
				// String polinom2="";
				polinom1 = text.getText();
				// polinom2=text2.getText();
				P.formarePolinom1(polinom1, P);
				// Q.formarePolinom1(polinom2, Q);
				derivat = r.derivare(P);
				rezultat.setText(derivat.toString());
				derivat.resetarePolinom(derivat);
			}
		});

		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String polinom1 = "";
				// String polinom2="";
				polinom1 = text.getText();
				// polinom2=text2.getText();
				P.formarePolinom1(polinom1, P);
				// Q.formarePolinom1(polinom2, Q);
				integrat = r.integrare(P);
				rezultat.setText(integrat.toString());
				integrat.resetarePolinom(integrat);
			}
		});

	}

}
