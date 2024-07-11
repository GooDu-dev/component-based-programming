package drawer;

public class Main {
    public static void main(String[] args) {
        FootShape fs = new FootShape();
        fs.draw(); // draw foot
        fs.drawAsRectangle(new Rectangle()); // draw rectangle
        fs.drawAsEclipse(new Eclipse()); // draw eclipse
    }
}
