import javax.swing.ImageIcon;

public class SupremeCourtCase {
    private String caseName;
    private String facts;
    private String constitutionalIssue;
    private String ruling;
    private String explanation;
    private String Question1;
    private String Question2;
    private String Question3;
    private ImageIcon bgimage;

    public SupremeCourtCase(String caseName, 
                            String Question1,
                            String Question2, 
                            String Question3,
                            String constitutionalIssue,
                            String ruling, String explanation,
                            ImageIcon bgimage) {
        this.caseName = caseName;
        this.Question1 = Question1;
        this.Question2 = Question2;
        this.Question3 = Question3;
        this.constitutionalIssue = constitutionalIssue;
        this.ruling = ruling;
        this.explanation = explanation;
        this.bgimage = bgimage;

    }

    public String getCaseName() {
        return caseName;
    }

    public String getFacts() {
        return facts;
    }

    public String getConstitutionalIssue() {
        return constitutionalIssue;
    }

    public String getRuling() {
        return ruling;
    }

    public String getExplanation() {
        return explanation;
    }
}