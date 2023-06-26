package com.opm.cofig;

import com.opm.model.Audit;
import com.opm.repository.AuditRepository;
import com.opm.service.AuditService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class CustomInterceptor implements HandlerInterceptor {

    @Autowired
    AuditRepository auditRepository;

    @Override
    public boolean preHandle(
            @NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        String path = request.getRequestURI().substring(request.getContextPath().length());
        if (path.contains("api/marvel")) {
            Audit audit = new Audit(null, path, LocalDate.now(), LocalTime.now());
            auditRepository.save(audit);
        }
        return true;
    }
}
