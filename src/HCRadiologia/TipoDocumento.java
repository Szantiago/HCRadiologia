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

public class TipoDocumento {

	private int intIdTipo;
	private String strTipDoc = new String();
        private String strInicialesDoc = new String();
	private Conectar conMiconexion;


//---------------------------------------------------
//Constructores
//--------------------------------------------------
	
	public TipoDocumento(){

	}
        public TipoDocumento( int cIntIdTipo, String cStrInicialesDoc, String cStrTipoDoc){
	
            intIdTipo=cIntIdTipo;
            strInicialesDoc=cStrInicialesDoc;
            strTipDoc=cStrTipoDoc;
            
	}
        
//---------------------------------------------------
//Get - Set
//--------------------------------------------------      
	public int getIntIdTipo(){
		return intIdTipo;
	}

	public String getstrTipDoc(){
		return strTipDoc;
	}
        
        public String getStrCInicialesTipoDoc(){
		return strInicialesDoc;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setstrTipDoc(String newVal){
		strTipDoc = newVal;
	}

        public void setStrCInicialesTipoDoc(String newVal){
		strInicialesDoc = newVal;
	}
	
//---------------------------------------------------
//CRUD
//--------------------------------------------------
	/**
	 * 
	 * @param StrCTipoDoc
	 */
	public void crudCrearTipoDocumento(String StrCTipoDoc, String StrCInicialesTipoDoc){

            conMiconexion = new Conectar();
            
            conMiconexion.queryUpdate("INSERT INTO `ct_tiposdocumentos`(`iniciales_tipodocumento`, `tipo_documento`) VALUES( '" + StrCInicialesTipoDoc + "', '" + StrCTipoDoc + "');");

            String strMensaje = "Se creo Tipo Documento con éxito";
            JOptionPane.showMessageDialog(null, strMensaje,  "CREAR Tipo Docuento", 2); 
            
	}

	/**
	 * 
	 * @param intCTipo
	 */
	public void crudMostrarTipoDocumento(int intCTipo){

            conMiconexion = new Conectar();

            String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta(
                                    "SELECT `id_tipodocumento`, `iniciales_tipodocumento`, `tipo_documento` FROM `ct_tiposdocumentos` WHERE  id_tipodocumento = " + intCTipo +  ";")); 
           
            intIdTipo = Integer.parseInt(strReg[0][0]);
            strInicialesDoc = strReg[0][1];
            strTipDoc = strReg[0][2];
            
	}

               
	/**
	 * 
	 * @param strCTipo
	 */
	public void crudActualizarTipoDocumento(int intCTipo, String strCinicialestipo, String strCTipo){

            conMiconexion = new Conectar();

	   String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta("SELECT `id_tipodocumento`, iniciales_tipodocumento, `tipo_documento` FROM `ct_tiposdocumentos` WHERE  id_tipodocumento = " + intCTipo  +  ";"));
           
	   if(strReg[0][0] != null)
	   {
                conMiconexion.queryUpdate("UPDATE `ct_tiposdocumentos` SET  iniciales_tipodocumento = '" + strCinicialestipo + "', tipo_documento = '"+ strCTipo + "' WHERE  `id_tipodocumento` = " + intCTipo + ";");
                
               
               strInicialesDoc = strCinicialestipo;
               strTipDoc = strCTipo;
               String strMensaje = "Se modifico Tipo Documento con éxito";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR Tipo Documento", 2);

	   }
	   else
	   {
               String strMensaje = "No se pudo modificar Tipo Documento";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR Tipo Documento", 0);

	   }
            
	}

	public TipoDocumento[] crudListaTipoDocumento(){
            int intCont;
            int intTama =0;
            conMiconexion = new Conectar();
            
            try
            {
                String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta( 
                                                "SELECT COUNT(`id_tipodocumento`) AS TAL FROM `ct_tiposdocumentos`;"));

                intTama = Integer.parseInt(strReg[0][0]);
                
                
                strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta(
                        "SELECT id_tipodocumento,iniciales_tipodocumento , tipo_documento FROM ct_tiposdocumentos ORDER BY id_tipodocumento;"));                

                TipoDocumento [] Lista = new TipoDocumento[intTama];

                for (intCont = 0; intCont <(intTama); intCont++)
                {
                    TipoDocumento TipAux = new TipoDocumento( Integer.parseInt(strReg[intCont][0]), 
                            strReg[intCont][1],strReg[intCont][2]);
                                        
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
/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){

                  	//prueba para la conexi�n
        Conectar CC = new Conectar();
        String R[][] = CC.resultadoQuery(CC.queryConsulta("SELECT `id_tipodocumento`, `iniciales_tipodocumento`, `tipo_documento` FROM `ct_tiposdocumentos` WHERE `id_tipodocumento`=1;"));
        System.out.print("\n Tipo Documento es: " + R[0][0] + " - " + R[0][1] + "\n");
        

    
		//-------------------------------------------------------------------------------
  
		//Prueba clase TipoDocumento
    
        TipoDocumento miObjeto = new TipoDocumento();
       
        //pueba para mostrar un Tipo Documento
        miObjeto.crudMostrarTipoDocumento(1);
        System.out.print("\n Tipo Documento es: " + miObjeto.getIntIdTipo() + " - " + miObjeto.getstrTipDoc() + "\n");
     
        //..................................................................................
       /* //Prueba para modificar un Tipo Documento
        miObjeto.crudActualizarTipoDocumento(2, "Cedula de extrangeria", "CE");
        
       
        System.out.print("\nEl Tipo Documento Modificado es: " + miObjeto.getIntIdTipo() + " - " + miObjeto.getstrTipDoc() + " - " + miObjeto.getStrCInicialesTipoDoc() + "\n");
       
        //...................................................................................
        //Prueba crear un Tipo Documento
        miObjeto.crudCrearTipoDocumento("TI", "Tarjeta de identidad");
        System.out.print("\nEl nuevo Tipo Documentoes: " + miObjeto.getIntIdTipo() + " - " + miObjeto.getstrTipDoc() + " - " + miObjeto.getStrCInicialesTipoDoc() + "\n\n");
           */ 
	
        
        TipoDocumento[] lisTabla = miObjeto.crudListaTipoDocumento();
        
        System.out.print("\n\t\tLa lista de documentos es: \n" );
        
        //Bucle para listar los colores del vector
        for(int intCont=0; intCont < lisTabla.length; intCont++)
        {
            System.out.print("\n" + lisTabla[intCont].getIntIdTipo()+" - "+lisTabla[intCont].getStrCInicialesTipoDoc());
        }
        }   
            
}
