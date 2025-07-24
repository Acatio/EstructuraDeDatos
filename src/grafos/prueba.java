/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class prueba
{

    public static void main(String[] args)
    {
        prueba p = new prueba();
        List lista = p.agrega(10, new ArrayList<>());
        System.out.println(lista.toString());

    }

    public List<Integer> agrega(int n, int contador, List<Integer> lista)
    {
        if (contador < n)
        {
            lista.add(contador);
            System.out.println(lista.toString());
            return agrega(n, contador + 1, lista);
        }
        return lista;
    }

    public List<Integer> agrega(int n, List<Integer> lista)
    {
        if (n == 0)
        {
            return lista;
        }
        agrega(n - 1, lista);     // Llamada recursiva primero
        lista.add(n - 1);         // Agregamos después
        System.out.println(lista.toString());
        return lista;
    }

}
