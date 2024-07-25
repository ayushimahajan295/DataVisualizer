package com.company.datavisualization;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

public class Dashboard extends JFrame {

    private DefaultTableModel tableModel;
    private JTable table;

    public Dashboard(String title) {
        super(title);
        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JPanel chartPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        JTextField itemField = new JTextField();
        JTextField amountField = new JTextField();
        JButton addRowButton = new JButton("Add Row");
        JButton deleteRowButton = new JButton("Delete Row");
        JButton barChartButton = new JButton("Show Bar Chart");
        JButton lineChartButton = new JButton("Show Line Chart");
        JButton treeMapChartButton = new JButton("Show Tree Map Chart");
        JButton pieChartButton = new JButton("Show Pie Chart");

        controlPanel.add(new JLabel("Data Item:"));
        controlPanel.add(itemField);
        controlPanel.add(new JLabel("Numerical Figure:"));
        controlPanel.add(amountField);
        controlPanel.add(addRowButton);
        controlPanel.add(deleteRowButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(controlPanel, BorderLayout.NORTH);
        mainPanel.add(Box.createVerticalStrut(20), BorderLayout.CENTER);
        mainPanel.add(chartPanel, BorderLayout.SOUTH);

        chartPanel.add(barChartButton);
        chartPanel.add(lineChartButton);
        chartPanel.add(treeMapChartButton);
        chartPanel.add(pieChartButton);

        tableModel = new DefaultTableModel(new Object[]{"Data Item", "Numerical Figure"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0 && super.isCellEditable(row, column);
            }
        };
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.SOUTH);

        addRowButton.addActionListener(e -> {
            String item = itemField.getText().trim();
            String amount = amountField.getText().trim();

            if (item.isEmpty() || !amount.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Data Item must be a string and Numerical Figure must be a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } else {
                tableModel.addRow(new Object[]{item, Integer.parseInt(amount)});
                itemField.setText("");
                amountField.setText("");
            }
        });

        deleteRowButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
            }
        });

        barChartButton.addActionListener(e -> {
            CustomChartPanel customChartPanel = new CustomChartPanel("Bar Chart", getDataFromTable());
            customChartPanel.setSize(800, 400);
            customChartPanel.setLocationRelativeTo(null);
            customChartPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            customChartPanel.setVisible(true);
        });

        lineChartButton.addActionListener(e -> {
            LineChart lineChart = new LineChart("Line Chart", getDataFromTable());
            lineChart.setSize(800, 400);
            lineChart.setLocationRelativeTo(null);
            lineChart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            lineChart.setVisible(true);
        });

        treeMapChartButton.addActionListener(e -> {
            TreeMapChart treeMapChart = new TreeMapChart("Tree Map Chart", getDataFromTable());
            treeMapChart.setSize(800, 600);
            treeMapChart.setLocationRelativeTo(null);
            treeMapChart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            treeMapChart.setVisible(true);
        });

        pieChartButton.addActionListener(e -> {
            PieChart pieChart = new PieChart("Pie Chart", getDataFromTable());
            pieChart.setSize(800, 400);
            pieChart.setLocationRelativeTo(null);
            pieChart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            pieChart.setVisible(true);
        });

        amountField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();
                if (!Character.isDigit(ch)) {
                    e.consume();
                    JOptionPane.showMessageDialog(Dashboard.this, "Numerical Figure must be a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private Vector<Vector<Object>> getDataFromTable() {
        Vector<Vector<Object>> data = new Vector<>();

        Vector<Object> columnHeaders = new Vector<>();
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            columnHeaders.add(tableModel.getColumnName(i));
        }
        data.add(columnHeaders);

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Vector<Object> rowData = new Vector<>();
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                rowData.add(tableModel.getValueAt(i, j));
            }
            data.add(rowData);
        }

        return data;
    }
}
