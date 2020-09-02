/******
 Declaracoes 
 *******/

main
    /******
     Comandos (verificacao se esta tudo funcionando)
     *******/
    /* COMANDOS BASICOS */
    while (true) ; /* while e comando nulo */
    if (true) then ; /* while e comando nulo */
    while(true) while (true) while (true) ; /* sequencias de while */
    if (true) then if(false) then ; /* sequencias de if */
    if (true) then while(false) ; /* if while */
    while (true) if (false) then ; /* while if */
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