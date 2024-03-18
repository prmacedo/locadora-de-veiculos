# Aluguel de Veículos

### Grupo:
* Luiz Gabriel
* Paulo Macêdo
* Rafael Luís
* Ricard Roberg


<br/>

#### [1 - ADA LocateCar - Locadora de veículos](#ada-locatecar---locadora-de-veículos)

#### [2 - Guia do Usuário](#guia-do-usuário)


# ADA LocateCar - Locadora de veículos

---
Criar uma aplicação que gerencie o aluguel de veículos, aplicando os conceitos vistos em aula, onde cada item abaixo seja considerado:
<br/>
## Itens obrigatórios

---
   - [x] Cadastrar os veículos;
   - [x] Alterar um veículo cadastrado;
   - [x] Buscar um veículo por parte do nome;
   - [x] Cadastrar o cliente (pessoa física e jurídica)
   - [x] Alterar o cliente (pessoa física e jurídica)
   - [x] Alugar um veículo para pessoa física e jurídica;
   - [x] Devolver um veículo para pessoa física e jurídica;
      
## Regras de negócio

---

- RN1: Os veículos não podem ser repetidos; Pode utilizar a placa como identificador de unicidade;
- RN2: Tipos de veículos que serão considerados: PEQUENO, MEDIO e SUV;
- RN3: Os aluguéis e devoluções terão o local, data e horário;
- RN4: Considere aluguel em horas quebradas como uma diária completa. Exemplo: uma devolução de um veículo alugado no dia 25 de janeiro às 15h30 será cobrado uma (1) diária até dia 26 de janeiro às 15h30, a partir desse horário já serão cobradas duas (2) diárias e assim por diante.
- RN5: Os veículos que estiverem alugados não poderão estar disponíveis;
- RN6: Clientes não podem estar duplicados; Considerar CPF (Pessoa Física) e CNPJ (Pessoa Jurídica) como identificadores de unicidade;
- RN7: Regras de devolução:
       Caso o cliente pessoa física tenha ficado com o carro mais que 5 diárias terá direito a 5% de desconto.
       Caso o cliente pessoa jurídica tenha ficado com o carro mais que 3 diárias terá direito a 10% de desconto.
       Valores base da diária por tipo de veículo:

```
| Tipo de Veículo | Valor por dia |
| --------------- | ------------- |
| PEQUENO         | R$ 100,00     |
| MEDIO           | R$ 150,00     |
| SUV             | R$ 200,00     |
```

## Itens bônus - Opcionais

---

  - [X] Paginar as listagem envolvidas;
  - [X] Gravar os dados em arquivos;




# Guia do Usuário

Ao iniciar o programa, será apresentada a seguinte tela:

```
------------- MENU -------------
|    1 - CLIENTES              |
|    2 - VEICULOS              |
|    3 - ALUGUEL               |
|    0 - SAIR                  |
--------------------------------
Escolha a opcao: 
```
#### [1 - CLIENTES](#Clientes)
#### [2 - VEICULOS](#Veiculos)
#### [3 - ALUGUEL](#Aluguel)
#### 0 (zero) para sair do programa
<br/><br/>
### Clientes

Tela inicial de cadastro de clientes:

```
------------ CLIENTE ------------
|    1 - Cadastrar Cliente      |
|    2 - Alterar Cliente        |
|    3 - Buscar Cliente         |
|    4 - Listar Cliente         |
|    5 - Menu Principal         |
|    0 - SAIR                   |
---------------------------------
Escolha a opcao: 
```
Opção 1: 
- Será solicitado um nome para o cadastro
- Em seguida o numero do documento: 
     * Se o documento possuir 12 ou mais caracteres o cadastro 
  <br/>será registrado como Pessoa Juridica, Caso contrário Pessoa Física
- Se tudo der certo deverá aparecer a mensaggem ```Pessoa cadastrada com sucesso!```


Opção 2:
- Será solicitado o numero antigo do documento do cliente
- O novo numero do documento
- E o nome do cliente

Opção 3:
- Será solicitado que o usuario digite um termo para busca.
- Escolha bem o termo pois será retornado apenas o primeiro resultado.

Opção 4:
- Será listado todos os usuários cadastrados (5 por pagina)
- Digite ENTER para trocar de página
  * Ao chegar na última página e apertar enter ele retorna pra primeira
```
|       Documento      |          Nome        |
| -------------------- | -------------------- |
|                  321 |                  asd |
|          99999999999 |               henrik |
|                  222 |                qqqqq |
-----------------------------------------------
Pagina 1 de 1
Enter proxima pagina ('s' para sair): 
```

Opção 5:
- Retorna ao menu  ([Inicio](#Guia-do-Usuário))

  <br/><br/>
### Veiculos

Tela inicial de cadastro de veículos:

```
------------ VEICULO ------------
|    1 - Cadastrar Veiculos     |
|    2 - Alterar Veiculo        |
|    3 - Buscar Veiculo         |
|    4 - Listar Veiculo         |
|    5 - Menu Principal         |
|    0 - SAIR                   |
---------------------------------
Escolha a opcao: 
```
Opção 1:
- Será solicitada a placa do veículo
- Em seguida o usuário deverá selecionar o tipo (PEQUENO, MEDIO, SUV)
```
----- TIPO VEICULO -----
1. PEQUENO
2. MEDIO
3. SUV
Escolha o tipo: 
```
- Se tudo der certo deverá aparecer a mensaggem ```Veículo cadastrado com sucesso!```


Opção 2:
- Será solicitado a placa antiga do veículo
- A nova placa do veículo
- E o menu para selecionar o tipo

Opção 3:
- Será solicitado que o usuario digite um termo para busca.
- Escolha bem o termo pois será retornado apenas o primeiro resultado.

Opção 4:
- Será listado todos os veículos cadastrados (5 por pagina)
- Digite ENTER para trocar de página
       * Ao chegar na última página e apertar enter ele retorna pra primeira
```
|         Placa        |          Tipo        |
| -------------------- | -------------------- |
|              AAA1111 |                MEDIO |
|              CBA4321 |                MEDIO |
|              ASD1234 |                  SUV |
-----------------------------------------------
Pagina 1 de 1
Enter proxima pagina ('s' para sair): 
```

Opção 5:
- Retorna ao menu  ([Inicio](#Guia-do-Usuário))

<br/><br/>
### Aluguel

Tela inicial de cadastro de veículos:

```
------------ ALUGUEL ------------
|    1 - Alugar Veiculo         |
|    2 - Devolver Veiculo       |
|    3 - Buscar Registro        |
|    4 - Menu Principal         |
|    0 - SAIR                   |
---------------------------------
Escolha a opcao: 
```
Opção 1:
- Digite o local onde o veículo está sendo alugado (ex: bairro ou nome filial)
- Digite a data e hora do início do contrato ou ENTER para data e hora atual.
- Digite o documento do cliente (Cliente já deverá estar cadastrado)
- Digite a placa do veículo (Veículo já deverá estar cadastrado)
- Se tudo der certo aparecerá a mensagem ```Veículo alugado com sucesso!```
 - <strong>Caso a placa ou documento não existam, um erro será apresentado e retornará ao menu.</strong>


Opção 2:
- Digite o local onde o veículo foi/será devolvido (ex: bairro ou nome filial)
- Digite a data e hora do final do contrato ou ENTER para data e hora atual.
- Digite o documento do cliente (Cliente já deverá estar cadastrado)
- Digite a placa do veículo (Veículo já deverá estar cadastrado)
- Se tudo der certo aparecerá a mensaggem com o período e o valor a ser pago
- <strong>Caso a placa ou documento não existam, um erro será apresentado e retornará ao menu.</strong>
- <strong>Caso a data seja antes da data de aluguel ou o veículo já esteja devolvido, um erro será apresentado.</strong>

Opção 3:
- Digite a placa do veículo para busca
- Será retornado todo o registro de movimentação do veículo
```
|       Registro       |        Local         |      Data e Hora     |        Placa         |    Doc. Cliente      |
| -------------------- | -------------------- | -------------------- | -------------------- | -------------------- |
|              Alugado |              Niteroi |     2024-03-17 14:03 |              CBA4321 |          12345678945 |
|            Devolvido |              Niteroi |     2024-03-17 14:34 |              CBA4321 |          12345678945 |
|              Alugado |              Barreto |     2024-03-17 21:24 |              CBA4321 |          99999999999 |
|            Devolvido |              Iracema |     2024-06-15 12:00 |              CBA4321 |          99999999999 |
--------------------------------------------------------------------------------------------------------------------
```

Opção 4:
- Retorna ao menu  ([Inicio](#Guia-do-Usuário))
  <br/><br/>
