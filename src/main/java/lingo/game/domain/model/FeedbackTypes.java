package lingo.game.domain.model;

public class FeedbackTypes {
    public final String CORRECT = "correct";
    public final String INVALID = "invalid";
    public final String PRESENT = "present";
    public final String ABSENT = "absent";

    public String getCORRECT() {
        return CORRECT;
    }

    public String getINVALID() {
        return INVALID;
    }

    public String getPRESENT() {
        return PRESENT;
    }

    public String getABSENT() {
        return ABSENT;
    }
}
