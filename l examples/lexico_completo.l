/* ARQUIVO DE TESTE LEXEMAS ACEITOS PELA LINGUAGEM L */

+ /* MAIS */
* /* ASTERISCO */
( /* BAR_ESQUERDA */
) /* BAR_DIREITA */
, /* VIRGULA */
; /* PONTO_VIRGULA */
!= /* DIFERENTE */
/ /* BARRA */
= /* ATRIBUICAO */
== /* IGUAL */
< /* MENOR */
> /* MAIOR */
<= /* MENOR_IGUAL */
>= /* MAIOR IGUAL */
'lucas e'' luana' /* testei com quebra de linha */
'''' /* string com apostofro */
'' /* string vazia */
0h00 /* valor hexadecimal sem letras */
0hFF /* valor hexadecimal com letras */
123456789 /* valor decimal positiva */
-12345678 /* valor decimal negativa */
- /* MENOS */
identificador /* ID somente letras */
identificador_sublinhado /* ID letras e sublinhado */
identificador1 /* ID letras e digito */
identificador01 /* ID letras e digitos */
identificador_01 /* ID letras digitos e sublinhado */
identificador__02 /* ID letras digitos e sublinhados */
_identificador /* ID sublinhado e letras */
__identificador /* ID sublinhados e letras */
_id_01_abc_ /* ID com todas opcoes */

'inicio palavras reservadas da linguagem L'
const
integer
byte
string
boolean
true
false
main
while
if
then
else
begin
end
and
or
not
readln
write
writeln

'fim palavras reservadas da linguagem L'

/* COMENTARIO DE FIM DE ARQUIVO DE TESTE CONTENDO TODOS POSSIVEIS TOKENS */
end