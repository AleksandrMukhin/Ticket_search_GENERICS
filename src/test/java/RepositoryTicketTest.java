import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.ticket.search.ManagerTicket;
import ru.netology.ticket.search.RepositoryTicket;
import ru.netology.ticket.search.Ticket;

public class RepositoryTicketTest {

    RepositoryTicket repo = new RepositoryTicket();

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
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);
        repo.add(ticket9);
        repo.add(ticket10);
    }

    @Test
    public void shouldAddAllTickets() {
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9, ticket10};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        repo.removeById(6);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket7, ticket8, ticket9, ticket10};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void allRemoveById() {
        repo.removeById(1);
        repo.removeById(2);
        repo.removeById(3);
        repo.removeById(4);
        repo.removeById(5);
        repo.removeById(6);
        repo.removeById(7);
        repo.removeById(8);
        repo.removeById(9);
        repo.removeById(10);

        Ticket[] expected = {};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}

