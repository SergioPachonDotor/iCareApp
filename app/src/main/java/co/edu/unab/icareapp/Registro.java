package co.edu.unab.icareapp;

public class Registro {
    String nombre;
    String apellido;
    String edad;
    String altura;
    String peso;
    String genero;

    public Registro(){
        this.nombre = "vacio";
        this.apellido = "vacio";
        this.edad = "0";
        this.altura = "0";
        this.peso = "0";
        this.genero = "vacio";
    }
    public Registro(String nombre, String apellido, String edad, String altura, String peso, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String calcularimc(){
        try {
            double peso_d = Double.parseDouble(this.peso);
            double altura_d = Double.parseDouble(this.altura);
            double imc_d  = peso_d / (altura_d * altura_d);
            String resultado = "Su IMC es: "+imc_d;
            return resultado;
        }
        catch (Exception exception){
            String message = "Por favor ingresa los datos";
            return message;
        }

    }

    public String calcularmbasal(){
        String resultado = null;
        String gender = null;
        try {
            /*gender = genero.getSelectedItem().toString();*/
            gender = this.genero;
            double peso_d = Double.parseDouble(this.peso);
            double altura_d = Double.parseDouble(this.altura);
            double edad_d = Double.parseDouble(this.edad);
            double mbasal_hombre = ( 10*peso_d)+(6.25*altura_d*100)-(5*edad_d)+5;
            double mbasal_mujer =( 10*peso_d)+(6.25*altura_d*100)-(5*edad_d)-161;

            resultado = "Su metabolismo basal es: "+mbasal_hombre;
            resultado = "Su metabolismo basal es: "+mbasal_mujer;


        }
        catch (Exception exception){
            String message = "Por favor ingresa los datos";
            return message;
        }
        return resultado;
    }
}
