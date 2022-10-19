package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;
import java.util.spi.LocaleNameProvider;


public class ClientHandler extends Thread {
    private Socket s;
    static int  x= 1;
    int id;
    private PrintWriter pr = null;
    private BufferedReader br = null;

    public ClientHandler(Socket s) {
        this.s = s;
        id=x;
        x++;

        try {
            // per parlare
            pr = new PrintWriter(s.getOutputStream(), true);
            // per ascoltare
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            //per tastiera 
           BufferedReader tast = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
      
        try {
            
            System.out.println(br.readLine());
            pr.println("Ciao come ti chiami"); // invio messaggio
            String nome = br.readLine(); // ricevo: il nome
            System.out.println("nome ricevuto");

            pr.println("Benvenuto " + nome.toUpperCase() + " sei l'utente numero " +  id );
            
            boolean running=true;
            while(running){

           
          
          
         
           pr.println("INSERISCI  LA DATA PER RICEVERE QUALLA ATTUALE");
           pr.println("INSERISCI L'ORA PER RICEVERE QUELLA ATTUALE");
           pr.println("INSERISCI IL NOME PER RICEVERE QUELLO DEL SERVER ");
           pr.println("INSERISCI IL'id");

           String scelta=br.readLine();
           System.out.println("scelta ricevuta");
           if(scelta.equals("data")){
               LocalDate tempo=LocalDate.now();
               pr.println(tempo);
           }else if(scelta.equals("ora")){
               LocalTime ora=LocalTime.now();
               pr.println(ora);
           }else if(scelta.equals("nome")){
              pr.println("Server ALESSIA");
           }else if(scelta.equals("nome")){
               s.close();
           }
/* 
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

            }
            
            System.out.println(br.readLine()); // leggo il saluto finale e lo metto in console

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
            */
        }
    }

}
}
