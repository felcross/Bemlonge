package br.com.bemlonge.util;

import java.util.InputMismatchException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/**
 * Classe Java que verifica se o CPF é Válido
 */

public class ValidadorCpfUtils {
	
	static final Logger logger = LogManager.getLogger(ValidadorCpfUtils.class.getName());

	    public static Boolean isCPF(String CPF) {
	    	if (CPF.equals("00000000000") || CPF.equals("11111111111")
					|| CPF.equals("22222222222") || CPF.equals("33333333333")
					|| CPF.equals("44444444444") || CPF.equals("55555555555")
					|| CPF.equals("66666666666") || CPF.equals("77777777777")
					|| CPF.equals("88888888888") || CPF.equals("99999999999")
					|| (CPF.length() != 11)) {
				return false;
			}
			char dig10, dig11;
			int soma, i, resultado, num, peso;

			try {
				// Calculo do 1o. Digito Verificador
				soma = 0;
				peso = 10;
				for (i = 0; i < 9; i++) {
					/*converte o i-esimo caractere do CPF em um numero:
					 por exemplo, transforma o caractere '0' no inteiro 0
					(48 eh a posicao de '0' na tabela ASCII)*/ 
					num = (int) (CPF.charAt(i) - 48);
					// EX:sm = (i*11)+(i*10)+(i*9)+(i*8)+(i*7)+(i*6)+(i*5)+(i*4)+(i*3)+(i*2);
					soma = soma + (num * peso);
					peso = peso - 1;
				}
				resultado = 11 - (soma % 11);
				if ((resultado == 10) || (resultado == 11))
					dig10 = '0';
				else
					dig10 = (char) (resultado + 48); // converte no respectivo caractere numerico
				// Calcula do 2o. Digito Verificador
				soma = 0;
				peso = 11;
				for (i = 0; i < 10; i++) {
					num = (int) (CPF.charAt(i) - 48);
					soma = soma + (num * peso);
					peso = peso - 1;
				}
				resultado = 11 - (soma % 11);
				if ((resultado == 10) || (resultado == 11))
					dig11 = '0';
				else
					dig11 = (char) (resultado + 48);
				// Verifica se os digitos calculados conferem com os digitos informados.
				if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
					return (true);
				}else{
					return (false);
				}
			} catch (InputMismatchException erro) {
				return (false);
			}
		}
}
