/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd.Libros;

import paquete1.Lecturas;

/**
 *
 * @author HP
 */
public class Vista
{

    public Vista()
    {
    }

    public boolean esElLibroBuscado()
    {
        return leerRespuesta() == 's';
    }

    public void mostrarLibro(Libro libro)
    {
        if (libro == null)
        {
            System.out.println("No hay información del libro disponible.");
            return;
        }
        System.out.println(libro.toString());
    }

    private char leerRespuesta()
    {
        char respuesta;
        do
        {
            System.out.println("Este es su libro? (s/n)");
            respuesta = Character.toLowerCase(Lecturas.leerCaracter()); // Convierte a minúscula

            if (respuesta != 's' && respuesta != 'n')
            {
                System.out.println("Ingrese una respuesta valida (s/n).");
            }
        } while (respuesta != 's' && respuesta != 'n');

        return respuesta;
    }



}
