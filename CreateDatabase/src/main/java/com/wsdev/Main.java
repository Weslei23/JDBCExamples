package com.wsdev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main
{
    static void main()
    {
        //Necessário passar as informações do DB.
        final String url = "jdbc:postgresql://localhost:5432/";
        final String user = "postgres";
        final String password = "12345678";

        //Sempre irá lançar uma exception, necessário trata-la.
        try
        {
            //Responsável por criar a conexão com o DB.
            Connection connection = DriverManager.getConnection( url, user, password );

            //Responsável por executar querys.
            PreparedStatement statement = connection.prepareStatement( "CREATE DATABASE novo_database" );
            statement.execute();

            System.out.println( "Database criado com sucesso!" );
            connection.close();
        }
        catch ( SQLException e )
        {
            System.out.println( "Erro ao conectar no banco de dados: " + e.getMessage() );
        }
    }
}
