package com.company.datavisualization;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.Vector;

public class LineChart extends JFrame {

    public LineChart(String title, Vector<Vector<Object>> data) {
        super(title);
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Line Chart",
                "Data Item",
                "Numerical Figure",
                createDataset(data)
        );

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset(Vector<Vector<Object>> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 1; i < data.size(); i++) { // Skip header row
            Vector<Object> row = data.get(i);
            String item = row.get(0).toString();
            Double amount = Double.valueOf(row.get(1).toString());
            dataset.addValue(amount, "Numerical Figure", item);
        }
        return dataset;
    }
}
