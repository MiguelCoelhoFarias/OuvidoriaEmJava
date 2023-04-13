package br.com.unifacisa.Ouvidoria;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.unifacisa.Ouvidoria.entities.Person;
import br.com.unifacisa.Ouvidoria.repositorys.OcorrencesRepositorys;
import br.com.unifacisa.Ouvidoria.repositorys.PersonRepositorys;
import br.com.unifacisa.Ouvidoria.services.OcorrenciasServices;
import br.com.unifacisa.Ouvidoria.services.PersonService;


@SpringBootApplication
public class OuvidoriaApplication implements CommandLineRunner {

	@Autowired
	PersonRepositorys personRepository;

	@Autowired
	PersonService personService;
	
	@Autowired
	OcorrencesRepositorys ocorrencesRepositorys;
	
	@Autowired
	OcorrenciasServices OcorrenciasServices;

	public static void main(String[] args) {
		SpringApplication.run(OuvidoriaApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		int option = 0;
		int optionRegistro = 0;
		boolean loginSucess = false;
		int optionLogAdmin =0;
		int optionLogAluno=0;
		
		Scanner sc = new Scanner(System.in);
		while (option != 3) {
			try {
				System.out.println("Bem vindo ao sistema de ouvidoria do setor financeiro da Unifacisa");
				System.out.println("o que deseja fazer primeiro?\n1-Registrar\n2-Logar\n3-Sair");
				option = sc.nextInt();
			} catch (InputMismatchException erro) {
				System.out.println("Opção invalida, tente novamente");
				sc.next();
			}

			if (option == 1) {
				System.out.println("Deseja se registrar como: \n1- Admin\n2- Estudante");
				optionRegistro = sc.nextInt();
				if (optionRegistro == 1) {
					System.out.println("Você sera registrado como: admin ");
					sc.nextLine();
					System.out.println("Digite seu nome:");
					String name = sc.nextLine();
					System.out.println("Digite seu email:");
					String email = sc.nextLine();
					System.out.println("Digite seu numero de telefone:");
					String numeroDeTelefone = sc.nextLine();
					System.out.println("Sua senha: ");
					String senha = sc.nextLine();
					personService.AddPerson(name, email, numeroDeTelefone, senha, 1);
					System.out.println("Registrado com sucesso!");
				}

			
				else if (optionRegistro == 2) {
					System.out.println("Você sera registrado como: aluno. ");
					sc.nextLine();
					System.out.println("Digite seu nome:");
					String name = sc.nextLine();
					System.out.println("Digite seu email:");
					String email = sc.nextLine();
					System.out.println("Digite seu numero de telefone:");
					String numeroDeTelefone = sc.nextLine();
					System.out.println("Sua senha: ");
					String senha = sc.nextLine();
					personService.AddPerson(name, email, numeroDeTelefone, senha, 2);
					System.out.println("Registrado com sucesso!");
				}
			}
				
			else if (option == 2) {
				System.out.println("Você está prestes a logar em nosso sistema. \nDigite seu email cadastrado:");
				sc.nextLine();
				String email = sc.nextLine();
				System.out.println("Agora digite sua senha: ");
				String senha = sc.nextLine();
				for (Person p : personRepository.findAll()) {
					if (p.getEmail().equals((email))
							&& p.getSenha().equals((senha))) {
						loginSucess = true;
							if (p.getTipoDeRegistro().equals(1)) {
							// MENU DE ADM
								while(optionLogAdmin !=4) {
									try {
										System.out.println("Você foi reconhecido pelo sistema como um Admin.");
										System.out.println("O que você esta procurando? \n1-Mostrar Ocorrencias salvas no sistema.\n2-Deletar ocorrencia especifica.\n3-Deletar todas as ocorrencias.\n4-Sair.");
										optionLogAdmin = sc.nextInt();
									}
									catch(InputMismatchException erro2) {
										System.out.println("Opção invalida, tente novamente.");
										sc.next();
									}
								switch (optionLogAdmin) {
								case 1:
									System.out.println("Aqui estão as ocorrencias salvas no sistema:");
									OcorrenciasServices.listarOcorrencias();
									break;
									
								case 2:
									System.out.println("Selecione o id da ocorrencia correspondente a que você deseja apagar:");
									OcorrenciasServices.listarOcorrencias();
									Integer id = sc.nextInt();
									OcorrenciasServices.DeletarEspecifico(id);
									System.out.println("Ocorrencia deletada.");
									break;
									
								case 3:
									System.out.println("Tem certez que deseja deletar tudo?\n1-Sim\n2-Não");
									int deletar = sc.nextInt();
									if (deletar == 1) {
										System.out.println("Deletando todas as ocorrencias do sistema...");
										OcorrenciasServices.DeletarTudo();
										System.out.println("Historico de ocorrencias deletado");
									}
									else {
										System.out.println("O sistema só apaga se sua resposta for diretamente SIM. Por segurança voltaremos para página anterior!");
									}
									break;
									
								case 4: 
									System.out.println("Você saiu da sua conta. A página voltará para a area de cadastro/login.");
								}
								}
						}
							else if (p.getTipoDeRegistro().equals(2)) {
								while(optionLogAluno !=3) {
									// MENU DE ALUNO
									try {
										System.out.println("Você foi reconhecido pelo sistema como um Aluno.");
										System.out.println("O que você esta procurando? \n1-Criar ocorrencia.\n2-Mostrar ocorrencias. \n3-Sair.");
										optionLogAluno = sc.nextInt();
									}
									catch(InputMismatchException erro2) {
										System.out.println("Opção invalida, tente novamente.");
										sc.next();
									}
									switch(optionLogAluno) {
									case 1:
										System.out.println("Selecione o tipo de ocorrencia que deseja registrar:");
										System.out.println("1-Reclamação\n2-Elogio\n3-Sugestão");
										int tipoDeoco= sc.nextInt();
										if (tipoDeoco == 1) {
											sc.nextLine();
											System.out.println("Digite o seu nome que vai ser registrado na ocorencia:");
											String seuNome = sc.nextLine();
											System.out.println("Agora digite a sua ocorrencia: ");
											String textoOcorrencia = sc.nextLine();
											OcorrenciasServices.AddoOcorrencia(seuNome, "ocorrencia", textoOcorrencia);
											System.out.println("Ocorrencia registrada com sucesso.");
										}
										else if (tipoDeoco == 2) {
											sc.nextLine();
											System.out.println("Digite o seu nome que vai ser registrado no elogio:");
											String seuNome = sc.nextLine();
											System.out.println("Agora digite o seu elogio: ");
											String textoOcorrencia = sc.nextLine();
											OcorrenciasServices.AddoOcorrencia(seuNome, "elogio", textoOcorrencia);
											System.out.println("Elogio registrado com sucesso.");
										}
										else if (tipoDeoco == 3) {
											sc.nextLine();
											System.out.println("Digite o seu nome que vai ser registrado na sugestão:");
											String seuNome = sc.nextLine();
											System.out.println("Agora digite a sua sugestão: ");
											String textoOcorrencia = sc.nextLine();
											OcorrenciasServices.AddoOcorrencia(seuNome, "sugestão", textoOcorrencia);
											System.out.println("Sugestão registrada com sucesso.");
										}
										else {
											System.out.println("Opção invalida.");
										
										}
										break;
									case 2:
										System.out.println("Aqui estão as ocorrencias registradas até o momento: \n");
										OcorrenciasServices.listarOcorrencias();
										break;
									
									case 3: 
										System.out.println("Você esta se desconectando, aguarde.");
										System.out.println("Prontinho, agora você sera redirecionado para nossa area de login e cadastro novamente");
										break;
									}
									
										
								
								
								
								}
						}
					}
				}
				if (loginSucess == false) {
					System.out.println("Credenciais erradas, tente novamente.");
				}
				else if (option == 3) {
					System.out.println("Sistema fechado.");
				}
			}
			
				
		}
		 sc.close();
	}
	
}
