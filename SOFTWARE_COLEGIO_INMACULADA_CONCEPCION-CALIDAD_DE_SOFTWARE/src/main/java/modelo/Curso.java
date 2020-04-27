
package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Curso {
    String codigo, nombre;
    int año;
    private Conexion conn;
    private PreparedStatement ps;

    public Curso(String codigo, String nombre, int año) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.año = año;
        conn = new Conexion();
        ps = null;
    }
    
    public Curso(String codigo){
     this.codigo = codigo; 
     conn = new Conexion();
     ps = null;
    }

    public boolean insert() {
        try {
            ps = conn.getConnection().prepareCall("call InsertarCurso(?,?,?)");
            ps.setString(1, codigo);
            ps.setString(2, nombre);
            ps.setInt(3, año);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.print("bien");
            } else {
                System.out.print("mal");
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en curso 1");
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
    
    public boolean editar() {
        try {
            ps = conn.getConnection().prepareCall("call EditarCurso(?,?)");
            ps.setString(1, codigo);
            ps.setString(2, nombre);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.print("bien");
            } else {
                System.out.print("mal");
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en curso 2");
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
    
    public boolean eliminar(String codigo) {
        try {
            ps = conn.getConnection().prepareCall("call EliminarCurso(?)");
            ps.setString(1, codigo);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.print("bien");
            } else {
                System.out.print("mal");
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en curso 3");
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    
}
