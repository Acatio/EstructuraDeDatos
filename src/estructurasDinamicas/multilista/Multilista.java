/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructurasDinamicas.multilista;

/**
 *
 * @author HP
 */
public class Multilista
{

    private NodoML r;

    /**
     * @return the r
     */
    public NodoML getR()
    {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(NodoML r)
    {
        this.r = r;
    }

    boolean bandera = false;

    public NodoML inserta(NodoML obj, NodoML r, String[] s, int nivel)
    {
        if (nivel == s.length - 1)
        {
            ListaSLML l = new ListaSLML();
            l.setR(r);
            l.inserta(obj);
            bandera = true;
            return l.getR();
        } else
        {
            NodoML aux = busca(r, s[nivel]);
            if (aux != null)
            {
                aux.setAbajo(inserta(obj, aux.getAbajo(), s, nivel + 1));
                if (bandera)
                {
                    obj.setArriba(aux);
                    bandera = false;
                }
            }
            return r;
        }

    }

    /**
     *
     * @param r raiz d
     * @param s ruta del dato a eliminar
     * @param nivel se manda cero al principio
     * @param arr arrego que va a almacenar en su posicion 0 el dato eliminado  y en la
     * 1 la nueva r
     */
    public void elimina(NodoML r, String[] s, int nivel, NodoML arr[])//debe retornar arreglo
    {
        if (nivel == s.length - 1)
        {
            ListaSLML l = new ListaSLML();
            l.setR(r);
            arr[0] = l.elimina(s[nivel]);;
            arr[1] = l.getR();
            arr[0].setArriba(null);
        } else
        {
            NodoML aux = busca(r, s[nivel]);
            if (aux != null)
            {
                elimina(aux.getAbajo(), s, nivel + 1, arr);
                aux.setAbajo(arr[1]);

            }
            arr[1] = r;
        }
    }

    public NodoML busca(NodoML r, String s)//eficientar 
    {

        while (r != null)
        {
            if (r.getEtiqueta().compareTo(s) > 0)
            {
                return null;
            }
            if (r.getEtiqueta().equals(s))
            {
                return r;
            }
            r = r.getSiguiente();
        }
        return null;
    }

    public String desp(NodoML r, String t)
    {
        String s = "";
        while (r != null)
        {

            if (r.getArriba() != null)
            {
                s += t + r.getEtiqueta() + "->" + r.getArriba().getEtiqueta() + "\n";
            } else
            {
                s += t + r.getEtiqueta() + "\n";
            }
            s += desp(r.getAbajo(), t + "\t");
            r = r.getSiguiente();

        }
        return s;
    }

    public static void main(String[] args)
    {
        NodoML<String> n1 = new NodoML<>("UNAM", "UNAM");
        NodoML<String> n2 = new NodoML<>("UDG", "UDG");
        NodoML<String> n3 = new NodoML<>("UAEMEX", "UAEMEX");
        NodoML<String> n4 = new NodoML<>("DER", "DER");
        NodoML<String> n5 = new NodoML<>("MED", "MED");
        NodoML<String> n6 = new NodoML<>("FIL", "FIL");
        NodoML<String> n7 = new NodoML<>("CON", "CON");
        NodoML<String> n8 = new NodoML<>("CHE", "CHE");
        NodoML<String> n9 = new NodoML<>("ODO", "ODO");
        NodoML<String> n10 = new NodoML<>("ISW", "ISW");
        NodoML<String> n11 = new NodoML<>("IPI", "IPI");
        NodoML<String> n12 = new NodoML<>("IPL", "IPL");
        NodoML<String> n13 = new NodoML<>("EDD", "EDD");
        NodoML<String> n14 = new NodoML<>("PRG", "PRG");
        Multilista m = new Multilista();
        String s[] =
        {
            ""
        };
        m.setR(m.inserta(n1, m.getR(), s, 0));
        m.setR(m.inserta(n2, m.getR(), s, 0));
        m.setR(m.inserta(n3, m.getR(), s, 0));

        String s2[] = new String[2];
        s2[0] = "UNAM";
        m.setR(m.inserta(n4, m.getR(), s2, 0));
        m.setR(m.inserta(n5, m.getR(), s2, 0));
        m.setR(m.inserta(n6, m.getR(), s2, 0));
        s2[0] = "UDG";
        m.setR(m.inserta(n7, m.getR(), s2, 0));
        m.setR(m.inserta(n8, m.getR(), s2, 0));
        m.setR(m.inserta(n9, m.getR(), s2, 0));
        s2[0] = "UAEMEX";
        m.setR(m.inserta(n10, m.getR(), s2, 0));
        m.setR(m.inserta(n11, m.getR(), s2, 0));
        m.setR(m.inserta(n12, m.getR(), s2, 0));

        String s3[] = new String[3];
        s3[0] = "UAEMEX";
        s3[1] = "ISW";
        m.setR(m.inserta(n13, m.getR(), s3, 0));
        m.setR(m.inserta(n14, m.getR(), s3, 0));

        System.out.println(m.desp(m.getR(), ""));
        String s4[] =
        {
            "UAEMEX", "ISW", "EDD"
        };
        NodoML arr[] = new NodoML[2];
        m.elimina(m.getR(), s4, 0, arr);
        if (arr[0] != null)
        {
            System.out.println("Dato eliminado: " + arr[0].getEtiqueta());
        }
        m.setR(arr[1]);

        System.out.println("****************BORRADO*****************");
        System.out.println(m.desp(m.getR(), ""));

    }

    public static String queHace(int n, String cad)
    {
        String s = "";
        if (n >= 0)
        {
            if (n % 2 == 0)
            {
                s += cad.substring(n);
            }
            s += queHace(n - 1, cad);
        }
        return s;
    }
}
