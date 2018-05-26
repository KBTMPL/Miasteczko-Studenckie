package MS.wyjatki;


public class WyjatekAB extends Exception {

    boolean pusty;

    public WyjatekAB() {
        this.pusty = false;
    }

    public WyjatekAB(Boolean pusty) {
        this.pusty = pusty;
    }

    public boolean isPusty() {
        return pusty;
    }

    public WyjatekAB(String message) {
        super(message);
    }
}
