package com.example.advancedjavaproject.Model;

public class Movie {

    // Attribute //
    private String m_MoName;
    private int m_time;
    private String m_bio;

    // Builder //
    public Movie(String name, int time, String bio)
    {
        m_MoName=name;
        m_time=time;
        m_bio=bio;
    }

    // Access //
    public String getM_MoName() {
        return m_MoName;
    }

    public int getM_time() {
        return m_time;
    }

    public String getM_bio() {
        return m_bio;
    }
}

