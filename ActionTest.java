package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionTest {


    Action betTen = new Action(10.0f, 100.0f);
    Action checked = new Action(0.0f, 100.0f);


    @Test
    void fold() {
        assertTrue(betTen.fold());
        assertFalse(checked.fold());
    }

    @Test
    void check() {
        assertTrue(checked.check());
        assertFalse(betTen.check());
    }

    @Test
    void call() {
        assertEquals(0.0f, checked.call());
        assertEquals(10.0f, betTen.call());
    }

    @Test
    void raise() {
        assertEquals(10.0f, checked.raise(10.0f));
        assertEquals(20.0f, betTen.raise(10.0f));
        assertEquals(100.0f, betTen.raise(101.0f));
        assertEquals(0.0f, betTen.raise(1.0f));
    }
}