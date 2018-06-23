package com.grupodot.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDB {
    public static final  String CLASSNAME = "com.mysql.jdbc.Driver";
    public static final  String USERNAME = "root";
    public static final  String PASSWORD = "";
    public static final  String HOST = "localhost";
    public static final  String PORT = "3306";
    public static final  String DATABASE = "cotizacion";
    public static final  String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
    
    Connection con = null;
        
    public ConexionDB(){
        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (con!= null){
                System.out.println("Conectado a la base de datos [" + con + "] Ok");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Excepcion del Driver " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Excepcion de la conexion " + e.getMessage());
        }   
    }
    
    public Connection getConnection(){
        return con;
    }
    
    public void Desconectar(){
        System.out.println("Cerrando la conexion a la base de datos [" + con + "] Ok");
        if (con!= null){
            try{
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }  
        }
    }
}
