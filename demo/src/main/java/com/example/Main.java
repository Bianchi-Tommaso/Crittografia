package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main 
{
    public static void main( String[] args ) throws IOException
    {
        String testo = "";
        String pattern = "";
        String nomeChiave = "c";
        int numeroChiavi = 0;
        int k = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        System.out.println("Inserire Testo Da Cifrare!");
        testo = br.readLine();

        System.out.println("Quante Chiavi Vuoi Inserire?");
        numeroChiavi = Integer.valueOf(br.readLine());

        System.out.println("Inserire Sequenza Chiave!");
        pattern = br.readLine();

        Cifra c = new Cifra(testo, pattern);

        for(int i = 0; i < numeroChiavi; i++)
        {
            System.out.println("Inserire Valore K Della Chiave");
            k = Integer.valueOf(br.readLine());

            System.out.println("Inserire Nome Chiave!");
            nomeChiave = br.readLine();

            Chiave chiave = new Chiave(k, nomeChiave);

            c.AddChiave(chiave);

        }

        System.out.println("Il Testo Cifrato E' Il Seguente: " + c.Codifica());
        System.out.println("Il Testo Decifrato E' Il Seguente: " + c.Decodifica(c.Codifica()));
    }
}
