/** 
 * ? Primeira Entrega   
 *  Componentes do grupo
 *  Luana Duarte Santana Farias - 576425
 *  Lucas de Souza Moraes - 536454
 */

import java.util.*;
import java.io.*;

/** enum Error
 *  Identificacao de erros de compilacao da linguagem L
 */
enum Error {
    // Acontece quando digita o nome do arquivo errado ou o mesmo nao exista
    ARQ_INEXISTENTE("arquivo fonte nao encontrado."), 
    // Acontece se o arquivo fonte contem caractere nao aceito na linguagem
    CHR_INVALIDO("caractere invalido."), 
    // Acontece quando na AFD iniciou-se a identificacao de um lexema mas nao 
    // chegou no estado final SF
    LEX_NIDENTIFICADO("lexema nao identificado "),
    // Acontece quando na AFD iniciou-se a identificao de um lexema mas chegou-se 
    // no fim do arquivo antes de chegar no estado final SF
    FIM_ARQUIVO("fim de arquivo nao esperado."),
    // Acontece na tentativa de casar um token mas o token atual nao ser o token esperado
    TKN_INESPERADO("token nao esperado ");
    
    private final String descricao;
  
    private Error(String descricao) {
      this.descricao = descricao;
    }

    /**
     * Executa Error. Apresentando mensagem de erro da forma nn : erro onde nn = linha do erro
     */
    public void executar(int linha) {
        System.out.println(linha + ":" + descricao);
        System.exit(0);
    }

    /**
     * Executa Error. Apresentando mensagem de erro da forma nn : erro [lex] onde nn = linha do erro
     */
    public void executar(int linha, String lexema) {
        System.out.println(linha + ":" + descricao + "[" + lexema + "].");
        System.exit(0);
    }

}

/** class Token
 *  tipo: Token → Armazena byte com ID do token e seu lexema
 */
class Token {

    public byte id;
    public String lexema;

    public Token(){
        this.lexema = "";
    }

    public Token(byte id, String lexema){
        this.id = id;
        this.lexema = lexema;
    }

    /**
     * @return id
     */
    public byte get_id(){
        return this.id;
    }

    /**
     * @return lexema
     */
    public String get_lexema(){
        return this.lexema;
    }
}

/** class Tabela_Simbolos
 *  tipo: Tabela_Simbolos → Armazena informacoes sobre tokens reseravados & identificadores
 */
class Tabela_Simbolos {

    LinkedHashMap < Token, String > tabela_simbolos = new LinkedHashMap < Token, String >();
    // Tokens reservados da linguagem L 
    final Token MAIS = new Token((byte) 0, "+");
    final Token MENOS = new Token((byte) 1, "-");
    final Token ASTERISCO = new Token((byte) 2, "*");
    final Token PAR_ESQUERDO = new Token((byte) 3, "(");
    final Token PAR_DIREITO = new Token((byte) 4, ")");
    final Token VIRGULA = new Token((byte) 5, ",");
    final Token PONTO_VIRGULA = new Token((byte) 6, ";");
    final Token DIFERENTE = new Token((byte) 7, "!=");
    final Token ATRIBUICAO = new Token((byte) 8, "=");
    final Token IGUAL = new Token((byte) 9, "==");
    final Token MENOR = new Token((byte) 10, "<");
    final Token MENOR_IGUAL = new Token((byte) 11, "<=");
    final Token MAIOR = new Token((byte) 12, ">");
    final Token MAIOR_IGUAL = new Token((byte) 13, ">=");
    final Token BARRA = new Token((byte) 14, "/");
    final Token CONST = new Token((byte) 15, "const");
    final Token INTEGER = new Token((byte) 16, "integer");
    final Token BYTE = new Token((byte) 17, "byte");
    final Token STRING = new Token((byte) 18, "string");
    final Token BOOLEAN = new Token((byte) 19, "boolean");
    final Token TRUE = new Token((byte) 36, "true"); // valores constantes
    final Token FALSE = new Token((byte) 36, "false"); // valores constantes
    final Token MAIN = new Token((byte) 22, "main");
    final Token WHILE = new Token((byte) 23, "while");
    final Token IF = new Token((byte) 24, "if");
    final Token THEN = new Token((byte) 25, "then");
    final Token ELSE = new Token((byte) 26, "else");
    final Token BEGIN = new Token((byte) 27, "begin");
    final Token END = new Token((byte) 28, "end");
    final Token AND = new Token((byte) 29, "and");
    final Token OR = new Token((byte) 30, "or");
    final Token NOT = new Token((byte) 31, "not");
    final Token READLN = new Token((byte) 32, "readln");
    final Token WRITE = new Token((byte) 33, "write");
    final Token WRITELN = new Token((byte) 34, "writeln");
    final byte ID = 35;

    public Tabela_Simbolos(){
        // Somente adicionar tokens reservados da linguagem L
        tabela_simbolos.put(MAIS, "+");
        tabela_simbolos.put(MENOS, "-");
        tabela_simbolos.put(ASTERISCO, "*");
        tabela_simbolos.put(PAR_ESQUERDO, "(");
        tabela_simbolos.put(PAR_DIREITO, ")");
        tabela_simbolos.put(VIRGULA, ",");
        tabela_simbolos.put(PONTO_VIRGULA, ";");
        tabela_simbolos.put(DIFERENTE, "!=");
        tabela_simbolos.put(ATRIBUICAO, "=");
        tabela_simbolos.put(IGUAL, "==");
        tabela_simbolos.put(MENOR, "<");
        tabela_simbolos.put(MENOR_IGUAL, "<=");
        tabela_simbolos.put(MAIOR, ">");
        tabela_simbolos.put(MAIOR_IGUAL, ">=");
        tabela_simbolos.put(BARRA, "/");
        tabela_simbolos.put(CONST, "const");
        tabela_simbolos.put(INTEGER, "integer");
        tabela_simbolos.put(BYTE, "byte");
        tabela_simbolos.put(STRING, "string");
        tabela_simbolos.put(BOOLEAN, "boolean");
        tabela_simbolos.put(TRUE, "true");
        tabela_simbolos.put(FALSE, "false");
        tabela_simbolos.put(MAIN, "main");
        tabela_simbolos.put(WHILE, "while");
        tabela_simbolos.put(IF, "if");
        tabela_simbolos.put(THEN, "then");
        tabela_simbolos.put(ELSE, "else");
        tabela_simbolos.put(BEGIN, "begin");
        tabela_simbolos.put(END, "end");
        tabela_simbolos.put(AND, "and");
        tabela_simbolos.put(OR, "or");
        tabela_simbolos.put(NOT, "not");
        tabela_simbolos.put(READLN, "readln");
        tabela_simbolos.put(WRITE, "write");
        tabela_simbolos.put(WRITELN, "writeln");
    }

    /**
     * Verifica se o token inserido existe na tabela, caso nao exista insere o mesmo e retorna seu endereco
     * @return pesquisar(lexema)
     */
    public Object inserir(String lexema) {
        if (!tabela_simbolos.containsValue(lexema)) {
            Token identificador = new Token(ID, lexema);
            tabela_simbolos.put(identificador, lexema);
        }
        return pesquisar(lexema);
    }

    /**
     * Pesquisa um token na tabela de simbolos e retorna seu endereco
     * @return endereco 
     */
    public Object pesquisar(String lexema) {
        Object endereco = null;
        for (Map.Entry<Token,String> entry: tabela_simbolos.entrySet()) {
            if(lexema.equals(entry.getValue().toString())) {
                endereco = entry.getKey();
                break;
            }
        }
        return endereco;
    }

    /**
     * Mostra resultados inseridos da tabela em tela
     */
    public void print_tabela_simbolos() {
        Object token;
        String lexema;
        System.out.println("Resultado da tabela de simbolos:");
        System.out.println("---------------");
        System.out.println(" token → lexema ");
        for (Map.Entry<Token,String> entry: tabela_simbolos.entrySet()) {
            lexema = entry.getValue().toString();
            token = entry.getKey();
            System.out.println(" " + ((Token) token).get_id() + " → " + lexema);
        }
        System.out.println("---------------");
    }

}

/** class Registro_lexico
 *  tipo: Registro_lexico → Armazena informacoes a mais sobre tokens, como seu tipo e seu endereco de insersao na tabela de simbolos
 */
class Registro_Lexico {
    
    private Token num_token;
    private String lexema;
    private Object endereco;
    private byte tipo;

    public Registro_Lexico(Token num_token, String lexema, Object endereco, byte tipo){
        this.num_token = num_token;
        this.lexema = lexema;
        this.endereco = endereco;
        this.tipo = tipo;
    }

}

/** class Lexico
 *  tipo: Lexico → Realiza o parsing do programa-fonte de linguagem L retornando o proximo token lido.
 *        Lexico também armazena todos os tokens no registro_lexico e IDs na tabela_simbolos.
 */
class Lexico {

    public static int EOF = 0;
    private static byte NAN = 0, INT = 1, BYT = 2, STR = 3, BLN = 4;
    private static ArrayList<Character> programa_fonte = new ArrayList<Character>();
    // Estados do AFD
    private static final int S0 = 0, S1 = 1, S2 = 2, S3 = 3, S4 = 4, S5 = 5,
        S6 = 6, S7 = 7, S8 = 8, S9 = 9, S10 = 10, S11 = 11, S12 = 12, S13 = 13,
        S14 = 14, S15 = 15, SF = 16;
    private static Tabela_Simbolos tabela_simbolos;
    private static LinkedHashMap< Integer, Registro_Lexico> registro_lexico = new LinkedHashMap<Integer, Registro_Lexico>();
    private static final byte VALOR = 36;
    private static int estado_atual = 0;
    public static int posicao = 0;
    public static int linha = 1;
    private static char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    private static char[] digitos = "0123456789".toCharArray();
    private static char[] hexadecimais = "0123456789aAbBcCdDeEfF".toCharArray();
    private static char[] caracteres_permitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz 0123456789_.,&:(){}[]+-\"\'/*!?><=\n\r\t;".toCharArray();

    public Lexico(String nome_programa_fonte){
        tabela_simbolos = new Tabela_Simbolos();
        try {
            File fl = new File(nome_programa_fonte);
		    FileReader fr = new FileReader(fl);
            BufferedReader br = new BufferedReader(fr);
            int char_atual = br.read();
            char caractere = '\0';
            while (char_atual != -1) {
                caractere = (char) char_atual;
                programa_fonte.add(caractere);
                char_atual = br.read();
            }
            programa_fonte.add(' ');
            br.close();
            EOF = programa_fonte.size();
        } catch (IOException e) {
            Error.ARQ_INEXISTENTE.executar(-1);
        }
        
    }

    /**
     * "Devolve" o caractere corrente, voltando uma posicao no arquivo fonte
     */
    private static void devolve_caractere(char caractere){
        if(caractere != '\n' && caractere != '\t' && caractere != '\r' && caractere != ' ') {
            posicao--; 
        }
    }

    /**
     * Realiza busca de um token (ids e palavras reservadas) na tabela de simbolos
     *  - Faz insercao caso ele nao esteja presente
     *  - Adiciona todos os tokens no registro lexico
     * @return endereco
     */
    private static Token busca_tabela(String lexema){
        Object endereco = tabela_simbolos.pesquisar(lexema);
        Token token;
        if(endereco == null){
            endereco = tabela_simbolos.inserir(lexema);
        }
        token = (Token) endereco;
        // true e false sao as unicas palavras reservadas que possuem tipo
        if (token.get_lexema() == "true"){
            adicionar_registro(lexema,VALOR,BLN);
        } else if (token.get_lexema() == "false"){
            adicionar_registro(lexema,VALOR,BLN);
        } else {
            registro_lexico.put(linha, new Registro_Lexico(token, lexema, endereco, NAN)); 
        }
        return token;
    }

    /**
     * Utlizado para adicionar registros de constantes no registro lexico
     * @return token
     */
    private static Token adicionar_registro(String lexema, byte id, byte tipo){
        Token token = new Token(id, lexema);
        registro_lexico.put(linha, new Registro_Lexico(token, lexema, null, tipo));
        return token;
    }

    /** 
     * verificar se o cartere esta presente no array 
     * @return pertence
     */
    private static boolean pertence(char caractere, char[] array){
		boolean pertence = false;
		for (char c : array) {
			if( c == caractere) {
				pertence = true;
			}
		}
		return pertence;
    }

    /**
     * Verifica erros do AFD & encerra o processo de compilacao
     */
    private static void verificar_erros(String lexema){
        if (posicao == EOF){
            Error.FIM_ARQUIVO.executar(linha);
        } else {
            lexema = lexema.replaceAll("\r", "");
            lexema = lexema.replaceAll("\n", "");
            Error.LEX_NIDENTIFICADO.executar(linha, lexema);
        }
    }

    /**
     * @return token
     */
    public Token analisador(){
        Token token = new Token();
        char caractere = '\0';
        String lexema = "";
        while(estado_atual != SF){

            if(posicao != EOF){
                caractere = programa_fonte.get(posicao);
                posicao++;
                if (caractere == '\n'){
                    linha++;
                } else if (!pertence(caractere, caracteres_permitidos)){
                    Error.CHR_INVALIDO.executar(linha);
                }
            } else {
                // Error.FIM_ARQUIVO.executar(linha);
            }
            // TODO: remover
            // System.out.println(" EST =" + estado_atual + " POS =" + posicao + "/" + EOF + " CHR = " + caractere);
            switch (estado_atual) {

                case S0:
                    lexema = "";
                    if (caractere == ' ' || caractere == '\n' || caractere == '\r' || caractere == '\t'){
                        if( posicao < EOF) {
                            estado_atual = S0;
                        } else {
                            estado_atual = SF;//caso o programa tenha espaco, \n ou \r depois do end(evita loop infinito)
                        }
                    } else if (caractere == '+' || caractere == '-' || caractere == '*' || caractere == '(' 
                    || caractere == ')' || caractere == ',' || caractere == ';'){
                        lexema += caractere;
                        estado_atual = SF;
                        token = busca_tabela(lexema);
                    } else if (caractere == '!'){
                        lexema += caractere;
                        estado_atual = S1;
                    } else if (caractere == '='){
                        lexema += caractere;
                        estado_atual = S2;        
                    } else if (caractere == '<'){
                        lexema += caractere;
                        estado_atual = S3;
                    } else if (caractere == '>'){
                        lexema += caractere;
                        estado_atual = S4;
                    } else if (caractere == '\''){
                        lexema += caractere;
                        estado_atual = S5;
                    } else if (caractere == '0'){
                        lexema += caractere;
                        estado_atual = S7;
                    } else if (pertence(caractere, digitos)){
                        lexema += caractere;
                        estado_atual = S10;
                    } else if (pertence(caractere, letras)){
                        lexema += caractere;
                        estado_atual = S11;
                    } else if (caractere == '_'){
                        lexema += caractere;
                        estado_atual = S12;
                    } else if (caractere == '/'){
                        lexema += caractere;
                        estado_atual = S13;
                    } else {
                        if( posicao >= EOF) {
                            estado_atual = SF;
                        } else {
                            lexema += caractere;
                            verificar_erros(lexema);
                        }
                    }
                break;

                case S1:
                    if (caractere == '='){
                        lexema += caractere;
                        estado_atual = SF;
                        token = busca_tabela(lexema);
                    } else {
                       verificar_erros(lexema);
                    }
                break;

                case S2:
                    if (caractere == '='){
                        lexema += caractere;
                        estado_atual = SF;
                        token = busca_tabela(lexema);
                    } else {
                        estado_atual = SF;
                        token = busca_tabela(lexema);
                        devolve_caractere(caractere);
                    }
                break;

                case S3:
                    if (caractere == '='){
                        lexema += caractere;
                        estado_atual = SF;
                        token = busca_tabela(lexema);
                    } else {
                        estado_atual = SF;
                        token = busca_tabela(lexema);
                        devolve_caractere(caractere);
                    }
                break;

                case S4:
                    if (caractere == '='){
                        lexema += caractere;
                        estado_atual = SF;
                        token = busca_tabela(lexema);
                    } else {
                        estado_atual = SF;
                        token = busca_tabela(lexema);
                        devolve_caractere(caractere);
                    }
                break;

                case S5:
                    if (caractere != '\'' && caractere != '\n'){
                        lexema += caractere;
                        estado_atual = S5;
                    } else if (caractere == '\''){
                        lexema += caractere;
                        estado_atual = S6;
                    } else {
                        lexema+=caractere;
                        verificar_erros(lexema);
                    }
                break;

                case S6:
                    if (caractere == '\''){
                        estado_atual = S5;
                    } else {
                        estado_atual = SF;
                        // Valores constantes estao somente no registro_lexico
                        token = adicionar_registro(lexema, VALOR, STR); 
                        devolve_caractere(caractere);
                    }
                break;
                
                case S7:
                    if (caractere == 'h'){
                        lexema += caractere;
                        estado_atual = S8;
                    } else if (pertence(caractere, digitos)){
                        lexema += caractere;
                        estado_atual = S10;
                    // Li apenas valor 0
                    } else {
                        estado_atual = SF;
                        // Valores constantes estao somente no registro_lexico
                        token = adicionar_registro(lexema, VALOR, INT);
                        devolve_caractere(caractere);
                    }
                break;

                case S8:
                    if (pertence(caractere, hexadecimais)){
                        lexema += caractere;
                        estado_atual = S9;
                    } else {
                        verificar_erros(lexema);
                    }
                break;

                case S9:
                    if (pertence(caractere, hexadecimais)){
                        lexema += caractere;
                        token = adicionar_registro(lexema, VALOR, BYT); 
                        estado_atual = SF;
                    } else {
                        verificar_erros(lexema);
                    }
                break;

                case S10:
                    if (pertence(caractere, digitos)){
                        lexema += caractere;
                        estado_atual = S10;
                    } else {
                        token = adicionar_registro(lexema, VALOR, INT); 
                        estado_atual = SF;
                        devolve_caractere(caractere);
                    }
                break;
                
                case S11:
                    if (pertence(caractere, letras) || pertence(caractere, digitos) || caractere == '_'){
                        lexema += caractere;
                        estado_atual = S11;
                    } else {
                        token = busca_tabela(lexema);
                        estado_atual = SF;
                        devolve_caractere(caractere);
                        
                    }
                break;

                case S12:
                    if (caractere == '_'){
                        lexema += caractere;
                        estado_atual = S12;
                    } else if (pertence(caractere, letras) || pertence(caractere, digitos)){
                        lexema += caractere;
                        estado_atual = S11;
                    } else {
                        // Nao posso ter id somente com _
                        verificar_erros(lexema);
                    }
                break;  

                case S13:
                    if (caractere != '*'){
                        estado_atual = SF;
                        token = busca_tabela(lexema);
                        devolve_caractere(caractere);
                    } else {
                        estado_atual = S14;
                    }
                break;

                case S14:
                    if (caractere != '*'){
                        estado_atual = S14;
                    } else {
                        estado_atual = S15;
                    }
                break;

                case S15:
                    if (caractere == '/'){
                        estado_atual = S0;
                    } else if (caractere == '*'){
                        estado_atual = S15;
                    } else  {
                        estado_atual = S14;
                    }
                break;
            }
        }
        estado_atual = S0;
        return token;
    }
}

/** class Sintatico 
 *  tipo: Sintatico → Realiza uma analise de sintaxe do programa-fonte
 */
class Sintatico {

    private static Token token_atual;
    // SIMBOLOS E PALAVRAS RESERVADAS 
    final static Token MAIS = new Token((byte) 0, "+");
    final static Token MENOS = new Token((byte) 1, "-");
    final static Token ASTERISCO = new Token((byte) 2, "*");
    final static Token PAR_ESQUERDO = new Token((byte) 3, "(");
    final static Token PAR_DIREITO = new Token((byte) 4, ")");
    final static Token VIRGULA = new Token((byte) 5, ",");
    final static Token PONTO_VIRGULA = new Token((byte) 6, ";");
    final static Token DIFERENTE = new Token((byte) 7, "!=");
    final static Token ATRIBUICAO = new Token((byte) 8, "=");
    final static Token IGUAL = new Token((byte) 9, "==");
    final static Token MENOR = new Token((byte) 10, "<");
    final static Token MENOR_IGUAL = new Token((byte) 11, "<=");
    final static Token MAIOR = new Token((byte) 12, ">");
    final static Token MAIOR_IGUAL = new Token((byte) 13, ">=");
    final static Token BARRA = new Token((byte) 14, "/");
    final static Token CONST = new Token((byte) 15, "const");
    final static Token INTEGER = new Token((byte) 16, "integer");
    final static Token BYTE = new Token((byte) 17, "byte");
    final static Token STRING = new Token((byte) 18, "string");
    final static Token BOOLEAN = new Token((byte) 19, "boolean");
    final static Token TRUE = new Token((byte) 20, "true");
    final static Token FALSE = new Token((byte) 21, "false");
    final static Token MAIN = new Token((byte) 22, "main");
    final static Token WHILE = new Token((byte) 23, "while");
    final static Token IF = new Token((byte) 24, "if");
    final static Token THEN = new Token((byte) 25, "then");
    final static Token ELSE = new Token((byte) 26, "else");
    final static Token BEGIN = new Token((byte) 27, "begin");
    final static Token END = new Token((byte) 28, "end");
    final static Token AND = new Token((byte) 29, "and");
    final static Token OR = new Token((byte) 30, "or");
    final static Token NOT = new Token((byte) 31, "not");
    final static Token READLN = new Token((byte) 32, "readln");
    final static Token WRITE = new Token((byte) 33, "write");
    final static Token WRITELN = new Token((byte) 34, "writeln");
    // 
    final static Token ID = new Token((byte) 35, "");
    final static Token VALOR = new Token((byte) 36, "");
    //
    static Lexico lexico;

    public Sintatico(String nome_programa_fonte){
        lexico = new Lexico(nome_programa_fonte);
    }

    /**
     * verifica se token atual == token esperado
     */
    private static void casa_token(Token token_esperado){
        // TODO: REMOVER
        //System.out.println("TOKEN ATUAL = "+ token_atual.get_lexema() + "|" + token_atual.get_id() + " TOKEN ESPERADO: " + token_esperado.get_lexema() + "|" + token_esperado.get_id() );
        if (token_atual.get_id() == token_esperado.get_id()){
            token_atual = lexico.analisador();
        } else {
            if(lexico.posicao != lexico.EOF){
                Error.TKN_INESPERADO.executar(lexico.linha, token_atual.get_lexema());
            }else{
                Error.FIM_ARQUIVO.executar(lexico.linha);
            }
        }
    }
    
    /**
     * inicia o sintatico
     */
    public void analisador(){
        token_atual = lexico.analisador();
        /* GRAMATICA
         S → { D } "main" { C } "end"
         // DECLARACOES
         D →  ( "integer" | "boolean" | "byte" | "string" ) "id" [ "=" [ "-" ] "valor" ] { "," "id" [ "=" [ "-" ] "valor" ] } ";" | "const" "id" "=" [ "-" ] "valor" ";"
         // COMANDOS
         // C → "id" "=" EXP ";"| A | B | "readln" "(" "id" ")" ";" | "write" "(" EXP { "," EXP } ")" ";" | "writeln" "(" EXP { "," EXP } ")" ";" | ";"
         A → "while" "(" EXP ")" ( C | "begin" { C } "end")
         B → "if" "(" EXP ")" "then" ( C | "begin" { C } "end") [ "else" ( C | "begin" { C } "end")]
         // EXPRESSÕES LOGICAS
         EXP → E [ ( "<" | ">" | "==" | "!=" | "<=" | ">=" ) E ] 
         E → [ "+" | "-" ] T { ( "+" | "-" | "or") T } 
         T → F { ( "*" | "/" | "and") F } 
         F → "not" F | "(" EXP ")" | "id" | "valor"
         */
        procedimento_S();
        //System.out.println("Compilou :D ");
    }

    // S → { D } "main" { C } "end"
    private static void procedimento_S(){
        // Diferente de first de D
        while (token_atual.get_lexema() != "main"){
            procedimento_D();
        }
        casa_token(MAIN);
        while (token_atual.get_lexema() != "end"){
            procedimento_C();
        }
        casa_token(END);
    }

    // D →  ( "integer" | "boolean" | "byte" | "string" ) "id" [ "=" [ "-" ] "valor" ] { "," "id" [ "=" [ "-" ] "valor" ] } ";" | "const" "id" "=" [ "-" ] "valor" ";"
    public static void procedimento_D(){
        if (token_atual.get_lexema() != "const"){
             // Obrigatorios com switch
            switch (token_atual.get_lexema()) {

                case "integer":
                    casa_token(INTEGER);
                break;

                case "boolean":
                    casa_token(BOOLEAN);
                break;

                case "byte":
                    casa_token(BYTE);
                break;

                case "string":
                    casa_token(STRING);
                break;

                default:
                    if (lexico.posicao != lexico.EOF){
                        Error.TKN_INESPERADO.executar(lexico.linha, token_atual.get_lexema());
                    } else {
                        Error.FIM_ARQUIVO.executar(lexico.linha);
                    }
                break;
            }
            casa_token(ID);
            if (token_atual.get_lexema() == "="){
                casa_token(ATRIBUICAO);
                if (token_atual.get_lexema() == "-"){
                    casa_token(MENOS);
                }
                casa_token(VALOR); 
            }
            while (token_atual.get_lexema() == ","){
                casa_token(VIRGULA);
                casa_token(ID);
                if (token_atual.get_lexema() == "="){
                    casa_token(ATRIBUICAO);
                    if (token_atual.get_lexema() == "-"){
                        casa_token(MENOS);
                    }
                    casa_token(VALOR); 
                }
            }
            casa_token(PONTO_VIRGULA);
        } else {
            casa_token(CONST);
            casa_token(ID);
            casa_token(ATRIBUICAO);
            if (token_atual.get_lexema() == "-"){
                casa_token(MENOS);
            }
            casa_token(VALOR); 
            casa_token(PONTO_VIRGULA);
        }
    }

    // C → "id" "=" EXP ";"| A | B | "readln" "(" "id" ")" ";" | "write" "(" EXP { "," EXP } ")" ";" | "writeln" "(" EXP { "," EXP } ")" ";" | ";"
    public static void procedimento_C(){
        if(token_atual.get_id() == ID.get_id()){
            casa_token(ID);
            casa_token(ATRIBUICAO);
            procedimento_EXP();
            casa_token(PONTO_VIRGULA);
        } else {
            switch(token_atual.get_lexema()){

                case "while":
                    procedimento_A();
                break;
    
                case "if":
                    procedimento_B();
                break;
    
                case "readln":
                    casa_token(READLN);
                    casa_token(PAR_ESQUERDO);
                    casa_token(ID);
                    casa_token(PAR_DIREITO);
                    casa_token(PONTO_VIRGULA);
                break;
    
                case "write":
                    casa_token(WRITE);
                    casa_token(PAR_ESQUERDO);
                    procedimento_EXP();
                    while (token_atual.get_lexema() != ")"){
                        casa_token(VIRGULA);
                        procedimento_EXP();
                    }
                    casa_token(PAR_DIREITO);
                    casa_token(PONTO_VIRGULA);
                break;
    
                case "writeln":
                    casa_token(WRITELN);
                    casa_token(PAR_ESQUERDO);
                    procedimento_EXP();
                    while (token_atual.get_lexema() != ")"){
                        casa_token(VIRGULA);
                        procedimento_EXP();
                    }
                    casa_token(PAR_DIREITO);
                    casa_token(PONTO_VIRGULA);
                break;
    
                case ";":
                    casa_token(PONTO_VIRGULA);
                break;
    
                default:
                    if (lexico.posicao != lexico.EOF){
                        Error.TKN_INESPERADO.executar(lexico.linha, token_atual.get_lexema());
                    } else {
                        Error.FIM_ARQUIVO.executar(lexico.linha);
                    }
                break;
            }
        }
    }

    //  A → "while" "(" EXP ")" ( C | "begin" { C } "end")
    public static void procedimento_A(){
        casa_token(WHILE);
        casa_token(PAR_ESQUERDO);
        procedimento_EXP();
        casa_token(PAR_DIREITO);
        if (token_atual.get_lexema() != "begin"){
            procedimento_C();
        } else {
            casa_token(BEGIN);
            while(token_atual.get_lexema() != "end"){
                procedimento_C();
            }
            casa_token(END);
        }
    }

    // B → "if" "(" EXP ")" "then" ( C | "begin" { C } "end") [ "else" ( C | "begin" { C } "end")]
    public static void procedimento_B(){
        casa_token(IF);
        casa_token(PAR_ESQUERDO);
        procedimento_EXP();
        casa_token(PAR_DIREITO);
        casa_token(THEN);
        if (token_atual.get_lexema() != "begin"){
            procedimento_C();
        } else {
            casa_token(BEGIN);
            while (token_atual.get_lexema() != "end"){
                procedimento_C();
            }
            casa_token(END);
        }
        // 
        if (token_atual.get_lexema() == "else"){
            casa_token(ELSE);
            if (token_atual.get_lexema() != "begin"){
                procedimento_C();
            } else {
                casa_token(BEGIN);
                while (token_atual.get_lexema() != "end"){
                    procedimento_C();
                }
                casa_token(END);
            }
        }
    }

    // EXPRESSOES LOGICAS
    // EXP → E [ ( "<" | ">" | "==" | "!=" | "<=" | ">=" ) E ] 
    public static void procedimento_EXP(){
        procedimento_E();
        if (token_atual.get_lexema() == "<" ||
        token_atual.get_lexema() == ">" ||
        token_atual.get_lexema() == "==" ||
        token_atual.get_lexema() == "!=" ||
        token_atual.get_lexema() == "<=" ||
        token_atual.get_lexema() == ">="){
            switch (token_atual.get_lexema()) {
                
                case "<":
                    casa_token(MENOR);    
                break;
            
                case ">":
                    casa_token(MAIOR);    
                break;

                case "==":
                    casa_token(IGUAL);    
                break;

                case "!=":
                    casa_token(DIFERENTE);    
                break;

                case "<=":
                    casa_token(MENOR_IGUAL);    
                break;

                case ">=":
                    casa_token(MAIOR_IGUAL);    
                break;
            }
            procedimento_E();
        }
    }

    // E → [ "+" | "-" ] T { ( "+" | "-" | "or") T } 
    public static void procedimento_E(){
        if(token_atual.get_lexema() == "+"){
            casa_token(MAIS);
        } else if(token_atual.get_lexema() == "-"){
            casa_token(MENOS);
        }
        procedimento_T();
        while(token_atual.get_lexema() == "+" || 
        token_atual.get_lexema() == "-" ||
        token_atual.get_lexema() == "or"){
            
            switch (token_atual.get_lexema()) {
                
                case "+":
                    casa_token(MAIS);
                break;

                case "-":
                    casa_token(MENOS);
                break;

                case "or":
                    casa_token(OR);
                break;
            
            }

            procedimento_T();
        }
    }

    // T → F { ( "*" | "/" | "and") F } 
    public static void procedimento_T(){
        procedimento_F();
        while(token_atual.get_lexema() == "*" || 
        token_atual.get_lexema() == "/" ||
        token_atual.get_lexema() == "and"){

            switch (token_atual.get_lexema()) {
                
                case "*":
                    casa_token(ASTERISCO);
                break;

                case "/":
                    casa_token(BARRA);
                break;

                case "and":
                    casa_token(AND);
                break;
            
            }

            procedimento_F();
        }
    }

    // F → "not" F | "(" EXP ")" | "id" | "valor"
    public static void procedimento_F(){
        if (token_atual.get_lexema() == "not"){
            casa_token(NOT);
            procedimento_F();
        } else if (token_atual.get_lexema() == "("){
            casa_token(PAR_ESQUERDO);
            procedimento_EXP();
            casa_token(PAR_DIREITO);
        } else if (token_atual.get_id() == ID.get_id()){
            casa_token(ID);
        } else {
            casa_token(VALOR); 
        }
    }
}

/**
 * 
 */
public class LC {

    public static void main(String[] args) {

        String nome_programa_fonte = (args.length != 0) ? args[0] : "teste.l";

        /* TESTE DE TABELA DE SIMBOLOS */

        // Tabela_Simbolos tl = new Tabela_Simbolos();
        // tl.inserir("Luana");
        // Object endereco1 = tl.pesquisar("Luana");
        // Token teste1 = (Token) endereco1;
        // System.out.println("Endereco do Token de lexema " + teste1.get_lexema() + " → " + endereco1);
        // tl.inserir("Lucas");
        // Object endereco = tl.pesquisar("Lucas");
        // Token teste = (Token) endereco;
        // System.out.println("Endereco do Token de lexema " + teste.get_lexema() + " → " + endereco);
        // tl.print_tabela_simbolos();
        // teste.lexema = "luana2";
        // System.out.println("Endereco do Token de lexema " + teste.get_lexema() + " → " + endereco);


        /* TESTE ANALISADOR LEXICO */

        // Lexico lexico = new Lexico(nome_programa_fonte);
        // Token teste = new Token();
        // int pos = 0;
        // int fimarq = 500;
        // while(pos != fimarq){
        //     teste = lexico.analisador();
        //      System.out.println("TOKEN = " + teste.id + " LEXEMA → " + teste.lexema);
        //     pos++;
        // }

        /* TESTE ANALISADOR SINTATICO */

        Sintatico sintatico = new Sintatico(nome_programa_fonte);
        sintatico.analisador();

        // System.out.println("FIM!");
    }
}

