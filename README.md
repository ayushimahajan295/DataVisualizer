# DataVisualizer
Developed Data Visualization Application using Java and relevant frameworks namely Java Swing and JFreeChart. It allows users to input custom data or numerical figures, add or delete rows, and visualize the data using various chart types including Bar Chart, Line Chart, Tree Map Chart, and Pie Chart. It can handle large datasets and provides interactive options for visualization.

Features: <br/>
1. Add and Delete Data Rows: Users can add and delete rows of data.
2. Input Validation: Ensures data items are strings and numerical figures are numbers.
3. Chart Visualization: Supports Bar Chart, Line Chart, Tree Map Chart, and Pie Chart visualization.

To run this project, you need to have the following installed on your system: <br/>
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (version 11 or above)
- [Apache Maven](https://maven.apache.org/download.cgi) (for dependency management)
- An IDE like [IntelliJ IDEA](https://www.jetbrains.com/idea/) or [Eclipse](https://www.eclipse.org/downloads/)

Clone the repository -> Build the project -> Run the Main.java file
In case of any issues click on the Maven Symbol on right side and click refresh to Reload all Maven Projects.

To use the application: <br/>
1. Enter Data: 
- Data Item as String representing a data item.
- Numerical Figure as a number representing the value of the data item.
2. Add Row: Click "Add Row" button to add the entered data to table.
3. Delete Row: Select a row in the table and click the "Delete Row" button to remove it.
4. Show Charts: Click on any of the chart buttons (Bar Chart, Line Chart, Tree Map Chart, Pie Chart) to visualize the data.

This project uses the following dependencies: <br/>
- `jfreechart`: For chart generation.
- `jackson-databind`: For JSON data processing.
These dependencies are managed via Maven.

