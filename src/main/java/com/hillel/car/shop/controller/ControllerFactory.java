package com.hillel.car.shop.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {

    private Map<String, Controller> controllerMap = new HashMap<>();

    private void init() {
        controllerMap.put("GET/profile", new ShowPageController("profile"));
        controllerMap.put("GET/login", new ShowPageController("login"));
    }

    public Controller getController(HttpServletRequest request) {
        if (controllerMap.isEmpty()) {
            init();
        }

        return controllerMap.get(request.getMethod() + request.getPathInfo());
    }
}
