package com.business.entities;


import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.Date;
import org.junit.jupiter.api.Test;

public class Orders_setOrderDate_f05b775bcf_Test {

    private Orders orders;
    private Date testDate;

    @BeforeEach
    public void setUp() {
        orders = new Orders();
        testDate = new Date();
    }

    @Test
    public void testSetOrderDate_ValidDate() {
        orders.setOrderDate(testDate);
        Assertions.assertEquals(testDate, orders.getOrderDate());
    }

    @Test
    public void testSetOrderDate_Null() {
        orders.setOrderDate(null);
        Assertions.assertNull(orders.getOrderDate());
    }

    @Test
    public void testSetOrderDate_FutureDate() {
        testDate.setTime(testDate.getTime() + (1000 * 60 * 60 * 24));
        orders.setOrderDate(testDate);
        Assertions.assertEquals(testDate, orders.getOrderDate());
    }

    @Test
    public void testSetOrderDate_PastDate() {
        testDate.setTime(testDate.getTime() - (1000 * 60 * 60 * 24));
        orders.setOrderDate(testDate);
        Assertions.assertEquals(testDate, orders.getOrderDate());
    }

    @Test
    public void testSetOrderDate_CurrentDate() {
        orders.setOrderDate(new Date());
        Assertions.assertNotNull(orders.getOrderDate());
    }

    @Test
    public void testSetOrderDate_LeapYearDate() {
       LocalDate testDate = LocalDate.of(2020, 1, 29);
        Date convertedDate = java.sql.Date.valueOf(testDate);
        orders.setOrderDate(convertedDate);
        Assertions.assertEquals(convertedDate, orders.getOrderDate());
    }

    @Test
    public void testSetOrderDate_DateWithTime() {
        testDate.setHours(12);
        testDate.setMinutes(30);
        testDate.setSeconds(15);
        orders.setOrderDate(testDate);
        Assertions.assertEquals(testDate, orders.getOrderDate());
    }

    @Test
    public void testSetOrderDate_DateWithoutTime() {
        testDate.setHours(0);
        testDate.setMinutes(0);
        testDate.setSeconds(0);
        orders.setOrderDate(testDate);
        Assertions.assertEquals(testDate, orders.getOrderDate());
    }
}
