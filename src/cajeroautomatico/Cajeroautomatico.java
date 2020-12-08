package cajeroautomatico;
import javax.swing.JOptionPane;


public class Cajeroautomatico {

    public static void main(String[] args) {
      
       int saldo=90000; 
       int saldod=500;
        String ax;
        String tranfe = "";
       
        
        int op=0;
        String usuario = "Luis Gonzalez",contraseña;
        String Pass="1234"; 
        
        
      JOptionPane.showMessageDialog(null,"","BIENVENIDO AL BANCO CFPN 36",JOptionPane.INFORMATION_MESSAGE);
        
      contraseña = JOptionPane.showInputDialog("Bienvenido  " + usuario + " Ingrese su contraseña ");
       
        
        if(contraseña.equals(Pass)){
           
        do{
         
          ax = JOptionPane.showInputDialog(null, "1. Saldo \n 2. Transferir \n 3. Retirar \n 4. Cambiar Clave \n 5. Salir");
           
                op = Integer.parseInt(ax);
                switch(op){
                    case 1:
                         verSal(saldo,saldod);
                         break; 
                    case 2:
                         saldo = transDinero(saldo);
                         break;
                    case 3:
                        saldo = retirarDinero(saldo);
                         break;
                    case 4:
                      
                         break;
                    case 5: 
                          JOptionPane.showMessageDialog(null,"","GRACIAS POR VENIR AL BANCO CFPN 36",JOptionPane.INFORMATION_MESSAGE,logo);
                         break;
                }    
           
        }while(op !=5);       
                        
            }else {
            JOptionPane.showMessageDialog(null,"La contraseña es incorrecta vuelva a ingresarla ","Error credenciales",JOptionPane.ERROR_MESSAGE);
        
        }
        
                 
    }
    
   
     private static void ticketTransf(int saldo, int montoTransf, String CBU) {
            
            System.out.println("========BANCO CFP N°36========");
            System.out.println("==Transferencia a CBU:========");
            System.out.println("======="+CBU+"=======");
            System.out.println("==Monto Transferido:==========");
            System.out.println("==$"+montoTransf+"=====================");
            System.out.println("==Saldo Restante:=============");
            System.out.println("==$"+saldo+"======================");
           
        }

    private static void verSal(int saldo,int saldod ) {
         
        System.out.println("=======     BANCO CFP N°36     ========");
        System.out.println("===  Saldo de Cuentas =================");
        System.out.println("===  Cuenta corriente en pesos     ====");
        System.out.println("==== $ " +saldo+ "=====================");
        System.out.println("===  Cuenta corriente en dolares ======");
        System.out.println("===== $ " +saldod+ "===================");
        
    }
  
        private static void ticketExt(int saldo, int montoExt) {
            System.out.println("========BANCO CFP N°36========");
            System.out.println("==Extracción realizada por:===");
            System.out.println("==$"+montoExt+"=====================");
            System.out.println("==Saldo Restante:=============");
            System.out.println("==$"+saldo+"======================");
            System.out.println("==============================");
        }
        
        
    private static int transDinero(int saldo) {
        
        int montoTransf=0; boolean CBUvalido=false; String CBU;
       
        do {
            CBU = JOptionPane.showInputDialog(null, "Ingrese el CBU de la cuenta a transferir:");
            
            if (CBU.length()==2) {
                CBUvalido = true;
               }else {
            JOptionPane.showMessageDialog(null,"No cumple con los 16 digitos ","Error CBU",JOptionPane.ERROR_MESSAGE);
             }
        }  while (CBUvalido==false);
        
          
        do {
            montoTransf = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el monto a transferir a CBU:\n"+CBU));
           if (saldo<montoTransf){
            JOptionPane.showMessageDialog(null,"No debe superar el SALDO actual que es de $"+ saldo ,"Supera al Saldo",JOptionPane.ERROR_MESSAGE);
          }
        }  while ((saldo<=montoTransf)&&(montoTransf>0));
        
        
        saldo = saldo - montoTransf;
      ticketTransf(saldo,montoTransf,CBU);
        return saldo;
    }
    private static int retirarDinero(int saldo) {
        int montoTransf=0; boolean CBUvalido=false; String CBU;
        int montoExt=0;
        do {
            int seleccion = JOptionPane.showOptionDialog(null,"Sel/*eccione el monto a retirar","Retiro de Efectivo",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,Icon, 
            new Object []{"200", "500","1000","Otro Importe"},"100" );  
            switch (seleccion) {
                case 0:
                    montoExt=200;
                    break;
                case 1:
                    montoExt=500;
                    break;
                case 2:
                    montoExt=1000;
                    break;
                case 3:
                    montoExt=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el monto a Retirar:","Ingrese el monto aquí."));
                    break;
            }
            if (montoExt>saldo) {
                JOptionPane.showMessageDialog(null,"Por favor, ingrese un monto valido menor a su saldo.\nSu saldo actual es de: $"+saldo,"Retirar Dinero",JOptionPane.WARNING_MESSAGE);
            }
        } while ((montoExt>=saldo)||(montoExt<0));
        saldo = saldo - montoExt;
        ticketExt(saldo,montoExt);
          
        return saldo;

}
        
}
        
        
        


