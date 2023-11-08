package Ejercicio2_4;

public class Empregado {

    private String Nome;
    private String Apelido_1;
    private String Apelido_2;
    private String NSS;
    private String Rua;
    private int Numero_rua;
    private String Piso;
    private String CP;
    private String Localidade;
    private String Data_nacemento;
    private float Salario;
    private String Sexo;
    private String NSS_Supervisa;
    private int Num_departamento_pertenece;

    public Empregado(String nome, String apelido_1, String apelido_2, String NSS, String rua, int numero_rua, String piso, String CP, String localidade, String data_nacemento, float salario, String sexo, String NSS_Supervisa, int num_departamento_pertenece) {
        Nome = nome;
        Apelido_1 = apelido_1;
        Apelido_2 = apelido_2;
        this.NSS = NSS;
        Rua = rua;
        Numero_rua = numero_rua;
        Piso = piso;
        this.CP = CP;
        Localidade = localidade;
        Data_nacemento = data_nacemento;
        Salario = salario;
        Sexo = sexo;
        this.NSS_Supervisa = NSS_Supervisa;
        Num_departamento_pertenece = num_departamento_pertenece;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getApelido_1() {
        return Apelido_1;
    }

    public void setApelido_1(String apelido_1) {
        Apelido_1 = apelido_1;
    }

    public String getApelido_2() {
        return Apelido_2;
    }

    public void setApelido_2(String apelido_2) {
        Apelido_2 = apelido_2;
    }

    public String getNSS() {
        return NSS;
    }

    public void setNSS(String NSS) {
        this.NSS = NSS;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String rua) {
        Rua = rua;
    }

    public int getNumero_rua() {
        return Numero_rua;
    }

    public void setNumero_rua(int numero_rua) {
        Numero_rua = numero_rua;
    }

    public String getPiso() {
        return Piso;
    }

    public void setPiso(String piso) {
        Piso = piso;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public String getLocalidade() {
        return Localidade;
    }

    public void setLocalidade(String localidade) {
        Localidade = localidade;
    }

    public String getData_nacemento() {
        return Data_nacemento;
    }

    public void setData_nacemento(String data_nacemento) {
        Data_nacemento = data_nacemento;
    }

    public float getSalario() {
        return Salario;
    }

    public void setSalario(float salario) {
        Salario = salario;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getNSS_Supervisa() {
        return NSS_Supervisa;
    }

    public void setNSS_Supervisa(String NSS_Supervisa) {
        this.NSS_Supervisa = NSS_Supervisa;
    }

    public int getNum_departamento_pertenece() {
        return Num_departamento_pertenece;
    }

    public void setNum_departamento_pertenece(int num_departamento_pertenece) {
        Num_departamento_pertenece = num_departamento_pertenece;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Empregado: ");
        sb.append("Nome='").append(Nome).append('\'');
        sb.append(", Apelido_1='").append(Apelido_1).append('\'');
        sb.append(", Apelido_2='").append(Apelido_2).append('\'');
        sb.append(", NSS='").append(NSS).append('\'');
        sb.append(", Rua='").append(Rua).append('\'');
        sb.append(", Numero_rua=").append(Numero_rua);
        sb.append(", Piso='").append(Piso).append('\'');
        sb.append(", CP='").append(CP).append('\'');
        sb.append(", Localidade='").append(Localidade).append('\'');
        sb.append(", Data_nacemento=").append(Data_nacemento);
        sb.append(", Salario=").append(Salario);
        sb.append(", Sexo='").append(Sexo).append('\'');
        sb.append(", NSS_Supervisa='").append(NSS_Supervisa).append('\'');
        sb.append(", Num_departamento_pertenece=").append(Num_departamento_pertenece);
        sb.append('\n');
        return sb.toString();
    }
}
