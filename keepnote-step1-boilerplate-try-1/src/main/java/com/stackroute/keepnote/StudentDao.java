package com.stackroute.keepnote;
import java.sql.*;

public class StudentDao {

    Connection connection=null;
    public void connect() throws SQLException {
        String url="jdbc:mysql://localhost:3306/world";
        String userName="root";
        String pass="RT@mysql2019";
        connection=DriverManager.getConnection(url,userName,pass);
    }

    public Student getStudent(int rollNo) throws SQLException {
        Student s=new Student();
        s.setRollNo(rollNo);
        String query="select * from students_table where rollNo="+rollNo+";";

        Statement statement=connection.createStatement();
        ResultSet QueryResult=statement.executeQuery(query);
        QueryResult.next();
        s.setsName(QueryResult.getString(2));
        return s;
    }

    public void addStudentInTable(Student newStud) throws SQLException {
        String query="insert into students_table values (?,?)";
        PreparedStatement pst=connection.prepareStatement(query);
        pst.setInt(1,newStud.getRollNo());
        pst.setString(2,newStud.getsName());
        int rowsAffected=pst.executeUpdate();
        System.out.println("number of rows affected = "+rowsAffected);
    }
}
