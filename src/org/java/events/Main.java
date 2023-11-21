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
            Date data = new Date(d.getTime());

            System.out.print("Numero di posti totali: ");
            int postiTotali = in.nextInt();

            // CREAZIONE NUOVO EVENTO
            Evento event = new Evento(titolo, data, postiTotali);

            System.out.println("Evento creato con successo:");
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
                        System.out.println("Prenotato un posto. Posti prenotati: " + event.getPostiPrenotati()
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

        } catch (Exception e) {
            System.err.println("Errore: " + e.getMessage());
        } finally {
            in.close();
        }
    }

}
