package com.employeesalary.main;

/*apstraktna klasa Employee koja sadrzi podatke o zaposlenom
 ime, broj radnih sati i cenu radnog sata, kao i 
 apstraktnu metodu izracunajPlatu() */

public abstract class Employee {

	// atribut ime, tipa String

	protected String ime;

	protected String pozicija;

//
	public Employee() {
	}

	public Employee(String ime, String pozicija, double brojRadnihSati, double cenaRadnogSata) {

		this.ime = ime;
		this.pozicija = pozicija;
		this.brojRadnihSati = brojRadnihSati;
		this.cenaRadnogSata = cenaRadnogSata;
	}

	// atribut brojRadnih sati, tipa double

	public String getPozicija() {
		return pozicija;
	}

	public void setPozicija(String pozicija) {
		this.pozicija = pozicija;
	}

	protected double brojRadnihSati;

	// atribut cenaRadnog sata, tipa double

	protected double cenaRadnogSata;

	// geteri i seteri za atribute ime, cenaRadnog sata i brojRadnih sati

	public String getIme() {

		return ime;
	}

	public void setIme(String ime) {

		this.ime = ime;
	}

	public double getBrojRadnihSati() {

		return brojRadnihSati;
	}

	public void setBrojRadnihSati(double brojRadnihSati) {

		this.brojRadnihSati = brojRadnihSati;
	}

	public double getCenaRadnogSata() {

		return cenaRadnogSata;
	}

	public void setCenaRadnogSata(double cenaRadnogSata) {

		this.cenaRadnogSata = cenaRadnogSata;
	}

	/*
	 * apstraktna metoda izracunaj platu, koja prima dva parametra broj radnih sati
	 * i cena radnog sata posto je metoda apstraktna, nema telo vec je samo
	 * deklarisana
	 */

	public abstract double izracunajPlatu(double brojRadnihSati, double cenaRadnogSata);

	// metoda toString koja kao rezultat vraca string i podatke o zaposlenom

	public String toString() {

		return "Ime: " + ime + "\nPozicija: " + pozicija +

				"\nBroj radnih sati: " + brojRadnihSati +

				"\nCena Radnog sata: " + cenaRadnogSata;
	}

}
