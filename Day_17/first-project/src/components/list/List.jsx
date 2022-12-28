import React, { useState } from "react";

function List() {
  const [items, setItems] = useState(["Item1", "Item2", "Item3"]);
  const [title, setTitle] = useState("");
  const [isShow, setIsShow] = useState(true);
  const handleAdd = () => {
    if (title === "") {
      alert("Tiêu đề không được để trống");
      return;
    }
    setItems([...items, title]);
    setTitle("");
  };

  const handleRemove = () => {
    if (items.length === 0) return;
    const newItems = items.slice(0, items.length - 1);
    setItems(newItems);
  };

  const handleToggle = () => {
    setIsShow(!isShow);
  };
  return (
    <>
      <button onClick={handleToggle}>{isShow ? "Hide" : "Show"}</button>

      <input
        type="text"
        placeholder="Enter name"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
      />
      <button onClick={handleAdd}>Add</button>

      <button onClick={handleRemove}>Remove</button>
      {isShow && (
        <ul>
          {items.map((item, index) => (
            <li key={index}>{item}</li>
          ))}
        </ul>
      )}
    </>
  );
}

export default List;
