
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class ListaGrados {
    
    public LinkedList<Grado> lista;
    int año;
    private Conexion conn;
    private PreparedStatement ps;
    
    public ListaGrados(int año){
        this.año = año;
        lista = new LinkedList<Grado>();
        conn = new Conexion();
        ps = null;
    }
    
    public LinkedList<Grado> select() {
        try {
            ps = conn.getConnection().prepareCall("call ConsultarGrado(?)");
            ps.setInt(1, año);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) //Esta es la forma correcta de recorrer los valores obtenidos de una consulta
            {
               String gra =rs.getString(1);
               int an =rs.getInt(3);
               Grado a = new Grado(gra,an);
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
