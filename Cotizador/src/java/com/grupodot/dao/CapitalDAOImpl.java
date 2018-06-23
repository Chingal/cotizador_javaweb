package com.grupodot.dao;

import com.grupodot.model.Capital;
import com.grupodot.model.Socio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CapitalDAOImpl implements CapitalDAO {
    // Atributo del DAO
    ConexionDB con;
    
    // Constructor Parametrizado
    public CapitalDAOImpl(ConexionDB con){
        this.con = con;
    }
    
    @Override
    public List<Capital> ListarSociosConCapital(){
        try{
            String SQL = "SELECT * FROM capital ORDER BY tasa asc;";
            PreparedStatement st = con.getConnection().prepareStatement(SQL);
            ResultSet resultado = st.executeQuery();
            List<Capital> listaCapital = new LinkedList<>();
            Capital capital;
            Socio socio = new Socio();
            SocioDAOImpl daoSocio = new SocioDAOImpl(this.con);
            while(resultado.next()){                
                capital = new Capital();
                capital.setMontoDisponible(resultado.getFloat("monto_disponible"));
                capital.setTasa(resultado.getFloat("tasa"));
                socio = daoSocio.getSocioById(resultado.getInt("socio"));
                capital.setSocio(socio);
                listaCapital.add(capital);
            }
            return listaCapital;
        } catch (SQLException e) {
            return null;
        }
    } 

    @Override
    public Capital getCapital(float monto) {
        Capital cap = null;
        List<Capital> socios = this.ListarSociosConCapital();
        for(int i=0; i<socios.size(); i++){
            if( monto <= socios.get(i).getMontoDisponible() ){
                cap = socios.get(i);
                break;
            }
        }
        return cap;
    }
}
