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

            // Creazione nuovo evento
            Evento event = new Evento(titolo, data, postiTotali);

            System.out.println("Evento creato con successo:");
            System.out.println(event);

            event.prenota();
            System.out.println("Prenotato un posto. Posti prenotati: " + event.getPostiPrenotati());

            event.disdici();
            System.out.println("Disdetto un posto. Posti prenotati: " + event.getPostiPrenotati());

        } catch (Exception e) {
            System.err.println("Errore: " + e.getMessage());
        } finally {
            in.close();
        }
    }

}
