
package sistemadereservas;

import java.util.Vector;
import javax.swing.JOptionPane;

public class Theater {
    String spots;
    String schecudleOne;
    String scheduleTwo;
    String movieOne;
    String movieTwo;
    Vector<String> availableSpots;
    Vector<String> busySpots;
    Vector<Vector<String>> reservedList;
    Vector<String> registeredIds;


    //Construtor
    public Theater(String spots, String schecudleOne, String scheduleTwo, String movieOne, String movieTwo, Vector<String> availableSpots, Vector<String> busySpots, Vector<Vector<String>> reservedList, Vector<String> registedIds) {
        this.spots = spots;
        this.schecudleOne = schecudleOne;
        this.scheduleTwo = scheduleTwo;
        this.movieOne = movieOne;
        this.movieTwo = movieTwo;
        this.availableSpots = availableSpots;
        this.busySpots = busySpots;
        this.reservedList = reservedList;
        this.registeredIds = registedIds;
    }

            //Selecciona la sala
    public String gestion(Vector<Vector<String>> register) {
        
        String selection = "";
        
        String option = JOptionPane.showInputDialog("""
                                            Indica a cual sala deseas ingresar: 
                                            
                                            1. Sala IMAX
                                            2. Sala VIP
                                            
                                            """);
        
        if (option == null) {
            selection = "";
            return "";
        }

        if (option.equals("1")) {
            selection = "IMAX";
            return selection;
        }
        
        if (option.equals("2")) {
            selection = "VIP";
            return selection;
        }
        return "";
    }
    
    
        
    
    
    //Se crea solicitud para reserva de un spot en la sala de cine
    public String reservation(Vector <Vector<String>> register, String textOne, String textTwo) {
        Vector <String> confirmedList = new Vector<>();
        String view = this.view();
        
        String employeeId = textOne;
        for (int i = 0; i < register.size(); i++) {
            
            if (register.get(i).contains(employeeId)) {
                String selectedSpot = textTwo;
                selectedSpot = selectedSpot.toUpperCase();
                if (availableSpots.contains(selectedSpot)) {
                    if (!registeredIds.contains(employeeId)) {
                        busySpots.add(selectedSpot);
                        availableSpots.remove(selectedSpot);
                        confirmedList.add(register.get(i).get(0));
                        confirmedList.add(register.get(i).get(1));
                        confirmedList.add(selectedSpot);
                        reservedList.add(confirmedList);
                        registeredIds.add(employeeId);
                        JOptionPane.showMessageDialog(null, "Reservacion realizada satisfactoriamente\n\nEmpleado: "+confirmedList.get(0)+"\nID: "+confirmedList.get(1)+"\nSpot Reservado: "+confirmedList.get(2));
                        break;
                    } 
                }
            }  
        }
        return view;
    }  

    
    
    //Settings view
    public void settingsView () {
        JOptionPane.showMessageDialog(null, "Titulo: "+this.movieOne+" (Sera transmitida en el horario "+this.schecudleOne+")\n"
                + "Titulo: "+this.movieTwo+" (Sera transmitida en el horario "+this.scheduleTwo+")\n"
                        + "Inicio de primer tanda: "+this.schecudleOne+"\n"
                                + "Inicio de segunda tanda: "+this.scheduleTwo+"\n"
                                        + "Cantidad de spots disponible en sala "+this.spots);

    }

        
    //Visualizacion de los spots de la sala (FASE 2)
    public String view() { 
        String view = "\n";
        
        int columns = Integer.parseInt(this.spots)/5;
        String [][] arragement = new String [5][columns];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < columns; j++) {
                switch (i) {
                    case 0 -> arragement[i][j] = "A"+j;
                    case 1 -> arragement[i][j] = "B"+j;
                    case 2 -> arragement[i][j] = "C"+j;
                    case 3 -> arragement[i][j] = "D"+j;
                    case 4 -> arragement[i][j] = "E"+j;
                }
                String element = arragement[i][j];
                String spot = checker(element);
                view += spot+" ";
                
            }
            view += "\n\n";
        }           
        return view;
    }
    
    //Valida si el spot esta disponible o ocupado
    public String checker (String element) {
        String spotchecker = "";
        if (!(this.busySpots.contains(element))) {
            if (!(this.availableSpots.contains(element))) {
                this.availableSpots.add(element);
            }
        } 
        if (this.availableSpots.contains(element)) {
            spotchecker = "<font color='green'>"+element+"</font>";
        }
        if (this.busySpots.contains(element)) {
            spotchecker = "<font color='red'>"+element+"</font>";
        }
        return spotchecker;
    }
}
