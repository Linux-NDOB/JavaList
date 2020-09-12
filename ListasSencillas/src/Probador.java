import javax.swing.JOptionPane;

public class Probador {

    public static void main(String args[]){
        int op, id;
        ListaSencilla obj = new ListaSencilla();
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog(
                            "Menú principal \n"+
                            "1. Registrar al inicio. \n"+
                            "2. Registrar al final. \n"+
                            "3. Buscar por código. \n"+
                            "4. Mostrar todos por Id. \n"+
                            "5. Eliminar por Id. \n"+
                            "6. Mostrar promedio de Glucosa " +"\n" +
                                    " hemoglobina e imc . \n"+
                            "7. Salir. \n"+
                            "Entre su opción: ?"
            ));

            switch(op){
                case 1:
                    obj.setAddInicio();
                    break;
                case 2:
                    obj.setAddFin();

                    break;
                case 3:
                    id=Integer.parseInt(JOptionPane.showInputDialog(
                            "Porfavor ingrese el id del paciente aque quiere ver: "));
                    obj.getSeeInfo(id);
                    break;

                case 4:
                    obj.setOrdenarB();
                    obj.getMostrarTodo();
                    JOptionPane.showMessageDialog(null,"Se mostro el vector asecendentemente por id");
                    break;

                case 5:
                    id=Integer.parseInt(JOptionPane.showInputDialog(
                            "Ingrese el id del paciente a eliminar: "));
                    obj.setEliminNodo(id);
                    break;

                case 6:

                    obj.getPromediosaMostrar();
                    break;

                case 7:
                    JOptionPane.showMessageDialog(null, "Adios!!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Opción No valida intente de nuevo porfavor!!!");
            }
        }while(op!=7);
        System.exit(0);
    }
}

