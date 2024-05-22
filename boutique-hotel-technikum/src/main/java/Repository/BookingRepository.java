package Repository;

import Model.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
}
