package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import io.cucumber.datatable.DataTable; 
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PedidoSteps {

    private List<String> cardapio = new ArrayList<>();
    
    private String itemEscolhido;
    private int tempoEstimado;
    private String mensagemExibida;

    @Dado("que o cardápio contém os itens:")
    public void que_o_cardapio_contem_os_itens(DataTable dataTable) {
        List<Map<String, String>> linhas = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> coluna : linhas) {
            String nomeDoItem = coluna.get("item"); 
            this.cardapio.add(nomeDoItem);          
        }
    }

    @Dado("que o cliente seleciona o item {string}")
    public void que_o_cliente_seleciona_o_item(String item) {
        if (cardapio.contains(item)) {
            this.itemEscolhido = item;
            this.mensagemExibida = "Item adicionado";
        } else {
            this.itemEscolhido = null;
            this.mensagemExibida = "Item indisponível no cardápio";
        }
    }

    @Dado("que o cliente procura por {string}")
    public void que_o_cliente_procura_por(String item){
            if (cardapio.contains(item)) {
            this.itemEscolhido = item;
            this.mensagemExibida = "Item adicionado";
        } else {
            this.itemEscolhido = null;
            this.mensagemExibida = "Item indisponível no cardápio";
        }
        }
    

    @Quando("o cliente define a quantidade {int}")
    public void o_cliente_define_a_quantidade(int quantidade) {
        if (this.itemEscolhido != null && quantidade > 0) {
            this.tempoEstimado = 8 + (2 * quantidade);
            this.mensagemExibida = "Pedido confirmado com sucesso";
        } else {
            if (this.itemEscolhido == null) {
                 this.mensagemExibida = "Item indisponível no cardápio";
            } else {
                 this.mensagemExibida = "Quantidade inválida, tem de ser maior que 0";
            }
            this.tempoEstimado = 0;
        }
    }

    @Então("o sistema deve exibir a mensagem {string}")
    public void o_sistema_deve_exibir_a_mensagem(String mensagemEsperada) {
        Assert.assertEquals(mensagemEsperada, this.mensagemExibida);
    }

    @Então("o tempo estimado de preparo sera de {int} minutos")
    public void o_tempo_estimado_de_preparo_sera_de_minutos(int tempoEsperado) {
    Assert.assertEquals(tempoEsperado, this.tempoEstimado);
    }

    @Então("fico feliz demais que não fiz o L")
    public void nao_fiz_o_l() {
    Assert.assertTrue(true);;
    }
}
