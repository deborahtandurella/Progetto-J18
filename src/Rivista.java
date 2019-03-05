public class Rivista {
    /**/
    private String IDrivista;
    private String nomeR;
    private Categoria categoria;
    private double costo;
    private Periodo periodo;

    public Rivista(String IDrivista, String nomeR, Categoria categoria, double costo, Periodo periodo) {
        this.IDrivista = IDrivista;
        this.nomeR = nomeR;
        this.categoria = categoria;
        this.costo = costo;
        this.periodo = periodo;
    }

    public String getIDrivista() {
        return IDrivista;
    }

    public String getNomeR() {
        return nomeR;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public double getCosto() {
        return costo;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public boolean inserisciRivista(Rivista R)
        {
            R.getCategoria();
        }
}
