package com.example;

public class Chiave 
{
    private int k;
    private String nomeChiave;
    
    public Chiave(int k, String nomeChiave)
    {
        this.k = k;
        this.nomeChiave = nomeChiave;
    }

    public Chiave(String nomeChiave)
    {
        this.nomeChiave = nomeChiave;
    }

    public int getK() 
    {
        return k;
    }

    public void setK(int k) 
    {
        this.k = k;
    }

    public String getNomeChiave() 
    {
        return nomeChiave;
    }

    public void setNomeChiave(String nomeChiave) 
    {
        this.nomeChiave = nomeChiave;
    }
    
}
