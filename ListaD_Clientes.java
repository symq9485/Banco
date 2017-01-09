
package banco;

public class ListaD_Clientes {
    Nodo_Doble C_Apun = null;
    Nodo_Doble C_Aux = null;
    
    void AgregarCF(String Nombre, int Numero, String Transaccion, double Tiempo, double Monto){
        Nodo_Doble nodo_n = new Nodo_Doble();
        nodo_n.Nombre = Nombre;
        nodo_n.Numero = Numero;
        nodo_n.Transaccion = Transaccion;
        nodo_n.Monto = Monto;
        nodo_n.Tiempo = Tiempo;
        
        if (C_Apun == null){
            C_Apun = nodo_n;
            C_Aux = C_Apun;
        }
        else{
            C_Aux.sig = nodo_n;
            nodo_n.ant = C_Aux;
            C_Aux = C_Aux.sig;
        }
    }
}
