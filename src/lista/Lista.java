package lista;

public class Lista {

	private Nod cabeca_lista;

	public Lista() {
		cabeca_lista = null;

	}

	public void insere_inicio(int conteudo) {
		Nod novo_no = new Nod(conteudo);
		if (cabeca_lista == null) {
			novo_no.prox = cabeca_lista;
			cabeca_lista = novo_no;
		} else {
			novo_no.prox = cabeca_lista;
			cabeca_lista.ant = novo_no;
			cabeca_lista = novo_no;
		}
	}

	public void insere_final(int conteudo) {
		Nod novo_no = new Nod(conteudo);
		if (cabeca_lista == null) {
			novo_no.prox = cabeca_lista;
			cabeca_lista = novo_no;
		} else {
			Nod aux;
			aux = cabeca_lista;
			while (aux.prox != null) {
				aux = aux.prox;
			}
			aux.prox = novo_no;
			novo_no.ant = aux;
		}
	}

	public String listar() {
		Nod aux;
		String msg = " ";
		aux = cabeca_lista;
		while (aux != null) {
			msg = msg + " " + aux.info;
			aux = aux.prox;
		}
		return msg;

	}

	public Nod localizar(int conteudo) {
		Nod aux = cabeca_lista;
		while (aux != null && aux.info != conteudo) {
			aux = aux.prox;
		}
		return aux;
	}

	public void insere_ordenado(int conteudo) {
		Nod novo_no = new Nod(conteudo);
		Nod aux = cabeca_lista;

		if (aux == null) { // lista vazia
			cabeca_lista = novo_no;
		} else {
			while (aux.info < conteudo && aux.prox != null) {
				aux = aux.prox;
			}
			if (aux.info < conteudo) { // Esta no último Elemento
				aux.prox = novo_no;
				novo_no.ant = aux;
			}

			if (aux.info > conteudo) {
				if (aux.ant == null) {// deverá ser o primeiro elemento
					aux.ant = novo_no;
					novo_no.prox = aux;
					cabeca_lista = novo_no;
				} else { // insere no meio
					novo_no.prox = aux;
					novo_no.ant = aux.ant;
					aux.ant.prox = novo_no;
					aux.ant = novo_no;
				}
			}
		}

	}

	public void remover(int conteudo) {

		Nod aux = cabeca_lista;
		if (aux == null) { // lista vazia
			System.out.println("Lista vazia");
		} else {
			if (cabeca_lista.info == conteudo) {
				cabeca_lista = cabeca_lista.prox; // é o primeiro elemento
			} else {
				while (aux != null && aux.info != conteudo) {
					aux = aux.prox;
				}
				if (aux != null) {
					if (aux != null) {
						if (aux.prox == null) { // é o último elelmento
							aux.ant.prox = null;
							aux.ant = null;
						} else { // está no meio
							aux.prox.ant = aux.ant;
							aux.ant.prox = aux.prox;
						}
					}
				}
			}
		}
	}
}
