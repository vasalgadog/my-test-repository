
package DAO;

import Connector.UConnection;
import DTO.TrabajadorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author vasal
 */
public class TrabajadorDAO {
    /*Devuelve todos los trabajadores registrados en la base de datos en una lista.
    */public List<TrabajadorDTO> buscarTodos(){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<TrabajadorDTO> list = new ArrayList<TrabajadorDTO>();
        
        try{
            con = UConnection.getConnection();
            String sql = "SELECT * FROM trabajador";
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                TrabajadorDTO trabajador = new TrabajadorDTO();
                trabajador.setId(rs.getInt("id"));
                trabajador.setNombre(rs.getString("nombre"));
                trabajador.setApellido_paterno(rs.getString("apellido_paterno"));
                trabajador.setApellido_materno(rs.getString("apellido_materno"));
                trabajador.setRut(rs.getString("rut"));
                trabajador.setSexo_id((byte)rs.getInt("sexo_id"));
                trabajador.setEmail(rs.getString("email"));
                trabajador.setAnio_ingreso(rs.getInt("anio_ingreso"));
                trabajador.setDepartamento_id((byte)rs.getInt("departamento_id"));
                list.add(trabajador);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Error en la lista", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if(rs != null) rs.close();
                if(ps != null) ps.close();
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        
        return list;
    }
    
    /*Realiza una búsuqeda de los trabajadores que pertenezcan al departamento id "dpto",
    es una búsqueda filtrada. Recibe como parámetro el id del departaento (dpto) y retorna
    una lista con los trabajadores que tienen esa id en departamento.
    */public List<TrabajadorDTO> buscarDpto(byte dpto){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<TrabajadorDTO> list = new ArrayList<TrabajadorDTO>();
        
        try{
            con = UConnection.getConnection();
            String sql = "SELECT * FROM trabajador WHERE departamento = ?";
            
            ps.setInt(1, dpto);
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                TrabajadorDTO trabajador = new TrabajadorDTO();
                trabajador.setId(rs.getInt("id"));
                trabajador.setNombre(rs.getString("nombre"));
                trabajador.setApellido_paterno(rs.getString("apellido_paterno"));
                trabajador.setApellido_materno(rs.getString("apellido_materno"));
                trabajador.setRut(rs.getString("rut"));
                trabajador.setSexo_id((byte)rs.getInt("sexo_id"));
                trabajador.setEmail(rs.getString("email"));
                trabajador.setAnio_ingreso(rs.getInt("anio_ingreso"));
                trabajador.setDepartamento_id((byte)rs.getInt("departamento_id"));
                list.add(trabajador);
            }
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex, "Error en la lista", JOptionPane.ERROR_MESSAGE);
            
        }finally{
            try{
                if(rs != null) rs.close();
                if(ps != null) ps.close();
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        
        return list;
    }
    
    /*Agrega los trabajadores a la base de datos, retorna verdadero si lo hace con éxito,
    sino retorna falso y lanza la excepción.
    */public boolean Agregar(TrabajadorDTO trabajador){
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = UConnection.getConnection();
            String sql = "INSERT INTO trabajador(id, nombre, apellido_paterno, apellido_materno, rut, sexo_id, email, anio_ingreso, departamento_id) VALUES ( ?,?,?,?,?,?,?,?,?)";
            
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, trabajador.getId());
            ps.setString(2, trabajador.getNombre());
            ps.setString(3, trabajador.getApellido_paterno());
            ps.setString(4, trabajador.getApellido_materno());
            ps.setString(5, trabajador.getRut());
            ps.setInt(6, trabajador.getSexo_id());
            ps.setString(7, trabajador.getEmail());
            ps.setInt(8, trabajador.getAnio_ingreso());
            ps.setInt(9, trabajador.getDepartamento_id());
            
            ps.execute();
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }finally{
            try{
                if(ps != null) ps.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
        return true;
    }
    
    public int cantidadTrabajadores(){
        int cantidad = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
    
        try{
            con = UConnection.getConnection();
            String sql = "SELECT count(id) FROM trabajador";
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            rs.next();
            cantidad = rs.getInt("count(id)");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return cantidad;
    }
}
