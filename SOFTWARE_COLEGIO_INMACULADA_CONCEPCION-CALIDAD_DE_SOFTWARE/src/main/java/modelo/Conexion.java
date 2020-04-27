
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //esta es la clase conexion aqui esta un atributo que
    //viene de una clase llamada Connection y ella lo sacamos de la libreria de mysql
    private static Connection conn;
    
     //conexion jelastic
    //estan son atributos necesarios para la conexion
  
    //primero el controlador de mysql
    public static final String driver="com.mysql.jdbc.Driver";
    //aqui esta el usuario de la Base de Datos
    public static final String user="root";
    //aqui esta la contraseña de la Base de datos
    public static final String pass="hYRKyX2IVz";
    //finalmente la ruta de la Base de datos como es localhost, con el puerto y el nombre de la BDD
    public static final String url = "jdbc:mysql://node46786-colegio.jelastic.saveincloud.net/colegio";
   
    
    
    /*
   //conexion localhost
    //estan son atributos necesarios para la conexion
  
    //primero el controlador de mysql
    public static final String driver="com.mysql.jdbc.Driver";
    //aqui esta el usuario de la Base de Datos
    public static final String user="root";
    //aqui esta la contraseña de la Base de datos
    public static final String pass="12345678";
    //finalmente la ruta de la Base de datos como es localhost, con el puerto y el nombre de la BDD
    public static final String url = "jdbc:mysql://localhost:3306/colegio1";
   */
       /* 
   //conexion openshift
    public static final String driver="com.mysql.jdbc.Driver";
    public static final String user="root";
    public static final String pass="root";
    public static final String url = "jdbc:mysql://mysql:3306/colegio";
   */
   //este es el contructor de la clase
    public Conexion() {
        //inicializamos la variable de Connection con null
        conn=null;
        // en try catch hacemos la conexion
        try {
            //esta clase con el metodo forname carga el driver
            //una vez que cargamos el driver
            Class.forName(driver);
            //ahora a la varible conn le damos la conexion con nuestra base de datos colegio
            //con la clase DriverManager y con uno se de sus metodos getConnection
            //y ahi le damos 3 parametros la url, el ususario y contra
            conn = (Connection) DriverManager.getConnection(url,user,pass);
            //ahora mira una vez que aya funcioado el metodo si es que la url el usuario
            //y la contra estan bien entonces retornara una conexion y la llenara en la
            //variable conn y debe estar llena quiere decir ya no es null por eso preguntamos
            //con este if(conn != null) si no es nulo conn quiere decir que hay conexion exitosa
            //pero si hay alguna excepcion sale error ahi ternima este metodo constructor
            if(conn!=null){
                System.out.println("conexion");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error");
        }
    }
    
    //este es un metodo get que te retorna la varible conn nada mas
    public Connection getConnection(){
        return conn;
    }
    
    //esto es para cortar la conexion poniendo siempre la varible 
    //con en null asi se desconecta ok akguna pregunta?
    public void desconectar(){
        conn=null;
        if(conn == null){
            System.out.println("terminado");
        }
    }
}
