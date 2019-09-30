# Alfabeto linguagem L.

Legenda .: L → Letras (a_z)(A_Z)

​					D → Dígitos (0_9)

​					H → Hexadecimais (0_9aAbBcCdDeEfF)

​					C → Caracteres Permitidos ( L + D + H +  0123456789_.,&:(){}[]+-\"\'/*!?><=\n\r ; )

| SIMBOLO            | LEXEMA    | PADRÃO DE FORMAÇÃO                                           |
| ------------------ | --------- | ------------------------------------------------------------ |
| ID                 | ""        | (L (L u _ u D)\*) u ( _ ( _ )\*(L u D)(L u _ u D)\*)         |
| VALOR (constantes) | ""        | ('0' 'h' H H) u ( (D(D)\*) u ('-'D(D)\*) ) u ( ' (C u ' ')* ' ) |
| MAIS               | "+"       | '+'                                                          |
| MENOS              | "-"       | '-'                                                          |
| ASTERISCO          | "*"       | '*'                                                          |
| PAR_ESQUERDO       | ''(''     | '('                                                          |
| PAR_DIREITO        | ")"       | ')'                                                          |
| VIRGULA            | ","       | ','                                                          |
| PONTO_VIRGULA      | ";"       | ';'                                                          |
| DIFERENTE          | "!="      | '!''='                                                       |
| ATRIBUICAO(IGUAL)  | "="       | '='                                                          |
| IGUAL              | "=="      | '=''='                                                       |
| MENOR              | "<"       | '<'                                                          |
| MENOR_IGUAL        | "<="      | '<''='                                                       |
| MAIOR              | ">"       | '>'                                                          |
| MAIOR_IGUAL        | ">="      | '>''='                                                       |
| BARRA              | "/"       | '/'                                                          |
| CONST              | "const"   | 'c''o''n''s''t'                                              |
| INTEGER            | "integer" | 'i''n''t''e''g''e''r'                                        |
| BYTE               | "byte"    | 'b''y''t''e'                                                 |
| STRING             | "string"  | 's''t''r''i''n''g'                                           |
| BOOLEAN            | "boolean" | 'b''o''o''l''e''a''n'                                        |
| TRUE               | "true"    | 't''r''u''e'                                                 |
| FALSE              | "false"   | 'f''a''l''s''e'                                              |
| MAIN               | "main"    | 'm''a''i''n'                                                 |
| WHILE              | "while"   | 'w''h''i''l''e'                                              |
| IF                 | "if"      | 'i''f'                                                       |
| THEN               | "then"    | 't''h''e''n'                                                 |
| ELSE               | "else"    | 'e''l''s''e'                                                 |
| BEGIN              | "begin"   | 'b''e''g''i''n'                                              |
| END                | "end"     | 'e''n''d'                                                    |
| AND                | "and"     | 'a''n''d'                                                    |
| OR                 | "or"      | 'o''r'                                                       |
| NOT                | "not"     | 'n''o''t'                                                    |
| READLN             | "readln"  | 'r''e''a''d''l''n'                                           |
| WRITE              | "write"   | 'w''r''i''t''e'                                              |
| WRITELN            | "writeln" | 'w''r''i''t''e''l''n'                                        |

# Gramática Linguagem L.

​         **S →** **{ D }** "main" **{ C }** "end"

​         **// DECLARACOES**

​         **D →**  **(** "integer" **|** "boolean" **|** "byte" **|** "string" **)** "id" **[** "=" "valor" **] {** "," "id" **[** "=" "valor" **] }** ";" 

​						**|** "const" "id" "=" "valor" ";"

​         **// COMANDOS**

​         **C →** **A** **| B |** "readln" "(" "id" ")" ";" **|** "write" "(" **EXP** [, **EXP** ] ")" ";" **|** "writeln" "(" **EXP** [, **EXP** ] ")" ";" 

​		   		  **| **"id" "=" **EXP** ";" **|** ";" 



​         **A →** "while" "(" **EXP** ")" **(** **C** **|** "begin" **{ C }+** "end" **)**

​         **B →** "if" "(" **EXP** ")" "then" **( C |** "begin" **{ C }+** "end" **) [** "else" **( C |** "begin" **{ C }+** "end" **) ]**

​         **// EXPRESSÕES LOGICAS**

​         **EXP → E** **[ (** "<" **|** ">" **|** "==" **|** "!=" **|** "<=" **|** ">=" ) **E** ] 

​         **E →** **[** "+" **|** "-" **]** **T** **{ (** "+" **|** "-" **|** "or" **)** **T** **}** 

​         **T → F** **{ (** "*" **|** "/" **|** "and" **)** **F** **}** 

​         **F →** "not" **F** **|** "(" **EXP** ")" **|** "id" **|** "valor"

​    

( ) → Obrigatório fazer.

[ ] → Eu faço ou não faço. 

{ } → Faço inúmeras vezes.
