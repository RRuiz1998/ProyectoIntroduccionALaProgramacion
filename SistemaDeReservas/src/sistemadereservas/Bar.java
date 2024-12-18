package sistemadereservas;

import java.util.Vector;
import javax.swing.JOptionPane;

public class Bar {

    Vector<Vector<String>> list = new Vector<>();
    Vector<String> bookedList = new Vector<>();

    public Vector<String> reservation(Vector<Vector<String>> register, String text) {
        Vector<String> reservationSet = new Vector<>();

        String option = text;

        for (int i = 0; i < register.size(); i++) {

            if (register.get(i).contains(option) && !(bookedList.contains(register.get(i).get(1)))) {
                String employeeName = register.get(i).get(0);
                String employeeId = register.get(i).get(1);
                reservationSet.add(employeeName);
                reservationSet.add(employeeId);

                return reservationSet;
            }
        }
        return null;
    }

    public void reservationSet(String name, String ID, String drink, String time) {
        Vector<String> reservationSet = new Vector<>();

        reservationSet.add(name);
        reservationSet.add(ID);
        reservationSet.add(drink);
        reservationSet.add(time);

        bookedList.add(ID);
        list.add(reservationSet);

    }

    //Modifica las reservaciones existentes de bebidas
    public Vector<String> modification(String text) {

        String id = text;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(1).equals(id)) {
                Vector<String> reservationSet = list.get(i);
                return reservationSet;
            }
        }
        return null;
    }

    public void reservationT(String reservationID, String option) {

        Vector<String> reservationSet = null;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(1).equals(reservationID)) {
                list.get(i).set(3, option);
                reservationSet = list.get(i);
            }
        }
        JOptionPane.showMessageDialog(null, "Modificacion realizada satisfactoriamente \nEmpleado: " + reservationSet.get(0) + "\nID: " + reservationSet.get(1) + "\nBebida: " + reservationSet.get(2) + "\nMomento de entrega: " + reservationSet.get(3));
    }

    public void reservationD(String reservationID, String option) {

        Vector<String> reservationSet = null;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(1).equals(reservationID)) {
                list.get(i).set(2, option);
                reservationSet = list.get(i);
            }
        }
        JOptionPane.showMessageDialog(null, "Modificacion realizada satisfactoriamente \nEmpleado: " + reservationSet.get(0) + "\nID: " + reservationSet.get(1) + "\nBebida: " + reservationSet.get(2) + "\nMomento de entrega: " + reservationSet.get(3));
    }

    //Remover pedidos
    public void delete(String text) {

        String id = text;

        if (bookedList.contains(id)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).get(1).equals(id)) {
                    Vector<String> set = list.get(i);
                    JOptionPane.showMessageDialog(null, "La reserva removida con exito: \n\nNombre: " + set.get(0) + "\nID: " + set.get(1) + "\nBebida: " + set.get(2) + "\nMomento de Entrega: " + set.get(3));
                    list.remove(i);
                    bookedList.remove(i);
                    break;
                }
            }
        } else if (!(bookedList.contains(id))) {
            JOptionPane.showMessageDialog(null, "Este ID no tiene reservaciones cargadas en el sistema");
        }
    }

}
