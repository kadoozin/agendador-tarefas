package br.com.kadoozin.agendador_tarefas.bunisess.dto.in;

import br.com.kadoozin.agendador_tarefas.bunisess.dto.out.EnderecoResponseDTO;
import br.com.kadoozin.agendador_tarefas.bunisess.dto.out.TelefoneResponseDTO;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class UsuarioRequestDTO {
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String email;
    private String senha;
    private List<EnderecoResponseDTO> enderecos;
    private List<TelefoneResponseDTO> telefones;
}
