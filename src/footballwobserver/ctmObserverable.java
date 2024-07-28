package footballwobserver;

import java.util.function.Consumer;

public interface ctmObserverable {

    ctmObserver register(String name, Consumer<Object> func);

    boolean unregister(String name);

    boolean notifyObservers(String name, Object data);
}
