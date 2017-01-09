
package banco;

import java.io.*;

public class Banco {

    public static void main(String[] args)  throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        
        String Nombre = "", Transaccion = "", Cerrar, Operacion, LD1 = "", LD2 = "", LD3 = "", LD4 = "", LG = "";
        int Numero_C = 0, Cont1 = 0, Cont2 = 0, Cont3 = 0, Cont4 = 0, ApilarEn = 0;
        double Tiempo = 0, Monto = 0, MontoD1 = 0, MontoD2 = 0, MontoD3 = 0, MontoR1 = 0, MontoR2 = 0, MontoR3 = 0, MontoD4 = 0, MontoR4 = 0;
        
        Taquillas Taquillas = new Taquillas();
        Taquillas.CrearTq();
        
        Pila_Taquilla PT1 = new Pila_Taquilla();
        Pila_Taquilla PT2 = new Pila_Taquilla();
        Pila_Taquilla PT3 = new Pila_Taquilla();
        Pila_Taquilla PT4 = new Pila_Taquilla();
        Pila_Taquilla PTT = new Pila_Taquilla();
        Pila_Taquilla PTG = new Pila_Taquilla();
        
        ListaD_Clientes Fila = new ListaD_Clientes();
        Archivo arc = new Archivo();
        
        
        try{
            System.out.println("|------------------------------------------------------------------------------------|\n"
                             + "|No hay ningun cliente registrado para ser atendido.Registe un cliente para comenzar.|\n"
                             + "|------------------------------------------------------------------------------------|\n");
            
            Cerrar = "n";
            
            while("n".equals(Cerrar)){
                System.out.println("Que desea hacer?\n1.- Registrar nuevo cliente.\n2.- Pasar cliente a taquilla.\n3.- Ninguna.");
                Operacion = br.readLine();
                

                switch(Operacion){
                    case("1"):
                        System.out.print("Ingrese el Nombre del Cliente: ");
                        Nombre = br.readLine();
                        System.out.println("Que tipo de Transaccion desea realizar? \n"
                                + "1.- Deposito.\n2.- Pago.\n3.- Consulta.\n"
                                + "4.- Retiro.\n5.- Actualizacion.");
                        Operacion = br.readLine();
                        switch(Operacion){
                            case("1"):
                                Transaccion = "Deposito";
                                System.out.println("Ingrese el monto a depositar:");
                                Monto = Integer.parseInt(br.readLine());
                                Tiempo = 2;
                                break;
                            case("2"):
                                Transaccion = "Pago";
                                Monto = 0;
                                Tiempo = 2;
                                break;
                            case("3"):
                                Transaccion = "Consulta";
                                Monto = 0;
                                Tiempo = 3.5;
                                break;
                            case("4"):
                                Transaccion = "Retiro";
                                System.out.println("Ingrese el monto a retirar:");
                                Monto = Integer.parseInt(br.readLine());
                                Tiempo = 4;
                                break;
                            case("5"):
                                Transaccion = "Actualizacion";
                                Monto = 0;
                                Tiempo = 5;
                                break;
                        }
                        Numero_C = Numero_C + 1;
                        Fila.AgregarCF(Nombre, Numero_C, Transaccion, Tiempo, Monto);
                        break;
                        
                    case("2"):
                        if(Fila.C_Apun != null){
                            Tiempo = Taquillas.T_Apun.Tiempo;
                            for(int i = 0; i < 4; i++){
                                if(Tiempo > Taquillas.T_Apun.Tiempo){
                                    Tiempo = Taquillas.T_Apun.Tiempo;
                                }
                                Taquillas.T_Apun = Taquillas.T_Apun.sig;
                            }
                            if((((Taquillas.T_Apun.Tiempo > 0) & Taquillas.T_Apun.sig.Tiempo > 0) & Taquillas.T_Apun.sig.sig.Tiempo > 0) & Taquillas.T_Apun.sig.sig.sig.Tiempo > 0){
                                for(int i = 0; i < 4; i++){
                                    Taquillas.T_Apun.Tiempo = Taquillas.T_Apun.Tiempo - Tiempo;
                                    Taquillas.T_Apun = Taquillas.T_Apun.sig;
                                }
                            }
                            while(Taquillas.T_Apun.Tiempo > 0){
                                Taquillas.T_Apun = Taquillas.T_Apun.sig;
                            }

                            Taquillas.T_Apun.Tiempo = Fila.C_Apun.Tiempo;

                            switch(Taquillas.T_Apun.NumeroTq){
                                case(1):
                                    PT1.AgregarNP(Taquillas.T_Apun.NumeroTq, Fila.C_Apun.Transaccion, Fila.C_Apun.Monto);
                                    ApilarEn = 1;
                                    break;
                                case(2):
                                    PT2.AgregarNP(Taquillas.T_Apun.NumeroTq, Fila.C_Apun.Transaccion, Fila.C_Apun.Monto);
                                    ApilarEn = 2;
                                    break;
                                case(3):
                                    PT3.AgregarNP(Taquillas.T_Apun.NumeroTq, Fila.C_Apun.Transaccion, Fila.C_Apun.Monto);
                                    ApilarEn = 3;
                                    break;
                                case(4):
                                    PT4.AgregarNP(Taquillas.T_Apun.NumeroTq, Fila.C_Apun.Transaccion, Fila.C_Apun.Monto);
                                    ApilarEn = 4;
                                    break;
                            }
                            if(Fila.C_Apun.sig != null){
                                Fila.C_Apun = Fila.C_Apun.sig;
                            }
                            else{
                                System.out.println("Ya no quedan mas clientes Registrados para ser atendidos.");
                            }
                        }
                        else{
                            System.out.println("No hay mas personas Resgitradas para ser atendidas.");
                        }
                        break;
                    case("3"):
                        System.out.println("Usted se dispone a salir del sistema.");
                        break;
                    default:
                        System.out.println("Usted introdujo una opcion invalida.");
                        break;
                }
                
                if(ApilarEn == 1){
                    while(PT1.P_Aux != null){
                        if(PT1.P_Aux.Transaccion == "Deposito"){
                            MontoD1 = MontoD1 + PT1.P_Aux.Monto;
                        }
                        else{
                            if(PT1.P_Aux.Transaccion == "Retiro"){
                                MontoR1 = MontoR1 + PT1.P_Aux.Monto;
                            }
                        }
                        Cont1++;
                        PT1.P_Aux = PT1.P_Aux.sig;
                    }
                    PT1.P_Aux = PT1.P_Apun;
                }
                
                if(ApilarEn == 2){
                    while(PT2.P_Aux != null){
                        if(PT2.P_Aux.Transaccion == "Deposito"){
                            MontoD2 = MontoD2 + PT2.P_Aux.Monto;
                        }
                        else{
                            if(PT2.P_Aux.Transaccion == "Retiro"){
                                MontoR2 = MontoR2 + PT2.P_Aux.Monto;
                            }
                        }
                        Cont2++;
                        PT2.P_Aux = PT2.P_Aux.sig;
                    }
                    PT2.P_Aux = PT2.P_Apun;
                }
                
                if(ApilarEn == 3){
                    while(PT3.P_Aux != null){
                        if(PT3.P_Aux.Transaccion == "Deposito"){
                            MontoD3 = MontoD3 + PT3.P_Aux.Monto;
                        }
                        else{
                            if(PT3.P_Aux.Transaccion == "Retiro"){
                                MontoR3 = MontoR3 + PT3.P_Aux.Monto;
                            }
                        }
                        Cont3++;
                        PT3.P_Aux = PT3.P_Aux.sig;
                    }
                    PT3.P_Aux = PT3.P_Apun;
                }
                
                if(ApilarEn == 4){
                    while(PT4.P_Aux != null){
                        if(PT4.P_Aux.Transaccion == "Deposito"){
                            MontoD4 = MontoD4 + PT4.P_Aux.Monto;
                        }
                        else{
                            if(PT4.P_Aux.Transaccion == "Retiro"){
                                MontoR4 = MontoR4 + PT4.P_Aux.Monto;
                            }
                        }
                        Cont4++;
                        PT4.P_Aux = PT4.P_Aux.sig;
                    }
                    PT4.P_Aux = PT4.P_Apun;
                }
                ApilarEn = 0;
                arc.Guardar1(MontoD1, MontoR1, MontoD2, MontoR2, MontoD3, MontoR3, MontoD4, MontoR4, Cont1, Cont2, Cont3, Cont4);
                
                System.out.print("Desea salir del sistema? (S/N):");
                Cerrar = br.readLine();
            }
            for(int i = 1; i < 5; i++){
                switch(i){
                    case(1):
                        
                        PTT.P_Apun = null;
                        while(PT1.P_Apun != null){
                            if(PT1.P_Apun.Transaccion == "Deposito"){
                                if(PTT == null){
                                    PT1.P_Apun = PT1.P_Apun.sig;
                                    PT1.P_Aux.sig = null;
                                    PTT.P_Apun = PT1.P_Aux;
                                    PT1.P_Aux = PT1.P_Apun;
                                }
                                else{
                                    PT1.P_Apun = PT1.P_Apun.sig;
                                    PT1.P_Aux.sig = PTT.P_Apun;
                                    PTT.P_Apun = PT1.P_Aux;
                                    PT1.P_Aux = PT1.P_Apun;
                                }
                            }
                            else{
                                if(PTG.P_Apun == null){
                                    PT1.P_Apun = PT1.P_Apun.sig;
                                    PT1.P_Aux.sig = null;
                                    PTG.P_Apun = PT1.P_Aux;
                                    PT1.P_Aux = PT1.P_Apun;
                                }
                                else{
                                    PT1.P_Apun = PT1.P_Apun.sig;
                                    PT1.P_Aux.sig = PTG.P_Apun;
                                    PTG.P_Apun = PT1.P_Aux;
                                    PT1.P_Aux = PT1.P_Apun;
                                }
                            }
                        }
                        PT1.P_Apun = PTT.P_Apun;
                        PT1.P_Aux = PT1.P_Apun;
                        break;
                    case(2):
                        
                        PTT.P_Apun = null;
                        while(PT2.P_Apun != null){
                            if(PT2.P_Apun.Transaccion == "Deposito"){
                                if(PTT == null){
                                    PT2.P_Apun = PT2.P_Apun.sig;
                                    PT2.P_Aux.sig = null;
                                    PTT.P_Apun = PT2.P_Aux;
                                    PT2.P_Aux = PT2.P_Apun;
                                }
                                else{
                                    PT2.P_Apun = PT2.P_Apun.sig;
                                    PT2.P_Aux.sig = PTT.P_Apun;
                                    PTT.P_Apun = PT2.P_Aux;
                                    PT2.P_Aux = PT2.P_Apun;
                                }
                            }
                            else{
                                if(PTG.P_Apun == null){
                                    PT2.P_Apun = PT2.P_Apun.sig;
                                    PT2.P_Aux.sig = null;
                                    PTG.P_Apun = PT2.P_Aux;
                                    PT2.P_Aux = PT2.P_Apun;
                                }
                                else{
                                    PT2.P_Apun = PT2.P_Apun.sig;
                                    PT2.P_Aux.sig = PTG.P_Apun;
                                    PTG.P_Apun = PT2.P_Aux;
                                    PT2.P_Aux = PT2.P_Apun;
                                }
                            }
                        }
                        PT2.P_Apun = PTT.P_Apun;
                        PT2.P_Aux = PT2.P_Apun;
                        break;
                    case(3):
                        
                        PTT.P_Apun = null;
                        while(PT3.P_Apun != null){
                            if(PT3.P_Apun.Transaccion == "Deposito"){
                                if(PTT == null){
                                    PT3.P_Apun = PT3.P_Apun.sig;
                                    PT3.P_Aux.sig = null;
                                    PTT.P_Apun = PT3.P_Aux;
                                    PT3.P_Aux = PT3.P_Apun;
                                }
                                else{
                                    PT3.P_Apun = PT3.P_Apun.sig;
                                    PT3.P_Aux.sig = PTT.P_Apun;
                                    PTT.P_Apun = PT3.P_Aux;
                                    PT3.P_Aux = PT3.P_Apun;
                                }
                            }
                            else{
                                if(PTG.P_Apun == null){
                                    PT3.P_Apun = PT3.P_Apun.sig;
                                    PT3.P_Aux.sig = null;
                                    PTG.P_Apun = PT3.P_Aux;
                                    PT3.P_Aux = PT3.P_Apun;
                                }
                                else{
                                    PT3.P_Apun = PT3.P_Apun.sig;
                                    PT3.P_Aux.sig = PTG.P_Apun;
                                    PTG.P_Apun = PT3.P_Aux;
                                    PT3.P_Aux = PT3.P_Apun;
                                }
                            }
                        }
                        PT3.P_Apun = PTT.P_Apun;
                        PT3.P_Aux = PT3.P_Apun;
                        break;
                    case(4):
                        
                        PTT.P_Apun = null;
                        while(PT4.P_Apun != null){
                            if(PT4.P_Apun.Transaccion == "Deposito"){
                                if(PTT == null){
                                    PT4.P_Apun = PT4.P_Apun.sig;
                                    PT4.P_Aux.sig = null;
                                    PTT.P_Apun = PT4.P_Aux;
                                    PT4.P_Aux = PT4.P_Apun;
                                }
                                else{
                                    PT4.P_Apun = PT4.P_Apun.sig;
                                    PT4.P_Aux.sig = PTT.P_Apun;
                                    PTT.P_Apun = PT4.P_Aux;
                                    PT4.P_Aux = PT4.P_Apun;
                                }
                            }
                            else{
                                if(PTG.P_Apun == null){
                                    PT4.P_Apun = PT4.P_Apun.sig;
                                    PT4.P_Aux.sig = null;
                                    PTG.P_Apun = PT4.P_Aux;
                                    PT4.P_Aux = PT4.P_Apun;
                                }
                                else{
                                    PT4.P_Apun = PT4.P_Apun.sig;
                                    PT4.P_Aux.sig = PTG.P_Apun;
                                    PTG.P_Apun = PT4.P_Aux;
                                    PT4.P_Aux = PT4.P_Apun;
                                }
                            }
                        }
                        PT4.P_Apun = PTT.P_Apun;
                        PT4.P_Aux = PT4.P_Apun;
                        break;
                }    
            }
            
            while(PT1.P_Apun != null){
                LD1 = LD1 + PT1.P_Apun.Monto + "\n";

                PT1.P_Apun = PT1.P_Apun.sig;
            }

            while(PT2.P_Apun != null){
                LD2 = LD2 + PT2.P_Apun.Monto + "\n";

                PT2.P_Apun = PT2.P_Apun.sig;
            }

            while(PT3.P_Apun != null){
                LD3 = LD3 + PT3.P_Apun.Monto + "\n";

                PT3.P_Apun = PT3.P_Apun.sig;
            }

            while(PT4.P_Apun != null){
                LD4 = LD4 + PT4.P_Apun.Monto + "\n";

                PT4.P_Apun = PT4.P_Apun.sig;
            }

            while(PTG.P_Apun != null){
                LG = LG + PTG.P_Apun.Transaccion + "\n";

                PTG.P_Apun = PTG.P_Apun.sig;
            }
            
            arc.Guardar2(LD1, LD2, LD3, LD4, LG);
            
            arc.Crear();
            
            System.out.println("|-------------------------------------------------|\n"
                             + "|    Los Siguientes clientes no fueron atendidos: |\n"
                             + "|-------------------------------------------------|");
            if(Fila.C_Apun != null){
                while(Fila.C_Apun != null){
                  System.out.print("|   " + Fila.C_Apun.Nombre + "\n");
                    Fila.C_Apun = Fila.C_Apun.sig;
                }
            }
            else{
                if(Fila.C_Apun != null){
                    if((Fila.C_Apun.sig == null)&Fila.C_Apun.ant == null){
                        System.out.println("El unico Cliente que se registro no fue atendido");
                    }
                    else{
                        System.out.println("|   Todos los clientes fueron atendidos.");
                    }
                }
            }
            System.out.println("|-------------------------------------------------|");
        }
        catch(Exception e){
            System.out.println("Se produjo un error de tipo" + e + ". Por favor vuelva a intentarlo.");
        }
    }
}
