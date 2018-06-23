package com.grupodot.model;

import com.grupodot.dao.CapitalDAOImpl;
import com.grupodot.dao.ConexionDB;
import static java.lang.Math.pow;
import java.text.DecimalFormat;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "CotizacionWS")
public class CotizacionWS {

    @WebMethod(operationName = "getCotizacion")
    public Cotizacion getCotizacion(@WebParam(name = "monto") float monto) {
        Float interes, valorCredito = null, cuotaMensual=null;
        Double tasaEfectivaAnual=null;
        DecimalFormat df = new DecimalFormat("#0.00");
        Cotizacion cotizacion = null;
        Capital capital = null;
        ConexionDB con = new ConexionDB();
        CapitalDAOImpl dao = new CapitalDAOImpl(con);
        capital = dao.getCapital(monto);
        System.out.println("-----> Capital: " + capital.getMontoDisponible() + " -> " +capital.getTasa() + " ->"+capital.getSocio().getCedula());
        if( capital != null ){
            cotizacion = new Cotizacion();
            interes = capital.getTasa()/100;
            tasaEfectivaAnual = (pow((1+interes), 12)-1)*100;
            valorCredito = monto*(1+36*interes);
            cuotaMensual = valorCredito/36;            
            cotizacion.setNombreSocio(capital.getSocio().getNombre()+" "+capital.getSocio().getApellido());
            cotizacion.setTasaEfectivaAnual(df.format(tasaEfectivaAnual));
            cotizacion.setTasaEfectivaMensual(df.format(capital.getTasa()));
            cotizacion.setCuotaMensual(df.format(cuotaMensual));
            cotizacion.setValorCredito(df.format(valorCredito));
            cotizacion.setPlazo("36 Meses");
        }
        con.Desconectar();        
        return cotizacion;
    }
}
