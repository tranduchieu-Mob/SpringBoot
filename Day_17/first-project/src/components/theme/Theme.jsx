import React, { useState } from 'react'

function Theme() {
    // Danh sách theme
    const themes = [
        {
            colorHeading: "#2C3639", // light theme
            colorText: "#3F4E4F",
            bg: "#F9F5EB",
        },
        {
            colorHeading: "#EAE3D2", // dark theme
            colorText: "#F9F5EB",
            bg: "#100720",
        },
    ];
    let change = {};
    const [theme, setTheme] = useState("Light Theme");
    if (theme === "Light Theme") {
        change = themes[0];
    } else {
        change = themes[1];
    }
    return (
        <div style={{ backgroundColor: change.bg }}>
            <select value={theme} onChange={e => setTheme(e.target.value)}>
                <option value={"Light Theme"}>Light Theme</option>
                <option value={"Dark Theme"}>Dark Theme</option>
            </select>

            <h2 style={{ color: change.colorHeading }}>
                Lorem ipsum dolor sit, amet consectetur adipisicing elit.
            </h2>
            <p style={{ color: change.colorText }}>
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis
                placeat necessitatibus, vitae laboriosam in quos, nesciunt modi
                error sit porro, reprehenderit voluptatem dolore libero
                incidunt. Illo mollitia fugit quam inventore?
            </p>
        </div>
    )

}

export default Theme