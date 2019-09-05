package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.samples.petclinic.*;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetType;

public class Ejercicios {

    public static void ejercicio1(Connection connection, Statement statement) throws SQLException {
        // 1. btener todos los clientes de la clinica y mostrar sus datos por pantalla
    	
		String sql = "SELECT * FROM owners";
		
		ResultSet rs = statement.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String address = rs.getString("address");
			String city = rs.getString("city");
			String telephone = rs.getString("telephone");
			
			System.out.print("Id:" + id);
			System.out.print(", Name: " + firstName);
			System.out.print(", Surname: "+ lastName);
			System.out.print(" Adress:" + address);
			System.out.print(" City:" + city);
			System.out.println(" Telephone:" + telephone);
			
			
		}
		rs.close();
    }
    
public static void printTableOwners(Statement statement) throws SQLException {
	
		String sql2 = "SELECT * FROM owners";
		
		ResultSet rs = statement.executeQuery(sql2);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String address = rs.getString("address");
			String city = rs.getString("city");
			String telephone = rs.getString("telephone");
			
			System.out.print("Id:" + id);
			System.out.print(", Name: " + firstName);
			System.out.print(", Surname: "+ lastName);
			System.out.print(" Adress:" + address);
			System.out.print(" City:" + city);
			System.out.println(" Telephone:" + telephone);
			
			
		}
		rs.close();
}
public static void printTableOwners(PreparedStatement statement) throws SQLException {
	
	String sql2 = "SELECT * FROM owners";
	
	ResultSet rs = statement.executeQuery(sql2);
	
	while(rs.next()) {
		int id = rs.getInt("id");
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name");
		String address = rs.getString("address");
		String city = rs.getString("city");
		String telephone = rs.getString("telephone");
		
		System.out.print("Id:" + id);
		System.out.print(", Name: " + firstName);
		System.out.print(", Surname: "+ lastName);
		System.out.print(" Adress:" + address);
		System.out.print(" City:" + city);
		System.out.println(" Telephone:" + telephone);
		
		
	}
	rs.close();
}

    public static void ejercicio2(Connection connection, Statement statement) throws SQLException {
        // 2. Insertarnos a nosotros como nuevo propietario de una mascota

    	String sql = "INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES (?, ?, ?, ?, ?);";
    		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, "diana");
		preparedStatement.setString(2, "nogueira");
		preparedStatement.setString(3, "Rua alfredo Cunha");
		preparedStatement.setString(4, "Caparica");
		preparedStatement.setString(5, "914048979");
		
		//preparedStatement.executeUpdate();
		preparedStatement.close();
		
		printTableOwners(statement);

    }

    public static void ejercicio3(Connection connection, Statement statement) throws SQLException {
        // 3. Modificar nuestra ciudad por Sevilla
    	String sql = "UPDATE owners SET city = 'sevilha' WHERE first_name = 'diana';";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

        int numeroDeFilasModificadas = preparedStatement.executeUpdate();
        preparedStatement.close();		
		printTableOwners(statement);
        System.out.println("Se han modificado " + numeroDeFilasModificadas + " rows.");

    }

    public static void ejercicio4(Connection connection) throws SQLException {
        // 4. Crear una variable de tipo String y buscar todos los Owner que coincidan en nombre o apellido.
    	String sql = "SELECT * FROM owners WHERE first_name = ? OR last_name = ?;";
    	String name = ("diana");
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, name);

		ResultSet rs = preparedStatement.executeQuery();
		int numeroDeFilasModificadas = 0;
		while(rs.next()) {
         numeroDeFilasModificadas++;
        }
        preparedStatement.close();
        
        System.out.println("Se han modificado " + numeroDeFilasModificadas + " rows.");

    }

    public static void ejercicio5(Connection connection) throws SQLException {
        // 5. Crear a partir de las variables nombre, apellido, direccion, ciudad y teléfono (todas de tipo
        // String), un nuevo owner
    	
    	String name = ("Diana");
    	String surname = ("Nogueira");
    	String addr = ("Rua Alfredo Cunha");
    	String city = ("Caparica");
    	String tel = ("914048979");

    	String sql = "INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES (?, ?, ?, ?, ?);";
    		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, surname);
		preparedStatement.setString(3, addr);
		preparedStatement.setString(4, city);
		preparedStatement.setString(5, tel);
		
		int numeroDeFilasModificadas = preparedStatement.executeUpdate();
		preparedStatement.close();
		
        System.out.println("Se han modificado " + numeroDeFilasModificadas + " rows.");

    }

    public static void reto(Connection connection, Statement statement) throws SQLException {

    	Owner own = new Owner();
    	Pet mystik= new Pet();
    	Date birth = new Date(2019-03-01);
    	PetType cat = new PetType();
    	
    	String sqlOwner = "INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES (?, ?, ?, ?, ?);";
		String sqlRemoveOwner = "DELETE FROM owners WHERE first_name ='Diana';";
		String sqlSelectOwner = "SELECT id FROM owners WHERE first_name = ? AND last_name = ?;";
		String sqlInsertPet = "INSERT INTO pets (name, birth_date, owner_id, type_id) VALUES (?, ?, ?, ?);";
    	
    	own.setFirstName("Antonio");
    	own.setLastName("Cardoso");
    	own.setAddress("Quinta das amoreiras");
    	own.setCity("Caparica");
    	own.setTelephone("964440937");
    	
    	mystik.setName("Mystik");
    	mystik.setBirthDate(birth);
    	mystik.setType(cat);
    	own.addPet(mystik);

		PreparedStatement prepSqlOwner = connection.prepareStatement(sqlOwner);
		PreparedStatement prepRemOwner = connection.prepareStatement(sqlRemoveOwner);
		PreparedStatement prepSelectOwner = connection.prepareStatement(sqlSelectOwner);
		PreparedStatement prepInsertPet = connection.prepareStatement(sqlInsertPet);
		
		prepSqlOwner.setString(1, own.getFirstName());
		prepSqlOwner.setString(2, own.getLastName());
		prepSqlOwner.setString(3, own.getAddress());
		prepSqlOwner.setString(4, own.getCity());
		prepSqlOwner.setString(5, own.getTelephone());
		
		prepSqlOwner.executeUpdate();
        
       // prepRemOwner.executeUpdate(); // Remove um utilizador

		prepSelectOwner.setString(1, own.getFirstName());
		prepSelectOwner.setString(2, own.getLastName());
		
		ResultSet rs = prepSelectOwner.executeQuery();
		Integer id = 0;
		while (rs.next()){	
			id = rs.getInt("id");
			break;
    }
		prepInsertPet.setString(1, mystik.getName());
		prepInsertPet.setString(2, mystik.getBirthDate().toString());
		prepInsertPet.setInt(3, id);
		prepInsertPet.setString(4, mystik.getType().toString());
		
		prepInsertPet.executeUpdate();
        
    	printTableOwners(prepSqlOwner);
    	
    	prepSqlOwner.close();
    	prepRemOwner.close();
    	prepInsertPet.close();	
    	
    }

}
