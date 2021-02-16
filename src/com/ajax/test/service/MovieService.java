package com.ajax.test.service;

import java.util.List;
import java.util.Map;

public interface MovieService {

	List<Map<String,String>> selectMovieList(Map<String,String> movie);
}
