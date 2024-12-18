package sistemadereservas;

import java.util.Vector;
import javax.swing.JOptionPane;

public class Baile {

    private final int maxCupos = 30; // Máximo de cupos por horario.
    private int reservas7pm = 0;
    private int reservas8pm = 0;
    private final String[] reservas = new String[maxCupos * 2]; // Reservas almacenadas.

    Vector<Vector<String>> list7pm = new Vector<>();
    Vector<Vector<String>> list8pm = new Vector<>();

    // Registra una nueva reserva
    public void registrarReserva(Vector<Vector<String>> register, String text) {
        Vector<String> listSet7pm = new Vector<>();
        Vector<String> listSet8pm = new Vector<>();

        String id = text;
        if (id == null || !id.matches("\\d{6}")) {
            JOptionPane.showMessageDialog(null, "ID inválido. Por favor, intente nuevamente.");
            return;
        }

        // Verifica si el ID existe en los registros
        Vector<String> usuario = null;
        for (Vector<String> registro : register) {
            if (registro.get(1).equals(id)) {
                usuario = registro;
                break;
            }

        }

        for (Vector<String> list7 : list7pm) {
            if (list7.get(1).equals(id)) {
                JOptionPane.showMessageDialog(null, "ID ya cuenta con una reservacion\n\n" + "Nombre: " + list7.get(0) + "\nHora reservada: " + list7.get(2));
                return;
            }
        }
        for (Vector<String> list8 : list8pm) {
            if (list8.get(1).equals(id)) {
                JOptionPane.showMessageDialog(null, "ID ya cuenta con una reservacion\n\n" + "Nombre: " + list8.get(0) + "\nHora reservada: " + list8.get(2));
                return;
            }
        }
        if (usuario == null) {
            JOptionPane.showMessageDialog(null, "ID no encontrado. Por favor, intente nuevamente.");
            return;
        }

        String horario = JOptionPane.showInputDialog("""
            Horarios disponibles:
            1. Clase a las 7pm
            2. Clase a las 8pm
            
            Seleccione el horario deseado:""");

        if (horario == null || !horario.matches("[1-2]")) {
            JOptionPane.showMessageDialog(null, "Seleccione un horario válido.");
            return;
        }

        String mensaje;
        if (horario.equals("1") && reservas7pm < maxCupos) {
            reservas[getIndiceReserva()] = usuario.get(0) + " (" + usuario.get(1) + ") - 7pm";
            reservas7pm++;
            mensaje = "Reserva registrada exitosamente para " + usuario.get(0) + " en la clase de las 7pm.";
            listSet7pm.add(usuario.get(0));
            listSet7pm.add(usuario.get(1));
            listSet7pm.add("7pm");
            list7pm.add(listSet7pm);

        }

        if (horario.equals("2") && reservas8pm < maxCupos) {
            reservas[getIndiceReserva()] = usuario.get(0) + " (" + usuario.get(1) + ") - 8pm";
            reservas8pm++;
            mensaje = "Reserva registrada exitosamente para " + usuario.get(0) + " en la clase de las 8pm.";
            listSet8pm.add(usuario.get(0));
            listSet8pm.add(usuario.get(1));
            listSet8pm.add("8pm");
            list8pm.add(listSet8pm);

        } else {
            mensaje = "No hay cupos disponibles en el horario seleccionado.";
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }

    // Cancela una reserva
    public void cancelarReserva(String text) {
        String idReservaStr = text;

        if (idReservaStr == null || !idReservaStr.matches("\\d{6}")) {
            JOptionPane.showMessageDialog(null, "ID inválido.");
            return;
        }

        for (Vector<String> list7 : list7pm) {
            if (list7.get(1).equals(text)) {
                reservas7pm--;
                JOptionPane.showMessageDialog(null, "Reserva " + list7.get(0) + " cancelada exitosamente.");
                list7pm.remove(list7);
            }
        }

        for (Vector<String> list8 : list8pm) {
            if (list8.get(1).equals(text)) {
                reservas8pm--;
                JOptionPane.showMessageDialog(null, "Reserva " + list8.get(0) + " cancelada exitosamente.");
                list8pm.remove(list8);
            }
        }
    }

    //Visualizacion
    public void mostrarReservas() {
        StringBuilder listado = new StringBuilder("Reservas actuales:\n");
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] != null) {
                listado.append("ID ").append(i + 1).append(": ").append(reservas[i]).append("\n");
            }
        }
        listado.append("\nTotal de reservas:\n").append(reservas7pm).append(" en 7pm\n").append(reservas8pm).append(" en 8pm.");
//        JOptionPane.showMessageDialog(null, listado.toString());

    }

    public Vector<Vector<Vector<String>>> listas() {
        Vector<Vector<Vector<String>>> list = new Vector<>();

        list.add(list7pm);
        list.add(list8pm);

        return list;
    }

    private int getIndiceReserva() {
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
