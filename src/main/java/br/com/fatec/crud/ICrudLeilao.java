package br.com.fatec.crud;

public interface ICrudLeilao<T> {
	public boolean cadastrar(T obj);
	public boolean remover(T obj);
	public boolean atualizar(T obj,int obj1);
	public T consultar(T obj);
}