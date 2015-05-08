package HCRadiologia;

import javax.swing.JOptionPane;

/**
 * UNIVERSIDAD DE CUNDINAMARCA
 * Profesor Jorge Páramo Fonseca
 * HCRadiologia
 * @author Glo System
 * 
 * 
 * Esta clase tiene por fin manejar el mapeo de la tabla tb_epss
 */

public class Eps {

	private int intIdEps;
	private String strNombre = new String();
	private Conectar conMiconexion;


	public Eps(){

	}

	/**
	 * 
	 * @param cIntIdEps
	 * @param cStrNombre
	 */
	public Eps(int cIntIdEps, String cStrNombre){
        intIdEps=cIntIdEps;
	strNombre=cStrNombre;
	}

	public int getIntIdEps(){
		return intIdEps;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIntIdEps(int newVal){
		intIdEps = newVal;
	}

	public String getStrNombre(){
		return strNombre;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStrNombre(String newVal){
		strNombre = newVal;
	}

	/**
	 * 
	 * @param strCNombreEps
	 */
	public void crudCrearEps(String strCNombreEps){

            conMiconexion = new Conectar();
            
            conMiconexion.queryUpdate("INSERT INTO `ct_epss`(`nombre_eps`) VALUES( '" + strCNombreEps + "');");

            String strMensaje = "Se creo a Eps con éxito";
            JOptionPane.showMessageDialog(null, strMensaje,  "CREAR EPS", 2);  
            
	}

	/**
	 * 
	 * @param strCNombreEps
	 */
	public void crudActualizarEps(int intCIdEps, String strNueCNombreEps){

           conMiconexion = new Conectar();

	   String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta("SELECT `cod_eps`, `nombre_eps` FROM `ct_epss` WHERE  cod_eps = " + intCIdEps  +  ";"));
           
	   if(strReg[0][0] != null)
	   {
                conMiconexion.queryUpdate("UPDATE ct_epss SET nombre_eps =  '" + strNueCNombreEps + 
                                                    "' WHERE  cod_eps = " + intCIdEps + ";");
                
               strNombre = strNueCNombreEps;
               String strMensaje = "Se modifico la EPS con éxito";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR EPS", 2);

	   }
	   else
	   {
               String strMensaje = "No se pudo modificar la EPS";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR EPS", 0);

	   }
            
	}

	/**
	 * 
	 * @param intCIdEps
	 */
	public void crudMostrarEps(int intCIdEps){

            conMiconexion = new Conectar();

            String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta(
                                    "SELECT cod_eps, nombre_eps FROM ct_epss WHERE  cod_eps = " + intCIdEps +  ";")); 
           
            intIdEps = Integer.parseInt(strReg[0][0]);
            strNombre = strReg[0][1];
            
	}

	public Eps[] crudListaEps(){
		
            int intCont;
            int intTama = 0;
            conMiconexion = new Conectar();

            try
            {
                String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta( 
                                                "SELECT COUNT(`cod_eps`) AS TAL FROM  ct_epss ;"));

                intTama = Integer.parseInt(strReg[0][0]);
                //System.out.print("\n el tamaño es:" + intTama + "\n");
                
                strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta(
                        "SELECT cod_eps, nombre_eps  FROM ct_epss ORDER BY cod_eps ;"));                

                Eps [] Lista = new Eps[intTama];

                for (intCont = 0; intCont <(intTama); intCont++)
                {
                    Eps EpsAux = new Eps( Integer.parseInt(strReg[intCont][0]), 
                            strReg[intCont][1]);
                                        
                    Lista[intCont] = EpsAux;

                }
                return Lista;
            }
            catch(Exception ex)
            {
                String strMensaje = "Se presento un problema con la lista de Eps 1";
                JOptionPane.showMessageDialog(null, strMensaje,  "PROBLEMA CON LA LISTA", 0);
                System.out.print(ex);
                return null;
            }
                
                
                
                
	}
    public static void main(String[] args) {
       
        
        
		//prueba para la conexi�n
        Conectar CC = new Conectar();
        String R[][] = CC.resultadoQuery(CC.queryConsulta("SELECT `cod_eps`, `nombre_eps` FROM `ct_epss` WHERE `cod_eps`=1;"));
        System.out.print("\nLa EPS es: " + R[0][0] + " - " + R[0][1] + "\n");
        

    
		//-------------------------------------------------------------------------------
  
		//Prueba clase Eps
    
        Eps miObjeto = new Eps();
        
        //...................................................................................
        //Prueba para modificar una Eps
       /* miObjeto.crudActualizarEps(1, "Colsanitas");

        System.out.print("\nLa EPS modificada es: " + miObjeto.getIntIdEps() + " - " + miObjeto.getStrNombre() + "\n");
       
        //...................................................................................
        //Prueba crear una Eps
        miObjeto.crudCrearEps("NuevaEPS");
   
        System.out.print("\nLA nueva Eps es: " + miObjeto.getIntIdEps() + " - " + miObjeto.getStrNombre() + "\n\n");
           
        
         //pueba para mostrar una Eps
        miObjeto.crudMostrarEps(1);
        System.out.print("\nLa Eps 1 es: " + miObjeto.getIntIdEps() + " - " + miObjeto.getStrNombre() + "\n");*/
     //-----------------------------------------------------------------------------------------------
        //se crea el vector para recibir el vector de Eps
        Eps[] lisTabla = miObjeto.crudListaEps();
        
        System.out.print("\n\t\tLa lista de Eps es: \n" );
        
        //Bucle para listar los colores del vector
        for(int intCont=0; intCont < lisTabla.length -1; intCont++)
        {
            System.out.print("\n" + lisTabla[intCont].getIntIdEps()+ " - " + lisTabla[intCont].getStrNombre());
        }
    }
    
}
