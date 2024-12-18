
package sistemadereservas;

import java.util.Vector;
import javax.swing.JOptionPane;

public class Gym {
    // Asignación de objetos donde se guardarán los datos

    private String tipoClase;      // Tipo de clase: Yoga o Baile
    private int espaciosOcupados;
    private final int MAX_ESPACIOS = 30; // estos espacios son para los estudiantes, no afecta en el horario
    
    
    
    Vector<String> bookedList = new Vector<>();
    Vector<Vector<String>> reservationList = new Vector<>();

    // Horarios para el entrenador personal
    private final String[] HORARIOS = {"14:00", "15:00", "16:00", "17:00", "18:00", "19:00"};
    private final boolean[] disponibilidadHorarios = new boolean[HORARIOS.length];

    // Constructor, se comienza con 0 estudiantes
    public Gym(String tipoClase) {
        this.tipoClase = tipoClase;
        this.espaciosOcupados = 0;
        inicializarDisponibilidadHorarios();
    }

    // Inicializa todos los horarios como disponibles
    private void inicializarDisponibilidadHorarios() {
        for (int i = 0; i < disponibilidadHorarios.length; i++) {
            disponibilidadHorarios[i] = true;
        }
    }

    // Clase para agregar un estudiante a la clase, si hay espacio disponible
    public boolean agregarEstudiante(Vector<Vector<String>> register, String text) {
        if (espaciosOcupados < MAX_ESPACIOS) {
            espaciosOcupados++;
            
            Vector<String> reservationSet = new Vector<>();

            String option = text;
            String employeeName = "";

            for (int i = 0; i < register.size(); i++) {
                
                if (!(option.equals("") || option == null)) {
                    if (register.get(i).contains(option) && !(bookedList.contains(register.get(i).get(1)))) {
                        
                        String schedule = reservarConEntrenador();
                        
                        if (schedule == null || schedule.equals("")) {
                            JOptionPane.showMessageDialog(null, "La informacion no es valida");
                            return false;
                        }
                        
                    employeeName = register.get(i).get(0);
                    String employeeId = register.get(i).get(1);
                    reservationSet.add(employeeName);
                    reservationSet.add(employeeId);
                    reservationSet.add(schedule);
                    bookedList.add(employeeId);
                    
                    reservationList.add(reservationSet);

                    JOptionPane.showMessageDialog(null, "Estudiante agregado a la clase: " + employeeName+" a las "+schedule);
                    return true;
                    }
                }
            }

        }
        JOptionPane.showMessageDialog(null, "Verifique la informacion o revise si el empleado ya cuenta con una reservacion");
        return false;
    }

    // Clase para mostrar información de la clase
    public void mostrarClase() {
    }

    // Clase para cancelar la inscripción de un estudiante
    public boolean eliminarEstudiante(String text) {
        if (espaciosOcupados > 0) {
            espaciosOcupados--;
            
            String option = text;
            
            for (Vector<String> set : reservationList) {
                if (set.get(1).equals(option)) {
                    
                    JOptionPane.showMessageDialog(null, "Reservacion removida satisfactoriamente\n\n"+"Nombre: "+set.get(0)+"\nMomento de reserva: "+set.get(2));
                    reservationList.remove(set);
                    return true;

                }
            }
            
            
        } else {
            JOptionPane.showMessageDialog(null, "No hay estudiantes para eliminar en la clase: " + tipoClase);
        }
        return false;
    }

    // Clase para reservar un horario con el entrenador personal
    public String reservarConEntrenador() {
        // Mostrar horarios disponibles
        StringBuilder horariosDisponibles = new StringBuilder("Horarios disponibles:\n");
        for (int i = 0; i < HORARIOS.length; i++) {
            if (disponibilidadHorarios[i]) {
                horariosDisponibles.append(HORARIOS[i]).append("\n");
            }
        }

        // Clase para solicitar al usuario el horario que desea reservar
        String horario = JOptionPane.showInputDialog(horariosDisponibles.toString() + "\nIngrese el horario que desea reservar (e.g., 15:00):");
        boolean reservado = false;

        // Clase para buscar el horario y verificar si está disponible
        for (int i = 0; i < HORARIOS.length; i++) {
            if (HORARIOS[i].equals(horario)) {
                if (disponibilidadHorarios[i]) {
                    disponibilidadHorarios[i] = false;
                    JOptionPane.showMessageDialog(null, "Reserva exitosa con el entrenador a las " + horario);
                    reservado = true;
                } else {
                    JOptionPane.showMessageDialog(null, "El horario " + horario + " ya está reservado. Intente con otro horario.");
                }
                break;
            }
        }

        // Validación en caso de horario inválido o no encontrado
        if (!reservado) {
            JOptionPane.showMessageDialog(null, "El horario no está disponible o es inválido. Intente de nuevo.");
        }
        return horario;
    }

    // Getter para obtener el tipo de clase
    public String getTipoClase() {
        return tipoClase;
    }

    // Getter para obtener la cantidad de espacios ocupados
    public int getEspaciosOcupados() {
        return espaciosOcupados;
    }
}
