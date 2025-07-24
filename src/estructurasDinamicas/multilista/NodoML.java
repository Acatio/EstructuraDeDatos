/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructurasDinamicas.multilista;

/**
 *
 * @author HP
 */
public class NodoML <T>
{
    private String etiqueta;
    private T objeto;
    private NodoML siguiente;
    private NodoML anterior;
    private NodoML arriba;
    private NodoML abajo;

    public NodoML(String etiqueta, T objeto)
    {
        this.etiqueta = etiqueta;
        this.objeto = objeto;
    }

    /**
     * @return the etiqueta
     */
    public String getEtiqueta()
    {
        return etiqueta;
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
    public NodoML getSiguiente()
    {
        return siguiente;
    }

    /**
     * @return the anterior
     */
    public NodoML getAnterior()
    {
        return anterior;
    }

    /**
     * @return the arriba
     */
    public NodoML getArriba()
    {
        return arriba;
    }

    /**
     * @return the abajo
     */
    public NodoML getAbajo()
    {
        return abajo;
    }

    /**
     * @param etiqueta the etiqueta to set
     */
    public void setEtiqueta(String etiqueta)
    {
        this.etiqueta = etiqueta;
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
    public void setSiguiente(NodoML siguiente)
    {
        this.siguiente = siguiente;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(NodoML anterior)
    {
        this.anterior = anterior;
    }

    /**
     * @param arriba the arriba to set
     */
    public void setArriba(NodoML arriba)
    {
        this.arriba = arriba;
    }

    /**
     * @param abajo the abajo to set
     */
    public void setAbajo(NodoML abajo)
    {
        this.abajo = abajo;
    }
    
    
    
}
