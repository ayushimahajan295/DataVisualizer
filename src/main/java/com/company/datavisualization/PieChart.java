package com.company.datavisualization;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class PieChart extends JFrame {

    public PieChart(String title, Vector<Vector<Object>> data) {
        super(title);
        setLayout(new BorderLayout());

        DefaultPieDataset pieDataset = new DefaultPieDataset();
        for (int i = 1; i < data.size(); i++) { // Skip header row
            Vector<Object> row = data.get(i);
            String itemName = row.get(0).toString();
            Double amount = Double.valueOf(row.get(1).toString());
            pieDataset.setValue(itemName, amount);
        }

        JFreeChart pieChart = ChartFactory.createPieChart(
                "Pie Chart",
                pieDataset,
                true,
                true,
                false);

        ChartPanel chartPanel = new ChartPanel(pieChart);
        add(chartPanel, BorderLayout.CENTER);
    }
}
