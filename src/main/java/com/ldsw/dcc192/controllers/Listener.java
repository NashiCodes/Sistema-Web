package com.ldsw.dcc192.controllers;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Web application lifecycle listener.
 */
public class Listener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public static final AtomicInteger usuarios = new AtomicInteger(0);
    public ServletContext context;

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("Contexto Inicializado");
        context = arg0.getServletContext();
        context.setAttribute("userCount", usuarios.get());
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("Contexto Destruido");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(">>> Session Created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(">>> Session Destroyed");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println(">>> Attribute Added: " + event.getName());
        if (event.getName().equals("user")) {
            usuarios.incrementAndGet();
            context.setAttribute("userCount", usuarios.get());
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println(">>> Attribute Removed: " + event.getName());
        if (event.getName().equals("user")) {
            usuarios.decrementAndGet();
            context.setAttribute("userCount", usuarios.get());
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println(">>> AttributeReplaced: " + event.getName());
    }


}