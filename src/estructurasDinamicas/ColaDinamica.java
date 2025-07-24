/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructurasDinamicas;

/**
 *
 * @author HP
 */
public class ColaDinamica
{
    Nodo frente;
    Nodo atras;
    
    public void inserta(Nodo n)
    {
        if (frente == null)
        {
            frente = n;
            atras = n;
        } else
        {
            atras.setSiguiente(n);
            atras = n;
        }
    }

    public Nodo elimina()
    {
        Nodo n = null;

        if (frente != null)
        {
            if (frente == atras)
            {
                n = frente;
                frente = null;
                atras = null;

            } else
            {
                n = frente;
                frente = frente.getSiguiente();
                n.setSiguiente(null);

            }

        } else
        {
            System.out.println("No hay elementos en la cola");
        }

        return n;
    }

    public static void main(String[] args)
    {
        ColaDinamica colaD = new ColaDinamica();
        Nodo<String> n1 = new Nodo<>("A", "A");
        Nodo<String> n2 = new Nodo<>("B", "B");
        Nodo<String> n3 = new Nodo<>("C", "C");
        Nodo<String> n4 = new Nodo<>("D", "D");
        Nodo<String> n5 = new Nodo<>("E", "E");
        Nodo<String> n6 = new Nodo<>("F", "F");
        Nodo<String> n7 = new Nodo<>("G", "G");
        Nodo<String> n8 = new Nodo<>("H", "H");
        colaD.inserta(n1);
        colaD.inserta(n2);
        colaD.inserta(n3);
        colaD.inserta(n4);
        colaD.inserta(n5);
        colaD.inserta(n6);
        colaD.inserta(n7);
        colaD.inserta(n8);
        System.out.println(colaD.elimina().getEtiqueta());
        System.out.println(colaD.elimina().getEtiqueta());
        System.out.println(colaD.elimina().getEtiqueta());
        System.out.println(colaD.elimina().getEtiqueta());
        System.out.println(colaD.elimina().getEtiqueta());
        System.out.println(colaD.elimina().getEtiqueta());
        System.out.println(colaD.elimina().getEtiqueta());
        System.out.println(colaD.elimina().getEtiqueta());
        colaD.inserta(n1);
        colaD.inserta(n2);
        colaD.inserta(n3);
        colaD.inserta(n4);
        colaD.inserta(n5);
        colaD.inserta(n6);
        System.out.println(colaD.elimina().getEtiqueta());
        System.out.println(colaD.elimina().getEtiqueta());
        System.out.println(colaD.elimina().getEtiqueta());
        System.out.println(colaD.elimina().getEtiqueta());
        System.out.println(colaD.elimina().getEtiqueta());
        System.out.println(colaD.elimina().getEtiqueta());
    }
}
