package com.employeesalary.main;

// klasa Programer, nasledjuje apstraktnu klasu zaposleni  ima atribut bonus

public class Programer extends Employee {

	public double bonus;

	// atribut prekovremeni rad, tipa double

	public double prekovremeniRad;

	public Programer() {
	}

	public Programer(String ime, String pozicija, double brojRadnihSati, double cenaRadnogSata, double bonus,
			double prekovremeniRad) {
		super(ime, pozicija, brojRadnihSati, cenaRadnogSata);
		this.bonus = bonus;
		this.prekovremeniRad = prekovremeniRad;

	}

	// geteri i seteri za atribute bonus i prekovremeni rad
	public double getBonus() {

		return bonus;
	}

	public void setBonus(double bonus) {

		this.bonus = bonus;
	}

	public double getPrekovremeniRad() {

		return prekovremeniRad;
	}

	public void setPrekovremeniRad(double prekovremeniRad) {

		this.prekovremeniRad = prekovremeniRad;
	}

	// redefinisana metoda izracunajPlatu(), nasledjena iz apstraktne klase

	public double izracunajPlatu(double brojRadnihSati, double cenaRadnogSata) {

		double plata = brojRadnihSati * cenaRadnogSata + bonus + prekovremeniRad;

		return plata;
	}

	// Redefinisama metoda toString, koja vraca string i podatke o programeru

	public String toString() {

		return super.toString() + "\nPrekovremeni rad: " + prekovremeniRad + "\nBonus: " + bonus + "\nPlata: "
				+ izracunajPlatu(brojRadnihSati, cenaRadnogSata) + "\n====================";
	}

}
