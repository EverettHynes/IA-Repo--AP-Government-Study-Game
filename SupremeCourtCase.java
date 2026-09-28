public class SupremeCourtCase {
    private String caseName;
    private String facts;
    private String constitutionalIssue;
    private String ruling;
    private String explanation;

    public SupremeCourtCase(String caseName, String facts,
                            String constitutionalIssue,
                            String ruling, String explanation) {
        this.caseName = caseName;
        this.facts = facts;
        this.constitutionalIssue = constitutionalIssue;
        this.ruling = ruling;
        this.explanation = explanation;
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