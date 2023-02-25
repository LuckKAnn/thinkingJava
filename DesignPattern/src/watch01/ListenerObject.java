package watch01;

public class ListenerObject {

    private String name;

    MyListener myListener;

    public ListenerObject(String name, MyListener myListener) {
        this.name = name;
        this.myListener = myListener;
    }

    public String getName() {
        return name;
    }

    public void eatFood(){
        if (myListener != null){
            myListener.fireAfterEventInvoked(new WashingHandsEvent(this,"洗手"));
        }
        System.out.println("吃饭");
    }

    public static void main(String[] args) {
        ListenerObject listenerObject = new ListenerObject("lkkk", new WashingHandsListener());

        listenerObject.eatFood();
    }
}
