package NotasUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotasUI extends JFrame{
    private JTextField txtNota1;
    private JTextField txtNota2;
    private JTextField txtNota3;
    private JTextField txtNota4;
    private JTextField txtNota5;
    private JButton btnCALCULAR;
    private JButton btnBORRAR;
    private JButton btnSALIR;
    private JLabel lbPromedio;
    private JLabel lbDesviacionEstandar;
    private JLabel lbMayorNota;
    private JLabel lbMenorNota;
    private JPanel MainPanel;

    public NotasUI() {
        setContentPane(MainPanel);
        setTitle("Notas Estudiantes");     //Titulo Ventana
        setSize(350, 350);      //Tamaño ventana
        setLocationRelativeTo(null);        //La ventana se posiciona en el centro
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    //El boton cerrar cierra la ventana
        //setResizable(false);                //La ventana no se puede cambiar de tamaño
        //setVisible(true); Se visualiza la ventana en la parte superior izquierda

        CalculoNotas Alumnos=new CalculoNotas();

        btnCALCULAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    Alumnos.adiccionarNotas(Double.parseDouble(txtNota1.getText()));
                    Alumnos.adiccionarNotas(Double.parseDouble(txtNota2.getText()));
                    Alumnos.adiccionarNotas(Double.parseDouble(txtNota3.getText()));
                    Alumnos.adiccionarNotas(Double.parseDouble(txtNota4.getText()));
                    Alumnos.adiccionarNotas(Double.parseDouble(txtNota5.getText()));

                    if(Alumnos.notaMenor10() == true){

                        lbPromedio.setText("PROMEDIO ="+String.valueOf(String.format("%.3f",Alumnos.Promedio())));
                        lbDesviacionEstandar.setText("DESVIACION ="+String.valueOf(String.format("%.3f",Alumnos.DesviacionEstandar())));
                        lbMayorNota.setText("NOTA MAYOR ="+String.valueOf(Alumnos.notaMayor()));
                        lbMenorNota.setText("NOTA MENOR ="+String.valueOf(Alumnos.notaMenor()));
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Las notas deben ser inferiores o iguales a 5", "Notas Incorrectas",
                                JOptionPane.ERROR_MESSAGE);

                        txtNota1.setText("");
                        txtNota2.setText("");
                        txtNota3.setText("");
                        txtNota4.setText("");
                        txtNota5.setText("");
                        Alumnos.borrarNotas();
                        System.exit(0);

                    }

                }
                catch (NumberFormatException exception){

                    JOptionPane.showMessageDialog(null, "El dato que ingresaste es incorrrecto debe ser numerico", "Datos Incorrectos",
                            JOptionPane.ERROR_MESSAGE);

                }



            }
        });
        btnBORRAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtNota1.setText("");
                txtNota2.setText("");
                txtNota3.setText("");
                txtNota4.setText("");
                txtNota5.setText("");

                lbPromedio.setText("");
                lbDesviacionEstandar.setText("");
                lbMayorNota.setText("");
                lbMenorNota.setText("");
                Alumnos.borrarNotas();

            }
        });
        btnSALIR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }
        });
    }


}
