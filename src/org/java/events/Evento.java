package org.java.events;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Evento {
	
	private String titolo;
	private Date data;
	private int postiTotali;
	private int postiPrenotati;
	
	// CONSTRUCTOR
	public Evento(String titolo, java.util.Date data, int postiTotali) throws IllegalArgumentException {
	    this.titolo = titolo;
	    this.data = new Date(data.getTime());
	    this.postiTotali = postiTotali;
	    this.postiPrenotati = 0;

	    if (this.data.before(new java.util.Date())) {
	        throw new IllegalArgumentException("La data dell'evento deve essere futura o attuale");
	    }
	    if (postiTotali <= 0) {
	        throw new IllegalArgumentException("Il numero di posti totali deve essere positivo");
	    }
	}
	
	//GETTER & SETTER

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) throws Exception {
		this.data = data;
		
        if (data.before(new java.util.Date())) {
            throw new Exception("La data dell'evento deve essere futura o attuale");
        }
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	
	//METHODS
	
    public void prenota() throws Exception {
        if (data.before(new java.util.Date()) || postiPrenotati >= postiTotali) {
            throw new Exception("L'evento è già passato o non ci sono posti disponibili.");
        }
        postiPrenotati++;
    }

    public void disdici() throws Exception {
        if (data.before(new java.util.Date()) || postiPrenotati <= 0) {
            throw new Exception("L'evento è già passato o non ci sono prenotazioni.");
        }
        postiPrenotati--;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(data) + " - " + titolo;
    }
	
}
