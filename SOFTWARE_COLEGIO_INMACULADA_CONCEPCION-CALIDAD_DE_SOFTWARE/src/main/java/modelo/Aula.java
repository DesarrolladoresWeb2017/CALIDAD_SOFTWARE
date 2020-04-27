
package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Aula {
    String grado, seccion, profesor;
    int cantMax,año;
    private Conexion conn;
    private PreparedStatement ps;

    public Aula(String grado, String seccion, String profesor, int cantMax,int año) {
        this.grado = grado;
        this.seccion = seccion;
        this.profesor = profesor;
        this.cantMax = cantMax;
        this.año = año;
        conn = new Conexion();
        ps = null;
    }

    public Aula(String grado, String seccion) {
        this.grado = grado;
        this.seccion = seccion;
        conn = new Conexion();
        ps = null;
    }

    public boolean insert() {
        try {
            ps = conn.getConnection().prepareCall("call InsertarAula(?,?,?,?,?)");
            ps.setString(1, grado);
            ps.setString(2, seccion);
            ps.setString(3, profesor);
            ps.setInt(4, cantMax);
            ps.setInt(5, año);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.print("bien");
            } else {
                System.out.print("mal");
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en aula 1");
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
            ps = conn.getConnection().prepareCall("call EditarAula(?,?,?,?)");
            ps.setString(1, grado);
            ps.setString(2, seccion);
            ps.setString(3, profesor);
            ps.setInt(4, cantMax);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.print("bien");
            } else {
                System.out.print("mal");
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en aula 2");
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
            ps = conn.getConnection().prepareCall("call EliminarAula(?,?)");
            ps.setString(1, grado);
            ps.setString(2, seccion);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.print("bien");
            } else {
                System.out.print("mal");
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en aula 3 ");
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

    public int getCantMax() {
        return cantMax;
    }

    public void setCantMax(int cantMax) {
        this.cantMax = cantMax;
    }
    
    
}
