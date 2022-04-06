package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main 
{
    public static void main(String[] args) throws Exception
    {
        String testo = "";
        String pattern = "";
        String nomeChiave = "";
        String scelta = "";
        String pattern1[];
        int numeroChiavi = 0;
        int k = 0;
        Cifra c = new Cifra("", "");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        System.out.println("1 - Sequenza Numerica \n 2 - Sequenza Letteraria");
        scelta = br.readLine();

        while(scelta.matches("[a-zA-Z]+"))
        {
            System.out.println("1 - Sequenza Numerica \n 2 - Sequenza Letteraria");
            scelta = br.readLine();
        }

        System.out.println("Inserire Testo Da Cifrare!");
        testo = br.readLine();

        switch (Integer.valueOf(scelta)) 
        {
            case 1:

                System.out.println("Quante Chiavi Vuoi Inserire?");
                numeroChiavi = Integer.valueOf(br.readLine());

                System.out.println("Inserire Sequenza Chiave (Dividere Pattern Con ;)!");
                pattern = br.readLine();

                c = new Cifra(testo, pattern);

                for(int i = 0; i < numeroChiavi; i++)
                {
                    System.out.println("Inserire Valore K Della Chiave");
                    k = Integer.valueOf(br.readLine());

                    System.out.println("Inserire Nome Chiave!");
                    nomeChiave = br.readLine();

                    Chiave chiave = new Chiave(k, nomeChiave);

                    c.AddChiave(chiave);
                }
                
                break;
            
            case 2:
                
                System.out.println("Inserire Sequenza Chiave Letteraria (Dividere Pattern Con ;)!");
                pattern = br.readLine();

                c = new Cifra(testo, pattern);

                pattern1 = pattern.split(";");

        
                
                break;

            default:
                System.exit(1);
                break;
        }


        
        

        System.out.println("Il Testo Cifrato E' Il Seguente: " + c.Codifica());
        System.out.println("Il Testo Decifrato E' Il Seguente: " + c.Decodifica(c.Codifica()));
    }
}
