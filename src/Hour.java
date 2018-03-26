public class Hour {
    private int hrs;
    private int min;
    private int seg;

    public Hour(int hrs, int min, int seg) {
        this.hrs = hrs;
        this.min = min;
        this.seg = seg;
    }

    public int getHrs() {
        return hrs;
    }

    public void setHrs(int hrs) {
        this.hrs = hrs;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSeg() {
        return seg;
    }

    public void setSeg(int seg) {
        this.seg = seg;
    }

    public String toString(int hrs, int min, int seg){
        return String.format("%d:%d:%d", hrs, min, seg);
    }
}
