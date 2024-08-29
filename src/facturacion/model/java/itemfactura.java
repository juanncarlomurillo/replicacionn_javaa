package facturacion.model.java;

public class itemfactura {
    private producto producto;
    private int cantidad;

    // Constructor
    public itemfactura(int cantidad, producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    // Getters y setters
    public producto getProducto() {
        return producto;
    }

    public void setProducto(producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Calcula el importe
    public float calcularImporte() {
        return this.cantidad * this.producto.getPrecio();
    }

    @Override
    public String toString() {
        return producto +
                "\t" + cantidad +
                "\t" + calcularImporte();
    }
}

