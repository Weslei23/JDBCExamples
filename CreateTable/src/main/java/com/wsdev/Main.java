package com.wsdev;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main
{
    static void main() throws SQLException
    {
        Connection connection = DatabaseConnection.getDatabaseConnection();
        System.out.println( "Conexão realizada com sucesso!" );

        String sql = "CREATE TABLE tb_pessoas ("
                + "codigo INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, "
                + "nome VARCHAR(80) NOT NULL"
                + ")";

        PreparedStatement statement = connection.prepareStatement( sql );
        statement.execute();

        System.out.println( "Tabela criada com suceso!" );
        
        connection.close();
    }
}
