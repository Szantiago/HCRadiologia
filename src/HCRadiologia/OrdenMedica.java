
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
 * Esta clase tiene por fin manejar el mapeo de la tabla tb_ordenes_medicas
 */


public class OrdenMedica {
    
    
    private int intIdOrdenMedica;
    private int intMedicoOrdenMedica;
    private int intPacienteOrdenMedica;
    private String strFechaOrdenMedica = new String();
    private String strObservacionesOrden = new String();
    private Conectar conMiconexion;
    
        public OrdenMedica (){
        }
        public OrdenMedica (int cIntIdOrdenMedica){
        }

        public int getIntIdOrdenMedica(){
		return intIdOrdenMedica;
	}

	public int getIntMedicoOrdenMedica(){
		return intMedicoOrdenMedica;
	}
        public void setIntMedicoOrdenMedica(int newVal){
		intMedicoOrdenMedica = newVal;
	}
        
        public int getIntPacienteOrdenMedica(){
		return intPacienteOrdenMedica;
	}
        public void setIntPacienteOrdenMedica(int newVal){
		intPacienteOrdenMedica = newVal;
	}
    
        public String getStrFechaOrdenMedica(){
		return strFechaOrdenMedica;
	}
        public void setStrFechaOrdenMedica(String newVal){
		strFechaOrdenMedica = newVal;
	}

        public String getStrObservacionesOrden(){
		return strObservacionesOrden;
	}
        public void setStrObservacionesOrden(String newVal){
		strObservacionesOrden = newVal;
	}
        
        
        public void crudCrearOrdenMedica(int intCIdOrdenMedica, int intCMedicoOrdenMedica, int intCPacienteOrdenMedica, String strCFechaOrdenMedica, String strCObservacionesOrden){

            conMiconexion = new Conectar();
            
            conMiconexion.queryUpdate("INSERT INTO `tb_ordenes_medicas`(`medico_orden_medica`, `paciente_orden_medica`, `fecha_orden_medica`, `observaciones_orden_medica`) VALUES( " + intCMedicoOrdenMedica +","+ intCPacienteOrdenMedica +",'"+ strCFechaOrdenMedica +"','"+ strCObservacionesOrden + "');");

            String strMensaje = "Se creo la Imagen con éxito";
            JOptionPane.showMessageDialog(null, strMensaje,  "CREAR IMAGEN", 2);  
            
	}
        
        public void crudActualizarOrdenMedica(int intCIdOrdenMedica, int intCMedicoOrdenMedica, int intCPacienteOrdenMedica, String strCFechaOrdenMedica, String strCObservacionesOrden){

            conMiconexion = new Conectar();
	   String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta("SELECT `id_orden_medica`, `medico_orden_medica`, `paciente_orden_medica`, `fecha_orden_medica`, `observaciones_orden_medica` FROM `tb_ordenes_medicas` WHERE `id_orden_medica` =" + intCIdOrdenMedica +  ";"));
	   if(strReg[0][0] != null)
	   {
               
               conMiconexion.queryUpdate("UPDATE `tb_ordenes_medicas` SET  `medico_orden_medica`= "+ intCMedicoOrdenMedica + ", `paciente_orden_medica`= "+ intCPacienteOrdenMedica+ ", `fecha_orden_medica`= '"+ strCFechaOrdenMedica+ "', `observaciones_orden_medica`= '"+ strCObservacionesOrden +  "' WHERE  id_orden_medica = " + intCIdOrdenMedica +";");
               
                intIdOrdenMedica = intCIdOrdenMedica;
                intMedicoOrdenMedica = intCMedicoOrdenMedica;
                intPacienteOrdenMedica = intCPacienteOrdenMedica;
                strFechaOrdenMedica = strCFechaOrdenMedica;
                strObservacionesOrden = strCObservacionesOrden;
             
               String strMensaje = "Se modifico con éxito";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR ", 2);
	   }
	   else
	   {
               String strMensaje = "No se pudo modificar ";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR ", 0);

	   }
            
	}
        
        public void crudMostrarImagen(int intCIdOrdenMedica){

            conMiconexion = new Conectar();
            String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta("SELECT `id_orden_medica`, `medico_orden_medica`, `paciente_orden_medica`, `fecha_orden_medica`, `observaciones_orden_medica` FROM `tb_ordenes_medicas` WHERE `id_orden_medica` =" + intCIdOrdenMedica + ";")); 
           
             intIdOrdenMedica = Integer.parseInt(strReg[0][0]);
             intMedicoOrdenMedica = Integer.parseInt(strReg[0][1]);
             intPacienteOrdenMedica = Integer.parseInt(strReg[0][2]);
             strFechaOrdenMedica = strReg[0][3];
             strObservacionesOrden = strReg[0][4];
    
	}
    public static void main(String[] args) {

        //prueba para la conexi�n
        Conectar CC = new Conectar();
        String R[][] = CC.resultadoQuery(CC.queryConsulta("SELECT `id_orden_medica`, `medico_orden_medica`, `paciente_orden_medica`, `fecha_orden_medica`, `observaciones_orden_medica` FROM `tb_ordenes_medicas` WHERE 1;"));
        System.out.print("\n Orden Medica: " + R[0][0] + " - " + R[0][1] + " - " + R[0][2] + R[0][3] + " - " + R[0][4] + "\n");
        
        
        //-------------------------------------------------------------------------------
            //Prueba clase OrdenMedica
        
        OrdenMedica miObjeto = new OrdenMedica();
        
        
        //pueba para mostrar 
        
          miObjeto.crudMostrarImagen(2);
          System.out.print("\n La orden medica es: " + miObjeto.getIntIdOrdenMedica() + " - " + miObjeto.getIntMedicoOrdenMedica() +" - " +  miObjeto.getIntPacienteOrdenMedica() +" - " + miObjeto.getStrFechaOrdenMedica() +" - " + miObjeto.getStrObservacionesOrden() + "\n");
       
         //...................................................................................
            //Prueba para modificar 

        miObjeto.crudActualizarOrdenMedica( 2,1,1, "2014-12-21", "Observacion");
        System.out.print("\n La orden medica modificada es: " + miObjeto.getIntIdOrdenMedica() + " - " + miObjeto.getIntMedicoOrdenMedica() +" - " +  miObjeto.getIntPacienteOrdenMedica() +" - " + miObjeto.getIntIdOrdenMedica() +" - " + miObjeto.getStrFechaOrdenMedica() +" - " + miObjeto.getStrObservacionesOrden() + "\n");
       
        
         //Prueba crear
       
        miObjeto.crudCrearOrdenMedica(1,1, 1, "2014-08-11","Observaciones");
        
    }
    
}
