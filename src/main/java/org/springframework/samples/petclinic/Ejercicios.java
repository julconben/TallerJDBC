package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicios {

    public static void ejercicio1(Connection connection, Statement statement) throws SQLException {
    	String sql = "SELECT * FROM owners ;";
		PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String address = rs.getString("address");
			String city = rs.getString("city");
			String telephone = rs.getString("telephone");

			System.out.print("Id: " + id);
			System.out.print(",Nombre: " + firstName);
			System.out.print(",Apelido: " + lastName);
			System.out.print(",Address: " + address);
			System.out.print(",City: " + city);
			System.out.print(",Telephone: " + telephone);

		}
    	
    	
    }

    public static void ejercicio2(Connection connection, Statement statement) throws SQLException {
        // 2. Insertarnos a nosotros como nuevo propietario de una mascota
    	statement = connection.createStatement();
    	String sql = "INSERT INTO owners VALUES (null, 'Sofia', 'Condesso', 'Rua da Amendoeira', 'Faro', 917706689);";
		int numeroDeFilasModificadas = statement.executeUpdate(sql);
    }

    public static void ejercicio3(Connection connection, Statement statement) throws SQLException {
        // 3. Modificar nuestra ciudad por Sevilla
    	statement = connection.createStatement();
    	String sql = "UPDATE owners SET city = 'Sevilha' WHERE id = 145444;";
       // int numeroDeFilasModificadas = -1;
    	int numeroDeFilasModificadas = statement.executeUpdate(sql);
        System.out.println("Se han modificado " + numeroDeFilasModificadas + " rows.");

    }

    public static void ejercicio4(Connection connection) throws SQLException {
        // 4. Crear una variable de tipo String y buscar todos los Owner que coincidan en nombre o apellido.
    	
    	PreparedStatement stmt = null;
    	
    	String sql = "SELECT * FROM owners WHERE first_name=? OR last_name=?;";
    	stmt = connection.prepareStatement(sql);
    	String nome = "Sofia";
        stmt.setString(1, nome);
        stmt.setString(2, nome);
        ResultSet rs = stmt.executeQuery(); 
        while (rs.next()) {
        	int id = rs.getInt("id");
        	String firstName = rs.getString("first_name");
        	String lastName = rs.getString("last_name");
        	
        	System.out.println("ID: "+id);
        	System.out.println("nombre: "+firstName);
        	System.out.println("ultimo: "+lastName);
        }

    }

    public static void ejercicio5(Connection connection) throws SQLException {
        // 5. Crear a partir de las variables nombre, apellido, direccion, ciudad y teléfono (todas de tipo
        // String), un nuevo owner
    	
    	String fname = "Manuel";
    	String lname = "Lopes";
    	String address = "Rua das Lojas";
    	String cidade = "Lamego";
    	String telef = "912345678";
    	String sql = "INSERT INTO owners VALUES (null, ?, ?, ?, ?, ?);";
    	PreparedStatement statement = null;
    	statement = connection.prepareStatement(sql);
    	statement.setString(1, fname);
    	statement.setString(2, lname);
    	statement.setString(3, address);
    	statement.setString(4, cidade);
    	statement.setString(5, telef);
        

    	statement.executeUpdate();
        

    }

    public static void reto(Connection connection, Statement statement) throws SQLException {
    	String sql1 = "INSERT INTO owners VALUES (null, 'Sofia', 'Condesso', 'Rua da Amendoeira', 'Faro', 917706689);";
    	String sql2 = "INSERT INTO pets VALUES (null, 'Toze', '2000', 145444, 3);";
    	PreparedStatement stmt = null;
    	stmt = connection.prepareStatement(sql1);
    	stmt = connection.prepareStatement(sql2);
    	stmt.executeUpdate();

    }

}
