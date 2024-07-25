package com.company.datavisualization;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class TreeMapChart extends JFrame {

    public TreeMapChart(String title, Vector<Vector<Object>> data) {
        super(title);
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 1; i < data.size(); i++) { 
            Vector<Object> row = data.get(i);
            String item = row.get(0).toString();
            Double amount = Double.valueOf(row.get(1).toString());
            dataset.setValue(item, amount);
        }

        JFreeChart treeMapChart = ChartFactory.createRingChart(
                "Tree Map Chart",
                dataset,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(treeMapChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }
}
