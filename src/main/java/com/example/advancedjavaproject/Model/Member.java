package com.example.advancedjavaproject.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Member extends Customer{

    // Attribute //
    Password m_password;

    // Builder //
    public Member(Password password)
    {
        /*m_CuName=name;
        m_CuSurname=surname;*/
        m_password=password;
    }

    /*
        return true if the account is a member account

     */
    public boolean getDatabase()
    {
        boolean find = false;
        int idCustomer=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Changer mydb par le nom de la base
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=FALSE", "root", "");


            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM `member` WHERE PaPassword_email = '" + m_password.getM_email()+"'");
            while(rs.next())
            {
                idCustomer= Integer.parseInt(rs.getString("Customer_idCustomer"));
                find=true;
            }
            con.close();
        } catch (Exception e1) {
            System.out.println(e1);
        }
        if(idCustomer!=0)
            getAccount(idCustomer);
        return find;
    }

    /*
        load the account with the corresponding ID account
     */
    public void getAccount(int idCustomer)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Changer mydb par le nom de la base
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=FALSE", "root", "");


            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM `customer` WHERE idCustomer = '" + idCustomer+"'");
            while(rs.next())
            {
                m_CuName= rs.getString("CuName");
                m_CuSurname=rs.getString("CuSurname");
            }
            System.out.println("Name : "+m_CuName);
            System.out.println("Surname : "+m_CuSurname);
            con.close();
        } catch (Exception e1) {
            System.out.println(e1);
        }
    }

}
