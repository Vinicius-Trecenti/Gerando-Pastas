import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Arquivos {
    File file;
    String caminho;
    static int N = 0;
    static int[] vetorInvert;

    Arquivos() {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showSaveDialog(chooser);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            caminho = chooser.getSelectedFile().getAbsolutePath();
            // arqEscrita = chooser.getSelectedFile().getName();
        }

        File file = new File(caminho);
        // System.out.println(file.getName() +"\n"+ file.getAbsolutePath());

    }

    public static void main(String[] args) {
        //Arquivos file = new Arquivos();

        // file.info();

        // ----------Funções -----------------

        // a.info(); //informações dos arquivos
        // a.criandoArquivos();//cria os arquivos
        // a.listandoArquivos();
        // a.lerArquivo();
        // a.escreverArquivo();

        // -----------------------------------

        // File file = new File("C:\\Users\\cg3023745\\Documents\\Arquivos");

        // if(file.exists() == false){
        // file.mkdir();
        // }
        // if(file.isDirectory()){
        // System.out.println(file.getName());
        // }

        // System.out.println("File = "+file.getAbsoluteFile()); //pega onde ele ta - o
        // nome dele pra criar
        // //System.out.println("Tamanho "+file.getAbsolutePath()); //pega o caminho do
        // arquivo
        // System.out.println("Tamanho "+file.length());
        // System.out.println("Espaço livre"+ file.getFreeSpace());

        // for(int i=0; i<10; i++){
        // File file = new File("C:\\Users\\cg3023745\\Documents\\Arquivos" +
        // String.valueOf(i));

        // if(file.exists() == false){
        // file.mkdir(); //vai criar o diretório dnv
        // }

        // System.out.println(file.getAbsoluteFile()); //pega onde ele ta - o nome dele
        // pra criar
        // System.out.println(file.getAbsolutePath());
        // System.out.println(file.length());

        // //File arq = new File("C:\\Users\\cg3023745\\Documents\\Arquivos\\nota.txt");

        // }

        // out.println(file.length());
        // System.exit(0); //sairia do programa
    }

    public void info() {
        File file = new File(caminho);

        if (file.exists() == false) {
            file.mkdir();
        }
        if (file.isDirectory()) { // pergunta o diretorio e qual o nome
            System.out.println(file.getName());
        }

        System.out.println("File: " + file.getAbsoluteFile()); // pega onde ele ta - o nome dele pra criar
        // System.out.println("Tamanho "+file.getAbsolutePath()); //pega o caminho do
        // arquivo
        System.out.println("Tamanho: " + file.length());
        System.out.println("Espaço livre: " + file.getFreeSpace());
    }

    public void criandoArquivos() {

        // pedindo humildemente para que o programa converse com partes fora
        // obrigatorio para criar aquivos
        try {

            for (int i = 0; i < 10; i++) { // criando dez arquivos
                File arquivo = new File(file.getAbsoluteFile() + "\\nota" + String.valueOf(i) + ".txt");
                arquivo.createNewFile(); // de fato criado o arquivo
                arquivo.setWritable(false); // false nao permite mais que voce escreva no arquivo - apenas o meu usuario
                                            // que esta como proprietario
                arquivo.setReadable(false); // para leitura

                // necessario criar outro obj para renomear
                File tmp = new File(file.getAbsoluteFile() + "\\texto" + String.valueOf(i) + ".doc");
                arquivo.renameTo(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void listandoArquivos() {

        if (file.isDirectory()) { // pergunta o diretorio e qual o nome
            String[] arquivos = file.list(); // pega todos os nomes dos arquivos

            for (int i = 0; i < arquivos.length; i++) {
                System.out.println(arquivos[i]);
            }

        }

    }

    public void lerArquivo() {
        try {
            String linha;
            BufferedReader buffRead = new BufferedReader(new FileReader(caminho));
            System.out.println("Lendo o arquivo " + caminho);
            linha = buffRead.readLine();

            N = Integer.valueOf(linha);

            int vetor[] = new int[N];

            System.out.println("valor de N: " + N);

            int cont = 0;
            int lin = 1;
            while (linha != null) {

                if (lin == 1) {
                    lin++;

                } else if (lin != 1 && cont < N) {
                    vetor[cont] = Integer.valueOf(linha);
                    cont++;
                }
                System.out.println(linha);
                linha = buffRead.readLine();
            }

            System.out.println("valor de N: " + N);
            for(int i=0; i<N; i++){
                System.out.println(vetor[i]);
            }

            vetorInvert = new int[N];
            int contador=0;

            for(int c=N-1; c>=0; c--){
                vetorInvert[contador] = vetor[c];
                contador= contador+1;
            }

            

            buffRead.close();
            

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public void escreverArquivo() {
        try {
            FileWriter escritor = new FileWriter(file + "\\texto11.txt"); // cria o arquivo
            BufferedWriter bfw = new BufferedWriter(escritor); // transforma em um arquivo manda do hd para ram
            String tmp = "Teste" + "\r\n" + "Teste 2";

            bfw.write(tmp);

            // fechar
            bfw.close(); // nao sai do sistema operaciona, para pode ser fechado em uso
            escritor.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    static JFileChooser chooser = new JFileChooser();
    static int returnValue;


    public static void Write() {
        try {
            String pathFileWriter = "";

            returnValue = chooser.showSaveDialog(chooser);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                pathFileWriter = chooser.getSelectedFile().getAbsolutePath();
            }

            System.out.println("Escrevendo no arquivo " + pathFileWriter);

            FileWriter writer = new FileWriter(pathFileWriter, false);
            BufferedWriter bufferWriter = new BufferedWriter(writer);

            for (int number : vetorInvert) {
                bufferWriter.append(number + ", ");
            }

            bufferWriter.close();
            writer.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}