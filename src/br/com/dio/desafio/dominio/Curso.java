package br.com.dio.desafio.dominio;

public class Curso extends Conteudo {
   private int cargaHoraria;
   

    public Curso(String titulo, String descricao, int cargaHoraria) {
        
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        this.setCargaHoraria(cargaHoraria);
        this.setNota(0.0);
        this.setAvaliacoes(0);
        
    }

    public double calcularXp() {
      return 10.0D * (double)this.cargaHoraria;
    }

    public int getCargaHoraria() {
      return this.cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
      this.cargaHoraria = cargaHoraria;
    }

    public String toString() {

      return    "Curso{" + 
                "titulo='" + this.getTitulo() + 
                "', descricao='" + this.getDescricao() + 
                "', cargaHoraria=" + this.cargaHoraria + "}";
    }
}