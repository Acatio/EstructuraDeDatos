/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

/**
 *
 * @author HP
 * @param <T>
 */
public class ArbolBinario<T>
{

    private NodoA raiz;

    /**
     * @return the raiz
     */
    public NodoA<T> getRaiz()
    {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(NodoA<T> raiz)
    {
        this.raiz = raiz;
    }

    public void insertar(NodoA<T> obj)
    {
        NodoA<T> nuevo = new NodoA<>(obj.getEtiqueta(), obj.getObj());
        raiz = ArbolBinario.this.insertar(raiz, nuevo);
    }

    private NodoA<T> insertar(NodoA<T> raiz, NodoA<T> nuevo)
    {
        if (raiz == null)
        {
            return nuevo;
        }

        if (nuevo.getEtiqueta().compareTo(raiz.getEtiqueta()) < 0)
        {
            raiz.setIzquierda(ArbolBinario.this.insertar(raiz.getIzquierda(), nuevo));
        } else
        {
            raiz.setDerecha(ArbolBinario.this.insertar(raiz.getDerecha(), nuevo));
        }

        actualizarAltura(raiz);
        return balancear(raiz);
    }

    private void actualizarAltura(NodoA<T> nodo)
    {
        int altIzq = (nodo.getIzquierda() != null) ? nodo.getIzquierda().getAltura() : 0;
        int altDer = (nodo.getDerecha() != null) ? nodo.getDerecha().getAltura() : 0;
        nodo.setAltura(1 + Math.max(altIzq, altDer));
    }

    private int obtenerBalance(NodoA<T> nodo)
    {
        int altIzq = (nodo.getIzquierda() != null) ? nodo.getIzquierda().getAltura() : 0;
        int altDer = (nodo.getDerecha() != null) ? nodo.getDerecha().getAltura() : 0;
        return altIzq - altDer;
    }

    private NodoA<T> balancear(NodoA<T> nodo)
    {
        int balance = obtenerBalance(nodo);

        // Rotación simple derecha
        if (balance > 1 && obtenerBalance(nodo.getIzquierda()) >= 0)
        {
            return rotacionDerecha(nodo);
        }

        // Rotación doble izquierda-derecha
        if (balance > 1 && obtenerBalance(nodo.getIzquierda()) < 0)
        {
            nodo.setIzquierda(rotacionIzquierda(nodo.getIzquierda()));
            return rotacionDerecha(nodo);
        }

        // Rotación simple izquierda
        if (balance < -1 && obtenerBalance(nodo.getDerecha()) <= 0)
        {
            return rotacionIzquierda(nodo);
        }

        // Rotación doble derecha-izquierda
        if (balance < -1 && obtenerBalance(nodo.getDerecha()) > 0)
        {
            nodo.setDerecha(rotacionDerecha(nodo.getDerecha()));
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    private NodoA<T> rotacionDerecha(NodoA<T> y)
    {
        NodoA<T> x = y.getIzquierda();
        NodoA<T> T2 = x.getDerecha();

        x.setDerecha(y);
        y.setIzquierda(T2);

        actualizarAltura(y);
        actualizarAltura(x);

        return x;
    }

    private NodoA<T> rotacionIzquierda(NodoA<T> x)
    {
        NodoA<T> y = x.getDerecha();
        NodoA<T> T2 = y.getIzquierda();

        y.setIzquierda(x);
        x.setDerecha(T2);

        actualizarAltura(x);
        actualizarAltura(y);

        return y;
    }

    public String recorridoEnOrden(NodoA<T> raiz)
    {
        String s = "";
        if (raiz != null)
        {
            s += recorridoEnOrden(raiz.getIzquierda());
            s += raiz.getEtiqueta();
            s += recorridoEnOrden(raiz.getDerecha());
        }
        return s;

    }

    public String recorridoEnPreOrden(NodoA<T> raiz)
    {
        String s = "";
        if (raiz != null)
        {
            s += raiz.getEtiqueta();
            s += recorridoEnPreOrden(raiz.getIzquierda());
            s += recorridoEnPreOrden(raiz.getDerecha());
        }
        return s;

    }

    public String recorridoEnPosOrden(NodoA<T> raiz)
    {
        String s = "";
        if (raiz != null)
        {
            s += recorridoEnPosOrden(raiz.getIzquierda());
            s += recorridoEnPosOrden(raiz.getDerecha());
            s += raiz.getEtiqueta();
        }
        return s;

    }

    public NodoA<T> busca(String s)
    {
        return busca(this.raiz, s);
    }

    private NodoA<T> busca(NodoA<T> raiz, String s)
    {
        if (raiz != null)
        {
            if (raiz.getEtiqueta().equals(s))
            {
                return raiz;
            } else
            {
                if (raiz.getEtiqueta().compareTo(s) < 0)
                {
                    return busca(raiz.getDerecha(), s);
                } else
                {
                    return busca(raiz.getIzquierda(), s);
                }
            }
        }
        return null;
    }

    public void elimina(NodoA r, String d, NodoA[] arr)
    {
        if (r == null)
        {
            arr[0] = null;
            arr[1] = null;
        } else
        {
            if (!r.getEtiqueta().equals(d))//si ya se encontró
            {
                if (r.getEtiqueta().compareTo(d) > 0)
                {
                    elimina(r.getIzquierda(), d, arr);
                    r.setIzquierda(arr[1]);

                } else
                {
                    elimina(r.getDerecha(), d, arr);
                    r.setDerecha(arr[1]);
                }
                arr[1] = r;
            } else
            {
                arr[0] = r;
                if (r.getIzquierda() == null && r.getDerecha() == null)
                {
                    arr[1] = null;

                } else
                {
                    if (!(r.getIzquierda() != null && r.getDerecha() != null))//tiene un hijo
                    {
                        if (r.getIzquierda() != null)//tiene hijo izquierdo
                        {
                            arr[1] = r.getIzquierda();

                        } else
                        {
                            arr[1] = r.getDerecha();
                        }
                    } else
                    {//tiene dos hijos

                        if (r.getDerecha().getIzquierda() == null)
                        {
                            r.getDerecha().setIzquierda(r.getIzquierda());
                            arr[1] = r.getDerecha();

                        } else
                        {
                            NodoA presuSesorEnOrden = susesor(r.getDerecha());
                            arr[1] = presuSesorEnOrden.getIzquierda();
                            presuSesorEnOrden.setIzquierda(arr[1].getDerecha());//presuSesorEnOrden.getIzquierda().getDerecha()
                            arr[1].setIzquierda(r.getIzquierda());
                            arr[1].setDerecha(r.getDerecha());
                        }
                    }
                }
                arr[0].setIzquierda(null);
                arr[0].setDerecha(null);
            }
        }
    }

    public NodoA susesor(NodoA r)
    {
        if (r.getIzquierda().getIzquierda() == null)
        {
            return r;

        } else
        {
            return susesor(r.getIzquierda());
        }
    }

    public static void main(String[] args)
    {
        NodoA<String> nodo1 = new NodoA("D", "D");
        NodoA<String> nodo2 = new NodoA("B", "B");
        NodoA<String> nodo3 = new NodoA("F", "F");
        NodoA<String> nodo4 = new NodoA("A", "A");
        NodoA<String> nodo5 = new NodoA("C", "C");
        NodoA<String> nodo6 = new NodoA("E", "E");
        NodoA<String> nodo7 = new NodoA("G", "G");
        ArbolBinario<String> arbol = new ArbolBinario();
        arbol.insertar(nodo1);
        arbol.insertar(nodo2);
        arbol.insertar(nodo3);
        arbol.insertar(nodo4);
        arbol.insertar(nodo5);
        arbol.insertar(nodo6);
        arbol.insertar(nodo7);
        NodoA arr[] = new NodoA[2];
        System.out.println("*******Arbol inicial******");
        System.out.println(arbol.recorridoEnOrden(arbol.getRaiz()));

        arbol.elimina(arbol.getRaiz(), "C", arr);
        arbol.setRaiz(arr[1]);
        System.out.println(arr[0].getEtiqueta());
        System.out.println(arbol.recorridoEnOrden(arbol.getRaiz()));

        arbol.elimina(arbol.getRaiz(), "B", arr);
        arbol.setRaiz(arr[1]);
        System.out.println(arr[0].getEtiqueta());
        System.out.println(arbol.recorridoEnOrden(arbol.getRaiz()));

        arbol.elimina(arbol.getRaiz(), "F", arr);
        arbol.setRaiz(arr[1]);
        System.out.println(arr[0].getEtiqueta());
        System.out.println(arbol.recorridoEnOrden(arbol.getRaiz()));

        arbol.elimina(arbol.getRaiz(), "D", arr);
        arbol.setRaiz(arr[1]);
        System.out.println(arr[0].getEtiqueta());
        System.out.println(arbol.recorridoEnOrden(arbol.getRaiz()));
//        System.out.println(arbol.recorridoEnPreOrden(arbol.getRaiz()));
//        System.out.println(arbol.recorridoEnPosOrden(arbol.getRaiz()));
    }
}
