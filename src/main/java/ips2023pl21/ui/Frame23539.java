package ips2023pl21.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import ips2023pl21.service.Service23539;
import javax.swing.JLabel;
import java.awt.Font;

public class Frame23539  extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Service23539 service;
	private JLabel lbTitulo;
	
	public Frame23539(Service23539 service) {
		this.service=service;
		setTitle("Balance de compra y venta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbTitulo());
		
		//gráfico
		CategoryDataset dataset = createDataset();
		
		JFreeChart chart = ChartFactory.createBarChart(
                "Balance compra - venta", // Título del gráfico
                "Mes", // Etiqueta del eje X
                "Euros", // Etiqueta del eje Y
                dataset
        );
		
		ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));
        setContentPane(chartPanel);
	}
	
	private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Agrega datos al conjunto de datos
        dataset.addValue(1.0, "Serie1", "Categoría1"); //TODO:CAMBIAR DATOS
        dataset.addValue(4.0, "Serie1", "Categoría2");
        dataset.addValue(3.0, "Serie1", "Categoría3");
        dataset.addValue(5.0, "Serie1", "Categoría4");

        return dataset;
    }

	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("BALANCE COMPRA - VENTA");
			lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
			lbTitulo.setBounds(210, 22, 389, 36);
		}
		return lbTitulo;
	}
}
