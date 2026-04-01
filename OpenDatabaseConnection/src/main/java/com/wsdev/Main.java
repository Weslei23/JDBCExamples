package com.wsdev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main
{
    static void main()
    {
        String url = "jdbc:postgresql://localhost/";
        String user = "postgres";
        String password = "12345678";

        try
        {
            Connection connection = DriverManager.getConnection( url, user, password );

            System.out.println( "Conectado com sucesso." );

            connection.close();
        }
        catch ( SQLException e )
        {
            System.out.println( "Erro ao conectar ao banco: "  + e.getMessage() );
        }
    }
}
