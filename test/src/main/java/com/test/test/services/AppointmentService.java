package com.test.test.services;


import com.test.test.entities.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.nio.file.FileAlreadyExistsException;

public interface AppointmentService {

    void saveAppointment(Appointment appointment) throws FileAlreadyExistsException;

    Page<Appointment> getAllAppointments(Pageable pageable);
}
