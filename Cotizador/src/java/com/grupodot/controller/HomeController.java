package com.grupodot.controller;

import com.grupodot.dao.*;
import com.grupodot.model.Capital;

import java.io.IOException;
import static java.lang.Math.pow;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeController", urlPatterns = {"/cotizacion"})
public class HomeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Float interes, valorCredito = null, cuotaMensual=null;
        Double tasaEfectivaAnual=null;
        DecimalFormat df = new DecimalFormat("#0.00");
        String monto = request.getParameter("monto");
        Capital capital = null;
        ConexionDB con = new ConexionDB();
        CapitalDAOImpl dao = new CapitalDAOImpl(con);
        capital = dao.getCapital(Float.parseFloat(monto));
        if( capital != null ){
            interes = capital.getTasa()/100;
            tasaEfectivaAnual = (pow((1+interes), 12)-1)*100;
            valorCredito = Float.parseFloat(monto)*(1+36*interes);
            cuotaMensual = valorCredito/36;            
            request.setAttribute("valorCredito", df.format(valorCredito));
            request.setAttribute("cuotaMensual", df.format(cuotaMensual));
            request.setAttribute("tasaEfectivaAnual", df.format(tasaEfectivaAnual));            
        }
        request.setAttribute("monto", monto);            
        request.setAttribute("capital", capital);            
        con.Desconectar();
        request.getRequestDispatcher("/index.jsp").forward(request, response);        
    }
}
