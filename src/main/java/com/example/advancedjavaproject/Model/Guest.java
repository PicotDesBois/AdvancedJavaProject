package com.example.advancedjavaproject.Model;

import java.util.ArrayList;

public class Guest extends Customer{

    // Builder //
    public Guest(String name,String surname)
    {
        m_CuName=name;
        m_CuSurname=surname;
        m_ticket=new ArrayList<>();
    }
}
