package com.example;

import java.util.ArrayList;

public class Cifra 
{
    private String testo;
    private String[] patternArray;
    private int patternLength;
    private static final char[] alfabeto = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    ArrayList<Chiave> contenitoreChiavi = new ArrayList<Chiave>();   

    public Cifra(String testo, String pattern)
    {
        this.testo = testo.replaceAll(" ", "");
        patternArray = pattern.split(";");
        patternLength = patternArray.length;
    }
    
    public void AddChiave(Chiave x)
    {
        contenitoreChiavi.add(x);
    }

    public String Codifica()
    {
        int j = 0;
        String testoCifrato = "";
        Chiave k;
        
        for(int i = 0; i < testo.length(); i++)
        {
            if(j == patternLength)
                j = 0;

            k = getLunghezzaChiave(j);

            if(k.getK() + getIndice(testo.charAt(i)) >= 26)
            {
                int x = k.getK() + getIndice(testo.charAt(i)) - 26;

                testoCifrato += alfabeto[x];
            }
            else
            {
                testoCifrato += alfabeto[k.getK() + getIndice(testo.charAt(i))];
            }

            j++;
        }

        return "Il Testo Cifrato E' Il Seguente: " + testoCifrato;
    }

    public int getIndice(char lettera)
    {
        for(int i = 0; i < alfabeto.length; i++)
        {
            if(alfabeto[i] == lettera)
            {
                return i;
            }
        }

        return 0;
    }

    public Chiave getLunghezzaChiave(int i)
    {
        for(int j = 0; j < contenitoreChiavi.size(); j++)
        {
            if(patternArray[i].equals(contenitoreChiavi.get(j).getNomeChiave()))
            {
                return contenitoreChiavi.get(j);
            }
        }

        return null;
    }
}