
package DAO;

import Connector.UConnection;
import DTO.SexoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vasal
 */
public class SexoDAO {
    public List<SexoDTO> buscarTodos(){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<SexoDTO> list = new ArrayList<SexoDTO>();
        
        try{
            con = UConnection.getConnection();
            String sql = "SELECT * FROM sexo";
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                SexoDTO dpto = new SexoDTO();
                dpto.setId(rs.getInt("id"));
                dpto.setDescripcion(rs.getString("descripcion"));
                list.add(dpto);
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return list;
    }
    
    public byte buscaId(String desc){
        byte id = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            con = UConnection.getConnection();
            String sql = "SELECT id FROM sexo WHERE descripcion = ?";
            
            ps = con.prepareStatement(sql);
            ps.setString(1, desc);
            rs = ps.executeQuery();
            
            rs.next();
            id = (byte)rs.getInt("id");
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return id;
    }
}
