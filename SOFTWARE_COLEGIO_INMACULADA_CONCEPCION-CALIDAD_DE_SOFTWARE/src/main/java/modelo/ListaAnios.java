
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class ListaAnios {
    
    public LinkedList<Anio> lista;
    private Conexion conn;
    private PreparedStatement ps;
    
    public ListaAnios(){
        lista = new LinkedList<Anio>();
        conn = new Conexion();
        ps = null;
    }
    
    public LinkedList<Anio> select() {
        try {
            ps = conn.getConnection().prepareCall("call ConsultarAnio");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) //Esta es la forma correcta de recorrer los valores obtenidos de una consulta
            {
               int ani =rs.getInt(1);
               Anio a = new Anio(ani);
               lista.add(a);
            }
            
            
            return lista;
        } catch (Exception e) {
            System.out.println("error");
            return null;
        }
        finally {

            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.desconectar();
                }
            } catch (SQLException ex) {
                System.out.println("error");
                
            }

        }
    }
    
    public int tama(){
        return lista.size();
    }
    

    
    
}
