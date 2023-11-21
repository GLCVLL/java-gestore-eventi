package org.java.events;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
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
            Date d = dateFormat.parse(dataInput);
            Date data = new Date(d.getTime());

            System.out.print("Numero di posti totali: ");
            int postiTotali = in.nextInt();
            
            System.out.print("Ora dell'evento (formato HH:mm): ");
            String oraInput = in.next();
            LocalTime ora = LocalTime.parse(oraInput);

            System.out.print("Prezzo dell'evento: ");
            BigDecimal prezzo = in.nextBigDecimal();

            // CREAZIONE NUOVO CONCERTO
            Concerto c = new Concerto(titolo, data, ora, postiTotali, prezzo);

            System.out.println("Concerto creato con successo:");
            System.out.println(c);
            
            //PRENOTAZIONI

            System.out.print("Desideri effettuare delle prenotazioni? (Si/No): ");
            String answer = in.next();

            while (answer.equalsIgnoreCase("Si")) {

            	System.out.print("Quanti posti vuoi prenotare? ");
                int nPrenotazioni = in.nextInt();

                // EFFETTURARE LA PRENOTAZIONE
                for (int i = 0; i < nPrenotazioni; i++) {
                    try {
                        c.prenota();
                        System.out.println("Prenotazione effettuata. Posti prenotati: " + c.getPostiPrenotati()
                                + ", Posti disponibili: " + (c.getPostiTotali() - c.getPostiPrenotati()));
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
                        c.disdici();
                        System.out.println("Disdetto un posto. Posti prenotati: " + c.getPostiPrenotati()
                                + " Posti disponibili: " + (c.getPostiTotali() - c.getPostiPrenotati()));
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
