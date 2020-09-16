package dev.euchigere.eventsmanager.controllers;

import dev.euchigere.eventsmanager.dto.DepartmentDTO;
import dev.euchigere.eventsmanager.dto.ServiceResponse;
import dev.euchigere.eventsmanager.models.Event;
import dev.euchigere.eventsmanager.models.User;
import dev.euchigere.eventsmanager.service.DepartmentService;
import dev.euchigere.eventsmanager.service.EventService;
import dev.euchigere.eventsmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    DepartmentService deptService;
    @Autowired
    UserService userService;
    @Autowired
    EventService eventService;

    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/auth/login";
        }
        ServiceResponse<DepartmentDTO> response =
                deptService.getCurrentUserDepartment(currentUser.getDepartment().getId());
        ServiceResponse<List<DepartmentDTO>> deptList = deptService.getAllDepartments();

        if (!response.isStatus()) {
            return "index";
        }

        model.addAttribute("currentUserDept", response.getData());
        model.addAttribute("deptList", deptList.getData());
        return "index";
    }

    @PostMapping("/add-user")
    public String addUser(@RequestParam(value="email") String email,
                          @RequestParam(value="department-id") Long id,
                          @RequestParam(value="role") String role) {
        userService.createUser(email, id, role);
        return "redirect:/";
    }

    @PostMapping("/add-department")
    public String addDepartment(@RequestParam(value = "dept-name") String deptName) {
        deptService.createDepartment(deptName);
        return "redirect:/";
    }

    @GetMapping("/all-events")
    public String displayAllEvents(Model model) {
        ServiceResponse<List<Event>> eventList = eventService.getAllEvents();
        ServiceResponse<List<DepartmentDTO>> deptList = deptService.getAllDepartments();

        model.addAttribute("eventList", eventList.getData());
        model.addAttribute("deptList", deptList.getData());

        return "all-events";
    }
}
