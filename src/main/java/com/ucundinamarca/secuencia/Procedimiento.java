/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucundinamarca.secuencia;

import java.util.Scanner;

/**
 * Esta clase trabaja la busqueda de los numeros faltantes en una secuencia ingresada por el usuario.
 * @author Alisson Celeita
 */

public class Procedimiento {
    private int[] secuencia;
    private int mayor=0, menor=0,j,i,cont;
    /**
     * Metodo constructor, aqui el usuario ingresa los numeros que desee.
     */
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
        llenarVector(cadena);
    }
    /**
     * Metodo que compara los numeros digitados por el usuario, para saber cual es el mayor y cual el menor.
     * @param numero Numero digitado por el usuario.
     */
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
    /**
     * Metodo que llena el vector con los numeros ingresados.
     * @param cadena recibe la lista de los numeros digitados por el usuario.
     */
    private void llenarVector(String cadena){
        String[] numeros = cadena.split(",");
        int [] aux=new int[numeros.length-1];
        j=0;
        for(i=1;i<numeros.length;i++){
            aux[j]=Integer.parseInt(numeros[i]);
            j++;
        }
        repetidos(aux);
    }
    /**
     *  Metodo que elimina los numeros repetidos de la secuencia ingresada.
     * @param aux Vector de todos los numeros ingresados.
     */
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
        llenarVectorF(repetidos);
    }
    /**
     * Metodo para llenar el vector final ya organizado sin numeros repetidos.
     * @param cadenafin Cadena de numeros ingresados por el usuario, sin repetidos
     */
    private void llenarVectorF(String cadenafin){
        String[] numeros = cadenafin.split(",");
        secuencia=new int[numeros.length-1];
        j=0;
        for(i=1;i<numeros.length;i++){
            secuencia[j]=Integer.parseInt(numeros[i]);
            j++;
        }
        faltantes(secuencia);
    } 
    /**
     * Metodo que busca e imprime los numeros faltantes en la secuencia dada por el usuario.
     * @param vector Vector final con numeros ingresados
     */
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
