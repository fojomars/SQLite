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
    
    /**
     * Este método se utiliza para crear una base de datos
     * @param fileName 
     */

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
     * Este método se utiliza para conectar con la base de datos
     * @return
     */
    public Connection conectar() {
        String url = "jdbc:sqlite:tienda.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            JOptionPane.showMessageDialog(null,"Conexión establecida");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos");
        }
        return conn;
    }

    /**
     * Este método crea la tabla en la base de datos. 
     * En caso de que ya exista
     * la borra
     */
    public boolean crearTablaTienda() {
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
            JOptionPane.showMessageDialog(null,"Tabla creada con exito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al crear la tabla");
        }
        return true;
    }

    /**
     * Este méto s utiliza para insertar datos en la tabla clientes
     * 
     * @param id
     * @param nombre
     * @param telefono
     */
    public boolean insertarCliente(int id, String nombre, int telefono) {
        String sql = "INSERT INTO clientes(id,nombre,telefono) VALUES(?,?,?)";
        try (Connection conn = this.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.setInt(3, telefono);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente registrado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al introducir los datos o puede que el id ya este selecionado");
        }
        return true;
    }

    /**
     * Método para borrar datos de la tabla clientes
     * 
     * @param id
     */
    public boolean borrarCliente(int id) {
        String sql = "DELETE FROM clientes WHERE id=?";
        try (Connection conn = this.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el cliente");
        }
        return true;
    }
    
    /**
     * Método para modicar el nombre y telefono de la tabla clientes
     * 
     * @param nombre
     * @param telefono
     * @param referencia 
     */

    public boolean modificarCliente(String nombre, int telefono, int referencia) {
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
            JOptionPane.showMessageDialog(null, "Erro al modificar el cliente");
        }
        return true;
    }
    
    /**
     * Método que devuelve el id, nombre y telefono del cliente
     * 
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
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            return resultado;
        }
    }
    
    /**
     * Método para realizar una consulta tanto de id, nombre y telefono médiante un combo box
     * 
     * @param campo
     * @param valor
     * @return 
     */

    public ArrayList<String> consultaClientes(String campo, String valor) {
        ArrayList<String> clientes = new ArrayList<>();
        String sql = "SELECT id,nombre,telefono"
                + " FROM clientes WHERE " + campo + " = ?";
        System.out.println("sql-"+sql);
        try (Connection conn = this.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, valor);
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                clientes.add(rs.getInt("id") + ","
                        + rs.getString("nombre") + ","
                        + rs.getInt("telefono"));
            }
            return clientes;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            return clientes;
        }
    }

}
