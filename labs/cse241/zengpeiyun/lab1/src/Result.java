package lab1;

public class Result {
    public XYPoint p1;
    public XYPoint p2;
    public double dist;
    
    Result(XYPoint ip1, XYPoint ip2, double d) {
	   p1 = ip1;
	   p2 = ip2;
	   dist = d;
    }

    public void print() {
	   Terminal.println(this.p1 + " " + this.p2 + " " + this.dist);
    }
}
