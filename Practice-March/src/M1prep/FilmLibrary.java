package M1prep;

import java.util.ArrayList;
import java.util.List;

interface IFilmLibrary extends IFilm{
    void addFilm(IFilm film);
    void removeFilm(String title);
    List<IFilm> getFilms(String query);
    List<IFilm> getFilms();
    int getTotalFilmCount();
}

public class FilmLibrary implements IFilmLibrary{

    String title;
    String director;
    int year;
    List<IFilm> lib = new ArrayList<>();

    @Override
    public void addFilm(IFilm film) {
        lib.add(film);
    }

    @Override
    public void removeFilm(String title) {
        lib.removeIf(film -> film.getTitle().equalsIgnoreCase(title));
    }

    @Override
    public List<IFilm> getFilms(String query) {
        List<IFilm> result = new ArrayList<>();

        for(IFilm film : lib) {
            if(film.getTitle().contains(query) ||
               film.getDirector().contains(query))

                result.add(film);
        }
        return result;
    }

    @Override
    public List<IFilm> getFilms() {
        return lib;
    }

    @Override
    public int getTotalFilmCount() {
        return lib.size();
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String getDirector() {
        return this.director;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int getYear() {
        return this.year;
    }
}