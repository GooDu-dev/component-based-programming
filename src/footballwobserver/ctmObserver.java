package footballwobserver;

import java.util.function.Consumer;

public class ctmObserver {

    private Object data;

    private Subject events;
    private Consumer<Object> func;

    public ctmObserver(Consumer<Object> func, Object data, Subject events) {
        this.func = func;
        this.data = data;
        this.events = events;
    }

    public void update() {
        if (this.func != null) {
            this.func.accept(this.data);
        } else {
            System.out.println("functional interface not found.");
        }
    }

    public void setData(Object data) {
        this.data = data;
    }
}
