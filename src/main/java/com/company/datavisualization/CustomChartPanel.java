package com.company.datavisualization;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.Vector;

public class CustomChartPanel extends JFrame {

    public CustomChartPanel(String title, Vector<Vector<Object>> data) {
        super(title);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 1; i < data.size(); i++) { // Skip header row
            Vector<Object> row = data.get(i);
            String item = row.get(0).toString();
            Double amount = Double.valueOf(row.get(1).toString());
            dataset.addValue(amount, "Numerical Figure", item);
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Bar Chart",
                "Category",
                "Score",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }
}
