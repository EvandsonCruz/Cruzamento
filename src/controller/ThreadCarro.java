package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {
	private int idCarro;
	private String sentido;
	private Semaphore semaforo;

	public ThreadCarro(int idCarro, String sentido, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.sentido = sentido;
		this.semaforo = semaforo;
		start();
	}

	public void run() {
		carroAndando();
		try {
			semaforo.acquire();
			carroPassando();
			carroSaindo();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	public void carroAndando() {
		int rua = 200;
		int somaRua=0;
		int tempo = 1000;
		while(somaRua<rua) {
			somaRua += 11;
			System.out.println("Carro #" + idCarro + " já andou "+ somaRua + "m para "+sentido);
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void carroPassando() {
		System.out.println("Carro #" + idCarro + " passando o cruzamento no sentido para "+sentido);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void carroSaindo() {
		System.out.println("Carro #" + idCarro + " passou o cruzamento no sentido para "+sentido);
	}

}
