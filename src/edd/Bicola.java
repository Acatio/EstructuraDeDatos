/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 *
 * @author HP
 */
public class Bicola<T>
{

    private int atras = -1;
    int atras2;
    private T arr[];

    public Bicola(T[] arr)
    {
        this.arr = arr;
        atras2 = arr.length;
    }

    public int getAtras2()
    {
        return atras2;
    }

    public void setAtras2(int atras2)
    {
        this.atras2 = atras2;
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

    public int inserta(T objeto, int atras, int limite, int factor)
    {
        if (atras + factor == limite)
        {
            System.out.println("Bicola llena");
        } else
        {
            arr[atras + factor] = objeto;
        }
        return atras + factor;

    }

    public Object[] elimina(int atras, int limite, int factor)
    {
        Object datos[] = new Object[2];//eliminado, atras
        if (atras == limite)
        {
            System.out.println("Bicola Vacia");
            datos[1] = atras;
        } else
        {
            datos[0] = arr[limite + factor];
        }
        for (int i = limite + factor; i != atras; i += factor)
        {
            arr[i] = arr[i + factor];
        }
        datos[1]=atras-factor;
        return datos;
    }

    public boolean isVacia()
    {
        return atras == -1;
    }

    public boolean isLlena()
    {
        return arr.length - 1 == atras;
    }

    public static void main(String[] args)
    {
        Character arr[] = new Character[5];
        Bicola<Character> bicola = new Bicola<>(arr);
        bicola.setAtras2(bicola.inserta('a', bicola.getAtras2(), bicola.getAtras(), -1));
        bicola.setAtras(bicola.inserta('x', bicola.getAtras(), bicola.getAtras2(), 1));
        bicola.setAtras2(bicola.inserta('e', bicola.getAtras2(), bicola.getAtras(), -1));
        bicola.setAtras(bicola.inserta('y', bicola.getAtras(), bicola.getAtras2(), 1));
        bicola.setAtras2(bicola.inserta('a', bicola.getAtras2(), bicola.getAtras(), -1));
       Object dato[];
       dato=bicola.elimina(bicola.getAtras2(), bicola.getArr().length, -1);
        System.out.println(dato[0]);
        bicola.setAtras((int) dato[1]);
       dato=bicola.elimina(bicola.getAtras(), bicola.getArr().length, -1);
        System.out.println(dato[0]);
        bicola.setAtras((int) dato[1]);
     

    }
}
