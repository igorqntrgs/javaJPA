package gerenciamento;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import gerenciamento.actions.AlunoDAO;
import gerenciamento.entity.Aluno;

public class Main {

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);
		Aluno aluno = new Aluno();
		AlunoDAO alunoDao = new AlunoDAO();

		int opcao;

		do {
			System.out.print("|-----------------------------|\n");
			System.out.println("1 - Inserir aluno");
			System.out.println("2 - Listar alunos");
			System.out.println("3 - Listar alunos por uma letra");
			System.out.println("4 - Pesquisar aluno");
			System.out.println("5 - Atualizar aluno");
			System.out.println("6 - Deletar aluno");
			System.out.println("7 - Encerrar");
			System.out.print("|-----------------------------|\n");
			System.out.print("Digite uma opção: ");

			opcao = Integer.parseInt(sc.nextLine());

			if (opcao < 1 || opcao > 7) {
				System.out.println("Opção incorreta!");
			} else if (opcao == 0) {
				System.out.println("Opção incorreta!");
			} else {
				if (opcao != 7) {
					try {
						switch (opcao) {
						case 1:
							System.out.print("Entre com o nome = ");
							aluno.setNome(sc.nextLine());

							System.out.print("Entre com o email = ");
							aluno.setEmail(sc.nextLine());

							System.out.print("Entre com o endereco = ");
							aluno.setEndereco(sc.nextLine());

							System.out.print("Entre com o cpf = ");
							aluno.setCpf(sc.nextLine());

							System.out.print("Entre com a data de nascimento = ");
							aluno.setDataNascimento(sc.nextLine());

							System.out.print("Entre com a naturalidade = ");
							aluno.setNaturalidade(sc.nextLine());

							alunoDao.persist(aluno);
							break;
						case 2:
							List<Aluno> alunos = alunoDao.findAll();
							SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

							for (Aluno alunoList : alunos) {
								System.out.println("-------------------------------");
								System.out.println("Nome: " + alunoList.getNome());
								System.out.println("Email: " + alunoList.getEmail());
								System.out.println("Endereço: " + alunoList.getEndereco());
								System.out.println("Cpf: " + alunoList.getCpf());
								System.out.println("Data de nascimento: " + alunoList.getDataNascimento());
								System.out.println("Naturalidade: " + alunoList.getNaturalidade());
								System.out.println("-------------------------------");
							}

							break;
						case 3:
							System.out.println("Insira a letra para pesquisar: ");
							String s = sc.nextLine();

							List<Aluno> alunosLetra = alunoDao.getAlunosLetra(s);

							for (Aluno alunoList : alunosLetra) {
								System.out.println("-------------------------------");
								System.out.println("Nome: " + alunoList.getNome());
								System.out.println("Email: " + alunoList.getEmail());
								System.out.println("Endereço: " + alunoList.getEndereco());
								System.out.println("Cpf: " + alunoList.getCpf());
								System.out.println("Data de nascimento: " + alunoList.getDataNascimento());
								System.out.println("Naturalidade: " + alunoList.getNaturalidade());
								System.out.println("-------------------------------");
							}
							break;
						case 4:
							System.out.print("Entre com o id = ");
							Long id = aluno.setId(Long.valueOf(sc.nextLine()));
		
							Aluno a = alunoDao.getById(id);
							
							System.out.println("-------------------------------");
							System.out.println("Nome: " + a.getNome());
							System.out.println("Email: " + a.getEmail());
							System.out.println("Endereço: " + a.getEndereco());
							System.out.println("Cpf: " + a.getCpf());
							System.out.println("Data de nascimento: " + a.getDataNascimento());
							System.out.println("Naturalidade: " + a.getNaturalidade());
							System.out.println("-------------------------------");

							break;
						case 5:
							System.out.print("Entre com o id = ");
							aluno.setId(Long.parseLong(sc.nextLine()));

							System.out.print("Entre com o nome = ");
							aluno.setNome(sc.nextLine());

							System.out.print("Entre com o email = ");
							aluno.setEmail(sc.nextLine());

							System.out.print("Entre com o endereco = ");
							aluno.setEndereco(sc.nextLine());

							System.out.print("Entre com o cpf = ");
							aluno.setCpf(sc.nextLine());

							System.out.print("Entre com a data de nascimento = ");
							aluno.setDataNascimento(sc.nextLine());

							System.out.print("Entre com a naturalidade = ");
							aluno.setNaturalidade(sc.nextLine());

							alunoDao.merge(aluno);
							break;
						case 6:
							System.out.print("Entre com o id = ");
							aluno.setId(Long.parseLong(sc.nextLine()));

							try {
								alunoDao.remove(aluno);
							} finally {
								System.out.println("Apagado com sucesso!!");
							}
							break;
						case 7:
							System.out.println("Programa encerrado!");
							sc.close();
							System.exit(0);
							break;
						}
					} catch (NumberFormatException erro) {
						System.out.println("Entre com o formato correto dos dados!");
					} catch (Exception erro) {
						System.out.println("Erro não identificado: " + erro.toString());
					}
				}
			}
		} while (opcao != 0);
		System.out.println("Programa encerrado!");
		sc.close();
		System.exit(0);
	}
}
