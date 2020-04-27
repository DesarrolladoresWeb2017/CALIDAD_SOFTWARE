
package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Asignacion {
    String grado, seccion, profesor,curso;
    int año;
    private Conexion conn;
    private PreparedStatement ps;

    public Asignacion(String grado, String seccion, String profesor, String curso, int año) {
        this.grado = grado;
        this.seccion = seccion;
        this.profesor = profesor;
        this.curso = curso;
        this.año = año;
        conn = new Conexion();
        ps = null;
    }

    public Asignacion(String grado, String seccion, String curso) {
        this.grado = grado;
        this.seccion = seccion;
        this.curso = curso;
        conn = new Conexion();
        ps = null;
    }

    
    public boolean insert() {
        try {
            ps = conn.getConnection().prepareCall("call InsertarAsignacion(?,?,?,?,?)");
            ps.setString(1, curso);
            ps.setString(2, profesor);
            ps.setString(3, grado);
            ps.setString(4, seccion);
            ps.setInt(5, año);
            
            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.print("bien");
            } else {
                System.out.print("mal");
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en asignacion 1");
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
            ps = conn.getConnection().prepareCall("call EditarAsignacion(?,?,?,?)");
            ps.setString(1, curso);
            ps.setString(2, profesor);
            ps.setString(3, grado);
            ps.setString(4, seccion);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.print("bien");
            } else {
                System.out.print("mal");
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en asignacion 2");
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
            ps = conn.getConnection().prepareCall("call EliminarAsignacion(?,?,?)");
            ps.setString(1, curso);
            ps.setString(2, grado);
            ps.setString(3, seccion);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.print("bien");
            } else {
                System.out.print("mal");
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en asignacion 3");
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
    
    

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }


    
    
}
