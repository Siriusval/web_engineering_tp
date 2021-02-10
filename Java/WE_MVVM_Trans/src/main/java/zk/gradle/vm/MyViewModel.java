package zk.gradle.vm;

import data.TransDataset;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.json.JSONArray;
import org.zkoss.json.JSONObject;

public class MyViewModel {
	public static final String SUBMIT_COMMAND = "submit";
	private String name = "";
	private TransDataset transDataset ;

	public MyViewModel() {
		transDataset = new TransDataset();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResponse() {
		return String.format("Hello %s!", name);
	}

	public JSONArray getData() {
		return transDataset.getData();
	}



	@Command(SUBMIT_COMMAND)
	@NotifyChange("response")
	public void submit() {
	}
}
