const btnRandomColorName = document.getElementById("btn-random-color-name");
const colorEl = document.getElementById("color");
btnRandomColorName.addEventListener("click", async function(){
    try {
        let res = await axios.get("http://localhost:8080/random-color?type=1")
        console.log(res);

        document.body.style.backgroundColor = res.data;
        colorEl.innerHTML = res.data;
    } catch (error) {
        console.log(error);
    }
})