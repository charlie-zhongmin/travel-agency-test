package com.test.test.controller;

import com.test.test.dtos.AppointmentDto.AppointmentGetAllDto;
import com.test.test.entities.Appointment;
import com.test.test.services.ActivityService;
import com.test.test.services.AppointmentService;
import com.test.test.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.nio.file.FileAlreadyExistsException;
import java.security.InvalidParameterException;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final ActivityService activityService;


    @GetMapping()
    public Response getAllAppointments(@RequestBody AppointmentGetAllDto appointmentGetAllDto) throws InvalidParameterException{
        //Set the pageable start from 1
        int real_page = appointmentGetAllDto.getPage()-1;
        PageRequest pageRequest = PageRequest.of(real_page, appointmentGetAllDto.getNumber());
        Page<Appointment> appointments = appointmentService.getAllAppointments(pageRequest);
        //Page number limit
        if (appointments.getTotalPages() <= real_page || real_page < 0 ) {
            throw new InvalidParameterException("Wrong page number");
        }
        return Response.success(appointments);
    }

    @PostMapping()
    public Response addAppointment(@RequestBody Appointment appointment) throws FileAlreadyExistsException {
        appointment.setActivity(activityService.getActivityByDate(appointment.getDate()).getActivity());
        appointmentService.saveAppointment(appointment);
        return Response.success(appointment, "Add appointment success");
    }
}
