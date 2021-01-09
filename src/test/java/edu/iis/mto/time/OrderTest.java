package edu.iis.mto.time;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.time.Clock;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Order order;
    private Clock mockedClock;

    @BeforeEach
    public void setUp(){
        mockedClock = Mockito.mock(Clock.class);
        order = new Order(mockedClock);
    }

}
