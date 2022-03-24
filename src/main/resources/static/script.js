//const url = "http://localhost:8080";
const url = "https://thursday-coffee.azurewebsites.net/";

function doAddBookmark(info) {
	let responseData;
	axios
		.post(url, info)
		.then((response) => {
			console.log("Status: ", response.status);
			responseData = response.data;
			console.log("Data: ", response.data);
		})
		.catch((error) => console.log(error));
}

// event handlers
document.getElementById("submit-new-button").addEventListener("click", () => {
	console.log("button clicked");
	const info = {
		name: document.getElementById("name-field").value,
		url: document.getElementById("url-field").value,
		description: document.getElementById("description-field").value,
	};
	console.log(info);
	doAddBookmark(info);
});

document.getElementById("submit-id-button").addEventListener("click", () => {
	const id = document.getElementById("id-number").value;
	console.log("get this id", id);
	let responseData;
	axios.get(url, id).then((response) => {
		console.log("Status: ", response.status);
		responseData = response.data;
		console.log("Data: ", response.data);
		document.getElementById("response").innerHTML = responseData;
	});
});
