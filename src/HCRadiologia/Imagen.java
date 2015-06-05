package HCRadiologia;

import javax.swing.JOptionPane;


/**
 * UNIVERSIDAD DE CUNDINAMARCA
 * Profesor Jorge Páramo Fonseca
 * HCRadiologia
 * @author Glo System
 * @version 1.0
 * 
 * 
 * Esta clase tiene por fin manejar el mapeo de la tabla tb_imagenes
 */

public class Imagen {

	private String strImagen = new String();
	private int intIdImagen;
	private String strFechaImagen = new String();
	private int intIdOrdenMedica;
	private String strDiagnostico = new String();
	private Conectar conMiconexion;
	private int intTipoDiagnostico;
	private int intTipoImagen;

//---------------------------------------------------
//Constructores
//--------------------------------------------------
	public Imagen(){

	}

	/**
	 * 
	 * @param cIntIdImagen
	 * @param cIntTipoImagen
	 * @param cIntTipoDiagnostico
	 * @param cStrDiagnostico
	 * @param cIntOrdenMedica
	 * @param cStrFechaImagen
	 * @param cStrImagen
	 */
	public Imagen(int cIntIdImagen, int cIntTipoImagen, int cIntTipoDiagnostico, String cStrDiagnostico, int cIntOrdenMedica, String cStrFechaImagen, String cStrImagen){

	}

//---------------------------------------------------
//Get - Set
//--------------------------------------------------
	public int getIntIdImagen(){
		return intIdImagen;
	}

	public String getStrFechaImagen(){
		return strFechaImagen;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStrFechaImagen(String newVal){
		strFechaImagen = newVal;
	}

	public String getstrImagen(){
		return strImagen;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setstrImagen(String newVal){
		strImagen = newVal;
	}

	public int getIntIdOrdenMedica(){
		return intIdOrdenMedica;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIntIdOrdenMedica(int newVal){
		intIdOrdenMedica = newVal;
	}

	public int getIntTipoDiagnostico(){
		return intTipoDiagnostico;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIntTipoDiagnostico(int newVal){
		intTipoDiagnostico = newVal;
	}

	public int getIntTipoImagen(){
		return intTipoImagen;
	}

	public String getStrDiagnostico(){
		return strDiagnostico;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIntTipoImagen(int newVal){
		intTipoImagen = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStrIdDiagnostico(String newVal){
		strDiagnostico = newVal;
	}
        
        
        /**
	 * 
	 * @param intCTipoImagen
	 * @param intCTipoDiagnostico
	 * @param strCDiagnostico
	 * @param intCOrdenMedica
	 * @param strCFechaImagen
	 * @param strCImagen
	 */
        
//---------------------------------------------------
//CRUD
//--------------------------------------------------
	public void crudCrearImagen(int intCTipoImagen, int intCTipoDiagnostico, String strCDiagnostico, int intCOrdenMedica, String strCFechaImagen, String strCImagen){

            conMiconexion = new Conectar();
            
            conMiconexion.queryUpdate("INSERT INTO `tb_imagenes`(`imagen`, `fecha_imagen`, `orden_medica_imagen`, `diagnostico_imagen`, `tipo_diagnostico_imagen`, `tipo_imagen`) VALUES( '" + strCImagen +"','"+ strCFechaImagen +"','"+ intCOrdenMedica +"','"+ strCDiagnostico+"','"+ intCTipoDiagnostico+"','"+ intCTipoImagen + "');");

            String strMensaje = "Se creo la Imagen con éxito";
            JOptionPane.showMessageDialog(null, strMensaje,  "CREAR IMAGEN", 2);  
            
	}

	/**
	 * 
	 * @param intCIdImagen
	 * @param intCTipoImagen
	 * @param intCTipoDiagnostico
	 * @param strCDiagnostico
	 * @param intCOrdenMedica
	 * @param strCFechaImagen
	 * @param strCImagen
	 */
	public void crudActualizarImagen(int intCIdImagen, int intCTipoImagen, int intCTipoDiagnostico, String strCDiagnostico, int intCOrdenMedica, String strCFechaImagen, String strCImagen){

            conMiconexion = new Conectar();
	   String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta("SELECT `id_imagen` , `tipo_imagen`, `tipo_diagnostico_imagen`, `diagnostico_imagen`, `orden_medica_imagen`, `fecha_imagen`, `imagen` FROM `tb_imagenes` WHERE `id_imagen` =" + intCIdImagen +  ";"));
	   if(strReg[0][0] != null)
	   {
               
               conMiconexion.queryUpdate("UPDATE `tb_imagenes` SET  tipo_imagen = "+ intCTipoImagen  + ", tipo_diagnostico_imagen = "+ intCTipoDiagnostico + ", diagnostico_imagen = '"+ strCDiagnostico + "', orden_medica_imagen = "+ intCOrdenMedica + ", fecha_imagen = '" + strCFechaImagen + "', imagen = '" + strCImagen + "' WHERE  id_imagen = " + intCIdImagen + ";");
               intIdImagen = intCIdImagen;
               intTipoImagen = intCTipoImagen;
               intTipoDiagnostico = intCTipoDiagnostico;
               strDiagnostico = strCDiagnostico;
               intIdOrdenMedica = intCOrdenMedica;
               strFechaImagen = strCFechaImagen;
               strImagen = strCImagen;
            
               String strMensaje = "Se modifico imagen con éxito";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR IMAGEN", 2);
	   }
	   else
	   {
               String strMensaje = "No se pudo modificar ";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR ", 0);

	   }
            
	}

	/**
	 * 
	 * @param intCIdImagen
	 */
	public void crudMostrarImagen(int intCIdImagen){

            conMiconexion = new Conectar();
            String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta("SELECT `id_imagen`, `tipo_imagen`, `tipo_diagnostico_imagen`, `diagnostico_imagen`, `orden_medica_imagen`, `fecha_imagen`, `imagen` FROM `tb_imagenes` WHERE `id_imagen`= " + intCIdImagen +  ";")); 
           
            intIdImagen = Integer.parseInt(strReg[0][0]);
            intTipoImagen = Integer.parseInt(strReg[0][1]);
            intTipoDiagnostico = Integer.parseInt(strReg[0][2]);
            strDiagnostico = strReg[0][3];
            intIdOrdenMedica = Integer.parseInt(strReg[0][4]);
            strFechaImagen = strReg[0][5];
            strImagen = strReg[0][6];
            
                
	}

	public Imagen[] crudListaImagen(){
		return null;
	}
        
  //---------------------------------------------------
//Main
//--------------------------------------------------      
	public static void main(String[] args){

            //prueba para la conexi�n
        Conectar CC = new Conectar();
        String R[][] = CC.resultadoQuery(CC.queryConsulta("SELECT `id_imagen`, `imagen`, `fecha_imagen`, `orden_medica_imagen`, `diagnostico_imagen`, `tipo_diagnostico_imagen`, `tipo_imagen` FROM `tb_imagenes` WHERE 1;"));
        System.out.print("\n Imagen: " + R[0][0] + " - " + R[0][1] + " - " + R[0][2] + R[0][3] + " - " + R[0][4] + " - " + R[0][5] + " - " + R[0][6] +"\n");
        
	//-------------------------------------------------------------------------------
            //Prueba clase Imagen
        
        Imagen miObjeto = new Imagen();
        
        //-------------------------------------------------------------------------------
            //pueba para mostrar una Imagen
        
          miObjeto.crudMostrarImagen(2);
          System.out.print("\n Imagen: " + miObjeto.getIntIdImagen() + " - " + miObjeto.getStrFechaImagen() +" - " +  miObjeto.getstrImagen() +" - " + miObjeto.getIntIdOrdenMedica() +" - " + miObjeto.getIntTipoDiagnostico() +" - " + miObjeto.getIntTipoImagen() +" - " + miObjeto.getStrDiagnostico() + "\n");
     
        //...................................................................................
            //Prueba para modificar una imagen

        miObjeto.crudActualizarImagen( 2,1,1, "fractura", 1 ,"2014-12-21","C://Imagenes");
        System.out.print("\n Imagen modificada es: " + miObjeto.getIntIdImagen() + " - " + miObjeto.getStrFechaImagen() +" - " +  miObjeto.getstrImagen() +" - " + miObjeto.getIntIdOrdenMedica() +" - " + miObjeto.getIntTipoDiagnostico() +" - " + miObjeto.getIntTipoImagen() +" - " + miObjeto.getStrDiagnostico() + "\n");
       
        //...................................................................................
            //Prueba crear
       
        miObjeto.crudCrearImagen(1,1, "Revision", 1, "2015-04-01","C://Imagenes");
            
	}
}