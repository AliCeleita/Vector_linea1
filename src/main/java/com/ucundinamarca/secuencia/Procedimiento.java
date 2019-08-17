/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucundinamarca.secuencia;

import java.util.Scanner;

/**
 *
 * @author alice
 */
public class Procedimiento {
    private int[] secuencia;
    private int mayor=0, menor=0,j,i,cont;
    
    public Procedimiento(){
        String letra="s", cadena="";
        int ingreso;
        while(letra.equals("s")||letra.equals("S")){
            Scanner numero = new Scanner(System.in);
            System.out.println("Digite la secuencia para evaluar");
            ingreso= numero.nextInt();
            cadena=cadena+","+ingreso;
            comparacion(ingreso);
            Scanner entrada = new Scanner(System.in);
            System.out.println("¿Desea continuar? S=>Si");
            letra= entrada.nextLine();
        }
        llenarRepetidos(cadena);
    }
    
    private void comparacion(int numero){
        
        if(mayor==0&&menor==0){
            mayor=menor=numero;
        }else{
            if(mayor<numero){
                mayor=numero;
            }else if(menor>numero){
                menor=numero;
            }
        }
    }
    
    private void llenarRepetidos(String cadena){
        String[] numeros = cadena.split(",");
        int [] aux=new int[numeros.length-1];
        j=0;
        for(i=1;i<numeros.length;i++){
            aux[j]=Integer.parseInt(numeros[i]);
            j++;
        }
        repetidos(aux);
    
    }
    
    private void repetidos(int[]aux){
        int[] aux2=aux;
        String repetidos="";
        for (int x=0;x<aux.length;x++) {
            cont=0;
            for (int y=x;y<aux.length;y++) {
                if (aux[x]==aux2[y]){
                    cont++;
                }    
            }
            if(cont==1){
                repetidos=repetidos+","+aux[x];
            }
        }
        llenarVector(repetidos);
    }
    
    private void llenarVector(String cadenafin){
        String[] numeros = cadenafin.split(",");
        secuencia=new int[numeros.length-1];
        j=0;
        for(i=1;i<numeros.length;i++){
            secuencia[j]=Integer.parseInt(numeros[i]);
            j++;
        }
        faltantes(secuencia);
    } 
    
    private void faltantes(int[] vector){
        j=0;
        boolean control;
        String resultado="";
        for(i=menor;i<mayor;i++){
            control=false;
            j=0;
            cont=0;
            while(control!=true&j<vector.length){
                if(i!=vector[j]){
                    control=false;
                    j++;
                }else{
                    cont=1;
                    control=true;
                }
            }
            if(cont==0){
                resultado=resultado+" || "+i;
            }
        }
        System.out.println("Faltantes "+resultado);
    }
}
