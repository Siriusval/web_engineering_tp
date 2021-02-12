package data;
import data.pojo.Artist;
import org.zkoss.json.JSONArray;
import org.zkoss.json.JSONObject;
import org.zkoss.json.parser.JSONParser;
import vm.filter.ArtistFilter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * MODEL
 * Class representing the database
 * Static singleton item, instantiated once and single source of truth
 * representing all the artists that performed at the festival
 */
public class TransDataset {

    /**
     * List of all artists
     */
    private static List<Artist> artists;

    //static initializer,(~constructor) executed once when class is loaded
    static {
        String resourceName = "./transmusicales_dataset.json";
        JSONParser parser = new JSONParser();

        artists = new ArrayList<>();
        try {
            //Get file data as JSON
            JSONArray data = (JSONArray) parser.parse(new FileReader(resourceName, StandardCharsets.UTF_8));

            initArray(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Parse the json element to create artists and fill the list
     * @param data, the JsonArray containing the data
     */
    private static void initArray(JSONArray data ){

        for(Object elem : data){
            JSONObject obj = (JSONObject) elem;
            //Get a particular field
            JSONObject fields = (JSONObject) obj.get("fields");

            //Retrieve attribute
            String name = (String) fields.get("artistes");
            name = name==null ? "Nan" : name;

            String country = (String) fields.get("origine_pays1");
            country = country==null ? "Nan" : country;

            String city = (String) fields.get("origine_ville1");
            city = city==null ? "Nan" : city;

            String year = (String) fields.get("annee");
            year = year==null ? "Nan" : year;

            String edition = (String) fields.get("edition");
            edition = edition==null ? "Nan" : edition.replaceAll("[^0-9]","");

            String spotify = (String) fields.get("spotify");
            spotify = spotify==null ? "Nan" : spotify.substring(0,2);

            //Create new artist
            Artist artist = new Artist(name,country,city,year,edition,spotify);

            //Append to list
            artists.add(artist);
        }

    }

    public static List<Artist> getAllArtists() {
        return artists;
    }

    /*
    public static Artist[] getAllArtistsArray() {
        return artists.toArray(new Artist[artists.size()]);
    }
    */

    /**
     * Method used to produce a list of artists with the choosen filters
     * (what has been typed by user)
     * @param artistFilter, object that contains the entry values of the form
     * @return the list of artists, filtered
     */
    public static List<Artist> getFilteredArtists(ArtistFilter artistFilter) {
        List<Artist> someArtists = new ArrayList<>();
        String name = artistFilter.getName().toLowerCase();
        String country = artistFilter.getCountry().toLowerCase();
        String city = artistFilter.getCity().toLowerCase();
        String year = artistFilter.getYear().toLowerCase();
        String edition = artistFilter.getEdition().toLowerCase();

        for (Iterator<Artist> i = artists.iterator(); i.hasNext();) {
            Artist tmp = i.next();
            if (tmp.getName().toLowerCase().contains(name)
            && tmp.getCountry().toLowerCase().contains(country)
            && tmp.getCity().toLowerCase().contains(city)
            && tmp.getYear().toLowerCase().contains(year)
            && tmp.getEdition().toLowerCase().contains(edition)) {
                someArtists.add(tmp);
            }
        }
        return someArtists;
    }

    /**
     * Return the list of artists by name
     * @param name the name of the artist
     * @return the artists that match the exact same name (no case)
     */
    public static List<Artist> getArtistsByName(String name) {
        List<Artist> someArtists = new ArrayList<>();
        for (Iterator<Artist> i = artists.iterator(); i.hasNext();) {
            Artist tmp = i.next();
            if (tmp.getName().equalsIgnoreCase(name)){
                someArtists.add(tmp);
            }
        }
        return someArtists;
    }

    /**
     * Debug to see if artists list is successfully created
     * @param args _
     */
    public static void main(String[] args) {
        System.out.println(artists.size());
        for(Artist a : artists){
            System.out.println(a.getName());
        }
    }


}


