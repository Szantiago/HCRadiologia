package HCRadiologia;

import javax.swing.JOptionPane;

/**
 * UNIVERSIDAD DE CUNDINAMARCA
 * Profesor Jorge Páramo Fonseca
 * HCRadiologia
 * @author Glo System
 * @version 1.0
 * @created 11-abr-2015 
 * 
 * Esta clase tiene por fin manejar el mapeo de la tabla ct_rh
 */

public class RH {

	private int intIdRh;
	private String strNomRh = new String();
	private Conectar conMiconexion;

//---------------------------------------------------
//Constructores
//--------------------------------------------------
	public RH(){

	}

	/**
	 * 
	 * @param cIntIdRh
	 * @param cStrNomRh
	 */
	public RH(int cIntIdRh, String cStrNomRh){
            intIdRh=cIntIdRh;
            strNomRh=cStrNomRh;
	}
//---------------------------------------------------
//Get - Set
//--------------------------------------------------
	public int getIntIdRh(){
		return intIdRh;
	}

	public String getStrNomRh(){
		return strNomRh;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStrNomRh(String newVal){
		strNomRh = newVal;
	}

	/**
	 * 
	 * @param strCNomRh
	 */
//---------------------------------------------------
//CRUD
//--------------------------------------------------
	public void crudCrearRh(String strCNomRh){

            conMiconexion = new Conectar();
            
            conMiconexion.queryUpdate("INSERT INTO `ct_rhs`(`nombre_rh`) VALUES( '" + strCNomRh + "');");

            String strMensaje = "Se creo RH con éxito";
            JOptionPane.showMessageDialog(null, strMensaje,  "CREAR RH", 2);  
            
	}

	/**
	 * 
	 * @param intCIdRh
	 * @param strCNomRh
	 */
	public void crudActualizarRh(int intCIdRh, String strCNomRh){

            conMiconexion = new Conectar();

	   String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta("SELECT `id_rh`, `nombre_rh` FROM `ct_rhs` WHERE `id_rh` = " + intCIdRh  +  ";"));
           
	   if(strReg[0][0] != null)
	   {
                conMiconexion.queryUpdate("UPDATE `ct_rhs` SET `nombre_rh`= '" + strCNomRh + 
                                                    "' WHERE `id_rh`= " + intCIdRh + ";");
                
               strNomRh = strCNomRh;
               String strMensaje = "Se modifico RH con éxito";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR RH", 2);

	   }
	   else
	   {
               String strMensaje = "No se pudo modificar RH";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR RH", 0);

	   }
            
	}

	/**
	 * 
	 * @param intCIdRh
	 */
	public void crudMostrarRh(int intCIdRh ){

            conMiconexion = new Conectar();

            String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta(
                                    "SELECT `id_rh`,`nombre_rh` FROM `ct_rhs` WHERE `id_rh` =" + intCIdRh +  ";")); 
           
            intIdRh = Integer.parseInt(strReg[0][0]);
            strNomRh = strReg[0][1];
	}
        
        public RH[] crudListaRH(){
		
            int intCont;
            int intTama =0;
            conMiconexion = new Conectar();
            
            try
            {
                String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta( 
                                                "SELECT COUNT(`id_rh`) AS TAL FROM `ct_rhs`;"));

                intTama = Integer.parseInt(strReg[0][0]);
                
                
                strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta(
                        "SELECT id_rh,nombre_rh FROM ct_rhs ORDER BY id_rh;"));                

                RH [] Lista = new RH[intTama];

                for (intCont = 0; intCont <(intTama); intCont++)
                {
                    RH RHAux = new RH( Integer.parseInt(strReg[intCont][0]), 
                            strReg[intCont][1]);
                                        
                    Lista[intCont] = RHAux;

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

        /**
	 * 
	 * @param args
	 */
//---------------------------------------------------
//Main
//--------------------------------------------------
	public static void main(String[] args){

            	//prueba para la conexi�n
        Conectar CC = new Conectar();
        String R[][] = CC.resultadoQuery(CC.queryConsulta("SELECT `id_rh`, `nombre_rh` FROM `ct_rhs` WHERE `id_rh`=1;"));
        System.out.print("\n RH es: " + R[0][0] + " - " + R[0][1] + "\n");
        

    
		//-------------------------------------------------------------------------------
  
		//Prueba clase RH
    
        RH miObjeto = new RH();
       
        //pueba para mostrar un RH
        miObjeto.crudMostrarRh(2);
        System.out.print("\n RH es: " + miObjeto.getIntIdRh() + " - " + miObjeto.getStrNomRh() + "\n");
     
        //...................................................................................
//        //Prueba para modificar un RH
//        miObjeto.crudActualizarRh(1, "O+");
//        
//        System.out.print("\nEl RH Modificado es: " + miObjeto.getIntIdRh() + " - " + miObjeto.getStrNomRh() + "\n");
//       
//        //...................................................................................
//        //Prueba crear un RH
//        miObjeto.crudCrearRh("O+");
//          
//        System.out.print("\n El nuevo RH es: " + miObjeto.getIntIdRh() + " - " + miObjeto.getStrNomRh() + "\n\n");
            
        RH[] lisTabla = miObjeto.crudListaRH();
        
        System.out.print("\n\t\tLa lista es: \n" );
        
//Bucle para listar las Epss del vector
        for(int intCont=0; intCont < lisTabla.length ; intCont++)
        {
            System.out.print("\n" + lisTabla[intCont].getIntIdRh()+ " - " + lisTabla[intCont].getStrNomRh());
        }
	}

}