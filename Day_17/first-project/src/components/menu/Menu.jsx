import React from "react";
import MenuItem from "./MenuItem";

// Destructuring Assignment - ES6
function Menu({ menus, name }) {
  // console.log(props);

  // const menus = props.menus;
  // const name = props.name;
  // const { menus, name } = props;
  return (
    <>
      <h2>Name : {name}</h2>
      <div className="menu-list">
        {menus.map((menu) => (
          <MenuItem key={menu.path} menu={menu} />
        ))}
      </div>
    </>
  );
}

export default Menu;
