package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.springframework.samples.petclinic.owner.Owner;

public class Ejercicios {

	public static void ejercicio1(Connection connection, Statement statement) throws SQLException {
		// 1. btener todos los clientes de la clinica y mostrar sus datos por pantalla
		statement = connection.createStatement();
		String sql = "SELECT * FROM owners;";
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			System.out.print("Id: " + rs.getInt("id"));
			System.out.print(", Nombre: " + rs.getString("first_name"));
			System.out.print(", Apellidos: " + rs.getString("last_name"));
			System.out.print(", Endereco: " + rs.getString("address"));
			System.out.print(", Cidade: " + rs.getString("city"));
			System.out.println(", Telefone: " + rs.getString("telephone"));
		}
	}

	public static void ejercicio2(Connection connection, PreparedStatement preparedStatement) throws SQLException {
		// 2. Insertarnos a nosotros como nuevo propietario de una mascota

		String sql = "INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES (?, ?, ?,?, ?);";
		preparedStatement = connection.prepareStatement(sql);		
		preparedStatement.setString(1, "Alexander");
		preparedStatement.setString(2, "Neto");
		preparedStatement.setString(3, "XPTO");
		preparedStatement.setString(4, "Lisbon");
		preparedStatement.setString(5, "60606060606");
		int numeroDeFilasModificadas = -1;
		numeroDeFilasModificadas=preparedStatement.executeUpdate();
		System.out.println("Se han insertado " + numeroDeFilasModificadas + " rows.");
	}

	public static void ejercicio3(Connection connection, PreparedStatement preparedStatement) throws SQLException {
		// 3. Modificar nuestra ciudad por Sevilla
		String sql = "UPDATE owners SET  city = ? WHERE id = ?;";
		preparedStatement = connection.prepareStatement(sql);		
		preparedStatement.setString(1, "Sevilla");
		preparedStatement.setInt(2, 11);
		int numeroDeFilasModificadas=preparedStatement.executeUpdate();	
		
		//int numeroDeFilasModificadas = -1;
		System.out.println("Se han modificado " + numeroDeFilasModificadas + " rows.");

	}

	public static void ejercicio4(Connection connection, PreparedStatement preparedStatement) throws SQLException {
		// 4. Crear una variable de tipo String y buscar todos los Owner que coincidan
		// en nombre o apellido.
		String name ="Alexander";
		String sql="select * from owners where first_name = ? or last_name = ?;";
		preparedStatement = connection.prepareStatement(sql);		
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, name);
		//statement = connection.createStatement();
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
			System.out.print("Id: " + rs.getInt("id"));
			System.out.print(", Nombre: " + rs.getString("first_name"));
			System.out.print(", Apellidos: " + rs.getString("last_name"));
			System.out.print(", Endereco: " + rs.getString("address"));
			System.out.print(", Cidade: " + rs.getString("city"));
			System.out.println(", Telefone: " + rs.getString("telephone"));
		}

	}

	public static void ejercicio5(Connection connection, PreparedStatement preparedStatement) throws SQLException {
		// 5. Crear a partir de las variables nombre, apellido, direccion, ciudad y
		// teléfono (todas de tipo
		// String), un nuevo owner
		String nombre = "Marcio", apellido = "Pires", direccion = "Av da Malhoa", ciudad = "Setubal", telephone = "300303003";
		String sql = "INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES (?, ?, ?,?, ?);";
		preparedStatement = connection.prepareStatement(sql);		
		preparedStatement.setString(1, nombre);
		preparedStatement.setString(2, apellido);
		preparedStatement.setString(3, direccion);
		preparedStatement.setString(4, ciudad);
		preparedStatement.setString(5, telephone);
		int numeroDeFilasModificadas = -1;
		numeroDeFilasModificadas=preparedStatement.executeUpdate();
		
		System.out.println("Se han creado " + numeroDeFilasModificadas + " rows.");

	}

	@SuppressWarnings("deprecation")
	public static void reto(Connection connection, PreparedStatement preparedStatement, Statement statement, Owner owner) throws SQLException {
		
		String sql = "INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES (?, ?, ?,?, ?);";
		preparedStatement = connection.prepareStatement(sql);		
		preparedStatement.setString(1, owner.getFirstName());
		preparedStatement.setString(2, owner.getLastName());
		preparedStatement.setString(3, owner.getAddress());
		preparedStatement.setString(4, owner.getCity());
		preparedStatement.setString(5, owner.getTelephone());
		int numeroDeFilasModificadas = -1;
		numeroDeFilasModificadas=preparedStatement.executeUpdate();
		System.out.println("Se han insertado " + numeroDeFilasModificadas + " rows.");
		
		statement = connection.createStatement();
		String sql1 = "SELECT Id FROM owners WHERE first_name = '"+ owner.getFirstName() + "' AND last_name ='"+ owner.getLastName()+"'";
		ResultSet rs = statement.executeQuery(sql1);
		int OwnerId = 0;
		while(rs.next()) {
			OwnerId=rs.getInt("id");
		}
		
		String sql2 = "INSERT INTO pets (name, birth_date, owner_id, type_id) VALUES (?, ?, ?,?);";
		preparedStatement = connection.prepareStatement(sql2);		
		preparedStatement.setString(1, "Boby");
		preparedStatement.setString(2, "2018/08/01");
		preparedStatement.setInt(3, OwnerId);
		preparedStatement.setInt(4, 2);
		preparedStatement.executeUpdate();
		System.out.println("Se han insertado una Mascota numero " + owner.getFirstName() + " rows.");	
		
	}

}
