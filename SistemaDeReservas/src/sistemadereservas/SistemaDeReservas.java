package sistemadereservas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.border.EmptyBorder;

public class SistemaDeReservas {

    public static void main(String[] args) {

        //Inicializador de Preloaded Data
        EmployeeInformation data = new EmployeeInformation();
        Vector<Vector<String>> register = data.register;
        

        //Inicializacion de las Salas de Cine (IMAX y VIP)
        Vector<String> availableImax = new Vector<>();
        Vector<String> busyImax = new Vector<>();
        Vector<Vector<String>> reservedImax = new Vector<>();
        Vector<String> registeredIdsImax = new Vector<>();

        Vector<String> availableVip = new Vector<>();
        Vector<String> busyVip = new Vector<>();
        Vector<Vector<String>> reservedVip = new Vector<>();
        Vector<String> registeredIdsVip = new Vector<>();

        //Inicializador de las salas de Cine
        Theater imax = new Theater("30", "10am", "2pm", "Mufasa: El rey leon", "Demon Slayer: Kimetsu no Yaiba - Arco del Castillo infinito.", availableImax, busyImax, reservedImax, registeredIdsImax);
        Theater vip = new Theater("30", "10am", "2pm", "Sonic 3, La pelicula", "La Guerra de los Rohirrim", availableVip, busyVip, reservedVip, registeredIdsVip);

        //Inicializacion de la Salas de gimnasio
        Gym gimnasio = new Gym("gimnasio");

        //Inicializacion de la Salas de yoga, baile
        Yoga yoga = new Yoga();
        Baile baile = new Baile();

        //Inicializacion de Bar
        Bar bar = new Bar();

        JFrame frame = new JFrame("Sistema de Reservaciones");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel panelNorte = new JPanel();
        panelNorte.setPreferredSize(new Dimension(150, 150));
        panelNorte.setBackground(new Color(255, 0, 0));
        panelNorte.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        panelNorte.setLayout(new FlowLayout());
        
        JLabel icon = new JLabel();
        
        
        
        
        

        JPanel panelOeste = new JPanel();
        panelOeste.setPreferredSize(new Dimension(170, 200));
        panelOeste.setBackground(new Color(28, 160, 85));
        panelOeste.setLayout(new FlowLayout());
        panelOeste.setBorder(BorderFactory.createLineBorder(Color.white, 2));

        JPanel panelDivision = new JPanel();
        panelDivision.setLayout(new FlowLayout());
        panelDivision.setBackground(new Color(0, 0, 0, 0));
        panelDivision.setPreferredSize(new Dimension(160, 160));

        JPanel panelTexto = new JPanel();
        panelTexto.setLayout(new FlowLayout());
        panelTexto.setBackground(new Color(0, 0, 0, 0));
        panelTexto.setPreferredSize(new Dimension(160, 55));

        String text = "Seleccione la opcion \n  que desea realizar";
        JLabel seleccionText = new JLabel("<html>" + text.replace("\n  ", "<br>") + "</html>");
        seleccionText.setForeground(new Color(255, 215, 0));

        panelTexto.add(seleccionText);

        JPanel panelBotones = new JPanel();
        panelBotones.setPreferredSize(new Dimension(160, 95));
        panelBotones.setLayout(new FlowLayout());
        panelBotones.setBackground(new Color(0, 0, 0, 0));

        JButton bInfo = new JButton("Informacion");
        JButton bAct = new JButton("Actividades");

        JButton[] buttonsTop = {bInfo, bAct};
        setButtons(buttonsTop);

        panelBotones.add(bInfo);
        panelBotones.add(bAct);

        panelDivision.add(panelTexto);
        panelDivision.add(panelBotones);

        panelOeste.add(panelDivision);

        JPanel panelOpciones = new JPanel();
        panelOpciones.setLayout(new FlowLayout());
        panelOpciones.setBackground(new Color(0, 0, 0, 0));
        panelOpciones.setPreferredSize(new Dimension(160, 250));

        JPanel seccionTexto = new JPanel();
        seccionTexto.setLayout(new FlowLayout());
        seccionTexto.setBackground(new Color(0, 0, 0, 0));

        panelBotones.setBackground(new Color(0, 0, 0, 0));

        JPanel panelCentral = new JPanel();
        panelCentral.setPreferredSize(new Dimension(600, 600));
        panelCentral.setBackground(new Color(255, 255, 255));
        panelCentral.setLayout(new BorderLayout());
        panelCentral.setBorder(BorderFactory.createLineBorder(Color.white, 2));

        JPanel panelCC = new JPanel();
        panelCC.setBackground(new Color(0, 0, 0, 0));
        panelCC.setLayout(new FlowLayout());
        

        bAct.addActionListener((ActionEvent e) -> {

            panelCentral.removeAll();
            panelOpciones.removeAll();
            seccionTexto.removeAll();

            JPanel seccionButones = new JPanel();
            seccionButones.setLayout(new FlowLayout());
            seccionButones.setBackground(new Color(0, 0, 0, 0));
            seccionButones.setPreferredSize(new Dimension(150, 150));

            JButton bCine = new JButton("Cine");
            JButton bGimnasio = new JButton("Gym");
            JButton bYoga = new JButton("Yoga");
            JButton bBaile = new JButton("Baile");
            JButton bBar = new JButton("Bar");

            JButton[] buttons = {bCine, bGimnasio, bYoga, bBaile, bBar};
            setButtons(buttons);

            String seleccionAct = """
                                  Indica la actividad a 
                                  la que deseas ingresar""";

            JLabel actividadOpcion = new JLabel("<html>" + seleccionAct.replace("\n", "<br>") + "<html>");
            actividadOpcion.setForeground(new Color(255, 215, 0));

            seccionButones.add(bCine);
            seccionButones.add(bGimnasio);
            seccionButones.add(bYoga);
            seccionButones.add(bBaile);
            seccionButones.add(bBar);

            seccionTexto.add(actividadOpcion);

            panelOpciones.add(seccionTexto);
            panelOpciones.add(seccionButones);

            panelOeste.add(panelOpciones);

            JPanel panelCS = new JPanel();
            panelCS.setBackground(new Color(0, 0, 0, 0));
            panelCS.setPreferredSize(new Dimension(100, 100));
            panelCS.setLayout(new BorderLayout());

            JPanel panelCSS = new JPanel();
            panelCSS.setLayout(new FlowLayout());
            panelCSS.setBackground(new Color(0, 102, 255));
            panelCSS.setBorder(BorderFactory.createLineBorder(Color.black, 2));

            JPanel panelCSI = new JPanel();
            panelCSI.setLayout(new FlowLayout());
            panelCSI.setBackground(new Color(0, 0, 0, 0));
            panelCSI.setPreferredSize(new Dimension(35, 30));

            JPanel firstPanel = new JPanel();
            firstPanel.setBackground(new Color(0, 0, 0, 0));
            firstPanel.setLayout(new FlowLayout());

            JPanel secondPanel = new JPanel();
            secondPanel.setBackground(new Color(0, 0, 0, 0));
            secondPanel.setLayout(new FlowLayout());

            JPanel thirdPanel = new JPanel();
            thirdPanel.setLayout(new FlowLayout());
            thirdPanel.setBackground(new Color(0, 0, 0, 0));
            thirdPanel.setPreferredSize(new Dimension(800, 150));
            
            
            bBar.addActionListener((var eBar) -> {

                cleaningWindow(panelCentral, panelCS, panelCSS, panelCSI, firstPanel, secondPanel, thirdPanel);

                String tituloEmpleadosInfo = """
                                            Has accedido a la opcion de Bar!
                                            En esta seccion podras realizar diferentes funciones como por ejemplo crear reservaciones de bebidas para los empleados 
                                            o realizar modificaciones a las reservas que estan cargadas en el sistema. 
                                                        """;

                JLabel titulo = new JLabel("<html>" + tituloEmpleadosInfo.replace("\n", "<br>") + "<html>");
                titulo.setForeground(new Color(255, 215, 0));

                panelCSS.add(titulo);

                JButton buttonA = new JButton("Asignar Bebida");
                JButton buttonM = new JButton("Modificar Datos");
                JButton buttonC = new JButton("Cancelar Reserva");
                JButton buttonV = new JButton("Visualizar Pedidos");

                JButton[] buttonsBar = {buttonA, buttonM, buttonC, buttonV};

                setButtons(buttonsBar);

                panelCSI.add(buttonA);
                panelCSI.add(buttonM);
                panelCSI.add(buttonC);
                panelCSI.add(buttonV);

                panelCS.add(panelCSS, BorderLayout.CENTER);
                panelCS.add(panelCSI, BorderLayout.SOUTH);

                panelCentral.add(panelCS, BorderLayout.NORTH);

                buttonA.addActionListener((ActionEvent e2) -> {

                    panelCC.removeAll();
                    firstPanel.removeAll();

                    panelsSize(firstPanel, secondPanel, thirdPanel);

                    String inputLabel = """
                                        Has accedido a la seccion de reservaciones!
                                        Es esta seccion podras realizar reservaciones de bebidas a los empleados utilizando su ID de empleado. 
                                        Recuerda que es importante configurar una hora de entrega de su pedido

                                        Por favor ingresa el ID del empleado: 
                                        
                                        """;

                    JLabel input = new JLabel("<html>" + inputLabel.replace("\n", "<br>") + "<html>");

                    JTextField textField = new JTextField(25);
                    JButton confirmationButton = new JButton("Confirmar");
                    JButton[] bConfirmation = {confirmationButton};
                    setButtons(bConfirmation);

                    firstPanel.add(input);
                    firstPanel.add(textField);
                    firstPanel.add(confirmationButton);

                    panelCC.add(firstPanel);

                    confirmationButton.addActionListener((ActionEvent e1) -> {
                        String texto = textField.getText();
                        Vector<String> reservationSet = bar.reservation(register, texto);
                        textField.setText("");

                        if (!(reservationSet == null)) {

                            secondPanel.removeAll();
                            thirdPanel.removeAll();

                            String messageOne = """
                                        
                                        Indica la opcion que deseas seleccionar:
                                       
                                        """;

                            JLabel inputText = new JLabel("<html>" + messageOne.replace("\n", "<br>") + "<html>");
                            inputText.setPreferredSize(new Dimension(750, 50));
                            inputText.setHorizontalAlignment(SwingConstants.CENTER);
                            JButton buttonOne = new JButton("Cafe Normal");
                            JButton buttonTwo = new JButton("Capuchino");
                            JButton buttonThree = new JButton("Capuchino con Vainilla");
                            JButton buttonFour = new JButton("Chocolate");
                            JButton buttonFive = new JButton("Moka");
                            JButton buttonSix = new JButton("Te Chai");
                            JButton buttonSeven = new JButton("Cafe Frio");

                            JButton[] buttonBarA = {buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven};

                            setButtons(buttonBarA);

                            secondPanel.add(inputText);
                            secondPanel.add(buttonOne);
                            secondPanel.add(buttonTwo);
                            secondPanel.add(buttonThree);
                            secondPanel.add(buttonFour);
                            secondPanel.add(buttonFive);
                            secondPanel.add(buttonSix);
                            secondPanel.add(buttonSeven);

                            panelCC.add(secondPanel);

                            panelCentral.add(panelCC);

                            buttonOne.addActionListener((ActionEvent e4) -> {

                                String drinkOption = "Cafe Normal";
                                barModification(thirdPanel, panelCC, panelCentral, frame, reservationSet, drinkOption, bar);
                            });

                            buttonTwo.addActionListener((ActionEvent e4) -> {

                                String drinkOption = "Capuchino";
                                barModification(thirdPanel, panelCC, panelCentral, frame, reservationSet, drinkOption, bar);
                            });

                            buttonThree.addActionListener((ActionEvent e4) -> {

                                String drinkOption = "Capuchino con Vainilla";

                                barModification(thirdPanel, panelCC, panelCentral, frame, reservationSet, drinkOption, bar);
                            });

                            buttonFour.addActionListener((ActionEvent e4) -> {

                                String drinkOption = "Chocolate";

                                barModification(thirdPanel, panelCC, panelCentral, frame, reservationSet, drinkOption, bar);
                            });

                            buttonFive.addActionListener((ActionEvent e4) -> {

                                String drinkOption = "Moka";

                                barModification(thirdPanel, panelCC, panelCentral, frame, reservationSet, drinkOption, bar);
                            });

                            buttonSix.addActionListener((ActionEvent e4) -> {

                                String drinkOption = "Te Chai";

                                barModification(thirdPanel, panelCC, panelCentral, frame, reservationSet, drinkOption, bar);
                            });

                            buttonSeven.addActionListener((ActionEvent e4) -> {

                                String drinkOption = "Cafe Frio";

                                barModification(thirdPanel, panelCC, panelCentral, frame, reservationSet, drinkOption, bar);
                            });

                            updateWindiow(frame);
                        } else {
                            JOptionPane.showMessageDialog(null, "El ID no se encuentra en el Sistema");
                        }

                        updateWindiow(frame);
                    });

                    panelCentral.add(panelCC);

                    confirmationButton.addActionListener((ActionEvent e1) -> {

                    });

                    updateWindiow(frame);

                });

                buttonM.addActionListener((ActionEvent e2) -> {

                    panelCC.removeAll();
                    firstPanel.removeAll();

                    panelsSize(firstPanel, secondPanel, thirdPanel);

                    String inputLabel = """
                                        En este menu podras modificar tanto el momento de entrega de la bebida que el empleado selecciono o bien la bebida seleccionada
                                        Primero, confirmemos el ID del empleado que desea realizar el cambio

                                        Ingresa el ID del empleado: 
                                        
                                        """;

                    JLabel input = new JLabel("<html>" + inputLabel.replace("\n", "<br>") + "<html>");

                    JTextField textField = new JTextField(25);
                    JButton confirmationButton = new JButton("Confirmar");
                    JButton[] bConfirmation = {confirmationButton};
                    setButtons(bConfirmation);

                    firstPanel.add(input);
                    firstPanel.add(textField);
                    firstPanel.add(confirmationButton);

                    panelCC.add(firstPanel);

                    panelCentral.add(panelCC);

                    secondPanel.setPreferredSize(new Dimension(400, 150));

                    confirmationButton.addActionListener((ActionEvent e1) -> {
                        String texto = textField.getText();
                        Vector<String> reservationSet = bar.modification(texto);
                        textField.setText("");

                        if (!(reservationSet == null)) {
                            secondPanel.removeAll();

                            String textOne = """
                                        
                                       Perfecto!! Ahora por favor indica cual opcion deseas modificar
                                        
                                        Indica la opcion que deseas realizar: 
                                       
                                        """;

                            JLabel inputText = new JLabel("<html>" + textOne.replace("\n", "<br>") + "<html>");
                            JButton buttonOne = new JButton("Momento de entrega");
                            JButton buttonTwo = new JButton("Bebida Seleccionada");

                            JButton[] buttonsBarM = {buttonOne, buttonTwo};

                            setButtons(buttonsBarM);

                            secondPanel.add(inputText);
                            secondPanel.add(buttonOne);
                            secondPanel.add(buttonTwo);

                            panelCC.add(secondPanel);

                            panelCentral.add(panelCC);

                            buttonOne.addActionListener((ActionEvent e3) -> {

                                thirdPanel.removeAll();

                                String textoOne = """
                                        Indica el nuevo momento de entrega:
                                        
                                        Indica la opcion deseada: 
                                        """;

                                JLabel inputTextOne = new JLabel("<html>" + textoOne.replace("\n", "<br>") + "<html>");
                                inputTextOne.setPreferredSize(new Dimension(800, 60));
                                inputTextOne.setHorizontalAlignment(SwingConstants.CENTER);
                                JButton bOne = new JButton("Break");
                                JButton bTwo = new JButton("Lunch");
                                JButton bThree = new JButton("Coffe Break");
                                JButton bFour = new JButton("Leave");

                                JButton[] buttonsTime = {bOne, bTwo, bThree, bFour};

                                setButtons(buttonsTime);

                                thirdPanel.add(inputTextOne);
                                thirdPanel.add(bOne);
                                thirdPanel.add(bTwo);
                                thirdPanel.add(bThree);
                                thirdPanel.add(bFour);

                                panelCC.add(thirdPanel);

                                panelCentral.add(panelCC);

                                bOne.addActionListener((ActionEvent e4) -> {
                                    String option = "Break";
                                    bar.reservationT(reservationSet.get(1), option);

                                    updateWindiow(frame);
                                    panelCC.removeAll();

                                });

                                bTwo.addActionListener((ActionEvent e4) -> {
                                    String option = "Lunch";
                                    bar.reservationT(reservationSet.get(1), option);

                                    updateWindiow(frame);
                                    panelCC.removeAll();

                                });
                                bThree.addActionListener((ActionEvent e4) -> {
                                    String option = "Coffee Break";
                                    bar.reservationT(reservationSet.get(1), option);

                                    updateWindiow(frame);
                                    panelCC.removeAll();

                                });

                                bFour.addActionListener((ActionEvent e4) -> {
                                    String option = "Leave";
                                    bar.reservationT(reservationSet.get(1), option);

                                    updateWindiow(frame);
                                    panelCC.removeAll();

                                });

                                updateWindiow(frame);

                            });

                            buttonTwo.addActionListener((ActionEvent e3) -> {

                                thirdPanel.removeAll();

                                String textoOne = """
                                        En este menu podras cambiar la opcion de bebida que fue seleccionada previamente.
                                        Agregamos un menu para mostrar las opciones disponibles
                                                  
                                        Indica la opcion que deseas seleccionar: 
                                        """;

                                JLabel inputTextOne = new JLabel("<html>" + textoOne.replace("\n", "<br>") + "<html>");
                                inputTextOne.setPreferredSize(new Dimension(800, 60));
                                inputTextOne.setHorizontalAlignment(SwingConstants.CENTER);
                                JButton bOne = new JButton("Cafe Normal");
                                JButton bTwo = new JButton("Capuchino");
                                JButton bThree = new JButton("Capuchino con Vainilla");
                                JButton bFour = new JButton("Chocolate");
                                JButton bFive = new JButton("Moka");
                                JButton bSix = new JButton("Te Chai");
                                JButton bSeven = new JButton("Cafe Frio");

                                JButton[] buttonsBarTipe = {bOne, bTwo, bThree, bFour, bFive, bSix, bSeven};

                                setButtons(buttonsBarTipe);

                                thirdPanel.add(inputTextOne);
                                thirdPanel.add(bOne);
                                thirdPanel.add(bTwo);
                                thirdPanel.add(bThree);
                                thirdPanel.add(bFour);
                                thirdPanel.add(bFive);
                                thirdPanel.add(bSix);
                                thirdPanel.add(bSeven);

                                panelCC.add(thirdPanel);

                                panelCentral.add(panelCC);

                                bOne.addActionListener((ActionEvent e4) -> {
                                    String option = "Cafe Normal";
                                    bar.reservationD(reservationSet.get(1), option);

                                    updateWindiow(frame);
                                    panelCC.removeAll();

                                });
                                bTwo.addActionListener((ActionEvent e4) -> {
                                    String option = "Capuchino";
                                    bar.reservationD(reservationSet.get(1), option);

                                    updateWindiow(frame);
                                    panelCC.removeAll();

                                });
                                bThree.addActionListener((ActionEvent e4) -> {
                                    String option = "Capuchino con Vainilla";
                                    bar.reservationD(reservationSet.get(1), option);

                                    updateWindiow(frame);
                                    panelCC.removeAll();

                                });
                                bFour.addActionListener((ActionEvent e4) -> {
                                    String option = "Chocolate";
                                    bar.reservationD(reservationSet.get(1), option);

                                    updateWindiow(frame);
                                    panelCC.removeAll();

                                });
                                bFive.addActionListener((ActionEvent e4) -> {
                                    String option = "Moka";
                                    bar.reservationD(reservationSet.get(1), option);

                                    updateWindiow(frame);
                                    panelCC.removeAll();

                                });
                                bSix.addActionListener((ActionEvent e4) -> {
                                    String option = "Te Chai";
                                    bar.reservationD(reservationSet.get(1), option);

                                    updateWindiow(frame);
                                    panelCC.removeAll();

                                });
                                bSeven.addActionListener((ActionEvent e4) -> {
                                    String option = "Cafe Frio";
                                    bar.reservationD(reservationSet.get(1), option);

                                    updateWindiow(frame);
                                    panelCC.removeAll();
                                });

                                updateWindiow(frame);

                            });

                            updateWindiow(frame);
                        } else {
                            JOptionPane.showMessageDialog(null, "El ID no cuenta con reservacion");
                        }

                        updateWindiow(frame);
                    });

                    updateWindiow(frame);

                });

                buttonC.addActionListener((ActionEvent e2) -> {

                    panelCC.removeAll();
                    firstPanel.removeAll();

                    panelsSize(firstPanel, secondPanel, thirdPanel);

                    String inputLabel = """
                                        Has ingresado a la seccion para cancelar una reservacion de bebida
                                        En esta seccion se necesitara ubicar al pedido realizado por el empleado utilizando su ID para lograr remover la reservacion correcta
                                        
                                        Por favor, ingrese el ID de empleado: 
                                        
                                        """;

                    JLabel input = new JLabel("<html>" + inputLabel.replace("\n", "<br>") + "<html>");
                    JTextField textFieldName = new JTextField(25);
                    JButton confirmationButton = new JButton("Confirmar");
                    JButton[] bConfirmation = {confirmationButton};
                    setButtons(bConfirmation);

                    firstPanel.add(input);
                    firstPanel.add(textFieldName);
                    firstPanel.add(confirmationButton);

                    panelCC.add(firstPanel);

                    panelCentral.add(panelCC);

                    confirmationButton.addActionListener((ActionEvent e1) -> {
                        String texto = textFieldName.getText();
                        bar.delete(texto);
                        textFieldName.setText("");

                        updateWindiow(frame);

                    });

                    updateWindiow(frame);

                });

                buttonV.addActionListener((var e2) -> {

                    firstPanel.removeAll();
                    secondPanel.removeAll();
                    thirdPanel.removeAll();

                    JPanel fourthPanel = new JPanel();
                    fourthPanel.setLayout(new FlowLayout());

                    firstPanel.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 5));
                    secondPanel.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 5));
                    thirdPanel.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 5));
                    fourthPanel.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 5));

                    JLabel titleOne = new JLabel("Reservaciones Break");
                    JLabel titleTwo = new JLabel("Reservaciones Lunch");
                    JLabel titleThree = new JLabel("Reservaciones Coffee Break");
                    JLabel titleFour = new JLabel("Reservaciones Leave");
                    
                    JLabel [] labels = {titleOne, titleTwo, titleThree, titleFour};
                    
                    for (JLabel label : labels) {
                        label.setHorizontalAlignment(SwingConstants.CENTER);
                        label.setVerticalAlignment(SwingConstants.CENTER);
                        label.setForeground(new Color(139, 0, 0));
                    }

                    JLabel[] titles = {titleOne, titleTwo, titleThree, titleFour};
                    for (JLabel title : titles) {
                        title.setPreferredSize(new Dimension(170, 20));
                    }

                    String textOne = "";
                    String textTwo = "";
                    String textThree = "";
                    String textFour = "";

                    for (int i = 0; i < bar.list.size(); i++) {
                        Vector<String> set = bar.list.get(i);
                        switch (set.get(3)) {
                            case "Break" ->
                                textOne = set.get(0) + " / " + set.get(2);
                            case "Lunch" ->
                                textTwo = set.get(0) + " / " + set.get(2);
                            case "Coffee Break" ->
                                textThree = set.get(0) + " / " + set.get(2);
                            case "Leave" ->
                                textFour = set.get(0) + " / " + set.get(2);
                        }
                    }

                    JLabel labelOne = new JLabel("<html>" + textOne.replace("\n", "<br>") + "<html>");
                    JLabel labelTwo = new JLabel("<html>" + textTwo.replace("\n", "<br>") + "<html>");
                    JLabel labelThree = new JLabel("<html>" + textThree.replace("\n", "<br>") + "<html>");
                    JLabel labelFour = new JLabel("<html>" + textFour.replace("\n", "<br>") + "<html>");

                    JPanel[] panels = {firstPanel, secondPanel, thirdPanel, fourthPanel};
                    for (JPanel panel : panels) {
                        panel.setPreferredSize(new Dimension(220, 500));
                        panel.setBackground(new Color(0, 0, 0, 0));
                        panelCC.add(panel);
                    }

                    firstPanel.add(titleOne);
                    firstPanel.add(labelOne);
                    secondPanel.add(titleTwo);
                    secondPanel.add(labelTwo);
                    thirdPanel.add(titleThree);
                    thirdPanel.add(labelThree);
                    fourthPanel.add(titleFour);
                    fourthPanel.add(labelFour);

                    panelCentral.add(panelCC);

                    updateWindiow(frame);

                });

                updateWindiow(frame);

            });

            bBaile.addActionListener((ActionEvent eBaile) -> {

                cleaningWindow(panelCentral, panelCS, panelCSS, panelCSI, firstPanel, secondPanel, thirdPanel);

                String info = """
                            En este apartado podras realizar diversas funciones con la sala de Baile
                            """;
                JLabel titulo = new JLabel("<html>" + info.replace("\n", "<br>") + "<html>");

                panelCSS.add(titulo);
                titulo.setForeground(new Color(255, 215, 0));

                JButton buttonA = new JButton("Agregar Reserva");
                JButton buttonC = new JButton("Cancelar Reserva");
                JButton buttonV = new JButton("Visualizar Reservas");

                JButton[] buttonsYoga = {buttonA, buttonC, buttonV};

                setButtons(buttonsYoga);

                panelCSI.add(buttonA);
                panelCSI.add(buttonC);
                panelCSI.add(buttonV);

                panelCS.add(panelCSS, BorderLayout.CENTER);
                panelCS.add(panelCSI, BorderLayout.SOUTH);

                panelCentral.add(panelCS, BorderLayout.NORTH);

                buttonA.addActionListener((ActionEvent e2) -> {

                    panelCC.removeAll();
                    firstPanel.removeAll();

                    panelsSize(firstPanel, secondPanel, thirdPanel);

                    firstPanel.setPreferredSize(new Dimension(500, 120));

                    JLabel input = new JLabel("Introduzca el ID del Empleado: ");
                    JTextField textField = new JTextField(25);
                    JButton confirmationButton = new JButton("Confirmar");
                    JButton[] bConfirmation = {confirmationButton};
                    setButtons(bConfirmation);

                    firstPanel.add(input);
                    firstPanel.add(textField);
                    firstPanel.add(confirmationButton);

                    panelCC.add(firstPanel);

                    panelCentral.add(panelCC);

                    confirmationButton.addActionListener((ActionEvent e1) -> {
                        String texto = textField.getText();
                        baile.registrarReserva(register, texto);
                        textField.setText("");

                        updateWindiow(frame);
                    });

                    updateWindiow(frame);

                });

                buttonC.addActionListener((ActionEvent e3) -> {

                    panelCC.removeAll();
                    firstPanel.removeAll();

                    panelsSize(firstPanel, secondPanel, thirdPanel);

                    firstPanel.setPreferredSize(new Dimension(750, 120));

                    JLabel input = new JLabel("Introduzca el ID del Empleado para remover su reserva: ");
                    JTextField textField = new JTextField(25);
                    JButton confirmationButton = new JButton("Confirmar");
                    JButton[] bConfirmation = {confirmationButton};
                    setButtons(bConfirmation);

                    firstPanel.add(input);
                    firstPanel.add(textField);
                    firstPanel.add(confirmationButton);

                    panelCC.add(firstPanel);

                    panelCentral.add(panelCC);

                    confirmationButton.addActionListener((ActionEvent e1) -> {
                        String texto = textField.getText();
                        baile.cancelarReserva(texto);
                        textField.setText("");

                        updateWindiow(frame);
                    });

                    updateWindiow(frame);

                });

                buttonV.addActionListener((ActionEvent e1) -> {

                    panelCC.removeAll();
                    firstPanel.removeAll();
                    secondPanel.removeAll();

                    firstPanel.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 5));
                    secondPanel.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 5));

                    baile.mostrarReservas();

                    String texto7pm = "";

                    for (Vector list : baile.list7pm) {
                        texto7pm += list.get(1) + " " + list.get(0) + "\n";
                    }
                    JLabel title7pm = new JLabel("Lista de Sesion de las 7pm");
                    title7pm.setPreferredSize(new Dimension(400, 25));
                    JLabel label7pm = new JLabel("<html>" + texto7pm.replace("\n", "<br>") + "<html>");

                    firstPanel.add(title7pm);
                    firstPanel.add(label7pm);

                    String texto8pm = "";

                    for (Vector list : baile.list8pm) {
                        texto8pm += list.get(1) + " " + list.get(0) + "\n";
                    }
                    JLabel title8pm = new JLabel("Lista de Sesion de las 8pm");
                    title8pm.setPreferredSize(new Dimension(400, 25));
                    JLabel label8pm = new JLabel("<html>" + texto8pm.replace("\n", "<br>") + "<html>");

                    JPanel[] panels = {firstPanel, secondPanel};
                    for (JPanel panel : panels) {
                        panel.setPreferredSize(new Dimension(400, 400));
                        panel.setBackground(new Color(0, 0, 0, 0));
                    }
                    
                    JLabel [] labels = {title8pm, title7pm};
                    
                    for (JLabel label : labels) {
                        label.setHorizontalAlignment(SwingConstants.CENTER);
                        label.setVerticalAlignment(SwingConstants.CENTER);
                        label.setForeground(new Color(139, 0, 0));
                    }

                    secondPanel.add(title8pm);
                    secondPanel.add(label8pm);

                    panelCC.add(firstPanel);
                    panelCC.add(secondPanel);

                    panelCentral.add(panelCC);

                    updateWindiow(frame);

                });

                updateWindiow(frame);

            });

            bYoga.addActionListener((ActionEvent eYoga) -> {

                cleaningWindow(panelCentral, panelCS, panelCSS, panelCSI, firstPanel, secondPanel, thirdPanel);

                String info = """
                            En este apartado podras realizar diversas funciones con la sala de Yoga
                            """;
                JLabel titulo = new JLabel("<html>" + info.replace("\n", "<br>") + "<html>");

                panelCSS.add(titulo);
                                titulo.setForeground(new Color(255, 215, 0));


                JButton buttonA = new JButton("Agregar Reserva");
                JButton buttonC = new JButton("Cancelar Reserva");
                JButton buttonV = new JButton("Visualizar Reservas");

                JButton[] buttonsYoga = {buttonA, buttonC, buttonV};

                setButtons(buttonsYoga);

                panelCSI.add(buttonA);
                panelCSI.add(buttonC);
                panelCSI.add(buttonV);

                panelCS.add(panelCSS, BorderLayout.CENTER);
                panelCS.add(panelCSI, BorderLayout.SOUTH);

                panelCentral.add(panelCS, BorderLayout.NORTH);

                buttonA.addActionListener((ActionEvent e2) -> {

                    panelCC.removeAll();
                    firstPanel.removeAll();

                    panelsSize(firstPanel, secondPanel, thirdPanel);

                    firstPanel.setPreferredSize(new Dimension(500, 120));

                    JLabel input = new JLabel("Introduzca el ID del Empleado: ");
                    JTextField textField = new JTextField(25);
                    JButton confirmationButton = new JButton("Confirmar");
                    JButton[] bConfirmation = {confirmationButton};
                    setButtons(bConfirmation);

                    firstPanel.add(input);
                    firstPanel.add(textField);
                    firstPanel.add(confirmationButton);

                    panelCC.add(firstPanel);

                    panelCentral.add(panelCC);

                    confirmationButton.addActionListener((ActionEvent e1) -> {
                        String texto = textField.getText();
                        yoga.registrarReserva(register, texto);
                        textField.setText("");

                        updateWindiow(frame);
                    });

                    updateWindiow(frame);

                });

                buttonC.addActionListener((ActionEvent e3) -> {

                    panelCC.removeAll();
                    firstPanel.removeAll();

                    panelsSize(firstPanel, secondPanel, thirdPanel);

                    firstPanel.setPreferredSize(new Dimension(750, 120));

                    JLabel input = new JLabel("Introduzca el ID del Empleado para remover su reserva: ");
                    JTextField textField = new JTextField(25);
                    JButton confirmationButton = new JButton("Confirmar");
                    JButton[] bConfirmation = {confirmationButton};
                    setButtons(bConfirmation);

                    firstPanel.add(input);
                    firstPanel.add(textField);
                    firstPanel.add(confirmationButton);

                    panelCC.add(firstPanel);

                    panelCentral.add(panelCC);

                    confirmationButton.addActionListener((ActionEvent e1) -> {
                        String texto = textField.getText();
                        yoga.cancelarReserva(texto);
                        textField.setText("");

                        updateWindiow(frame);
                    });

                    updateWindiow(frame);

                });

                buttonV.addActionListener((ActionEvent e1) -> {

                    panelCC.removeAll();
                    firstPanel.removeAll();
                    secondPanel.removeAll();

                    firstPanel.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 5));
                    secondPanel.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 5));

                    yoga.mostrarReservas();

                    String texto7pm = "";

                    for (Vector list : yoga.list7pm) {
                        texto7pm += list.get(1) + " " + list.get(0) + "\n";
                    }
                    JLabel title7pm = new JLabel("Lista de Sesion de las 7pm");
                    title7pm.setPreferredSize(new Dimension(400, 25));
                    JLabel label7pm = new JLabel("<html>" + texto7pm.replace("\n", "<br>") + "<html>");

                    firstPanel.add(title7pm);
                    firstPanel.add(label7pm);

                    String texto8pm = "";

                    for (Vector list : yoga.list8pm) {
                        texto8pm += list.get(1) + " " + list.get(0) + "\n";
                    }
                    JLabel title8pm = new JLabel("Lista de Sesion de las 8pm");
                    title8pm.setPreferredSize(new Dimension(400, 25));
                    JLabel label8pm = new JLabel("<html>" + texto8pm.replace("\n", "<br>") + "<html>");

                    JPanel[] panels = {firstPanel, secondPanel};
                    for (JPanel panel : panels) {
                        panel.setPreferredSize(new Dimension(400, 400));
                        panel.setBackground(new Color(0, 0, 0, 0));
                    }
                    
                    JLabel [] labels = {title8pm, title7pm};
                    
                    for (JLabel label : labels) {
                        label.setHorizontalAlignment(SwingConstants.CENTER);
                        label.setVerticalAlignment(SwingConstants.CENTER);
                        label.setForeground(new Color(139, 0, 0));
                    }
                    
                    
                    secondPanel.add(title8pm);
                    secondPanel.add(label8pm);

                    panelCC.add(firstPanel);
                    panelCC.add(secondPanel);

                    panelCentral.add(panelCC);

                    updateWindiow(frame);

                });

                updateWindiow(frame);

            });

            bGimnasio.addActionListener((ActionEvent eGym) -> {

                cleaningWindow(panelCentral, panelCS, panelCSS, panelCSI, firstPanel, secondPanel, thirdPanel);

                String tituloEmpleadosInfo = """
                            En este apartado podras realizar diversas funciones con la sala de Gym
                            """;

                JLabel titulo = new JLabel("<html>" + tituloEmpleadosInfo.replace("\n", "<br>") + "<html>");

                panelCSS.add(titulo);
                                titulo.setForeground(new Color(255, 215, 0));


                JButton buttonA = new JButton("Agregar Estudiante");
                JButton buttonC = new JButton("Cancelar Inscripcion");
                JButton buttonV = new JButton("Visualizar Clase");

                JButton[] buttonsGym = {buttonA, buttonV, buttonC};

                setButtons(buttonsGym);

                panelCSI.add(buttonA);
                panelCSI.add(buttonC);
                panelCSI.add(buttonV);

                panelCS.add(panelCSS, BorderLayout.CENTER);
                panelCS.add(panelCSI, BorderLayout.SOUTH);

                panelCentral.add(panelCS, BorderLayout.NORTH);

                secondPanel.setPreferredSize(new Dimension(500, 100));
                secondPanel.setBorder(new EmptyBorder(30, 0, 0, 0));

                buttonA.addActionListener((ActionEvent e2) -> {

                    panelCC.removeAll();
                    firstPanel.removeAll();

                    panelsSize(firstPanel, secondPanel, thirdPanel);

                    firstPanel.setPreferredSize(new Dimension(500, 150));

                    JLabel input = new JLabel("Introduzca el ID del Empleado: ");
                    JTextField textField = new JTextField(25);
                    JButton confirmationButton = new JButton("Confirmar");
                    JButton[] bConfirmation = {confirmationButton};
                    setButtons(bConfirmation);

                    firstPanel.add(input);
                    firstPanel.add(textField);
                    firstPanel.add(confirmationButton);

                    panelCC.add(firstPanel);

                    panelCentral.add(panelCC);

                    confirmationButton.addActionListener((ActionEvent e1) -> {
                        String texto = textField.getText();
                        gimnasio.agregarEstudiante(register, texto);
                        textField.setText("");

                        updateWindiow(frame);
                    });

                    updateWindiow(frame);

                });

                buttonC.addActionListener((ActionEvent e3) -> {

                    panelCC.removeAll();
                    firstPanel.removeAll();

                    panelsSize(firstPanel, secondPanel, thirdPanel);

                    firstPanel.setPreferredSize(new Dimension(500, 150));

                    JLabel input = new JLabel("""
                                              Introduzca el ID del Empleado: 
                            
                                              """);
                    JTextField textField = new JTextField(25);
                    JButton confirmationButton = new JButton("Verificar");
                    JButton[] bConfirmation = {confirmationButton};
                    setButtons(bConfirmation);

                    firstPanel.add(input);
                    firstPanel.add(textField);
                    firstPanel.add(confirmationButton);

                    panelCC.add(firstPanel);

                    panelCentral.add(panelCC);

                    confirmationButton.addActionListener((ActionEvent e1) -> {
                        String texto = textField.getText();
                        gimnasio.eliminarEstudiante(texto);
                        textField.setText("");

                        updateWindiow(frame);
                    });

                    updateWindiow(frame);

                });

                buttonV.addActionListener((ActionEvent e1) -> {

                    panelCC.removeAll();
                    firstPanel.removeAll();

                    panelsSize(firstPanel, secondPanel, thirdPanel);

                    firstPanel.setPreferredSize(new Dimension(300, 500));
                    firstPanel.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 5));
                    firstPanel.setBackground(new Color(0, 0, 0, 0));

                    String labelText = "";

                    for (Vector<String> set : gimnasio.reservationList) {
                        labelText += set.get(0) + " / " + set.get(2) + "\n";
                    }

                    JLabel title = new JLabel("Reservaciones realizadas");
                    title.setPreferredSize(new Dimension(300, 15));
                    title.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel label = new JLabel("<html>" + labelText.replace("\n", "<br>") + "<html>");
                    
                    JLabel [] labels = {title};
                    
                    for (JLabel labelOne : labels) {
                        labelOne.setHorizontalAlignment(SwingConstants.CENTER);
                        labelOne.setVerticalAlignment(SwingConstants.CENTER);
                        labelOne.setForeground(new Color(139, 0, 0));
                    }
                    
                    firstPanel.add(title);
                    firstPanel.add(label);

                    panelCC.add(firstPanel);

                    panelCentral.add(panelCC);

                    updateWindiow(frame);

                });

                updateWindiow(frame);

            });
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            

            bCine.addActionListener((ActionEvent eCine1) -> {

                cleaningWindow(panelCentral, panelCS, panelCSS, panelCSI, firstPanel, secondPanel, thirdPanel);

                String gestion = imax.gestion(register);

                String sala = "";

                if (gestion.equals("IMAX")) {
                    sala = "IMAX";
                    theaterRooms(sala, panelCSS, panelCSI, panelCS, panelCentral, firstPanel, secondPanel, thirdPanel, panelCC, imax, register, frame);
                } else if (gestion.equals("VIP")) {
                    sala = "VIP";
                    theaterRooms(sala, panelCSS, panelCSI, panelCS, panelCentral, firstPanel, secondPanel, thirdPanel, panelCC, vip, register, frame);
                } else {
                    JOptionPane.showMessageDialog(null, "La informacion introducida no es correcta");
                }

                updateWindiow(frame);

            });

            updateWindiow(frame);

        });
        
        
        
        
        
        
        
        
        
        
        
        
        

        bInfo.addActionListener((ActionEvent e) -> {

            panelOpciones.removeAll();
            panelCentral.removeAll();

            JPanel panelCS = new JPanel();
            panelCS.setBackground(new Color(0, 0, 0, 0));
            panelCS.setPreferredSize(new Dimension(100, 100));
            panelCS.setLayout(new BorderLayout());

            JPanel panelCSS = new JPanel();
            panelCSS.setLayout(new FlowLayout());
            panelCSS.setBackground(new Color(0, 102, 255));
            panelCSS.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 0)));

            String tituloEmpleadosInfo = """
                            En este apartado podras realizar diversas funciones con la informacion de los empleados
                            Con el fin de facilitar el uso se te agrega las opciones disponibles
                            """;

            JLabel titulo = new JLabel("<html>" + tituloEmpleadosInfo.replace("\n", "<br>") + "<html>");

            panelCSS.add(titulo);
                titulo.setForeground(new Color(255, 215, 0));

            JPanel panelCSI = new JPanel();
            panelCSI.setLayout(new FlowLayout());
            panelCSI.setBackground(new Color(0, 0, 0, 0));
            panelCSI.setPreferredSize(new Dimension(35, 30));

            JButton buttonA = new JButton("Agregar Empleado");
            JButton buttonM = new JButton("Modificar Informacion");
            JButton buttonR = new JButton("Remover Empleado");

            JButton[] buttonsMCine = {buttonA, buttonM, buttonR};

            setButtons(buttonsMCine);

            panelCSI.add(buttonA);
            panelCSI.add(buttonM);
            panelCSI.add(buttonR);

            panelCS.add(panelCSS, BorderLayout.CENTER);
            panelCS.add(panelCSI, BorderLayout.SOUTH);

            panelCentral.add(panelCS, BorderLayout.NORTH);

            JPanel firstPanel = new JPanel();
            firstPanel.setBackground(new Color(0, 0, 0, 0));
            firstPanel.setLayout(new FlowLayout());
            firstPanel.setPreferredSize(new Dimension(600, 140));
            firstPanel.setBorder(new EmptyBorder(30, 30, 0, 0));

            buttonA.addActionListener((ActionEvent e1) -> {

                panelCC.removeAll();
                firstPanel.removeAll();

                JLabel input = new JLabel("Introduzca el nombre del empleado: ");
                JTextField textFieldName = new JTextField(25);
                JButton confirmationButton = new JButton("Verificar");
                JButton[] bConfirmation = {confirmationButton};
                setButtons(bConfirmation);

                firstPanel.add(input);
                firstPanel.add(textFieldName);
                firstPanel.add(confirmationButton);

                panelCC.add(firstPanel);

                panelCentral.add(panelCC);

                confirmationButton.addActionListener((ActionEvent e2) -> {

                    String inpuText = textFieldName.getText();
                    data.addEmployee(inpuText);
                    textFieldName.setText("");

                    updateWindiow(frame);

                });

                updateWindiow(frame);

            });

            buttonM.addActionListener((ActionEvent e2) -> {

                panelCC.removeAll();
                firstPanel.removeAll();

                JLabel input = new JLabel("Ingrese el ID del empleado: ");
                JTextField textFieldName = new JTextField(25);
                JButton confirmationButton = new JButton("Verificar");
                JButton[] bConfirmation = {confirmationButton};
                setButtons(bConfirmation);

                firstPanel.add(input);
                firstPanel.add(textFieldName);
                firstPanel.add(confirmationButton);

                panelCC.add(firstPanel);

                panelCentral.add(panelCC);

                confirmationButton.addActionListener((ActionEvent e3) -> {

                    String inpuText = textFieldName.getText();
                    data.modifyEmployeeName(inpuText);
                    textFieldName.setText("");

                    updateWindiow(frame);

                });

                updateWindiow(frame);

                confirmationButton.addActionListener((ActionEvent e1) -> {
                    String texto = textFieldName.getText();
                    data.modifyEmployeeName(texto);
                    textFieldName.setText("");

                });

            });

            buttonR.addActionListener((ActionEvent e3) -> {

                panelCC.removeAll();
                firstPanel.removeAll();

                JLabel input = new JLabel("Ingrese el ID del empleado a remover: ");
                JTextField textFieldName = new JTextField(25);
                JButton confirmationButton = new JButton("Verificar");
                JButton[] bConfirmation = {confirmationButton};
                setButtons(bConfirmation);

                firstPanel.add(input);
                firstPanel.add(textFieldName);
                firstPanel.add(confirmationButton);

                panelCC.add(firstPanel);

                panelCentral.add(panelCC);

                updateWindiow(frame);

                confirmationButton.addActionListener((ActionEvent e1) -> {
                    String texto = textFieldName.getText();
                    data.removeEmployee(texto);
                    textFieldName.setText("");

                    updateWindiow(frame);

                });
                updateWindiow(frame);

            });

            updateWindiow(frame);

        });

        frame.add(panelNorte, BorderLayout.NORTH);
        frame.add(panelOeste, BorderLayout.WEST);
        frame.add(panelCentral, BorderLayout.CENTER);

        frame.setVisible(true);

    }

    public static void barModification(JPanel thirdPanel, JPanel panelCC, JPanel panelCentral, JFrame frame, Vector<String> reservationSet, String drink, Bar bar) {

        thirdPanel.removeAll();

        String messageTwo = "Indica la opcion que deseas seleccionar: ";

        JLabel inputTextOne = new JLabel("<html>" + messageTwo.replace("\n", "<br>") + "<html>");
        inputTextOne.setPreferredSize(new Dimension(750, 50));
        inputTextOne.setHorizontalAlignment(SwingConstants.CENTER);
        JButton bOne = new JButton("Break");
        JButton bTwo = new JButton("Lunch");
        JButton bThree = new JButton("Coffee Break");
        JButton bFour = new JButton("Leave");

        JButton[] buttonsTime = {bOne, bTwo, bThree, bFour};

        setButtons(buttonsTime);

        thirdPanel.add(inputTextOne);
        thirdPanel.add(bOne);
        thirdPanel.add(bTwo);
        thirdPanel.add(bThree);
        thirdPanel.add(bFour);

        panelCC.add(thirdPanel);

        panelCentral.add(panelCC);

        bOne.addActionListener((ActionEvent e) -> {

            String time = "Break";

            JOptionPane.showMessageDialog(null, "Se ha completado exitosamente la reservacion!!\n\n"
                    + "Detalles: \n"
                    + "Nombre del empleado: " + reservationSet.get(0) + "\n"
                    + "ID de empleado: " + reservationSet.get(1) + "\n"
                    + "Bebida: " + drink + "\n"
                    + "Hora de entrega: " + time);

            bar.reservationSet(reservationSet.get(0), reservationSet.get(1), drink, time);
            panelCC.removeAll();

            updateWindiow(frame);

        });

        bTwo.addActionListener((ActionEvent e) -> {
            String time = "Lunch";

            JOptionPane.showMessageDialog(null, "Se ha completado exitosamente la reservacion!!\n\n"
                    + "Detalles: \n"
                    + "Nombre del empleado: " + reservationSet.get(0) + "\n"
                    + "ID de empleado: " + reservationSet.get(1) + "\n"
                    + "Bebida: " + drink + "\n"
                    + "Hora de entrega: " + time);

            bar.reservationSet(reservationSet.get(0), reservationSet.get(1), drink, time);
            panelCC.removeAll();

            updateWindiow(frame);

        });
        bThree.addActionListener((ActionEvent e) -> {
            String time = "Coffee Break";

            JOptionPane.showMessageDialog(null, "Se ha completado exitosamente la reservacion!!\n\n"
                    + "Detalles: \n"
                    + "Nombre del empleado: " + reservationSet.get(0) + "\n"
                    + "ID de empleado: " + reservationSet.get(1) + "\n"
                    + "Bebida: " + drink + "\n"
                    + "Hora de entrega: " + time);

            bar.reservationSet(reservationSet.get(0), reservationSet.get(1), drink, time);
            panelCC.removeAll();

            updateWindiow(frame);

        });
        bFour.addActionListener((ActionEvent e) -> {
            String time = "Leave";

            JOptionPane.showMessageDialog(null, "Se ha completado exitosamente la reservacion!!\n\n"
                    + "Detalles: \n"
                    + "Nombre del empleado: " + reservationSet.get(0) + "\n"
                    + "ID de empleado: " + reservationSet.get(1) + "\n"
                    + "Bebida: " + drink + "\n"
                    + "Hora de entrega: " + time);

            bar.reservationSet(reservationSet.get(0), reservationSet.get(1), drink, time);
            panelCC.removeAll();

            updateWindiow(frame);

        });

        updateWindiow(frame);

    }

    public static void setButtons(JButton[] buttons) {
        for (JButton button : buttons) {
            button.setBackground(new Color(0, 102, 255));
            button.setPreferredSize(new Dimension(150, 25));
            button.setForeground(new Color(255, 215, 0));
            button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            button.setFocusPainted(false);
        }
    }

    public static void groups(String info, JPanel panelCSS, JPanel panelCSI, JPanel panelCS, JPanel panelCentral, JPanel firstPanel, JPanel panelCC, JFrame frame) {
        JLabel titulo = new JLabel("<html>" + info.replace("\n", "<br>") + "<html>");

        panelCSS.add(titulo);
                titulo.setForeground(new Color(255, 215, 0));

        JButton buttonA = new JButton("Agregar Reserva");
        JButton buttonC = new JButton("Cancelar Reserva");
        JButton buttonV = new JButton("Visualizar Reservas");

        JButton[] buttonsYoga = {buttonA, buttonC, buttonV};

        setButtons(buttonsYoga);

        panelCSI.add(buttonA);
        panelCSI.add(buttonV);
        panelCSI.add(buttonC);

        panelCS.add(panelCSS, BorderLayout.CENTER);
        panelCS.add(panelCSI, BorderLayout.SOUTH);

        panelCentral.add(panelCS, BorderLayout.NORTH);

        buttonA.addActionListener((ActionEvent e2) -> {

            panelCC.removeAll();
            firstPanel.removeAll();

            JLabel input = new JLabel("Introduzca el ID del Empleado: ");
            JTextField textField = new JTextField(25);
            JButton confirmationButton = new JButton("Confirmar");
            JButton[] bConfirmation = {confirmationButton};
            setButtons(bConfirmation);

            firstPanel.add(input);
            firstPanel.add(textField);
            firstPanel.add(confirmationButton);

            panelCC.add(firstPanel);

            panelCentral.add(panelCC);

            updateWindiow(frame);

        });

        buttonC.addActionListener((ActionEvent e3) -> {

            panelCC.removeAll();
            firstPanel.removeAll();

            JLabel input = new JLabel("Introduzca el ID del Empleado para remover su reserva: ");
            JTextField textFieldInput = new JTextField(25);
            JButton confirmationButton = new JButton("Confirmar");
            JButton[] bConfirmation = {confirmationButton};
            setButtons(bConfirmation);

            firstPanel.add(input);
            firstPanel.add(textFieldInput);
            firstPanel.add(confirmationButton);

            panelCC.add(firstPanel);

            panelCentral.add(panelCC);

            updateWindiow(frame);

        });

        updateWindiow(frame);

    }

    public static void theaterOptions(JPanel secondPanel, JLabel input, JPanel panelCC, JPanel panelCentral, JFrame frame, Theater sala, String selection) {
        JTextField textField = new JTextField(25);
        JButton confirmationButton = new JButton("Confirmar");
        JButton[] bConfirmation = {confirmationButton};
        setButtons(bConfirmation);

        secondPanel.add(input);
        secondPanel.add(textField);
        secondPanel.add(confirmationButton);
        secondPanel.add(input);
        secondPanel.add(textField);
        secondPanel.add(confirmationButton);

        panelCC.add(secondPanel);

        panelCentral.add(panelCC);
                
        
        confirmationButton.addActionListener((ActionEvent e1) -> {
            String texto = textField.getText();
                        
            switch (selection) {
                case "1" -> sala.movieOne = texto;
                case "2" -> sala.movieTwo = texto;
                case "3" -> sala.schecudleOne = texto;
                case "4" -> sala.scheduleTwo = texto;
                case "5" -> sala.spots = texto;
            }
            
            
                        sala.settingsView();

            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            textField.setText("");

            updateWindiow(frame);
        });

        updateWindiow(frame);
        
    }

    public static void theaterOptionsTwo(JPanel firstPanel, JLabel input, JPanel panelCC, JPanel panelCentral, JFrame frame) {
        JTextField textFieldName = new JTextField(25);
        JButton confirmationButton = new JButton("Verificar");
        JButton[] bConfirmation = {confirmationButton};
        setButtons(bConfirmation);

        firstPanel.add(input);
        firstPanel.add(textFieldName);
        firstPanel.add(confirmationButton);

        panelCC.add(firstPanel);

        panelCentral.add(panelCC);

        updateWindiow(frame);

        confirmationButton.addActionListener((ActionEvent e1) -> {
            EmployeeInformation data = new EmployeeInformation();
            String text = textFieldName.getText();
            data.modifyEmployeeName(text);
            textFieldName.setText("");
        });

    }

    public static void cleaningWindow(JPanel panelCentral, JPanel panelCS, JPanel panelCSS, JPanel panelCSI, JPanel firstPanel, JPanel secondPanel, JPanel thirdPanel) {
        panelCentral.removeAll();
        panelCS.removeAll();
        panelCSS.removeAll();
        panelCSI.removeAll();
        firstPanel.removeAll();
        secondPanel.removeAll();
        thirdPanel.removeAll();
    }

    public static void updateWindiow(JFrame frame) {
        frame.revalidate();
        frame.repaint();
    }

    public static void panelsSize(JPanel firstPanel, JPanel secondPanel, JPanel thirdPanel) {
        firstPanel.setPreferredSize(new Dimension(800, 160));
        firstPanel.setBorder(new EmptyBorder(30, 30, 0, 0));
        secondPanel.setPreferredSize(new Dimension(750, 130));
        thirdPanel.setPreferredSize(new Dimension(800, 150));
    }

    public static void theaterRooms(String theater, JPanel panelCSS, JPanel panelCSI, JPanel panelCS, JPanel panelCentral, JPanel firstPanel, JPanel secondPanel, JPanel thirdPanel, JPanel panelCC, Theater sala, Vector<Vector<String>> register, JFrame frame) {

        String tituloCine = "Bienvenidos a la seccion de reservacion y configuraciones relacionadas a la sala " + theater + "\n" + ""
                + "En este apartado especial seras capaz de asignar espacios disponibles a empleados y modificar ajustes. \nPor favor selecciona la opcion que deseas realizar\n";

        JLabel titulo = new JLabel("<html>" + tituloCine.replace("\n", "<br>") + "<html>");
                        titulo.setForeground(new Color(255, 215, 0));

        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setVerticalAlignment(SwingConstants.CENTER);

        panelCSS.add(titulo);

        panelCSS.add(titulo);

        JButton buttonA = new JButton("Crear Reservacion");
        JButton buttonM = new JButton("Modificar Informacion");

        JButton[] buttonsCine = {buttonA, buttonM};

        setButtons(buttonsCine);

        panelCSI.add(buttonA);
        panelCSI.add(buttonM);

        panelCS.add(panelCSS, BorderLayout.CENTER);
        panelCS.add(panelCSI, BorderLayout.SOUTH);

        panelCentral.add(panelCS, BorderLayout.NORTH);

        panelsSize(firstPanel, secondPanel, thirdPanel);

        buttonA.addActionListener((ActionEvent e1) -> {

            panelCC.removeAll();
            firstPanel.removeAll();
            

            panelsSize(firstPanel, secondPanel, thirdPanel);

            firstPanel.setPreferredSize(new Dimension(600, 150));
            secondPanel.setPreferredSize(new Dimension(450, 300));
            secondPanel.setBackground(new Color(0, 0, 0, 0));
            thirdPanel.setPreferredSize(new Dimension(450, 300));
            thirdPanel.setBackground(new Color(0, 0, 0, 0));

            JLabel inputID = new JLabel("Introduzca el ID del empleado: ");
            JTextField textFieldOne = new JTextField(25);
            JLabel inputSpot = new JLabel("Indique el spot que desea reservar: ");
            JTextField textFieldTwo = new JTextField(25);
            JButton confirmationButton = new JButton("Actualizar");
            JButton[] bConfirmation = {confirmationButton};
            setButtons(bConfirmation);

            firstPanel.add(inputID);
            firstPanel.add(textFieldOne);
            firstPanel.add(inputSpot);
            firstPanel.add(textFieldTwo);
            firstPanel.add(confirmationButton);

            String preview = sala.view();

            JLabel movieTitle = new JLabel(sala.movieOne);
            JLabel spots = new JLabel("<html>" + preview.replace("\n", "<br>") + "<html>");

            spots.setFont(new Font("Arial", Font.PLAIN, 18));
            movieTitle.setFont(new Font("Arial", Font.PLAIN, 18));
            movieTitle.setPreferredSize(new Dimension(850, 30));
            movieTitle.setHorizontalAlignment(SwingConstants.CENTER);

            secondPanel.add(movieTitle);
            secondPanel.add(spots);

            panelCC.add(firstPanel);
            panelCC.add(secondPanel);
            panelCC.add(thirdPanel);

            panelCentral.add(panelCC);

            confirmationButton.addActionListener((ActionEvent e2) -> {

                secondPanel.removeAll();
                thirdPanel.removeAll();

                String textoOne = textFieldOne.getText();
                String textoTwo = textFieldTwo.getText();
                sala.reservation(register, textoOne, textoTwo);
                String view = sala.reservation(register, textoOne, textoTwo);
                textFieldOne.setText("");
                textFieldTwo.setText("");

                JLabel movieTitleOne = new JLabel(sala.movieOne);
                JLabel updatedSpots = new JLabel("<html>" + view.replace("\n", "<br>") + "<html>");

                updatedSpots.setFont(new Font("Arial", Font.PLAIN, 18));
                movieTitleOne.setFont(new Font("Arial", Font.PLAIN, 18));
                movieTitleOne.setPreferredSize(new Dimension(850, 30));
                movieTitleOne.setHorizontalAlignment(SwingConstants.CENTER);

                String set = "";

                for (Vector<String> reservedList : sala.reservedList) {
                    set += reservedList.get(0) + " / " + reservedList.get(2) + "\n";
                }

                if (!(set == null)) {

                    JLabel spotsB = new JLabel("<html>" + set.replace("\n", "<br>") + "<html>");

                    thirdPanel.add(spotsB);
                }

                secondPanel.add(movieTitleOne);
                secondPanel.add(updatedSpots);

                panelCC.add(firstPanel);
                panelCC.add(secondPanel);
                panelCC.add(thirdPanel);

                panelCentral.add(panelCC);

                updateWindiow(frame);
            });

            updateWindiow(frame);

        });
        
        
        
        
        
        
        

        buttonM.addActionListener((ActionEvent e1) -> {

            panelCC.removeAll();
            firstPanel.removeAll();

            panelsSize(firstPanel, secondPanel, thirdPanel);

            firstPanel.setPreferredSize(new Dimension(500, 200));

            JButton movieOne = new JButton("Pelicula 1");
            JButton movieTwo = new JButton("Pelicula 2");
            JButton scheduleOne = new JButton("Horario 1");
            JButton scheduleTwo = new JButton("Horario 2");
            JButton spots = new JButton("Spots");

            String text1 = """
                                         Perfecto, estas en la seccion para la modificacion de configuraciones
                                               En este segmento lograras localizar las distintas opciones 
                                   que son disponibles de ajustar
                                   
                                         """;

            JLabel titulo1 = new JLabel("<html>" + text1.replace("\n", "<br>") + "<html>");
                            titulo.setForeground(new Color(255, 215, 0));

            
                        sala.settingsView();


            firstPanel.add(titulo1);
            firstPanel.add(movieOne);
            firstPanel.add(movieTwo);
            firstPanel.add(scheduleOne);
            firstPanel.add(scheduleTwo);
            firstPanel.add(spots);

            JButton[] buttonsMCine = {movieOne, movieTwo, scheduleOne, scheduleTwo, spots};

            setButtons(buttonsMCine);

            panelCC.add(firstPanel);
            panelCentral.add(panelCC);

            movieOne.addActionListener((ActionEvent e2) -> {
                
                String selection = "1";

                secondPanel.removeAll();

                JLabel input = new JLabel("Introduzca el titulo de la pelicula que sera transmitida en la primer jornada: ");
                theaterOptions(secondPanel, input, panelCC, panelCentral, frame, sala, selection);            
                

            });
            movieTwo.addActionListener((ActionEvent e2) -> {
                
                String selection = "2";

                secondPanel.removeAll();

                JLabel input = new JLabel("Introduzca el titulo de la pelicula que sera transmitida en la segunda jornada: ");

                theaterOptions(secondPanel, input, panelCC, panelCentral, frame, sala, selection);            

            });
            scheduleOne.addActionListener((ActionEvent e2) -> {

                String selection = "3";

                secondPanel.removeAll();

                JLabel input = new JLabel("Introduzca el nuevo horario para la primer jornada de pelicula: ");
                theaterOptions(secondPanel, input, panelCC, panelCentral, frame, sala, selection);            

            });
            scheduleTwo.addActionListener((ActionEvent e2) -> {

                String selection = "4";

                secondPanel.removeAll();

                JLabel input = new JLabel("Introduzca el nuevo horario para la segunda jornada de pelicula: ");
                theaterOptions(secondPanel, input, panelCC, panelCentral, frame, sala, selection);            

            });
            spots.addActionListener((ActionEvent e2) -> {

                String selection = "5";

                secondPanel.removeAll();

                JLabel input = new JLabel("Introduzca la cantidad de spots disponibles para la sala (Maximo 30)");
                theaterOptions(secondPanel, input, panelCC, panelCentral, frame, sala, selection);            

            });
            updateWindiow(frame);

        });
    }
    
  
}
