/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.model.paginavenda;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Alann Rodrigues
 */
public class PostagemVenda{
    
    private String titulo;
    private String descricao;
    private float valor;
    private boolean disponibilidade;
    private byte[] img;
    private Categoria categoria;
    
    public PostagemVenda(){
        
    }

    public PostagemVenda(String titulo, String descricao, float valor, boolean disponibilidade, byte[] img, Categoria categoria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.valor = valor;
        this.disponibilidade = disponibilidade;
        this.img = img;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.titulo);
        hash = 17 * hash + Objects.hashCode(this.descricao);
        hash = 17 * hash + Float.floatToIntBits(this.valor);
        hash = 17 * hash + (this.disponibilidade ? 1 : 0);
        hash = 17 * hash + Arrays.hashCode(this.img);
        hash = 17 * hash + Objects.hashCode(this.categoria);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PostagemVenda other = (PostagemVenda) obj;
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        if (this.disponibilidade != other.disponibilidade) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Arrays.equals(this.img, other.img)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PostagemVenda{" + "titulo=" + titulo + ", descricao=" + descricao + ", valor=" + valor + ", disponibilidade=" + disponibilidade + ", img=" + img + ", categoria=" + categoria + '}';
    }
    
}
