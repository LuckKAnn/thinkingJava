package watch01;

import java.util.EventListener;

public interface MyListener extends EventListener {
    public void fireAfterEventInvoked(Event event);

}
