package zk.gradle.vm;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.chart.model.ChartsModel;
import org.zkoss.chart.model.DefaultPieModel;
import org.zkoss.chart.model.PieModel;
import zk.gradle.model.Budget;

import java.util.ArrayList;

public class BudgetViewModel {

    //Attributes
    public static final String ADD_COMMAND = "add";
    private String instr = "Add a new budget line :";
    private ArrayList<Budget> budgetList = new ArrayList<>();

    //Label
    private final String intituleLabel = "Intitule";
    private final String descriptionLabel = "Description";
    private final String valeurLabel = "Valeur";

    //Fields
    private String intituleTextbox="";
    private String descriptionTextbox="";
    private String valeurTextbox ="";

    public BudgetViewModel() {
        budgetList.add(new Budget("a","b",0));
    }


    private PieModel pm = new DefaultPieModel();

    public PieModel getPm() {
        return pm;
    }

    public void setIntituleTextbox(String intituleTextbox) {
        this.intituleTextbox = intituleTextbox;
    }

    public void setDescriptionTextbox(String descriptionTextbox) {
        this.descriptionTextbox = descriptionTextbox;
    }

    public void setValeurTextbox(String valeurTextbox) {
        this.valeurTextbox = valeurTextbox;
    }

    public String getIntituleLabel() {
        return intituleLabel;
    }

    public String getDescriptionLabel() {
        return descriptionLabel;
    }

    public String getValeurLabel() {
        return valeurLabel;
    }

    public String getIntituleTextbox() {
        return intituleTextbox;
    }

    public String getDescriptionTextbox() {
        return descriptionTextbox;
    }

    public String getValeurTextbox() {
        return valeurTextbox;
    }

    public ArrayList<Budget> getBudgetList() {
        return budgetList;
    }

    public String getInstr() {
        return instr;
    }

    @Command(ADD_COMMAND)
    @NotifyChange({"budgetList","intituleTextbox","descriptionTextbox","valeurTextbox"})
    public void add() {
        Budget b = new Budget(intituleTextbox,descriptionTextbox,Float.parseFloat(valeurTextbox));
        this.budgetList.add(b);
        System.out.println(budgetList.size());
        intituleTextbox ="";
        descriptionTextbox="";
        valeurTextbox="";

        pm.setValue(b.getIntitule(),b.getValeur());

    }
}
