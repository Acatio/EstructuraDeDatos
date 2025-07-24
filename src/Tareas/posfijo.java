/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tareas;

import edd.Pila;


/**
 *
 * @author HP
 */
public class posfijo
{

    public static void posfijo(String s)
    {
        Pila pila = new Pila(new Character[s.length()]);
      //  Cola cola = new Cola(new Character[s.length()]);
        String ss = "";
        Character c;
        for (int i = 0; i < s.length(); i++)
        {
            c = s.charAt(i);
            switch (c)
            {
                case '(', '+', '-', '/', '*':
                    pila.inserta(c);
                    break;
                case ')':
                    while (!pila.isVacia())
                    {
                        c = (char) pila.elimina();
                        if (c == '(')
                        {
                            break;
                        }
                        ss += c;
                    }
                    break;
                default:
                    ss += c;
            }
        }
        System.out.println(ss);
    }

    public static void main(String[] args)
    {

        posfijo("(a+b)/(c-d)");
        posfijo("((a*b)/(c-d))");
        posfijo("((f+(a*b))/(c-d))");
        

    }
}
