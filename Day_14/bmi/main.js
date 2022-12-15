const bmi = document.getElementById("bmi");
const getBTN = document.getElementById("GET");
const postBTN = document.getElementById("POST");
const height = document.getElementById("height");
const weight = document.getElementById("weight");
postBTN.addEventListener("click", async () => {
    try {
        let res = await axios.post("http://localhost:8080/bmi", {
            height: height.value,
            weight: weight.value
        });
        bmi.innerHTML = res.data;
        console.log(res)
    } catch (error) {
        console.log(error);
    }
})

getBTN.addEventListener("click", async () => {
    try {
        let res = await axios.get(`http://localhost:8080/bmi?height=${height.value}&weight=${weight.value}`);
        bmi.innerHTML = res.data;
    } catch (error) {
        console.log(error);
    }
});