/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppSQLite;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fojomars
 */
public class MetodosSQLite {

//    public static void createNewDatabase(String fileName) {
// 
//        String url = "jdbc:sqlite:" + fileName;
// 
//        try (Connection conn = DriverManager.getConnection(url)) {
//            if (conn != null) {
//                DatabaseMetaData meta = conn.getMetaData();
//                System.out.println("The driver name is " + meta.getDriverName());
//                System.out.println("A new database has been created.");
//            }
// 
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    /**
     * Este método sirve para conectar con la base de datos
     *
     * @return
     */
    public Connection conectar() {
        String url = "jdbc:sqlite:tienda.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión establecida");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
        }
        return conn;
    }

    /**
     * Este método crea la tabla en la base de datos. En caso de que ya exista
     * la borra
     */
    public void crearTablaTienda() {
        String sql1 = "DROP TABLE IF EXISTS clientes;\n";
        String sql2 = "CREATE TABLE IF NOT EXISTS clientes (\n"
                + "id integer PRIMARY KEY,\n"
                + "nombre text NOT NULL,\n"
                + "telefono integer NOT NULL"
                + ");";
        try (Connection conn = this.conectar();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql1);
            stmt.execute(sql2);
            JOptionPane.showMessageDialog(null, "Tabla creada con exito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear la tabla");
        }
    }

    /**
     * Este méto sirve para insertar datos en la tabla clientes
     *
     * @param id
     * @param nombre
     * @param telefono
     */
    public void insertarCliente(int id, String nombre, int telefono) {
        String sql = "INSERT INTO clientes(id,nombre,telefono) VALUES(?,?,?)";
        try (Connection conn = this.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.setInt(3, telefono);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente registrado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al introducir los datos");
        }
    }

    /**
     * Método para borrar datos de la tabla clientes
     * @param id
     */
    public void borrarCliente(int id) {
        String sql = "DELETE FROM clientes WHERE id=?";
        try (Connection conn = this.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Método para modicar el nombre y telefono de la tabla clientes
     * @param nombre
     * @param telefono
     * @param referencia 
     */

    public void modificarCliente(String nombre, int telefono, int referencia) {
        String sql = "UPDATE clientes SET nombre = ? , "
                + "telefono = ? "
                + "WHERE id = ?";
        try (Connection conn = this.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setInt(2, telefono);
            pstmt.setInt(3, referencia);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente modificado correctamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Método que devuelve el id, nombre y telefono del cliente
     * @param id
     * @return 
     */

    public String devolverCliente(int id) {
        String sql = "SELECT id,nombre,telefono"
                + " FROM clientes WHERE id=?";
        String resultado = "";
        try (Connection conn = this.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                resultado = (rs.getInt("id") + ","
                        + rs.getString("nombre") + ","
                        + rs.getInt("telefono"));
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return resultado;
        }
    }
    
    /**
     * Método para realizar una consulta tanto de id, nombre y telefono médiante un combo box
     * @param campo
     * @param valor
     * @return 
     */

    public ArrayList<String> consultaClientes(String campo, Object valor) {
        ArrayList<String> clientes = new ArrayList<>();
        String sql = "SELECT id,nombre,telefono"
                + " FROM clientes WHERE " + campo + "=?";
        try (Connection conn = this.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, valor);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                clientes.add(rs.getInt("id") + ","
                        + rs.getString("nombre") + ","
                        + rs.getInt("telefono"));
            }
            return clientes;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return clientes;
        }
    }

}
