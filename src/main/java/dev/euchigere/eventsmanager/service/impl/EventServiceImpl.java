package dev.euchigere.eventsmanager.service.impl;

import dev.euchigere.eventsmanager.dto.ServiceResponse;
import dev.euchigere.eventsmanager.models.Department;
import dev.euchigere.eventsmanager.models.Event;
import dev.euchigere.eventsmanager.repository.DepartmentRepo;
import dev.euchigere.eventsmanager.repository.EventRepo;
import dev.euchigere.eventsmanager.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepo eventRepo;
    @Autowired
    DepartmentRepo deptRepo;

    public ServiceResponse<List<Event>> getAllEvents() {
        ServiceResponse<List<Event>> response = new ServiceResponse<>();
        response.setData(eventRepo.findAll());
        return response;
    }

    public void addEvent(Event event) {
        if (event.getId() == null) {
            for (Long deptId : event.getDeptIds()) {
                Department dept = deptRepo.findDepartmentById(deptId).orElse(null);

                if (dept == null) {
                    continue;
                }
                event.addDepartment(dept);
            }
            eventRepo.save(event);
            return;
        }

        Event e = eventRepo.findEventById(event.getId()).orElse(null);
        e.setAttendanceType(event.getAttendanceType());
        e.setDate(event.getDate());
        e.setDescription(event.getDescription());
        e.setTime(event.getTime().toString());
        e.setTitle(event.getTitle());
        e.setVenue(event.getVenue());

        for (Iterator<Department> it = e.getDepartments().iterator(); it.hasNext(); ) {
            Department dept = it.next();
            if (!event.getDeptIds().contains(dept.getId())) {
                event.getDeptIds().remove(dept.getId());
                e.removeDepartment(dept);
            }
        }

        for (Long deptId : event.getDeptIds()) {
            Department dept = deptRepo.findDepartmentById(deptId).orElse(null);

            if (dept == null) {
                continue;
            }
            e.addDepartment(dept);
        }
        eventRepo.save(e);
    }
}
