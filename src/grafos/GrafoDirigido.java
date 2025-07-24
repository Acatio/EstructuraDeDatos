/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos;

import java.util.ArrayList;
import java.util.List;
import paquete1.Lecturas;

/**
 *
 * @author HP
 */
public class GrafoDirigido
{

    private int cantidadDeNodos;
    private int grafo[][];
    private List<Integer> pesoDeCadaRuta;
    private List<List<Character>> todasLasRutas;
    private List<Character> rutaMasCorta;

    public GrafoDirigido(int cantidadDeNodos)
    {
        this.cantidadDeNodos = cantidadDeNodos;
        grafo = new int[cantidadDeNodos][cantidadDeNodos];
        pesoDeCadaRuta = new ArrayList<>();
        todasLasRutas = new ArrayList<>();
        rutaMasCorta = new ArrayList<>();
    }

    /**
     * @return the cantidadDeNodos
     */
    public int getCantidadDeNodos()
    {
        return cantidadDeNodos;
    }

    /**
     * @return the pesoDeCadaRuta
     */
    public List<Integer> getPesoDeCadaRuta()
    {
        return pesoDeCadaRuta;
    }

    /**
     * @return the todasLasRutas
     */
    public List<List<Character>> getTodasLasRutas()
    {
        return todasLasRutas;
    }

    /**
     * @return the rutaMasCorta
     */
    public List<Character> getRutaMasCorta()
    {
        return rutaMasCorta;
    }

    /**
     * @param cantidadDeNodos the cantidadDeNodos to set
     */
    public void setCantidadDeNodos(int cantidadDeNodos)
    {
        this.cantidadDeNodos = cantidadDeNodos;
    }

    /**
     * @param pesoDeCadaRuta the pesoDeCadaRuta to set
     */
    public void setPesoDeCadaRuta(List<Integer> pesoDeCadaRuta)
    {
        this.pesoDeCadaRuta = pesoDeCadaRuta;
    }

    /**
     * @param todasLasRutas the todasLasRutas to set
     */
    public void setTodasLasRutas(List<List<Character>> todasLasRutas)
    {
        this.todasLasRutas = todasLasRutas;
    }

    /**
     * @param rutaMasCorta the rutaMasCorta to set
     */
    public void setRutaMasCorta(List<Character> rutaMasCorta)
    {
        this.rutaMasCorta = rutaMasCorta;
    }

    /**
     * @return the grafo
     */
    public int[][] getGrafo()
    {
        return grafo;
    }

    /**
     * @param grafo the grafo to set
     */
    public void setGrafo(int[][] grafo)
    {
        this.grafo = grafo;
    }

    public void llenarGrafo()
    {
        for (int i = 0; i < cantidadDeNodos; i++)
        {
            for (int j = 0; j < cantidadDeNodos; j++)
            {
                System.out.println("Digite la distancia de " + getLetraCorrespondienteALaPosicion(i) + " a " + getLetraCorrespondienteALaPosicion(j));
                int distancia = Lecturas.leerEntero();
                grafo[i][j] = distancia;
            }
        }

    }

    public void mostrarGrafo()
    {
        // Imprimir cabecera (A B C D ...)
        System.out.print("   "); // espacio para esquina superior izquierda
        for (int j = 0; j < cantidadDeNodos; j++)
        {
            System.out.print(getLetraCorrespondienteALaPosicion(j) + "  ");
        }
        System.out.println();

        // Imprimir filas
        for (int i = 0; i < cantidadDeNodos; i++)
        {
            // Imprimir letra de la fila
            System.out.print(getLetraCorrespondienteALaPosicion(i) + "  ");

            for (int j = 0; j < cantidadDeNodos; j++)
            {
                // Imprimir peso/distancia formateado
                System.out.printf("%-3d", grafo[i][j]); // ajusta ancho si quieres
            }
            System.out.println();
        }
    }

    public Character getLetraCorrespondienteALaPosicion(int posicion)
    {
        return (char) (65 + posicion);
    }

    public int getPosicionCorrespondienteAlaLetra(Character letra)
    {
        return (int) (letra - 65);
    }

    public void llenarGrafoConDatosDePrueba()
    {
        grafo[0][1] = 5;
        grafo[0][2] = 1;
        grafo[0][3] = 10;

        grafo[1][2] = 1;
        grafo[1][3] = 3;

        grafo[2][3] = 2;
    }

    public List<Character> encontrarRutaMasCorta()
    {
        encontrarPosiblesRutas(0, 0, new ArrayList<>());
        llenarListaConLosPesosDeLasRutas();
        int indexRuttaMasCorta = calcularIndexRutaMasCorta();
        return todasLasRutas.get(indexRuttaMasCorta);
    }

    private List<Character> encontrarPosiblesRutas(int filaIndex, int columnaIndex, List<Character> ruta)
    {
        if (filaIndex == cantidadDeNodos - 1)
        {
            return ruta;
        }
        if (grafo[filaIndex][columnaIndex] != 0)
        {
            List<Character> ruta2 = new ArrayList<>();
            ruta.add(getLetraCorrespondienteALaPosicion(columnaIndex));
            ruta2.addAll(ruta);
            encontrarPosiblesRutas(columnaIndex, 0, ruta);
            if (columnaIndex == cantidadDeNodos - 1)
            {
                todasLasRutas.add(ruta2);
            } else
            {
                ruta2.remove(getLetraCorrespondienteALaPosicion(columnaIndex));
                if (columnaIndex < cantidadDeNodos - 1)
                {
                    encontrarPosiblesRutas(filaIndex, columnaIndex + 1, ruta2);
                }
            }
            return ruta;

        } else
        {
            if (columnaIndex < cantidadDeNodos - 1)
            {
                encontrarPosiblesRutas(filaIndex, columnaIndex + 1, ruta);
            }
            return ruta;
        }

    }

    private List<Character> encontrarPrimerRuta(int filaIndex, int columnaIndex, List<Character> ruta)
    {
        if (filaIndex == cantidadDeNodos - 1)
        {
            return ruta;
        }

        if (grafo[filaIndex][columnaIndex] != 0)
        {
            ruta.add(getLetraCorrespondienteALaPosicion(columnaIndex));

            return encontrarPrimerRuta(columnaIndex, 0, ruta);
        } else
        {
            return encontrarPrimerRuta(filaIndex, columnaIndex + 1, ruta);
        }

    }

    private void llenarListaConLosPesosDeLasRutas()
    {
        if (todasLasRutas == null || todasLasRutas.isEmpty())
        {
            throw new IllegalStateException("No se encontro alguna ruta");
        }
        int pesoRutaActual;
        for (int i = 0; i < todasLasRutas.size(); i++)
        {
            pesoRutaActual = calcularPesoTotalDeLaRuta(todasLasRutas.get(i));
            if (pesoRutaActual != 0)
            {
                pesoDeCadaRuta.add(pesoRutaActual);
            }
        }

    }

    private int calcularIndexRutaMasCorta()
    {
        if (pesoDeCadaRuta == null || pesoDeCadaRuta.isEmpty())
        {
            throw new IllegalStateException("No se encontraron los pesos de las rutas");
        }

        int indexMenor = 0;
        int pesoRutaMenor = pesoDeCadaRuta.get(0);

        for (int i = 1; i < pesoDeCadaRuta.size(); i++)
        {
            if (pesoDeCadaRuta.get(i) < pesoRutaMenor)
            {
                pesoRutaMenor = pesoDeCadaRuta.get(i);
                indexMenor = i;
            }
        }

        return indexMenor;
    }

    private int calcularPesoTotalDeLaRuta(List<Character> ruta)
    {
        if (ruta == null || ruta.isEmpty())
        {
            throw new IllegalStateException("La ruta no existe o esta vacia");
        }
        int pesoDeLaRuta = 0;
        for (int i = 0; i < ruta.size(); i++)
        {
            int columna = getPosicionCorrespondienteAlaLetra(ruta.get(i));
            if (i == 0)
            {
                pesoDeLaRuta += obtenerPesoDeCelda(0, columna);
            } else
            {
                int fila = getPosicionCorrespondienteAlaLetra(ruta.get(i - 1));
                pesoDeLaRuta += obtenerPesoDeCelda(fila, columna);
            }
        }
        return pesoDeLaRuta;
    }

    private int obtenerPesoDeCelda(int fila, int columna)
    {
        if (fila < 0 || columna < 0 || fila >= grafo.length || columna >= grafo[fila].length)
        {
            throw new IndexOutOfBoundsException("Índices fuera de rango: fila:" + fila + ", columna:" + columna);
        }
        return grafo[fila][columna];
    }

    public static void main(String[] args)
    {
        GrafoDirigido g = new GrafoDirigido(4);
        g.llenarGrafoConDatosDePrueba();
        g.mostrarGrafo();
        try
        {
            System.out.println(g.encontrarRutaMasCorta().toString());
            System.out.println(g.todasLasRutas.toString());

        } catch (RuntimeException e)
        {
            System.out.println(e.getMessage());
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
