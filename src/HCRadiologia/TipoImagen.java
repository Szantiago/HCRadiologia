/**
 * UNIVERSIDAD DE CUNDINAMARCA
 * Profesor Jorge Páramo Fonseca
 * HCRadiologia
 * @author Glo System
 */
package HCRadiologia;

import javax.swing.JOptionPane;


public class TipoImagen {

        private int intIdTipoImagen;
	private String strTipoImagen = new String();
	private Conectar conMiconexion;
//---------------------------------------------------
//Constructores
//--------------------------------------------------

	public TipoImagen(){

	}

	/**
	 * 
	 * @param cIntIdTipoImagen
	 * @param cStrTipoImagen
	 */
	public TipoImagen(int cIntIdTipoImagen, String cStrTipoImagen){

	}
//---------------------------------------------------
//Get - Set
//--------------------------------------------------
	public int getIntIdTipoImagen(){
		return intIdTipoImagen;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIntIdTipoImagen(int newVal){
		intIdTipoImagen= newVal;
	}

	public String getStrTipoImagen(){
		return strTipoImagen;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStrTipoImagen(String newVal){
		strTipoImagen = newVal;
	}
//---------------------------------------------------
//CRUD
//--------------------------------------------------
	/**
	 * 
	 * @param strCTipoImagen
	 */
	public void crudCrearTipoImagen(String strCTipoImagen){

            conMiconexion = new Conectar();
            
            conMiconexion.queryUpdate("INSERT INTO `ct_tipos_imagenes`(`tipo_imagen`) VALUES( '" + strCTipoImagen + "');");

            String strMensaje = "Se creo el Tipo Imagen con éxito";
            JOptionPane.showMessageDialog(null, strMensaje,  "CREAR TIPOS IMAGEN", 2);  
            
	}

	/**
	 * 
	 * @param strCTipoImagen
	 */
	public void crudActualizarTipoImagen(int intCIdTipoImagen, String strNueCTipoImagen){

           conMiconexion = new Conectar();

	   String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta("SELECT `id_tipo_imagen`, `tipo_imagen` FROM `ct_tipos_imagenes` WHERE  id_tipo_imagen = " + intCIdTipoImagen  +  ";"));
           
	   if(strReg[0][0] != null)
	   {
                conMiconexion.queryUpdate("UPDATE ct_tipos_imagenes SET tipo_imagen =  '" + strNueCTipoImagen + 
                                                    "' WHERE  id_tipo_imagen = " + intCIdTipoImagen + ";");
                
               strTipoImagen = strNueCTipoImagen;
               String strMensaje = "Se modifico el tipo de imagen con éxito";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR TIPOIMAGEN", 2);

	   }
	   else
	   {
               String strMensaje = "No se pudo modificar el Tipo de Imagen";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR TIPOIMAGEN", 0);

	   }
            
	}

	/**
	 * 
	 * @param intCIdTipoImagen
	 */
	public void crudMostrarTipoImagen(int intCIdTipoImagen){

            conMiconexion = new Conectar();

            String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta(
                                    "SELECT id_tipo_imagen, tipo_imagen FROM ct_tipos_imagenes WHERE  id_tipo_imagen = " + intCIdTipoImagen +  ";")); 
           
            intIdTipoImagen = Integer.parseInt(strReg[0][0]);
            strTipoImagen = strReg[0][1];
            
	}

	public Eps[] crudListaTipoImagen(){
		return null;
	}
        
//---------------------------------------------------
//Main
//--------------------------------------------------
    public static void main(String[] args) {
       
        
        
		//prueba para la conexi�n
        Conectar CC = new Conectar();
        String R[][] = CC.resultadoQuery(CC.queryConsulta("SELECT `id_tipo_imagen`, `tipo_imagen` FROM `ct_tipos_imagenes` WHERE `id_tipo_imagen`=1;"));
        System.out.print("\nEl tipo de imagen es: " + R[0][0] + " - " + R[0][1] + "\n");
        

    
		//-------------------------------------------------------------------------------
  
		//Prueba clase TipoImagen
    
        TipoImagen miObjeto = new TipoImagen();
        
        //...................................................................................
        //Prueba para modificar un Tipo Imagen
        miObjeto.crudActualizarTipoImagen(1,"tomografía");

        System.out.print("\nEl Tipo Imagen modificada es: " + miObjeto.getIntIdTipoImagen() + " - " + miObjeto.getStrTipoImagen() + "\n");
       
        //...................................................................................
        //Prueba crear una Tipo Imagen
        miObjeto.crudCrearTipoImagen("resonancia magnética");
   
        System.out.print("\nEl nuevo Tipo Imagen es: " + miObjeto.getIntIdTipoImagen() + " - " + miObjeto.getStrTipoImagen() + "\n\n");
           
        
         //pueba para mostrar un Tipo de Imagen
        miObjeto.crudMostrarTipoImagen(1);
        System.out.print("\nEl Tipo Imagen 1 es: " + miObjeto.getIntIdTipoImagen() + " - " + miObjeto.getStrTipoImagen() + "\n");
    }
    
}
