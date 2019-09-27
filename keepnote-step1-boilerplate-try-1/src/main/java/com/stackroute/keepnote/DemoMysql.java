package com.stackroute.keepnote;
import java.sql.*;

public class DemoMysql {
    public static void main(String[] args) throws Exception
    {
        String url="jdbc:mysql://localhost:3306/world";
        String userName="root";
        String pass="RT@mysql2019";
        String query="select * from city where Id<10";

        //Class.forName("com.mysql.jdbc.Driver");
        Connection connection=DriverManager.getConnection(url,userName,pass);

    /**********************************************************************************/
        Statement statement=connection.createStatement();
        ResultSet headQueryResult=statement.executeQuery("desc city");
        while (headQueryResult.next())
        {
            System.out.print(headQueryResult.getString("Field")+"\t");
        }
        System.out.println();
        /*****************************************************************************/
        //System.out.println(columns);
        //resultSet.next();
        //String cName=resultSet.getString("Name");
        //System.out.println("fetched city name= "+cName);


        /*********************************************************************************/
        Statement statement2=connection.createStatement();
        ResultSet resultSet=statement2.executeQuery(query);
        String city_data="";
        while(resultSet.next())
        {
            city_data=resultSet.getInt(1)
                    + " \t: "+resultSet.getString(2)
                    +" \t: "+resultSet.getString("CountryCode")
                    +" \t: "+resultSet.getString("District")
                    +" \t: "+resultSet.getBigDecimal("Population");
            System.out.println(city_data);
        }
        /******************************************************************************************/

         StringBuilder sb=new StringBuilder("CREATE TABLE students_table( rollNo INT(6) UNSIGNED AUTO_INCREMENT " +
                 "PRIMARY KEY, " + "sName VARCHAR(30) NOT NULL)");

        String createTableQuery=sb.toString();
        Statement statement3=connection.createStatement();
        statement3.executeUpdate(createTableQuery);


/*        StringBuilder sb2=new StringBuilder("INSERT INTO MyGuests (firstname, lastname, email) VALUES ('John', 'Doe', 'john@example.com')");
        Statement statement3=connection.createStatement();
        int rowsAffected=statement3.executeUpdate(sb2.toString());
        System.out.println(rowsAffected);*/
        statement.close();
        connection.close();
    }

}
