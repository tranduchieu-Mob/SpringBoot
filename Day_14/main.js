const btnRandomColorName = document.getElementById("btn-random-color-name");
const colorEl = document.getElementById("color");
btnRandomColorName.addEventListener("click", async function(){
    try {
        //Gọi API
        let res = await axios.get("http://localhost:8080/random-color?type=1")
        console.log(res);
        //Thay đổi màu và hiển thị
        document.body.style.backgroundColor = res.data;
        colorEl.innerHTML = res.data;
    } catch (error) {
        console.log(error);
    }
})

//Lắng nghe trên toàn bộ các nút
const btns = document.querySelectorAll("button");