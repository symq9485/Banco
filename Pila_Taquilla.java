
package banco;

public class Pila_Taquilla {
    Nodo_Pila P_Apun = null;
    Nodo_Pila P_Aux = null;
    
    void AgregarNP(int Taquilla, String Transaccion, double Monto){
        Nodo_Pila nodo_n = new Nodo_Pila();
        nodo_n.Taquilla = Taquilla;
        nodo_n.Transaccion = Transaccion;
        nodo_n.Monto = Monto;
        
        if(P_Apun == null){
            P_Apun = nodo_n;
            P_Aux = P_Apun;
        }
        else{
            nodo_n.sig = P_Apun;
            P_Apun = nodo_n;
            P_Aux = P_Apun;
        }
    }
}
