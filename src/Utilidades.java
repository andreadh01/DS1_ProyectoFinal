import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utilidades {

    //Clases para cargar el mundo desde un archivo
    public static String cargarArchivoComoString(String path){
        StringBuilder constructor=new StringBuilder();

        try {
            BufferedReader br=new BufferedReader(new FileReader(path));
            String linea;
            while ((linea=br.readLine()) !=null)
                constructor.append(linea+"\n");
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return constructor.toString();

    }

    //Convierte el texto del archivo a enteros
    public static int parseInt(String numero){
        try {
            return Integer.parseInt(numero);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }

}
