package br.dev_anderson.sistema_de_chaves;

import br.dev_anderson.sistema_de_chaves.controller.FuncionariosController;
import br.dev_anderson.sistema_de_chaves.model.Funcionarios;
import br.dev_anderson.sistema_de_chaves.repository.FuncionariosRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FuncionariosControllerTests {
	@Mock
	private FuncionariosRepository funcionariosRepository;
	@InjectMocks
	private FuncionariosController funcionariosController;


	@Test
	void DevelistarNomeMatricula() {
		Funcionarios funcionarios = new Funcionarios();
		funcionarios.setNome("Teste Unitário");
		funcionarios.setMatricula("198442");
		funcionariosController.cadastrarpeao(funcionarios);
		verify(funcionariosRepository, times(1)).save(funcionarios);
	}


}
