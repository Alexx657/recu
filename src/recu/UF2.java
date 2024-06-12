package recu;
import java.util.ArrayList;
import java.util.Scanner;

class Professor {
    private String nombre;
    private String apellido;

    public Professor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}

class Materia {
    private String nombre;
    private double notaMedia;

    public Materia(String nombre, double notaMedia) {
        this.nombre = nombre;
        this.notaMedia = notaMedia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }
}

class Alumno {
    private String nombre;
    private String apellido;
    private ArrayList<Materia> materias;

    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.materias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }

    public void addMateria(Materia materia) {
        this.materias.add(materia);
    }

    public double getNotaMediaTotal() {
        double total = 0;
        for (Materia materia : materias) {
            total += materia.getNotaMedia();
        }
        return total / materias.size();
    }
}

public class UF2 {
    private static ArrayList<Alumno> alumnos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce nombre del profesor:");
        String nombreProfesor = scanner.nextLine();

        System.out.println("Introduce apellido del profesor:");
        String apellidoProfesor = scanner.nextLine();

        Professor profesor = new Professor(nombreProfesor, apellidoProfesor);

        System.out.println("Bienvenido/a " + profesor.getNombre() + " " + profesor.getApellido());

        while (true) {
            System.out.println("Menú");
            System.out.println("1. Introducir datos alumno");
            System.out.println("2. Mostrar la nota media total de un alumno");
            System.out.println("3. Mostrar alumnos suspendidos");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    introducirAlumno(scanner);
                    break;
                case 2:
                    mostrarNotaMedia(scanner);
                    break;
                case 3:
                    mostrarAlumnosSuspendidos();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        }
    }

    private static void introducirAlumno(Scanner scanner) {
        System.out.println("Introduzca el nombre del alumno:");
        String nombreAlumno = scanner.nextLine();

        System.out.println("Introduzca el apellido del alumno:");
        String apellidoAlumno = scanner.nextLine();

        Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno);

        for (int i = 0; i < 5; i++) {
            System.out.println("Introduzca el nombre de la materia " + (i + 1) + ":");
            String nombreMateria = scanner.nextLine();

            System.out.println("Introduzca la nota media de la materia " + (i + 1) + ":");
            double notaMedia = scanner.nextDouble();
            scanner.nextLine(); // Consumir nueva línea

            Materia materia = new Materia(nombreMateria, notaMedia);
            alumno.addMateria(materia);
        }

        alumnos.add(alumno);
        System.out.println("Alumno añadido exitosamente.");
    }

    private static void mostrarNotaMedia(Scanner scanner) {
        System.out.println("Introduzca el nombre del alumno:");
        String nombreAlumno = scanner.nextLine();

        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombreAlumno)) {
                System.out.println("La nota media de " + nombreAlumno + " es: " + alumno.getNotaMediaTotal());
                return;
            }
        }
        System.out.println("Alumno no encontrado.");
    }

    private static void mostrarAlumnosSuspendidos() {
        for (Alumno alumno : alumnos) {
            if (alumno.getNotaMediaTotal() < 5) {
                System.out.println(alumno.getNombre() + " " + alumno.getApellido() + " está suspendido/a.");
            }
        }
    }
}
