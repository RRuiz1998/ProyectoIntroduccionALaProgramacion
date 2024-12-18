package sistemadereservas;

import java.util.Arrays;
import java.util.Vector;
import javax.swing.JOptionPane;

class EmployeeInformation {
    //Registro precargado de informacion de empleados

    Vector<Vector<String>> register = new Vector<>(Arrays.asList(
            new Vector<>(Arrays.asList("Richard Ruiz", "000001")),
            new Vector<>(Arrays.asList("Santiago Zamora", "000002")),
            new Vector<>(Arrays.asList("Edgar Monge", "000003")),
            new Vector<>(Arrays.asList("Josafat Garcia", "000004"))
    ));
    

    //Agrega Empleados del sistema
    public void addEmployee(String text) {
        Vector<String> newEmployeeSet = new Vector<>();

        String name = text;
        
        String id = addingId();
        if (!(text.equals(""))) {
            newEmployeeSet.add(name);
            newEmployeeSet.add(id);
            JOptionPane.showMessageDialog(null, """
                                                Empleado agregado satisfactoriamente.
                                                
                                                Nombre de Empleado: """ + " " + name + "\nID: " + id);
            register.add(newEmployeeSet);  //set de informacion del empleado nuevo registrada en el sistema;
        }  
    }

    //Modifica la informacion del empleado
    public void modifyEmployeeName(String text) {
        
        for (int i = 0; i < register.size(); i++) {
            String employeeId = register.get(i).get(1);
            if (employeeId.equals(text)) {
                String inputName = JOptionPane.showInputDialog("Ingrese el nombre correcto: ");
                if (inputName == null) {
                JOptionPane.showMessageDialog(null, "Revisa la informacion introducida");
                    break;
                }
                register.get(i).set(0, text);
                JOptionPane.showMessageDialog(null, """
                                                        Se realizo la modificacion satisfactoriamente.
                                                        
                                                        Nombre actualizado: """ + " " + inputName + "\nID: " + text);
                break;
            }
        }
    }

    //Remueve Empleados del Sistema
    public void removeEmployee(String text) {
        String id = text;
        for (int i = 0; i < register.size(); i++) {
            String element = register.get(i).get(1);
            if (element.equalsIgnoreCase(id)) {
                JOptionPane.showMessageDialog(null, """
                                                    Usuario removido de la Base de Datos.
                                                    
                                                    Nombre de Empleado: """ + " " + register.get(i).get(0) + "\nID: " + register.get(i).get(1));
                register.remove(register.get(i));
                break;
            }
        }
        JOptionPane.showMessageDialog(null, "El no ID introducido no se encuentra en el Sistema");
    }


    //Generate unique ID 
    public String addingId() {
        int randomNumber = (int) (Math.random() * 999999) + 1;
        return String.valueOf(randomNumber);
    }
}
