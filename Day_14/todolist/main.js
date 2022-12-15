const API_URL = "http://localhost:8080/api/v1"

const todoListEl = document.getElementById("todolist");
let todos = [];
//Lấy danh sách todo và hiển thị
const getTodos = async () => {
    try {
        //Gọi API
        let res = await axios.get(`${API_URL}/todos`);
        console.log(res);
        todos = res.data; // Lưu lại dữ liệu trả về từ server

        //Hiển thị lên trên giao diện
        renderTodos(todos);
    } catch (error) {
        console.log(error);
    }

}

const renderTodo = arr => {
    todoListEl.innerHTML = "";
    if (arr.length === 0) {
        todoListEl.innerHTML = '<li>Không có công việc nào trong danh sách</li>'
        return;
    }

    let html = "";
    arr.forEach(t => {
        html += `
            <li>
                <input type="checkbox" ${t.status ? "checked" : ""}>
                <span class=${t.status ? "todo-active" : ""}>${t.title}</span>
                <button onclick="updateTodo(${t.id}">Update</button>
                <button onclick="deleteTodo(${t.id}">Delete</button>
            </li>
        `
    });

    todoListEl.innerHTML =html;
}

const createTodo = () => {
    let newTodoTitle = document.getElementById('input').value;
    let response = axios.post(`${API_URL}/todos`, {
        "title" : newTodoTitle,
        "status" : false
    });
    response
        .then((res) => {
            console.log(res);
            alert("Todo created successfully");
            getTodos();
        })
        .catch((error) => {
            console.log(error);
        })
}

const updateTitle = (id) => {
    console.log("id to update: " + id);
    let newTitle = document.getElementById('input').value;
    let currentStatus = document.getElementById(`checkbox-${id}`).parentNode.querySelector("span").classList.contains("todo-done");
    let response = axios.put(`${API_URL}/todos/${id}`, {
        "title" : newTitle,
        "status" : currentStatus
    });
    response
        .then((res) => {
            console.log(res);
            alert("Todo updated successfully");
            getTodos();
        })
        .catch((error) => {
            console.log(error);
        })
}

const updateStatus = (id) => {
    console.log("id to update: " + id);
    let newStatus = document.getElementById(`checkbox-${id}`).checked;
    let currentTitle = document.getElementById(`checkbox-${id}`).parentNode.querySelector("span").innerHTML;
    let response = axios.put(`${API_URL}/todos/${id}`, {
        "title" : currentTitle,
        "status" : newStatus
    });
    response
        .then((res) => {
            console.log(res);
            alert("Todo updated successfully");
            getTodos();
        })
        .catch((error) => {
            console.log(error);
        })
}

const deleteTodo = (id) => {
    console.log("id to delete: " + id);
    let response = axios.delete(`${API_URL}/todos/${id}`);
    response
        .then((res) => {
            console.log(res);
            alert("Todo deleted successfully");
            getTodos();
        })
        .catch((error) => {
            console.log(error);
        })
}

//Vừa vào trang sẽ gọi
getTodos();