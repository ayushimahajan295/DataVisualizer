import com.company.datavisualization.Dashboard;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Dashboard dashboard = new Dashboard("Data Visualization Dashboard");
            dashboard.setSize(1000, 800);
            dashboard.setLocationRelativeTo(null);
            dashboard.setDefaultCloseOperation(Dashboard.EXIT_ON_CLOSE);
            dashboard.setVisible(true);
        });
    }
}
