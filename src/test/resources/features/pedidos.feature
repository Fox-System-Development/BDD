# language: pt
@hamburgueria
Funcionalidade: Pedidos na hamburgueria Peppa Lanches
  Para realizar pedidos corretos
  Como cliente
  Eu quero saber se o item pode ser pedido, o valor total e o tempo estimado

  Contexto:
    Dado que o cardápio contém os itens:
      | item         | preco |
      | x-bacon      | 25.00 |
      | x-salada     | 22.00 |
      | batata frita | 12.00 |

  @feliz
  Cenário: Pedido simples de item existente
  Dado que o cliente seleciona o item "x-salada"
  Quando o cliente define a quantidade 2
  Então o sistema deve exibir a mensagem "Pedido confirmado com sucesso"
  E fico feliz demais que não fiz o L

  @inexistente
  Cenário: Pedido de item inexistente
  Dado que o cliente procura por "Risoto"
  Então o sistema deve exibir a mensagem "Item indisponível no cardápio"

  @quantidade
  Cenário: Pedido com quantidade inválida
  ...

  @desconto
  Cenário: Pedido com desconto de 10 por cento
  ...
  
  @sla
  Cenário: Calcular tempo estimado de preparo
  Dado que o cliente seleciona o item "x-bacon"
  Quando o cliente define a quantidade 2
  Então o sistema deve exibir a mensagem "Pedido confirmado com sucesso"
  E o tempo estimado de preparo sera de 12 minutos