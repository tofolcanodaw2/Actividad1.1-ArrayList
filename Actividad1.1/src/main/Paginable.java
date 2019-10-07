package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Paginable <E extends Producto> {

	/*
	 * add					V
	 * remove				V
	 * contains		
	 * getPage(int index)	V
	 * int getTotalPages()
	 * size*/
	
	private ArrayList<Producto<?>> productos = new ArrayList<Producto<?>>();
	private int prodPorPag = 3;
	private int numDePags = 0;
	
	Paginable(Producto<?>[] prod){
		this.productos = new ArrayList<Producto<?>>(Arrays.asList(prod));
		numDePags = (int) Math.ceil(productos.size()/prodPorPag);
	}
		
	/***
	 * Solo añade productos en el array
	 * @param p Producto
	 */
	public void add(Producto<?> p){
		productos.add(p);
		numDePags = (int) Math.ceil(productos.size()/prodPorPag);
	}
	
	/***
	 * Elimina el producto del array
	 * @param p Producto
	 */
	public void remove(Producto<?> p) {
		if(contains(p)) {
			productos.remove(p);
		}
		
		numDePags = (int) Math.ceil(productos.size()/prodPorPag);
	}
	
	/***
	 * Busca si el producto está en el array
	 * @param p Producto
	 * @return True si p está en el array
	 */
	public boolean contains(Producto<?> producto) {
		boolean resul = false;
		for (Producto<?> p : productos) {
			if(resul) {
				break;
			} else {
				resul = producto.equals(p);
			}
			
		}
		return resul;
	}
	
	/***
	 * Calcula que productos hay en la página pasada por parámetro y los devuelve como un array
	 * @param n Número de página
	 * @return Devuelve array de productos
	 */
	public Producto<?>[] getPage(int n) {
		int tamPag = prodPorPag;
		int primProd = n * prodPorPag;
		int ultProd = primProd+prodPorPag;
		if(ultProd>productos.size()) {
			ultProd = productos.size();
			tamPag = ultProd-primProd;
		}
		Producto<?>[] resul = new Producto<?>[tamPag];
		List pag = productos.subList(primProd, ultProd);
				
		for (int i = 0; i < pag.size(); i++) {
			resul[i] = (Producto<?>) pag.get(i);
		}
//		
//		resul = (Producto<?>[]) pag.toArray();
		
		return resul;
	}
	
}