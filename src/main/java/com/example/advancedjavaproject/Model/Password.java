package com.example.advancedjavaproject.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Password {

    // Attribute //
    String m_email;
    String m_password;

    // Builder //
    public Password(String email, String password)
    {
        m_email=email;
        m_password=password;
    }

    // Read database //
    public boolean getDataBase()
    {
        boolean find=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Changer mydb par le nom de la base
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=FALSE", "root", "");


            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM `password` WHERE email = '" + m_email + "' AND PaSecretCode = '" + m_password + "'");
            while(rs.next())
            {
                m_email=rs.getString("email");
                m_password=rs.getString("PaSecretCode");
                find=true;
            }

            con.close();
        } catch (Exception e1) {
            System.out.println(e1);
        }
        return find;
    }
    // Access //

    public String getM_email() {
        return m_email;
    }

    public String getM_password() {
        return m_password;
    }

    public void setM_password(String password) {
        m_password = password;
    }

    public Password getObject()
    {
        return this;
    }
}
