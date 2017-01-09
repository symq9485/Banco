
package banco;

public class Taquillas {
    Nodo_Simple T_Apun = null;
    Nodo_Simple T_Aux = null;
    
    void CrearTq(){
        for( int i = 0; i < 4; i++){
            Nodo_Simple nodo_n = new Nodo_Simple();
            nodo_n.NumeroTq = i + 1;
            nodo_n.Tiempo = 0;
            if(T_Apun == null){
                T_Apun = nodo_n;
                T_Aux = T_Apun;
            }
            else{
                if(i < 3){
                    T_Aux.sig = nodo_n;
                    T_Aux = T_Aux.sig;
                }
                else{
                    T_Aux.sig = nodo_n;
                    T_Aux = T_Aux.sig;
                    T_Aux.sig = T_Apun;
                }
            }
        }
    }
}
