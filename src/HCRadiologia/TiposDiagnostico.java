
package HCRadiologia;

import javax.swing.JOptionPane;
/**
 * UNIVERSIDAD DE CUNDINAMARCA
 * Profesor Jorge Páramo Fonseca
 * HCRadiologia
 * @author Glo System
 * @version 1.0
 * @created 10-abr-2015 
 * 
 * 
 */

public class TiposDiagnostico {
private int intIdTiposDiagnostico;
	private String strTiposDiagnostico = new String();
	private Conectar conMiconexion;


	public TiposDiagnostico(){

	}

	/**
	 * 
	 * @param cIntIdTiposDiagnostico
	 * @param cStrTiposDiagnostico
	 */
	public TiposDiagnostico(int cIntIdTiposDiagnostico, String cStrTiposDiagnostico){

	}

	public int getIntIdTiposDiagnostico(){
		return intIdTiposDiagnostico;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIntIdTiposDiagnostico(int newVal){
		intIdTiposDiagnostico = newVal;
	}

	public String getStrTiposDiagnostico(){
		return strTiposDiagnostico;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStrTiposDiagnostico(String newVal){
		strTiposDiagnostico = newVal;
	}

	/**
	 * 
	 * @param strCTiposDiagnostico
	 */
	public void crudCrearTiposDiagnostico(String strCTiposDiagnostico){

            conMiconexion = new Conectar();
            
            conMiconexion.queryUpdate("INSERT INTO `ct_tipos_diagnosticos`(`tipo_diagnostico`) VALUES( '" + strCTiposDiagnostico + "');");

            String strMensaje = "Se creo el Tipo de Diagnostico con éxito";
            JOptionPane.showMessageDialog(null, strMensaje,  "CREAR TIPO DE DIAGNOSTICO", 2);  
            
	}

	/**
	 * 
	 * @param strCTiposDiagnostico
	 */
	public void crudActualizarTiposDiagnostico(int intCIdTiposDiagnostico, String strNueCTiposDiagnostico){

           conMiconexion = new Conectar();

	   String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta("SELECT `id_tipo_diagnostico`, `tipo_diagnostico` FROM `ct_tipos_diagnosticos` WHERE  id_tipo_diagnostico = " + intCIdTiposDiagnostico +  ";"));
           
	   if(strReg[0][0] != null)
	   {
                conMiconexion.queryUpdate("UPDATE ct_tipos_diagnosticos SET tipo_diagnostico =  '" + strNueCTiposDiagnostico + 
                                                    "' WHERE  id_tipo_diagnostico = " + intCIdTiposDiagnostico + ";");
                
               strTiposDiagnostico = strNueCTiposDiagnostico;
               String strMensaje = "Se modifico el Tipo de Diagnostico con éxito";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR TIPO DE DIAGNOSTICO", 2);

	   }
	   else
	   {
               String strMensaje = "No se pudo modificar el Tipo de Diagnostico";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR TIPO DE DIAGNOSTICO", 0);

	   }
            
	}

	/**
	 * 
	 * @param intCIdTiposDiagnostico
	 */
	public void crudMostrarTiposDiagnostico(int intCIdTiposDiagnostico){

            conMiconexion = new Conectar();

            String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta(
                                    "SELECT id_tipo_diagnostico, tipo_diagnostico FROM ct_tipos_diagnosticos WHERE  id_tipo_diagnostico = " + intCIdTiposDiagnostico +  ";")); 
           
            intIdTiposDiagnostico = Integer.parseInt(strReg[0][0]);
            strTiposDiagnostico = strReg[0][1];
            
	}

	public Eps[] crudListaTiposDiagnostico(){
		return null;
	}
    public static void main(String[] args) {
       
        
        
		//prueba para la conexi�n
        Conectar CC = new Conectar();
        String R[][] = CC.resultadoQuery(CC.queryConsulta("SELECT `id_tipo_diagnostico`, `tipo_diagnostico` FROM `ct_tipos_diagnosticos` WHERE `id_tipo_diagnostico`=1;"));
        System.out.print("\nEl Tipo Diagnostico es: " + R[0][0] + " - " + R[0][1] + "\n");
        

    
		//-------------------------------------------------------------------------------
  
		//Prueba clase TiposDiagnostico
    
        TiposDiagnostico miObjeto = new TiposDiagnostico();
        
        //...................................................................................
        //Prueba para modificar un Tipo Diagnostico
        miObjeto.crudActualizarTiposDiagnostico(1, "Especifico");

        System.out.print("\nEl Tipo Diagnostico modificada es: " + miObjeto.getIntIdTiposDiagnostico() + " - " + miObjeto.getStrTiposDiagnostico() + "\n");
       
        //...................................................................................
        //Prueba crear un Tipo Diagnostico
        miObjeto.crudCrearTiposDiagnostico("Generak");
   
        System.out.print("\nEl nuevo Tipo Diagnostico es: " + miObjeto.getIntIdTiposDiagnostico() + " - " + miObjeto.getStrTiposDiagnostico() + "\n\n");
           
        
         //pueba para mostrar un Tipo Diagnostico
        miObjeto.crudMostrarTiposDiagnostico(1);
        System.out.print("\nEl Tipo Diagnostico 1 es: " + miObjeto.getIntIdTiposDiagnostico() + " - " + miObjeto.getStrTiposDiagnostico() + "\n");
     
    }
    
}
