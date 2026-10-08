public class Facts {
    private String fact1;
    private String fact2;
    private String fact3;
    private Boolean TrueFalse;

    public Facts(String fact1, String fact2, String fact3, Boolean TrueFalse) {
        this.fact1 = fact1;
        this.fact2 = fact2;
        this.fact3 = fact3;
        this.TrueFalse = TrueFalse;
    }

    public String getFacts() {
        return fact1 + fact2 + fact3;
    }

    public Boolean getTrueFalse() {
        return TrueFalse;
    }
}