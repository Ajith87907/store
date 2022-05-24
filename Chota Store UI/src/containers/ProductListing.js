import React, { useEffect, useCallback, useMemo } from "react";
import axios from "axios";
import { useDispatch, useSelector } from "react-redux";
import { setProducts } from "../redux/actions/productsActions";
import ProductComponent from "./ProductComponent";

const ProductPage = () => {
  const products = useSelector((state) => state.allProducts.products);
  const dispatch = useDispatch();
  
   const fetchProducts = () => {
    return new Promise((resolve, reject) => {
      axios.get(`http://localhost:4000/api/v1/app/products`)
        .then((resp) => {
          if (resp) {
            resolve(resp.data);
            let products = resp.data;
            products=products.sort((a,b)=>{
              return b.price-a.price;
            });
            dispatch(setProducts(products));
          }
        })
        .catch((err) => {
          reject(err);
        });
    });
  }

  useEffect(() => {
    fetchProducts();
  }, []);
  return (
    <div className="ui grid container">
      <ProductComponent />
    </div>
  );
};

export default ProductPage;
