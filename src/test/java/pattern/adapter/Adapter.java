package pattern.adapter;

public class Adapter {

    public static void main(String[] args) {
        AmericanSocket socket = new SimpleAmericanSocket();
         Radio radio = new Radio();
         EuroSocket euroSocket = new SocketAdapter(socket);
         radio.listenMusic(euroSocket);
    }
}

interface EuroSocket{
    void getPower();
}

class SocketAdapter implements EuroSocket{
    AmericanSocket americanSocket;

    public SocketAdapter(AmericanSocket americanSocket) {
        this.americanSocket = americanSocket;
    }

    @Override
    public void getPower() {
americanSocket.getPower();
    }
}

interface AmericanSocket{
    void getPower();
}

class SimpleAmericanSocket implements AmericanSocket{
    @Override
    public void getPower() {
        System.out.println("get 110v");
    }
}

class Radio {
    public void listenMusic(EuroSocket euroSocket){
        euroSocket.getPower();
    }
}