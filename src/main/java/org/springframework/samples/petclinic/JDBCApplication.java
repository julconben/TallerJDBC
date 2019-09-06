package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.Pet;

import ch.qos.logback.classic.spi.STEUtil;

public class JDBCApplication {

    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
    	
    	Owner owner = new Owner();
    	//first_name, last_name, address, city, telephone
    	owner.setFirstName("Jose");
    	owner.setLastName("Santos");
    	owner.setAddress("Rua Cordeiro");
    	owner.setCity("Porto");
    	owner.setTelephone("123456789");
    	
    	
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
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic", "root", "");
            if (connection != null) {
                System.out.println("Conexión establecida");
            }
            
            
            
            // TODO: hacer aqui los ejercicios del taller en la usando la Class Ejercicios
            System.out.println("\n\n===== EJERCICIO 1 =====");
            Ejercicios.ejercicio1(connection, statement);
            System.out.println("\n\n===== EJERCICIO 2 =====");
            Ejercicios.ejercicio2(connection, preparedStatement);
            System.out.println("\n\n===== EJERCICIO 3 =====");
            Ejercicios.ejercicio3(connection, preparedStatement);
            System.out.println("\n\n===== EJERCICIO 4 =====");
            Ejercicios.ejercicio4(connection,preparedStatement);
            System.out.println("\n\n===== EJERCICIO 5 =====");
            Ejercicios.ejercicio5(connection, preparedStatement);
            System.out.println(" \n\n===== RETO =====");
            Ejercicios.reto(connection, preparedStatement,statement,owner);
            
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
