public class Send implements PaySend, ReturnSend {
    @Override
    public void sendPay(String name) {
        System.out.println("Был приобретен товар " + name);
    }

    @Override
    public void sendReturn(String name) {
        System.out.println("Был возвращен товар " + name);
    }
}