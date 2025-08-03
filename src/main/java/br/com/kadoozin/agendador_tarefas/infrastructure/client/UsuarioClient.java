package br.com.kadoozin.agendador_tarefas.infrastructure.client;

import br.com.kadoozin.agendador_tarefas.bunisess.dto.in.EnderecoRequestDTO;
import br.com.kadoozin.agendador_tarefas.bunisess.dto.in.LoginRequestDTO;
import br.com.kadoozin.agendador_tarefas.bunisess.dto.in.TelefoneRequestDTO;
import br.com.kadoozin.agendador_tarefas.bunisess.dto.in.UsuarioRequestDTO;
import br.com.kadoozin.agendador_tarefas.bunisess.dto.out.EnderecoResponseDTO;
import br.com.kadoozin.agendador_tarefas.bunisess.dto.out.TelefoneResponseDTO;
import br.com.kadoozin.agendador_tarefas.bunisess.dto.out.UsuarioResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "usuario", url = "http://localhost:9090")
public interface UsuarioClient {
    @PostMapping
    UsuarioResponseDTO criaUsuario(@RequestBody UsuarioRequestDTO usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO dto);

    @PutMapping("/atualizar/usuario")
    UsuarioResponseDTO atualizaDadosUsuario(@RequestBody UsuarioRequestDTO usuarioDTO,
                                            @RequestHeader("Authorization") String token);

    @GetMapping("/buscar/{email}")
    UsuarioResponseDTO buscarUsuarioPorEmail(@RequestParam String email,
                                             @RequestHeader("Authorization") String token);

    @GetMapping("/buscar/{id}")
    UsuarioResponseDTO buscarUsuarioPorId(@PathVariable Long id,
                                          @RequestHeader("Authorization") String token);

    @DeleteMapping("/deletar/{id}")
    void deletarUsuarioPorId(@PathVariable Long id,
                             @RequestHeader("Authorization") String token);

    @GetMapping("/listar")
    List<UsuarioResponseDTO> listarUsuarios();

    @PutMapping("/atualizar/endereco/{id}")
    EnderecoResponseDTO atualizaDadosDoEnderecoPorId(@RequestParam Long id,
                                                     @RequestBody EnderecoRequestDTO dto,
                                                     @RequestHeader("Authorization") String token);

    @PutMapping("/atualizar/telefone/{id}")
    TelefoneResponseDTO atualizaDadosDoTelefonePorId(@RequestParam Long id,
                                                     @RequestBody TelefoneRequestDTO dto,
                                                     @RequestHeader("Authorization") String token);

    @PostMapping("/adicionar/endereco")
    EnderecoResponseDTO adicionaNovoEndereco(@RequestHeader("Authorization") String token,
                                             @RequestBody EnderecoRequestDTO dto);

    @PostMapping("/adicionar/telefone")
    TelefoneResponseDTO adicionaNovoTelefone(@RequestHeader("Authorization") String token,
                                             @RequestBody TelefoneRequestDTO dto);
}
