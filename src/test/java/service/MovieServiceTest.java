package service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


import com.example.demo.entities.Movie;
import com.example.demo.repository.MovieRepository;
import com.example.demo.service.MovieService;
import com.example.demo.vo.MovieVO;
import core.testcontainers.mapper.MockMovie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    MockMovie mockMovie;

    @InjectMocks
    private MovieService service;

    @Mock
    MovieRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception {
        mockMovie = new MockMovie();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateSuccess(){
        Movie movie = mockMovie.mockEntity(1);
        movie.setId(1L);

        Movie moviePersisted = movie;
        moviePersisted.setId(1L);

        MovieVO vo = mockMovie.mockVO(1);
        vo.setId(1L);

        when(repository.save(movie)).thenReturn(moviePersisted);

        var result = service.create(vo);
        assertNotNull(result);
    }
}
