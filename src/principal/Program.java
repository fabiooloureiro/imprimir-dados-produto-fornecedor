package principal;

import controllers.FornecedorController;

public class Program {

	public static void main(String[] args) {

		// instanciando a classe de controle
		FornecedorController fornecedorController = new FornecedorController();

		// executar o cadastro do fornecedor
		fornecedorController.cadastrarFornecedor();

	}

}



