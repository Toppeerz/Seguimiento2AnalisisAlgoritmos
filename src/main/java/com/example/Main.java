package com.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.PrintWriter;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;

public class Main extends JFrame {

    public Main() {

        int[] arr = new int[262_144];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            // Cada número será un número de 8 dígitos único
            arr[i] = 10_000_000 + rand.nextInt(89_999_999); 
        }
         int n = arr.length;
        // try {
        //     PrintWriter writer = new PrintWriter("array.txt", "UTF-8");
        //     for (int i = 0; i < arr.length; i++) {
        //         writer.println(arr[i]);
        //     }
        //     writer.close();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        int index = 0;

        // try {
        //     Scanner scanner = new Scanner(new File("array.txt"));
        //     while (scanner.hasNextInt()) {
        //         arr[index++] = scanner.nextInt();
        //     }
        //     scanner.close();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        List<AbstractMap.SimpleEntry<String, Long>> listaTiempos = new ArrayList<>();
        listaTiempos.add(new AbstractMap.SimpleEntry<>("TimSort", calcularTimSort(arr, n)));
        listaTiempos.add(new AbstractMap.SimpleEntry<>("CombSort", calcularCombSort(arr)));
        listaTiempos.add(new AbstractMap.SimpleEntry<>("TreeSort", calcularTreeSort(arr)));
        listaTiempos.add(new AbstractMap.SimpleEntry<>("PigeonholeSort", calcularPigeonholeSort(arr)));
        listaTiempos.add(new AbstractMap.SimpleEntry<>("HeapSort", calcularHeapSort(arr)));
        listaTiempos.add(new AbstractMap.SimpleEntry<>("BitonicSort", calcularBitonicSort(arr)));
        listaTiempos.add(new AbstractMap.SimpleEntry<>("GnomeSort", calcularGnomeSort(arr)));

        // Ordenar la lista de tiempos de ejecución
        Collections.sort(listaTiempos, Map.Entry.comparingByValue());

        correrInterfaz(listaTiempos);
        parar();
    }

    private Long calcularGnomeSort(int[] arr) {
        int[] arregloGnomeSort = arr.clone();
        Long startTime = System.currentTimeMillis();
        GnomeSort.gnomeSort(arregloGnomeSort, arregloGnomeSort.length);
        Long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private Long calcularBitonicSort(int[] arr) {
        int[] arregloBitonicSort = arr.clone();
        BitonicSort bitonicSort = new BitonicSort();
        Long startTime = System.currentTimeMillis();
        bitonicSort.sort(arregloBitonicSort, arregloBitonicSort.length, 1);
        Long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private Long calcularHeapSort(int[] arr) {
        int[] arregloHeapSort = arr.clone();
        HeapSort heapSort = new HeapSort();
        Long startTime = System.currentTimeMillis();
        heapSort.sort(arregloHeapSort);
        Long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private Long calcularPigeonholeSort(int[] arr) {
        
        int[] arregloPigeonholeSort = arr.clone();
        Long startTime = System.currentTimeMillis();
        PigeonholeSort.pigeonHoleSort(arregloPigeonholeSort, arregloPigeonholeSort.length);
        Long endTime = System.currentTimeMillis();
        return endTime - startTime;
        
    }

    private Long calcularTreeSort(int[] arr) {
        int[] arregloTreeSort = arr.clone();
        TreeSort treeSort = new TreeSort();
        Long startTime = System.currentTimeMillis();
        treeSort.treeins(arregloTreeSort);
        Long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private void parar() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private Long calcularCombSort(int[] arr) {
        int[] arregloCombSort = arr.clone();
        CombSort combSort = new CombSort();
        Long startTime = System.currentTimeMillis();
        combSort.sort(arregloCombSort);
        Long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        return endTime - startTime;
    }

    private Long calcularTimSort(int[] arr, int n) {
        int[] arregloTimSort = arr.clone();
        Long startTime = System.currentTimeMillis();
        TimSort.timSort(arregloTimSort,n);
        Long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        return endTime - startTime;
    }

    private void correrInterfaz(List<AbstractMap.SimpleEntry<String, Long>> listaTiempos) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (AbstractMap.SimpleEntry<String, Long> tiempo : listaTiempos) {
            dataset.addValue((double)tiempo.getValue(), tiempo.getKey(), "Tiempo de Ejecución");
        }
        JFreeChart chart = ChartFactory.createBarChart("Tiempos de Ejecución", "Algoritmo", "Tiempo (ms)", dataset);
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryItemRenderer renderer = plot.getRenderer();

    // Habilitar las etiquetas de los items
        renderer.setDefaultItemLabelsVisible(true);
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());

        ChartPanel chartPanel = new ChartPanel(chart);

        add(chartPanel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
        
    }

    
}
