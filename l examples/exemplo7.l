/***** constante negativa*/

integer n;
string nome;
boolean naoTerminou;
const MAXITER=-100;

/* Programa Principal */
main
	write('Digite seu nome: ');
	readln(nome);
	naoTerminou=true;
	while (naoTerminou) begin
		writeln('Ola'' ',nome);
		n=n+1;
		naoTerminou=n<MAXITER;
	end
end
