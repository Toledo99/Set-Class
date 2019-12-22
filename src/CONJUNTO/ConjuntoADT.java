/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONJUNTO;

/**
 *
 * @author huesos
 */
public interface ConjuntoADT <T> extends Iterable <T>{
    
    public boolean agrega (T elem);
    public T quita (T elem);
    public boolean contiene(T elem);
    public int getCardinalidad();
    public boolean estaVacio();
    
    public ConjuntoADT <T> union(ConjuntoADT <T> otro);
    public ConjuntoADT <T> interseccion(ConjuntoADT <T> otro);
    public ConjuntoADT <T> diferencia(ConjuntoADT <T> otro);
}
