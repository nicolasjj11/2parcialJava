import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vehiculo {
    private final String placa;
    private final String tipo;
    private final String propietario;

    public Vehiculo(String placa, String tipo, String propietario) {
        this.placa = placa;
        this.tipo = tipo.toLowerCase();
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Vehiculo [placa=" + placa + ", tipo=" + tipo + ", propietario=" + propietario + "]";
    }
}

class EspacioParqueadero {
    private final int numeroEspacio;
    private final String tipoPermitido; 
    private boolean ocupado;

    public EspacioParqueadero(int numeroEspacio, String tipoPermitido) {
        this.numeroEspacio = numeroEspacio;
        this.tipoPermitido = tipoPermitido.toLowerCase();
        this.ocupado = false;
    }

    public boolean estaDisponible() {
        return !ocupado;
    }

    public String getTipoPermitido() {
        return tipoPermitido;
    }

    public int getNumeroEspacio() {
        return numeroEspacio;
    }

    public void asignarVehiculo(Vehiculo vehiculo) {
        if (ocupado) {
            System.out.println("Espacio " + numeroEspacio + " ya está ocupado.");
        } else if (!vehiculo.getTipo().equals(tipoPermitido)) {
            System.out.println("El tipo de vehículo no coincide con el espacio permitido.");
        } else {
            ocupado = true;
            System.out.println("Vehículo " + vehiculo.getPlaca() + " asignado al espacio " + numeroEspacio);
        }
    }

    public void liberarEspacio() {
        if (!ocupado) {
            System.out.println("El espacio " + numeroEspacio + " ya está disponible.");
        } else {
            ocupado = false;
            System.out.println("Espacio " + numeroEspacio + " ahora está disponible.");
        }
    }

    @Override
    public String toString() {
        return "EspacioParqueadero [numero=" + numeroEspacio + ", tipoPermitido=" + tipoPermitido + 
               ", ocupado=" + ocupado + "]";
    }
}

class GestionParqueadero {
    private final List<Vehiculo> vehiculos;
    private final List<EspacioParqueadero> espacios;

    public GestionParqueadero() {
        this.vehiculos = new ArrayList<>();
        this.espacios = new ArrayList<>();
    }

    public void registrarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        System.out.println("Vehículo registrado: " + vehiculo);
    }

    public void mostrarEspaciosDisponibles() {
        System.out.println("Espacios disponibles:");
        for (EspacioParqueadero espacio : espacios) {
            if (espacio.estaDisponible()) {
                System.out.println(espacio);
            }
        }
    }

    public void asignarEspacio(String placa) {
        Vehiculo vehiculo = buscarVehiculo(placa);
        if (vehiculo == null) {
            System.out.println("Vehículo con placa " + placa + " no encontrado.");
            return;
        }

        for (EspacioParqueadero espacio : espacios) {
            if (espacio.estaDisponible() && espacio.getTipoPermitido().equals(vehiculo.getTipo())) {
                espacio.asignarVehiculo(vehiculo);
                return;
            }
        }
        System.out.println("No hay espacios disponibles para el tipo de vehículo: " + vehiculo.getTipo());
    }

    public void agregarEspacio(EspacioParqueadero espacio) {
        espacios.add(espacio);
        System.out.println("Espacio agregado: " + espacio);
    }

    private Vehiculo buscarVehiculo(String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                return vehiculo;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        GestionParqueadero gestion = new GestionParqueadero();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Sistema de Parqueadero ");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Agregar espacio de parqueadero");
            System.out.println("3. Mostrar espacios disponibles");
            System.out.println("4. Asignar espacio a vehículo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la placa del vehículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Ingrese el tipo de vehículo (carro/moto): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Ingrese el propietario del vehículo: ");
                    String propietario = scanner.nextLine();
                    gestion.registrarVehiculo(new Vehiculo(placa, tipo, propietario));
                    break;
                case 2:
                    System.out.print("Ingrese el número del espacio: ");
                    int numeroEspacio = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el tipo permitido (carro/moto): ");
                    String tipoPermitido = scanner.nextLine();
                    gestion.agregarEspacio(new EspacioParqueadero(numeroEspacio, tipoPermitido));
                    break;
                case 3:
                    gestion.mostrarEspaciosDisponibles();
                    break;
                case 4:
                    System.out.print("Ingrese la placa del vehículo: ");
                    String placaVehiculo = scanner.nextLine();
                    gestion.asignarEspacio(placaVehiculo);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}


    




