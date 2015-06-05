
package HCRadiologia;
import javax.swing.JOptionPane;

/**
 * UNIVERSIDAD DE CUNDINAMARCA
 * Profesor Jorge Páramo Fonseca
 * HCRadiologia
 * @author Glo System
 * @version 1.0
 * @created 20-abr-2015 
 * 
 * Esta clase tiene por fin manejar el mapeo de la tabla tb_datos_contacto
 */


public class DatosContacto {

        private int intIdDatoContacto;
	private int intPersonaDatoContacto;
	private int intEpsDatoContacto;
        private String strDatoContacto = new String();
	private int intTipoDatoContacto;
	private short shPrioridadDatoContacto;
        private byte byteVigenciaDatoContacto;
        private Conectar conMiconexion;

//---------------------------------------------------
//Constructores
//--------------------------------------------------
public DatosContacto(){
            
	}
public DatosContacto(int cIntIdDatoContacto){
            
	}
public DatosContacto( int cIntIdDatoContacto, int cIntEpsDatoContacto, String cStrDatoContacto){
            intIdDatoContacto=cIntIdDatoContacto;
            intEpsDatoContacto=cIntEpsDatoContacto;
            strDatoContacto=cStrDatoContacto;
            
	}
//---------------------------------------------------
//Get - Set
//--------------------------------------------------
public int getIntIdDatoContacto(){
		return intIdDatoContacto ;
	}

public int getIntPersonaDatoContacto(){
		return intPersonaDatoContacto ;
	}
public void setIntPersonaDatoContacto(int  newVal){
		intPersonaDatoContacto = newVal;
	}

public int getIntEpsDatoContacto(){
		return intEpsDatoContacto ;
	}
public void setIntEpsDatoContacto(int  newVal){
		intEpsDatoContacto = newVal;
	}

public String getStrDatoContacto(){
		return strDatoContacto ;
	}
public void setStrDatoContacto(String  newVal){
		strDatoContacto = newVal;
	}

public int getIntTipoDatoContacto(){
		return intTipoDatoContacto ;
	}
public void setIntTipoDatoContacto(int  newVal){
		intTipoDatoContacto = newVal;
	}
 
public short getShPrioridadDatoContacto(){
		return shPrioridadDatoContacto ;
	}
public void setShPrioridadDatoContacto(short  newVal){
		intTipoDatoContacto = newVal;
	}

public byte getByteVigenciaDatoContacto(){
            
		return byteVigenciaDatoContacto;
	}
public void setByteVigenciaDatoContacto(byte newVal){
		byteVigenciaDatoContacto = newVal;
	}
//---------------------------------------------------
//CRUD
//--------------------------------------------------
	public void crudCrearDatosPersona(int intCPersonaDatoContacto, String strCDatoContacto, int intCTipoDatoContacto, int shCPrioridadDatoContacto, int byteCVigenciaDatoContacto){
        
            conMiconexion = new Conectar();
            int intAux;          
            intAux = conMiconexion.queryUpdate ("INSERT INTO `tb_datos_contacto`(`persona_dato_contacto`, `dato_contacto`, `tipo_dato_contacto`, `prioridad_dato_contacto`, `vigencia_dato_contacto`) VALUES(" +
                    intCPersonaDatoContacto +",'"+ strCDatoContacto + "',"+ intCTipoDatoContacto + "," + shCPrioridadDatoContacto +","+ byteCVigenciaDatoContacto +");");
            
            String strMensaje = "Se creo con éxito";
            JOptionPane.showMessageDialog (null, strMensaje,  "CREAR", 2);   
         }

        public void crudCrearDatosEps(int  intCEpsDatoContacto, String strCDatoContacto, int intCTipoDatoContacto, int shCPrioridadDatoContacto, int byteCVigenciaDatoContacto){
        
            conMiconexion = new Conectar();
            int intAux;          
            intAux = conMiconexion.queryUpdate ("INSERT INTO `tb_datos_contacto` (`eps_dato_contacto`, `dato_contacto`, `tipo_dato_contacto`, `prioridad_dato_contacto`, `vigencia_dato_contacto`) "
                    + "VALUES(" +intCEpsDatoContacto +",'" + strCDatoContacto + "',"+ intCTipoDatoContacto + "," + shCPrioridadDatoContacto +","+ byteCVigenciaDatoContacto +");");
            
            String strMensaje = "Se creo con éxito";
            JOptionPane.showMessageDialog (null, strMensaje,  "CREAR", 2);   
         }

        public void crudMostrarDatosContacto(int intCIdDatoContacto){
            
            conMiconexion = new Conectar();
            String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta("SELECT `id_dato_contacto`, `persona_dato_contacto`, `eps_dato_contacto`, `dato_contacto`, `tipo_dato_contacto` FROM `tb_datos_contacto` WHERE `cod_persona` = " + intCIdDatoContacto +  ";")); 
           
            intIdDatoContacto =Integer.parseInt(strReg[0][0]);
            intPersonaDatoContacto =Integer.parseInt(strReg[0][1]);
            intEpsDatoContacto =Integer.parseInt(strReg[0][2]);
            strDatoContacto =strReg[0][3];
            intTipoDatoContacto =Integer.parseInt(strReg[0][4]);
            
	}
        
        public void crudActualizarDatosContactoPersona(int intCIdDatoContacto, int intCPersonaDatoContacto, String strCDatoContacto, int intCTipoDatoContacto, int intCPrioridadDatoContacto, int intCVigenciaDatoContacto){

           conMiconexion = new Conectar();
	   String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta("SELECT `id_dato_contacto`, `persona_dato_contacto`, `eps_dato_contacto`, `dato_contacto`, `tipo_dato_contacto`, `prioridad_dato_contacto`, `vigencia_dato_contacto` FROM `tb_datos_contacto` WHERE `id_dato_contacto` =" + intCIdDatoContacto +  ";"));
	   if(strReg[0][0] != null)
	   {
               conMiconexion.queryUpdate("UPDATE `tb_datos_contacto` SET `persona_dato_contacto` = " + intCPersonaDatoContacto+" , `dato_contacto` = '" +strCDatoContacto+"' ,`tipo_dato_contacto` =" +intCTipoDatoContacto+" ,`prioridad_dato_contacto` =" + intCPrioridadDatoContacto +" ,`vigencia_dato_contacto` =" + intCVigenciaDatoContacto +" WHERE `id_dato_contacto` = " + intCIdDatoContacto + ";");                  
               
               
               intIdDatoContacto = intCIdDatoContacto;
               intPersonaDatoContacto = intCPersonaDatoContacto;
               strDatoContacto = strCDatoContacto;
               intTipoDatoContacto = intCTipoDatoContacto;
               intCPrioridadDatoContacto = (int)shPrioridadDatoContacto;
               intCVigenciaDatoContacto = ( byteVigenciaDatoContacto<< 24) >>> 24;
               
               String strMensaje = "Se modifico con éxito";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR ", 2);
	   }
	   else
	   {
               String strMensaje = "No se pudo modificar ";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR ", 0);

	   }
            
	}

        public void crudActualizarDatosContactoEps(int intCIdDatoContacto, int  intCEpsDatoContacto, String strCDatoContacto, int intCTipoDatoContacto, int intCPrioridadDatoContacto, int intCVigenciaDatoContacto){

           conMiconexion = new Conectar();
	   String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta("SELECT `id_dato_contacto`, `persona_dato_contacto`, `eps_dato_contacto`, `dato_contacto`, `tipo_dato_contacto`, `prioridad_dato_contacto`, `vigencia_dato_contacto` FROM `tb_datos_contacto` WHERE `id_dato_contacto`=" + intCIdDatoContacto +  ";"));
	   if(strReg[0][0] != null)
	   {
               conMiconexion.queryUpdate("UPDATE `tb_datos_contacto` SET `eps_dato_contacto` = "+ intCEpsDatoContacto+" ,`dato_contacto` = '" +strCDatoContacto+"' ,`tipo_dato_contacto` =" +intCTipoDatoContacto+" ,`prioridad_dato_contacto` =" + intCPrioridadDatoContacto +" ,`vigencia_dato_contacto` =" + intCVigenciaDatoContacto +" WHERE `id_dato_contacto` = " + intCIdDatoContacto + ";");                  
               
               
               intIdDatoContacto = intCIdDatoContacto;
               intEpsDatoContacto = intCEpsDatoContacto;
               strDatoContacto = strCDatoContacto;
               intTipoDatoContacto = intCTipoDatoContacto;
               intCPrioridadDatoContacto = (int)shPrioridadDatoContacto;
               intCVigenciaDatoContacto = ( byteVigenciaDatoContacto<< 24) >>> 24;
               
               String strMensaje = "Se modifico con éxito";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR ", 2);
	   }
	   else
	   {
               String strMensaje = "No se pudo modificar ";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR ", 0);

	   }
            
        } 
           public DatosContacto[] crudListaDatosContactoEps(int cIdEps){
            int intCont;
            int intTama =0;
            conMiconexion = new Conectar();
            
            try
            {
                String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta( 
                                                "SELECT COUNT(`eps_dato_contacto`) AS TAL FROM `tb_datos_contacto` WHERE `eps_dato_contacto` = "+cIdEps+";"));

                intTama = Integer.parseInt(strReg[0][0]);
                
                
                strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta(
                        "SELECT `id_dato_contacto`,`eps_dato_contacto`,`dato_contacto` FROM `tb_datos_contacto` WHERE `eps_dato_contacto` =" + cIdEps+" ORDER BY id_dato_contacto ;"));                

                DatosContacto [] Lista = new DatosContacto[intTama];

                for (intCont = 0; intCont <(intTama); intCont++)
                {
                    DatosContacto TipAux = new DatosContacto( Integer.parseInt(strReg[intCont][0]), 
                            Integer.parseInt(strReg[intCont][1]),strReg[intCont][2]);
                                        
                    Lista[intCont] = TipAux;

                }//System.out.print("\n el tamaño es:" + intTama + "\n");
                return Lista;
                
            }
            catch(Exception ex)
            {
                String strMensaje = "Se presento un problema con la lista de Tipo Documento 1";
                JOptionPane.showMessageDialog(null, strMensaje,  "PROBLEMA CON LA LISTA", 0);
                System.out.print(ex);
                return null;
            }	
	}
//---------------------------------------------------
//Main
//--------------------------------------------------
    public static void main(String[] args) {
        
            //prueba para la conexi�n
        Conectar CC = new Conectar();
        //String R[][] = CC.resultadoQuery(CC.queryConsulta("SELECT `id_dato_contacto`, `persona_dato_contacto`, `eps_dato_contacto`, `dato_contacto`, `tipo_dato_contacto`, `prioridad_dato_contacto`, `vigencia_dato_contacto` FROM `tb_datos_contacto` WHERE 1;"));
        //System.out.print("\n Persona: " + R[0][0] + " - " + R[0][1] + " - " + R[0][2]+ " - " + R[0][3] + " - " + R[0][4] + " - " + R[0][5] + " - " + R[0][6] + " - " + R[0][7] +"\n");
        
        DatosContacto miObjeto = new DatosContacto();
	//-------------------------------------------------------------------------------
            //Prueba clase DatosContacto
        //Mostrar DatosContacto
        //miObjeto.crudMostrarDatosContacto(1);
        //System.out.print("\n-Registro: " + miObjeto.getIntIdDatoContacto() +" - "+ miObjeto.getIntPersonaDatoContacto() + " - " + miObjeto.getIntEpsDatoContacto() + " - " + miObjeto.getStrDatoContacto() +" - " +  miObjeto.getIntTipoDatoContacto() +" - " + miObjeto.getShPrioridadDatoContacto() +" - " + miObjeto.getByteVigenciaDatoContacto() + "\n");
     
        //Prueba para modificar

//        miObjeto.crudActualizarDatosContactoPersona(2,1,"564556",1,1,1);
//        System.out.print("\n Registro modificado es: " + miObjeto.getIntIdDatoContacto() +" - "+ miObjeto.getIntPersonaDatoContacto() + " - " + miObjeto.getStrDatoContacto() +" - " +  miObjeto.getIntTipoDatoContacto() +" - " + miObjeto.getShPrioridadDatoContacto() +" - " + miObjeto.getByteVigenciaDatoContacto() + "\n");
//        
//        miObjeto.crudActualizarDatosContactoEps(3,1,"56094322",1,1,1);
//        System.out.print("\n Registro modificado es: " + miObjeto.getIntIdDatoContacto() + " - " + miObjeto.getIntEpsDatoContacto() + " - " + miObjeto.getStrDatoContacto() +" - " +  miObjeto.getIntTipoDatoContacto() +" - " + miObjeto.getShPrioridadDatoContacto() +" - " + miObjeto.getByteVigenciaDatoContacto() + "\n");
//     
        
        
// Crear DatosContacto
       // miObjeto.crudCrearDatosPersona(2,"676455",1,1,1 ); 
        //miObjeto.crudCrearDatosEps(2,"456354",1,1,1); 
        
     DatosContacto[] lisTabla = miObjeto.crudListaDatosContactoEps(1);
        
        System.out.print("\n\t\tLa lista de datos es: \n" );
        
        //Bucle para listar los colores del vector
        for(int intCont=0; intCont < lisTabla.length; intCont++)
        {
            System.out.print("\n" + lisTabla[intCont].getIntIdDatoContacto()+" - "+lisTabla[intCont].getIntEpsDatoContacto()+" - "+lisTabla[intCont].getStrDatoContacto());
        }
     
    }
    
}
