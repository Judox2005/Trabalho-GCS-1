# Trabalho-GCS-1

- integrantes &#128572; :
</br>　- Antônio Fontanive de Oliveira
</br>　- Arthur Faleiro Barbosa
</br>　- Fernando Jung Lau
</br>　- Piedro Rockembach Nunes

# Commits
- padrão:
    - feature/[nome da feature]
    - hotfix/[o que está sendo arrumado]
# Funcionalidades gerais a serem implementadas
- [ Registro ] método para adicionar pedido na lista de pedidos: adicionarPedido(pedido: Pedido): void;
- [ Pedido ] Método para adicionar itens no pedido: adicionarItem(item: Item): void;
    * Adiciona item na lista de itens;
    * Adiciona o valor do item ( valor * quantidade ) ao valor total do pedido;
- [ Registro ] Método para remover Pedido da lista de Pedidos;

# Requisitos
## 1 - Escolher usuário
- opção de escolher o usuario ao entrar no programa;
- opção no menu de alterar usuário;
## 2 - Departamento
- criar metodo para adicionar usuarios no departamento;
## 3 - Usuário
- Get departamento
- Get tipo
- Get id

## 4 - Registrar um novo pedido
- Pegar os dados do usuario;
- verificar o departamento;
- cria um novo pedido com usuario e departamento passados;
- criar menu para adicionar itens ao pedido até que seja requisitado para continuar com o pedido ou seja cancelado;
- verificar se o pedido não excedeu o saldo limite por pedido do departamento;
- se exceder, apresentar mensagem;
- se o pedido for cancelado, apresentar mensagem;
- se tudo ocorrer corretamente, adicionar novo pedido no array de pedidos;
- o status inicial do pedido dever ser "aberto"

## 5 - Excluir pedido [Apenas usuario que criou o pedido]
- Pegar os dados do usuario;
- mostra ao usuário todos os pedidos que ele fez;
- Caso não haja nenhum pedido feito por esse usuario, mostrar mensagem "Você não tem pedidios";
- Usuário escolhe o pedido a ser excluído pelo id;
- verifica se o pedido corresponde ao usuário atual;
- se o usuário não possuir um pedido com o id fornecido, mostrar mensagem "Você não possui um pedido com este id!"
- se não, mostra mensagem de erro;
- se sim exclui o pedido e mostra mensagem de sucesso;
- Exclui o pedido da lista de pedidos;
- retorna ao menu principal;

## 6 - Listar todos os pedidos entre datas [ADM]
- solicitar data inicial e final no formato "DD/MM/AAAA";
- pesquisar os pedidos entre estas datas e escrever na tela;
- caso não houver nenhum mostrar mensagem de erro;

## 7 - Listar todos os pedidos de um certo funcionario
- Solictar id de um funcionario;
- pesquisar todos os pedidos deste funcionario e mostrar na tela;
- se nenhum pedido for encontrado, informar na tela;

## 8 - Listar todos os pedidos pela descrrção do item;
- solicitar uma descrição de item;
- pesquisar todos os pedidos que possuem esta descrição e mostrar na tela;
- se nenhum pedido for encontrado, informar na tela;

## 9 - Editar status [ADM]
- Dar a opção de acessar um dos pedidos pelo id;
- Oferecer duas opções na tela, aprovar ou reprovar;
- verificar se o status está como "aberto";
- se der certo, mostrar os dados atulizados do pedido e mensagem "Status atualizado com sucesso!";
- se der errado, retornar ao menu;

## 10 - Número de pedidos total, divididos entre aprovados e reprovados (com percentuais).
- vai buscar todos os pedidos aprovados e reprovados;
- mostrar a quantidade total de pedidos;
- mostrar quantidade de pedidos aprovados com percentual do lado;
- mostrar quantidade pedidos reprovados com percentual do lado;
- formato "aprovado: 10 [20%]"

## 11 - Número de pedidos nos últimos 30 dias e seu valor médio.
- pede a data atual
- pesquisa pelos pedidos feitos nos ultimos 30 dias
- mostra na tela a quantidade de pedidos encontrados no intervalo;
- mostra a média dos valores encontrados;


## 12 - Valor total de cada categoria nos últimos 30 dias.
- pede a data atual
- pesquisa pelos pedidos feitos nos ultimos 30 dias
- mostra todas as categorias dos pedidos encontrados com o valor total de seus pedidos do lado
- formato: "aberto: 30.00"

## 13 - Detalhes do pedido de aquisição de maior valor ainda aberto.
- pesquisa por todos os pedidos abertos
- mostra na tela o pedido com maior valor

## Divisão
- Arthur
    - 4
    - 2
    - 3
- Antônio
    - 9
    - 7
    - 13
- Fernando
    - 11
    - 12
    - 5
- Piedro
    - 6
    - 10
    - 8


