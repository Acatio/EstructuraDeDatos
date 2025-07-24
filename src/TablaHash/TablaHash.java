/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TablaHash;

import arboles.*;

/**
 *
 * @author HP
 */
public class TablaHash
{

    ArbolBinario<Object> tablaHash[] = new ArbolBinario[26];

    public TablaHash()
    {
        for (int i = 0; i < tablaHash.length; i++)
        {
            tablaHash[i] = new ArbolBinario<>();

        }
    }

    public void inserta(NodoA<Object> n)
    {
        int posicion = calculaPosision(n.getEtiqueta());
        if (posicion >= 0 && posicion < 26)
        {
            tablaHash[posicion].insertar(n);
        }
    }

    public int calculaPosision(String s)
    {
        return (int) (s.toUpperCase().charAt(0)) - 65;
    }

    public NodoA busca(String buscado)
    {
        int posicion = calculaPosision(buscado);
        if (posicion >= 0 && posicion < 26)
        {
            return tablaHash[posicion].busca(buscado);
        }
        return null;
    }

    public static void main(String[] args)
    {
        TablaHash obj = new TablaHash();
        NodoA n1 = new NodoA("ANA", "ANA");
        NodoA n2 = new NodoA("ANASTACIA", "ANASTACIA");
        NodoA n3 = new NodoA("MAURO", "MAURO");
        NodoA n4 = new NodoA("MANUEL", "MANUEL");
        obj.inserta(n1);
        obj.inserta(n2);
        obj.inserta(n3);
        obj.inserta(n4);
        System.out.println(obj.busca("MAURO").getEtiqueta());
        

    }
}
