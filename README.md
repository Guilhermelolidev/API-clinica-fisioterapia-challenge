Desafio Back End Pic Pay

💼 Projeto: Sistema de Gestão de Agendamentos para Clínicas de Fisioterapia

🧑‍💼 Requisitos funcionais (do cliente):
"Queremos um sistema simples onde os administradores da clínica consigam cadastrar profissionais (fisioterapeutas), pacientes e agendamentos de sessões.
Cada sessão precisa ter um horário, um status, e não pode haver dois agendamentos no mesmo horário com o mesmo fisioterapeuta.
O sistema também deve impedir agendamentos fora do horário comercial (08:00 às 18:00)."

🧱 Entidades principais:

Pessoa (abstrata)
Nome, e-mail, telefone, CPF

Fisioterapeuta (herda de Pessoa)
Registro profissional (CRF), especialização

Paciente (herda de Pessoa)
Data de nascimento, plano de saúde

Agendamento
Fisioterapeuta, paciente, data e hora, status (Agendado, Concluído, Cancelado), observações

📜 Regras de negócio:
- Não pode haver agendamento duplicado no mesmo horário com o mesmo fisioterapeuta.
- Horário do agendamento deve estar entre 08:00 e 18:00.
- Fisioterapeuta e paciente devem existir no sistema antes de criar o agendamento.
- Somente agendamentos com status "Agendado" podem ser alterados ou cancelados.
- Paciente não pode ter mais de um agendamento ativo por dia.
- Quando um agendamento for marcado como "Concluído", ele se torna imutável.

📦 Recursos da API:
GET /pacientes – Listar todos os pacientes
POST /fisioterapeutas – Cadastrar um novo profissional
POST /agendamentos – Criar sessão
PUT /agendamentos/{id}/cancelar – Cancelar agendamento
PUT /agendamentos/{id}/concluir – Concluir sessão

✅ Tecnologias:
Spring Boot (web, JPA)
PostgreSQL
DTOs e mapeamento com ModelMapper ou manual
Validações com Bean Validation (@NotNull, @CPF, @Future, etc)
Tratamento global de exceções (@ControllerAdvice)
Camadas: controller, service, repository, domain
Uso de interfaces nos serviços para aplicar inversão de dependência (SOLID)
