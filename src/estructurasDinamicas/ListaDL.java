/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructurasDinamicas;

/**
 *
 * @author HP
 */
public class ListaDL
{

    private NodoD r;

    /**
     * @return the r
     */
    public NodoD getR()
    {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(NodoD r)
    {
        this.r = r;
    }

    public void inserta(NodoD n)
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
                    r.setAnterior(n);
                    r = n;
                } else
                {
                    NodoD aux = r;
                    while (aux.getSiguiente() != null)
                    {
                        if (aux.getSiguiente().getEtiqueta().compareTo(n.getEtiqueta()) > 0)
                        {
                            n.setSiguiente(aux.getSiguiente());
                            aux.getSiguiente().setAnterior(n);
                            aux.setSiguiente(n);
                            n.setAnterior(aux);
                            break;
                        }
                        aux = aux.getSiguiente();
                    }
                    if (aux.getSiguiente() == null)
                    {
                        aux.setSiguiente(n);
                        n.setAnterior(aux);

                    }
                }
            }
        } else
        {
            System.out.println("El nodo es nulo");
        }
    }

    public NodoD elimina(String etiqueta)
    {
        NodoD n = null;
        if (r != null)
        {

            if (r.getEtiqueta().compareTo(etiqueta) == 0)
            {
                n = r;
                r = r.getSiguiente();
                n.setSiguiente(null);
                n.setAnterior(null);
            } else
            {
                NodoD aux = r;
                while (aux.getSiguiente() != null)
                {
                    if (aux.getSiguiente().getEtiqueta().compareTo(etiqueta) <= 0)//comparacion de aux inecesaria al inicio si es que etiqueta es menor a r
                    {//si es necesario
                        if (aux.getSiguiente().getEtiqueta().compareTo(etiqueta) == 0)
                        {
                            n = aux.getSiguiente();
                            aux.setSiguiente(n.getSiguiente());
                            if (n.getSiguiente() != null)
                            {
                                n.getSiguiente().setAnterior(aux);
                            }
                            n.setSiguiente(null);
                            n.setAnterior(null);
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
        NodoD aux = r;
        while (aux != null)
        {
            s += aux.getEtiqueta() + "\t";
            aux = aux.getSiguiente();
        }
        return s;
    }

    public String despAlRevez()
    {
        String s = "";
        NodoD aux = r;
        if (r!=null)
        {
            while (aux.getSiguiente() != null)
            {
                aux = aux.getSiguiente();
            }
            while (aux != null)
            {
                s += aux.getEtiqueta() + "\t";
                aux = aux.getAnterior();

            }
            
        }


        return s;
    }

    public String despRecu(NodoD aux)
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
        ListaDL lista = new ListaDL();
        NodoD<String> n1 = new NodoD<>("A", "A");
        NodoD<String> n2 = new NodoD<>("B", "B");
        NodoD<String> n3 = new NodoD<>("C", "C");
        NodoD<String> n4 = new NodoD<>("D", "F");
        lista.inserta(null);
        lista.inserta(n2);
        lista.inserta(n1);
        lista.inserta(n4);
        lista.inserta(n3);
        System.out.println(lista.despRecu(lista.getR()));
        System.out.println(lista.despAlRevez());
        System.out.println(lista.elimina("F").getEtiqueta());
        System.out.println(lista.elimina("A").getEtiqueta());
        System.out.println(lista.elimina("B").getEtiqueta());
        System.out.println(lista.elimina("C").getEtiqueta());

//       
    }
}
