const btnRandomColorName = document.getElementById("btn-random-color-name");
const colorEl = document.getElementById("color");
btnRandomColorName.addEventListener("click", async function () {
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

// btns.forEach((btn, index) => {
//     btn.addEventListener("click", async () => {
//         try {
//             //Gọi API
//             let res = await axios.get(`http://localhost:8080/random-color?type=${index + 1}`)
//             console.log(res);

//             //Thay đổi màu và hiển thị
//             document.body.style.backgroundColor = res.data;
//             colorEl.innerHTML = res.data;
//         } catch (error) {
//             console.log(error);
//         }
//     })
// })

//Nếu không phải 1,2,3 mà là type bất kỳ, ví dụ : 2 5 6, 5 8 9 thì làm như thế nào?
//Gợi ý : gắn giá trị type vào từng button
btns.forEach(btn => {
    btn.addEventListener("click", async () => {
        try {
            let type = btn.dataset.type;
            //Gọi API
            let res = await axios.get(`http://localhost:8080/random-color?type=${type}`)
            console.log(res);

            //Thay đổi màu và hiển thị
            document.body.style.backgroundColor = res.data;
            colorEl.innerHTML = res.data;
        } catch (error) {
            console.log(error);
        }
    })
})