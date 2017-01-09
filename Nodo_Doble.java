
package banco;

public class Nodo_Doble {
    String Nombre;
    int Numero;
    String Transaccion;
    double Monto;
    double Tiempo;
    Nodo_Doble sig;
    Nodo_Doble ant;

    void Nodo_Doble(){
        this.Nombre = "";
        this.Numero = 0;
        this.Transaccion = "";
        this.Monto = 0;
        this.Tiempo = 0;
        this.ant = null;
        this.sig = null;
    }
}
