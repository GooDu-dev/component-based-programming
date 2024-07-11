package drawer;

public class FootShape {

    private Foot foot;

    public void draw() {
        foot.draw();
        return;
    }

    public void setFoot(Foot foot) {
        this.foot = foot;
    }

    public void drawAsEllipse(Ellipse e) {
        e.draw();
        return;
    }

    public void drawAsRectangle(Rectangle r) {
        r.draw();
        return;
    }
}
