/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Modelo.Ventas;
import Vista.Formulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.JFreeChart;

public class ControladorVentas implements ActionListener {

    Formulario objetoVista;
    Ventas objetoModelo;
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorVentas() {
        objetoVista = new Formulario();
        objetoModelo = new Ventas();
        objetoVista.setVisible(true);
        objetoVista.getjButton1().addActionListener((ActionListener) this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == objetoVista.getjButton1()) {
            objetoModelo.setNombre(objetoVista.getjComboBox1().getSelectedItem().toString());
            objetoModelo.setCantidad(objetoVista.getTxtCantidad().getText());
            objetoModelo.setPrecio(objetoVista.getTxtPreciounidad().getText());
            objetoModelo.insertar();
            objetoVista.getTxtCantidad().setText("");
            objetoVista.getTxtPreciounidad().setText("");
            modelo = (DefaultTableModel) objetoVista.getjTable1().getModel();
            int filas = objetoVista.getjTable1().getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
            modelo = objetoModelo.consultar();
            objetoVista.getjTable1().setModel(modelo);
            JFreeChart grafica = objetoModelo.Graficar();
            BufferedImage grafico = grafica.createBufferedImage(600, 300);
            objetoVista.getLblgrafica().setSize(objetoVista.getPanelgrafico().getSize());
            objetoVista.getLblgrafica().setIcon(new ImageIcon(grafico));
            objetoVista.getPanelgrafico().repaint();
        }
    }
}
