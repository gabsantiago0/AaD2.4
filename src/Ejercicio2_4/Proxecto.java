package Ejercicio2_4;

public class Proxecto {

    private int Num_proxecto;
    private String Nome_proxecto;
    private String Lugar;
    private int Num_departamento;

    public Proxecto(int num_proxecto, String nome_proxecto, String lugar, int num_departamento) {
        Num_proxecto = num_proxecto;
        Nome_proxecto = nome_proxecto;
        Lugar = lugar;
        Num_departamento = num_departamento;
    }

    public int getNum_proxecto() {
        return Num_proxecto;
    }

    public void setNum_proxecto(int num_proxecto) {
        Num_proxecto = num_proxecto;
    }

    public String getNome_proxecto() {
        return Nome_proxecto;
    }

    public void setNome_proxecto(String nome_proxecto) {
        Nome_proxecto = nome_proxecto;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String lugar) {
        Lugar = lugar;
    }

    public int getNum_departamento() {
        return Num_departamento;
    }

    public void setNum_departamento(int num_departamento) {
        Num_departamento = num_departamento;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Proxecto: ");
        sb.append("Num_proxecto=").append(Num_proxecto);
        sb.append(", Nome_proxecto='").append(Nome_proxecto).append('\'');
        sb.append(", Lugar='").append(Lugar).append('\'');
        sb.append(", Num_departamento=").append(Num_departamento);
        sb.append('\n');
        return sb.toString();
    }
}
