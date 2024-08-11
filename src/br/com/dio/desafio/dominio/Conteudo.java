package br.com.dio.desafio.dominio;

public abstract class Conteudo {

   protected static final double XP_PADRAO = 10.0D;
   private String titulo;
   private String descricao;
   private double nota;
   private int avaliacoes;

   public abstract double calcularXp();

   public void avaliar(int nota){

        this.nota = (this.nota*avaliacoes + nota)/++avaliacoes;

    }

   public String getTitulo() {
      return this.titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   public String getDescricao() {
      return this.descricao;
   }

   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }

    public double getNota() {
        return this.nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getAvaliacoes() {
        return this.avaliacoes;
    }

    public void setAvaliacoes(int avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

}
    