package com.example;

// Programa Java para implementar Tree Sort
class TreeSort 
{ 

    // Clase que contiene el hijo izquierdo y derecho del nodo actual y el valor clave
    class Nodo 
    { 
        int clave; 
        Nodo izquierdo, derecho; 

        public Nodo(int item) 
        { 
            clave = item; 
            izquierdo = derecho = null; 
        } 
    } 

    // Raíz del BST
    Nodo raiz; 

    // Constructor
    TreeSort() 
    { 
        raiz = null; 
    } 

    // Este método llama principalmente a insertarRec()
    void insertar(int clave) 
    { 
        raiz = insertarRec(raiz, clave); 
    } 
    
    /* Una función recursiva para insertar una nueva clave en el BST */
    Nodo insertarRec(Nodo raiz, int clave) 
    { 

        /* Si el árbol está vacío, devuelve un nuevo nodo */
        if (raiz == null) 
        { 
            raiz = new Nodo(clave); 
            return raiz; 
        } 

        /* De lo contrario, recurre hacia abajo en el árbol */
        if (clave < raiz.clave) 
            raiz.izquierdo = insertarRec(raiz.izquierdo, clave); 
        else if (clave > raiz.clave) 
            raiz.derecho = insertarRec(raiz.derecho, clave); 

        /* devuelve la raíz */
        return raiz; 
    } 
    
    // Una función para hacer un recorrido en orden del BST
    void inorderRec(Nodo raiz) 
    { 
        if (raiz != null) 
        { 
            inorderRec(raiz.izquierdo); 
            System.out.print(raiz.clave + " "); 
            inorderRec(raiz.derecho); 
        } 
    } 
    void treeins(int arr[]) 
    { 
        for(int i = 0; i < arr.length; i++) 
        { 
            insertar(arr[i]); 
        } 
        
    } 

    // Código del controlador
    public static void main(String[] args) 
    { 
        TreeSort tree = new TreeSort(); 
        int arr[] = {5, 4, 7, 2, 11}; 
        tree.treeins(arr); 
        tree.inorderRec(tree.raiz); 
    } 
} 

// Este código es contribuido por Vibin M
