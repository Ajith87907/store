import React, { useEffect, useState } from "react";
import { history } from "../App";
import  './header.css'
import axios from "axios";
import { useDispatch, useSelector } from "react-redux";
import { setProducts } from "../redux/actions/productsActions";
import moment from "moment";
const Header = () => {
  const [time,setTime] = useState([]);
  const dispatch = useDispatch();
  
  const handleClick=()=>{
    return new Promise((resolve, reject) => {
      axios.get(`http://localhost:9000/api/v1/products`)
        .then((resp) => {
          if (resp) {
            resolve(resp.data);
            dispatch(setProducts(resp.data));
            history.push("/");
          }
        })
        .catch((err) => {
          reject(err);
        });
    });
  }
  (function(){
    setInterval(()=>{
      setTime(moment(new Date()).format('DD-MMM-YYYY hh:mm:ss a'));
    },1000);
  })
  ();
  
  return (
    <div className="ui fixed menu">
      <div className="ui container center"> 
        <h2 onClick={handleClick}>ChotaStore</h2>
          <p>{time}</p>
          <i class="dolly icon"></i>
      </div>
    </div>
  );
};

export default Header;
