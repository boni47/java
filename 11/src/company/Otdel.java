package company;

public class Otdel {
    private String nazvanie;
    private int kolichestvoSotrudnikov;

    public Otdel(String nazvanie, int kolichestvoSotrudnikov) {
        this.nazvanie = nazvanie;
        this.kolichestvoSotrudnikov = kolichestvoSotrudnikov;
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    public int getKolichestvoSotrudnikov() {
        return kolichestvoSotrudnikov;
    }

    public void setKolichestvoSotrudnikov(int kolichestvoSotrudnikov) {
        this.kolichestvoSotrudnikov = kolichestvoSotrudnikov;
    }
}