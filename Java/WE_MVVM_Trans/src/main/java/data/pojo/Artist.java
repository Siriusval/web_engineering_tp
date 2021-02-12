package data.pojo;

/**
 * MODEL
 * POJO Class representing one Artist in our database
 */
public class Artist {
    private String name;
    private String country;
    private String city;
    private String year;
    private String edition;
    private String spotify;

    /**
     * Constructor
     * @param name of the artist
     * @param country of the artist
     * @param city of the artist
     * @param year of the festival
     * @param edition of the festival
     * @param spotify key of the artist
     */
    public Artist(String name, String country, String city, String year, String edition, String spotify) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.year = year;
        this.edition = edition;
        this.spotify = spotify;
    }

    /*
    ALL GETTERS FOR ATTRIBUTES
     */
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getYear() {
        return year;
    }

    public String getEdition() {
        return edition;
    }

    public String getSpotify() {
        return spotify;
    }

}
