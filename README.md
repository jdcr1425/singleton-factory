# singleton-factory

proyecto implemento estos dos patrones de diseños de creacion : Singleton y Factory.

<h1>Factory</h1>

<p>Es un objeto que maneja la creación de otros objetos. Las factorías se utilizan cuando la creación de un objeto implica algo más que una simple instanciación.<p>
  
<h3>Los siguientes ejemplos son casos donde una factoría puede ayudar:</h3>

<ul>
  <li>Es necesario acceder a algún recurso para la creación y configuración de un objeto.</li>
  <li>No conocemos hasta el momento preciso de la instanciación qué tipo concreto de objeto se va a instanciar. </li>
</ul>



    public class FactoryAcademia{

    public static Persona getPersona(String tipo){

        if(tipo.equals("estudiante")){
            return new Estudiante();
        }else{
            return new Profesor();
        }
    }


}

tenemos la clase FactoryAcademia,que es la que  nos permite atravez de un metodo getPersona(String tipo) retornar un objeto de tipo, Estudiante o Profesor. Esto es posible ya que existe una clase padre llamada Persona, Y estudiante y persona heredan ella.

USO : Se crea un objeto de tipo Persona y obtenemos el valor de la variable "tipo" por medio de un spinner de opciones Usando el metodo getPersona(rol) hacemos el uso del factory para crear nuestro objeto de un subtipo de Persona.

         Persona p;
         String rol = mySpinner.getSelectedItem().toString();
         p=FactoryAcademia.getPersona(rol);


<h1>Singleton</h1>

Singleton o instancia única es un patrón de diseño que permite restringir la creación de objetos pertenecientes a una clase o el valor de un tipo a un único objeto.

Su intención consiste en garantizar que una clase sólo tenga una instancia y proporcionar un punto de acceso global a ella.

El patrón singleton se implementa creando en nuestra clase un método que crea una instancia del objeto sólo si todavía no existe alguna. Para asegurar que la clase no puede ser instanciada nuevamente se regula el alcance del constructor (con modificadores de acceso como protegido o privado).

En este proyecto se usa este patron de 2 maneras, uno para tener la asistencia de la academia y la otra es usando nuestro objeto singleton como una memoria para siempre cargar nuestros datos al iniciar la aplicacion. (Normalmente seria con el uso de archivos, pero por questiones de requeriemientos no se usó en este proytecto)

    
<b>Memoria</b>    
    
    public class Academiasingleton {

    public Map<String, Object> memory ;


    private static Academiasingleton instance = null;

    private Academiasingleton() {
        memory = new HashMap<String,Object>();
    }

    public static Academiasingleton getInstance()
    {
        if (instance == null) {
            instance = new Academiasingleton();
        }
        return instance;
    }


}

USO:
 -creamos List de tipo Persona
 
  List<Persona> per = new ArrayList<Persona>();
  
  -Le asiganamos a esa lista  lo que obtengamos de nuestra memoria, que no es mas que un HASMAP que registra nuestros estudieantes y       profesores.
  
  per = (List<Persona>)Academiasingleton.getInstance().memory.get("personas");
  
  - Despues nos disponemos a mostrar una lista de todas las personas ingresadas utilizando nuevamente nuestro objeto singleton.
  
        per = (List<Persona>)Academiasingleton.getInstance().memory.get("personas");
        if(per.size() != 0){
            for(int i=0; i< per.size(); i++){
                data+= "Nombre: "+ per.get(i).getNombre() + "\n" +
                        "Idenficacion: " + per.get(i).getID() + "\n" +
                        "Direccion: " + per.get(i).getDireccion() + "\n" +
                        "______________________\n";
            }

            datos.setText(data);
        }


<strong>Asistencia</strong>

    public class asistenciaSingleton {
    private static final asistenciaSingleton contador=new asistenciaSingleton();
    private int Asistencia=0;

    private asistenciaSingleton(){}

    public static asistenciaSingleton getInstance() {
        return contador;
    }

    public void setAsistencia(int a){
        Asistencia+=a;
    }

    public int getAsistencia(){
        return Asistencia;
    }
}


En el MainActivity  podemos ver la implementacion de esto.

      asistenciaSingleton asis= asistenciaSingleton.getInstance();
      asis.setAsistencia(1);
      
      Donde siempre va a apuntar al mismo objeto y por ende siempre tendremos la asistencia en nuestra academia.
   
