import React, { useState } from 'react'
import { faker } from '@faker-js/faker';

const orders = [{ id: 1, total: 100000},
                { id: 2, total: 200000},
                { id: 3, total: 300000},
];

function Content() {
    //Tính toán phức tạp và cần thời gian để thực hiện
    // const totalMoney = orders.reduce((a, b) => {
    //     console.log("Tính toán");
    //     return (a + b.total), 0;
    // });
    const [total, setTotal] = useState(() => orders.reduce((a, b) => a + b.total,0));

    const [count, setCount] = useState(0);
    const [products, setProducts] = useState([
        { id: 1, name: "Sản phẩm 1", price: 100000},
        { id: 2, name: "Sản phẩm 2", price: 200000},
        { id: 3, name: "Sản phẩm 3", price: 300000},
    ]);
    const [user, setUser] = useState({
        id: 1,
        name: "Đức Hiếu",
        email: "hieu@gmail.com",
    });

    const increment = () => {
        setCount(count + 1);//Bất đồng bộ
        console.log(count);
    }

    const decrement = () => {
        setCount(count => count - 1);
        setCount(count => count - 1);
        setCount(count => count - 1);
    }

    const updatePrice = () => {
        const productId = 1;
        const newPrice = Math.floor(Math.random() * (500000 - 100000 +1)) + 100000;

        const newProducts = products.map(p => {
            if(p.id === productId){
                return {...p, price: newPrice};
            }
            return p;
        });

        setProducts(newProducts);
    }

    const updateName = () =>{
        const rdName = faker.name.fullName();
        setUser({...user, name: rdName});
    }
  return (
    <>
        {console.log("render")}
        <h2>Total: {total}</h2>

        <hr />
        
        <h1>Count : {count}</h1>
        <button onClick={increment}>Increment</button>
        <button onClick={decrement}>Decrement</button>

        <hr />

        <h2>Danh sách sản phẩm</h2>
        <ul>
            {products.map(p => (
                <li key={p.id}>
                    {p.id} - {p.name} - {p.price}
                </li>
            ))}
        </ul>

        <button onClick={updatePrice}>Update price</button>

        <hr />

        <h2>Thông tin user</h2>
        <p>Id : {user.id}</p>
        <p>Name : {user.name}</p>
        <p>Email : {user.email}</p>

        <button onClick={updateName}>Update name</button>
    </>
  )
}

export default Content