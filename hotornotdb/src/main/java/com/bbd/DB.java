package com.bbd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bbdnet1523 on 2016/12/09.
 */
public class DB {

    Connection conn;

    public DB(Connection conn) {
        this.conn = conn;
    }

    public double getAverageCars()
    {
        double avg = 0;

        try {
            Statement stm = conn.createStatement();

            String sql = "SELECT AVG(rating) AS Average FROM Cars";

            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                avg = rs.getDouble("Average");
            }
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return avg;

    }

    public double getAverageCelebs()
    {
        double avg = 0;

        try {
            Statement stm = conn.createStatement();

            String sql = "SELECT AVG(rating) AS Average FROM CELEBRITIES ";

            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                avg = rs.getDouble("Average");
            }
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return avg;

    }

    public List<Cars> getCars() {
        List<Cars> carsList = new ArrayList<Cars>();

        String sql = "SELECT * FROM Cars";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()) {
                Cars car = new Cars(rs.getInt("rating"), rs.getString("imageURL"), rs.getString("model"), rs.getString("make"));
                carsList.add(car);
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return carsList;
    }

    public List<Celeb> getCelebs() {
        List<Celeb> celebsList = new ArrayList<Celeb>();

        String sql = "SELECT * FROM Celebrities";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()) {
                Celeb cel = new Celeb(rs.getInt("rating"), rs.getString("imageURL"), rs.getString("name"), rs.getString("surname"));
                celebsList.add(cel);
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return celebsList;
    }
}
