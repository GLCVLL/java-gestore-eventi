package org.java.events;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class Concerto extends Evento{
	
	private LocalTime ora;
	private BigDecimal prezzo;
	
	// CONSTRUCTOR
	
	public Concerto(String titolo, Date data, LocalTime ora, int postiTotali, BigDecimal prezzo) throws Exception {
	    super(titolo, data, postiTotali);
	    this.ora = ora;
	    this.prezzo = prezzo;
	}
	
	// GETTER & SETTER

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	
	// METHODS
	
	public String getDataFormattata() {
	    SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
	    return data.format(getData());
	}

	public String getOraFormattata() {
	    return ora.toString();
	}

	public String getPrezzoFormattato() {
	    DecimalFormat d = new DecimalFormat("##,##€");
	    return d.format(prezzo);
	}
	
	
	@Override
	public String toString() {

		return getDataFormattata() + " " + getOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
	}
	

}
