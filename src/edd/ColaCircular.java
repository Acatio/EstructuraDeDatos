/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 *
 * @author HP
 */
public class ColaCircular<T> implements Machote<T>
{

    private T arr[];
    private int atras = -1;
    private int frente = -1;

    public ColaCircular(T[] arr)
    {
        this.arr = arr;
    }

    /**
     * @return the atras
     */
    public int getAtras()
    {
        return atras;
    }

    /**
     * @return the arr
     */
    public T[] getArr()
    {
        return arr;
    }

    /**
     * @param atras the atras to set
     */
    public void setAtras(int atras)
    {
        this.atras = atras;
    }

    /**
     * @param arr the arr to set
     */
    public void setArr(T[] arr)
    {
        this.arr = arr;
    }

    /**
     * @return the frente
     */
    public int getFrente()
    {
        return frente;
    }

    /**
     * @param frente the frente to set
     */
    public void setFrente(int frente)
    {
        this.frente = frente;
    }

    @Override
    public void inserta(T objeto)
    {
        if (!isLlena())
        {
            if (atras == -1)
            {
                atras = 0;
                frente = 0;
            } else
            {
                if (atras+1==arr.length)
                {
                    atras=0;
                    
                } else
                {
                    atras++;
                }
            }
            arr[atras]=objeto;

        } else
        {
            System.out.println("cola llena");
        }

    }

    @Override
    public T elimina()
    {
        T eliminado = null;
        if (!isVacia())
        {
            eliminado=arr[frente];
            if (frente==arr.length-1)
            {
 
                
            } else
            {
                if (frente==atras)
                {
                    frente=-1;
                    atras=-1;
                } else
                {
                    frente++;
                }
            }

        } else
        {
            System.out.println("cola circular vacia");
        }
        return eliminado;
    }

    @Override
    public boolean isVacia()
    {
        return atras == -1;
    }

    @Override
    public boolean isLlena()
    {
        return arr.length - 1 == atras && frente == 0 || atras + 1 == frente;
    }

    public static void main(String[] args)
    {
        Integer arr[]=new Integer[5];
        ColaCircular<Integer> cola=new ColaCircular<>(arr);
        cola.inserta(1);
        cola.inserta(2);
        cola.inserta(3);
        cola.inserta(4);
        cola.inserta(5);
        cola.inserta(10);
        System.out.println(cola.elimina());
        System.out.println(cola.elimina());
           System.out.println(cola.elimina());
           System.out.println(cola.elimina());
           System.out.println(cola.elimina());
           System.out.println(cola.elimina());
                

    }

}
