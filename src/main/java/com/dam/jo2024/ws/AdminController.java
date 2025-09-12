package com.dam.jo2024.ws;

import com.dam.jo2024.api_ws.ApiRegistration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Acces to the administrator panel
@RestController
@RequestMapping(ApiRegistration.REST_DASHBOARD)
public class AdminController {

    // For Aministrator
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(ApiRegistration.REST_DASHBOARD_ADMIN)
    public String getAdminDashboard() {
        return "Bienvenue sur le dashboard Administrateur !";
    }


    // For Client
    @PreAuthorize("hasRole('CLIENT')")
    @GetMapping(ApiRegistration.REST_DASHBOARD_USER)
    public String getClientDashboard() {
        return "Bienvenue sur le dashboard Client !";
    }
}
