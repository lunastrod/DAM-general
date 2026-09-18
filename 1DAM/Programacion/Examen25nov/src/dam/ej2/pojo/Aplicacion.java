package dam.ej2.pojo;

/*
Que permita almacenar:
    el nombre
    una descripción
    la empresa a la que pertenece
    la fecha de lanzamiento
    la posición en el ranking.

"TikTok",
"Es una red social para compartir videos cortos y en formato vertical que pueden tener una duración desde 1 segundo hasta 10 minutos.", "ByteDance", "Septiembre de 2016", 1
"Instagram", 
"Es una aplicación y red social, que permite mensajería instantánea, y una función para publicar fotografías y vídeos temporales, agregando variados filtros y efectos, con una duración máxima de permanencia de 24 horas.", "Meta Platforms", "6 de octubre de 2010", 2
"Facebook", 
"Es una red social.", "Meta Platforms", "4 de febrero de 2004", 3
"WhatsApp",
"Es una aplicación de mensajería instantánea. Permite enviar y recibir mensajes, además de imágenes, videos, audios, grabaciones de audio (notas de voz), documentos, ubicaciones, contactos, gifs, stickers, así como llamadas y videollamadas con varios participantes a la vez", "Meta Platforms", "22 de enero de 2009", 4
"Telegram", 
"Es una plataforma de mensajería instantánea, el envío de varios archivos y la comunicación en masa.", "Telegram FZ-LLC", "14 de agosto de 2013", 5
"Snapchat",
"Es una aplicación de mensajería con soporte multimedia de imagen, vídeo y filtros para fotos de realidad aumentada. Las imágenes y mensajes pueden ser accesibles solo durante un tiempo determinado, como 24 horas, elegido por los usuarios.", "Snap Inc.", "1 de septiembre de 2011", 6
“CapCut", 
“Es es una aplicación gratuita de edición de vídeo que permite a los usuarios crear y editar vídeos cortos de forma sencilla, ofreciendo una amplia gama de funciones.” “ByteDance”, “10 de abril de 2020”, 7

Que tenga un constructor que inicialice los cinco atributos.
Que tenga un método que devuelva el año de lanzamiento teniendo en cuenta que el año son los últimos 4 caracteres de la fecha de lanzamiento.
    Ejemplo: De TikTok sería el 2016
Que tenga un método que devuelva la cantidad de años que lleva en uso recibiendo el año actual como parámetro.
    Ejemplo: TikTok lleva 6 años en uso.
Que tenga un método que devuelva un booleano que indique si la descripción contiene una cadena de caracteres recibida por parámetro.
    Ejemplo: Si la cadena es "red social" para TikTok retornará un true. Si la cadena es "mensajería instantánea" para Facebook retornará un false.
Que tenga un método que indique cuál es la cadena de caracteres que representa a un objeto de este tipo, siguiendo el siguiente formato:
    posición – nombre (empresa)
    Año de lanzamiento: anioLanzamiento				
    Descripción: descripción
*/


public class Aplicacion {
    private String nombre;
    private String descripcion;
    private String empresa;
    private String fecha;
    private int ranking;
    
    public Aplicacion(String nombre, String descripcion, String empresa, String fecha, int ranking) {
        /*constructor que inicializa los cinco atributos*/
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.empresa = empresa;
        this.fecha = fecha;
        this.ranking = ranking;
    }

    public int getRanking() {
        return ranking;
    }

    public String getNombre() {
        return nombre;
    }

    public int anioLanzamiento(){
        /*método que devuelve el año de lanzamiento teniendo en cuenta que el año son los últimos 4 caracteres de la fecha de lanzamiento*/
        //no voy a poner el 4 como constante porque si cambia el formato de la fecha habría que cambiar este método entero.
        return Integer.parseInt(fecha.substring(fecha.length()-4));
    }

    public int aniosEnUso(int anioActual){
        /*método que devuelve la cantidad de años que lleva en uso recibiendo el año actual como parámetro */
        return anioActual-anioLanzamiento();
    }

    public boolean descripcionContiene(String s){
        /*método que devuelve la cantidad de años que lleva en uso recibiendo el año actual como parámetro */
        //si indexOf no encuentra una cadena devuelve -1, si no, devuelve un indice (positivo)
        //ignora minusculas y mayusculas pasando todo a minusculas
        return descripcion.toLowerCase().indexOf(s.toLowerCase())>=0;
    }

    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(ranking);
        res.append(" - ");
        res.append(nombre);
        res.append(" (");
        res.append(empresa);
        res.append(")\nAño de lanzamiento: ");
        res.append(anioLanzamiento());
        res.append("\nDescripción: ");
        res.append(descripcion);
        return res.toString();
    }
}
