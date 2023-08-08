import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Pastas {

    /*Joao
        Ana
        Lucas
            Maria
            Pedro
                Luiz
            Ricardo
        Antony
            Felipe
    
    */




    public static void main(String[] args) throws IOException {

        GerarPastas raiz = new GerarPastas();

        String caminho_atual = System.getProperty("user.dir");

        String principal[] = {"João"};
        String pastasJoao[] = {"Ana", "Lucas", "Antony"};
        String pastasLucas[] = {"Maria", "Pedro", "Ricardo"};
        String pastasPedro[] = {"Luiz"};
        String pastasAntony[] = {"Felipe"};
        String pastasFelipe[] = {"Carol"};


        raiz.geradorPastas(principal, caminho_atual);
        raiz.geradorPastas(pastasJoao, caminho_atual + "\\João");
        raiz.geradorPastas(pastasLucas, caminho_atual + "\\João\\Lucas");
        raiz.geradorPastas(pastasPedro, caminho_atual + "\\João\\Lucas\\Pedro");
        raiz.geradorPastas(pastasAntony, caminho_atual + "\\João\\Antony");
        raiz.geradorPastas(pastasFelipe, caminho_atual + "\\João\\Antony\\Felipe");

        
        /*
        String nome_raiz;
        nome_raiz = JOptionPane.showInputDialog("Digite o nome para a pasta raiz: ");
        File joao = new File(nome_raiz);

        if(!joao.exists()){
            joao.mkdir();
        }

            String filho1;
            filho1 = JOptionPane.showInputDialog("Digite o nome para que ficara dentro da joao: ");
            File ana = new File(joao.getAbsoluteFile() + "\\" + filho1);

            if(!ana.exists()){
                ana.mkdir(); //Ana
            }

            String filho2;
            filho2 = JOptionPane.showInputDialog("Digite o nome para que ficara dentro da joao: ");
            File lucas = new File(joao.getAbsoluteFile() + "\\" + filho2);

            if(!lucas.exists()){
                lucas.mkdir(); //Lucas
            }

                String maria;
                maria = JOptionPane.showInputDialog("Digite o nome para que ficara dentro da Lucas: ");
                File pastamaria = new File(joao.getAbsoluteFile() + "\\"+ filho2 + "\\" + maria);

                if(!pastamaria.exists()){
                    pastamaria.mkdir(); //Maria
                }
            */



    /*Joao
        Ana
        Lucas
            Maria
            Pedro
                Luiz
            Ricardo
            Antony
                Felipe
    
    */

                
    
    }
}
