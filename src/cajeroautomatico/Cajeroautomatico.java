package cajeroautomatico;
import javax.swing.JOptionPane;


public class Cajeroautomatico {

    
    public static void main(String[] args) {
        String usuario="luis",contraseña;
        String pass="1234";
        int saldo=90000;
        
        usuario = JOptionPane.showInputDialog("Ingrese usuario:");
       contraseña =JOptionPane.showInputDialog("Ingrese contraseña: ");
       
       if(contraseña.equals(pass)){
           
           JOptionPane.showMessageDialog(null,"","BIENVENIDO AL BANCO CFPN 36",JOptionPane.INFORMATION_MESSAGE);
       }
       int seleccion = JOptionPane.showOptionDialog(null,"Seleccione una Opción","menu",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[]{"saldo","transferir","retirar","clave","salir"},"exit");
       
       
       switch (seleccion){
            case 1:
                Consultasaldo(saldo);
                break;
            case 2:
                JOptionPane.showInputDialog(null, "trasferir");
                break;
            case 3:
                JOptionPane.showInputDialog(null, "retirar");
                break;
            case 4:
                JOptionPane.showInputDialog(null, "clave");
                break;
            case 5:
                JOptionPane.showInputDialog(null, "salir");
                break;

       }
       else{
           JOptionPane.showMessageDialog(null,"La contraseña es incorrecta vuelva a ingresarla ","Error credenciales",JOptionPane.ERROR_MESSAGE);
       }
       
        public static void Consultasaldo(int saldo){
           
        System.out.println("=======================================");
        System.out.println("=======     BANCO CFP N°36     ========");
        System.out.println("=======================================");
        System.out.println("===  Saldo de Cuentas =================");
        System.out.println("=======================================");
        System.out.println("===  Cuenta corriente en pesos     ====");
        System.out.println("=======================================");
        System.out.println("==== $ " +saldo+ "=====================");
       
             }
        
        public static int transDinero(int saldo) {
        //Declaracion de Variables
        int montoTrans=0; 
        boolean CBUvalido=false; 
        String CBU;
       
        
        while (CBUvalido==false);
        
  CBU = JOptionPane.showInputDialog(null, "Ingresar CBU de la cuenta a transferir:","Ingrese el CBU aquí.");
            
        if (CBU.length()==22) {
            CBUvalido = true;
            }
        
        
        montoTrans = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el monto a transferir a CBU:\n"+CBU,"Ingrese el monto aquí."));
        while ((saldo<=montoTrans)&&(montoTrans>0));
        
        saldo = saldo - montoTrans;
        System.out.println(saldo+" | "+montoTrans);
        ticketTransf(saldo,montoTrans,CBU);
        return saldo;
    }
    
        public static void ticketTransf(int saldo, int montoTrans, String CBU) {
            System.out.println("========BANCO CFP N°36========");
            System.out.println("==Transferencia a CBU:========");
            System.out.println("======="+CBU+"=======");
            System.out.println("==============================");
            System.out.println("==Monto Transferido:==========");
            System.out.println("==$"+montoTrans+"=====================");
            System.out.println("==Saldo Restante:=============");
            System.out.println("==$"+saldo+"======================");
            System.out.println("==============================");
        }
    
 }
}


