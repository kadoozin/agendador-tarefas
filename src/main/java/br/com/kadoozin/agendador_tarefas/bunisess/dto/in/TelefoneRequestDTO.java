package br.com.kadoozin.agendador_tarefas.bunisess.dto.in;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class TelefoneRequestDTO {
    private String numero;
    private String ddd;
}
