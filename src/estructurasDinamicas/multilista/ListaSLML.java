/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructurasDinamicas.multilista;

import estructurasDinamicas.*;

/**
 *
 * @author HP
 */
public class ListaSLML
{

    private NodoML r;

    /**
     * @return the r
     */
    public NodoML getR()
    {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(NodoML r)
    {
        this.r = r;
    }

    public void inserta(NodoML n)
    {
        if (n != null)
        {
            if (r == null)
            {
                r = n;
            } else
            {
                if (n.getEtiqueta().compareTo(r.getEtiqueta()) < 0)
                {
                    n.setSiguiente(r);
                    r = n;
                } else
                {
                    NodoML aux = r;
                    while (aux.getSiguiente() != null)
                    {
                        if (aux.getSiguiente().getEtiqueta().compareTo(n.getEtiqueta()) > 0)
                        {
                            n.setSiguiente(aux.getSiguiente());
                            aux.setSiguiente(n);
                            break;
                        }
                        aux = aux.getSiguiente();
                    }
                    if (aux.getSiguiente() == null)
                    {
                        aux.setSiguiente(n);
                    }
                }
            }
        } else
        {
            System.out.println("El nodo es nulo");
        }
    }

    public NodoML elimina(String etiqueta)
    {
        NodoML n = null;
        if (r != null)
        {

            if (r.getEtiqueta().compareTo(etiqueta) == 0)
            {
                n = r;
                r = r.getSiguiente();
                n.setSiguiente(null);
            } else
            {
                NodoML aux = r;
                while (aux.getSiguiente() != null)
                {
                    if (aux.getSiguiente().getEtiqueta().compareTo(etiqueta) <= 0)//comparacion de aux inecesaria al inicio si es que etiqueta es menor a r
                    {//si es necesario
                        if (aux.getSiguiente().getEtiqueta().compareTo(etiqueta) == 0)
                        {
                            n = aux.getSiguiente();
                            aux.setSiguiente(n.getSiguiente());
                            n.setSiguiente(null);
                            break;
                        }
                        aux = aux.getSiguiente();
                    } else
                    {
                        System.out.println("no encontrado");
                        break;
                    }
                }
            }

        } else
        {
            System.out.println("No hay elementos en la lista");
        }

        return n;
    }

    public String desp()
    {
        String s = "";
        NodoML aux = r;
        while (aux != null)
        {
            s += aux.getEtiqueta() + "\t";
            aux = aux.getSiguiente();
        }
        return s;
    }


    public String despRecu(Nodo aux)
    {
        if (aux != null)
        {
            return aux.getEtiqueta() + "\t" + despRecu(aux.getSiguiente());
        } else
        {
            return "";
        }
    }

}
