/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructurasDinamicas;

/**
 *
 * @author HP
 */
public class NodoD <T>
{
    private T objeto;
    private NodoD siguiente;
    private NodoD anterior;
    private String etiqueta;

    public NodoD(T objeto, String etiqueta)
    {
        this.objeto = objeto;
        this.etiqueta = etiqueta;
    }

    /**
     * @return the objeto
     */
    public T getObjeto()
    {
        return objeto;
    }

    /**
     * @return the siguiente
     */
    public NodoD getSiguiente()
    {
        return siguiente;
    }

    /**
     * @return the anterior
     */
    public NodoD getAnterior()
    {
        return anterior;
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(T objeto)
    {
        this.objeto = objeto;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoD siguiente)
    {
        this.siguiente = siguiente;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(NodoD anterior)
    {
        this.anterior = anterior;
    }

    /**
     * @return the etiqueta
     */
    public String getEtiqueta()
    {
        return etiqueta;
    }

    /**
     * @param etiqueta the etiqueta to set
     */
    public void setEtiqueta(String etiqueta)
    {
        this.etiqueta = etiqueta;
    }
    
}
