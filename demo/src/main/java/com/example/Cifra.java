package com.example;

import java.util.ArrayList;

public class Cifra 
{
    private String testo;
    private String[] patternArray;
    private char[] patternArray1;
    private int patternLength;
    private static final char[] alfabeto = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    ArrayList<Chiave> contenitoreChiavi = new ArrayList<Chiave>();   

    public Cifra(String testo, String pattern)
    {
        this.testo = testo.replaceAll(" ", "");
        patternArray = pattern.split(";");
        pattern = pattern.replaceAll(";", "");
        patternArray1 = pattern.toCharArray();
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

                if(k == null)
                {
                    if(getIndice(patternArray1[j]) + getIndice(testo.charAt(i)) % 26 < 26)
                        testoCifrato += alfabeto[getIndice(patternArray1[j]) + getIndice(testo.charAt(i)) % 26];
                    else
                        testoCifrato += alfabeto[getIndice(patternArray1[i]) + getIndice(testo.charAt(i)) - 26];
                }
                else
                {
                    if(k.getK() + getIndice(testo.charAt(i)) % 26 < 26)
                        testoCifrato += alfabeto[k.getK() + getIndice(testo.charAt(i)) % 26];
                    else
                        testoCifrato += alfabeto[k.getK() + getIndice(testo.charAt(i)) - 26];
                }

            j++;
        }

        return testoCifrato;
    }

    public String Decodifica(String testoCifrato)
    {
        int j = 0;
        String testoDecifrato = "";
        Chiave k;
        
        for(int i = 0; i < testoCifrato.length(); i++)
        {
            if(j == patternLength)
                j = 0;

                k = getLunghezzaChiave(j);

                if(k == null)
                {
                    if(getIndice(testoCifrato.charAt(i)) - getIndice(patternArray1[j]) % 26 < 0)
                        testoDecifrato += alfabeto[getIndice(testoCifrato.charAt(i)) - getIndice(patternArray1[j]) % 26 + 26];
                    else
                        testoDecifrato += alfabeto[getIndice(testoCifrato.charAt(i)) - getIndice(patternArray1[j])];
                }
                else
                {
                    if(getIndice(testoCifrato.charAt(i)) - k.getK() % 26 < 0)
                        testoDecifrato += alfabeto[getIndice(testoCifrato.charAt(i)) - k.getK() % 26 + 26];
                    else
                        testoDecifrato += alfabeto[getIndice(testoCifrato.charAt(i)) - k.getK()];
                }

            j++;
        }

        return testoDecifrato;
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
