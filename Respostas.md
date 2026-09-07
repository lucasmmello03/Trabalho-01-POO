**1. Quais classes você identificou em cada parte, e como decidiu as responsabilidades de cada uma? (Se usou CRC Cards, ainda que informalmente, inclua-as.)**

**Parte1->** Foi identificado a necessidade da inclusão de 3 classes com responsabilidades distintas e um enum, sendo elas: 
`Frota.java:` Responsável apenas por cadastrar o veículo, buscar por placa e imprimir o relatório; 
`Manutencao.java:` Responsável por encapsular a lógica e as devidas validações específicas, juntamente das regras de negócio estabelecidas para manutenção; 
`Veiculo.java:` Responsável por trazer também segurança no encapsulamento, identidade nos seus comportamentos e intenção nos seus métodos;
`TipoManutencao.java:` Responsável por trazer robustez, ao contrário de uma simples String sem identidade, ela representa uma escolha finita de opções para manutenção.
Todas as escolhas procuram manter a lógica de funcionamento inicial, porém trazendo os pilares de POO vistos até o momento, abstração e encapsulamento, com suas devidas validações e identidade, deixando de serem informações soltas e desconexas no Main.java.

**Parte2->** Foi identificado a necessidade da inclusão de 3 classes com resposabiidades distintas, sendo elas: 
`Aluno.java:` Responsável por abstrair a figura de um Aluno, com suas devidas validações, o qual era tratado como uma simples String desconexa de um contexto geral de abstração;
`Matricula.java:` Responsável por fazer o elo entre o Aluno e a Turma, ela abstrai os atributos e métodos que competem ao controle acadêmico, como lançamento de nota e cálculo para aprovação, trazendo robustez com encapsulamento;
`Turma.java:` Responsável por assegurar o controle e regras de negócio de Matrícula, porém com atribuições para cada instância de um Aluno, validando as regras de negócio previamente estabelecidas, encapsulando comportamentos de listas com LinkedHashMap, e trazendo o resultado desejado para o controle academico. 

**2. Na Parte 2, como você decidiu representar a relação entre Turma e Matricula, e entre Matricula e Aluno? As duas relações acabaram modeladas da mesma forma, ou de formas diferentes? Por quê?**

As relações foram modeladas de formas diferentes, mas complementares.
Portanto, a classe Matricula recebe a instância independente de um Aluno e abstrai os comportamentos acadêmicos referentes a ele de forma única, ou seja, aplica para cada instância de Aluno, para o objeto, as devidas ações, como lançar uma nota e verificar se o mesmo está aprovado diante das regras de negócio. Neste cenário, a classe Turma se beneficia deste encapsulamento prévio. A Turma gerencia o seu conjunto de matrículas e faz as devidas validações globais (como limite de vagas), delegando para a Matricula as atribuições individuais de nota e o cálculo de aprovação. Assim, a Turma apenas aciona os comportamentos que já foram abstraídos de forma segura na relação entre o aluno e a sua matrícula.

**3. Qual regra de negócio (de qualquer uma das partes) foi mais difícil de proteger estruturalmente (isto é, através do próprio modelo, não de um if em algum lugar)? Por quê?**

Acredito que na Parte2, na relação citada anteriormente, onde as 3 classes, Aluno, Turma e Matrícula, estão extremamente interligadas porém separadas em responsabilidades, no sentido em que uma não se sobrepõe a outra em regras de validações por exemplo. O desafio foi lidar com a delegação e sobreposição, no qual a dificuldade central foi garantir que a Turma gerenciasse apenas as regras do coletivo, como o controle da capacidadeMaximaVagas, enquanto a Matricula assumia as regras do indivíduo, instância do Aluno. Ao separar essas, estruturalmente, me forçei a delegar que a Turma acionasse a Matricula para lidar com o lançamento da nota, respeitando o princípio de que a validação deve ocorrer exatamente onde o dado se encontra.

**4. Existe alguma decisão de design da sua solução que você sabe que é discutível — outra pessoa razoavelmente poderia ter modelado diferente? Qual, e por que você escolheu o caminho que escolheu?**

 Sim, ao meu ver na Parte2, especificamente na classe Turma. Na mesma iria residir a resposnsabilidade de formatar e exibir os dados, com o método `imprimirTurma()`, pensei em focar nela essa resposnsabilidade, por aglutinar os comportamentos já abstraídos de Matrícula e Aluno, onde ocorre forte encapsulamento deste escopo, e forçar essa separação, exigiria expor publicamente a estrutura do LinkedHashMap através de um gett, apenas para que uma classe externa pudesse iterar sobre os dados. Entendo que essa decisão, poderia ser contestada, na medida em que, é possível chegar a conclusão de que pode ser delegado a uma outra classe, que teria talvez tenha apenas essa atribuição.