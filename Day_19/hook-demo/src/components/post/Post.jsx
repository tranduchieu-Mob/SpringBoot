import React, { useEffect, useState } from 'react'
import axios from 'axios';
/*
// useEffect(callback, dependences)

- TH1 : useEffect(callback) : Được gọi sau mỗi lần re-render
- TH2 : useEffect(callback, []) : Chỉ được gọi 1 lần duy nhất sau lần render đầu tiên
- TH3 : useEffect(callback, [deps]) : Được gọi khi deps thay đổi giá trị

Đặc điểm chung : đều chạy sau lần render đầu tiên

*/

function Post() {
    const [count, setCount] = useState(0);
    const [count1, setCount1] = useState(0);
    const [posts, setPosts] = useState([]);
    const [loading, setLoading] = useState(true);
    const [type, setType] = useState("posts");

    useEffect(() => {
        const getPosts = async () => {
            try {
                setLoading(true)
                let res = await axios.get(`https://jsonplaceholder.typicode.com/${type}`);
                console.log(res);

                setPosts(res.data);
                setTimeout(() => {
                    setLoading(false);
                }, 500);

                
            } catch (error) {
                console.log(error)
            }
        }

        getPosts();
    }, [type]);

    // TH1 : useEffect(callback)
    // useEffect(() => {
    //     console.log("useEffect(callback)")
    // })

    // //TH2 : useEffect(callback, [])
    // useEffect(() => {
    //     console.log("useEffect(callback, [])");
    // }, [])

    //TH3 : useEffect(callback, [deps])
     useEffect(() => {
        console.log("useEffect(callback, [deps])");
    }, [count]);

    const increment = () => {
        setCount(count + 1);
    }

    const decrement = () => {
        setCount(count - 1);
    }

    const increment1 = () => {
        setCount1(count1 + 1);
    }

    const decrement1 = () => {
        setCount1(count1 - 1);
    }

    if(loading) {
        return <h2>Loading ...</h2>
    }

  return (
    <>
        {console.log("render")}

        <h1>Count : {count}</h1>
        <button onClick={increment}>Increment</button>
        <button onClick={decrement}>Decrement</button>

        <h1>Count1 : {count1}</h1>
        <button onClick={increment1}>Increment1</button>
        <button onClick={decrement1}>Decrement1</button>

        <hr />

        <h2>Type : {type}</h2>

        {/*<button onClick={() => setType("posts")} 
        style = {type === "posts" ? {background : "red"} : {}}
        >
            Posts
        </button>
        <button onClick={() => setType("comments")} 
        style = {type === "comments" ? {background : "red"} : {}}
        >
            Comment
        </button>
        <button onClick={() => setType("albums")} 
        style = {type === "albums" ? {background : "red"} : {}}
        >
            albums
    </button>*/}
    {["posts", "comments", "albums"].map((ele, index) => (
        <button onClick={() => setType(ele)}
        key={index}
        style = {type === ele ? {background : "red"} : {}}
        >
            {ele}
        </button>
    ))}

        <ul>
            {posts.map(p =>(
                <li key={p.id}>{p.title || p.body}</li>
            ))}
        </ul>
    </>
  )
}

export default Post