import React, { useEffect, useRef, useState } from 'react'
import video from "./tải xuống.mp4";

const colors = ["red", "blue", "green", "yellow", "pink"];
function Blog() {

    const [color, setColor] = useState("red");

    const videoRef = useRef();
    const inputRef = useRef();
    console.log(inputRef);

    useEffect(() => {
        console.log(inputRef);
        inputRef.current.focus();
    },[]);

    const play = () =>{
        videoRef.current.play();

    };
    const pause = () => {
        videoRef.current.pause();
    };

    //Random 1 color trong mảng màu bên trên
    //Mỗi lần random không được trùng với màu đang có trong state
    const randomColor = () => {
        return setColor[Math.floor(Math.random() * colors.length)];
    }
  return (
    <>
        <h1>useRef() Hook</h1>

        <input type="text" placeholder='Enter name ...' ref={inputRef} />

        <hr />

        <video src={video} style={{height: 500}} ref={videoRef}></video>
        <button onClick={play}>Play</button>
        <button onClick={pause}>Pause</button>

        <hr />

        <div 
            style={{
                height : 200, 
                width : 200, 
                border : "1px solid black", 
                backgroundColor: color, 
            }}
        ></div>

        <button onClick={randomColor}>Random background color</button>
    </>
  )
}

export default Blog