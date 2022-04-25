/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automacellulare;

import java.util.Vector;

/**
 *
 * @author Paolo
 */
public class Automa{
    private int[] lista;
    private int[][] regole = {
        {0,0,0},
        {0,0,1},
        {0,1,0},
        {0,1,1},
        {1,0,0},
        {1,0,1},
        {1,1,0},
        {1,1,1}
    };
    private int[] statoRegole = new int[regole.length];

    public Automa(int[] path, int[] statoIniziale){
        lista = statoIniziale;
        statoRegole = path;
    }
    

    private int controllaRegola(int[] celle){
        int ris = 0;
        //controllo dentro la tabella delle regole
        for(int i = 0; i < regole.length;i++){
            if(celle[0]==regole[i][0]&&celle[1]==regole[i][1]&&celle[2]==regole[i][2]){
                ris = statoRegole[i];
                break;
            }else{
                ris = 0;
            }
        }
        return ris;
    }
    /**
     * per il calcolo di bordi ho deciso di pensare come se fosse un anello
     * per cui:
     * - nella posizione 0 al posto di -1 avrò n-1
     * - nella posizione n-1 al posto di n+1 avrò 0 
     */
    public void calcolaGenerazione(){
        int[] nuova = new int[lista.length];
        int[] celle = new int[3];
        
        for(int i=0; i<lista.length;i++){
            if(i==0){
                celle[0] = lista[lista.length-1];
                celle[1] = lista[i];
                celle[2] = lista[i+1];
            }else if(i == lista.length-1){
                celle[0] = lista[i-1];
                celle[1] = lista[i];
                celle[2] = lista[0];                    
            }else{
                celle[0] = lista[i-1];
                celle[1] = lista[i];
                celle[2] = lista[i+1];
            } 
     
            nuova[i] = controllaRegola(celle);
        }
        lista = nuova;
    }
    public int[] getGenerazione(){
        return lista;
    }
}
