package uf2;
import java.util.ArrayList;
import java.util.Scanner;

public class TestBicicleta {
	public static void main(String[] args) {
		//como hacer array
		ArrayList<Bicicleta> bicicletas = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		//menu
		int opcion;

		do{
			System.out.println("Menú Principal:");
			System.out.println("1. Crear bicicleta");
			System.out.println("2. Mostrar bicicleta");
			System.out.println("3. Modificar bicicleta");
			System.out.println("4. Modificar datos personales");
			System.out.println("5. Salir");
			System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
           switch(opcion) {
           case 1:
               crearBicicleta(bicicletas, scanner);
               break;
           case 2:
               mostrarBicicleta(bicicletas, scanner);
               break;
           case 3:
               modificarBicicleta(bicicletas, scanner);
               break;
           case 4:
               modificarDatosPersonales(bicicletas, scanner);
               break;
           case 5:
               System.out.println("Saliendo...");
               break;
           default:
               System.out.println("Opción no válida.");
           
		}
     } while (opcion != 5);


}

	private static void modificarDatosPersonales(ArrayList<Bicicleta> bicicletas, Scanner scanner) {
		System.out.print("Introduce el código de la bicicleta a modificar: ");
        String codigo = scanner.nextLine();
        
        for (Bicicleta bici : bicicletas) {
        	//esto es para q da igual como lo ponga si en mayus o minus
            if (bici.getCodigo().equals(codigo)) {
                bici.showBici();
                System.out.println("¿Qué deseas modificar?");
                System.out.println("1. Fecha de fabricación");
                System.out.println("2. Si es eléctrica");
                int opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    case 1:
                        System.out.print("Nueva fecha de fabricación: ");
                        String nuevaFecha = scanner.nextLine();
                        //cuando hagamos modigicaicon hay q poner el set. y como se llame , el get es para llamar a un getter y 
                        //el set para actualizar un dato
                        bici.setFechaFabricacion(nuevaFecha);
                        break;
                    case 2:
                        System.out.print("Es eléctrica (true/false): ");
                        boolean nuevaElectrica = scanner.nextBoolean();
                        bici.setEsElectrica(nuevaElectrica);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
                System.out.println("Datos personales modificados con éxito.");
                return;
            }
        }
        System.out.println("Bicicleta no encontrada.");
    }

	private static void modificarBicicleta(ArrayList<Bicicleta> bicicletas, Scanner scanner) {
	    System.out.print("Introduce el código de la bicicleta a modificar: ");
        String codigo = scanner.nextLine();
        
        for (Bicicleta bici : bicicletas) {
            if (bici.getCodigo().equals(codigo)) {
                bici.showBici();
                System.out.println("¿Qué deseas modificar?");
                System.out.println("1. Fecha de fabricación");
                System.out.println("2. Array de distancias");
                System.out.println("3. Si es eléctrica");
                int opcion = scanner.nextInt();
                scanner.nextLine(); 
                switch (opcion) {
                case 1:
                    System.out.print("Nueva fecha de fabricación: ");
                    String nuevaFecha = scanner.nextLine();
                    bici.setFechaFabricacion(nuevaFecha);
                    break;
                case 2:
                    double[] nuevasDistancias = new double[4];
                    System.out.println("Introduce las nuevas distancias:");
                    for (int i = 0; i < 4; i++) {
                        System.out.print("Distancia " + (i + 1) + ": ");
                        nuevasDistancias[i] = scanner.nextDouble();
                    }
                    bici.setDistancias(nuevasDistancias);
                    break;
                case 3:
                    System.out.print("Es eléctrica (true/false): ");
                    boolean nuevaElectrica = scanner.nextBoolean();
                    bici.setEsElectrica(nuevaElectrica);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println("Bicicleta modificada con éxito.");
            return;
        }
    }
    System.out.println("Bicicleta no encontrada.");
	}

	private static void mostrarBicicleta(ArrayList<Bicicleta> bicicletas, Scanner scanner) {
        System.out.print("Introduce el código de la bicicleta a consultar: ");
        String codigo = scanner.nextLine();
        
        for (Bicicleta bici: bicicletas) {
        	bici.showBici();
        	return;
        }
        System.out.println("Bicicleta no encontrada");
	}

	private static void crearBicicleta(ArrayList<Bicicleta> bicicletas, Scanner scanner) {
		System.out.println("Introduce el codigo de la bici");
		String codigo= scanner.nextLine();
		System.out.print("Fecha de fabricación: ");
        String fecha = scanner.nextLine();       
        System.out.print("Es eléctrica (true/false): ");
        boolean esElectrica = scanner.nextBoolean();
        double[] distancias = new double[4];
        System.out.println("Introduce las distancias entre los 4 parkings:");
        for(int i=0; i <4; i++) {
        	System.out.println("Distancia"+ (i + 1) + ":");
        	distancias[i] = scanner.nextDouble();
        }
        Bicicleta bici = new Bicicleta(codigo, fecha, distancias, esElectrica);
        bicicletas.add(bici);
        System.out.println("Bicicleta creada con éxito.");

	}
}
