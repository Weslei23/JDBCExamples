package com.wsdev;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    static void main() throws SQLException
    {
        Scanner scanner = new Scanner( System.in );

        System.out.println( "Por qual texto deseja filtrar? " );
        String texto = scanner.nextLine();

        Connection connection = DatabaseConnection.getDatabaseConnection();

        String sql = "SELECT * FROM tb_pessoas WHERE nome LIKE ?";

        PreparedStatement statement = connection.prepareStatement( sql );
        statement.setString( 1, "%" + texto + "%" );

        ResultSet resultSet = statement.executeQuery();

        List<Pessoa> pessoas = new ArrayList<>();

        while ( resultSet.next() )
        {
            String nome = resultSet.getString( "nome" );
            pessoas.add( new Pessoa( nome ) );
        }

        for( Pessoa pessoa : pessoas )
        {
            System.out.println( pessoa.getNome() );
        }
        connection.close();
        scanner.close();
        statement.close();
    }
}
