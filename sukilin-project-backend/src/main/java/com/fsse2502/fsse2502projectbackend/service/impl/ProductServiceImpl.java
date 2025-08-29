package com.fsse2502.fsse2502projectbackend.service.impl;

import com.fsse2502.fsse2502projectbackend.data.product.domainObject.response.ProductResponseData;
import com.fsse2502.fsse2502projectbackend.data.product.entity.ProductEntity;
import com.fsse2502.fsse2502projectbackend.repository.ProductRepository;
import com.fsse2502.fsse2502projectbackend.service.ProductService;
import com.fsse2502.fsse2502projectbackend.exception.product.ProductNotExist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductResponseData> getAllProduct() {
        List<ProductResponseData> productResponseDataList = new ArrayList<>();

        for(ProductEntity productEntity : productRepository.findAll() ) {
            productResponseDataList.add(
                    new ProductResponseData(productEntity)
            );
        }
        return productResponseDataList;
    }

    @Override
    public ProductResponseData getByPid(Integer pid) {
        return null;
    }

//    @Override
//    public ProductResponseData getByPid(Integer pid){
//        try {
//            return new ProductResponseData(getEntityByPid(pid));
//        } catch (Exception ex){
//            log.warn("Product getByPid failed: {}" ex.getMessage());
//            throw ex;
//        }
//    }

    public ProductResponseData getProductById(Integer id){
        if(productRepository.findById(id).isPresent()) {
            return new ProductResponseData(
                    productRepository.findById(id).get());
        }
        throw new ProductNotExist("Product Not Exist");
    }

//    public ProductResponseData getProductEntityByPid(Integer pid){
//        try {
//            return new ProductResponseData(getEntityByPid(pid));
//        } catch (Exception ex) {
//            log.warn("Product getByPid failed:{}" ex.getMessage());
//            throw ex;
//        }
//    }

//    @Override
//    public ProductEntity getEntityByPid(Integer pid){
//        return productRepository.findById(pid)
//                .orElseThrow(()-> new ProviderNotFoundException("Product not found with ID: " + pid));
//    }

    @Override
    public ProductEntity getProductEntityById(Integer pid){
        if (productRepository.findById(pid).isPresent()) {
            return productRepository.findById(pid).get();
        }
        throw new ProductNotExist("Product Not Exist");
    }

    @Override
    public ProductEntity getEntityByPid(Integer pid) {
        return null;
    }

    @Override
    public boolean deductStock(Integer pid, Integer quantity){
        ProductEntity productEntity = productRepository.findById(pid).orElseThrow(() -> new RuntimeException());

        if (productEntity.getStock() < quantity){
            throw new RuntimeException();
        }

        productEntity.setStock(productEntity.getStock() - quantity);
        productRepository.save(productEntity);
        return true;
    }
}
