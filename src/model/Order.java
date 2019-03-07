package model;

public class Order {
    private String id;
    private int number;
    private Rivista rivista;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Rivista getRivista() {
        return rivista;
    }

    public void setRivista(Rivista rivista) {
        this.rivista = rivista;
    }
}
