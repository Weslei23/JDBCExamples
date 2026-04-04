package com.wsdev;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main
{
    static void main()
    {
        try
        {
            Connection connection = DatabaseConnection.getDatabaseConnection();

            String sql = "CREATE DATABASE teste_was";

            PreparedStatement statement = connection.prepareStatement( sql );
            statement.execute();

            System.out.println( "Database criado com sucesso." );

            connection.close();
        } catch ( Exception e )
        {
            System.out.println( "Erro ao criar o database: " + e.getMessage() );
        }
    }
}
