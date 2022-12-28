import React, { useEffect, useState } from "react";
import axios from "axios";
const API_URL = "http://localhost:8080/api/v1/todos";
function TodoList() {
  const [todos, setTodos] = useState([]);
  const [title, setTitle] = useState("");
  useEffect(() => {
    const fetchTodos = async () => {
      try {
        let res = await axios.get(API_URL);
        setTodos(res.data);
      } catch (error) {
        console.log(error);
      }
    };

    fetchTodos();
  }, []);

  const handleAdd = () => {

  };
  const handleToggleStatus = (id) => {
    
  };
  const handleUpdateTitle = (id) => {

  };
  const handleDelete = (id) => {

  };

  return (
    <>
      <h2>TodoList</h2>

      <input 
        type="text" 
        placeholder="Enter title ..." 
        onClick={(e) => setTitle(e.target.value)} />
      <button onClick={handleAdd}>ADD</button>

      <ul>
        {todos.length === 0 && <li>Không có công việc nào trong danh sách</li>}
        {todos.length > 0 &&
          todos.map((todo) => (
            <li key={todo.id}>
              <input 
                type="checkbox" 
                checked={todo.status} 
                onChange={() => handleToggleStatus(todo.id)}
              />
              <span className={todo.status ? "active" : ""}>
                {todo.title}
              </span>
              <button onClick={() => handleUpdateTitle(todo.id)}>update</button>
              <button onClick={() => handleDelete(todo.id)}>delete</button>
            </li>
          ))}

        {/* <li>
                <input type="checkbox" checked />
                <span className='active'>Đi chơi</span>
                <button>update</button>
                <button>delete</button>
            </li> */}
      </ul>
    </>
  );
}

export default TodoList;
