/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructurasDinamicas;

/**
 *
 * @author HP
 */
public class ListaSL
{

    private Nodo r;

    /**
     * @return the r
     */
    public Nodo getR()
    {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(Nodo r)
    {
        this.r = r;
    }

    public void inserta(Nodo n)
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
                    Nodo aux = r;
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

    public Nodo elimina(String etiqueta)
    {
        Nodo n = null;
        if (r != null)
        {

            if (r.getEtiqueta().compareTo(etiqueta) == 0)
            {
                n = r;
                r = r.getSiguiente();
                n.setSiguiente(null);
            } else
            {
                Nodo aux = r;
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
        Nodo aux = r;
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

    public static void main(String[] args)
    {
        ListaSL lista = new ListaSL();
        Nodo<String> n1 = new Nodo<>("A", "A");
        Nodo<String> n2 = new Nodo<>("B", "B");
        Nodo<String> n3 = new Nodo<>("C", "C");
        Nodo<String> n4 = new Nodo<>("D", "F");
        lista.inserta(null);
        lista.inserta(n2);
        lista.inserta(n1);
        lista.inserta(n4);
        lista.inserta(n3);
        System.out.println(lista.despRecu(lista.getR()));        
        System.out.println(lista.elimina("F").getEtiqueta());
        System.out.println(lista.despRecu(lista.getR()));        
        System.out.println(lista.elimina("A").getEtiqueta());
        System.out.println(lista.despRecu(lista.getR()));        
        System.out.println(lista.elimina("B").getEtiqueta());
        System.out.println(lista.despRecu(lista.getR()));        
        System.out.println(lista.elimina("C").getEtiqueta());
        System.out.println(lista.despRecu(lista.getR()));        
//       

    }
}
