package br.com.kadoozin.agendador_tarefas.bunisess.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class UsuarioDTO {
    private String email;
    private String senha;
}
