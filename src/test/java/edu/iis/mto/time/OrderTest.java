package edu.iis.mto.time;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Clock;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Order order;
    private Clock mockedClock;

    @BeforeEach
    public void setUp(){
        mockedClock = Mockito.mock(Clock.class);
        order = new Order(mockedClock);
    }

    @Test
    public void orderNotExpiredImmediately(){
        Mockito.when(mockedClock.instant()).thenReturn(Instant.now());
        order.submit();
        order.confirm();
    }

    @Test
    public void orderNotExpiredWithValidTime(){
        Mockito.when(mockedClock.instant()).thenReturn(Instant.now(), Instant.now().plus(24, ChronoUnit.HOURS));
        order.submit();
        order.confirm();
    }
    @Test
    public void OrderExpiredWithValidDate(){
        Mockito.when(mockedClock.instant()).thenReturn(Instant.now(), Instant.now().plus(25, ChronoUnit.HOURS));
        order.submit();
        assertThrows(OrderExpiredException.class, order::confirm);
    }

}
