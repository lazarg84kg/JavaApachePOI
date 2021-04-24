package com.employeesalary.main;

//klasa Devops, nasledjuje apstraktnu klasu zaposleni ima atribut bonus

public class Devops extends Employee {

	public double bonus;

	public Devops() {
	}

	public Devops(String ime, String pozicija, double brojRadnihSati, double cenaRadnogSata, double bonus) {
		super(ime, pozicija, brojRadnihSati, cenaRadnogSata);
		this.bonus = bonus;

	}

	// geter i seter za atribut bonus

	public double getBonus() {

		return bonus;
	}

	public void setBonus(double bonus) {

		this.bonus = bonus;
	}

	// redefinisana metoda izracunajPlatu(), nasledjena iz apstraktne klase

	public double izracunajPlatu(double brojRadnihSati, double cenaRadnogSata) {

		double plata = brojRadnihSati * cenaRadnogSata + bonus;

		return plata;
	}

	/*
	 * Redefinisama metoda toString, koja vraca string i podatke o devops-u, ime,
	 * broj radnih sati, cenu radnog sata i ostvareni bonus. i realizuje apstraktnu
	 * metodu IzracunajPlatu()
	 */
	public String toString() {
		return super.toString() +

				"\nBonus: " + bonus +

				"\nPlata: " + izracunajPlatu(brojRadnihSati, cenaRadnogSata)

				+ "\n====================";
	}

}
