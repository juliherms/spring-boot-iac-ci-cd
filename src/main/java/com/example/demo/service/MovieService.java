package com.example.demo.service;

import com.example.demo.converter.DozerConverter;
import com.example.demo.entities.Movie;
import com.example.demo.repository.MovieRepository;
import com.example.demo.vo.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository repository;

    public MovieVO create(MovieVO movieVO){
        var entity = DozerConverter.parseObject(movieVO, Movie.class);
        return DozerConverter.parseObject(repository.save(entity), MovieVO.class);
    }

    public List<MovieVO> findAll() {
        return DozerConverter.parseListObjects(repository.findAll(), MovieVO.class);
    }
}
