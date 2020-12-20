package com.informatorio.blog_info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import com.informatorio.blog_info.repository.ProductoRepository;
import com.informatorio.blog_info.entity.Producto;
@RestController
public class ProductoController {

	@Autowired
	private ProductoRepository productoRepository;
	
	@GetMapping("/producto")
	public List<Producto> getAllProductos() {return productoRepository.findAll();}
	
	@PostMapping("/producto")
	public Producto crearProducto(@RequestBody Producto producto) {return productoRepository.save(producto);}
	
}
