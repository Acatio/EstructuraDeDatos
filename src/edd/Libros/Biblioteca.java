/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd.Libros;

import edd.Pila;

/**
 *
 * @author HP
 */
public class Biblioteca
{

    private Pila<Libro> pilaLibros;
    private Pila<Libro> pilaAuxiliar;

    public Biblioteca(int cantidadDeLibros)
    {
        pilaLibros = new Pila<>(new Libro[cantidadDeLibros]);
        pilaAuxiliar = new Pila<>(new Libro[cantidadDeLibros]);
    }

    /**
     * @return the pilaLibros
     */
    public Pila<Libro> getPilaLibros()
    {
        return pilaLibros;
    }

    /**
     * @param pilaLibros the pilaLibros to set
     */
    public void setPilaLibros(Pila<Libro> pilaLibros)
    {
        this.pilaLibros = pilaLibros;
    }

    public void insertaLibro(Libro libro)
    {
        pilaLibros.inserta(libro);
    }

    public Libro eliminaLibro()
    {
        return pilaLibros.elimina();
    }

    public boolean pilaLlena()
    {
        return pilaLibros.isLlena();
    }

    public boolean pilaVacia()
    {
        return pilaLibros.isVacia();
    }

    public void insertaLibroEnAux(Libro libro)
    {
        pilaAuxiliar.inserta(libro);
    }

    public Libro eliminaLibroDeAux()
    {
        return pilaAuxiliar.elimina();
    }

    public boolean pilaAuxLlena()
    {
        return pilaAuxiliar.isLlena();
    }

    public boolean pilaAuxVacia()
    {
        return pilaAuxiliar.isVacia();
    }

    public void regresarLibros()
    {
        while (!pilaAuxiliar.isVacia())
        {
            pilaLibros.inserta(pilaAuxiliar.elimina());
        }
    }

    public static void main(String[] args)
    {

    }

    /**
     * @return the pilaAuxiliar
     */
    public Pila<Libro> getPilaAuxiliar()
    {
        return pilaAuxiliar;
    }

    /**
     * @param pilaAuxiliar the pilaAuxiliar to set
     */
    public void setPilaAuxiliar(Pila<Libro> pilaAuxiliar)
    {
        this.pilaAuxiliar = pilaAuxiliar;
    }
}
