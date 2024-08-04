package com.first.api.repository;

import com.first.api.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductoRepository {

    private List<Producto> productos = new ArrayList<>();


    public void createProductos() {
		// TODO Auto-generated method stub
	
    	productos = List.of(
    	new Producto(1,"producto 1",10,100),
		new Producto(2,"producto 2",11,200),
		new Producto(3,"producto 3",12,300),
		new Producto(4,"producto 4",13,400),
		new Producto(5,"producto 5",14,500),
		new Producto(6,"producto 6",15,600),
		new Producto(7,"producto 7",16,700),
		new Producto(8,"producto 8",17,800),
		new Producto(9,"producto 9",18,900),
		new Producto(10,"producto 10",19,1000)
		
		);
		
		
		
	}
    
    public ProductoRepository() {
    	createProductos();
    	
    }
    
	//Listar todos los productos
    public List<Producto> getAllProductos(){
        return productos;
    }

    //Buscar un producto
    public Producto findById(int id){
        for(int i = 0;i < productos.size();i++){
            if(productos.get(i).getId() == id){
                return productos.get(i);
            }
        }
        return null;
    }

    //Se encarga de buscar un producto
    public List<Producto> search(String nombre){
        return productos.stream()
                .filter(x -> x.getNombre().startsWith(nombre))
                .collect(Collectors.toList());
    }

    //Guardamos un produto
    public Producto save(Producto p){
        Producto producto = new Producto();
        producto.setId(p.getId());
        producto.setNombre(p.getNombre());
        producto.setCantidad(p.getCantidad());
        producto.setPrecio(p.getPrecio());

        productos.add(producto);
        return producto;
    }

    //Eliminamos un producto
    public String delete(Integer id){
        productos.removeIf(x -> x.getId() == id);
        return null;
    }

    public Producto update(Producto producto){
        int idPos = 0;
        int id = 0;

        //comprobamos si existe el producto y obtenemos la posicion y ID del producto
        for(int i = 0;i < productos.size();i++){
            if(productos.get(i).getId() == (producto.getId())){
                id = producto.getId(); //ID del producto
                idPos = i; //posicion
                break;
            }
        }

        Producto producto1 = new Producto();
        producto1.setId(id);
        producto1.setNombre(producto.getNombre());
        producto1.setCantidad(producto.getCantidad());
        producto1.setPrecio(producto.getPrecio());
        productos.set(idPos,producto);
        return producto1;
    }
    

}
