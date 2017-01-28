package testnewapp.everythingforward.com.wellnessdoctorside;

/**
 * Created by santh on 1/22/2017.
 */

public class PatientInfo {
    private String username,anger,contempt,disgust,fear,happy,neutral,sadness,surprise,scale;

    public PatientInfo(String username, String anger, String contempt, String disgust, String fear, String happy, String neutral, String sadness, String surprise, String scale) {
        this.username = username;
        this.anger = anger;
        this.contempt = contempt;
        this.disgust = disgust;
        this.fear = fear;
        this.happy = happy;
        this.neutral = neutral;
        this.sadness = sadness;
        this.surprise = surprise;
        this.scale = scale;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAnger() {
        return anger;
    }

    public void setAnger(String anger) {
        this.anger = anger;
    }

    public String getContempt() {
        return contempt;
    }

    public void setContempt(String contempt) {
        this.contempt = contempt;
    }

    public String getDisgust() {
        return disgust;
    }

    public void setDisgust(String disgust) {
        this.disgust = disgust;
    }

    public String getFear() {
        return fear;
    }

    public void setFear(String fear) {
        this.fear = fear;
    }

    public String getHappy() {
        return happy;
    }

    public void setHappy(String happy) {
        this.happy = happy;
    }

    public String getNeutral() {
        return neutral;
    }

    public void setNeutral(String neutral) {
        this.neutral = neutral;
    }

    public String getSadness() {
        return sadness;
    }

    public void setSadness(String sadness) {
        this.sadness = sadness;
    }

    public String getSurprise() {
        return surprise;
    }

    public void setSurprise(String surprise) {
        this.surprise = surprise;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }
}
