package com.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class Main extends JFrame {

    public Main() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Category 1", "Value 1");
        dataset.addValue(15, "Category 1", "Value 2");
        dataset.addValue(20, "Category 1", "Value 3");

        JFreeChart barChart = ChartFactory.createBarChart(
                "Bar Chart Example",
                "Category",
                "Value",
                dataset);

        ChartPanel chartPanel = new ChartPanel(barChart);
        setContentPane(chartPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
