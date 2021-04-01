package controllers;

import dao.FilmDAO;
import dto.FilmDTO;
import entity.Film;
import parser.FilmToFilmDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilmController implements Controller<FilmDTO> {

    @Override
    public List<FilmDTO> getAllFilms() throws Exception {
        FilmDAO filmDAO = new FilmDAO();
        FilmToFilmDTO filmToFilmDTO = new FilmToFilmDTO();
        return new ArrayList<>(filmToFilmDTO.parseCollection(new HashSet<>(filmDAO.getAll())));
    }

}
