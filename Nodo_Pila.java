
package banco;

public class Nodo_Pila {
    int Taquilla;
    String Transaccion;
    double Monto;
    Nodo_Pila sig;
    
    Nodo_Pila(){
        this.Taquilla = 0;
        this.Transaccion = "";
        this.Monto = 0;
        this.sig = null;
    }
}
