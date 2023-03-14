import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.ticket.search.ManagerTicket;
import ru.netology.ticket.search.RepositoryTicket;
import ru.netology.ticket.search.Ticket;

public class ManagerTicketTest {

    RepositoryTicket repo = new RepositoryTicket();
    ManagerTicket manager = new ManagerTicket(repo);

    Ticket ticket1 = new Ticket(1, 1000, "DME", "LED", 120);
    Ticket ticket2 = new Ticket(2, 7000, "DME", "LED", 120);
    Ticket ticket3 = new Ticket(3, 2000, "VNO", "LED", 120);
    Ticket ticket4 = new Ticket(4, 4000, "DME", "LED", 320);
    Ticket ticket5 = new Ticket(5, 9000, "LED", "SVO", 120);
    Ticket ticket6 = new Ticket(6, 18_000, "VNO", "IST", 320);
    Ticket ticket7 = new Ticket(7, 22_000, "LAX", "YVR", 400);
    Ticket ticket8 = new Ticket(8, 8000, "BUS", "MSQ", 380);
    Ticket ticket9 = new Ticket(9, 9500, "VNO", "IST", 320);
    Ticket ticket10 = new Ticket(10, 10_000, "YVR", "LED", 210);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
    }

    @Test
    public void sortTickets() {
        Ticket[] expected = {ticket1, ticket4, ticket2};
        Ticket[] actual = manager.findAll("DME", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTickets() {
        Ticket[] expected = {ticket8};
        Ticket[] actual = manager.findAll("BUS", "MSQ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfNoTicket() {
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("BUS", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }
}
