package collatzproject;

public class CollatzCalculation {
    RealCollatz realCollatz;

    public CollatzCalculation(RealCollatz realCollatz) {
        this.realCollatz = realCollatz;
    }

    public RealCollatz getRealCollatz() {
        return realCollatz;
    }

    public void setRealCollatz(RealCollatz realCollatz) {
        this.realCollatz = realCollatz;
    }
}
