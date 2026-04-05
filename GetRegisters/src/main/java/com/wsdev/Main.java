package com.wsdev;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    static void main() throws SQLException
    {
        Connection connection = DatabaseConnection.getDatabaseConnection();

        String sql = "SELECT * FROM tb_pessoas";

        PreparedStatement statement = connection.prepareStatement( sql );

        ResultSet resultSet = statement.executeQuery();

        List<Pessoa> pessoas = new ArrayList<>();

        while ( resultSet.next() )
        {
            int codigo = resultSet.getInt( "codigo" );
            String nome = resultSet.getString( "nome" );

            pessoas.add( new Pessoa( codigo, nome ) );

        }

        statement.close();
        connection.close();

        for ( Pessoa pessoa : pessoas )
        {
            System.out.println( pessoa.getCodigo() );
            System.out.println( pessoa.getNome() );
        }
    }
}
