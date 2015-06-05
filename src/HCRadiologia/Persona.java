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
 * Esta clase tiene por fin manejar el mapeo de la tabla tb_persona
 */

public class Persona {

	private int intCodPer;
	private String strNumDoc = new String();
	private String strPNom = new String();
	private String strSNom = new String();
	private String strPApe = new String();
	private String strSApe = new String();
	private String strFecNac = new String();
	private int intEps;
	private int intTipoDocumento;
	private int intRH;
	private byte byteGenero;
        private byte byteMedicoPersona;
        private String strEspecialidadMedicaPersona;
        private String strObservacionesPersona;
	private Conectar conMiconexion;
//---------------------------------------------------
//Constructores
//--------------------------------------------------
	public Persona(){
            
	}

	
	public Persona(int cIntCodPer, int cIntTipoDocumento, String cStrNumDoc, String cStrPNom, String cStrSNom, String cStrPApe, String cStrSApe, String cStrFecNac, int cIntEps, int cIntRH, String cStrObservacionesPersona ){
            intCodPer=cIntCodPer;
            strNumDoc=cStrNumDoc;
            strPNom=cStrPNom;
            strSNom=cStrSNom;
            strPApe=cStrPApe;
            strSApe=cStrSApe;
            strFecNac=cStrFecNac;
            intEps=cIntEps;
            intTipoDocumento=cIntTipoDocumento;
            intRH=cIntRH;
            strObservacionesPersona=cStrObservacionesPersona;
            
	}
//--------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------
//Get - Set
//--------------------------------------------------
        public int getIntCodPer(){
		return intCodPer;
	}

	public String getStrNumDoc(){
		return strNumDoc;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStrNumDoc(String newVal){
		strNumDoc = newVal;
	}

	/**
	 * Primer nombre
	 */
	public String getStrPNom(){
		return strPNom;
	}

	/**
	 * Primer nombre
	 * 
	 * @param newVal
	 */
	public void setStrPNom(String newVal){
		strPNom = newVal;
	}

	/**
	 * Segundo nombre
	 */
	public String getStrSNom(){
		return strSNom;
	}

	/**
	 * Segundo nombre
	 * 
	 * @param newVal
	 */
	public void setStrSNom(String newVal){
		strSNom = newVal;
	}

	public String getStrPApe(){
		return strPApe;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStrPApe(String newVal){
		strPApe = newVal;
	}

	public String getStrSApe(){
		return strSApe;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStrSApe(String newVal){
		strSApe = newVal;
	}


	/**
	 * Fecha de nacimiento
	 */
	public String getStrFecNac(){
		return strFecNac;
	}

	/**
	 * Fecha de nacimiento
	 * 
	 * @param newVal
	 */
	public void setStrFecNac(String newVal){
		strFecNac = newVal;
	}

	public int getIntEps(){
		return intEps;
	}

	public int getIntTipoDocumento(){
		return intTipoDocumento;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIntEps(int newVal){
		intEps = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIntTipDocTipoDocumento(int newVal){
		intTipoDocumento = newVal;
	}

	public int getIntRH(){
		return intRH;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIntRH(int newVal){
		intRH = newVal;
	}

	public int getByteGenero(){
            
		return byteGenero;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setByteGenero(byte newVal){
		byteGenero = newVal;
	}
        public byte getbyteMedicoPersona(){
            
		return byteMedicoPersona;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setbyteMedicoPersona(byte newVal){
		byteMedicoPersona = newVal;
	}
        
        public String getStrObservacionesPersona(){
		return strObservacionesPersona;
	}

	/**
	 * Segundo nombre
	 * 
	 * @param newVal
	 */
	public void setStrObservacionesPersona(String newVal){
		strObservacionesPersona = newVal;
	}
        
        public String getStrEspecialidadMedicaPersona(){
		return strEspecialidadMedicaPersona;
	}

	/**
	 * Segundo nombre
	 * 
	 * @param newVal
	 */
	public void setStrEspecialidadMedicaPersona(String newVal){
		strEspecialidadMedicaPersona = newVal;
	}
//---------------------------------------------------
//CRUD
//--------------------------------------------------        
	
	public void crudCrearPersona(int intCTipoDocPer, String strCNumDoc, String strCPNom, String strCSNom, String strCPApe,String strCSApe, int intCGenero, int intCMedicoPersona, String strCFechaNac, int intCRh, int intCEpsPer, String strCObservacionesPersona){
        
            conMiconexion = new Conectar();
            int intAux;          
            intAux = conMiconexion.queryUpdate ("INSERT INTO `tb_personas`( `tip_doc_persona`, `num_doc_persona`,"
                    + " `prim_nombre_persona`, `seg_nombre_persona`, `prim_apellido_persona`, `seg_apellido_persona`,"
                    + " `femenino_persona`, `medico_persona`, `fech_nacimiento_persona`,"
                    + " `rh_persona`, `eps_persona`, `observaciones_persona`) VALUES('" + intCTipoDocPer +"','"+strCNumDoc +"','" +
                    strCPNom + "','"+ strCSNom + "','" + strCPApe +"','"+ strCSApe +"',"+ intCGenero +","+ intCMedicoPersona +
                    ","+ strCFechaNac +","+ intCRh + ","+intCEpsPer+",'"+strCObservacionesPersona+"');");
            
            String strMensaje = "Se creo con éxito";
            JOptionPane.showMessageDialog (null, strMensaje,  "CREAR", 2);   
         }
        
        public void crudCrearMedico(int intCTipoDocPer, String strCNumDoc,String strCPNom, String strCSNom, String strCPApe,String strCSApe, int intCGenero, int intCMedicoPersona, String strCEspecialidadMedicaPersona,
                String strCFechaNac, int intCRh, int intCEpsPer, String strCObservacionesPersona){
        
            conMiconexion = new Conectar();
            int intAux;          
            intAux = conMiconexion.queryUpdate ("INSERT INTO `tb_personas`( `tip_doc_persona`, `num_doc_persona`,"
                    + " `prim_nombre_persona`, `seg_nombre_persona`, `prim_apellido_persona`, `seg_apellido_persona`,"
                    + " `femenino_persona`, `medico_persona`, `especialidad_medica_persona`, `fech_nacimiento_persona`,"
                    + " `rh_persona`, `eps_persona`, `observaciones_persona`) VALUES('" + intCTipoDocPer +"','"+strCNumDoc +"','" +
                    strCPNom + "','"+ strCSNom + "','" + strCPApe +"','"+ strCSApe +"',"+ intCGenero +","+ intCMedicoPersona +",'"+ strCEspecialidadMedicaPersona +
                    "',"+ strCFechaNac +","+ intCRh + ","+intCEpsPer+",'"+strCObservacionesPersona+"');");
            
            String strMensaje = "Se creo con éxito";
            JOptionPane.showMessageDialog (null, strMensaje,  "CREAR", 2);   
         }
        
	public void crudMostrarPersona(int intNCodPer){
            
            conMiconexion = new Conectar();
            String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta("SELECT `cod_persona`, `tip_doc_persona`, `num_doc_persona`, `prim_nombre_persona`, `seg_nombre_persona`, `prim_apellido_persona`, `seg_apellido_persona`, `fech_nacimiento_persona`, `rh_persona`, `eps_persona`, `observaciones_persona` FROM `tb_personas` WHERE `cod_persona` = " + intNCodPer +  ";")); 
           
            intCodPer = Integer.parseInt(strReg[0][0]);
            intTipoDocumento = Integer.parseInt(strReg[0][1]);
            strNumDoc = strReg[0][2];
            strPNom = strReg[0][3];
            strSNom = strReg[0][4];
            strPApe = strReg[0][5];
            strSApe = strReg[0][6];
            strFecNac = strReg[0][7];
            intRH = Integer.parseInt(strReg[0][8]);
            intEps = Integer.parseInt(strReg[0][9]);
            strObservacionesPersona = strReg[1][0];
	}

	/**
	 * 
	 * @param strCNumDoc
	 * @param strCPNom
	 * @param strCSNom
	 * @param strCPApe
	 * @param strCSApe
	 * @param strCFecNac
	 * @param cEps
	 * @param tipCDocTipoDocumento
	 * @param rhCRH
	 * @param genCGenero
	 */
	public void crudActualizarPersona(int intCCodPer, int intCTipoDocPer, String strCNumDoc, 
                String strCPNom, String strCSNom, String strCPApe, String strCSApe, int intCGenero,int intCMedicoPersona,
                String strCFechaNac, int intCRh, int intCEpsPer, 
                String strCObservacionesPersona){

           conMiconexion = new Conectar();
	   String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta("SELECT `cod_persona`, `tip_doc_persona`, `num_doc_persona`, `prim_nombre_persona`, `seg_nombre_persona`, `prim_apellido_persona`, `seg_apellido_persona`, `femenino_persona`, `medico_persona`, `fech_nacimiento_persona`, `rh_persona`, `eps_persona`, `observaciones_persona` FROM `tb_personas` WHERE `cod_persona` =" + intCCodPer +  ";"));
	   if(strReg[0][0] != null)
	   {
               conMiconexion.queryUpdate("UPDATE `tb_personas` SET `tip_doc_persona` =  " +intCTipoDocPer +" , `num_doc_persona` =  '" + strCNumDoc +"' , `prim_nombre_persona` = '" + strCPNom + "' , `seg_nombre_persona`=  '" + strCSNom +"' ,`prim_apellido_persona`=  '" + strCPApe +"',`seg_apellido_persona`=  '" + strCSApe + "' ,`femenino_persona`=  " + intCGenero +", `medico_persona`= " + intCMedicoPersona  +"', `fech_nacimiento_persona`=  '" + strCFechaNac +"', `rh_persona`=  " +intCRh +",`eps_persona`= " + intCEpsPer + ",`observaciones_persona`=  '" + strCObservacionesPersona +"' WHERE cod_persona = " + intCCodPer + ";");                  
               
                intTipoDocumento = intCTipoDocPer;
                strNumDoc = strCNumDoc;
                strPNom = strCPNom;
                strSNom = strCSNom;
                strPApe = strCPApe;
                strSApe = strCSApe;
                intCGenero  = ( byteGenero << 24) >>> 24;
                intCMedicoPersona = ( byteMedicoPersona << 24) >>> 24;
                strFecNac = strCFechaNac;
                intEps = intCEpsPer;
                intRH =intCRh;
                strObservacionesPersona = strCObservacionesPersona;
               
               String strMensaje = "Se modifico la persona con éxito";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR ", 2);
	   }
	   else
	   {
               String strMensaje = "No se pudo modificar ";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR ", 0);

	   }
            
	}

        
        public void crudActualizarMedico(int intCCodPer, int intCTipoDocPer, String strCNumDoc, String strCPNom, String strCSNom, String strCPApe, 
                String strCSApe, int intCGenero,int intCMedicoPersona, String strCEspecialidadMedicaPersona, String strCFechaNac, int intCRh, int intCEpsPer, 
                String strCObservacionesPersona){

           conMiconexion = new Conectar();
	   String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta("SELECT `cod_persona`, `tip_doc_persona`, `num_doc_persona`, `prim_nombre_persona`, `seg_nombre_persona`, `prim_apellido_persona`, `seg_apellido_persona`, `femenino_persona`, `medico_persona`, `especialidad_medica_persona`, `fech_nacimiento_persona`, `rh_persona`, `eps_persona`, `observaciones_persona` FROM `tb_personas` WHERE `cod_persona` =" + intCCodPer +  ";"));
	   if(strReg[0][0] != null)
	   {
               conMiconexion.queryUpdate("UPDATE `tb_personas` SET `tip_doc_persona` =  " +intCTipoDocPer +" , `num_doc_persona` =  '" + strCNumDoc +"' , `prim_nombre_persona` = '" + strCPNom + "' , `seg_nombre_persona`=  '" + strCSNom +"' ,`prim_apellido_persona`=  '" + strCPApe +"',`seg_apellido_persona`=  '" + strCSApe + "' ,`femenino_persona`=  " + intCGenero +", `medico_persona`= " + intCMedicoPersona  + " , `especialidad_medica_persona`=  '" + strCEspecialidadMedicaPersona +"', `fech_nacimiento_persona`=  '" + strCFechaNac +"', `rh_persona`=  " +intCRh +",`eps_persona`= " + intCEpsPer + ",`observaciones_persona`=  '" + strCObservacionesPersona +"' WHERE cod_persona = " + intCCodPer + ";");                  
               
                intTipoDocumento = intCTipoDocPer;
                strNumDoc = strCNumDoc;
                strPNom = strCPNom;
                strSNom = strCSNom;
                strPApe = strCPApe;
                strSApe = strCSApe;
                intCGenero  = ( byteGenero << 24) >>> 24;
                intCMedicoPersona = ( byteMedicoPersona << 24) >>> 24;
                strEspecialidadMedicaPersona = strCEspecialidadMedicaPersona;
                strFecNac = strCFechaNac;
                intEps = intCEpsPer;
                intRH =intCRh;
                strObservacionesPersona = strCObservacionesPersona;
               
               String strMensaje = "Se modifico la persona con éxito";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR ", 2);
	   }
	   else
	   {
               String strMensaje = "No se pudo modificar ";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR ", 0);

	   }
        }
        
	public Persona[] crudListaPersona(){
		
            int intCont;
            int intTama = 0;
            conMiconexion = new Conectar();

            try
            {
                String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta( 
                                                "SELECT count(`cod_persona`)AS TAL FROM `tb_personas` ;"));

                intTama = Integer.parseInt(strReg[0][0]);
                //System.out.print("\n el tamaño es:" + intTama + "\n");
                
                strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta(
                        "SELECT `cod_persona`,`tip_doc_persona`,`num_doc_persona`,`prim_nombre_persona`,`seg_nombre_persona`,`prim_apellido_persona`,`seg_apellido_persona`,`fech_nacimiento_persona`,`rh_persona`,`eps_persona`,`observaciones_persona` FROM `tb_personas` ORDER BY cod_persona ;"));                

                Persona [] Lista = new Persona[intTama];

                for (intCont = 0; intCont <(intTama); intCont++)
                {
                    Persona PerAux = new Persona( Integer.parseInt(strReg[intCont][0]), 
                            Integer.parseInt(strReg[intCont][1]), strReg[intCont][2], strReg[intCont][3], strReg[intCont][4], strReg[intCont][5], strReg[intCont][6], strReg[intCont][7],  Integer.parseInt(strReg[intCont][8]) , Integer.parseInt(strReg[intCont][9]), strReg[intCont][10]);
                                        
                    Lista[intCont] = PerAux;

                }
                return Lista;
            }
            catch(Exception ex)
            {
                String strMensaje = "Se presento un problema con la lista 1";
                JOptionPane.showMessageDialog(null, strMensaje,  "PROBLEMA CON LA LISTA", 0);
                System.out.print(ex);
                return null;
            }          
	}
        
        
//==========================================================================================================================
// Main para hacer pruebas 

    public static void main(String args[])
    {     
            //prueba para la conexi�n
        Conectar CC = new Conectar();
        String R[][] = CC.resultadoQuery(CC.queryConsulta("SELECT `cod_persona`, `tip_doc_persona`, `num_doc_persona`, `prim_nombre_persona`, `seg_nombre_persona`, `prim_apellido_persona`, `seg_apellido_persona`, `femenino_persona`, `medico_persona`, `especialidad_medica_persona`, `fech_nacimiento_persona`, `rh_persona`, `eps_persona`, `observaciones_persona` FROM `tb_personas` WHERE cod_persona = 2;"));
        System.out.print("\n Persona: " + R[0][0] + " - " + R[0][1] + " - " + R[0][2]+ " - " + R[0][3] + " - " + R[0][4] + " - " + R[0][5] + " - " + R[0][6] + " - " + R[0][7] + " - " + R[0][8] + " - " + R[0][9] + " - " + R[1][0]+ " - " + R[1][1]+ " - " + R[1][2]+ " - " + R[1][3]+ " - " + R[1][4] +"\n");
        
	//-------------------------------------------------------------------------------
            //Prueba clase Persona
        
        Persona miObjeto = new Persona();
        
        //-------------------------------------------------------------------------------
            //pueba para mostrar una persona
        
        /*miObjeto.crudMostrarPersona(2);
        System.out.print("\n-Registro: " + miObjeto.getIntCodPer() +" - "+ miObjeto.getIntTipoDocumento() + " - " + miObjeto.getStrNumDoc() + " - " + miObjeto.getStrPNom() +" - " +  miObjeto.getStrSNom() +" - " + miObjeto.getStrPApe() +" - " + miObjeto.getStrSApe() + " - " + miObjeto.getStrFecNac() +" - " + miObjeto.getIntRH() + " - " + miObjeto.getIntEps()+ " - " + miObjeto.getStrObservacionesPersona() + "\n");
     */
        //...................................................................................
            //Prueba para modificar una persona

        //miObjeto.crudActualizarPersona(1,1,"56094322", "Laura", "Maria", "Naranjo", "Guarin",0,1,"19850522",1,1,"");
        //System.out.print("\n Registro modificado es: " + miObjeto.getIntTipoDocumento() + " - " + miObjeto.getStrNumDoc() + " - " + miObjeto.getStrPNom() +" - " +  miObjeto.getStrSNom() +" - " + miObjeto.getStrPApe() +" - " + miObjeto.getStrSApe() + " - " + miObjeto.getStrFecNac() +" - " + miObjeto.getIntRH() + " - " + miObjeto.getIntEps()+ " - " + miObjeto.getStrObservacionesPersona() + "\n");
       
        //miObjeto.crudActualizarMedico(3,1,"45563", "Jacinto", "Cenovio", "Linares", "Garcia",0,0,"Especialidad","766566",1,1,"");
        //System.out.print("\n Registro modificado es: " + miObjeto.getIntTipoDocumento() + " - " + miObjeto.getStrNumDoc() + " - " + miObjeto.getStrPNom() +" - " +  miObjeto.getStrSNom() +" - " + miObjeto.getStrPApe() +" - " + miObjeto.getStrSApe() + " - " + miObjeto.getStrFecNac() +" - " + miObjeto.getIntRH() + " - " + miObjeto.getIntEps()+ " - " + miObjeto.getStrObservacionesPersona() + "\n");
       
        //...................................................................................
            //Prueba crear
       
        
//        //miObjeto.crudCrearMedico(1,"45563","Jacinto","Cenovio","Lopez","Garcia",0,0,"","766566",1,1,"");
//        miObjeto.crudCrearPersona(1,"65456788","Maria","","Jimenes","",0,1,"1366571",1,1,"");  
//        
//        miObjeto.crudMostrarPersona(2);
//        System.out.print("\n-Registro: " + miObjeto.getIntCodPer() +" - "+ miObjeto.getIntTipoDocumento() + " - " + miObjeto.getStrNumDoc() + " - " + miObjeto.getStrPNom() +" - " +  miObjeto.getStrSNom() +" - " + miObjeto.getStrPApe() +" - " + miObjeto.getStrSApe() + " - " + miObjeto.getStrFecNac() +" - " + miObjeto.getIntRH() + " - " + miObjeto.getIntEps()+ " - " + miObjeto.getStrObservacionesPersona() + "\n");
//     
//        miObjeto.crudMostrarPersona(5);
//        System.out.print("\n-Registro: " + miObjeto.getIntCodPer() +" - "+ miObjeto.getIntTipoDocumento() + " - " + miObjeto.getStrNumDoc() + " - " + miObjeto.getStrPNom() +" - " +  miObjeto.getStrSNom() +" - " + miObjeto.getStrPApe() +" - " + miObjeto.getStrSApe() + " - " + miObjeto.getStrFecNac() +" - " + miObjeto.getIntRH() + " - " + miObjeto.getIntEps()+ " - " + miObjeto.getStrObservacionesPersona() + "\n");
//     
        
        Persona[] lisTabla = miObjeto.crudListaPersona();
        
        System.out.print("\n\t\tLa lista es: \n" );
        
//Bucle para listar del vector
        for(int intCont=0; intCont < lisTabla.length -1 ; intCont++)
        {
            System.out.print("\n" + lisTabla[intCont].getIntCodPer()+ " - " + lisTabla[intCont].getStrNumDoc()+ " - " + lisTabla[intCont].getStrPNom());
        }
    }        

        
}