package org.java.events;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ProgrammaEventi {
	
    private String titolo;
    private List<Evento> eventi;

    // CONSTRUCTOR
    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }
    
    // METHODS
    
    // ADD EVENT
    
    public void addEvent(Evento e) {
    	eventi.add(e);
    }
    
    // EVENT LIST PER DATE
    public List<Evento> eventiPerData(Date d) {
        List<Evento> eventsPerDate = new ArrayList<>();

        for (Evento e : eventi) {
            if (e.getData().equals(d)) {
                eventsPerDate.add(e);
            }
        }

        return eventsPerDate;
    }
    
    // NUMBER OF ELEMENTS
    public int numeroEventi() {
        return eventi.size();
    }
    
    // REMOVE FROM THE LIST
    public void svuotaEventi() {
        eventi.clear();
    }
    
    // LIST WITH TITLE
    
    public String eventsListPerDate() {
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

        return "Titolo: " + titolo + "\n" +
                eventi.stream()
                        .sorted((e1, e2) -> e1.getData().compareTo(e2.getData()))
                        .map(evento -> data.format(evento.getData()) + " - " + evento.getTitolo())
                        .collect(Collectors.joining("\n"));
    }

}
