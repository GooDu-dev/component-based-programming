package drawer;

public class FootShape {

    private Foot foot;

    public void draw() {
        foot.draw();
        return;
    }

    public void drawAsEclipse(Eclipse e) {
        e.draw();
        return;
    }

    public void drawAsRectangle(Rectangle r) {
        r.draw();
        return;
    }
}
