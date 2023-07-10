package com.example.advancedjavaproject.Model;

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
}
