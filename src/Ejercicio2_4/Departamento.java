package Ejercicio2_4;

public class Departamento {

    private int Num_departamento;
    private String Nome_departamento;
    private String NSS_dirige;
    private String Data_direccion;


    public Departamento(int num_departamento, String nome_departamento, String NSS_dirige, String data_direccion) {
        Num_departamento = num_departamento;
        Nome_departamento = nome_departamento;
        this.NSS_dirige = NSS_dirige;
        Data_direccion = data_direccion;
    }

    public int getNum_departamento() {
        return Num_departamento;
    }

    public void setNum_departamento(int num_departamento) {
        Num_departamento = num_departamento;
    }

    public String getNome_departamento() {
        return Nome_departamento;
    }

    public void setNome_departamento(String nome_departamento) {
        Nome_departamento = nome_departamento;
    }

    public String getNSS_dirige() {
        return NSS_dirige;
    }

    public void setNSS_dirige(String NSS_dirige) {
        this.NSS_dirige = NSS_dirige;
    }

    public String getData_direccion() {
        return Data_direccion;
    }

    public void setData_direccion(String data_direccion) {
        Data_direccion = data_direccion;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Departamento: ");
        sb.append("Num_departamento=").append(Num_departamento);
        sb.append(", Nome_departamento='").append(Nome_departamento).append('\'');
        sb.append(", NSS_dirige='").append(NSS_dirige).append('\'');
        sb.append(", Data_direccion=").append(Data_direccion);
        sb.append('\n');
        return sb.toString();
    }
}
