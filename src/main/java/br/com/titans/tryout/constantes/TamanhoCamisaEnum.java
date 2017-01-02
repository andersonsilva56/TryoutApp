package br.com.titans.tryout.constantes;

public enum TamanhoCamisaEnum {

	P,
	M,
	G,
	GG,
	EG;
	
	public static TamanhoCamisaEnum get(String find) {

		TamanhoCamisaEnum result = P;
		try{
			result  = valueOf(TamanhoCamisaEnum.class, find);
		}catch (IllegalArgumentException e) {
			
			System.out.println("Tamanho Nao Encontrado");
		}
		return result;
	}
}
