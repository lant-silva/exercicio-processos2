package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	
	public String os() {
			String sys = System.getProperty("os.name");
			return sys;
	}
	
	public void listaProcessos() {
		String os = os();
		String Win = "TASKLIST /FO TABLE";
		String Unix = "ps -ef";
		if(os.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec(Win);
				InputStream dados = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(dados);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while(linha!=null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				
				buffer.close();
				leitor.close();
				
			}catch(Exception err) {
				System.err.println("Sistema incompativel");
			}
		}
		else {
			try {
				Process p = Runtime.getRuntime().exec(Unix);
				InputStream dados = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(dados);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while(linha!=null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				
				buffer.close();
				leitor.close();
				
			}catch(Exception err) {
				System.err.println("Sistema incompativel");
			}
		}
	}
	
	public void mataPid(String processo) {
		String os = os();
		String Win = "TASKKILL /PID";
		String Unix = "kill -9";
		StringBuffer buffer = new StringBuffer();
		int pid = 0;
		
		if(os.contains("Windows")) {
				pid = Integer.parseInt(processo);
				buffer.append(Win);
				buffer.append(" ");
				buffer.append(pid);
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (Exception e) {
				System.err.println("Processo invalido");
				return;
			}
			System.out.println("Processo eliminado!");
		}
		else {
				pid = Integer.parseInt(processo);
				buffer.append(Unix);
				buffer.append(" ");
				buffer.append(pid);
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				System.err.println("Processo invalido");
				return;
			}
		}
	}
	
	public void mataNome(String processo) {
		String os = os();
		String Win = "TASKKILL /PID";
		String Unix = "kill -9";
		StringBuffer buffer = new StringBuffer();
		
		if(os.contains("Windows")) {
				buffer.append(Win);
				buffer.append(" ");
				buffer.append(processo);
			try {
				Runtime.getRuntime().exec(buffer.toString());
			}catch(Exception err) {
				System.err.println("Processo invalido");
				return;
			}
			System.out.println("Processo eliminado!");
		}
		else {
				buffer.append(Unix);
				buffer.append(" ");
				buffer.append(processo);
			try {
				Runtime.getRuntime().exec(buffer.toString());
			}catch(Exception e) {
				System.err.println("Processo invalido");
				return;
			}
		}
	}
}
