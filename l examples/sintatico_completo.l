/******
 Declaracoes (verificacao se esta tudo funcionando)
 *******/
integer a;
integer b, c, d;
integer aa = 1;
integer aaa = -1;
integer ab = 1, ac = 2, ad = 3;
/* boolean */
boolean e;
boolean f, g, h;
boolean ee = true;
boolean eee = false;
boolean eb = true, ec = false, ed = true;
/* byte */
byte i;
byte j, k, l;
byte ii = 33;
byte iii = 0hFF;
byte ib = 1, ic = 0hAA, id = 255;
/* string */
string m;
string n, o, p;
string mm = '33';
string mmm = '0hFF';
string mb = '''', mc = '', md = 'luana e''lucas';
/* const */
const a_01 = 0;
const a_02 = 0hFF;
const a_03 = -1;
const a_04 = true;
const a_05 = false;
const a_06 = 'true';
const a_07 = '';
const a_08 = 'luana e''lucas';
main
    /******
     Comandos (verificacao se esta tudo funcionando)
     *******/
    /* COMANDOS BASICOS */
    while (true) a = 5 + 3; /* while e comando nulo */
    if (true) then a = 5 + 3; /* while e comando nulo */
    while(true) while (true) while (true) a = 5 + 3; /* sequencias de while */
    if (true) then if(false) then a = 5 + 3; /* sequencias de if */
    if (true) then while(false) a = 5 + 3; /* if while */
    while (true) if (false) then a = 5 + 3; /* while if */
    ;
    readln (id_1) ;
    write (id_2) ;
    writeln (id_3) ;
    ;
    /* EXPRESSOES */
    writeln (id_4 < 10);
    writeln (id_5 > 10);
    writeln (id_6 == 10);
    writeln (id_7 != 10);
    writeln (id_8 >= 10);
    writeln (id_9 <= 10);
    writeln (id_10 + 10);
    writeln (-id_11 - 10);
    writeln (+id_12 or 10); /* PERGUNTAR SINAL + */
    writeln (id_13 * 10);
    writeln (-id_14 / 10);
    writeln (+id_15 and 10);
    writeln (not id_16);
    writeln (not 15);
    writeln (not ( id_17 < 6));
    writeln ((((('lucas')))));
    /* COMANDOS UM POUCO MAIS AVANCADOS */
    /* while if */
    while((id_18 > 15) and (id_19 < 16)) begin
        if (not id_20) then begin
            /* varios comandos */
            readln (id_1) ;
            write (id_2) ;
            writeln (id_3) ;
        end else begin
              /* varios comandos */
            readln (id_1) ;
            write (id_2) ;
            writeln (id_3) ;
        end
    end
    /* if while */
    if((id_18 > 15) and (id_19 < 16)) then begin
        while (not id_20) begin
            /* varios comandos */
            readln (id_1) ;
            write (id_2) ;
            writeln (id_3) ;
        end
    end else ;
end