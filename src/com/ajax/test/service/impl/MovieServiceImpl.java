package com.ajax.test.service.impl;

import java.util.List;
import java.util.Map;

import com.ajax.test.dao.MovieDAO;
import com.ajax.test.dao.impl.MovieDAOImpl;
import com.ajax.test.service.MovieService;

public class MovieServiceImpl implements MovieService {
	private MovieDAO movieDAO = new MovieDAOImpl();
	@Override
	public List<Map<String, String>> selectMovieList(Map<String, String> movie) {
		
		return movieDAO.selectMovieList(movie);
	}

}
