package watch01;

public class WashingHandsListener implements MyListener{
    @Override
    public void fireAfterEventInvoked(Event event) {

        WashingHandsEvent washingHandsEvent  = (WashingHandsEvent) event;
        ListenerObject source = (ListenerObject) event.getSource();

//        System.out.println(washingHandsEvent.getEventName());
        System.out.println(source.getName() + "请"+washingHandsEvent.getEventName());

    }
}
