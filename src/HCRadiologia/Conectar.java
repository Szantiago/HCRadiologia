package HCRadiologia;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * UNIVERSIDAD DE CUNDINAMARCA
 * Profesor Jorge Páramo Fonseca
 * HCRadiologia
 * @author Glo System
 * @version 1.0
 * @created 10-abr-2015 
 * 
 * Esta clase tiene por fin realizar la conexion con la base de datos
 */


public class Conectar extends java.lang.Object {

    private String strIp = "localhost" ;                       	//Dirección IP del servidor donde este la base de datos
    private String strPuerto = "3306" ;                             //Puerto del servidor de bases de datos
    private String strTipo = "mysql" ;                               //Tipo de Servidor
    private String strBD = "bdhcradiologia" ;                                	//Nombre de la base de datos
    private String strClassForName = "com.mysql.jdbc.Driver" ;          				//Para crear la clase por nombre segun el tipo y el driver
    private String strUrl;									//Para la URL ya armada

    private DatabaseMetaData dbmd;                          //Metadatos de la BD
    private Statement stmt;                                 //Consulta o instrución SQL establecida
    private Connection conexion;                            //Conexión

    public String strError;                                    //Para manejo del error


 Conectar()
    {
		//Valida que los datos de la conexión esten completos 
        if(strIp.compareTo("")==0 || strPuerto.compareTo("")==0 || strTipo.compareTo("")==0 || strBD.compareTo("")==0  
                                                                            || strClassForName.compareTo("")==0)
        {
            System.out.print("No estan todos los parametros o no todos son correctos");
        }
        else
        {	//Arma la URL
             strUrl = "jdbc:" + strTipo + "://" + strIp + ":" + strPuerto + "/" + strBD;

            try
            {   
                Class.forName(strClassForName);
                strError = "Creo la Conexion";
                conexion = DriverManager.getConnection(strUrl, "root", "");
                System.out.print("Ya estan todos los parametros\n");

                stmt = conexion.createStatement();
                System.out.println("LISTO YA ME CONECTE ");
            }
            catch (SQLException e)
            {
                strError = strUrl;
                System.out.print("\nError 1 " + e);
            }
            catch (java.lang.ClassNotFoundException e)
            {
                strError = strUrl;
                System.out.print("\nError 2 " + e);
            }
        }
    }

//-------------------------------------------------------------------------------------------------------------------------------

    Conectar(String strCIp,String strCPuerto,String strCTipo,String strCDb,String strCClassForName, String strCUsuario, String strCClave)
    {
		//Carga las variables de la clase con los valores recibidos
        strIp = strCIp;									//Dirección IP del servidor donde este la base de datos
        strPuerto = strCPuerto;							//Puerto del servidor de bases de datos
        strTipo = strCTipo;								//Tipo de Servidor
        strBD = strCDb;									//Nombre de la base de datos
        strClassForName = strCClassForName;         	//Para crear la clase por nombre segun el tipo y el driver

		//Valida que los datos de la conexión esten completos 
        if(strIp.compareTo("")==0 || strPuerto.compareTo("")==0 || strTipo.compareTo("")==0 || strCDb.compareTo("")==0  
                                                                            || strCClassForName.compareTo("")==0)
        {
            System.out.print("No estan todos los parametros o no todos son correctos");
        }
        else
        {	
			//Arma la URL
            strUrl = "jdbc:"+strTipo+"://" + strIp + ":" + strPuerto + "/"+strCDb;

            try
            {
                Class.forName(strClassForName);
                strError = "Creo la Conexion";
                conexion = DriverManager.getConnection(strUrl, strCUsuario, strCClave);
                System.out.print("Ya estan todos los parametros\n");

                stmt = conexion.createStatement();
                System.out.println("LISTO YA ME CONECTE ");
            }
            catch (SQLException e)
            {
                strError = strUrl;
                System.out.print("\nError 3 " + e);
            }
            catch (java.lang.ClassNotFoundException e)
            {
                strError = strUrl;
                System.out.print("\nError 4 " + e);
            }
        }
    }

//-------------------------------------------------------------------------------------------------------------------------------
//Metodos del CRUD

//consulta
    public ResultSet queryConsulta(String Consulta)
    {
        ResultSet rs;
        rs = null;

        try
        {
            rs = stmt.executeQuery(Consulta);
        }
        catch (SQLException e)
        {
            System.out.print("\nError 5 " + e);
        }
        return rs;
    }

//---------------------------------------------------------------------------------------------------------------------------	
//UpDate Consulta de actualización

    public int queryUpdate(String Consulta)
    {
        int filas;
        filas = 0;

        try
        {
            filas = stmt.executeUpdate(Consulta);
        }
        catch (SQLException e)
        {
            System.out.print("\nError 6 " + e);
        }

        return filas;
    }

//---------------------------------------------------------------------------------------------------------------------------	
//Resultado de una consulra

    public String[][] resultadoQuery(ResultSet rs)
    {
        String [][] elementos;
        elementos = null;
        int i,j;

        try
        {
            ResultSetMetaData rsmd;
            rsmd = rs.getMetaData();
            elementos = new String [100][rsmd.getColumnCount()];
            i=0;
            j=0;

            while(rs.next())
            {
                for(j = 0 ;j<rsmd.getColumnCount();j++)
                {
                    elementos[i][j]=rs.getString(j+1);
                }
                i++;
            }

        }
        catch (SQLException e)
        {
            System.out.print("\nError 7 " + e);
        }

        return elementos;
    }

//---------------------------------------------------------------------------------------------------------------------------	
//para retornar un conjunto de consultas

    public String getFuncionxId(int idFuncion) //recibir una funcion
    {
        String funcion ="";

        try
        {
            ResultSet rs=queryConsulta("select procedimiento from tbcatprocedimientos where estado = 1 and idprocedimiento = "+idFuncion);

            while(rs.next())
            {
                funcion = rs.getString(1);
            }
        }
        catch (SQLException e)
        {
            System.out.print("\nError 8 " + e);
        }
        return funcion;
    }

//---------------------------------------------------------------------------------------------------------------------------	
// Retorna la conexión establecida

    public Connection getConexion()
    {
        return conexion;
    }

//==========================================================================================================================
// Main para hacer pruebas de conexión

    public static void main(String args[])
    {  
        
    Conectar CC = new Conectar();      

    String R[][] = CC.resultadoQuery(CC.queryConsulta("SELECT `codper`, `pnom` FROM `tbpersona` WHERE 1;"));
        System.out.print("\n: " + R[0][0] + " - " + R[0][1] + "\n");
 
    }
}