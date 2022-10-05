package com.test.test.services;

import com.test.test.entities.Appointment;
import com.test.test.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.file.FileAlreadyExistsException;


@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public void saveAppointment(Appointment appointment) throws FileAlreadyExistsException {
        if (appointmentRepository.findByDateAndPhone(appointment.getDate(), appointment.getPhone()).isPresent()) {
            throw new FileAlreadyExistsException("Appointment exist");
        }
        appointmentRepository.save(appointment);
    }

    @Override
    public Page<Appointment> getAllAppointments(Pageable pageable) {
        return appointmentRepository.findAll(pageable);
    }


}
