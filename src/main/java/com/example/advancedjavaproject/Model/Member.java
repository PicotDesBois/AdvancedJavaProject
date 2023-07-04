package com.example.advancedjavaproject.Model;

public class Member extends Customer{

    // Attribute //
    Password m_password;

    // Builder //
    public Member(String name,String surname,Password password)
    {
        m_CuName=name;
        m_CuSurname=surname;
        m_password=password;
    }

}
