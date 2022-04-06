package com.example;

public class MainTest
{
    public static void main(String[] args)
    {
        String testo = "";
        String pattern = "c1;c2;c2;c3";
        String nomeChiave1 = "c1";
        String nomeChiave2 = "c2";
        String nomeChiave3 = "c3";

        int k1 = 5;
        int k2 = 19;
        int k3 = 10;

        System.out.println("Testo Da Cifrare! " + testo);

        System.out.println("Sequenza Chiave! " + pattern);

        Cifra c = new Cifra(testo, pattern);

            Chiave chiave1 = new Chiave(k1, nomeChiave1);
            Chiave chiave2 = new Chiave(k2, nomeChiave2);
            Chiave chiave3 = new Chiave(k3, nomeChiave3);

            c.AddChiave(chiave1);
            c.AddChiave(chiave2);
            c.AddChiave(chiave3);
            
            System.out.println("Il Testo Cifrato E' Il Seguente: " + c.Codifica());
            System.out.println("Il Testo Decifrato E' Il Seguente: " + c.Decodifica(c.Codifica()));
    }
}