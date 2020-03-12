package com.ecommerce.product.xyz.controller;

import com.ecommerce.product.xyz.Utils.ResponseUtils;
import com.ecommerce.product.xyz.model.ProductDTO;
import com.ecommerce.product.xyz.model.SearchCriteria;
import com.ecommerce.product.xyz.repository.model.Product;
import com.ecommerce.product.xyz.service.SearchService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SearchController {

    @Autowired
    public SearchService searchService;


    /**Search products based on search criteria
     *
     * @param color
     * @param size
     * @param brand
     * @param price
     * @return
     */
    @ApiOperation(value = " Search Products " , notes = " This API will get the product details based on the given search criteria ")
    @RequestMapping(value="/products",method = RequestMethod.GET)
    public ResponseEntity<Object> getProductList(@RequestParam(required=false) String color ,@RequestParam(required=false) String size,
                                                 @RequestParam(required=false) String brand , @RequestParam(required=false,defaultValue = "0") int price)
    {
        SearchCriteria searchCriteria = new SearchCriteria(brand,color,size,price);
        List<Product> productList = searchService.getSearchProducts(searchCriteria);
        return ResponseUtils.createObjectResponse(productList,HttpStatus.OK);
    }




    /**Controller to get the product details based on sku number
     *
     * @param sku
     *
     * @return
     */
    @ApiOperation(value = " GET BY SKU " , notes = " This API will get products for the SKU value provided ")
    @RequestMapping(value="/stockkeepingunits/{sku}/products",method = RequestMethod.GET)
    public ResponseEntity<Object> getProductBySKU(@PathVariable String sku)
    {
            return ResponseUtils.createObjectResponse(searchService.getProductBySku(sku),HttpStatus.OK);
    }

    /**
     *
     * @param supplierId
     * @param
     * @return
     */
    @ApiOperation(value = " Count of Products for Supplier ID's " , notes = " This API will get count of products for the Supplier ")
    @RequestMapping(value="/suppliers/{supplierId}/products",method = RequestMethod.GET)
    public ResponseEntity<Object> getSupplierProducts(@PathVariable int supplierId)
    {
        return ResponseUtils.createObjectResponse(searchService.getCountOfSupplierProducts(supplierId),HttpStatus.OK);
    }


    /**Provision to add a new product to the database
     *
     * @param products
     *
     */
    @ApiOperation(value = " Add Product " , notes = " This API will add products ")
    @RequestMapping(value="/products",method = RequestMethod.POST)
    public void getProductBySKU(@RequestBody List<Product> products)
    {
        searchService.addProduct(products);

    }


}
