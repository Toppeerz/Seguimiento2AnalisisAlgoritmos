package com.example;

// Programa Java para implementar el Ordenamiento Gnome

import java.util.Arrays; 
public class GnomeSort{ 
static void gnomeSort(int[] arr, int n) 
{ 
int index = 0; 

while (index < n) { 
if (index == 0) {
    index++; 
}
if (arr[index] >= arr[index - 1]) {
    index++; 
}
else { 
    int temp = 0; 
    temp = arr[index]; 
    arr[index] = arr[index - 1]; 
    arr[index - 1] = temp; 
    index--; 
} 
} 
return; 
} 

// Programa principal para probar las funciones anteriores. 
public static void main(String[] args) 
{ 
    int a[] = new int[1_048_576];
    for (int i = 0; i < a.length; i++) {
        // Cada número será un número de 8 dígitos único
        a[i] = a.length - i; 
    }; 

gnomeSort(a, a.length); 

System.out.print("Secuencia ordenada después de aplicar el ordenamiento Gnome: "); 
System.out.println(a[2_097_151]); 
} 
} 

// Código contribuido por Mohit Gupta_OMG
