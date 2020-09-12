import javax.swing.JOptionPane;

public class nodo {

    public int id;
    public String nombre;
    public String eps;
    public String genero;
    public int año;
    public float peso;
    public float estatura;
    public int Glucosa;
    public float Hemoglobina;
    public float imc;

    nodo sig;

    public nodo(int id, String nombre, String eps, String genero,
                int año, float peso, float estatura, int Glucosa,
                float Hemoglobina, float imc) {
        this.id = id;
        this.nombre = nombre;
        this.eps = eps;
        this.genero = genero;
        this.año = año;
        this.peso = peso;
        this.estatura = estatura;
        this.Glucosa = Glucosa;
        this.Hemoglobina = Hemoglobina;
        this.imc = imc;
        sig = null;
    }

    public void getMostrarNodo() {

        String info = "Información del paciente: \n";
        info += "id: " + id + "\n";
        info += "Nombre: " + nombre + "\n";
        info += "EPS: " + eps + "\n";
        info += "Genero: " + genero + "\n";
        info += "Edad: " + ((año - 2020) * -1) + "\n";

        if ((Glucosa >= 75) && (Glucosa <= 100))
            info += "Nivel de glucosa: " + Glucosa + "Optimo" + "\n";

        else if ((Glucosa > 100) && (Glucosa <= 125))
            info += "Nivel de glucosa: " + Glucosa + "PreDiabetes" + "\n";

        else if (Glucosa > 125)
            info += "Nivel de glucosa: " + Glucosa + "Diabetes" + "\n";


        if ((genero.equals("H") && (Hemoglobina < 13)))
            info += "Nivel de hemoglobina: " + Hemoglobina + "Bajo" + "\n";

        else if ((genero.equals("H") && (Hemoglobina > 13 && Hemoglobina <= 17)))
            info += "Nivel de hemoglobina: " + Hemoglobina + "Optimo" + "\n";

        else if (genero.equals("H") && (Hemoglobina > 17))
            info += "Nivel de hemoglobina: " + Hemoglobina + "Alto" + "\n";

        if ((genero.equals("M") && (Hemoglobina < 12)))
            info += "Nivel de hemoglobina: " + Hemoglobina + "Bajo" + "\n";

        else if ((genero.equals("M") && (Hemoglobina > 12 && Hemoglobina <= 15)))
            info += "Nivel de hemoglobina: " + Hemoglobina + "Optimo" + "\n";

        else if (genero.equals("M") && (Hemoglobina > 15))
            info += "Nivel de hemoglobina: " + Hemoglobina + "Alto" + "\n";

        info += "Peso: " + peso + "Kg" + "\n";
        info += "Estatura: " + estatura + "m²" + "\n";


        if (imc > 15 && imc <= 18.4)

            info += "IMC: " + imc + "Kg/m²" + " Peso Insuficiente" + "\n";

        else if (imc >= 18.5 && imc <= 24.9)

            info += "IMC: " + imc + "Kg/m²" + "Peso normal" + "\n";

        else if (imc >= 25 && imc <= 29.9)
            info += "IMC: " + imc + "Kg/m²" + "SobrePeso" + "\n";

        else if (imc >= 30 && imc <= 39.9)
            info += "IMC: " + imc + "Kg/m²" + "Obesidad clinica" + "\n";

        else if (imc >= 40 && imc <= 49.9)
            info += "IMC: " + imc + "Kg/m²" + "Obesidad Mordiba" + "\n";

        else if (imc >= 50 && imc <= 59.9)
            info += "IMC: " + imc + "Kg/m²" + "Super obesidad mordiba" + "\n";

        else if (imc >= 60 && imc <= 64.9)
            info += "IMC: " + imc + "Kg/m²" + "Super super obesidad " + "\n";

        else if (imc > 65)
            info += "IMC: " + imc + "Kg/m²" + "Triple obesidad" + "\n";


        JOptionPane.showMessageDialog(null, info);
    }
}
