package lab2_extra;

public class Movie {
    private final String title,director;
    private final int releaseYear;
    private double rating;
    Genre genre;
    public  Movie(String ptitle, String pdirector, int preleaseYear, double prating , Genre pgenre) {
        title = ptitle;
        director = pdirector;
        releaseYear = preleaseYear;
        rating = prating;
        genre = pgenre;
    }
    public String getTitle() {
        return title;
    }
    public String getDirector() {
        return director;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public double getRating() {
        return rating;
    }
    public Genre getGenre() {
        return genre;
    }
    public void setRating(double prating) {
        rating = prating;
    }
    public String toString() {
        return title + " (" + releaseYear + ") directed by " + director + ", rating: " + rating + ", genre: " + genre;
    }
}
