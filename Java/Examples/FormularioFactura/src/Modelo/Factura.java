
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Factura {

    private float subtotal, iva;
    ArrayList<Datos> factura;
    String titulos[] = {"Producto", "Valor", "Cantidad", "Subtotal", "I.V.A.", "Neto a pagar"};
    DefaultTableModel modelo = new DefaultTableModel(null, titulos);

    public Factura() {
        factura = new ArrayList();
        subtotal = 0;
        iva = 0;
    }

    public DefaultTableModel adicionar(Datos objetonuevo) {
        factura.add(objetonuevo);
        System.out.println(factura.size());
        DecimalFormat formato = new DecimalFormat("#,###,###.##");

        int i;
        Object[] fila = new Object[6];
        for (i = 0; i < factura.size(); i++) {
            fila[0] = factura.get(i).getNombre();
            fila[1] = formato.format(factura.get(i).getPrecio());
            fila[2] = formato.format(factura.get(i).getCantidad());
            subtotal = factura.get(i).getPrecio() * factura.get(i).getCantidad();
            fila[3] = formato.format(subtotal);
            iva = (subtotal * 19) / 100;
            fila[4] = formato.format(iva);
            fila[5] = formato.format(subtotal + iva);
            modelo.addRow(fila);
        }
        return modelo;
    }
}
