/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd.Libros;

/**
 *
 * @author HP
 */
public class Controlador
{

    private final Biblioteca biblioteca;
    private final Vista vista;

    public Controlador(Biblioteca biblioteca, Vista visata)
    {
        this.biblioteca = biblioteca;
        this.vista = visata;
    }

    public boolean pilaConLibros()///TODO separar en bibliotecaExiste y utilizar aparte pilaVacia
    {
        if (biblioteca == null)
        {
            System.out.println("Biblioteca nulla");
            return false;
        }
        if (biblioteca.pilaVacia())
        {
            System.out.println("No hay libros");
            return false;
        }
        return true;

    }

    public void buscarLibro()
    {
        if (pilaConLibros())//TODO  cambiar a if bibliotecca existe y pila no vacia
        {
            boolean libroEncontrado = false;
            do
            {
                Libro libro = biblioteca.eliminaLibro();
                vista.mostrarLibro(libro);
                libroEncontrado = vista.esElLibroBuscado();
                if (libroEncontrado)
                {
                    biblioteca.regresarLibros();
                } else
                {
                    biblioteca.insertaLibroEnAux(libro);
                }

            } while (!libroEncontrado && !biblioteca.pilaVacia());
            if (libroEncontrado == false)
            {
                System.out.println("Se han mostrado todos los libros!!!");
            }
        }

    }

    public void mostrarTodosLosLibros()
    {

        while (pilaConLibros())
        {

            Libro libro = biblioteca.eliminaLibro();
            if (libro != null)
            {
                vista.mostrarLibro(libro);
                biblioteca.insertaLibroEnAux(libro);
            }
        }
        if (biblioteca != null)
        {
            if (!biblioteca.pilaAuxVacia())
            {
                biblioteca.regresarLibros();
            }
        }

    }

}
