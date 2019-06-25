package agendaPrincipal;

/**
 * Implementações da classe Agenda e ItemAgenda.
 * <p>
 * Um menu com diversas opções para o uso da classe Agenda. Dentre
 * eles, estão inserir itens, exibir diversos relatórios, armazenar 
 * em disco e recuperar o arquivo
 * @author Rafael Emery
 * @version 1.0
 */

import java.util.*;

public class Uso {
	
	public static Scanner ler;
	public static void main(String[] args) {
		try {	
			ler = new Scanner(System.in);
			int i, escolhaAgenda = 0, escolhaRelatorio = 0, escolhaGeral = 0;
			String titulo, descricao, dtInicio, dtFim, hrInicio, hrFim;
			Agenda agenda = new Agenda();
			do {	
				System.out.println("\n\n||=======||* AGENDA *||=======||");
				System.out.println("1) Inserir\n2) Relatórios\n3) Grava em um arquivo\n4) Ler o arquivo\n5) Sair\nO que deseja fazer?");
				escolhaGeral = ler.nextInt();
				
				if (escolhaGeral == 1) {			
					System.out.println("\n\n----- Inserir item na agenda -----");
					System.out.println("1) Meta\n2) Lembrete\n3) Evento\nO que deseja fazer?");
					escolhaAgenda = ler.nextInt();
					
					ler = new Scanner(System.in);
					System.out.print("Titulo: ");
					titulo = ler.nextLine();
					ler = new Scanner(System.in);
					System.out.print("Descricao: ");
					descricao = ler.nextLine();
					ler = new Scanner(System.in);
					System.out.print("Data de inicio: ");
					dtInicio = ler.nextLine();
					ler = new Scanner(System.in);
					System.out.print("Data final: ");
					dtFim = ler.nextLine();
					ler = new Scanner(System.in);
					System.out.print("Horario de inicio: ");
					hrInicio = ler.nextLine();
					ler = new Scanner(System.in);
					System.out.print("Horario final: ");
					hrFim = ler.nextLine();
					
					switch (escolhaAgenda) {						
						case 1: 
							//Inserindo uma meta
							System.out.print("Prioridade da meta: ");
							int prioridade = ler.nextInt();
							Meta meta = new Meta(titulo, descricao, new Periodo(new Data(dtInicio), new Data(dtFim), new Horario(hrInicio), new Horario(hrFim)), prioridade);
							agenda.insere(meta);
							break;
						case 2:
							//Inserindo um lembrete
							System.out.print("Quantidade de minutos de antecedencia: ");
							int qtdeMinutos = ler.nextInt();
							Lembrete lembrete = new Lembrete(titulo, descricao, new Periodo(new Data(dtInicio), new Data(dtFim), new Horario(hrInicio), new Horario(hrFim)), qtdeMinutos);
							agenda.insere(lembrete);	
							break;
						case 3:
							//Inserindo um evento
							System.out.print("Local do evento: ");
							String local = ler.nextLine();
							Evento evento = new Evento(titulo, descricao, new Periodo(new Data(dtInicio), new Data(dtFim), new Horario(hrInicio), new Horario(hrFim)), local);
							agenda.insere(evento);
							break;
					}
				}
				else if (escolhaGeral == 2) {
					System.out.println("\n\n----- Relatorios -----");
					System.out.println("1) Vizualizar itens\n2) Exibir itens em um itervalo de datas\n3) Ordenar as metas em ordem de prioridade"
							+ "\n4) Ordenar lembretes por ordem de minutos de antecedencia\n5) Ordenar lembretes em ordem de local\nO que deseja fazer?");
					escolhaRelatorio = ler.nextInt();
					
					switch (escolhaRelatorio) {
						case 1:
							System.out.println(agenda.toString());
							break;
						case 2:
							//Exibe todos os itens agendados e a quantidade de itens em um intervalo de datas
							System.out.println("\nIntervalo de datas");
							System.out.print("Data de inicio: ");
							ler = new Scanner(System.in);
							String dt1 = ler.nextLine();				
							System.out.print("Data de termino: ");
							ler = new Scanner(System.in);
							String dt2 = ler.nextLine();
							agenda.itensIntervalo(new Data(dt1), new Data(dt2));
							break;
						case 3:
							//Ordenar em prioridade
							agenda.ordenaPorPrioridade();
							//Exibe as metas de acordo com a prioridade
							break;
						case 4:
							//Ordenar em minutos de antecedencia
							agenda.ordenaPorQtdeMinutos();
							break;
						case 5:
							//Ordenar em ordem alfabetica local
							agenda.ordenaPorLocal();
							break;
					}
				}
				else if (escolhaGeral == 3) {
					//Gravando a agenda em um arquivo
					ler = new Scanner(System.in);
					System.out.print("\nEntre com o nome do arquivo (gravar): ");
					String nomeArquivo = ler.nextLine();
					Agenda.gravaAgenda(nomeArquivo, agenda);
				}
				else if (escolhaGeral == 4) {
					ler = new Scanner(System.in);
					System.out.print("\nEntre com o nome do arquivo (ler): ");
					String nomeArquivo = ler.nextLine();
					System.out.println(Agenda.leAgenda(nomeArquivo));
				}
				//Limpando a tela
				for (i = 0; i < 5; i++) {
					System.out.println("");
				}
			} while (escolhaGeral != 5);
		}
		catch (Exception e) {
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}
		System.out.println("\n\nFim do programa");
	}
}



