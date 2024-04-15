package com.example;

// Programa Java para la implementación de Heap Sort

public class HeapSort {
    public void sort(int[] arr)
    {
        int N = arr.length;

        // Construir el montículo (reorganizar el arreglo)
        for (int i = N / 2 - 1; i >= 0; i--){
            heapify(arr, N, i);
        }

        // Extraer uno por uno los elementos del montículo
        for (int i = N - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Llamar a heapify máximo en el montículo reducido
            heapify(arr, i, 0);
        }
    }

    // Para convertir un subárbol con raíz en el nodo i, que es
    // un índice en arr[]. n es el tamaño del montículo
    void heapify(int arr[], int N, int i)
    {
        // Inicializar largest como raíz
        int largest = i; 
        // izquierda = 2*i + 1
        int l = 2 * i + 1; 
        // derecha = 2*i + 2
        int r = 2 * i + 2;

        // Si el hijo izquierdo es mayor que la raíz
        if (l < N && arr[l] > arr[largest]){
            largest = l;
        }
        // Si el hijo derecho es mayor que el mayor hasta ahora
        if (r < N && arr[r] > arr[largest]){
            largest = r;
        }
        // Si el mayor no es la raíz
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursivamente convertir el subárbol afectado
            heapify(arr, N, largest);
        }
    }

    /* Una función de utilidad para imprimir un arreglo de tamaño n */
    static void printArray(int arr[])
    {
        int N = arr.length;

        for (int i = 0; i < N; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Código del controlador
    public static void main(String args[])
    {
        int[] arr = { 12, 11, 13, 5, 6, 7 };

        // Llamada a la función
        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("El arreglo ordenado es");
        printArray(arr);
    }
}
