package com.example.Practica.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.Practica.persistence.entity.CategoryEntity;
import com.example.Practica.persistence.entity.ImageEntity;
import com.example.Practica.persistence.entity.MarcaEntity;
import com.example.Practica.persistence.entity.ProductEntity;
import com.example.Practica.persistence.repository.CategoryRepository;
import com.example.Practica.persistence.repository.ImageRepository;
import com.example.Practica.persistence.repository.MarcaRepository;
import com.example.Practica.persistence.repository.ProductRepository;
import com.example.Practica.presentation.controller.dto.CategoryDTO;
import com.example.Practica.presentation.controller.dto.ImageDTO;
import com.example.Practica.presentation.controller.dto.MarcaDTO;
import com.example.Practica.presentation.controller.dto.ProductDTO;
import com.example.Practica.utils.mappers.CategoryMapper;
import com.example.Practica.utils.mappers.ImageMapper;
import com.example.Practica.utils.mappers.MarcaMapper;
import com.example.Practica.utils.mappers.ProductMapper;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final MarcaRepository marcaRepository;
    private final CategoryRepository categoryRepository;
    private final ImageRepository imageRepository;

    public ProductService(ProductRepository productRepository, MarcaRepository marcaRepository,
        CategoryRepository categoryRepository, ImageRepository imageRepository) {
        this.productRepository = productRepository;
        this.marcaRepository = marcaRepository;
        this.categoryRepository = categoryRepository;
        this.imageRepository = imageRepository;
    }

    // Método de paginación con las relaciones cargadas
    public Page<ProductDTO> findAllProducts(Pageable pageable) {
        // Obtener los productos con las relaciones de categoria y marca
        Page<ProductEntity> products = productRepository.findAllWithCategoryAndBrand(pageable);

        // Mapear las entidades a DTOs con las relaciones de categoria y marca
        return products.map(product -> {
            // Mapear el producto a DTO
            ProductDTO productDTO = ProductMapper.INSTANCE.fromEntity(product);

            // Mapear las relaciones de categoria y marca
            CategoryDTO categoryDTO = CategoryMapper.INSTANCE.fromEntity(product.getCategoria());
            MarcaDTO marcaDTO = MarcaMapper.INSTANCE.fromEntity(product.getMarca());

            ImageDTO imageDTO = ImageMapper.INSTANCE.fromEntity(product.getImage());

            // Devolver el ProductDTO con las relaciones mapeadas
            return new ProductDTO(
                    productDTO.id(),
                    productDTO.nombre(),
                    productDTO.descripcion(),
                    productDTO.precio(),
                    productDTO.created_at(),
                    productDTO.updated_at(),
                    categoryDTO, // Asignar categoria
                    marcaDTO, // Asignar marca
                    imageDTO);
        });
    }

    // GET BY ID
    public ProductDTO findByIdProduct(ProductDTO productDTO) {
        ProductEntity product = productRepository.findById(productDTO.id())
                .orElseThrow(
                        () -> new IllegalArgumentException("El producto con id " + productDTO.id() + " no existe"));
        return ProductMapper.INSTANCE.fromEntity(product);
    }

    // GET BY NAME
    public ProductDTO findByNameProduct(ProductDTO productDTO) {
        ProductEntity product = productRepository.findByNombre(productDTO.nombre())
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "El producto con nombre " + productDTO.nombre() + " no existe"));
        return ProductMapper.INSTANCE.fromEntity(product);
    }

    // METODO CREATE
    @Transactional
    public ProductDTO createProduct(ProductDTO productDTO) {

        // VERFICIAR QUE NO EXISTA DICHO PRODUCTO
        if (productRepository.existsByNombre(productDTO.nombre())) {
            throw new IllegalArgumentException("El producto con nombre " + productDTO.nombre() + " ya existe");
        }

        // Buscar la marca y la categoría en la base de datos por su ID
        MarcaEntity marca = marcaRepository.findById(productDTO.marca().id())
                .orElseThrow(() -> new IllegalArgumentException(
                        "La marca con ID " + productDTO.marca().id() + " no existe"));

        CategoryEntity categoria = categoryRepository.findById(productDTO.categoria().id())
                .orElseThrow(() -> new IllegalArgumentException(
                        "La categoría con ID " + productDTO.categoria().id() + " no existe"));

        // Buscar la imagen en la base de datos por su ID
        ImageEntity image = imageRepository.findById(productDTO.image().id())
                .orElseThrow(() -> new IllegalArgumentException(
                        "La imagen con ID " + productDTO.image().id() + " no existe"));

        // VALIDAR CON REGEX
        if (productDTO.nombre() == null || !productDTO.nombre().matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("El nombre del producto no es valido");
        }

        if (productDTO.descripcion() == null || !productDTO.descripcion().matches("[a-zA-Z0-9 ]+")) {
            throw new IllegalArgumentException("La descripcion del producto no es valida");
        }

        // Crear la entidad de producto a partir del DTO
        ProductEntity product = ProductMapper.INSTANCE.fromDTO(productDTO);

        // Asignar la marca y la categoría al producto
        product.setMarca(marca);
        product.setCategoria(categoria);
        product.setImage(image);

        // Guardar el producto en la base de datos
        ProductEntity productSaved = productRepository.save(product);

        // Mapear y devolver el DTO con el producto guardado
        return ProductMapper.INSTANCE.fromEntity(productSaved);
    }

    // METODO ACTULIZAR
    @Transactional
    public ProductDTO updateProduct(ProductDTO productDTO) {

        // VALIDAR CON REGEX
        if (productDTO.nombre() == null || !productDTO.nombre().matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("El nombre del producto no es valido");
        }

        if (productDTO.descripcion() == null || !productDTO.descripcion().matches("[a-zA-Z0-9 ]+")) {
            throw new IllegalArgumentException("La descripcion del producto no es valida");
        }


        productRepository.findById(productDTO.id())
                .orElseThrow(
                        () -> new IllegalArgumentException("El producto con id " + productDTO.id() + " no existe"));

        ProductEntity updatedProduct = productRepository.save(ProductMapper.INSTANCE.fromDTO(productDTO));
        return ProductMapper.INSTANCE.fromEntity(updatedProduct);
    }

    // METODO DELETE
    public void deleteProduct(Long product_id) {
        if (!productRepository.existsById(product_id)) {
            throw new IllegalArgumentException("El producto con id " + product_id + " no existe");
        }
        productRepository.deleteById(product_id);
    }
}