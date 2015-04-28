
package HCRadiologia;

import javax.swing.JOptionPane;

/**
 * @author Toshiba
 * @version 1.0
 * @created 10-abr-2015 6:54:07 PM
 */
public class TiposDatosContactos {

	private int intIdTipoDato;
	private String strTipoDato = new String();
	private Conectar conMiconexion;



	public void finalize() throws Throwable {

	}
	public TiposDatosContactos(){

	}

	/**
	 * 
	 * @param cStrTipoDato
	 * @param cintIdTipoDato
	 */
	public TiposDatosContactos(String cStrTipoDato, int cintIdTipoDato){

	}

	public int getintIdTipoDato(){
		return intIdTipoDato;
	}

	public String getStrTipoDato(){
		return strTipoDato;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStrTipoDato(String newVal){
		strTipoDato = newVal;
	}

	/**
	 * 
	 * @param cStrTipoDato
	 */
	public void crudCrearTipoDato(String cStrTipoDato){

            conMiconexion = new Conectar();
            
            conMiconexion.queryUpdate("INSERT INTO `ct_tipos_datos_contactos`(`tipo_dato_contacto`) VALUES( '" + cStrTipoDato + "');");

            String strMensaje = "Se creo el tipo de dato con éxito";
            JOptionPane.showMessageDialog(null, strMensaje,  "CREAR TIPO DE DATO", 2);
            
	}

	/**
	 * 
	 * @param cintIdTipoDato
	 */
	public void crudMostrarTipoDato(int cintIdTipoDato){

            conMiconexion = new Conectar();

            String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta(
                                    "SELECT `id_tipo_dato_contacto`, `tipo_dato_contacto` FROM `ct_tipos_datos_contactos` WHERE  id_tipo_dato_contacto = " + cintIdTipoDato +  ";")); 
           
            intIdTipoDato = Integer.parseInt(strReg[0][0]);
            strTipoDato = strReg[0][1];
            
	}

	/**
	 * 
	 * @param cStrTipoDato
	 */
	public void crudActualizarTipoDato(int intCIdTipoDato ,String strCTipoDato){

            conMiconexion = new Conectar();

	   String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta("SELECT `id_tipo_dato_contacto`, `tipo_dato_contacto` FROM `ct_tipos_datos_contactos` WHERE `id_tipo_dato_contacto`= " + intCIdTipoDato  +  ";"));
           
	   if(strReg[0][0] != null)
	   {
                conMiconexion.queryUpdate("UPDATE `ct_tipos_datos_contactos` SET `tipo_dato_contacto` = '" + strCTipoDato + 
                                                    "' WHERE `id_tipo_dato_contacto` = " + intCIdTipoDato + ";");
                
               strTipoDato = strCTipoDato;
               String strMensaje = "Se modifico el tipo de dato con éxito";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR TIPO DE DATOS", 2);

	   }
	   else
	   {
               String strMensaje = "No se pudo modificar el tipo de dato";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR EL TIPO DE DATO", 0);

	   }
            
	}

	public TiposDatosContactos[] crudListaTipoDato(){
            return null;
	}
        
    public static void main(String[] args) {
        
        	//prueba para la conexi�n
        Conectar CC = new Conectar();
        String R[][] = CC.resultadoQuery(CC.queryConsulta("SELECT `cod_eps`, `nombre_eps` FROM `ct_epss` WHERE `cod_eps`=1;"));
        System.out.print("\nLa EPS es: " + R[0][0] + " - " + R[0][1] + "\n");
        

    
		//-------------------------------------------------------------------------------
  
		//Prueba clase TiposDatosContactos
    
        TiposDatosContactos miObjeto = new TiposDatosContactos();
        
        //...................................................................................
        //Prueba para modificar Tipo Dato Contacto
        miObjeto.crudActualizarTipoDato(1, "Direccion");

        System.out.print("\nEl Tipo de Dato de Contacto modificado es: " + miObjeto.getintIdTipoDato() + " - " + miObjeto.getStrTipoDato() + "\n");
       
        //...................................................................................
        //Prueba crear un Tipo Dato Contacto
        miObjeto.crudCrearTipoDato("Correo");
   
        System.out.print("\nEl nuevo Tipo de Dato de Contacto es: " + miObjeto.getintIdTipoDato() + " - " + miObjeto.getStrTipoDato() + "\n\n");
           
        
         //pueba para mostrar un Tipo Dato Contacto
        miObjeto.crudMostrarTipoDato(1);
        System.out.print("\nEl Tipo de Dato de Contacto 1 es: " + miObjeto.getintIdTipoDato() + " - " + miObjeto.getStrTipoDato() + "\n");
     
        
    }
    
}
