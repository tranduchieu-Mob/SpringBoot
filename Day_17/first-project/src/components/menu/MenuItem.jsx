import React from "react";

function MenuItem({ menu }) {
    return (
        <a href={menu.path} className="menu-item">
            {menu.label}
        </a>
    );
}

export default MenuItem;