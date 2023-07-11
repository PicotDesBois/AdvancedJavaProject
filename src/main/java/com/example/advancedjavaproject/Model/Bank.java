package com.example.advancedjavaproject.Model;

import javafx.util.StringConverter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class Bank {
    String m_cardNumber;
    String m_name;
    LocalDate m_expirationDate;
    int m_CVV;
    Customer m_customer;

    /// Builder ///
    public Bank(String cardNumber, String name, LocalDate date, String CVV)
    {
        m_cardNumber=cardNumber;
        m_name=name;
        m_expirationDate= date;
        m_CVV= Integer.parseInt(CVV);
    }

    /// Access //


    // Read database //
    public void getDataBase()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Changer mydb par le nom de la base
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies_project?useSSL=FALSE", "root", "");


            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM `bank` ");
            while (rs.next())
            {
                System.out.println(rs.getString("Name"));
                System.out.println(rs.getString("Type_Card"));
                System.out.println(rs.getString("Number_Card"));
                System.out.println(rs.getString("Date_Exp"));
                System.out.println(rs.getString("CVV"));
                System.out.println(rs.getString("Balance"));


                /*m_name=rs.getString("Name");
                m_cardNumber= rs.getString("Number_Card");
                m_CVV= Integer.parseInt(rs.getString("CVV"));
                m_expirationDate=LocalDate.parse(rs.getString("Date_Exp"));
                */

                System.out.println(m_expirationDate);
                System.out.println(m_name);
                System.out.println(m_cardNumber);
                System.out.println(m_CVV);
            }

            con.close();
        } catch (Exception e1) {
            System.out.println(e1);
        }
    }

    // Write attribute in database
    public void setDatabase()
    {
        try {
            // Établir la connexion à la base de données
            String url = "jdbc:mysql://localhost:3306/movies_project";
            Connection connection = DriverManager.getConnection(url, "root", "");

            // Créer un objet Statement
            Statement statement = connection.createStatement();

            String name = "'" + m_name + "'";
            String cardNumber = "'" + m_cardNumber + "'";
            String expirationDate = "'" + m_expirationDate.toString() + "'";
            String CVV = Integer.toString(m_CVV);

            // Écrire la requête SQL pour l'insertion en utilisant les variables échappées
            String query = "INSERT INTO `bank` (`Name`, `Type_Card`, `Number_Card`, `Date_Exp`, `CVV`, `Balance`) VALUES " +
                    "(" + name + ", 'Mastercard', " + cardNumber + ", " + expirationDate + ", " + CVV + ", 2000)";


            // Exécuter la requête SQL
            statement.executeUpdate(query);

            // Fermer les ressources
            statement.close();
            connection.close();

            System.out.println("Données insérées avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
