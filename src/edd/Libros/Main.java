/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd.Libros;

/**
 *
 * @author HP
 */
public class Main
{

    public static void main(String[] args)
    {
        Vista miVista = new Vista();
        Biblioteca biblioteca = new Biblioteca(10);

        Libro libro1 = new Libro("Pinocho", "Carlo Collodi", 250, "Fantasía");
        Libro libro2 = new Libro("Alicia en el País de las Maravillas", "Lewis Carroll", 200, "Fantasia");
        Libro libro3 = new Libro("El Principito", "Antoine de Saint-Exupery", 96, "Fábula");
        Libro libro4 = new Libro("Moby Dick", "Herman Melville", 635, "Aventura");
        Libro libro5 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 863, "Novela");
        Libro libro6 = new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", 320, "Fantasía");
        Libro libro7 = new Libro("El Hobbit", "J.R.R. Tolkien", 310, "Fantasía");
        Libro libro8 = new Libro("Cien años de soledad", "Gabriel Garcia Marquez", 471, "Realismo mágico");
        Libro libro9 = new Libro("Dracula", "Bram Stoker", 418, "Terror");
        Libro libro10 = new Libro("Orgullo y prejuicio", "Jane Austen", 432, "Romance");

        biblioteca.insertaLibro(libro1);
        biblioteca.insertaLibro(libro2);
        biblioteca.insertaLibro(libro3);
        biblioteca.insertaLibro(libro4);
        biblioteca.insertaLibro(libro5);
        biblioteca.insertaLibro(libro6);
        biblioteca.insertaLibro(libro7);
        biblioteca.insertaLibro(libro8);
        biblioteca.insertaLibro(libro9);
        biblioteca.insertaLibro(libro10);
        Controlador controlador = new Controlador(biblioteca, miVista);
      //  controlador.mostrarTodosLosLibros();
        controlador.buscarLibro();
        controlador.mostrarTodosLosLibros();

    }

}
