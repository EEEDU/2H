package B6R4EduardoGuerrero.B6R4EduardoGuerrero.Repositories;

import B6R4EduardoGuerrero.B6R4EduardoGuerrero.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
