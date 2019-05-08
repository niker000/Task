package task6;

import org.junit.Test;

import static org.junit.Assert.*;

public class TicketCounterTest {

    @Test
    public void countLuckyPiterTiket() {
        TicketCounter ticketCounter = new TicketCounter();
        assertEquals(25080, ticketCounter.countLuckyTiket("piter"));
    }
    @Test
    public void countLuckyMoscowTiket() {
        TicketCounter ticketCounter = new TicketCounter();
        assertEquals(55251, ticketCounter.countLuckyTiket("moskow"));
    }
}