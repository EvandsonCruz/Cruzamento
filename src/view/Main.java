package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Main {

	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		ThreadCarro threadCarro = new ThreadCarro(1, "baixo",semaforo);
		ThreadCarro threadCarro2 = new ThreadCarro(2, "esquerda",semaforo);
		ThreadCarro threadCarro3 = new ThreadCarro(3, "direita",semaforo);
		ThreadCarro threadCarro4 = new ThreadCarro(4, "cima",semaforo);

	}

}
