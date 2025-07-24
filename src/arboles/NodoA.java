/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

/**
 *
 * @author HP
 */
public class NodoA<T>
{

    private String etiqueta;
    private T obj;
    private NodoA<T>izquierda;
    private NodoA<T> derecha;
    private int altura = 1;

    public NodoA(String etiqueta, T obj)
    {
        this.etiqueta = etiqueta;
        this.obj = obj;
    }

    /**
     * @return the etiqueta
     */
    public String getEtiqueta()
    {
        return etiqueta;
    }

    /**
     * @return the obj
     */
    public T getObj()
    {
        return obj;
    }

    /**
     * @return the izquierda
     */
    public NodoA getIzquierda()
    {
        return izquierda;
    }

    /**
     * @return the derecha
     */
    public NodoA<T> getDerecha()
    {
        return derecha;
    }

    /**
     * @param etiqueta the etiqueta to set
     */
    public void setEtiqueta(String etiqueta)
    {
        this.etiqueta = etiqueta;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(T obj)
    {
        this.obj = obj;
    }

    /**
     * @param izquierda the izquierda to set
     */
    public void setIzquierda(NodoA izquierda)
    {
        this.izquierda = izquierda;
    }

    /**
     * @param derecha the derecha to set
     */
    public void setDerecha(NodoA<T> derecha)
    {
        this.derecha = derecha;
    }

    /**
     * @return the altura
     */
    public int getAltura()
    {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(int altura)
    {
        this.altura = altura;
    }

}
