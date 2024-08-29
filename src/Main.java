package facturacion.model.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        cliente cliente = new cliente();
        cliente.setNif("5555-5");
        cliente.setNombre("Andrés");

        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese una descripción de la factura: ");
        String desc = s.nextLine();
        factura factura = new factura(desc, cliente);

        producto producto;

        System.out.println();

        for (int i = 0; i < 5; i++) {
            producto = new producto();
            System.out.print("Ingrese producto nº " + producto.getCodigo() + ": ");
            producto.setNombre(s.nextLine());

            System.out.print("Ingrese el precio: ");
            producto.setPrecio(s.nextFloat());

            System.out.print("Ingrese la cantidad: ");
            factura.addItemFactura(new itemfactura(s.nextInt(), producto));

            System.out.println();
            s.nextLine(); // Consumir la línea pendiente
        }
        System.out.println(factura);
    }
}

