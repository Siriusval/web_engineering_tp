package vm;

import data.TransDataset;
import data.pojo.Artist;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import vm.filter.ArtistFilter;

import java.util.List;

/**
 * CONTROLLER
 * Provide :
 * - the artists list to the grid
 * - the artistFilter object
 * - the method to get filtered artists
 * - the footer message
 */
public class FilterViewModel {

	/** Footer message template string, never sent, see getFooter to view output*/
	private static final String footerMessage = "A Total of %d Artists";
	/** Object that allow us to collect input values and filter later */
	private ArtistFilter artistFilter = new ArtistFilter();

	/** List of artists in the grid, initialized with the whole list */
	private List<Artist> currentArtists = TransDataset.getAllArtists();

	/**
	 * Provide filter to view, to the filter inputs to be exact
	 * @return the object that collect input
	 */
	public ArtistFilter getArtistFilter() {
		return artistFilter;
	}

	/**
	 * Provide the list of artists to the grid
	 * @return the list of artists
	 */
	public ListModel<Artist> getArtistModel() {
		return new ListModelList<>(currentArtists);
	}

	/**
	 * Send footer string to view
	 * Template string is updated with the number of results
	 * @return
	 */
	public String getFooter() {
		return String.format(footerMessage, currentArtists.size());
	}

	/**
	 * Update current artists with filters
	 * if all filters are empty strings, the whole list is sent
	 */
	@Command
	@NotifyChange({"artistModel", "footer"})
	public void changeFilter() {
		currentArtists = TransDataset.getFilteredArtists(artistFilter);
	}
}
