package com.grupodot.dao;

import com.grupodot.model.Socio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SocioDAOImpl implements SocioDAO {
    // Atributo del DAO
    ConexionDB con;
    
    // Constructor Parametrizado
    public SocioDAOImpl(ConexionDB con){
        this.con = con;
    }    
    
    @Override
    public Socio getSocioById(int id) {
        try{
            String SQL = "SELECT * FROM Socio where id=? LIMIT 1;";
            PreparedStatement st = con.getConnection().prepareStatement(SQL);            
            st.setInt(1, id);
            ResultSet resultado = st.executeQuery();
            Socio socio = new Socio();
            while(resultado.next()){
                socio.setNombre(resultado.getString("nombre"));
                socio.setApellido(resultado.getString("apellido"));
                socio.setCedula(resultado.getLong("cedula"));
            }
            return socio;
        } catch (SQLException e) {
            return null;
        }
    }
    
}
