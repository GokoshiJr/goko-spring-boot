package com.goko.Interceptores.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component("basicInterceptor")
public class BasicInterceptor implements HandlerInterceptor {


    private static final Logger LOGGER = LoggerFactory.getLogger(BasicInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod controller = (HandlerMethod) handler;
        // time
        long start = System.currentTimeMillis();
        request.setAttribute("start", start);
        // delay
        Random random = new Random();
        int delay = random.nextInt(500);

        Thread.sleep(delay);
        LOGGER.info("preHandle entrando dalex " + controller.getMethod().getName());

        if (delay > 250) {
            Map<String, String> result = new HashMap<>();
            result.put("message", "Acceso denegado");
            result.put("date", new Date().toString());
            // result to json
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(result);
            response.setContentType("application/json");
            response.setStatus(401);
            response.getWriter().write(json);

            return false;
        }

        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long end = System.currentTimeMillis();
        long start = (long) request.getAttribute("start");
        LOGGER.info("Tiempo transcurrido " + (end-start) + " milisegundos");
        LOGGER.info("postHandle saliendo alex " + ((HandlerMethod) handler).getMethod().getName());
    }
}
