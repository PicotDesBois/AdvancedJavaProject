package com.example.advancedjavaproject.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Employees {

    // Attribute //

    private String m_EmName;
    private String m_EmSurname;
    private Password m_password;

    // Builder //
    public Employees(Password password)
    {
        m_password=password;
    }

    // Access //

    public String getM_EmName() {
        return m_EmName;
    }

    public String getM_EmSurname() {
        return m_EmSurname;
    }

    /*
        return true if it found the corresponding ID account
        + load the account
     */
    public boolean getDatabase()
    {
        boolean find=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Changer mydb par le nom de la base
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=FALSE", "root", "");


            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM `employees` WHERE Password_email = '" + m_password.getM_email()+"'");
            while(rs.next())
            {
                m_EmName= rs.getString("EmName");
                m_EmSurname=rs.getString("EmSurname");
                find=true;
            }
            System.out.println("EmName "+m_EmName);
            System.out.println("EmSurname"+m_EmSurname);
            con.close();
        } catch (Exception e1) {
            System.out.println(e1);
        }
        return find;
    }
}
