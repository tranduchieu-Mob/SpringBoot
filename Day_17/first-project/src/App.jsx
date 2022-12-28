import React from 'react';
import './App.css';
import Content from './components/content/Content';
import Counter from './components/counter/Counter';
import List from './components/list/List';
import Menu from './components/menu/Menu';
import Theme from './components/theme/Theme';
import User from './components/user/User';

function App() {
  const myStyle = {
    color: "red",
    backgroundColor: "black"
  }

  const menus = [
    { path: "/", label: "Trang chủ" },
    { path: "/shop", label: "Cửa hàng" },
    { path: "/about", label: "Về chúng tôi" },
    { path: "/contact", label: "Liên hệ" },
  ];

  return (
    <>
      <h1 className="heading" style={myStyle}>Hello world {1 + 1}</h1>

      <div className="intro-content">
        <h1 className="intro-title">Fashion Trends</h1>
        <p className="intro-description">There are some trends that are just too plain wacky to really affect your wardrobe,
          so for that reason we've left out a few ideas we know you'd rather sidestep.</p>
        <a href="#" className="intro-btn">Buy now</a>
      </div>

      <Menu menus={menus} name={"Nguyễn Văn A"}/>

      <Counter />
      <hr />
      <Content />
      <hr />
      <List />
      <hr />
      <Theme />
      <hr />
      <User />

    </>

  );
}

export default App;