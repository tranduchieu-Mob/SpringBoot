import React, { useState } from "react";
import "./Counter.css";

//Vòng đời
//Mounting : quá trình component được gắn vào DOM (1 lần)
//Updating : quá trình component được render lại (re-render)(Nhiều lần)
//Unmounting : quá trình component được xóa khỏi DOM (1 lần)

function Counter() {
  const [count, setCount] = useState(0);

  const decrement = () => {
    setCount(count -1);
  };

  const increment = () => {
    setCount(count + 1);
  };

  return (
    <div className="main-container">
      {console.log("render")}
      <h1 className="title">Đếm số</h1>
      <h1 id="counter" style={{ color: "#333333" }}>
        {count}
      </h1>
      <div className="btn-container">
        <button className="btn counterBtn prevBtn" onClick={decrement}>Trừ</button>
        <button className="btn counterBtn nextBtn" onClick={increment}>Cộng</button>
      </div>
    </div>
  );
}

export default Counter;
