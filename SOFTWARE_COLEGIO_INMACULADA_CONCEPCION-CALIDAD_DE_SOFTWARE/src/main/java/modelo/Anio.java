
package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Anio {
 int anio;
 private Conexion conn;
 private PreparedStatement ps;

    public Anio(int anio) {
        this.anio = anio;
         conn = new Conexion();
         ps = null;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
 
    public boolean insert() {
        try {
            ps = conn.getConnection().prepareCall("call InsertarAnio(?)");
            ps.setInt(1, anio);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.print("bien");
            } else {
                System.out.print("mal");
            }
            return true;
        } catch (Exception e) {
            System.out.println("ErrorE");
            return false;
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
    
    
    public boolean editar(String nuevo) {
        try {
            ps = conn.getConnection().prepareCall("call EditarAnio(?,?)");
            ps.setInt(1, anio);
            ps.setString(2, nuevo);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.print("bien");
            } else {
                System.out.print("mal");
            }
            return true;
        } catch (Exception e) {
            System.out.println("ErrorE");
            return false;
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
    public boolean eliminar() {
        try {
            ps = conn.getConnection().prepareCall("call EliminarAnio(?)");
            ps.setInt(1, anio);
            
            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.print("bien");
            } else {
                System.out.print("mal");
            }
            return true;
        } catch (Exception e) {
            System.out.println("ErrorE");
            return false;
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
 
 
}
