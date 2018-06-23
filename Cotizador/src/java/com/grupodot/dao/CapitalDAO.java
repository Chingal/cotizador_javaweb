package com.grupodot.dao;

import com.grupodot.model.Capital;
import java.util.List;

public interface CapitalDAO {
    
    public Capital getCapital(float monto);
    public List<Capital> ListarSociosConCapital(); 
}
