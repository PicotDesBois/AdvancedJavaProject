package com.example.advancedjavaproject.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MovieShow {

    // Attribute //
    private Customer m_client;
    private Room m_room;
    private int m_price;
    private LocalDateTime m_movieShowTime;
    private Movie m_movie;

    // Access //
    public MovieShow(Customer client, Room room,int price,LocalDateTime movieShowTime,Movie movie)
    {
        m_client=client;
        m_room=room;
        m_price=price;
        m_movieShowTime=movieShowTime;
        m_movie=movie;
    }

    // Access //

    public Movie getM_movie() {
        return m_movie;
    }

    public Customer getM_client() {
        return m_client;
    }

    public int getM_price() {
        return m_price;
    }

    public LocalDateTime getM_movieShowTime() {
        return m_movieShowTime;
    }

    public Room getM_room() {
        return m_room;
    }

    public void setM_client(Customer m_client) {
        this.m_client = m_client;
    }

    public void setM_price(int m_price) {
        this.m_price = m_price;
    }

    public void setM_room(Room m_room) {
        this.m_room = m_room;
    }
}
