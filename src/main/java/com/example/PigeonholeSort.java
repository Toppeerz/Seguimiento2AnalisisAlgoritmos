package com.example;
/* Programa Java para implementar el ordenamiento de Pigeonhole */

import java.util.*;

public class PigeonholeSort
{
    public static void pigeonHoleSort(int[] arr,
                                        int n)
    {
        int min = arr[0];
        int max = arr[0];
        int range; 
        int i; 
        int j; 
        int index; 

        // Encontrar el valor mínimo y máximo en el arreglo
        for(int a=0; a<n; a++)
        {
            if(arr[a] > max){
                max = arr[a];
            }
            if(arr[a] < min){
                min = arr[a];
            }
        }

        range = max - min + 1;
        int[] phole = new int[range];
        Arrays.fill(phole, 0);

        // Contar la frecuencia de cada elemento en el arreglo
        for(i = 0; i<n; i++){
            phole[arr[i] - min]++;
        }
        
        index = 0;

        // Ordenar el arreglo utilizando el ordenamiento de Pigeonhole
        for(j = 0; j<range; j++){
            while(phole[j]-->0){
                arr[index++]=j+min;
            }
        }
    }

public static void main(String[] args)
{
    int[] arr = {8, 3, 2, 7, 4, 6, 8};

    System.out.print("El arreglo ordenado es: ");

    PigeonholeSort.pigeonHoleSort(arr,arr.length);
    
    for(int i=0 ; i<arr.length ; i++){
        System.out.print(arr[i] + " ");
    }
}
}

// Código contribuido por Mohit Gupta_OMG <(0_o)>
