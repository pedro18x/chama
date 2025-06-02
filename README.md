# Educar

Aplicativo Android desenvolvido em Kotlin para gerenciamento de usuários acadêmicos, permitindo cadastro, autenticação, listagem e exclusão de usuários, além de navegação entre diferentes telas informativas.

## Funcionalidades Principais

- **Tela de Menu**  
  Navegação para tela de login ou de cadastro.

- **Cadastro de Usuário**  
  Formulário para inserir nome completo, matrícula, curso, nome de usuário e senha. Os dados são armazenados localmente via SQLite.

- **Login**  
  Autenticação do usuário com nome de usuário e senha, validando os dados no banco local.

- **Listagem e Exclusão de Usuários**  
  Mostra todos os usuários cadastrados e permite exclusão por ID.

- **Tela de Informações**  
  Exibe informações e permite acesso à lista de usuários.

- **Tela de Matérias**  
  Disponibiliza navegação para mais informações.

## Infraestrutura Técnica

- **Armazenamento Local:** Utiliza SQLite (`CadastroDBHelper`) para persistência dos dados dos usuários (CRUD completo).
- **Kotlin puro:** Foco em Activities tradicionais do Android.
- **Interface:** Utiliza layouts XML para as telas.
- **Navegação:** Entre Activities via Intents.

## Principais Classes

- `MenuActivity`: Tela inicial, navegação para login ou cadastro.
- `CadastroActivity`: Cadastro de novos usuários.
- `LoginActivity`: Autenticação.
- `ListarUsuariosActivity`: Listagem e exclusão de usuários.
- `InformacoesActivity`: Tela de informações extras.
- `MateriasActivity`: Navegação de conteúdos/matérias.
- `CadastroDBHelper`: Gerencia o banco de dados SQLite (CRUD de usuários).

---

Projeto ideal para fins didáticos em desenvolvimento mobile, exemplificando um app educacional com banco de dados local e operações completas de usuário.
