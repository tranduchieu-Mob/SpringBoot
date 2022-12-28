const API_URL = "http://localhost:8080/api/v1";
const params = new URLSearchParams(window.location.search);
const userId = params.get("id");
console.log(userId);

if(!userId){
    window.location.href = "./404.html"
}

//Quản lý ảnh
let images = [];

//Lấy danh sách images
const getImages = async () => {
    try {
        let res = await axios.get(`${API_URL}/users/${userId}/files`);
        console.log(res);

        images = res.data;
        renderPaginationAndRenderImages(images);
    } catch (error) {
        console.log(error);
    }
}

//truy cập
const imageContainerEL = document.querySelector(".image-container");
const btnChoseImage = document.getElementById("btn-chose-image");
const btnDeleteImage = document.getElementById("btn-delete-image");
const avatarPreviewEl = document.getElementById("avatar-preview");
const avatarEl = document.getElementById("avatar");
const modalImageEl = new bootstrap.Modal(document.getElementById('modal-image'), {
    keyboard: false
  })

//Hiển thị image trên UI

const renderImages = arr => {
    imageContainerEL.innerHTML = "";
    let html = "";
    arr.forEach(i => {
        html += `
        <div class="image-item" onclick = "choseImgae(this)">
            <img src="http://localhost:8080${i}" alt="Ảnh" data-url=${i}>
        </div>
        `
    });
    imageContainerEL.innerHTML = html;
    btnChoseImage.disabled = true;
    btnDeleteImage.disabled = true;
}

//Phân trang
const renderPaginationAndRenderImages = arr => {
    $('.pagination-container').pagination({
        dataSource: arr,
        pageSize : 8,
        callback: function(data, pagination) {
           console.log(data);
           console.log(pagination);

           renderImages(data);
        }
    })
}


//Chọn 1 hình ảnh
const choseImgae = (imageEl) => {
    //Xóa ảnh được active trước đó nếu có
    const imageActiveEl = document.querySelector(".image-active");
    if(imageActiveEl) {
        imageActiveEl.classList.remove("image-active");
    }
    //active được hình ảnh
    imageEl.classList.add("image-active");
    //active nút chức năng
    btnChoseImage.disabled = false;
    btnDeleteImage.disabled = false;
}

//Xóa ảnh
btnDeleteImage.addEventListener("click", async () =>{
    try {
        const imageActiveEl = document.querySelector(".image-active img");
        if(!imageActiveEl) return;

        const url = imageActiveEl.src;

        //Xóa trên server
        await axios.delete(url);
        
        //xóa trên client
        images = images.filter(i => !url.includes(i))
        //Render lại image
        renderPaginationAndRenderImages(images);
    } catch (error) {
        console.log(error)
    }
});
//Update ảnh
btnChoseImage.addEventListener("click", async () => {
    try {
        const imageActiveEl = document.querySelector(".image-active img");
        if (!imageActiveEl) return;

        // /api/v1/users/1/files/1671191936
        const url = imageActiveEl.dataset.url;
        console.log(url)

        // Gọi API
        await axios.put(`${API_URL}/users/${userId}/update-avatar`, { avatar: url })

        // Cập nhật avatar trên UI
        avatarPreviewEl.src = `http://localhost:8080${url}`;


        // Đóng modal
        modalImageEl.hide();
    } catch (error) {
        console.log(error);
    }
});

//Update ảnh
avatarEl.addEventListener("change", async(e) => {
    try {
        // lay ra file upload
        const file = e.target.files[0];
        console.log(file);

        // tao doi tuong form data 
        const formData = new FormData();
        formData.append("file", file);

        // goi API
        const res = await axios.post(`${API_URL}/users/${userId}/files`, formData);

        // cap nhat ui
        images.unshift(res.data);
        renderPaginationAndRenderImages(images);

    } catch (error) {
        
    }
})

getImages();