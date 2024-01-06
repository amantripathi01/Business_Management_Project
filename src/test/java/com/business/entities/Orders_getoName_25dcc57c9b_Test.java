package com.business.entities;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class OrdersTest {

    @Test
    public void testGetoName_NullValue() {
        Orders orders = new Orders();
        assertNull(orders.getoName());
    }

    @Test
    public void testGetoName_EmptyString() {
        Orders orders = new Orders();
        orders.setoName("");
        assertEquals("", orders.getoName());
    }

    @Test
    public void testGetoName_NonEmptyString() {
        Orders orders = new Orders();
        orders.setoName("Test");
        assertEquals("Test", orders.getoName());
    }

    @Test
    public void testGetoName_SpecialCharacters() {
        Orders orders = new Orders();
        orders.setoName("@#$$%%");
        assertEquals("@#$$%%", orders.getoName());
    }

    @Test
    public void testGetoName_Whitespace() {
        Orders orders = new Orders();
        orders.setoName(" ");
        assertEquals(" ", orders.getoName());
    }

    @Test
    public void testGetoName_LongStringValue() {
        Orders orders = new Orders();
        String longString = new String(new char[1000]).replace("\0", "a");
        orders.setoName(longString);
        assertEquals(longString, orders.getoName());
    }

}
