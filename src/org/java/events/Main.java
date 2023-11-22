package org.java.events;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
	

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Inserisci i dettagli dell'evento:");

            System.out.print("Titolo: ");
            String titolo = in.nextLine();
            System.out.print("Data dell'evento (formato dd/MM/yyyy): ");
            String dataInput = in.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date d = dateFormat.parse(dataInput);

            // Converti la data da java.util.Date a java.sql.Date
            Date data = new Date(d.getTime());

            System.out.print("Numero di posti totali: ");
            int postiTotali = in.nextInt();

            // Crea un nuovo evento
            Evento event = new Evento(titolo, data, postiTotali);

            // Visualizza i dettagli dell'evento
            System.out.println("Evento creato con successo:");
            System.out.println(event);

            System.out.println("Concerto creato con successo:");
            System.out.println(event);
            
            //PRENOTAZIONI

            System.out.print("Desideri effettuare delle prenotazioni? (Si/No): ");
            String answer = in.next();

            while (answer.equalsIgnoreCase("Si")) {

            	System.out.print("Quanti posti vuoi prenotare? ");
                int nPrenotazioni = in.nextInt();

                // EFFETTURARE LA PRENOTAZIONE
                for (int i = 0; i < nPrenotazioni; i++) {
                    try {
                    	event.prenota();
                        System.out.println("Prenotazione effettuata. Posti prenotati: " + event.getPostiPrenotati()
                                + ", Posti disponibili: " + (event.getPostiTotali() - event.getPostiPrenotati()));
                    } catch (IllegalStateException e) {
                        System.err.println("Impossibile prenotare un posto: " + e.getMessage());
                    }
                }

                System.out.print("Desideri effettuare altre prenotazioni? (Si/No): ");
                answer = in.next();
            }
            
            // DISDIRE PRENOTAZIONI
            
            System.out.print("Desideri disdire delle prenotazioni? (Si/No): ");
            answer = in.next();

            while (answer.equalsIgnoreCase("Si")) {

            	System.out.print("Quanti posti vuoi disdire? ");
                int nDisdette = in.nextInt();

                // DISDIRE LA PRENOTAZIONE

                for (int i = 0; i < nDisdette; i++) {
                    try {
                    	event.disdici();
                        System.out.println("Disdetto un posto. Posti prenotati: " + event.getPostiPrenotati()
                                + " Posti disponibili: " + (event.getPostiTotali() - event.getPostiPrenotati()));
                    } catch (IllegalStateException e) {
                        System.err.println("Impossibile disdire un posto: " + e.getMessage());
                    }
                }

                System.out.print("Desideri fare altre disdette? (Si/No): ");
                answer = in.next();
            }
            
            System.out.println("Vuoi inserire altri eventi? ");

            System.out.print("Titolo dell'evento: ");
            String titoloProgramma = in.nextLine();

            ProgrammaEventi programma = new ProgrammaEventi(titoloProgramma);

            // EVENTI DI ESEMPIO
            Evento evento1 = new Evento("Evento 1", new Date(), 100);
            Evento evento2 = new Evento("Evento 2", new Date(), 150);
            programma.addEvent(evento1);
            programma.addEvent(evento2);

            System.out.println(programma.eventsListPerDate());

        } catch (Exception e) {
            System.err.println("Errore: " + e.getMessage());
        } finally {
            in.close();
        }
    }

}
