package core.testcontainers.mapper;

import com.example.demo.entities.Movie;
import com.example.demo.vo.MovieVO;

import java.util.ArrayList;
import java.util.List;

public class MockMovie {

    public Movie mockEntity(){
        return mockEntity(0);
    }

    public List<Movie> mockEntityList() {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            movies.add(mockEntity(i));
        }
        return movies;
    }

    public List<MovieVO> mockVOList() {
        List<MovieVO> movies = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            movies.add(mockVO(i));
        }
        return movies;
    }

    public Movie mockEntity(Integer number){
        Movie movie = new Movie();
        movie.setId(number.longValue());
        movie.setDescription("Description Test " + number);
        return movie;
    }

    public MovieVO mockVO(Integer number){
        MovieVO movieVO = new MovieVO();
        movieVO.setId(number.longValue());
        movieVO.setDescription("Description Test " + number);
        return movieVO;
    }
}
