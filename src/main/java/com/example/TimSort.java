package com.example;

// Programa Java para realizar TimSort.
class TimSort {

    static int minMerge = 32;

    public static int minRunLength(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N debe ser positivo");
        }

        // Se vuelve 1 si se desplaza cualquier bit 1
        int r = 0;
        while (n >= minMerge) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    // Esta función ordena el array desde el índice izquierdo hasta el índice derecho,
    // que tiene un tamaño máximo de RUN
    public static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    // La función merge fusiona las ejecuciones ordenadas
    public static void merge(int[] arr, int l, int m, int r) {
        // El array original se divide en dos partes
        // array izquierdo y derecho
        int len1 = m - l + 1;
        int len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        for (int x = 0; x < len1; x++) {
            left[x] = arr[l + x];
        }
        for (int x = 0; x < len2; x++) {
            right[x] = arr[m + 1 + x];
        }

        int i = 0;
        int j = 0;
        int k = l;

        // Después de comparar, fusionamos esos dos arrays
        // en un subarray más grande
        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes
        // de la izquierda, si hay alguno
        while (i < len1) {
            arr[k] = left[i];
            k++;
            i++;
        }

        // Copiar el elemento restante
        // de la derecha, si hay alguno
        while (j < len2) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    // Función Timsort iterativa para ordenar el
    // array[0...n-1] (similar a merge sort)
    public static void timSort(int[] arr, int n) {
        int minRun = minRunLength(minMerge);

        // Ordenar subarrays individuales de tamaño RUN
        for (int i = 0; i < n; i += minRun) {
            insertionSort(arr, i, Math.min((i + minMerge - 1), (n - 1)));
        }

        // Comenzar a fusionar desde el tamaño
        // RUN (o 32). Se fusionará para formar tamaño 64,
        // luego 128, 256 y así sucesivamente
        for (int size = minRun; size < n; size = 2 * size) {

            // Elegir el punto de inicio
            // del subarray izquierdo. Vamos a
            // fusionar arr[left..left+size-1]
            // y arr[left+size, left+2*size-1]
            // Después de cada fusión, aumentamos left en 2*size
            for (int left = 0; left < n; left += 2 * size) {

                // Encontrar el punto final del subarray izquierdo
                // mid+1 es el punto de inicio del subarray derecho
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                // Fusionar el subarray arr[left.....mid] y
                // arr[mid+1....right]
                if (mid < right){
                    merge(arr, left, mid, right);
                }
            }
        }
    }

    // Función de utilidad para imprimir el Array
    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    // Código del controlador
    public static void main(String[] args) {
        
        int[] arr = new int[100_000_000];
        for (int i = 0; i < arr.length; i++) {
            // Cada número será un número de 8 dígitos único
            arr[i] = 10_000_000 + i; 
        }
        int n = arr.length;

        System.out.println("Given Array is");
        printArray(arr, n);

        // Tomar el tiempo antes de la ejecución del algoritmo
        long startTime = System.currentTimeMillis();

        timSort(arr, n);

        // Tomar el tiempo después de la ejecución del algoritmo
        long endTime = System.currentTimeMillis();

        System.out.println("After Sorting Array is");
        printArray(arr, n);

        // Calcular la diferencia de tiempo en milisegundos
        long executionTime = endTime - startTime;
        System.out.println(startTime);
        System.out.println(endTime);

        System.out.println("Execution time: " + executionTime + " milliseconds");
    }
}

// Este código ha sido contribuido por 29AjayKumar
