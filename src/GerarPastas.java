import java.io.File;

public class GerarPastas {
    public static void geradorPastas(String nome[], String caminho) {
        for(String nomes : nome){


            File pasta = new File(caminho + "\\" + nomes);
            
            if(!pasta.exists()){
                pasta.mkdir();
            }

        }
    }
}
