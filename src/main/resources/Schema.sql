
CREATE SCHEMA product_catalogue;

  CREATE TABLE product_catalogue.supplier(
      supplier_id INT AUTO_INCREMENT PRIMARY key ,
      supplier_name VARCHAR (50) NOT NULL
  );



   CREATE TABLE product_catalogue.product_type(
      product_type_id INT AUTO_INCREMENT PRIMARY key ,
      product_type_name VARCHAR (50) NOT NULL
  );

     CREATE TABLE product_catalogue.brand(
      brand_id INT AUTO_INCREMENT PRIMARY key ,
      brand_name VARCHAR (50) NOT NULL
  );

CREATE TABLE product_catalogue.product(
      product_id INT AUTO_INCREMENT PRIMARY key ,
      sku VARCHAR(50) NOT NULL,
      product_name VARCHAR (50) NOT NULL,
      colour VARCHAR (20) NOT NULL,
      size VARCHAR (20) NOT NULL,
      brand INT NOT NULL ,
      product_value INT NOT NULL ,
      supplier_value INT NOT NULL,
      FOREIGN KEY (brand) REFERENCES product_catalogue.brand(brand_id),
      FOREIGN KEY (product_value) REFERENCES product_catalogue.product_type(product_type_id),
      FOREIGN KEY (supplier_value) REFERENCES product_catalogue.supplier(supplier_id),
      CONSTRAINT UC_product UNIQUE (sku)
  );

