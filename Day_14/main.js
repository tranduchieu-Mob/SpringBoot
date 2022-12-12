const btnRandomColorName = document.getElementById("btn-random-color-name");
btnRandomColorName.addEventListener("click", async function(){
    try {
        let res = await axios.get("http://localhost:8080/random-color?type=1")
        console.log(res);
    } catch (error) {
        console.log(error);
    }
})