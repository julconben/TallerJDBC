package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicios {

    public static void ejercicio1(Connection connection, Statement statement) throws SQLException {
        // Obtener todos los clientes de la clinica y mostrar sus datos por pantalla
        statement = connection.createStatement();
        String sql = "SELECT * FROM owners";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String address = rs.getString("address");
            String city = rs.getString("city");
            String telephone = rs.getString("telephone");

            System.out.print("Id: " + id);
            System.out.print(", Nombre: " + firstName);
            System.out.print(", Apellidos: " + lastName);
            System.out.print(", Dirección: " + address);
            System.out.print(", Ciudad: " + city);
            System.out.println(", Teléfono: " + telephone);

        }
        rs.close();
    }

    public static void ejercicio2(Connection connection, Statement statement) throws SQLException {
        // 2. Insertarnos a nosotros como nuevo propietario de una mascota
        statement = connection.createStatement();
        String sql = "INSERT INTO owners (first_name, last_name, address, city, telephone) "
                + "VALUES ('Julio', 'Benavides', 'Mi dirección', 'Sevilla', '666666666')";
        int numeroDeFilasModificadas = statement.executeUpdate(sql);
        System.out.println("Se han modificado " + numeroDeFilasModificadas + " rows.");

    }

    public static void ejercicio3(Connection connection, Statement statement) throws SQLException {
        // 3. Modificar nuestra ciudad por Sevilla
        statement = connection.createStatement();
        String sql = "UPDATE owners " + "SET city = 'Sevilla'" + "WHERE first_name = 'Marcos'";
        int numeroDeFilasModificadas = statement.executeUpdate(sql);
        System.out.println("Se han modificado " + numeroDeFilasModificadas + " rows.");

    }

    public static void ejercicio4(Connection connection) throws SQLException {
        // 4. Crear una variable de tipo String y buscar todos los Owner que coincidan en nombre o apellido.
        String sql = "SELECT * FROM owners WHERE first_name LIKE ? OR last_name LIKE ?";
        String busqueda = "Da";
        String termino = "%" + busqueda + "%";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, termino);
        prepareStatement.setString(2, termino);
        ResultSet rs = prepareStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");

            System.out.print("Id: " + id);
            System.out.print(", Nombre: " + firstName);
            System.out.println(", Apellidos: " + lastName);
        }
        rs.close();

    }

    public static void ejercicio5(Connection connection) throws SQLException {
        // 5. Crear a partir de las variables nombre, apellido, direccion, ciudad y teléfono (todas de tipo
        // String), un nuevo owner
        String[] valores;
        valores = new String[] { "Marcos", "Ginel", "Mi casa", "Sevilla", "666666666" };
        String sql = "INSERT INTO owners (first_name, last_name, address, city, telephone)  VALUES(?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < valores.length; i++)
            preparedStatement.setString(i + 1, valores[i]);

        int numeroDeFilasModificadas = preparedStatement.executeUpdate();
        System.out.println("Se han modificado " + numeroDeFilasModificadas + " rows.");

    }

    public static void reto(Connection connection, Statement statement) throws SQLException {

    }

}
