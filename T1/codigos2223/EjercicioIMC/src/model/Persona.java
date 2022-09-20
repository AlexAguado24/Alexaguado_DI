package model;

public class Persona {

    //atributos
    private String nombre, DNI, sexo;
    private double peso, altura;
    private int edad;

    //constructores
    public Persona() {
        this.nombre= "Por defecto";
        this.DNI= "Por defecto";
        this.sexo= "Por defecto";
        this.peso= 0.0;
        this.altura= 0.0;
        this.edad= 0;
    }

    public Persona(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.DNI = "Por defecto";
        this.peso = 0.0;
        this.altura = 0.0;
    }

    public Persona(String nombre /*String DNI*/,int edad, String sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        //this.DNI = DNI;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    //metodos
    public void mostrarDatos (){
        System.out.println(getNombre());
        System.out.println(getEdad());
        System.out.println(getSexo());
        System.out.println(getPeso());
        System.out.println(getAltura());
    }

    public int calcularIMC(){
        double pesoIdeal;
        pesoIdeal = (peso/(altura*2));
        if (pesoIdeal < 20){
            return -1;
        } else if (pesoIdeal >= 20 && pesoIdeal <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        if (new Persona().edad >= 18){
            return true;
        } else {
            return false;
        }
    }

    //getters setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    //ToString
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                ", sexo='" + sexo + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", edad=" + edad +
                '}';
    }
}
