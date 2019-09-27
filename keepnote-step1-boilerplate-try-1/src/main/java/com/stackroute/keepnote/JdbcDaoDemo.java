package com.stackroute.keepnote;

public class JdbcDaoDemo {

    public static void main(String[] args) throws Exception
    {
        StudentDao sdao=new StudentDao();
/*        Student studentDD=sdao.getStudent(12);
        System.out.println(studentDD.getRollNo());
        System.out.println(studentDD.getsName());*/

        Student newStud=new Student();
        newStud.setsName("barun");
        newStud.setRollNo(23);

        sdao.connect();
        sdao.addStudentInTable(newStud);
    }

}
