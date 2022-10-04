package com.test.test.repositories;

import com.test.test.entities.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findByDateAndPhone(String date, Integer phone);

    @Override
    Page<Appointment> findAll(Pageable pageable);
}
