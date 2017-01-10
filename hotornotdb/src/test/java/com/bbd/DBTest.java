package com.bbd;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by bbdnet1523 on 2016/12/09.
 */
public class DBTest {

    Connection conn;
    DB dataBase;
    File file;
    FileWriter writer;

    @Before
    public void setUp() throws Exception {
        conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
        dataBase = new DB(conn);

        file = new File("E:/export.csv");
        if (file.exists())
            file.delete();

        writer = new FileWriter(file);
    }

    @Test
    public void testCarsAvg() throws Exception {
        double avg = dataBase.getAverageCars();
        assertEquals(2d, avg,0.001d);
    }

    @Test
    public void testCelebAvg() throws Exception {
        double avg = dataBase.getAverageCelebs();
        assertEquals(1d, avg,0.001d);
    }

    @Test
    public void testCarAvgList() throws Exception {
        List<Cars> cars = dataBase.getCars();
        double avg = 0;
        for (Cars c: cars) {
            avg += c.getRating();
        }
        avg = (double)avg/cars.size();
        assertEquals(avg, dataBase.getAverageCars(), 0.001d);
    }

    @Test
    public void testCelebAvgList() throws Exception {
        List<Celeb> cars = dataBase.getCelebs();
        double avg = 0;
        for (Celeb c: cars) {
            avg += c.getRating();
        }
        avg = (double)avg/cars.size();
        assertEquals(avg, dataBase.getAverageCelebs(), 0.001d);
    }

    @Test
    public void exportCSV() throws Exception {
        String data = "Category,AverageRating\n";
        data += "Cars," + dataBase.getAverageCars() + "\n";
        data += "Celebraties," + dataBase.getAverageCelebs() + "\n";

        writer.write(data);
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
        writer.close();
    }
}
