import javax.swing.JOptionPane;

public class ListaSencilla {


    nodo cab;


    public ListaSencilla(){ cab=null; }


    public int getTamlista(){
        int cont=0;
        nodo p=cab;
        if(cab==null)
            return 0;
        else{
            while(p!=null){
                cont++;
                p=p.sig;
            }
            return cont;
        }
    }


    public nodo getBuscarCodP(int id){
        nodo buscar=null;
        if(cab==null)
            return null;
        else{
            buscar=cab;
            while(buscar!=null){
                if( buscar.id == id )
                    return buscar;
                buscar = buscar.sig;
            }
            return null;
        }
    }

    public nodo getCrearNodo() {
        int id;
        String nombre;
        String eps;
        String genero;
        int año;
        float peso;
        float estatura;
        int Glucosa;
        float Hemoglobina;
        float imc;

        nodo b = null;
        do {
            id = Integer.parseInt(JOptionPane.showInputDialog(
                    "Entre id de pacient a registrar: "));
            b = getBuscarCodP(id);
            if (b != null)
                JOptionPane.showMessageDialog(null,
                        "El id ya existe en la lista");
        } while (b != null);
        nombre = JOptionPane.showInputDialog("Entre nombre del paciente: ");

        eps = JOptionPane.showInputDialog("Entre la eps del paciente: ");

        genero = JOptionPane.showInputDialog("Entre el genero del paciente H o M: ");

        año = Integer.parseInt(JOptionPane.showInputDialog("Entre año de nacimiento del paciente: "));

        peso = Float.parseFloat(JOptionPane.showInputDialog(
                "Entre peso del paciente en Kg: "));

        estatura = Float.parseFloat(JOptionPane.showInputDialog(
                "Entre estatura del paciente en m: "));

        float estaturaAlCuadrado= (estatura*estatura);

        imc = peso/estaturaAlCuadrado;


        Glucosa = Integer.parseInt(JOptionPane.showInputDialog("Entre los niveles de glucosa em mg/dl"));
        Hemoglobina = Float.parseFloat(JOptionPane.showInputDialog(
                "Entre nivel de hemoglobina del paciente m/dl: "));


        nodo info = new nodo( id, nombre, eps, genero, año,
                peso, estatura, Glucosa, Hemoglobina,imc);

        return  info;

    }

    public void setAddInicio(){
        nodo info = getCrearNodo();
        if(cab==null){
            cab=info;
            JOptionPane.showMessageDialog(null,
                    "Elemento agregado, la lista estaba vacía!");
        }else{
            info.sig = cab;
            cab = info;
            JOptionPane.showMessageDialog(null,
                    "Elemento agregado al incio de la lista!");
        }
    }

    public void setAddFin(){
        nodo info=getCrearNodo();
        nodo p=null;
        if(cab==null){
            cab=info;
            JOptionPane.showMessageDialog(null,
                    "Elemento agregado, la lista estaba vacía!");
        }else{
            p=cab;
            while(p.sig!=null)
                p=p.sig;
            p.sig=info;
            JOptionPane.showMessageDialog(null,
                    "Elemento agregado al final de la lista!");
        }
    }

    public boolean getEsVacia(){
        return cab==null?true:false;
    }

    public void getMostrarTodo(){
        nodo p=null;
        if(getEsVacia())
            JOptionPane.showMessageDialog(null,
                    "La lista no tiene elementos!");
        else{
            p=cab;
            while(p!=null){
                p.getMostrarNodo();
                p=p.sig;
            }
            JOptionPane.showMessageDialog(null,
                    "Se mostraron todos los elementos de la lista, "
                            + "la lista tiene: "+getTamlista()+" elementos.");
        }
    }

    public void getSeeInfo(int id){
        if(cab==null)
            JOptionPane.showMessageDialog(null,
                    "La lista esta vacía!!!");
        else{
            nodo p=getBuscarCodP(id);
            if(p==null)
                JOptionPane.showMessageDialog(null,
                        "El elemento consultado no existe!!");
            else
                p.getMostrarNodo();
        }
    }

    public nodo getBack(nodo p){
        nodo q=cab;
        while(q.sig!=p)
            q=q.sig;
        return q;
    }

    public void setEliminNodo(int id){
        if(getEsVacia())
            JOptionPane.showMessageDialog(null,
                    "La lista esta vacía!");
        else{
            nodo q=null;
            nodo p=getBuscarCodP(id);
            if(p==null)
                JOptionPane.showMessageDialog(null,
                        "El elemento no existe!!");
            else{
                if((p==cab)&&(cab.sig==null)){
                    cab=null;
                    JOptionPane.showMessageDialog(null,
                            "Se eliminó el único elemento de la lista,"
                                    + " la lista esta vacía!!");
                }
                else if((cab.sig!=null)&&(p==cab)){
                    cab=cab.sig;
                    p.sig=null;
                    p=null;
                    JOptionPane.showMessageDialog(null,
                            "Elemento eliminado al inicio de la lista!!");
                }
                else if(p.sig==null){
                    q=getBack(p);
                    q.sig=null;
                    p=null;
                    JOptionPane.showMessageDialog(null,
                            "Elemento eliminado al final de la lista!!");
                }else{
                    q=getBack(p);
                    q.sig=p.sig;
                    p.sig=null;
                    p=null;
                    JOptionPane.showMessageDialog(null,
                            "Elemento eliminado entre dos nodos!!");
                }
            }
        }
    }

    public float getSumaG(){
        float sum;
        nodo q;
        if(getEsVacia())
            return 0;
        else{
            sum=0;
            q=cab;
            while(q!=null){
                sum+=q.Glucosa;
                q=q.sig;
            }
            return sum;
        }
    }

    public float getPromedioG(){
        if(cab==null)
            return 0;
        else{
            float tam=(float) getTamlista();
            return getSumaG()/tam;
        }
    }

    public float getSumaH(){
        float sum;
        nodo q;
        if(getEsVacia())
            return 0;
        else{
            sum=0;
            q=cab;
            while(q!=null){
                sum+=q.Hemoglobina;
                q=q.sig;
            }
            return sum;
        }
    }

    public float getPromedioH(){
        if(cab==null)
            return 0;
        else{
            float tam=(float) getTamlista();
            return getSumaH()/tam;
        }
    }

    public float getSumaI(){
        float sum;
        nodo q;
        if(getEsVacia())
            return 0;
        else{
            sum=0;
            q=cab;
            while(q!=null){
                sum+=q.imc;
                q=q.sig;
            }
            return sum;
        }
    }

    public float getPromedioI(){
        if(cab==null)
            return 0;
        else{
            float tam=(float) getTamlista();
            return getSumaI()/tam;
        }
    }

    public void getPromediosaMostrar(){

        JOptionPane.showMessageDialog(null,
                "El promedio de Glucosa en el paciente es:" + getPromedioG() +"\n"+
                "El promedio de Hemoglobina en el paciente  es:" + getPromedioH()+"\n"+
                "El promedio de IMC en el paciente es:" + getPromedioI());
    }

    public void setOrdenarB( ){
        nodo temp=null;
        if(getEsVacia())
            JOptionPane.showMessageDialog(null,
                    "Lista vacía!!!");
        else{
            nodo p,q;
            p=cab;
            while(p!=null){
                q=cab;
                while(q.sig!=null){
                    if((q.id) > ( q.sig.id)){
                        temp=new nodo(
                                q.id,
                                q.nombre,
                                q.eps,
                                q.genero,
                                q.año,
                                q.peso,
                                q.estatura,
                                q.Glucosa,
                                q.Hemoglobina,
                                q.imc
                        );

                        q.id  = q.sig.id ;
                        q.nombre = q.sig.nombre;
                        q.eps = q.sig.eps;
                        q.genero = q.sig.genero;
                        q.año  = q.sig.año ;
                        q.peso = q.sig.peso;
                        q.estatura = q.sig.estatura;
                        q. Glucosa = q.sig.Glucosa;
                        q.Hemoglobina = q.sig.Hemoglobina;
                        q.imc = q.sig.imc;
                        q.sig.id = temp.id;
                        q.sig.nombre = temp.nombre;
                        q.sig.eps = temp.eps;
                        q.sig.genero = temp.genero;
                        q.sig.año = temp.año;
                        q.sig.peso = temp.peso;
                        q.sig.estatura = temp.estatura;
                        q.sig.Glucosa = temp.Glucosa;
                        q.sig.Hemoglobina = temp.Hemoglobina;
                        q.sig.imc = temp.imc;
                    }
                    q=q.sig;
                }
                p=p.sig;
            }
        }
    }
}
