package com.example.advancedjavaproject.Model;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Room {

    // Attribute //

    private int m_seatNumber;
    ArrayList<LocalDateTime> m_schedule;


    // Builder //
    public Room(int seatNumber)
    {
        m_seatNumber=seatNumber;
        m_schedule=new ArrayList<>();
    }

    // Access //

    public ArrayList<LocalDateTime> getM_schedule() {
        return m_schedule;
    }

    public int getM_seatNumber() {
        return m_seatNumber;
    }

    public void setAddM_schedule(LocalDateTime movieShowTime) {
        m_schedule.add(movieShowTime);
    }

    public void setRemoveM_schedule(int index) {
       m_schedule.remove(index);
    }

    public void setM_seatNumber(int seatNumber) {
        m_seatNumber = seatNumber;
    }
}
