package com.example.advancedjavaproject.Model;

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
}
