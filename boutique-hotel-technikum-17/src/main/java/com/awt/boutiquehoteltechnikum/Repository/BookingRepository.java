package com.awt.boutiquehoteltechnikum.Repository;

import com.awt.boutiquehoteltechnikum.Entities.BookingEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<BookingEntity, Integer> {
    @Query("SELECT b FROM BookingEntity b WHERE (b.bookingStart <= :endDate AND b.bookingEnd >= :startDate)")
    List<BookingEntity> findAllByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
