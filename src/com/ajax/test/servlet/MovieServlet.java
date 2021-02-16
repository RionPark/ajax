package com.ajax.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.test.service.MovieService;
import com.ajax.test.service.impl.MovieServiceImpl;
import com.google.gson.Gson;

public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MovieService movieService = new  MovieServiceImpl();
    private Gson g = new Gson();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		List<Map<String,String>> movieList = movieService.selectMovieList(null);
		String json = g.toJson(movieList);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
