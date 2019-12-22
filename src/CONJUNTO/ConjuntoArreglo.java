/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONJUNTO;

import java.util.Iterator;

/**
 *
 * @author huesos
 */
public class ConjuntoArreglo <T> implements ConjuntoADT <T> {
    
    private T [] conjunto;
    private int cardinalidad;
    private final int MAX = 20;
    
    public ConjuntoArreglo(){
        conjunto = (T[]) new Object[MAX];
        cardinalidad = 0;
    }
    
    public ConjuntoArreglo(int max){
        conjunto = (T[]) new Object[max];
        cardinalidad = 0;
    }
    
    public Iterator<T> iterator(){
        return new IteradorArreglo(conjunto, cardinalidad);
    }
    
    public boolean contiene(T elem){
        Iterator <T> it = iterator();
        boolean band = false;
        while(it.hasNext() && !band)
            band = it.next().equals(elem);
        return band;
    }
    
    /*
    public boolean contiene(T elem){
        return contiene(elem, iterator());
    }
    private boolean contiene(T elem, Iterator <T> it){
        if(!it.hasNext())
            return false;
        else
            if(it.next().equals(elem))
                return true;
            else 
                return contiene(elem, it);
    }
    */
    public boolean agrega(T elem){
        boolean resp = false;
        if(!contiene(elem)){
            if(cardinalidad == conjunto.length)
                expande();
            conjunto[cardinalidad] = elem;
            cardinalidad++;
            resp=true;
        }
        return resp;
    }
    
    private void expande(){
        T [] aux = (T[]) new Object[conjunto.length*2];
        for(int i =0; i<conjunto.length; i++)
            aux[i] = conjunto[i];
        conjunto = aux;
        
    }
    
    public boolean estaVacio(){
        return cardinalidad == 0;
    }
    
    public int getCardinalidad(){
        return cardinalidad;
    }
    
    private int buscaPos(T elem){
        int i = 0;
        while( i<cardinalidad && !conjunto[i].equals(elem))
            i++;
        if(i== cardinalidad)
            i=-1;
        return i;
    }
    public T quita(T elem){
        T resp;
        int pos = buscaPos(elem);
        if(pos >=0){
            resp=conjunto[pos];
            conjunto[pos] = conjunto[cardinalidad-1];
            conjunto[cardinalidad-1]=null;
            cardinalidad--;
        }
        else
            resp = null;
        
        return resp;
    }

    @Override
    public ConjuntoADT<T> union(ConjuntoADT<T> otro) {
        if(otro == null)
            throw new NullPointerException();
        int max= cardinalidad + otro.getCardinalidad();
        ConjuntoArreglo <T> res = new ConjuntoArreglo(max);
        for(int i=0; i<cardinalidad; i++){
            res.agrega(conjunto[i]);
        }
        Iterator <T> itOtro = otro.iterator();
        T aux;
        while(itOtro.hasNext()){
            aux = itOtro.next();
            if(!res.contiene(aux)){
                res.agrega(aux);
            }
        }
        return res;
    }
    
    /*
    public ConjuntoADT <T> union(ConjuntoADT otro){
        ConjuntoADT res = new ConjuntoArreglo();
        Iterator<T> it1 = iterator();
        Iterator <T> it2 = otro.iterator();
        
        while(it1.hasNext())
            res.agrega(it1.next());
        while(it2.hasNext())
            res.agrega(it2.next());
        return res;
    }
    */
    

    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro) {
        if(otro == null)
            throw new NullPointerException();
        
        ConjuntoADT <T> res = new ConjuntoArreglo(MAX);
        
        if(cardinalidad <= otro.getCardinalidad())
            for(int i = 0; i<cardinalidad; i++)
                if(otro.contiene(conjunto[i]))
                    res.agrega(conjunto[i]);
                
        else{  
            T aux=null;
            Iterator it = otro.iterator();
            
            while(it.hasNext()){
                aux = (T) it.next();
                if(this.contiene(aux))
                    res.agrega(aux);
            }        
        }
        return res;
    }
    
    /*
    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro){
        Iterator <T> it = otro.iterator();
        ConjuntoADT <T> res = new ConjuntoArreglo();
        T aux;
        while(it.hasNext()){
            aux=it.next();
            if(contiene(aux))
                res.agrega(aux);
        }
        return res;
    }
    */
    
    /*
    @Override
    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro) {
        if(otro == null)
            throw new NullPointerException();
        
        ConjuntoADT <T> res = new ConjuntoArreglo(MAX);
        for(int i = 0; i<cardinalidad; i++)
                if(!otro.contiene(conjunto[i]))
                    res.agrega(conjunto[i]);
        
        return res;
    }
    */
    
    public ConjuntoADT <T> diferencia(ConjuntoADT <T> otro){
        ConjuntoArreglo res = new ConjuntoArreglo(cardinalidad);
        if(otro == null)
            throw new NullPointerException();
        Iterator <T> it = iterator();
        T aux;
        int j=0;
        int cont=0;
        int n = otro.getCardinalidad();
        while(it.hasNext() && cont<n){
            aux = it.next();
            if(!otro.contiene(aux)){
                res.conjunto[j] = aux;
                j++;
            }
            else
                cont++;
        }
        res.cardinalidad = j;
        return res;
    }
    
    
    
}
