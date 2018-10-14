package lista;

public class Principal {
	
	
	public static void main (String [] args) {
		
		Lista n = new Lista();
		
		n.insere_ordenado(50);
		n.insere_ordenado(10);
		n.insere_ordenado(30);
		n.insere_ordenado(90);
		
		System.out.println(n.listar());
		
		
	}
	


}
