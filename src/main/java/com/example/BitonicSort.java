package com.example;

// Programa Java para ordenamiento Bitonic. Tenga en cuenta que este programa

// solo funciona cuando el tamaño de la entrada es una potencia de 2.

// Clase
public class BitonicSort {

    // El parámetro dir indica la dirección de ordenamiento,
    // ASCENDENTE o DESCENDENTE; si (a[i] > a[j]) concuerda
    // con la dirección, entonces a[i] y a[j] se intercambian.

    void compAndSwap(int[] a, int i, int j, int dir)
    {
        if ((a[i] > a[j] && dir == 1)
            || (a[i] < a[j] && dir == 0)) {
            // Intercambiando elementos
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    /* Ordena recursivamente una secuencia bitónica en orden ascendente,
    si dir = 1, y en orden descendente en caso contrario
    (es decir, dir=0). La secuencia a ordenar comienza en
    la posición de índice bajo, el parámetro cnt es el número
    de elementos a ordenar.*/
    void bitonicMerge(int a[], int low, int cnt, int dir)
    {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++){
                compAndSwap(a, i, i + k, dir);
            }
            bitonicMerge(a, low, k, dir);
            bitonicMerge(a, low + k, k, dir);
        }
    }

    /* Esta función primero produce una secuencia bitónica al
    ordenar recursivamente sus dos mitades en órdenes de
    ordenamiento opuestos, y luego llama a bitonicMerge para
    hacerlas en el mismo orden */
    void bitonicSort(int a[], int low, int cnt, int dir)
    {
        if (cnt > 1) {
            int k = cnt / 2;

            // ordenar en orden ascendente ya que dir aquí es 1
            bitonicSort(a, low, k, 1);

            // ordenar en orden descendente ya que dir aquí es 0
            bitonicSort(a, low + k, k, 0);

            // Fusionará toda la secuencia en orden ascendente
            // ya que dir=1.
            bitonicMerge(a, low, cnt, dir);
        }
    }

    /* Llamador de bitonicSort para ordenar todo el arreglo
    de longitud N en orden ASCENDENTE */
    void sort(int a[], int N, int up)
    {
        bitonicSort(a, 0, N, up);
    }

    /* Una función de utilidad para imprimir un arreglo de tamaño n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Método principal
    public static void main(String args[])
    {
        int a[] = new int[16_777_216];
        for (int i = 0; i < a.length; i++) {
            // Cada número será un número de 8 dígitos único
            a[i] = a.length - i; 
        }
        int up = 1;
        BitonicSort ob = new BitonicSort();
        ob.sort(a, a.length,up);
        System.out.println("\nSorted array");
        // printArray(a);
        System.out.println(a[16_777_210]);
        System.out.println(a[16_777_211]);
        System.out.println(a[16_777_212]);
    }
}
