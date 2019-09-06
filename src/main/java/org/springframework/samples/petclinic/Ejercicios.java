package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.Pet;
public class Ejercicios {

	public static void ejercicio1(Connection connection, Statement statement) throws SQLException {
		// 1. btener todos los clientes de la clinica y mostrar sus datos por pantalla
		String sql = "SELECT * FROM owners ;";
		PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement(sql);
//		preparedStatement.setInt();
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

		String sql = "INSERT INTO owners VALUES(null,'Sofia','Condesso','Moscavide','Lisboa','911111')";
		int numeroDeFilasModificada = statement.executeUpdate(sql);
	}

	public static void ejercicio3(Connection connection, Statement statement) throws SQLException {
		// 3. Modificar nuestra ciudad por Sevilla
		statement = connection.createStatement();
		String sql = "UPDATE owners SET city ='Sevilha' WHERE city='Lisboa'";
		int numeroDeFilasModificada = statement.executeUpdate(sql);
	}

	public static void ejercicio4(Connection connection) throws SQLException {
		// 4. Crear una variable de tipo String y buscar todos los Owner que coincidan
		// en nombre o apellido.
		String name = "Sofia";
		String sql = "SELECT * FROM owners WHERE (first_name=? OR last_name=? );";
		PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, name);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");

			System.out.print("Id: " + id);
			System.out.print(",Nombre: " + firstName);
			System.out.print(",Apelido: " + lastName);
		}
		rs.close();
	}

	public static void ejercicio5(Connection connection) throws SQLException {
		// 5. Crear a partir de las variables nombre, apellido, direccion, ciudad y
		// teléfono (todas de tipo
		// String), un nuevo owner
		String nombre = "João";
		String apellido = "Anjos";
		String address = "Rua do Lago";
		String city = "Almeirim";
		String telefone = "9111";
		String sql = "INSERT INTO owners VALUES (null,?,?,?,?,?);";
		PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, nombre);
		preparedStatement.setString(2, apellido);
		preparedStatement.setString(3, address);
		preparedStatement.setString(4, city);
		preparedStatement.setString(5, telefone);
		preparedStatement.executeUpdate();
//		while (rs.next()) {
//			int id = rs.getInt("id");
//			String firstName = rs.getString("first_name");
//			String lastName = rs.getString("last_name");
//
//			System.out.print("Id: " + id);
//			System.out.print(",Nombre: " + firstName);
//			System.out.print(",Apelido: " + lastName);
//		}
//		rs.close();

	}

	public static void reto(Connection connection, Statement statement) throws SQLException {
		Owner novoOwner = new Owner();
				
		novoOwner.setId(null);
		novoOwner.setFirstName("Pedro");
		novoOwner.setLastName("Veado");
		novoOwner.setCity("Santarem");
		novoOwner.setAddress("Rua Dos Mouros");
		
		Pet novoPet = new Pet();
		
		novoPet.setId(null);
		novoPet.setName("Negão");
		Date data = new Date(2009-12-19);
		novoPet.setBirthDate(data);
		
		String sql = "INSERT INTO owners VALUES(null,?,?,?,?,?)";
		PreparedStatement preparedStatement= null;
		preparedStatement= connection.prepareStatement(sql);
		preparedStatement.setString(1, novoOwner.getFirstName());
		preparedStatement.setString(2, novoOwner.getLastName());
		preparedStatement.setString(3, novoOwner.getAddress());
		preparedStatement.setString(4, novoOwner.getCity());
		preparedStatement.setString(5, novoOwner.getTelephone());
		statement.executeUpdate(sql);


		statement = connection.createStatement();
		String sql1= "SELECT * FROM owners WHERE firs_name='Pedro' AND last_name='Veado'";
		ResultSet rs= statement.executeQuery(sql1);
		int id=0;
		
		while (rs.next()) {
			id=rs.getInt("id");
		}

		String sql3 = "INSERT INTO pets VALUES (null,?,?,?,?)";
		preparedStatement = connection.prepareStatement(sql3);
		preparedStatement.setString(1, "Negão");
		preparedStatement.setDate(2, data);
		preparedStatement.setInt(3, id);
		preparedStatement.setInt(4, 5);
		preparedStatement.executeUpdate();

		sql = "DELETE * FROM owners WHERE id=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.execute(sql);
	}

}
