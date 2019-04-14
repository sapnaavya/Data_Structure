class Rect {
    int x, y, width, height;
    public Rect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}

public class RectangleIntersection {
    public static Rect intersectionRect(Rect r1, Rect r2) {
        if(!isIntersection(r1, r2)) {
            return new Rect(0, 0, -1, -1);
        }

        return new Rect(
            Math.max(r1.x, r2.x),
            Math.max(r1.y, r2.y),
            Math.min(r1.x + r1.width, r2.x + r2.width) - Math.max(r1.x, r2.x),
            Math.min(r1.y + r1.height, r2.y + r2.height) - Math.max(r1.y, r2.y)
        );
    }

    public static boolean isIntersection(Rect r1, Rect r2) {
        return (r1.x <= r2.x + r2.width) && (r2.x <= r1.x + r1.width) && 
                (r1.y <= r2.y + r2.height) && (r2.y <= r1.y + r1.height);
    }

    public static void main(String args[]) {
        Rect r1 = new Rect(1,1,3,5);
        Rect r2 = new Rect(3,3,9,6);
        RectangleIntersection rectIntsec = new RectangleIntersection();
        Rect r3 = rectIntsec.intersectionRect(r1, r2);
        System.out.println("Intersecting coordinates are:" + r3.x +" "+ r3.y + " " + r3.width + " " + r3.height) ;
    }
}
