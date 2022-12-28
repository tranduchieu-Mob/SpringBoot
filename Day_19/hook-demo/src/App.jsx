import React, { useState } from 'react'
// import Blog from './components/blog/Blog';
// import Menu from './components/menu/Menu';
import './index.css'
import TodoList from './todoList/TodoList';



function App() {

  // const [isShow, setIsShow] = useState(true);

  // const toggle = () => {
  //   setIsShow(!isShow);
  // }
  return (
     <>
    {/* // <Blog /> */}
    {/* {isShow && <Menu />} */}
    {/* <button onClick={toggle}>toggle</button> */}
    <TodoList />
    </>


  )
}

export default App