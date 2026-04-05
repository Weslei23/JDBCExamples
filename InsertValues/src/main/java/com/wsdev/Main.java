package com.wsdev;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main
{
    static void main() throws SQLException
    {
        Scanner scanner = new Scanner( System.in );

        System.out.println( "Digite um nome: " );
        String nome = scanner.nextLine();

        Connection connection = DatabaseConnection.getDatabaseConnection();

        System.out.println( "Conexão criada com sucesso!" );

        String sql = "INSERT INTO tb_pessoas (nome) VALUES (?)";

        PreparedStatement statement = connection.prepareStatement( sql );
        statement.setString(1, nome );
        statement.execute();

        System.out.println( "Pessoa adicionada com sucesso!");

        scanner.close();
        connection.close();
    }
}
