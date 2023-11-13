package Practica.semanaDos.practica2.ejer13.domain.models;

public class Movie extends RentalItem{
    private String director;
    private short duration;
    private short ageRating;
    private String genre;

    public Movie(String itemName, String director, short duration, short ageRating, String genre) {
        super(itemName);
        this.director = director;
        this.duration = duration;
        this.ageRating = ageRating;
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public short getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(short ageRating) {
        this.ageRating = ageRating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String showDetails() {
        String msmAvailable = available ? "is available" : "not available";
        return "Movie {" +
                "director='" + director + '\'' +
                ", duration=" + duration +
                ", ageRating=" + ageRating +
                ", genre='" + genre + '\'' +
                ", idItem=" + idItem +
                ", itemName='" + itemName + '\'' +
                ", available=" + msmAvailable +
                '}';
    }
}
