package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

import org.springframework.boot.SpringApplication;

public class JDBCApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetClinicApplication.class, args);
        System.out.println("-------- Test de conexión con MySQL ------------");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No encuentro el driver en el Classpath");
            e.printStackTrace();
            return;
        }

        System.out.println("Driver instalado y funcionando");
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic", "root", "");
            if (connection != null) {
                System.out.println("Conexión establecida");
            }
            statement = connection.createStatement();
            String sql = "SELECT * FROM vets";
            //ResultSet rs = statement.executeQuery(sql);
            sql = "SELECT * FROM vets WHERE id=?;";
            PreparedStatement preparedStatement = null;
           
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 2);;
            ResultSet rs = preparedStatement.executeQuery();           
            Ejercicios.ejercicio2(connection, statement);
            while (rs.next()) {
            	int id = rs.getInt("id");
            	String firstName = rs.getString("first_name");
            	String lastName = rs.getString("last_name");
            	
            	System.out.println("ID: "+id);
            	System.out.println("nombre: "+firstName);
            	System.out.println("ultimo: "+lastName);
            }
            rs.close();
            sql = "SELECT * FROM vets WHERE id=?;";
            // TODO: hacer aqui los ejercicios del taller en la usando la Class Ejercicios
            System.out.println("\n\n===== EJERCICIO 1 =====");
                        
            Ejercicios.ejercicio1(connection, statement);
            
            System.out.println("\n\n===== EJERCICIO 2 =====");
            
            Ejercicios.ejercicio2(connection, statement);
            
            
            System.out.println("\n\n===== EJERCICIO 3 =====");
            Ejercicios.ejercicio3(connection, statement);
            
            System.out.println("\n\n===== EJERCICIO 4 =====");
            Ejercicios.ejercicio4(connection);
            System.out.println("\n\n===== EJERCICIO 5 =====");
            Ejercicios.ejercicio5(connection);
            System.out.println(" \n\n===== RETO =====");
            Ejercicios.reto(connection, statement);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        } finally {
            try {
                if (statement != null)
                    connection.close();
            } catch (SQLException se) {

            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

}
