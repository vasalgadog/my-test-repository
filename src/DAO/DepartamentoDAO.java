/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connector.UConnection;
import DTO.DepartamentoDTO;
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
public class DepartamentoDAO {
    public List<DepartamentoDTO> buscarTodos(){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DepartamentoDTO> list = new ArrayList<DepartamentoDTO>();
        
        try{
            con = UConnection.getConnection();
            String sql = "SELECT * FROM departamento";
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                DepartamentoDTO dpto = new DepartamentoDTO();
                dpto.setId(rs.getInt("id"));
                dpto.setNombre(rs.getString("nombre"));
                list.add(dpto);
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return list;
    }
    
    public byte buscaId(String nombre){
        byte id = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            con = UConnection.getConnection();
            String sql = "SELECT id FROM departamento WHERE nombre = ?";
            
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            
            rs.next();
            id = (byte)rs.getInt("id");
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return id;
    }
    
    public String buscaNombre(int id){
        String departamento = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            con = UConnection.getConnection();
            String sql = "SELECT nombre FROM departamento WHERE id = ?";
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            rs.next();
            departamento = rs.getString("nombre");
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return departamento;
    }
}
