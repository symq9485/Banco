
package banco;

import java.io.*;

public class Archivo {
    
    double MontoD1, MontoR1, MontoD2, MontoR2, MontoD3, MontoR3, MontoD4, MontoR4;
    int Cont1, Cont2, Cont3, Cont4;
    String LD1, LD2, LD3, LD4, LG;
    Pila_Taquilla P_Taquilla1, P_Taquilla2, P_Taquilla3, P_Taquilla4, General;
    
    void Guardar1 (double MontoD1, double MontoR1, double MontoD2, double MontoR2, double MontoD3, double MontoR3, double MontoD4, double MontoR4, int Cont1, int Cont2, int Cont3, int Cont4) throws IOException{
        this.MontoD1 = MontoD1;
        this.MontoD2 = MontoD2;
        this.MontoD3 = MontoD3;
        this.MontoD4 = MontoD4;
        this.MontoR1 = MontoR1;
        this.MontoR2 = MontoR2;
        this.MontoR3 = MontoR3;
        this.MontoR4 = MontoR4;
        this.Cont1 = Cont1;
        this.Cont2 = Cont2;
        this.Cont3 = Cont3;
        this.Cont4 = Cont4;
    }
    
    void Guardar2 (String LD1, String LD2, String LD3, String LD4, String LG){
        this.LD1 = LD1;
        this.LD2 = LD2;
        this.LD3 = LD3;
        this.LD4 = LD4;
        this.LG = LG;
                
    }
    
    void Crear() throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("/home/symq9485/Proyectos/UNIMAR/Estructura_de_datos/Banco/resultados.txt", true));
        bw.newLine();
        bw.write("Taquilla No. 1.\nTansacciones realizadas: " + this.Cont1 + ".\nDepositos: " + this.MontoD1 + ".\nRetiros: " + this.MontoR1 + ".\nPila de Depositos:\n" + LD1 + "\n\n" 
                +"Taquilla No. 2.\nTansacciones realizadas: " + this.Cont2 + ".\nDepositos: " + this.MontoD2 + ".\nRetiros: " + this.MontoR2 + ".\nPila de Depositos:\n" + LD2 + "\n\n"
                +"Taquilla No. 3.\nTansacciones realizadas: " + this.Cont3 + ".\nDepositos: " + this.MontoD3 + ".\nRetiros: " + this.MontoR3 + ".\nPila de Depositos:\n" + LD3 + "\n\n"
                +"Taquilla No. 4.\nTansacciones realizadas: " + this.Cont4 + ".\nDepositos: " + this.MontoD4 + ".\nRetiros: " + this.MontoR4 + ".\nPila de Depositos:\n" + LD4 + "\n\n"
                +"Pila de Transacciones General:\n" + LG);
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
