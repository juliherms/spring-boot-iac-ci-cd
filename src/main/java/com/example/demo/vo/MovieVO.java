package com.example.demo.vo;

import java.io.Serializable;
import java.util.Objects;

public class MovieVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieVO)) return false;
        MovieVO movieVO = (MovieVO) o;
        return Objects.equals(id, movieVO.id) && Objects.equals(description, movieVO.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
