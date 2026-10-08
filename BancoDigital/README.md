# Banco Digital

Programa em Java com dois clientes e três operações: **depositar**, **sacar** e **transferir**.

## Quem é o cliente 1 e o cliente 2?

Ao abrir o programa, digite o **nome** e a **agência**:

Cliente 1 | `Cliente Um`   | `1`     | R$ 1.000    

Cliente 2 | `Cliente Dois` | `2`     | R$ 20.000  

Se o nome não combinar com a agência, o programa não deixa entrar.

## O que dá para fazer

1. **Depositar:** coloca dinheiro na sua conta.
2. **Sacar:** tira dinheiro da sua conta (não pode passar do saldo).
3. **Transferir:** digite a agência do outro cliente e o valor.

## Como rodar

Abra a pasta no IntelliJ e execute o arquivo `Main.java`.

## Onde fica cada coisa

- `Main.java`: o menu.
- `bancodigital/modelo`: as contas e o cliente.
- `bancodigital/servico`: o banco (identifica o cliente e faz a transferência).
