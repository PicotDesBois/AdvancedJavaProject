package com.example.advancedjavaproject.Model;

public class Employees {

    // Attribute //

    private String m_EmName;
    private String m_EmSurname;
    private Password m_password;

    // Builder //
    public Employees(String name,String surname,Password password)
    {
        m_EmName=name;
        m_EmSurname=name;
        m_password=password;
    }

    // Access //

    public String getM_EmName() {
        return m_EmName;
    }

    public String getM_EmSurname() {
        return m_EmSurname;
    }
}
