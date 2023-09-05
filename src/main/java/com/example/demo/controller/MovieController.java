package com.example.demo.controller;

import com.example.demo.service.MovieService;
import com.example.demo.vo.MovieVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
@Tag(name = "Movies", description = "Endpoints para gerenciar filmes")
public class MovieController {

    @Autowired
    private MovieService service;

    @PostMapping
    public MovieVO create(@RequestBody MovieVO movieVO) {
        return service.create(movieVO);
    }

    @GetMapping
    @Operation(summary = "Retorna todos os filmes cadastrados", description = "Retorna todos os filmes",
            tags = {"Filmes"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = MovieVO.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public List<MovieVO> findAll() {
        return service.findAll();
    }
}
