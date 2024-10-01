# Trabalho-GCS-1

- integrantes &#128572; :
</br>　- Antônio Fontanive de Oliveira
</br>　- Arthur Faleiro Barbosa
</br>　- Fernando Jung Lau
</br>　- Piedro Rockembach Nunes

# Git


<strong>1. Clonar o repositório pelo terminal </strong>

- abra o terminal do seu sitema operacional;
- use o comando `cd [nome da pasta]` para navegar até a pasta que deseja guardar o projeto;
    - exemplos:
      - windows: `cd Documents\Puc\GCS`;
  
      - linux/mac: `cd Documents/Puc/GCS`
<br>

- Use o comando `git clone https://github.com/Judox2005/Trabalho-GCS-1.git ` para clonar o repositório no diretório atual

- Entre na pasta do repositório que você acabou de clonar:
  - `cd Trabalho-GCS-1`   
- Caso esteja usando o VSCode você pode usar o comando `code .` para abrir o diretório atual no editor de código.
- após abrir o projeto no seu editor de texto abra o terminal dele (eu acho mais fácil fazer por lá)
- entre na pasta src `cd .\src`(windows) ou `cd ./src`(mac/linux), n precisa mas eu acho que facilita os proximos comandos, evitar ter que ficar repetindo o `.\src\` para cada comando.

<strong>2. Fluxo de trabalho </strong>

- Use o comando `git branch` para verificar em qual branch você está;
- use o comando `git checkout [nome da branch]` para mudar de branch;
- para desenvolver uma nova funcionalidade no projeto:
  - vá até a branch develop
    - `git checkout develop`
  - sincronize seu repositório local com o remoto
    - `git pull`
  - crie uma nova branch seguindo o padrao de nome
    - `git branch [nome da nova branch]`
  - vá até a nova branch
    - `git checkout [nome da nova branch]`
  - após concluir uma etapa da funcionalidade, adicione os arquivos modificados para a área de stage com `git add [nome do arquivo]`, lembrando que se o arquivo não estiver na mesma pasta que você está até agora tem que escrever todo o caminho ex.: `git add ./src/[nome do arquivo]`, mas como eu já estou na pasta src eu vou colocar direto o nome do arquivo;
  - crie uma versão do repositório com as novas alterações usando `git commit -m "[mensagem que diz o que foi feito no commit]"` que vai adicionar todas as modificações adicionadas na área de stage;
- Para mesclar as alterações feitas na nova branch com o restante do projeto
  - após concluir por completo uma funcionalidade, envie a branch atual para o repositório remoto com `git push`;
  - caso seja a primeira vez fazendo push na branch atual, será necessário usar o comando `git push -u origin [nome da branch atual]`;
  - agora vá até a branch develop que será a branch onde todas as features serão mescladas com `git checkout develop`;
  - sincronize seu repositório local com o remoto com o `git pull` para evitar conflito por estar com uma versão diferente da salva no repositório remoto;
  - agora traga as alterações da sua branch para a develop com o comando `git merge [nome da branch que deseja mesclar]`;
  - em caso de conflitos será necessário ir nos arquivos com conflito e resolvelos antes de continuar
    - se for necessário modificar algum arquivo por causa dos conflitos, será necessário adiciona-los na área de stage novamente e criar um novo commit;
  - não tendo conflitos ou tendo resolvido todos eles, basta usar o comando `git push` para passar as alterações para o repositório remoto;

<strong>3. Comandos úteis </strong>

- `git status`: mostra quais arquivos já estão na área de stage (em verde) e também aqueles que foram modificados mas ainda não foram adicionados (em vermelho).
- `git log`: mostra o histórico de commits da branch atual e suas antecessoras, com um código hash, descrição e mensagem do commit;
- `git checkout -b [nome da nova branch]`: atalho que cria uma nova branch e já muda para ela, é o mesmo que fazer `git branch [nome]` e depois `git checkout [nome]`
- [não sei se isso aqui pode dar problema mas eu precisei usar ent vou por aqui]se precisar voltar para alguma versão anterior da sua branch use o `git log` e copie o código hash do commit que deseja ir, após isso digite `git reset [hash do commit]` para voltar para aquela 
  
<strong>Padrão</strong>
- feature/[nome da feature]/[seu nome]
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


