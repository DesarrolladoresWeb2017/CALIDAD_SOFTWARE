
package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Seccion {
    String nombre;
    int año;
    private Conexion conn;
    private PreparedStatement ps;

    public Seccion(String nombre, int año) {
        this.nombre = nombre;
        this.año = año;
        conn = new Conexion();
        ps = null;
    }

    public boolean insert() {
        try {
            ps = conn.getConnection().prepareCall("call InsertarSeccion(?,?)");
            ps.setString(1, nombre);
            ps.setInt(2, año);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.print("bien");
            } else {
                System.out.print("mal");
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en seccion 1");
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
            ps = conn.getConnection().prepareCall("call EditarSeccion(?,?)");
            ps.setString(1, nombre);
            ps.setString(2, nuevo);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.print("bien");
            } else {
                System.out.print("mal");
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en seccion 2");
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
            ps = conn.getConnection().prepareCall("call EliminarSeccion(?)");
            ps.setString(1, nombre);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.print("bien");
            } else {
                System.out.print("mal");
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en seccion 3");
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
    
    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
