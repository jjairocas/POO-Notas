package NotasUI;
import java.util.*;
public class CalculoNotas {

    Vector <Double>notasAlumnos;        //Atributo

    public CalculoNotas(){
        notasAlumnos=new Vector<>();        //Constructor

    }

    public int Tamano(){
        int n=notasAlumnos.size();
        return n;
    }

    public void  adiccionarNotas(double Alumno){
        notasAlumnos.add(Alumno);

    }

    public double Promedio(){
        double Prom=0;
        for (int i = 0; i < notasAlumnos.size(); i++) {

            Prom= Prom+notasAlumnos.get(i);

        }
        double Promedio=(Prom/notasAlumnos.size());
        return Promedio;

    }
    public double DesviacionEstandar(){
        double Desviacion=0;
        double PromedioDesv=Promedio();

        for (int i = 0; i < notasAlumnos.size(); i++) {

            Desviacion += (Math.pow((notasAlumnos.get(i)-PromedioDesv),2));

        }
        double DesviacionStandard=(Math.sqrt(Desviacion/ notasAlumnos.size()));
        return DesviacionStandard;

    }

    public double notaMayor(){
        double Mayorque=notasAlumnos.get(0);
        for (int i = 0; i < notasAlumnos.size(); i++) {
            if(notasAlumnos.get(i)>Mayorque){
                Mayorque=notasAlumnos.get(i);

            }

        }
        return Mayorque;

    }
    public double notaMenor(){
        double Menorque=notasAlumnos.get(0);
        for (int i = 0; i < notasAlumnos.size(); i++) {
            if(notasAlumnos.get(i)<Menorque){
                Menorque=notasAlumnos.get(i);

            }

        }
        return Menorque;
    }

    public void borrarNotas(){
        notasAlumnos.removeAllElements();

    }
    public boolean notaMenor10(){
        double NotaMenor10=0;
        boolean NotaMenorque10=true;

        NotaMenor10=notaMayor();
        if(NotaMenor10 >=5.1){
            NotaMenorque10=false;

        }
        return NotaMenorque10;
    }
    public boolean notaMayor0(){

        double NotaMayor0;
        boolean NotaMayorque0=false;

        NotaMayor0=notaMenor();
        if(NotaMayor0 >=0) {
            NotaMayorque0 = true;
        }
        return NotaMayorque0;

    }

}
