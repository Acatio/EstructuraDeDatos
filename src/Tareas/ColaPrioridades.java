/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tareas;

import edd.*;

/**
 *
 * @author HP
 */
public class ColaPrioridades
{


    public static void main(String[] args)
    {
        Integer[] arr = new Integer[5];
        Integer[] arr2 = new Integer[5];
        Integer[] arr3 = new Integer[5];
        Cola cola = new Cola(arr);
        Pila pila1 = new Pila(arr2);
        Pila pila2 = new Pila(arr3);
        cola.inserta(5);
        cola.inserta(1);
        cola.inserta(2);
        cola.inserta(3);
        cola.inserta(4);
        while (!cola.isVacia())
        {
            int eliminadoCola = (int) cola.elimina();
            if (pila1.isVacia())
            {
                pila1.inserta(eliminadoCola);
            } else
            {
                int eliminadoPila;
                while (!pila1.isVacia())
                {
                    eliminadoPila = (int) pila1.elimina();
                    if (eliminadoCola > eliminadoPila)
                    {
                        pila2.inserta(eliminadoPila);
                    } else
                    {
                        pila1.inserta(eliminadoPila);
                        break;
                    }
                }
                pila1.inserta(eliminadoCola);

                while (!pila2.isVacia())
                {
                    pila1.inserta(pila2.elimina());
                }
            }
        }
        while (!pila1.isVacia())
        {
            cola.inserta(pila1.elimina());
        }
        while (!cola.isVacia())
        {
            System.out.println(cola.elimina());
        }
        

    }

}
