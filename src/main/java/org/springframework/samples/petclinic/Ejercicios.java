package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicios {

    public static void ejercicio1(Connection connection, Statement statement) throws SQLException {
        // 1. btener todos los clientes de la clinica y mostrar sus datos por pantalla
    	
    	
        
        statement=connection.createStatement();
        
        String sql="SELECT * FROM owners";
        ResultSet rs=statement.executeQuery(sql);
        
        while(rs.next()) {
        	String firstName=rs.getString("first_name");
        	String lastName=rs.getString("last_name");
        	String city=rs.getString("city");
        	System.out.println("Nome: "+firstName+", Apelido: "+lastName+", City: "+city);
        }
        rs.close();
    }

    public static void ejercicio2(Connection connection, Statement statement) throws SQLException {
    	
    	
        // 2. Insertarnos a nosotros como nuevo propietario de una mascota
    	
    	
    	
    	/*
    	String query="insert into owners (id, first_name, last_name, address, city, telephone)"+ "values (?, ?, ?, ?, ?, ?)";
    	
    	 PreparedStatement preparedStmt = connection.prepareStatement(query);
    	 preparedStmt.setInt (1, 12);
         preparedStmt.setString (2, "Joao");
         preparedStmt.setString (3, "Jacob");
         preparedStmt.setString   (4, "rua Sao nunca 2");
         preparedStmt.setString(5, "Seixal");
         preparedStmt.setString    (6, "987654321");
         
         preparedStmt.execute();
         */
    }

    

    public static void ejercicio3(Connection connection) throws SQLException {
        // 3. Modificar nuestra ciudad por Sevilla
    	
    /*
    	String query = "update owners set city = ? where id = ?";
    	PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString   (1, "Sevilla");
        preparedStmt.setInt(2, 12);
    	
        preparedStmt.executeUpdate();
        
        connection.close();
    	
        int numeroDeFilasModificadas = -1;
        System.out.println("Se han modificado " + numeroDeFilasModificadas + " rows.");
*/
    }

    public static void ejercicio4(Connection connection, Statement statement) throws SQLException {
        // 4. Crear una variable de tipo String y buscar todos los Owner que coincidan en nombre o apellido.
    	/*
    	statement=connection.createStatement();
    	String query="SELECT * FROM owners where first_name ='Harold' or last_name='Harold'";
    	ResultSet rs=statement.executeQuery(query);
    	
    	
    	PreparedStatement preparedStmt = connection.prepareStatement(query);
       
    	
        preparedStmt.executeQuery();
        
        while(rs.next()) {
        	String firstName=rs.getString("first_name");
        	String lastName=rs.getString("last_name");
        	String city=rs.getString("city");
        	System.out.println("Nome: "+firstName+", Apelido: "+lastName+", City: "+city);
        }
        rs.close();
        
        connection.close();*/
    	
    }

    public static void ejercicio5(Connection connection, Statement statement) throws SQLException {
    	/*
    	Statement st = connection.createStatement();
    	
    	
    	st.executeUpdate("insert into owners (id, first_name, last_name, address, city, telephone)"+ "values (13, 'Bono', 'Roger', 'Rua Alegre', 'Beja', '928736163')");
    	
        // 5. Crear a partir de las variables nombre, apellido, direccion, ciudad y teléfono (todas de tipo
        // String), un nuevo owner
        int numeroDeFilasModificadas = -1;
        System.out.println("Se han modificado " + numeroDeFilasModificadas + " rows.");

        
        connection.close();*/
    }

    public static void reto(Connection connection, Statement statement) throws SQLException {
    	
    	/*
    	int ownerid=0;
    	statement=connection.createStatement();
    	String query="SELECT * FROM owners where first_name ='Joao' and last_name='Jacob'";
    	ResultSet rs=statement.executeQuery(query);
    	
    	while(rs.next()) {
        	ownerid=rs.getInt("id");
        }
        rs.close();
    	*/
    	
    	
    	//st.executeUpdate("insert into pets ( name, birth_date, owner_id, type_id)"+ "values ('Jota', '2010-10-10', 12, 3)");
    	
        // 5. Crear a partir de las variables nombre, apellido, direccion, ciudad y teléfono (todas de tipo
        // String), un nuevo owner
    	
        
        /*
    	String query1="insert into pets ( name, birth_date, owner_id, type_id)"+ "values (?, ?, ?, ?)";
    	
   	 	PreparedStatement preparedStmt1 = connection.prepareStatement(query1);
   	 
        preparedStmt1.setString (1, "Max");
        preparedStmt1.setString (2, "2015-02-05");
        preparedStmt1.setInt   (3, ownerid);
        preparedStmt1.setInt(4, 2);
        
        preparedStmt1.execute();
        
        int numeroDeFilasModificadas = -1;
        System.out.println("Se han modificado " + numeroDeFilasModificadas + " rows.");
*/
        
    	statement=connection.createStatement();
    	String query2="DELETE FROM owners WHERE first_name ='Bono' AND last_name='Roger'";
    	statement.executeUpdate(query2);
    	
    	
    	

    }

}
