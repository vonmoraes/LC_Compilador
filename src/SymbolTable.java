import java.util.*;
import java.io.*;

public class SymbolTable {
    public static void main(String[] args) {
        
        Hashtable<Integer, String> hash = new Hashtable<Integer, String>();
        int c = 0;
        Scanner ler = new Scanner(System.in);

        System.out.printf("Informe o nome de arquivo texto:\n");
        String nome = ler.nextLine();

        System.out.printf("\nConteúdo do arquivo texto:\n");
    try {
        FileReader arq = new FileReader(nome);
        BufferedReader lerArq = new BufferedReader(arq);

        String linha = lerArq.readLine(); // lê a primeira linha
        // a variável "linha" recebe o valor "null" quando o processo
        // de repetição atingir o final do arquivo texto
        hash.put(c,linha);
        while (linha != null) {
            c++;
            System.out.printf("%s\n", linha);

            linha = lerArq.readLine(); // lê da segunda até a última linha
            if(linha != null){
                hash.put(c,linha);
            }
        }

        arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
        e.getMessage());
        }

        System.out.println();
        System.out.println("//////////////////////////////////////////////");
        System.out.println(hash.values());
        
    }//endmain

}

/**
 * COISAS TALVEZ NECESSÁRIAS PARA A TABELA DE SIMBOLOS
 *  __________________________________________________________________
 * | Nº Token | Lexema |     End. Inserção      |     Tipo   | Escopo |
 * |    0     |  'id'  | ID, Palavras Reservadas| Constantes | 0-INF  |
 * 
 */