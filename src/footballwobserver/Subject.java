package footballwobserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Subject implements ctmObserverable {

    private static Map<String, List<ctmObserver>> observers;

    public Subject() {
        observers = new HashMap<String, List<ctmObserver>>();
    }

    @Override
    public ctmObserver register(String name, Consumer<Object> func) {
        List<ctmObserver> observer = observers.get(name);
        if (observer == null) {
            observer = new ArrayList<ctmObserver>();
            observers.put(name, observer);
        }
        ctmObserver obs = new ctmObserver(func, null, this);
        observer.add(obs);
        return obs;
    }

    @Override
    public boolean unregister(String name) {
        if (observers.get(name) != null) {
            observers.remove(name);
        }
        return true;
    }

    @Override
    public boolean notifyObservers(String name, Object data) {
        for (Map.Entry<String, List<ctmObserver>> obs : observers.entrySet()) {
            if (obs.getKey() == name) {
                for (ctmObserver o : obs.getValue()) {
                    o.setData(data);
                    o.update();
                }
            }
        }
        return true;
    }
}
