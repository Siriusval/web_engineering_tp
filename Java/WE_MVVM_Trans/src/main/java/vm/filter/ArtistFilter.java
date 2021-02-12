package vm.filter;

/**
 * Model
 * Contains all the entry values of the filter cells
 * Is used to produce a new list of artists, with filtered results
 */
public class ArtistFilter {

    /**
     * The attributes to collect from form
     */
    private String name="", country="", city="",year="",edition="";


    /*
       GETTERS & SETTERS
       if entry is null, replace by "" (empty string)
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name==null?"":name.trim();
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country==null?"":country.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city==null?"":city.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year==null?"":year.trim();
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition==null?"":edition.trim();
    }


}
