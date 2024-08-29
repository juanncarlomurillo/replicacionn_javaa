package facturacion.model.java;
import java.text.SimpleDateFormat;
import java.util.Date;

public class factura {
    private static int ultimoFolio;
    private int folio;
    private String descripcion;
    private Date fecha;
    private cliente cliente;
    private itemfactura[] items;
    private int indiceItems;
    private static final int MAX_ITEMS = 10;

    public factura(String descripcion, cliente cliente) {
        this.folio = ++ultimoFolio;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new itemfactura[MAX_ITEMS];
        this.fecha = new Date();
    }

    public void addItemFactura(itemfactura item) {
        if (indiceItems < MAX_ITEMS) {
            this.items[indiceItems++] = item;
        }
    }

    public float calcularTotal() {
        float total = 0.0f;
        for (itemfactura item : items) {
            if (item == null) {
                continue;
            }
            total += item.calcularImporte();
        }
        return total;
    }

    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura Nº: ");
        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t NIF: ")
                .append(cliente.getNif())
                .append("\nDescripción: ")
                .append(this.descripcion)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append("Fecha Emisión: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n");

        for (itemfactura item : this.items) {
            if (item == null) {
                continue;
            }
            sb.append(item)
                    .append("\n");
        }
        sb.append("\nGran Total: ")
                .append(calcularTotal());

        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}
