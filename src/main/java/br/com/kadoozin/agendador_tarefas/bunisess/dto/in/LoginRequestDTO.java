package br.com.kadoozin.agendador_tarefas.bunisess.dto.in;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class LoginRequestDTO {
    private String email;
    private String senha;
}
