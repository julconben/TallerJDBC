package org.springframework.samples.petclinic;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Date;
import java.util.Date;

//import org.springframework.boot.SpringApplication;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.Pet;

public class Ejercicios {

	public static void ejercicio1(Connection connection, Statement statement) throws SQLException {
		// 1. btener todos los clientes de la clinica y mostrar sus datos por pantalla
		statement = connection.createStatement();
		String sql = "SELECT * FROM owners";
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {

			int id = rs.getInt("id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String adress = rs.getString("address");
			String city = rs.getString("city");
			String phone = rs.getString("telephone");

			System.out.println("Id : " + id);
			System.out.println("Nome : " + firstName);
			System.out.println("Apelido: " + lastName);
			System.out.println("Address: " + adress);
			System.out.println("City :" + city);
			System.out.println("Telephone: " + phone);
		}

		rs.close();

	}

	public static void ejercicio2(Connection connection, Statement statement) throws SQLException {
		// 2. Insertarnos a nosotros como nuevo propietario de una mascota
		statement = connection.createStatement();
		String sql = "INSERT INTO owners VALUES (null,'Emanuel','Morais','Rua dos Arneiros','Lisboa','932566890')";
		//não é necessário colocar valor no ID, tem auto increment
		statement.executeUpdate(sql);
		
		//int numeroDeFilasModificadas = statement.executeUpdate(sql)
	}

	public static void ejercicio3(Connection connection, Statement statement) throws SQLException {
		// 3. Modificar nuestra ciudad por Sevilla
		statement = connection.createStatement();
	    String sql = "UPDATE owners SET city = 'Sevilla' WHERE id=100002";
	    statement.executeUpdate(sql);
		
		/*int numeroDeFilasModificadas = -1;
		System.out.println("Se han modificado " + numeroDeFilasModificadas + " rows.");*/
	}

	public static void ejercicio4(Connection connection) throws SQLException {
		// 4. Crear una variable de tipo String y buscar todos los Owner que coincidan
		// en nombre o apellido.
		String firstName = "Emanuel";
		String lastName = "Morais";
	//	Statement statement = connection.createStatement();
	    String sql = "SELECT * FROM owners WHERE first_name = ? OR last_name= ?";
	    
	    PreparedStatement preparedStatement = null;
	    preparedStatement = connection.prepareStatement(sql);
	    preparedStatement.setString(1, firstName);
	    preparedStatement.setString(2, lastName);
	    
	    ResultSet rs = preparedStatement.executeQuery();

	    while(rs.next()){  
	    	int id = rs.getInt("id");
	    	firstName = rs.getString("first_name");
	    	lastName = rs.getString("last_name");
	    	System.out.println("ID : " +id);
	    	System.out.println("Nome: "+firstName);
	    	System.out.println("Apelido: "+lastName);
	          }
	    rs.close();
	}

	public static void ejercicio5(Connection connection) throws SQLException {
		// 5. Crear a partir de las variables nombre, apellido, direccion, ciudad y
		// teléfono (todas de tipo
		// String), un nuevo owner
		String nombre = "Jose";
		String apellido = "Morais";
		String direccion = "Rua dos Arneiros";
		String ciudade = "Lisboa";
		String telefono = "91589856";
		
		//Statement statement = connection.createStatement();
	    String sql = "INSERT INTO owners VALUES (null,?,?,?,?,?)"; //cada "?" corresponde a uma posição do setString(posição do ? , atributo string)
	    
	    PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, nombre);
		preparedStatement.setString(2,apellido);
		preparedStatement.setString(3, direccion);
		preparedStatement.setString(4, ciudade);
		preparedStatement.setString(5, telefono);
		preparedStatement.executeUpdate();
		int numeroDeFilasModificadas = preparedStatement.executeUpdate();
		System.out.println("Se han modificado " + numeroDeFilasModificadas + " rows.");

	}

	public static void reto(Connection connection, Statement statement) throws SQLException {
		
		Owner novoOwner = new Owner();
		Pet novoPet = new Pet();
		
		/* OWNER */
		novoOwner.setId(null);
		novoOwner.setFirstName("Emanuel");
		novoOwner.setLastName("Morais");
		novoOwner.setAddress("Rua dos Arneiros");
		novoOwner.setCity("Lisboa");
		novoOwner.setTelephone("914511943");
		
		/* PET */
		novoPet.setId(null);
		Date date = new Date(2010-10-10);
		novoPet.setBirthDate(date );
		novoPet.setName("Bobby");
		//novoPet.setType(cat);
		
		/*INSERT INTO OWNERS VALUES*/
		String sql = "INSERT INTO owners VALUES (null,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1,novoOwner.getFirstName());
		preparedStatement.setString(2,novoOwner.getLastName());
		preparedStatement.setString(3,novoOwner.getAddress());
		preparedStatement.setString(4,novoOwner.getCity());
		preparedStatement.setString(5,novoOwner.getTelephone());
		preparedStatement.executeUpdate();
		
		/*GET OWNER_ID*/
		String sqlOwnerID = "SELECT id FROM owners WHERE first_name = ? OR last_name= ?";
		PreparedStatement preparedStatement2 = connection.prepareStatement(sqlOwnerID);
	    preparedStatement2.setString(1, novoOwner.getFirstName());
	    preparedStatement2.setString(2, novoOwner.getLastName());
	    
	    ResultSet rs = preparedStatement2.executeQuery();
	    
	    int id = 0;
	    
	    while(rs.next()){  
	    	id = rs.getInt("id");
	          }
	    rs.close();

		
		/* INSERT INTO PETS VALUES*/
		String sqlpet = "INSERT INTO pets VALUES(null,?,?,?,?)";
		PreparedStatement preparedStatement1 = null;
		preparedStatement1 = connection.prepareStatement(sqlpet);
		preparedStatement1.setString(1,novoPet.getName());
		 preparedStatement1.setString(2,novoPet.getBirthDate().toString()); 
		preparedStatement1.setInt(3,id);
		preparedStatement1.setInt(4,5);

		preparedStatement1.executeUpdate();
	}
	


}
