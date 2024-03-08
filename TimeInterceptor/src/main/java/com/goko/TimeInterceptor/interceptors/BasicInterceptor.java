package com.goko.TimeInterceptor.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component("basicInterceptor")
public class BasicInterceptor implements HandlerInterceptor {

    @Value("${config.calendar.open}")
    private int calendarOpen;

    @Value("${config.calendar.close}")
    private int calendarClose;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if ((hour >= calendarOpen) && (hour < calendarClose)) {
            String msg = "Welcome to attention time " + calendarOpen + "h to " + calendarClose + "h";
            request.setAttribute("message", msg);
            return true;
        }

        Map<String, String> result = new HashMap<>();
        result.put("message", "Attention time is closed");
        result.put("date", new Date().toString());
        // result to json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(result);
        response.setContentType("application/json");
        response.setStatus(401);
        response.getWriter().write(json);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        
    }
}
