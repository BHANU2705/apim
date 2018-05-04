package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/starter", loadOnStartup = 1)
public class Starter extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Starter() {
    }

    @Override
    public void init() throws ServletException {
    	super.init();
    	BeeperControl beeperControl = new BeeperControl();
		beeperControl.beepForAnHour();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
