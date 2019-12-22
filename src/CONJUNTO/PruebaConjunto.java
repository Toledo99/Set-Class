/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONJUNTO;

import CONJUNTO.*;
import java.util.Iterator;
/**
 *
 * @author huesos
 */
public class PruebaConjunto {
    
    public static void main ( String [] args){
        
        ConjuntoADT <String> conj1 = new ConjuntoArreglo();
        ConjuntoADT <Double> conj2 = new ConjuntoArreglo();
        
        conj1.agrega("azul");
        conj1.agrega("rojo");
        conj1.agrega("verde");
        
        if(conj1.agrega("rojo"))
            System.out.println("¡Allta exitosa!");
        else
            System.out.println("\n Error de alta");
        
        conj2.agrega(10.5);
        conj2.agrega(20.3);
        conj2.agrega(240.9);
        conj2.agrega(86.47);
        
        if(conj2.contiene(240.9))
            System.out.println("Simón Pedro");
        else
            System.out.println("Nel coronel");
        
        Iterator <Double> it = conj2.iterator() ;
        double suma=0;
        
        while(it.hasNext())
            suma+=it.next();
        
        System.out.println("Suma: "+suma+"\n");
        
        ConjuntoADT <String> conj4 = new ConjuntoArreglo();
        conj4.agrega("azul");
        conj4.agrega("naranja");
        conj4.agrega("verde");
        
        ConjuntoADT <String> resUnion = conj1.union(conj4);
        
        Iterator itRes = resUnion.iterator();
        while(itRes.hasNext())
            System.out.println((String)itRes.next());
        
        System.out.println("\n");
        
        ConjuntoADT <String> resInter = conj1.interseccion(conj4);
        
        Iterator itResInter = resInter.iterator();
        while(itResInter.hasNext())
            System.out.println((String)itResInter.next());
        
        System.out.println("\n");
        
        ConjuntoADT <String> resDif = conj1.diferencia(conj4);
        
        Iterator itResDif = resDif.iterator();
        while(itResDif.hasNext())
            System.out.println((String)itResDif.next());
    }
}
