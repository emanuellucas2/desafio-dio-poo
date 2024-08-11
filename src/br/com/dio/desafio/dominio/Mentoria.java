package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo {
   private LocalDate data;

    public Mentoria(String titulo, String descricao, LocalDate data) {
        
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        this.setData(data);
        this.setNota(0.0);
        this.setAvaliacoes(0);
    }

   public double calcularXp() {
      return 30.0D;
   }

   public LocalDate getData() {
      return this.data;
   }

   public void setData(LocalDate data) {
      this.data = data;
   }

   public String toString() {

      return    "Mentoria{" +
                "titulo='" + this.getTitulo() + 
                "', descricao='" + this.getDescricao() + 
                "', data=" + this.data + "}";
   }
}
    