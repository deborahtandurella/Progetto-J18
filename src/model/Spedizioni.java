package model;

import java.util.ArrayList;
import java.util.List;
public class Spedizioni {
    private Cliente cliente;
    private  Rivista rivista;
   private String ID;
   private int NumSpeddizione;
    private List<Order> items=new ArrayList<Order>();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Rivista getRivista() {
        return rivista;
    }

    public void setRivista(Rivista rivista) {
        this.rivista = rivista;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getNumSpeddizione() {
        return NumSpeddizione;
    }

    public void setNumSpeddizione(int numSpeddizione) {
        NumSpeddizione = numSpeddizione;
    }

    public List<Order> getItems() {
        return items;
    }

    public void setItems(List<Order> items) {
        this.items = items;
    }
}
