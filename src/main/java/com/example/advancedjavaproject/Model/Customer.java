package com.example.advancedjavaproject.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

 public class Customer {

    // Attribute
    protected String m_CuName;
    protected String m_CuSurname;
    protected ArrayList<MovieShow> m_ticket;


    // Access //
    public String getM_CuName() {
        return m_CuName;
    }

    public String getM_CuSurname() {
        return m_CuSurname;
    }

     public int saveMember()
     {
         int number=1;
         try {
             // Établir la connexion à la base de données
             String url = "jdbc:mysql://localhost:3306/mydb";
             Connection connection = DriverManager.getConnection(url, "root", "");

             // Créer un objet Statement
             Statement statement = connection.createStatement();

             ResultSet rs = statement.executeQuery("SELECT * FROM `customer` ");
             while (rs.next())
             {
                 number++;
             }

             // Écrire la requête SQL pour l'insertion en utilisant les variables échappées
             String query = "INSERT INTO `customer` (`idCustomer`, `CuName`, `CuSurname`) VALUES (" + number + ", '" + m_CuName + "', '" + m_CuSurname + "')";



             // Exécuter la requête SQL
             statement.executeUpdate(query);

             // Fermer les ressources
             statement.close();
             connection.close();

             System.out.println("Données insérées avec succès !");
         } catch (Exception e) {
             e.printStackTrace();
         }
         return number;
     }
}
