package ips2023pl21.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.Dimension;


public class Frame23539_2  extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnGrafico;
	private ChartPanel chartPanel;
	private Frame23539_1 frame;
	
	
	public Frame23539_2(Frame23539_1 frame23539_1) {
		this.frame=frame23539_1;
		setMinimumSize(new Dimension(700,400));
		setLocationRelativeTo(null);
		setTitle("Balance de compra y venta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnGrafico());
		crearGrafico();
	}
	
	private void crearGrafico() {
		
		//gráfico
		CategoryDataset dataset = createDataset();
		
		JFreeChart chart = ChartFactory.createBarChart(
                "Balance compra - venta", // Título del gráfico
                "Mes", // Etiqueta del eje X
                "Euros", // Etiqueta del eje Y
                dataset
        );
		
		chartPanel=new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));
        setContentPane(chartPanel);
	}
	
	private CategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Agrega datos al conjunto de datos
        for(int i=1;i<=9;i++) {
        	String date=frame.getComboBox().getSelectedItem().toString()+"-0"+i+"-01";
        	dataset.addValue(frame.getService().calcularGanancias(date),  "Ganancias(Euros)",String.valueOf(i)); 
        	dataset.addValue(frame.getService().calcularPerdidas(date), "Pérdidas(Euros)", String.valueOf(i));
        	dataset.addValue(frame.getService().getBalance(), "Balance(Euros)", String.valueOf(i));
        }for(int i=10;i<=12;i++) {
        	String date=frame.getComboBox().getSelectedItem().toString()+"-"+i+"-01";
        	dataset.addValue(frame.getService().calcularGanancias(date),  "Ganancias(Euros)",String.valueOf(i)); 
        	dataset.addValue(frame.getService().calcularPerdidas(date), "Pérdidas(Euros)", String.valueOf(i));
        	dataset.addValue(frame.getService().getBalance(), "Balance(Euros)", String.valueOf(i));	
        }
        return dataset;
    }
	private JPanel getPnGrafico() {
		if (pnGrafico == null) {
			pnGrafico = new JPanel();
		}
		return pnGrafico;
	}
}
