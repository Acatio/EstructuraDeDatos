/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd.Libros;

/**
 *
 * @author HP
 */
public class Libro
{

    private String titulo;
    private String autor;
    private int numeroPaginas;
    private String genero;

    public Libro(String titulo, String autor, int numeroPaginas, String genero)
    {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.genero = genero;
    }

    /**
     * @return the titulo
     */
    public String getTitulo()
    {
        return titulo;
    }

    /**
     * @return the autor
     */
    public String getAutor()
    {
        return autor;
    }

    /**
     * @return the numeroPaginas
     */
    public int getNumeroPaginas()
    {
        return numeroPaginas;
    }

    /**
     * @return the genero
     */
    public String getGenero()
    {
        return genero;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor)
    {
        this.autor = autor;
    }

    /**
     * @param numeroPaginas the numeroPaginas to set
     */
    public void setNumeroPaginas(int numeroPaginas)
    {
        this.numeroPaginas = numeroPaginas;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero)
    {
        this.genero = genero;
    }

    @Override
    public String toString()
    {
        // Crear el marco superior e inferior
        String marco = "------------------------------------------\n";
        String cierreMarco = "------------------------------------------";

        // Construir el contenido del libro dentro del marco
        String contenido = "| Titulo: " + String.format("%-30s", titulo) + " |\n"
                + "| Autor: " + String.format("%-31s", autor) + " |\n"
                + "| Pginas: " + String.format("%-30d", numeroPaginas) + " |\n"
                + "| Gnero: " + String.format("%-31s", genero) + " |";

        // Combinar el marco, el contenido y el cierre del marco
        return marco + contenido + "\n" + cierreMarco;
    }

    public static void main(String[] args)
    {
        Libro libro = new Libro("1984", "George Orwell", 328, "Ciencia Ficcion");
        System.out.println(libro.toString());
 
        System.out.println("hola");

    }

}
