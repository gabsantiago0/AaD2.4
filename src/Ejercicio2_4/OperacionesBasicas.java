package Ejercicio2_4;

import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;


public class OperacionesBasicas {

    static Connection conexion;


    //-----------------------------------------------------------------Metodos ABRIR/CERRAR CONEXION------------------------------------------------------//
    public static void abrirConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/DBEmpresa", "root", "Abc123.,");
        } catch (ClassNotFoundException | SQLException ex) {
            cerrarConexion();
        }

    }

    public static void cerrarConexion() {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

//-------------------------------------------------------------------------EJERCICIO 1-----------------------------------------------------------------------------------------------------//


    // A) Fai un método para subir o salario aos empregados dun determinado departamento. O método recibirá
    //como parámetros a cantidade a aumentar e o nome do departamento.
    public static void aumentarSueldoDepartamento(float salario, Departamento nombreDepartamento) {

        String update = "UPDATE EMPREGADO SET Salario = Salario + ? " +
                "WHERE Num_departamento_pertenece IN (SELECT Num_departamento FROM DEPARTAMENTO WHERE Nome_departamento = ?)";

        try {
            abrirConexion();
            try (PreparedStatement ps = conexion.prepareStatement(update)) {
                ps.setFloat(1, salario);
                ps.setString(2, nombreDepartamento.getNome_departamento());
                int filasIncrementadas = ps.executeUpdate();
                System.out.println("Se han incrementado " + filasIncrementadas + " Empleados del departamento " + nombreDepartamento.getNome_departamento());

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            cerrarConexion();
        }

    }

    // B) Fai un método para inserir un novo departamento. O método recibirá como parámetros o número,
    //nome do departamento e o nss do empregado director. A data do comezo do director do departamento será a
    //data do sistema.
    public static void insertarNuevoDepartamento(int numeroDepartamento, String nombreDepartamento, String NSSDirige) {

        String insert = "INSERT INTO DEPARTAMENTO (Num_departamento, Nome_departamento, NSS_Dirige) VALUES (?,?,?,?)";

        try {
            abrirConexion();
            try (PreparedStatement ps = conexion.prepareStatement(insert)) {
                ps.setInt(1, numeroDepartamento);
                ps.setString(2, nombreDepartamento);
                ps.setString(3, NSSDirige);
                ps.setDate(4, Date.valueOf(LocalDate.now()));
                int filasIncrementadas = ps.executeUpdate();

                if (filasIncrementadas > 0) {
                    System.out.println("Se ha añadido con exito el nuevo DEPARTAMENTO");
                } else {
                    System.out.println("No se ha añadido.");
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            cerrarConexion();
        }
    }

    // C) Fai un método para borrar un empregado dun proxecto. O método recibirá como parámetros o nss do
    //empregado e o número do proxecto.
    public static void borrarEmpleadoDeProyecto(String NSS, int numProyecto) {
        String delete = "DELETE FROM EMPREGADO_PROXECTO WHERE NSS_Empregado = ? AND Num_proxecto = ?)";

        try {
            abrirConexion();
            try (PreparedStatement ps = conexion.prepareStatement(delete)) {
                ps.setString(1, NSS);
                ps.setInt(2, numProyecto);
                int filasAfectadas = ps.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Se ha BORRADO con EXITO.");
                } else {
                    System.out.println("No se ha eliminado.");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            cerrarConexion();
        }
    }

//-------------------------------------------------------------------------EJERCICIO 2-----------------------------------------------------------------------------------------------------//

//No programa anterior, engade un método para visualizar os nomes, apelidos, localidade, salario, data de
//nacemento, nome do empregado xefe e o nome do departamento onde traballan, de aqueles empregados
//dunha determinada localidade. O método recibirá por parámetro o nome da localidade. Para executar as
//sentenzas utilizarase a interface Statement e deberanse controlar os posibles erros.

    public static Empregado visualizarEmpregadoXefe(String nombreLocalidad) {
        String select = "select EMPREGADO.Nome,EMPREGADO.Apelido_1,EMPREGADO.Apelido_2,EMPREGADO.Localidade,EMPREGADO.Data_nacemento,EMPREGADO.Salario,DEPARTAMENTO.Nome_departamento, jefe.Nome as Supervisor from EMPREGADO" +
                " INNER JOIN EMPREGADO as jefe ON EMPREGADO.NSS_Supervisa = jefe.NSS" +
                " INNER JOIN DEPARTAMENTO ON DEPARTAMENTO.Num_departamento=EMPREGADO.Num_departamento_pertenece" +
                " Where DEPARTAMENTO.Num_departamento='" + nombreLocalidad + "'";

        try {
            abrirConexion();

            try (Statement s = conexion.createStatement()) {
                s.executeUpdate(select);

                //Datos de casa

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

//-------------------------------------------------------------------------EJERCICIO 3-----------------------------------------------------------------------------------------------------//

//a) Fai un método para cambiar o departamento que controla un proxecto. O método recibirá como
//parámetros o nome do departamento e o nome do proxecto.

    public static void cambiarDepartControlaProxecto(String nomeDepart, String nomeProxect) {

        String sentencia = "UPDATE PROXECTO SET Num_departamento =" +
                " (SELECT Num_departamento FROM DEPARTAMENTO WHERE Nome_departamento = ?)" +
                " WHERE Nome_proxecto = ?";

        try {
            abrirConexion();
            try (PreparedStatement ps = conexion.prepareStatement(sentencia)) {

                ps.setString(1, nomeDepart);
                ps.setString(2, nomeProxect);

                int filasAfectadas = ps.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Se ha modificado correctamente");
                } else {
                    System.out.println("No se ha modificado");
                }

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            cerrarConexion();
        }

    }

//b) Fai un método para inserir un novo proxecto. O método recibirá como parámetro un obxecto proxecto.
//Crea a clase proxecto, cos métodos setter e getter, e coa mesma estrutura que a táboa proxecto.

    public static void insertarNuevoProxecto(Proxecto p) {

        String insert = "INSERT INTO PROXECTO (Num_proxecto, Nome_proxecto, Lugar, Num_departamento) VALUES (?,?,?,?)";

        try {
            abrirConexion();
            try (PreparedStatement ps = conexion.prepareStatement(insert)) {
                ps.setInt(1, p.getNum_proxecto());
                ps.setString(2, p.getNome_proxecto());
                ps.setString(3, p.getLugar());
                ps.setInt(4, p.getNum_departamento());
                int filasIncrementadas = ps.executeUpdate();

                if (filasIncrementadas > 0) {
                    System.out.println("Se ha añadido con exito el nuevo DEPARTAMENTO");
                } else {
                    System.out.println("No se ha añadido.");
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            cerrarConexion();
        }
    }

//C) Fai un método para borrar un proxecto. O método recibirá como parámetros o número do proxecto.
//Tamén debes borrar a información da asignación dos empregados ao proxecto

    public static void borrarProyecto(int numProyecto) {
        String delete = "DELETE PROXECTO, EMPREGADO_PROXECTO" +
                " FROM PROXECTO INNER JOIN EMPREGADO_PROXECTO ON PROXECTO.Num_proxecto = EMPREGADO_PROXECTO.Num_proxecto" +
                " WHERE PROXECTO.Num_proxecto = ?";

        try {
            abrirConexion();
            try (PreparedStatement ps = conexion.prepareStatement(delete)) {
                ps.setInt(1, numProyecto);
                int filasAfectadas = ps.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Se ha BORRADO con EXITO.");
                } else {
                    System.out.println("ERROR : No se ha eliminado.");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            cerrarConexion();
        }
    }

//-------------------------------------------------------------------------EJERCICIO 4-----------------------------------------------------------------------------------------------------//

    //No programa anterior, engade un método que reciba como parámetro o nome dun departamento e devolva
    //una lista de obxectos proxectos coa información dos proxectos que controla dito departamento. Utiliza
    //sentenzas parametrizadas e controla os posible erros.

    public static ArrayList<Proxecto> listaDeInfoProxectos(String Nome_departamento){
        ArrayList<Proxecto> lista = new ArrayList<>();
        Proxecto proxecto;
        String consulta = "SELECT PROXECTO.Num_proxecto,PROXECTO.Nome_proxecto,PROXECTO.Lugar,PROXECTO.Num_departamento" +
                " FROM PROXECTO INNER JOIN DEPARTAMENTO ON PROXECTO.Num_departamento = DEPARTAMENTO.Num_departamento" +
                " WHERE DEPARTAMENTO.Nome_departamento=?";

        try {
            abrirConexion();
            try (PreparedStatement ps = conexion.prepareStatement(consulta)){
                ps.setString(1,Nome_departamento);
                try (ResultSet rs = ps.executeQuery()){
                    while(rs.next()){
                        proxecto = new Proxecto(
                                rs.getInt("Num_proxecto"),
                                rs.getString("Nome_proxecto"),
                                rs.getString("Lugar"),
                                rs.getInt("Num_departamento")
                        );
                        lista.add(proxecto);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            cerrarConexion();
        }
        return lista;
    }

//-------------------------------------------------------------------------EJERCICIO 5-----------------------------------------------------------------------------------------------------//

    // Primeiro, na base de datos BDEmpresa, crea un procedemento almacenado chamado
    //pr_cambioDomicilio para que modifique a dirección dun empregado cos datos que se lle pasan por
    //parámetro. O procedemento recibirá como parámetros o nss do empre-gado, e os novos datos: rúa, número,
    //piso, código postal e localidade.

    //– Crea un método que chame ao procedemento sp_cambioDomicilio. O método recibirá como
    //parámetros o nss do empregado, a rúa, o número, o piso, o código postal e a localidade




}