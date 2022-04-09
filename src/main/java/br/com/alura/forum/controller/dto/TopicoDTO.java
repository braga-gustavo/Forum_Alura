package br.com.alura.forum.controller.dto;

import br.com.alura.forum.modelo.Topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

public class TopicoDTO {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    public TopicoDTO(Topico topico) {

        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
    }



    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }



    public static List<TopicoDTO> converter(List<Topico> topicos) {

        return topicos.stream().map(TopicoDTO::new).collect(Collectors.toList());
    }

}
