import java.util.Scanner;

public class HeladeriaDistribuidora {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("**Heladería y Distribuidora**");

        Usuario usuario = iniciarSesion();

        if (usuario != null) {
            int opcion;
            while ((opcion = leerOpcionMenu()) != 3) {
                switch (opcion) {
                    case 1:
                        gestionProductos(usuario);
                        break;
                    case 2:
                        gestionVentas(usuario);
                        break;
                }
            }
            System.out.println("**Saliendo del sistema**");
        } else {
            System.out.println("**Acceso denegado**");
        }
    }

    private static Usuario iniciarSesion() {
        System.out.println("\n**Inicio de sesión**");
        String nombreUsuario = leerString("Usuario: ");
        String contrasena = leerString("Contraseña: ");

        if (usuarioValido(nombreUsuario, contrasena)) {
            return new Usuario(nombreUsuario);
        }
        return null;
    }

    private static void gestionProductos(Usuario usuario) {
        System.out.println("\n**Gestión de productos**");
        int opcionProducto;
        while ((opcionProducto = leerOpcionMenuProducto()) != 5) {
            switch (opcionProducto) {
                case 1:
                    agregarProducto(usuario);
                    break;
                case 2:
                    modificarProducto(usuario);
                    break;
                case 3:
                    eliminarProducto(usuario);
                    break;
                case 4:
                    listarProductos();
                    break;
            }
        }
    }

    private static void gestionVentas(Usuario usuario) {
        System.out.println("\n**Gestión de ventas**");
        int opcionVenta;
        while ((opcionVenta = leerOpcionMenuVenta()) != 3) {
            switch (opcionVenta) {
                case 1:
                    registrarVenta(usuario);
                    break;
                case 2:
                    listarVentas();
                    break;
            }
        }
    }

    private static int leerOpcionMenu() {
        System.out.println("\n**Menú principal**");
        System.out.println("1. Gestión de productos");
        System.out.println("2. Gestión de ventas");
        System.out.println("3. Salir");
        System.out.print("Introduzca una opción: ");

        int opcion;
        try {
            opcion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            opcion = 0;
        }
        return opcion;
    }

    private static int leerOpcionMenuProducto() {
        System.out.println("\n**Opciones de productos:**");
        System.out.println("1. Agregar producto");
        System.out.println("2. Modificar producto");
        System.out.println("3. Eliminar producto");
        System.out.println("4. Listar productos");
        System.out.println("5. Salir");
        System.out.print("Introduzca una opción: ");

        int opcion;
        try {
            opcion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            opcion = 0;
        }
        return opcion;
    }

    private static int leerOpcionMenuVenta() {
        System.out.println("\n**Opciones de ventas:**");
        System.out.println("1. Registrar venta");
        System.out.println("2. Listar ventas");
        System.out.println("3. Salir");
        System.out.print("Introduzca una opción: ");

        int opcion;
        try {
            opcion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            opcion = 0;
        }
        return opcion;
    }

    private static String leerString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private static boolean usuarioValido(String nombreUsuario, String contrasena) {
        
        return true;
    }

    private static void agregarProducto(Usuario usuario) {
        String nombre = leerString("Nombre del producto: ");
        String descripcion = leerString("Descripción del producto: ");
        double precio = leerDouble("Precio del producto: ");
        int stock = leerInt("Stock del producto: ");
        
