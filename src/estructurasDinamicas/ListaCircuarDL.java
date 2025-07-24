/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructurasDinamicas;

/**
 *
 * @author HP
 */
public class ListaCircuarDL
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
                r.setSiguiente(n);
                r.setAnterior(n);
            } else
            {
                if (n.getEtiqueta().compareTo(r.getSiguiente().getEtiqueta()) < 0 || n.getEtiqueta().compareTo(r.getEtiqueta()) > 0)
                {
                    n.setSiguiente(r.getSiguiente());
                    r.setSiguiente(n);
                    n.getSiguiente().setAnterior(n);
                    n.setAnterior(r);
                    if (n.getEtiqueta().compareTo(r.getEtiqueta()) > 0)
                    {
                        r = n;//r.getSiguiente()
                    }
                } else
                {
                    NodoD aux = r;
                    while (true)
                    {
                        if (aux.getSiguiente().getEtiqueta().compareTo(n.getEtiqueta()) > 0)
                        {
                            n.setSiguiente(aux.getSiguiente());
                            aux.setSiguiente(n);
                            n.getSiguiente().setAnterior(n);
                            n.setAnterior(aux);
                            break;
                        }
                        aux = aux.getSiguiente();
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
        if (etiqueta == null)
        {
            System.out.println("inserte una etiqueta valida");
            return n;
        }
        if (r != null)
        {
            if (etiqueta.compareTo(r.getSiguiente().getEtiqueta()) >= 0 && etiqueta.compareTo(r.getEtiqueta()) <= 0)
            {
                
                if (etiqueta.compareTo(r.getSiguiente().getEtiqueta()) == 0)
                {
                    n = r.getSiguiente();
                    r.setSiguiente(n.getSiguiente());
                    n.getSiguiente().setAnterior(r);
                    n.setSiguiente(null);
                    n.setAnterior(null);
                    if (n == r)
                    {
                        r = null;
                    }
                } else
                {
                    NodoD aux = r.getSiguiente();
                    while (aux != r)
                    {
                        if (etiqueta.compareTo(aux.getSiguiente().getEtiqueta()) >= 0)
                        {
                            if (etiqueta.compareTo(aux.getSiguiente().getEtiqueta()) == 0)
                            {
                                n = aux.getSiguiente();
                                aux.setSiguiente(n.getSiguiente());
                                n.getSiguiente().setAnterior(aux);
                                
                                if (n == r)
                                {
                                    r = aux;
                                }
                                n.setSiguiente(null);
                                n.setAnterior(null);
                                break;
                                
                            } else
                            {
                                aux = aux.getSiguiente();
                            }
                            
                        } else
                        {
                            break;
                        }
                    }
                    if (n == null)
                    {
                        System.out.println("no encontrado D:");
                    }
                    
                }
                
            } else
            {
                System.out.println("El elemento no esta en la lista");
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
        if (r != null)
        {
            NodoD aux = r.getSiguiente();
            do
            {
                s += aux.getEtiqueta() + "\t";
                aux = aux.getSiguiente();
            } while (aux != r.getSiguiente());
            
        }else
        {
            s+="No hay elementos en la lista";
        }
        return s;
    }
     public String despAlReves()
    {
        String s = "";
        if (r != null)
        {
            NodoD aux = r;
            do
            {
                s += aux.getEtiqueta() + "\t";
                aux = aux.getAnterior();
            } while (aux != r);
           
        }else
        {
            s+="No hay elementos en la lista";
        }
        return s;
    }
    public String despRecu(Nodo r, Nodo primerNodo)
    {
        if (primerNodo != r)
        {
            return primerNodo.getEtiqueta() + "\t" + despRecu(r, primerNodo.getSiguiente());
        } else
        {
            return r.getEtiqueta();
        }
    }
    
    public static void main(String[] args)
    {
        ListaCircuarDL lista = new ListaCircuarDL();
        NodoD<String> n1 = new NodoD<>("A", "A");
        NodoD<String> n2 = new NodoD<>("B", "B");
        NodoD<String> n3 = new NodoD<>("C", "C");
        NodoD<String> n4 = new NodoD<>("D", "F");
        lista.inserta(null);
        lista.inserta(n2);
        lista.inserta(n1);
        lista.inserta(n4);
        lista.inserta(n3);
        System.out.println(lista.desp());
        System.out.println(lista.despAlReves());
        
        lista.elimina(null);
        
        System.out.println(lista.elimina("B").getEtiqueta());
        System.out.println(lista.elimina("C").getEtiqueta());
        System.out.println(lista.desp());
        System.out.println(lista.despAlReves());
        
    }
}
